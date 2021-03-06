package it.unibas.icar.freesbee.processors;

import it.unibas.icar.freesbee.contrib.SoapReaderFix;
import it.unibas.icar.freesbee.exception.FreesbeeException;
import it.unibas.icar.freesbee.utilita.CostantiBusta;
import it.unibas.icar.freesbee.utilita.CostantiSOAP;
import it.unibas.icar.freesbee.utilita.FreesbeeUtil;
import it.unibas.icar.freesbee.utilita.MessageUtil;
import it.unibas.icar.freesbee.xml.XmlUtil;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.xml.transform.OutputKeys;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.apache.cxf.helpers.XMLUtils;
import org.apache.servicemix.soap.marshalers.SoapMarshaler;
import org.apache.servicemix.soap.marshalers.SoapMessage;
import org.slf4j.LoggerFactory;

public class SOAPProcessorReader implements Processor {

//    private static Log logger = LogFactory.getLog(SOAPProcessorReader.class);
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SOAPProcessorReader.class.getName());
    private static SOAPProcessorReader singleton = new SOAPProcessorReader();

    private SOAPProcessorReader() {
    }

    public static SOAPProcessorReader getInstance() {
        return singleton;
    }

    public void process(Exchange exchange) throws Exception {
        //ContextStartup.aggiungiThread(this.getClass().getName());
        ProcessorLogFactory.getInstance().getProcessorLog(this.getClass()).process(exchange);
        if (MessageUtil.isEmpty(exchange.getIn())) {
            if (logger.isInfoEnabled()) logger.info("Ricevuto un messaggio vuoto. Probabilemente e' un ack di risposta.");
            MessageUtil.setString(exchange.getIn(), "");
            return;
        }
        String contentType = (String) exchange.getIn().getHeader("Content-Type");
        String charset = estraiCharset(contentType);
        if (logger.isDebugEnabled()) logger.debug("Il content type del messaggio vale: " + contentType);
        if (logger.isDebugEnabled()) logger.debug("Il charset estratto dal content type vale: |" + charset + "|");
        SoapMarshaler soapMarshaler = new SoapMarshaler(true);
//        soapMarshaler.setSoap(true);
//        soapMarshaler.setUseDom(true);
        soapMarshaler.setSoapUri(CostantiSOAP.SOAP_VERSION);
////        soapMarshaler.setUseDom(true);      
//        SoapReader soapReader = new SoapReader(soapMarshaler);
        SoapReaderFix soapReader = new SoapReaderFix(soapMarshaler);
        SoapMessage soapMessage;
        try {
            if (contentType != null && startsWithCaseInsensitive(contentType, SoapMarshaler.MULTIPART_CONTENT)) {
                //E' UN MESSAGGIO CON ATTACHMENT
                InputStream bodyStream = MessageUtil.getStream(exchange.getIn());
                String stringaIntestazioni = FreesbeeUtil.estraiIntestazioniHTTP(exchange.getIn());
                InputStream intestazioniStream = new ByteArrayInputStream(stringaIntestazioni.getBytes());
                InputStream messaggioStream = new SequenceInputStream(intestazioniStream, bodyStream);
                if (logger.isDebugEnabled()) logger.debug("E' stato ricevuto un messaggio soap con attachment.");
                Session session = Session.getDefaultInstance(new Properties());
                MimeMessage mime = new MimeMessage(session, messaggioStream);
                soapMessage = soapReader.read(mime);
                //AGGIUNGO GLI ATTACHMENT ALLA MAPPA DELLE INTESTAZIONI
                exchange.setProperty(CostantiSOAP.SOAP_ATTACHMENT, soapMessage.getAttachments());
            } else {
                if (logger.isDebugEnabled()) logger.debug("E' stato ricevuto un messaggio soap senza attachment.");
                InputStream bodyStream = MessageUtil.getStream(exchange.getIn());
                soapMessage = soapReader.read(bodyStream, charset);
            }
//            if (logger.isDebugEnabled()) logger.debug("soapMessage.getBodyName()" + soapMessage.getBodyName());
//            if (logger.isDebugEnabled()) logger.debug("soapMessage.hasAttachments()" + soapMessage.hasAttachments());
            MessageUtil.setSource(exchange.getIn(), soapMessage.getSource());
            exchange.setProperty(CostantiSOAP.SOAP_HEADERS, soapMessage.getHeaders());
            if (soapMessage.getFault() != null) {
                exchange.setProperty(CostantiSOAP.SOAP_FAULT, soapMessage.getFault());
            }
        } catch (Exception e) {
            logger.error("Errore nel parsing del messaggio SOAP.");
            if (logger.isDebugEnabled()) e.printStackTrace();
            exchange.setException(new FreesbeeException("Errore nel parsing del messaggio SOAP."));
            return;
        }

        if (logger.isDebugEnabled()) logger.debug("Il parsing del messaggio SOAP e' stato completato con successo. Il messaggio letto e': " + MessageUtil.getString(exchange.getIn()));
        
        exchange.setProperty(CostantiBusta.FIGLI_MULTIPLI, "false");
        InputStream messaggio = MessageUtil.getStream(exchange.getIn());
        verificaFigliMultipli(messaggio, exchange.getIn());
        messaggio.reset();
    }

    private void verificaFigliMultipli(InputStream messaggio, Message messaggioIn) {
        try {
            Document docMessaggio = XMLUtils.parse(messaggio);
            Element envElem = docMessaggio.getDocumentElement();
            if (envElem != null && envElem.getLocalName().compareToIgnoreCase("envelope") == 0) {
                NodeList envChild = envElem.getChildNodes();
                Node elementBody = null;
                for (int i = 0; i < envChild.getLength(); i++) {

                    if (envChild.item(i).getLocalName() != null && envChild.item(i).getLocalName().equalsIgnoreCase("body")) {
                        elementBody = envChild.item(i);
                    }
                }
                if (elementBody != null) {
                    NodeList bodyChild = elementBody.getChildNodes();
                    int numeroFigli = bodyChild.getLength();
                    if (logger.isDebugEnabled()) logger.debug("Il body ha " + numeroFigli + " figli");
                    if (numeroFigli > 1) {
                        if (logger.isDebugEnabled()) logger.debug("Il body ha " + numeroFigli + " figli");
                        messaggioIn.getExchange().setProperty(CostantiBusta.FIGLI_MULTIPLI, "true");
                        Properties props = new Properties();
                        props.put(OutputKeys.OMIT_XML_DECLARATION, "yes");

                        String stringaBody = "";
                        for (int i = 0; i < bodyChild.getLength(); i++) {
                            stringaBody += XmlUtil.stampaDocument(bodyChild.item(i));
                        }
                        if (logger.isDebugEnabled()) logger.debug(stringaBody);
                        MessageUtil.setString(messaggioIn, stringaBody);
                    }
                }
            }

        } catch (Exception e) {
            logger.error("Impossibile verificare se il body ha piu' figli.");
            if (logger.isDebugEnabled()) e.printStackTrace();
        }
    }

    static boolean startsWithCaseInsensitive(String s1, String s2) {
        return s1.regionMatches(true, 0, s2, 0, s2.length());
    }

    private String estraiCharset(String contentType) {
        if (contentType == null) {
            return null;
        }
        StringTokenizer tokenizer = new StringTokenizer(contentType, ";");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.contains("\"")) {
                token = token.replace("\"", "");
            }
            if (token.contains("charset=")) {
                return token.replace("charset=", "").trim();
            }
        }
        return null;
    }

}
