package it.unibas.icar.freesbee.ws.client.accordoservizio.cxf;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.5.2
 * 2012-06-22T17:23:47.431+02:00
 * Generated source version: 2.5.2
 * 
 */
@WebServiceClient(name = "WSAccordoServizioImplService", 
                  wsdlLocation = "http://localhost:8191/ws/accordoServizio?wsdl",
                  targetNamespace = "http://web.ws.freesbee.icar.unibas.it/") 
public class WSAccordoServizioImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://web.ws.freesbee.icar.unibas.it/", "WSAccordoServizioImplService");
    public final static QName WSAccordoServizioImplPort = new QName("http://web.ws.freesbee.icar.unibas.it/", "WSAccordoServizioImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8191/ws/accordoServizio?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WSAccordoServizioImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8191/ws/accordoServizio?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WSAccordoServizioImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WSAccordoServizioImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSAccordoServizioImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WSAccordoServizioImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WSAccordoServizioImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WSAccordoServizioImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName);
    }

    /**
     *
     * @return
     *     returns IWSAccordoServizio
     */
    @WebEndpoint(name = "WSAccordoServizioImplPort")
    public IWSAccordoServizio getWSAccordoServizioImplPort() {
        return super.getPort(WSAccordoServizioImplPort, IWSAccordoServizio.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IWSAccordoServizio
     */
    @WebEndpoint(name = "WSAccordoServizioImplPort")
    public IWSAccordoServizio getWSAccordoServizioImplPort(WebServiceFeature... features) {
        return super.getPort(WSAccordoServizioImplPort, IWSAccordoServizio.class, features);
    }

}
