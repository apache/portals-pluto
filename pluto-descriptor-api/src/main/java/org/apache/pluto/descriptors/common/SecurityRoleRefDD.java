/*
 * Copyright 2005 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.descriptors.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.descriptors.portlet.PortletDD;

/**
 * Security Role Reference Configuration.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version $Id: SecurityRoleRefDD.java 157038 2005-03-11 03:44:40Z ddewolf $
 * @since Feb 28, 2005
 *
 * 
 *                      The security-role-ref element contains the declaration of a 
 *                      security role reference in the code of the web application. The 
 *                      declaration consists of an optional description, the security 
 *                      role name used in the code, and an optional link to a security 
 *                      role. If the security role is not specified, the Deployer must 
 *                      choose an appropriate security role.
 *                      The value of the role name element must be the String used 
 *                      as the parameter to the 
 *                      EJBContext.isCallerInRole(String roleName) method
 *                      or the HttpServletRequest.isUserInRole(String role) method.
 *                      Used in: portlet
 *                      
 * 
 * <p>Java class for security-role-refType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="security-role-refType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}descriptionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="role-name" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}role-nameType"/>
 *         &lt;element name="role-link" type="{http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd}role-linkType" minOccurs="0"/>
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
@XmlType(name = "security-role-refType", propOrder = {
    "description","description1",
    "roleName","roleName1",
    "roleLink","roleLink1"
})

public class SecurityRoleRefDD {
	
	/** The description of what the role is utilized for. */
	@XmlElement( name = "description")
    private String description;
	
	/** The description of what the role is utilized for. */
	@XmlElement( name = "description", namespace = PortletDD.QNAME_JSR168)
    private String description1;

    /** The name of the role reference. */
	@XmlElement( name = "role-name")
    private String roleName;
	
	/** The name of the role reference. */
	@XmlElement( name = "role-name", namespace = PortletDD.QNAME_JSR168)
    private String roleName1;

    /** The role to which the reference is linked. */
	@XmlElement( name = "role-link")
    private String roleLink;    
	
	/** The role to which the reference is linked. */
	@XmlElement( name = "role-link", namespace = PortletDD.QNAME_JSR168)
    private String roleLink1;    

    /**
     * Default Constructor.
     */
    public SecurityRoleRefDD() {

    }

    /**
     * Retrieve the name of the role reference.
     * @return
     */
    public String getRoleName() {
    	if (roleName != null)
    		return roleName;
    	return roleName1;
    }

    /**
     * Set the name of the role reference.
     * @param roleName
     */
    public void setRoleName(String roleName) {
    	this.roleName = roleName;
    	this.roleName1 = roleName;
    }

    /**
     * Retrieve then role to which the reference is linked.
     * @return
     */
    public String getRoleLink() {
    	if (roleLink != null)
    		return roleLink;
    	return roleLink1;
    }

    /**
     * Set the role to which the reference is linked.
     * @param roleLink
     */
    public void setRoleLink(String roleLink) {
    	this.roleLink = roleLink;
    	this.roleLink1 = roleLink;
    }

    /**
     * Retrieve the description of the role reference.
     * @return
     */
    public String getDescription() {
    	if (description != null)
    		return description;
    	return description1;
    }

    /**
     * Set the description of the role reference.
     * @param description
     */
    public void setDescription(String description) {
    	this.description = description;
    	this.description1 = description;
    }
}

