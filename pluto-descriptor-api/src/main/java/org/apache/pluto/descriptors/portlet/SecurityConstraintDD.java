/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.descriptors.portlet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.descriptors.common.UserDataConstraintDD;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "security-constraintType", propOrder = {
    "displayName","displayName1",
    "portletCollection","portletCollection1",
    "userDataConstraint",    "userDataConstraint1"
})
public class SecurityConstraintDD {
	
	@XmlElement (name = "display-name")
	private String displayName = null;
	
	@XmlElement (name = "display-name", namespace = PortletDD.QNAME_JSR168)
	private String displayName1 = null;
	
	@XmlElement ( name = "portlet-collection")
	private PortletCollectionDD portletCollection = null; 
	
	@XmlElement ( name = "portlet-collection", namespace = PortletDD.QNAME_JSR168)
	private PortletCollectionDD portletCollection1 = null; 
	
	@XmlElement ( name = "user-data-constraint")
	private UserDataConstraintDD userDataConstraint = null;
	
	@XmlElement ( name = "user-data-constraint", namespace = PortletDD.QNAME_JSR168)
	private UserDataConstraintDD userDataConstraint1 = null;

	public String getDisplayName() {
		if (displayName != null)
			return displayName;
		return displayName1;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
		this.displayName1 = displayName;
	}

	public PortletCollectionDD getPortletCollection() {
		if (portletCollection != null)
			return portletCollection;
		return portletCollection1;
	}

	public void setPortletCollection(PortletCollectionDD portletCollection) {
		this.portletCollection = portletCollection;
		this.portletCollection1 = portletCollection;
	}

	public UserDataConstraintDD getUserDataConstraint() {
		if (userDataConstraint != null)
			return userDataConstraint;
		return userDataConstraint1;
	}

	public void setUserDataConstraint(UserDataConstraintDD userDataConstraint) {
		this.userDataConstraint = userDataConstraint;
		this.userDataConstraint1 = userDataConstraint;
	}

}
