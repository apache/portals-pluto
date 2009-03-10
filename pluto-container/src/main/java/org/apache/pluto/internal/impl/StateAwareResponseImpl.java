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

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.Event;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.StateAwareResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.xml.namespace.QName;

import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.spi.PortalCallbackService;
import org.apache.pluto.container.spi.optional.PortletStateAwareResponseContext;
import org.apache.pluto.util.ArgumentUtility;

/**
 * Implementation of JSR-286 <code>StateAwareResponse</code>.
 *
 * @since 2.0
 */
public abstract class StateAwareResponseImpl extends PortletResponseImpl implements StateAwareResponse
{
    private PortletStateAwareResponseContext responseContext;
    
	public StateAwareResponseImpl(PortletStateAwareResponseContext responseContext)
	{
		super(responseContext);
		this.responseContext = responseContext;
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
	
	protected abstract void checkSetStateChanged();
	
    protected boolean isWindowStateAllowed(WindowState state)
    {
        Enumeration<WindowState> supportedStates = getPortalContext().getSupportedWindowStates();
        while (supportedStates.hasMoreElements()) {
            if (supportedStates.nextElement().equals(state))
            {
                return true;
            }
        }
        return false;
    }
    
    public PortletMode getPortletMode()
    {
        return responseContext.getPortletMode();
    }

    public Map<String, String[]> getRenderParameterMap()
    {
        Map<String, String[]> parameters = new HashMap<String, String[]>(responseContext.getRenderParameters());
        for (Map.Entry<String,String[]> entry : parameters.entrySet())
        {
            entry.setValue(entry.getValue().clone());
        }
        return parameters;
    }
    
    public WindowState getWindowState()
    {
        return responseContext.getWindowState();
    }
    
    public void removePublicRenderParameter(String name)
    {
        ArgumentUtility.validateNotEmpty("name", name);
        checkSetStateChanged();
        responseContext.getRemovedPublicRenderParameters().add(name);
        responseContext.getRenderParameters().remove(name);
    }

	public void setEvent(QName qname, Serializable value)
	{
        ArgumentUtility.validateNotNull("qname", qname);
        PortalCallbackService callback = getPortletContainer().getRequiredContainerServices().getPortalCallbackService();
		Event event = callback.getEventProvider(getServletRequest(),getPortletWindow()).createEvent(qname, value);
		responseContext.getEvents().add(event);
	}

	public void setEvent(String name, Serializable value)
	{
	    PortletWindow window = getPortletWindow();
        String defaultNamespace;
        defaultNamespace = window.getPortletEntity().getPortletDefinition().getApplication().getDefaultNamespace();
        QName qname = new QName(defaultNamespace, name);
        setEvent(qname, value);
	}

    public void setPortletMode(PortletMode portletMode) throws PortletModeException 
    {
        ArgumentUtility.validateNotNull("portletMode", portletMode);
        if (isPortletModeAllowed(portletMode))
        {
            checkSetStateChanged();
            responseContext.setPortletMode(portletMode);
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
            checkSetStateChanged();
            responseContext.setWindowState(windowState);
        }
        else 
        {
            throw new WindowStateException("Can't set this WindowState", windowState);
        }
    }
	    
    public void setRenderParameters(java.util.Map<String, String[]> parameters)
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
        checkSetStateChanged();
        Map<String, String[]> map = responseContext.getRenderParameters();
        map.clear();
        for (Map.Entry<String,String[]> entry : parameters.entrySet())
        {
            String[] values = cloneParameterValues(entry.getValue());
            if (values != null)
            {
                map.put(entry.getKey(), values);
                responseContext.getRemovedPublicRenderParameters().remove(entry.getKey());
            }
        }
    }
    
    public void setRenderParameter(String key, String value)
    {
        ArgumentUtility.validateNotEmpty("key", key);
        
        checkSetStateChanged();
        if (value == null || value.length() == 0)
        {
            responseContext.getRenderParameters().remove(key);
        }
        else
        {
            responseContext.getRenderParameters().put(key, new String[]{value});
            responseContext.getRemovedPublicRenderParameters().remove(key);
        }
    }
    
    public void setRenderParameter(String key, String[] values)
    {
        ArgumentUtility.validateNotEmpty("key", key);
        ArgumentUtility.validateNotNull("values", values);
        String[] copy = cloneParameterValues(values);
        checkSetStateChanged();
        if (copy == null)
        {
            responseContext.getRenderParameters().remove(key);
        }
        else
        {
            responseContext.getRenderParameters().put(key, copy);
            responseContext.getRemovedPublicRenderParameters().remove(key);
        }
    }
}
