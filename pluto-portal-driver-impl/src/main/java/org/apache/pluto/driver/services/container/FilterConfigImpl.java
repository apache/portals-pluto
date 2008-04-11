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
package org.apache.pluto.driver.services.container;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.portlet.PortletContext;
import javax.portlet.filter.FilterConfig;

import org.apache.pluto.descriptors.common.InitParamDD;
import org.apache.pluto.om.common.InitParam;

/**
 * 
 *@since 29/05/2007
 *@version 2.0
 */
public class FilterConfigImpl implements FilterConfig {

	private String filterName = null;
	private List<InitParam> initParameters = null;
	private PortletContext portletContext = null;
	public FilterConfigImpl(String filterName, List<InitParam> initParameters, PortletContext portletContext){
		this.filterName = filterName;
		this.initParameters = initParameters;
		this.portletContext = portletContext;
	}
	public String getFilterName() {
		return filterName;
	}

	public String getInitParameter(String name) {
		for (InitParam initParameter2 : initParameters) {
			if (initParameter2.getParamName().equals(name)){
				return initParameter2.getParamValue();
			}
		}
		return null;
	}

	public Enumeration getInitParameterNames() {
		Hashtable<String,String> enum1 = new Hashtable<String, String>();
		return enum1.elements();
	}

	public PortletContext getPortletContext() {
		return portletContext;
	}
}
