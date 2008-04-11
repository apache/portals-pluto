package org.apache.pluto.descriptors.portlet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.om.portlet.ExpirationCache;

/**
 * 
 * 			Expriation-cache defines expiration-based caching for this
 * 			portlet. 
 * 			Used in: portlet
 * 			
 * 
 * <p>Java class for expiration-cacheType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="expiration-cacheType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="expiration-time" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}expiration-timeType" minOccurs="0"/>
 *         &lt;element name="scope" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}cache-scopeType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "expiration-cacheType", propOrder = {
    "expirationTime",
    "scope"
})
public class ExpirationCacheDD implements ExpirationCache {
	
	@XmlElement(name = "expiration-time")
    protected int expirationTime;
    protected String scope;
	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.ExpirationCache#getExpirationTime()
	 */
	public int getExpirationTime() {
		return expirationTime;
	}
	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.ExpirationCache#setExpirationTime(int)
	 */
	public void setExpirationTime(int expirationTime) {
		this.expirationTime = expirationTime;
	}
	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.ExpirationCache#getScope()
	 */
	public String getScope() {
		return scope;
	}
	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.ExpirationCache#setScope(java.lang.String)
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
    

}
