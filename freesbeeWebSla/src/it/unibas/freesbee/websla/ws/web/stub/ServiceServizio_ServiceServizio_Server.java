
package it.unibas.freesbee.websla.ws.web.stub;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2013-12-12T23:04:16.146+01:00
 * Generated source version: 2.7.7
 * 
 */
 
public class ServiceServizio_ServiceServizio_Server{

    protected ServiceServizio_ServiceServizio_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new ServiceServizioImpl();
        String address = "http://0.0.0.0:28080/freesbee-Sla/ws/servizio/ServiceServizio";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws java.lang.Exception { 
        new ServiceServizio_ServiceServizio_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}
