//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.09.20 at 02:59:44 PM CEST 
//


package it.unibas.freesbee.monitoraggio.calcolo.wsaIcarGuaranteeTerms.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FunctionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FunctionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="resultType" type="{http://schemas.ggf.org/graap/2007/03/ws-agreement}Type" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FunctionType", namespace = "http://schemas.ggf.org/graap/2007/03/ws-agreement")
@XmlSeeAlso({
    Plus.class,
    Round.class,
    Divide.class,
    Hits.class,
    Times.class,
    Sum.class,
    Minus.class,
    Max.class,
    Mean.class,
    Min.class
})
public abstract class FunctionType {

    @XmlAttribute(namespace = "http://schemas.ggf.org/graap/2007/03/ws-agreement")
    protected Type resultType;

    /**
     * Gets the value of the resultType property.
     * 
     * @return
     *     possible object is
     *     {@link Type }
     *     
     */
    public Type getResultType() {
        return resultType;
    }

    /**
     * Sets the value of the resultType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Type }
     *     
     */
    public void setResultType(Type value) {
        this.resultType = value;
    }

}
