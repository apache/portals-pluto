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
package org.apache.pluto.container.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.EventDefinitionReference;
import org.apache.pluto.container.om.portlet.InitParam;
import org.apache.pluto.container.om.portlet.PortletDefinition;

/**
 * Abstract PortletConfig base class Implementation.
 * <p>
 * An embedding Portal can extend this base class and is only required to provide
 * an implementation of the getResourceBundle bundle method.
 * </p>
 * 
 * @version $Id$
 */
public abstract class AbstractPortletConfigImpl implements PortletConfig
{
    protected PortletContext portletContext;
    /**
     * The portlet descriptor.
     */
    protected PortletDefinition portlet;
    
    protected Map<String, String[]> containerRuntimeOptions;
    
    protected Set<String> supportedContainerRuntimeOptions; 

    public AbstractPortletConfigImpl(PortletContext portletContext, PortletDefinition portlet)
    {
        this.portletContext = portletContext;
        this.portlet = portlet;
        this.supportedContainerRuntimeOptions = new HashSet<String>();
        for (Enumeration<String> e = portletContext.getContainerRuntimeOptions(); e.hasMoreElements(); )
        {
            supportedContainerRuntimeOptions.add(e.nextElement());
        }
    }

    public abstract ResourceBundle getResourceBundle(Locale locale);
    
    public String getPortletName() {
        return portlet.getPortletName();
    }

    public PortletContext getPortletContext() {
        return portletContext;
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
		if (portlet.getApplication().getDefaultNamespace() == null)
			return XMLConstants.NULL_NS_URI;
		return portlet.getApplication().getDefaultNamespace();
	}

	public Enumeration<QName> getProcessingEventQNames() {
	    ArrayList<QName> qnameList = new ArrayList<QName>();
        for (EventDefinitionReference ref : portlet.getSupportedProcessingEvents())
        {
            QName name = ref.getQualifiedName(portlet.getApplication().getDefaultNamespace());
            if (name == null)
            {
                continue;
            }
            qnameList.add(name);
        }
        return Collections.enumeration(qnameList);
	}

	public Enumeration<QName> getPublishingEventQNames() {
        ArrayList<QName> qnameList = new ArrayList<QName>();
        for (EventDefinitionReference ref : portlet.getSupportedPublishingEvents())
        {
            QName name = ref.getQualifiedName(portlet.getApplication().getDefaultNamespace());
            if (name == null)
            {
                continue;
            }
            qnameList.add(name);
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
	
	public Map<String, String[]> getContainerRuntimeOptions()
	{
	    synchronized(this)
	    {
	        if (containerRuntimeOptions == null)
	        {
	            containerRuntimeOptions = new HashMap<String, String[]>();
                for (ContainerRuntimeOption option : portlet.getApplication().getContainerRuntimeOptions())
                {
                    List<String> values = option.getValues();
                    String [] tempValues = new String[values.size()];
                    for (int i=0;i<values.size();i++)
                    {
                        tempValues[i] = values.get(i);
                    }
                    containerRuntimeOptions.put(option.getName(),tempValues);
                }
                for (ContainerRuntimeOption option : portlet.getContainerRuntimeOptions())
                {
                    List<String> values = option.getValues();
                    String [] tempValues = new String[values.size()];
                    for (int i=0;i<values.size();i++)
                    {
                        tempValues[i] = values.get(i);
                    }
                    containerRuntimeOptions.put(option.getName(),tempValues);
                }
	            for (Iterator<String> iter = containerRuntimeOptions.keySet().iterator(); iter.hasNext(); )
	            {
	                String key = iter.next();
	                if (!supportedContainerRuntimeOptions.contains(key))
	                {
	                    iter.remove();
	                }
	            }
	        }
	    }
	    
        if (!containerRuntimeOptions.isEmpty())
        {
            Map<String, String[]> result = new HashMap<String, String[]>(containerRuntimeOptions.size());
            for (Map.Entry<String,String[]> entry : containerRuntimeOptions.entrySet())
            {
                if (entry.getValue() != null)
                {
                    result.put(entry.getKey(), entry.getValue().clone());
                }
            }
            return Collections.unmodifiableMap(result);
        }
        return Collections.emptyMap();
	}
}
