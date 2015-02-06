
package it.unibas.icar.freesbee.test.messaggi.attachment.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.5.2
 * 2015-01-19T22:10:10.589+01:00
 * Generated source version: 2.5.2
 */

@WebFault(name = "SOAPFault", targetNamespace = "http://icar.unibas.it/freesbee/")
public class SOAPFault_Exception extends Exception {
    
    private it.unibas.icar.freesbee.test.messaggi.attachment.client.SOAPFault soapFault;

    public SOAPFault_Exception() {
        super();
    }
    
    public SOAPFault_Exception(String message) {
        super(message);
    }
    
    public SOAPFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public SOAPFault_Exception(String message, it.unibas.icar.freesbee.test.messaggi.attachment.client.SOAPFault soapFault) {
        super(message);
        this.soapFault = soapFault;
    }

    public SOAPFault_Exception(String message, it.unibas.icar.freesbee.test.messaggi.attachment.client.SOAPFault soapFault, Throwable cause) {
        super(message, cause);
        this.soapFault = soapFault;
    }

    public it.unibas.icar.freesbee.test.messaggi.attachment.client.SOAPFault getFaultInfo() {
        return this.soapFault;
    }
}
