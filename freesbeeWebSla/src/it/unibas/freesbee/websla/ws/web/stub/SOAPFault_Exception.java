
package it.unibas.freesbee.websla.ws.web.stub;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.7
 * 2013-12-12T22:29:20.161+01:00
 * Generated source version: 2.7.7
 */

@WebFault(name = "SOAPFault", targetNamespace = "http://web.ws.freesbeesla.unibas.it/")
public class SOAPFault_Exception extends Exception {
    
    private SOAPFault soapFault;

    public SOAPFault_Exception() {
        super();
    }
    
    public SOAPFault_Exception(String message) {
        super(message);
    }
    
    public SOAPFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public SOAPFault_Exception(String message, SOAPFault soapFault) {
        super(message);
        this.soapFault = soapFault;
    }

    public SOAPFault_Exception(String message, SOAPFault soapFault, Throwable cause) {
        super(message, cause);
        this.soapFault = soapFault;
    }

    public SOAPFault getFaultInfo() {
        return this.soapFault;
    }
}
