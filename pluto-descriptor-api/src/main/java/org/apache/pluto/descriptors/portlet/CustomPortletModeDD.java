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

import org.apache.pluto.om.portlet.CustomPortletMode;
import org.apache.pluto.om.portlet.Portlet;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "custom-portlet-modeType", propOrder = {
    "description","description1",
    "portletMode","portletMode1",
    "portalManaged",
    "decorationName"
})
public class CustomPortletModeDD implements CustomPortletMode {
	
	@XmlElement(name = "description")
	private String description = null;
	
	@XmlElement(name = "description", namespace = Portlet.QNAME_JSR168)
	private String description1 = null;
	
	@XmlElement(name = "portlet-mode")
	private String portletMode = null;
	
	@XmlElement(name = "portlet-mode", namespace = Portlet.QNAME_JSR168)
	private String portletMode1 = null;
	
	@XmlElement(name = "portal-managed")
	private String portalManaged = null;
	
	@XmlElement(name = "decoration-name")
	private String decorationName = null;
	
	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.CustomPortletMode#isPortalManaged()
	 */
	public boolean isPortalManaged(){
		return portalManaged.equals("true")?true:false;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.CustomPortletMode#getDecorationName()
	 */
	public String getDecorationName() {
		return decorationName;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.CustomPortletMode#setDecorationName(java.lang.String)
	 */
	public void setDecorationName(String decorationName) {
		this.decorationName = decorationName;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.CustomPortletMode#getDescription()
	 */
	public String getDescription() {
		if (description != null)
			return description;
		return description1;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.CustomPortletMode#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		this.description = description;
		this.description1 = description;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.CustomPortletMode#getPortletMode()
	 */
	public String getPortletMode() {
		if (portletMode != null)
			return portletMode;
		return portletMode1;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.CustomPortletMode#setPortletMode(java.lang.String)
	 */
	public void setPortletMode(String portletMode) {
		this.portletMode = portletMode;
		this.portletMode1 = portletMode;
	}
}
