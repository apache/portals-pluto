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

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.Event;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.StateAwareResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.xml.namespace.QName;

import org.apache.pluto.container.PortletStateAwareResponseContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.util.ArgumentUtility;

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
        if (isPublicRenderParameter(name))
        {
            responseContext.getPublicRenderParameters().put(name, null);
            responseContext.getRenderParameters().remove(name);
        }
    }

	public void setEvent(QName qname, Serializable value)
	{
        ArgumentUtility.validateNotNull("qname", qname);
        Event event = responseContext.getEventProvider().createEvent(qname, value);
        if (event != null)
        {
            responseContext.getEvents().add(event);
        }
	}

	public void setEvent(String name, Serializable value)
	{
	    PortletWindow window = getPortletWindow();
        String defaultNamespace;
        defaultNamespace = window.getPortletDefinition().getApplication().getDefaultNamespace();
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
        checkSetStateChanged();
        
        responseContext.getRenderParameters().clear();
        for (Iterator<Map.Entry<String,String[]>> iter = responseContext.getPublicRenderParameters().entrySet().iterator(); iter.hasNext();)
        {
            if (iter.next().getValue() != null)
            {
                iter.remove();
            }
        }
        for (Map.Entry<String,String[]> entry : parameters.entrySet())
        {
            String[] values = cloneParameterValues(entry.getValue());
            responseContext.getRenderParameters().put(entry.getKey(), values);
            if (isPublicRenderParameter(entry.getKey()))
            {
                responseContext.getPublicRenderParameters().put(entry.getKey(), values);
            }
        }
    }
    
    public void setRenderParameter(String key, String value)
    {
        ArgumentUtility.validateNotEmpty("key", key);
        ArgumentUtility.validateNotNull("value", value);
        checkSetStateChanged();
        String[] values = new String[]{value};
        responseContext.getRenderParameters().put(key, values);
        if (isPublicRenderParameter(key))
        {
            responseContext.getPublicRenderParameters().put(key, values);
        }
    }
    
    public void setRenderParameter(String key, String[] values)
    {
        ArgumentUtility.validateNotEmpty("key", key);
        ArgumentUtility.validateNotNull("values", values);
        values = cloneParameterValues(values);
        if (values == null )            
        {
            throw new IllegalStateException("Illegal Argument: values array is empty or contains only null values");
        }
        checkSetStateChanged();
        responseContext.getRenderParameters().put(key, values);
        if (isPublicRenderParameter(key))
        {
            responseContext.getPublicRenderParameters().put(key, values);
        }
    }
}
