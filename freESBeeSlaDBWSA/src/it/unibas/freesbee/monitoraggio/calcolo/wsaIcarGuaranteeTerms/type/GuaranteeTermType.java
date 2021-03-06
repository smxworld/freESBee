//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.09.20 at 02:59:44 PM CEST 
//


package it.unibas.freesbee.monitoraggio.calcolo.wsaIcarGuaranteeTerms.type;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuaranteeTermType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GuaranteeTermType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.ggf.org/graap/2007/03/ws-agreement}TermType">
 *       &lt;sequence>
 *         &lt;element name="ServiceScope" type="{http://schemas.ggf.org/graap/2007/03/ws-agreement}ServiceSelectorType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.ggf.org/graap/2007/03/ws-agreement}QualifyingCondition" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.ggf.org/graap/2007/03/ws-agreement}ServiceLevelObjective"/>
 *         &lt;element name="BusinessValueList" type="{http://schemas.ggf.org/graap/2007/03/ws-agreement}BusinessValueListType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Obligated" type="{http://schemas.ggf.org/graap/2007/03/ws-agreement}ServiceRoleType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuaranteeTermType", namespace = "http://schemas.ggf.org/graap/2007/03/ws-agreement", propOrder = {
    "serviceScope",
    "qualifyingCondition",
    "serviceLevelObjective",
    "businessValueList"
})
public class GuaranteeTermType
    extends TermType
{

    @XmlElement(name = "ServiceScope", namespace = "http://schemas.ggf.org/graap/2007/03/ws-agreement")
    protected List<ServiceSelectorType> serviceScope;
    @XmlElement(name = "QualifyingCondition", namespace = "http://schemas.ggf.org/graap/2007/03/ws-agreement")
    protected Object qualifyingCondition;
    @XmlElement(name = "ServiceLevelObjective", namespace = "http://schemas.ggf.org/graap/2007/03/ws-agreement", required = true)
    protected ServiceLevelObjectiveType serviceLevelObjective;
    @XmlElement(name = "BusinessValueList", namespace = "http://schemas.ggf.org/graap/2007/03/ws-agreement", required = true)
    protected BusinessValueListType businessValueList;
    @XmlAttribute(name = "Obligated", namespace = "http://schemas.ggf.org/graap/2007/03/ws-agreement")
    protected ServiceRoleType obligated;

    /**
     * Gets the value of the serviceScope property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceScope property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceScope().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceSelectorType }
     * 
     * 
     */
    public List<ServiceSelectorType> getServiceScope() {
        if (serviceScope == null) {
            serviceScope = new ArrayList<ServiceSelectorType>();
        }
        return this.serviceScope;
    }

    /**
     * Gets the value of the qualifyingCondition property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getQualifyingCondition() {
        return qualifyingCondition;
    }

    /**
     * Sets the value of the qualifyingCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setQualifyingCondition(Object value) {
        this.qualifyingCondition = value;
    }

    /**
     * Gets the value of the serviceLevelObjective property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceLevelObjectiveType }
     *     
     */
    public ServiceLevelObjectiveType getServiceLevelObjective() {
        return serviceLevelObjective;
    }

    /**
     * Sets the value of the serviceLevelObjective property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceLevelObjectiveType }
     *     
     */
    public void setServiceLevelObjective(ServiceLevelObjectiveType value) {
        this.serviceLevelObjective = value;
    }

    /**
     * Gets the value of the businessValueList property.
     * 
     * @return
     *     possible object is
     *     {@link BusinessValueListType }
     *     
     */
    public BusinessValueListType getBusinessValueList() {
        return businessValueList;
    }

    /**
     * Sets the value of the businessValueList property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessValueListType }
     *     
     */
    public void setBusinessValueList(BusinessValueListType value) {
        this.businessValueList = value;
    }

    /**
     * Gets the value of the obligated property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceRoleType }
     *     
     */
    public ServiceRoleType getObligated() {
        return obligated;
    }

    /**
     * Sets the value of the obligated property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceRoleType }
     *     
     */
    public void setObligated(ServiceRoleType value) {
        this.obligated = value;
    }

}
