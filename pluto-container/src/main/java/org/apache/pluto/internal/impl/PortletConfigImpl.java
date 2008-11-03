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
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.internal.InternalPortletConfig;
import org.apache.pluto.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.om.portlet.EventDefinitionReference;
import org.apache.pluto.om.portlet.InitParam;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;

public class PortletConfigImpl implements PortletConfig, InternalPortletConfig {

    private static final Log LOG = LogFactory.getLog(PortletConfigImpl.class);

    /**
     * The Portlet Application Context within which we exist.
     */
    protected PortletContext portletContext;

    /**
     * The portlet descriptor.
     */
    protected PortletDefinition portlet;
    
    /**
     * The portlet application descriptor.
     */
    protected PortletApplicationDefinition portletApp;

    protected ResourceBundleFactory bundles;

    public PortletConfigImpl(PortletContext portletContext,
                             PortletDefinition portletDD,
                             PortletApplicationDefinition portletAppDD) {
        this.portletContext = portletContext;
        this.portlet = portletDD;
        this.portletApp = portletAppDD;
    }

    public String getPortletName() {
        return portlet.getPortletName();
    }

    public PortletContext getPortletContext() {
        return portletContext;
    }

    public ResourceBundle getResourceBundle(Locale locale) {
        if(LOG.isDebugEnabled()) {
            LOG.debug("Resource Bundle requested: "+locale);
        }
        if (bundles == null) {
            bundles = new ResourceBundleFactory(portlet);
        }
        return bundles.getResourceBundle(locale);
    }

    public String getInitParameter(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Parameter name == null");
        }

        Iterator<? extends InitParam> parms = portlet.getInitParams().iterator();
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
                new ArrayList<InitParam>(portlet.getInitParams()).iterator();

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

    public PortletDefinition getPortletDefinition() {
        return portlet;
    }
    // --------------------------------------------------------------------------------------------

	public Enumeration<String> getPublicRenderParameterNames() {
		if (portlet.getSupportedPublicRenderParameters() != null){
			return Collections.enumeration(portlet.getSupportedPublicRenderParameters());
		}
		return  Collections.enumeration(new ArrayList<String>());
	}

	public String getDefaultNamespace() {
		if (portletApp.getDefaultNamespace() == null)
			return XMLConstants.NULL_NS_URI;
		return portletApp.getDefaultNamespace();
	}

	public Enumeration<QName> getProcessingEventQNames() {
	    ArrayList<QName> qnameList = new ArrayList<QName>();
        for (EventDefinitionReference ref : portlet.getSupportedProcessingEvents())
        {
            QName name = ref.getQualifiedName(portletApp.getDefaultNamespace());
            if (name == null)
            {
                continue;
            }
            else
            {
                qnameList.add(name);
            }
        }
        return Collections.enumeration(qnameList);
	}

	public Enumeration<QName> getPublishingEventQNames() {
        ArrayList<QName> qnameList = new ArrayList<QName>();
        for (EventDefinitionReference ref : portlet.getSupportedPublishingEvents())
        {
            QName name = ref.getQualifiedName(portletApp.getDefaultNamespace());
            if (name == null)
            {
                continue;
            }
            else
            {
                qnameList.add(name);
            }
        }
        return Collections.enumeration(qnameList);
	}

	public Enumeration<Locale> getSupportedLocales() {
		// for each String entry in SupportedLocales (portletDD)
		// add an entry in the resut list (new Locale(string))
		List<Locale> locals = new ArrayList<Locale>();
		List<String> localsAsStrings = portlet.getSupportedLocales();
		if (localsAsStrings!=null){
			for (String string : localsAsStrings) {
				locals.add(new Locale(string));
			}
		}
		return Collections.enumeration(locals);
	}
	
	public Map<String, String[]> getApplicationRuntimeOptions() {
		Map<String, String[]> resultMap = new HashMap<String, String[]>();
		if (portletApp.getContainerRuntimeOptions() != null){
			for (ContainerRuntimeOption option : portletApp.getContainerRuntimeOptions()) {
				if (getSupportedContainerRuntimeOptions().contains(option.getName())){
					List<String> values = option.getValues();
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
		if (portlet.getContainerRuntimeOptions() != null) {
			for (ContainerRuntimeOption option : portlet.getContainerRuntimeOptions()) {
				if (getSupportedContainerRuntimeOptions().contains(option.getName())){
					List<String> values = option.getValues();
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
	
    protected List<String> getSupportedContainerRuntimeOptions()
    {
        return Configuration.getSupportedContainerRuntimeOptions();
    }
	
}
