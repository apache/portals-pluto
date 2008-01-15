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
package org.apache.pluto.descriptors.common;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.descriptors.portlet.PortletDD;

/**
 * User Data Constraint descriptor.
 *
 * @version $Id: UserDataConstraintDD.java 156636 2005-03-09 12:16:31Z cziegeler $
 * @since Feb 28, 2005
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user-data-constraintType", propOrder = {
		"descriptions","descriptions1",
		"transportGuarantee", "transportGuarantee1"
})
public class UserDataConstraintDD {

    public static final String NONE = "NONE";
    public static final String INTEGRAL = "INTEGRAL";
    public static final String CONFIDENTIAL = "CONFIDENTIAL";

    @XmlElement(name = "description")
    private List<String> descriptions = new ArrayList<String>();
    
    @XmlElement(name = "description", namespace = PortletDD.QNAME_JSR168)
	private List<String> descriptions1 = new ArrayList<String>();

    @XmlElement(name = "transport-guarantee")
    private String transportGuarantee;
    
    @XmlElement(name = "transport-guarantee", namespace = PortletDD.QNAME_JSR168)
	private String transportGuarantee1 = null;

    public UserDataConstraintDD() {

    }

    public List<String> getDescriptions() {
    	if (descriptions.size() > 0) 
    		return descriptions;
        return descriptions1;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
        this.descriptions1 = descriptions;
    }

    public String getTransportGuarantee() {
    	if (transportGuarantee != null)
			return transportGuarantee;
		return transportGuarantee1;
    }

    public void setTransportGuarantee(String transportGuarantee) {
        this.transportGuarantee = transportGuarantee;
        this.transportGuarantee1 = transportGuarantee;
    }

}

