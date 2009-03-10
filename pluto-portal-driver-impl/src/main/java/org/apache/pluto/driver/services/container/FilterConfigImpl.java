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
import java.util.List;
import java.util.Vector;

import javax.portlet.PortletContext;
import javax.portlet.filter.FilterConfig;

import org.apache.pluto.container.om.portlet.InitParam;

/**
 *
 *@since 29/05/2007
 *@version 2.0
 */
public class FilterConfigImpl implements FilterConfig {

	private final String filterName;
	private final List<? extends InitParam> initParameters;
	private final PortletContext portletContext;

	public FilterConfigImpl(String filterName, List<? extends InitParam> initParameters, PortletContext portletContext){
		this.filterName = filterName;
		this.initParameters = initParameters;
		this.portletContext = portletContext;
	}

	/**
	 * @see javax.portlet.filter.FilterConfig#getFilterName()
	 */
	public String getFilterName() {
		return filterName;
	}

	/**
	 * @see javax.portlet.filter.FilterConfig#getInitParameter(java.lang.String)
	 */
	public String getInitParameter(String name) {
		if (initParameters != null) {
			for (InitParam initParameter2 : initParameters) {
				if (initParameter2.getParamName().equals(name)){
					return initParameter2.getParamValue();
				}
			}
		}
		return null;
	}

	/**
	 * @see javax.portlet.filter.FilterConfig#getInitParameterNames()
	 */
	public Enumeration<String> getInitParameterNames() {
        Vector<String> enum1 = new Vector<String>();
        if ( initParameters != null ) {
            for(InitParam ip : this.initParameters ) {
                enum1.add(ip.getParamName());
            }
        }
        return enum1.elements();
	}

	/**
	 * @see javax.portlet.filter.FilterConfig#getPortletContext()
	 */
	public PortletContext getPortletContext() {
		return portletContext;
	}
}
