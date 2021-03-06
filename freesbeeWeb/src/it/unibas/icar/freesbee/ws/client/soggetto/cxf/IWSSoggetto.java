package it.unibas.icar.freesbee.ws.client.soggetto.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.5.2
 * 2012-06-22T18:14:44.585+02:00
 * Generated source version: 2.5.2
 * 
 */
@WebService(targetNamespace = "http://icar.unibas.it/freesbee/", name = "IWSSoggetto")
@XmlSeeAlso({ObjectFactory.class})
public interface IWSSoggetto {

    @RequestWrapper(localName = "removeSoggetto", targetNamespace = "http://icar.unibas.it/freesbee/", className = "it.unibas.icar.freesbee.ws.client.soggetto.cxf.RemoveSoggetto")
    @WebMethod
    @ResponseWrapper(localName = "removeSoggettoResponse", targetNamespace = "http://icar.unibas.it/freesbee/", className = "it.unibas.icar.freesbee.ws.client.soggetto.cxf.RemoveSoggettoResponse")
    public void removeSoggetto(
        @WebParam(name = "soggetto", targetNamespace = "")
        long soggetto
    ) throws SOAPFault_Exception;

    @RequestWrapper(localName = "addSoggetto", targetNamespace = "http://icar.unibas.it/freesbee/", className = "it.unibas.icar.freesbee.ws.client.soggetto.cxf.AddSoggetto")
    @WebMethod
    @ResponseWrapper(localName = "addSoggettoResponse", targetNamespace = "http://icar.unibas.it/freesbee/", className = "it.unibas.icar.freesbee.ws.client.soggetto.cxf.AddSoggettoResponse")
    public void addSoggetto(
        @WebParam(name = "soggetto", targetNamespace = "")
        it.unibas.icar.freesbee.ws.client.soggetto.cxf.Soggetto soggetto
    ) throws SOAPFault_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getSoggetto", targetNamespace = "http://icar.unibas.it/freesbee/", className = "it.unibas.icar.freesbee.ws.client.soggetto.cxf.GetSoggetto")
    @WebMethod
    @ResponseWrapper(localName = "getSoggettoResponse", targetNamespace = "http://icar.unibas.it/freesbee/", className = "it.unibas.icar.freesbee.ws.client.soggetto.cxf.GetSoggettoResponse")
    public it.unibas.icar.freesbee.ws.client.soggetto.cxf.Soggetto getSoggetto(
        @WebParam(name = "soggetto", targetNamespace = "")
        long soggetto
    ) throws SOAPFault_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getListaSoggetti", targetNamespace = "http://icar.unibas.it/freesbee/", className = "it.unibas.icar.freesbee.ws.client.soggetto.cxf.GetListaSoggetti")
    @WebMethod
    @ResponseWrapper(localName = "getListaSoggettiResponse", targetNamespace = "http://icar.unibas.it/freesbee/", className = "it.unibas.icar.freesbee.ws.client.soggetto.cxf.GetListaSoggettiResponse")
    public java.util.List<it.unibas.icar.freesbee.ws.client.soggetto.cxf.Soggetto> getListaSoggetti() throws SOAPFault_Exception;
}
