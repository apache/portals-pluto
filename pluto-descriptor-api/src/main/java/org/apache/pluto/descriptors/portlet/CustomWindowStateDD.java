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

import org.apache.pluto.om.portlet.CustomWindowState;
import org.apache.pluto.om.portlet.Portlet;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "custom-window-stateType", propOrder = {
    "description","description1",
    "windowState","windowState1"
})
public class CustomWindowStateDD implements CustomWindowState {
	
	@XmlElement(name = "description")
	private String description = null;
	
	@XmlElement(name = "description", namespace = Portlet.QNAME_JSR168)
	private String description1 = null;
	
	@XmlElement(name = "window-state")
	private String windowState = null;

	@XmlElement(name = "window-state", namespace = Portlet.QNAME_JSR168)
	private String windowState1 = null;
	
	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.CustomWindowState#getDescription()
	 */
	public String getDescription() {
		if (description != null)
			return description;
		return description1;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.CustomWindowState#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		this.description = description;
		this.description1 = description;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.CustomWindowState#getWindowState()
	 */
	public String getWindowState() {
		if (windowState != null)
			return windowState;
		return windowState1;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.CustomWindowState#setWindowState(java.lang.String)
	 */
	public void setWindowState(String windowState) {
		this.windowState = windowState;
		this.windowState1 = windowState;
	}

}
