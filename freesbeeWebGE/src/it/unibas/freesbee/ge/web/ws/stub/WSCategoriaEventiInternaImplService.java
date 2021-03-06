
/*
 * 
 */

package it.unibas.freesbee.ge.web.ws.stub;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by Apache CXF 2.1.3
 * Tue Oct 20 23:16:34 CEST 2009
 * Generated source version: 2.1.3
 * 
 */


@WebServiceClient(name = "WSCategoriaEventiInternaImplService", 
                  wsdlLocation = "file:categoriaEventiInterna.wsdl",
                  targetNamespace = "http://ge.freesbee.unibas.it/") 
public class WSCategoriaEventiInternaImplService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://ge.freesbee.unibas.it/", "WSCategoriaEventiInternaImplService");
    public final static QName WSCategoriaEventiInternaImplPort = new QName("http://ge.freesbee.unibas.it/", "WSCategoriaEventiInternaImplPort");
    static {
        URL url = null;
        try {
            url = new URL("file:categoriaEventiInterna.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:categoriaEventiInterna.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public WSCategoriaEventiInternaImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WSCategoriaEventiInternaImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSCategoriaEventiInternaImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns IWSCategoriaEventiInterna
     */
    @WebEndpoint(name = "WSCategoriaEventiInternaImplPort")
    public IWSCategoriaEventiInterna getWSCategoriaEventiInternaImplPort() {
        return super.getPort(WSCategoriaEventiInternaImplPort, IWSCategoriaEventiInterna.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IWSCategoriaEventiInterna
     */
    @WebEndpoint(name = "WSCategoriaEventiInternaImplPort")
    public IWSCategoriaEventiInterna getWSCategoriaEventiInternaImplPort(WebServiceFeature... features) {
        return super.getPort(WSCategoriaEventiInternaImplPort, IWSCategoriaEventiInterna.class, features);
    }

}
