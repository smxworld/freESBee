
package it.unibas.freesbee.websla.ws.web.stub;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;


/**
 * This class was generated by Apache CXF (incubator) 2.0.4-incubator
 * Wed Sep 03 15:35:51 CEST 2008
 * Generated source version: 2.0.4-incubator
 * 
 */

@WebServiceClient(name = "ServiceMonitoraggioStatistiche", targetNamespace = "http://web.ws.freesbeesla.unibas.it/", wsdlLocation = "file:ServiceMonitoraggioStatistiche.wsdl")
public class ServiceMonitoraggioStatistiche_Service extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://web.ws.freesbeesla.unibas.it/", "ServiceMonitoraggioStatistiche");
    public final static QName ServiceMonitoraggioStatistiche = new QName("http://web.ws.freesbeesla.unibas.it/", "ServiceMonitoraggioStatistiche");
    static {
        URL url = null;
        try {
            url = new URL("file:ServiceMonitoraggioStatistiche.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:ServiceMonitoraggioStatistiche.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public ServiceMonitoraggioStatistiche_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ServiceMonitoraggioStatistiche_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServiceMonitoraggioStatistiche_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns ServiceMonitoraggioStatistiche
     */
    @WebEndpoint(name = "ServiceMonitoraggioStatistiche")
    public ServiceMonitoraggioStatistiche getServiceMonitoraggioStatistiche() {
        return (ServiceMonitoraggioStatistiche)super.getPort(ServiceMonitoraggioStatistiche, ServiceMonitoraggioStatistiche.class);
    }

}
