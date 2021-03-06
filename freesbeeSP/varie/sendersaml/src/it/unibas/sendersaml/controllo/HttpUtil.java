package it.unibas.sendersaml.controllo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xml.sax.InputSource;

public class HttpUtil {

    private static Log logger = LogFactory.getLog(HttpUtil.class);

    public static String completaUrl(String nodeValue, String stringaUrl) {
        if (nodeValue == null || stringaUrl == null) {
            throw new IllegalArgumentException("nodeValue: " + nodeValue + " stringaUrl: " + stringaUrl);
        }
        try {
            if (nodeValue.toLowerCase().startsWith("http://")) {
                return nodeValue;
            }
            if (nodeValue.toLowerCase().startsWith("/")) {
                URL url = new URL(stringaUrl);
                return url.getProtocol() + "://" + url.getHost() + nodeValue;
            }
            return nodeValue;
        } catch (Exception e) {
            logger.error("Impossibile compleatare l'url " + nodeValue);
            return nodeValue;
        }
    }

    public static Document parseHttp(InputStream reponse) {
        OutputStream os = new ByteArrayOutputStream();
        Tidy tidy = new Tidy();
        tidy.setXHTML(true);
        tidy.setIndentContent(true);
        Document docResponse = tidy.parseDOM(reponse, os);
        if (logger.isDebugEnabled()) {
            tidy.pprint(docResponse, System.out);
        }

        return docResponse;
    }

    public static String stampaMethod(HttpMethod httpMethod) {
        try {
            String s = "Risposta: \nIndirizzo: " + httpMethod.getURI() + "\nStato: " + httpMethod.getStatusCode() + "\n";

            s += "Header Richiesta:\n";
            Header[] requestHeaders = httpMethod.getRequestHeaders();
            for (int i = 0; i < requestHeaders.length; i++) {
                Header header = requestHeaders[i];
                s += "\t" + header.getName() + ": " + header.getValue() + "\n";
            }
            s += "Header Risposta:\n";
            Header[] responseHeaders = httpMethod.getResponseHeaders();
            for (int i = 0; i < responseHeaders.length; i++) {
                Header header = responseHeaders[i];
                s += "\t" + header.getName() + ": " + header.getValue() + "\n";
            }
            s += httpMethod.getResponseBodyAsString();
            return s;
        } catch (IOException ex) {
            logger.error("Impossibile stampare il method");
        }
        return "";
    }

    public static HttpClient getHttpClient(String username, String password) {
        HttpClient httpClient = new HttpClient();
        if (username != null && password != null) {
            logger.info("Aggiungo le credenziali " + username + "@" + password);
            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
            httpClient.getState().setCredentials(AuthScope.ANY, credentials);
//            httpClient.getState().setCredentials(new AuthScope(urlIdp, 443), credentials);
        }
        return httpClient;
    }

    public static String getRedirect(HttpMethod httpMethod) {
        int statusCode = httpMethod.getStatusCode();
        Header redirectLocation = httpMethod.getResponseHeader("Location");
        if (statusCode >= 300 && statusCode <= 304 && redirectLocation != null) {
            return redirectLocation.getValue();
        } else {
            return null;
        }
    }

    public static Document loadXMLFromString(String xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }
}
