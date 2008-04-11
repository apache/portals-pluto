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
package org.apache.pluto.internal.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.servlet.ServletConfig;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.pluto.internal.InternalPortletConfig;
import org.apache.pluto.om.common.InitParam;
import org.apache.pluto.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.om.portlet.Portlet;
import org.apache.pluto.om.portlet.PortletApp;
import org.apache.pluto.descriptors.common.InitParamDD;

public class PortletConfigImpl implements PortletConfig, InternalPortletConfig {

    private static final Log LOG = LogFactory.getLog(PortletConfigImpl.class);

    /**
     * The servlet config for which we exist.
     */
    private ServletConfig servletConfig;

    /**
     * The Portlet Application Context within which we exist.
     */
    private PortletContext portletContext;

    /**
     * The portlet descriptor.
     */
    protected Portlet portletDD;
    
    /**
     * The portlet application descriptor.
     */
    private PortletApp portletAppDD;

    private ResourceBundleFactory bundles;

    public PortletConfigImpl(ServletConfig servletConfig,
                             PortletContext portletContext,
                             Portlet portletDD,
                             PortletApp portletAppDD) {
        this.servletConfig = servletConfig;
        this.portletContext = portletContext;
        this.portletDD = portletDD;
        this.portletAppDD = portletAppDD;
    }

    public String getPortletName() {
        return portletDD.getPortletName();
    }

    public PortletContext getPortletContext() {
        return portletContext;
    }

    public ResourceBundle getResourceBundle(Locale locale) {
        if(LOG.isDebugEnabled()) {
            LOG.debug("Resource Bundle requested: "+locale);
        }
        if (bundles == null) {
            bundles = new ResourceBundleFactory(portletDD);
        }
        return bundles.getResourceBundle(locale);
    }

    public String getInitParameter(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Parameter name == null");
        }

        Iterator<InitParam> parms = portletDD.getInitParams().iterator();
        while(parms.hasNext()) {
            InitParam param = parms.next();
            if (param.getParamName().equals(name)) {
                return param.getParamValue();
            }
        }
        return null;
    }

    public Enumeration<String> getInitParameterNames() {
        return new java.util.Enumeration<String>() {
            private Iterator<InitParam> iterator =
                new ArrayList<InitParam>(portletDD.getInitParams()).iterator();

            public boolean hasMoreElements() {
                return iterator.hasNext();
            }

            public String nextElement() {
                if (iterator.hasNext()) {
                    return iterator.next().getParamName();
                } 
                return null;
            }
        };
    }


    public javax.servlet.ServletConfig getServletConfig() {
        return servletConfig;
    }

    public Portlet getPortletDefinition() {
        return portletDD;
    }
    // --------------------------------------------------------------------------------------------

	public Enumeration<String> getPublicRenderParameterNames() {
		if (portletDD.getPublicRenderParameter() != null){
			return Collections.enumeration(portletDD.getPublicRenderParameter());
		}
		return  Collections.enumeration(new ArrayList<String>());
	}

	public String getDefaultNamespace() {
		if (portletAppDD.getDefaultNamespace() == null)
			return XMLConstants.NULL_NS_URI;
		return portletAppDD.getDefaultNamespace();
	}

	public Enumeration<QName> getProcessingEventQNames() {
		List<QName> qnameList = portletDD.getProcessingEvents();
		if (qnameList != null){
			for (int index = 0; index < qnameList.size();index++) {
				QName qname = qnameList.get(index);
				if (qname.getNamespaceURI().equals("")){
					qnameList.remove(index);
					qnameList.add(index, new QName(portletAppDD.getDefaultNamespace(),qname.getLocalPart()));
				}
			}
			return Collections.enumeration(qnameList);
		}
		else
			return Collections.enumeration(new ArrayList<QName>());
		
//		return (portletDD.getProcessingEvents() != null) ? 
//				Collections.enumeration(portletDD.getProcessingEvents()) :
//					Collections.enumeration(new ArrayList<QName>());
	}

	public Enumeration<QName> getPublishingEventQNames() {
		List<QName> qnameList = portletDD.getPublishingEvents();
		if (qnameList != null){
			for (int index = 0; index < qnameList.size();index++) {
				QName qname = qnameList.get(index);
				if (qname.getNamespaceURI().equals("")){
					qnameList.remove(index);
					qnameList.add(index, new QName(portletAppDD.getDefaultNamespace(),qname.getLocalPart()));
				}
			}
			return Collections.enumeration(qnameList);
		}
		else
			return Collections.enumeration(new ArrayList<QName>());
		
//		return (portletDD.getPublishingEvents() != null) ?
//				Collections.enumeration(portletDD.getPublishingEvents()) :
//					Collections.enumeration(new ArrayList<QName>());
	}

	public Enumeration<Locale> getSupportedLocales() {
		// for each String entry in SupportedLocales (portletDD)
		// add an entry in the resut list (new Locale(string))
		List<Locale> locals = new ArrayList<Locale>();
		List<String> localsAsStrings = portletDD.getSupportedLocale();
		if (localsAsStrings!=null){
			for (String string : localsAsStrings) {
				locals.add(new Locale(string));
			}
		}
		return Collections.enumeration(locals);
	}
	
	public Map<String, String[]> getApplicationRuntimeOptions() {
		Map<String, String[]> resultMap = new HashMap<String, String[]>();
		if (portletAppDD.getContainerRuntimeOption() != null){
			for (ContainerRuntimeOption option : portletAppDD.getContainerRuntimeOption()) {
				if (Configuration.getSupportedContainerRuntimeOptions().contains(option.getName())){
					List<String> values = option.getValue();
					String [] tempValues = new String[values.size()];
					for (int i=0;i<values.size();i++){
						tempValues[i] = values.get(i);
					}
					resultMap.put(option.getName(),tempValues);
				}
			}
		}
		return resultMap;
	}
	
	public Map<String, String[]> getPortletRuntimeOptions() {
		Map<String, String[]> resultMap = new HashMap<String, String[]>();
		if (portletDD.getContainerRuntimeOption() != null) {
			for (ContainerRuntimeOption option : portletDD.getContainerRuntimeOption()) {
				if (Configuration.getSupportedContainerRuntimeOptions().contains(option.getName())){
					List<String> values = option.getValue();
					String [] tempValues = new String[values.size()];
					for (int i=0;i<values.size();i++){
						tempValues[i] = values.get(i);
					}
					resultMap.put(option.getName(),tempValues);
				}
			}
		}
		return resultMap;
	}

	public Map<String, String[]> getContainerRuntimeOptions() {
		
		Map<String,String[]> appRuntimeOptions = getApplicationRuntimeOptions();
		Map<String,String[]> portletRuntimeOptions = getPortletRuntimeOptions();
		
		// merge these two, with portlet priority
		Map<String, String[]> resultMap = new HashMap<String, String[]>();
		
		// first all entries in portletAppDD (without these in portletDD)
		for (String option : appRuntimeOptions.keySet()) {
			if (portletRuntimeOptions.containsKey(option))
				resultMap.put(option, portletRuntimeOptions.get(option));
			else
				resultMap.put(option, appRuntimeOptions.get(option));
		}
		// and now the rest
		if (portletRuntimeOptions != null){
			for (String option : portletRuntimeOptions.keySet()) {
				if (!appRuntimeOptions.containsKey(option))
					resultMap.put(option, portletRuntimeOptions.get(option));
			}
		}
		//return resultMap;
		return null;
	}
}
