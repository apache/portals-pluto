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

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.om.portlet.Portlet;
import org.apache.pluto.om.portlet.PortletCollection;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portlet-collectionType", propOrder = {
    "portletName","portletName1"
})
public class PortletCollectionDD implements PortletCollection {
	@XmlElement (name = "portlet-name")
	private List<String> portletName = null;
	
	@XmlElement (name = "portlet-name", namespace = Portlet.QNAME_JSR168)
	private List<String> portletName1 = null;

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletCollection#getPortletName()
	 */
	public List<String> getPortletName() {
		if (portletName != null)
			return portletName;
		return portletName1;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.PortletCollection#setPortletName(java.util.List)
	 */
	public void setPortletName(List<String> portletName) {
		this.portletName = portletName;
		this.portletName1 = portletName;
	}

}
