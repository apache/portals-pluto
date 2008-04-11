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

import org.apache.pluto.om.portlet.Portlet;
import org.apache.pluto.om.portlet.UserAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user-attributeType", propOrder = {
    "description","description1",
    "name","name1"
})
public class UserAttributeDD implements UserAttribute {
	
	@XmlElement(name = "description")
	private String description = null;
	
	@XmlElement(name = "description", namespace = Portlet.QNAME_JSR168)
	private String description1 = null;
	
	@XmlElement ( name = "name")
	private String name = null;
	
	@XmlElement ( name = "name", namespace = Portlet.QNAME_JSR168)
	private String name1 = null;

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.UserAttribute#getDescription()
	 */
	public String getDescription() {
		if (description != null)
			return description;
		return description1;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.UserAttribute#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		this.description = description;
		this.description1 = description;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.UserAttribute#getName()
	 */
	public String getName() {
		if (name != null)
			return name;
		return name1;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.UserAttribute#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
		this.name1 = name;
	}
}
