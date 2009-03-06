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

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortalContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletSecurityException;
import javax.portlet.PortletURL;
import javax.portlet.ResourceURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.apache.pluto.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.portlet.Supports;
import org.apache.pluto.spi.PortletURLListener;
import org.apache.pluto.spi.PortletURLProvider;
import org.apache.pluto.spi.optional.PortletResponseContext;
import org.apache.pluto.util.ArgumentUtility;

/**
 * Refactoring where functionality was pushed into JSR-286 <code>BaseURL</code>.
 *
 * @since 2.0
 */
public class PortletURLImpl implements PortletURL, ResourceURL {

    private PortletResponseContext responseContext;
    private PortalContext portalContext;
    private PortletURLProvider urlProvider;
    private String cacheLevel;
    private boolean filtering;
    
    public PortletURLImpl(PortletResponseContext responseContext, boolean actionURL, boolean resourceURL)
    {
        this.responseContext = responseContext;
        this.portalContext = responseContext.getContainer().getRequiredContainerServices().getPortalContext();
        // TODO: actionURL/resourceURL parameters
        urlProvider = responseContext.getContainer().getRequiredContainerServices().getPortalCallbackService().getPortletURLProvider(responseContext.getServletRequest(), responseContext.getPortletWindow());
    }
    
    public PortletURLImpl(PortletResponseContext responseContext, boolean actionURL, boolean resourceURL, String cacheLevel)
    {
        this(responseContext, actionURL, resourceURL);
        this.cacheLevel = cacheLevel == null ? ResourceURL.PAGE : cacheLevel;
    }

    private boolean isPortletModeAllowed(PortletMode mode)
    {
        return isPortletModeAllowedByPortlet(mode) && isPortletModeAllowedByPortal(mode);
    }

    private boolean isPortletModeAllowedByPortlet(PortletMode mode) 
    {
        if(PortletMode.VIEW.equals(mode))
        {
            return true;
        }

        PortletDefinition dd = responseContext.getPortletWindow().getPortletEntity().getPortletDefinition();

        for (Supports sup : dd.getSupports())
        {
            for (String m : sup.getPortletModes())
            {
                if (m.equalsIgnoreCase(mode.toString())) 
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPortletModeAllowedByPortal(PortletMode mode) 
    {
        Enumeration<PortletMode> supportedModes = portalContext.getSupportedPortletModes();
        while (supportedModes.hasMoreElements()) 
        {
            if (supportedModes.nextElement().toString().equalsIgnoreCase(
                    (mode.toString()))) 
            {
                return true;
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
        
    private static String[] cloneParameterValues(String[] values)
    {
        int count = 0;
        for (String s : values)
        {
            if (!(s == null || s.length() == 0))
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
                if (!(s == null || s.length() == 0))
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
    
    private void filterURL()
    {
        if (filtering)
        {
            throw new IllegalStateException("Calling PortletURL toString or write methods from a PortletURLGenerationListener not allowed");
        }
        filtering = true;
        try
        {
            PortletURLListener portletURLFilterListener = responseContext.getContainer()
            .getRequiredContainerServices()
            .getPortalCallbackService().getPortletURLListener();
            PortletApplicationDefinition portletApp = responseContext.getPortletWindow().getPortletEntity().getPortletDefinition().getApplication();
            portletURLFilterListener.callListener(portletApp, this, urlProvider.isActionURL(), urlProvider.isResourceURL());

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
        Map<String, String[]> parameters = urlProvider.getRenderParameters();
        if (value == null )            
        {
            parameters.remove(name);
        }
        else
        {
            parameters.put(name, new String[]{value});
            urlProvider.getRemovedPublicRenderParameters().remove(name);
        }
    }

    public void setParameter(String name, String[] values)
    {
        ArgumentUtility.validateNotEmpty("name", name);
        Map<String, String[]> parameters = urlProvider.getRenderParameters();
        values = cloneParameterValues(values);
        if (values == null )            
        {
            parameters.remove(name);
        }
        else
        {
            parameters.put(name, values);
            urlProvider.getRemovedPublicRenderParameters().remove(name);
        }
    }

    public void setParameters(Map<String, String[]> parameters)
    {
        ArgumentUtility.validateNotNull("parameters", parameters);
        
        // validate map first
        for (Map.Entry<? extends Object, ? extends Object> entry : parameters.entrySet())
        {
            if (entry.getKey() == null || entry.getValue() == null)
            {
                throw new IllegalArgumentException("RenderParameters contains a null key or value entry");
            }
            if (!(entry.getKey() instanceof String))
            {
                throw new IllegalArgumentException("RenderParameters contains a key which is not of type String");
            }
            if (!(entry.getValue() instanceof String[]))
            {
                throw new IllegalArgumentException("RenderParameters contains a value which is not of type String[]");
            }
        }
        Map<String, String[]> map = urlProvider.getRenderParameters();
        map.clear();
        for (Map.Entry<String,String[]> entry : parameters.entrySet())
        {
            String[] values = cloneParameterValues(entry.getValue());
            if (values != null)
            {
                map.put(entry.getKey(), values);
                urlProvider.getRemovedPublicRenderParameters().remove(entry.getKey());
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
        filterURL();
        urlProvider.write(out);
    }
    
    public String toString()
    {
        filterURL();
        return urlProvider.toString();
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
        urlProvider.getRemovedPublicRenderParameters().add(name);
        urlProvider.getRenderParameters().remove(name);
    }

    // ResourceURL impl ------------------------------------------------------------    
    
    public String getCacheability()
    {
        String cacheability = urlProvider.getCacheability();
        return cacheability == null ? this.cacheLevel : cacheability;
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
            if (FULL.equals(cacheLevel))
            {
                throw new IllegalStateException("Current Cachelevel is FULL: URLs with cacheability PORTLET not allowed");
            }
            
        }
        else if (PAGE.equals(cacheLevel))
        {
            if (FULL.equals(cacheLevel))
            {
                throw new IllegalStateException("Current Cachelevel is FULL: URLs with cacheability PORTLET not allowed");
            }
            else if (PORTLET.equals(cacheLevel))
            {
                throw new IllegalStateException("Current Cachelevel is PORTLET: URLs with cacheability PAGE not allowed");
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
