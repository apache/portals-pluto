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

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.PortalContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletSecurityException;
import javax.portlet.PortletURL;
import javax.portlet.PortletURLGenerationListener;
import javax.portlet.ResourceURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.apache.pluto.container.PortletMimeResponseContext;
import org.apache.pluto.container.PortletResponseContext;
import org.apache.pluto.container.PortletURLListenerService;
import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.om.portlet.CustomPortletMode;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.Supports;
import org.apache.pluto.container.util.ArgumentUtility;

/**
 * Refactoring where functionality was pushed into JSR-286 <code>BaseURL</code>.
 *
 * @since 2.0
 */
public class PortletURLImpl implements PortletURL, ResourceURL {

    private PortletResponseContext responseContext;
    private PortalContext portalContext;
    private PortletURLProvider urlProvider;
    private String cacheLevel = ResourceURL.PAGE;
    private boolean filtering;
    private boolean renderURL;
    
    public PortletURLImpl(PortletResponseContext responseContext, PortletURLProvider urlProvider)
    {
        this.responseContext = responseContext;
        this.portalContext = responseContext.getContainer().getContainerServices().getPortalContext();
        this.urlProvider = urlProvider;
        renderURL = PortletURLProvider.TYPE.RENDER == urlProvider.getType();
    }
    
    public PortletURLImpl(PortletMimeResponseContext responseContext, PortletURLProvider.TYPE type)
    {
        this(responseContext, responseContext.getPortletURLProvider(type));
    }
    
    public PortletURLImpl(PortletMimeResponseContext responseContext, String cacheLevel)
    {
        this(responseContext, PortletURLProvider.TYPE.RESOURCE);
        if (cacheLevel != null)
        {
            this.cacheLevel = cacheLevel;
        }
        urlProvider.setCacheability(this.cacheLevel);
    }

    private boolean isPortletModeAllowed(PortletMode mode)
    {
        if(PortletMode.VIEW.equals(mode))
        {
            return true;
        }
        
        String modeName = mode.toString();

        PortletDefinition dd = responseContext.getPortletWindow().getPortletDefinition();

        for (Supports sup : dd.getSupports())
        {
            for (String m : sup.getPortletModes())
            {
                if (m.equalsIgnoreCase(modeName)) 
                {
                    // check if a portlet managed mode which is always allowed.
                    CustomPortletMode cpm = dd.getApplication().getCustomPortletMode(modeName);
                    if (cpm != null && !cpm.isPortalManaged())
                    {
                        return true;
                    }
                    Enumeration<PortletMode> supportedModes = portalContext.getSupportedPortletModes();
                    while (supportedModes.hasMoreElements()) 
                    {
                        if (supportedModes.nextElement().equals(mode)) 
                        {
                            return true;
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    private boolean isWindowStateAllowed(WindowState state)
    {
        Enumeration<WindowState> supportedStates = portalContext.getSupportedWindowStates();
        while (supportedStates.hasMoreElements()) {
            if (supportedStates.nextElement().equals(state))
            {
                return true;
            }
        }
        return false;
    }
    
    private boolean isPublicRenderParameter(String name)
    {
        List<String> publicRenderParameterNames = responseContext.getPortletWindow().getPortletDefinition().getSupportedPublicRenderParameters();
        return publicRenderParameterNames.isEmpty() ? false : publicRenderParameterNames.contains(name);
    }
        
    private static String[] cloneParameterValues(String[] values)
    {
        int count = 0;
        for (String s : values)
        {
            if (s != null)
            {
                count++;
            }
        }
        if (count == 0)
        {
            return null;
        }
        else if (count < values.length)
        {
            String[] copy = new String[count];
            count = 0;
            for (String s : values)
            {
                if (s != null)
                {
                    copy[count++] = s;
                }
            }
            return copy;
        }
        else
        {
            return values.clone();
        }
    }
    
    public void filterURL()
    {
        if (filtering)
        {
            throw new IllegalStateException("Calling PortletURL toString or write methods from a PortletURLGenerationListener not allowed");
        }
        filtering = true;
        try
        {
            PortletURLListenerService service = responseContext.getContainer().getContainerServices().getPortletURLListenerService();
            PortletApplicationDefinition portletApp = responseContext.getPortletWindow().getPortletDefinition().getApplication();
            for (PortletURLGenerationListener listener : service.getPortletURLGenerationListeners(portletApp))
            {
                if (PortletURLProvider.TYPE.ACTION == urlProvider.getType())
                {
                    listener.filterActionURL(this);
                }
                else if (PortletURLProvider.TYPE.RESOURCE == urlProvider.getType())
                {
                    listener.filterResourceURL(this);
                }
                else
                {
                    listener.filterRenderURL(this);
                }
            }
        }
        finally
        {
            filtering = false;
        }
    }

    
    // BaseURL impl ------------------------------------------------------------
    
    public void addProperty(String key, String value)
    {
        ArgumentUtility.validateNotEmpty("key", key);
        if (value != null)
        {
            Map<String, List<String>> properties = urlProvider.getProperties();
            List<String> values = properties.get(key);
            if (values == null)
            {
                values = new ArrayList<String>();
                urlProvider.getProperties().put(key, values);
            }
            values.add(value);
        }
    }

    public Map<String, String[]> getParameterMap()
    {
        Map<String, String[]> parameters = urlProvider.getRenderParameters();
        if (parameters.isEmpty())
        {
            parameters = Collections.emptyMap();
        }
        else
        {
            parameters = new HashMap<String,String[]>(parameters);
            for (Map.Entry<String,String[]> entry : parameters.entrySet())
            {
                entry.setValue(entry.getValue().clone());
            }
        }
        return parameters;
    }

    public void setParameter(String name, String value)
    {
        ArgumentUtility.validateNotEmpty("name", name);
        ArgumentUtility.validateNotNull("value", value);
        String[] values = new String[]{value};
        urlProvider.getRenderParameters().put(name, values);
        if (renderURL && isPublicRenderParameter(name))
        {
            urlProvider.getPublicRenderParameters().put(name, values);
        }
    }

    public void setParameter(String name, String[] values)
    {
        ArgumentUtility.validateNotEmpty("name", name);
        ArgumentUtility.validateNotNull("values", values);
        values = cloneParameterValues(values);
        if (values == null )            
        {
            throw new IllegalStateException("Illegal Argument: values array is empty or contains only null values");
        }
        urlProvider.getRenderParameters().put(name, values);
        if (renderURL && isPublicRenderParameter(name))
        {
            urlProvider.getPublicRenderParameters().put(name, values);
        }
    }

    public void setParameters(Map<String, String[]> parameters)
    {
        ArgumentUtility.validateNotNull("parameters", parameters);
        
        // validate map first
        boolean emptyValuesArray;
        for (Map.Entry<? extends Object, ? extends Object> entry : parameters.entrySet())
        {
            if (entry.getKey() == null || entry.getValue() == null)
            {
                throw new IllegalArgumentException("parameters map contains a null key or value entry");
            }
            if (!(entry.getKey() instanceof String))
            {
                throw new IllegalArgumentException("parameters map contains a key which is not of type String");
            }
            if (!(entry.getValue() instanceof String[]))
            {
                throw new IllegalArgumentException("parameters map contains a value which is not of type String[]");
            }
            emptyValuesArray = true;
            for (String s : (String[])entry.getValue())
            {
                if (s != null)
                {
                    emptyValuesArray = false;
                    break;
                }
            }
            if (emptyValuesArray)
            {
                throw new IllegalStateException("parameters map contains a values array which is empty or contains only null values");
            }
        }
        urlProvider.getRenderParameters().clear();
        if (renderURL)
        {
            for (Iterator<Map.Entry<String,String[]>> iter = urlProvider.getPublicRenderParameters().entrySet().iterator(); iter.hasNext();)
            {
                if (iter.next().getValue() != null)
                {
                    iter.remove();
                }
            }
        }
        for (Map.Entry<String,String[]> entry : parameters.entrySet())
        {
            String[] values = cloneParameterValues(entry.getValue());
            urlProvider.getRenderParameters().put(entry.getKey(), values);
            if (renderURL && isPublicRenderParameter(entry.getKey()))
            {
                urlProvider.getPublicRenderParameters().put(entry.getKey(), values);
            }
        }
    }

    public void setProperty(String key, String value)
    {
        ArgumentUtility.validateNotEmpty("key", key);
        Map<String, List<String>> properties = urlProvider.getProperties();
        if (value == null)
        {
            properties.remove(key);
        }
        else
        {
            List<String> values = properties.get(key);
            if (values == null)
            {
                values = new ArrayList<String>();
                properties.put(key,values);
            }
            else
            {
                values.clear();
            }
            values.add(value);
        }
    }

    public void setSecure(boolean secure) throws PortletSecurityException
    {
        urlProvider.setSecure(secure);
    }

    public void write(Writer out, boolean escapeXML) throws IOException
    {
        filterURL();
        urlProvider.write(out, escapeXML);
    }

    public void write(Writer out) throws IOException
    {
        write(out, true);
    }
    
    public String toString()
    {
        filterURL();
        return urlProvider.toURL();
    }

    // PortletURL impl ------------------------------------------------------------    
    
    public PortletMode getPortletMode() 
    {
        return urlProvider.getPortletMode();
    }
    
    public WindowState getWindowState() 
    {
        return urlProvider.getWindowState();
    }
    
    public void setPortletMode(PortletMode portletMode) throws PortletModeException 
    {
        ArgumentUtility.validateNotNull("portletMode", portletMode);
        if (isPortletModeAllowed(portletMode))
        {
            urlProvider.setPortletMode(portletMode);
        }
        else 
        {
            throw new PortletModeException("Can't set this PortletMode", portletMode);
        }
    }

    public void setWindowState(WindowState windowState) throws WindowStateException
    {
        ArgumentUtility.validateNotNull("windowState", windowState);
        if (isWindowStateAllowed(windowState))
        {
            urlProvider.setWindowState(windowState);
        }
        else 
        {
            throw new WindowStateException("Can't set this WindowState", windowState);
        }
    }

    public void removePublicRenderParameter(String name)
    {
        ArgumentUtility.validateNotEmpty("name", name);
        if (isPublicRenderParameter(name))
        {
            urlProvider.getPublicRenderParameters().put(name, null);
            urlProvider.getRenderParameters().remove(name);
        }
    }

    // ResourceURL impl ------------------------------------------------------------    
    
    public String getCacheability()
    {
        return urlProvider.getCacheability();
    }

    public void setCacheability(String cacheLevel)
    {
        ArgumentUtility.validateNotEmpty("cachelevel", cacheLevel);
        if (FULL.equals(cacheLevel))
        {
            // always OK
        }
        else if (PORTLET.equals(cacheLevel))
        {
            if (FULL.equals(this.cacheLevel))
            {
                throw new IllegalStateException("Current request cacheablility is FULL: URLs with cacheability PORTLET not allowed");
            }
            
        }
        else if (PAGE.equals(cacheLevel))
        {
            if (FULL.equals(this.cacheLevel))
            {
                throw new IllegalStateException("Current request cacheablility is FULL: URLs with cacheability PORTLET not allowed");
            }
            else if (PORTLET.equals(this.cacheLevel))
            {
                throw new IllegalStateException("Current request cacheablility is PORTLET: URLs with cacheability PAGE not allowed");
            }
        }
        else
        {
            throw new IllegalArgumentException("Unknown cacheLevel: "+cacheLevel);
        }
        urlProvider.setCacheability(cacheLevel);
    }

    public void setResourceID(String resourceID)
    {
        urlProvider.setResourceID(resourceID);
    }        
}
