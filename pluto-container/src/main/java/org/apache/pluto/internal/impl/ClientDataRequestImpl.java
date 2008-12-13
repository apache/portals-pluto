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
import java.io.InputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.portlet.ClientDataRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.util.ArgumentUtility;

/**
 * Implementation of the <code>javax.portlet.ClientDataRequest</code> interface.
 */
public abstract class ClientDataRequestImpl extends PortletRequestImpl
        implements ClientDataRequest
{

    /** Logger. */
    private static final Log LOG = LogFactory
            .getLog(ClientDataRequestImpl.class);

    public ClientDataRequestImpl(PortletContainer container,
            PortletWindow portletWindow, HttpServletRequest servletRequest)
    {
        super(container, portletWindow, servletRequest);
    }

    public InputStream getPortletInputStream() throws IOException
    {
        HttpServletRequest servletRequest = (HttpServletRequest) getRequest();
        if (servletRequest.getMethod().equals("POST"))
        {
            String contentType = servletRequest.getContentType();
            if (contentType == null
                    || contentType.equals("application/x-www-form-urlencoded")) { throw new IllegalStateException(
                    "User request HTTP POST data is of type "
                            + "application/x-www-form-urlencoded. "
                            + "This data has been already processed "
                            + "by the portal/portlet-container and is available "
                            + "as request parameters."); }
        }
        return servletRequest.getInputStream();
    }

    public void setCharacterEncoding(String encoding)
            throws java.io.UnsupportedEncodingException
    {
        super.setCharacterEncoding(encoding);
    }

    public java.io.BufferedReader getReader()
            throws java.io.UnsupportedEncodingException, java.io.IOException
    {
        return super.getReader();
    }

    public java.lang.String getCharacterEncoding()
    {
        return super.getCharacterEncoding();
    }

    public java.lang.String getContentType()
    {
        return super.getContentType();
    }

    public int getContentLength()
    {
        return super.getContentLength();
    }

    public String getMethod()
    {
        return super.getMethod();
    }

    @Override
    public String getParameter(String name)
    {
        ArgumentUtility.validateNotNull("parameterName", name);
        String[] values  = null;
        if (parameters != null)
        {
            values = parameters.get(name);
        }
        else
        {
            values = mergeParameters().get(name);
        }
        if (values != null && values.length > 0) 
        {
            return values[0];
        } 
        return null;
    }
    
    @Override
    public Enumeration<String> getParameterNames() 
    {
        if (parameters != null)
        {
            return Collections.enumeration(parameters.keySet());
        }
        return Collections.enumeration(mergeParameters().keySet());
    }
    

    @Override
    public Map<String, String[]> getParameterMap()
    {
        if (parameters != null)
        {
            return parameters;
        }
        return Collections.unmodifiableMap(mergeParameters());
    }

    @Override
    public String[] getParameterValues(String name)
    {
        ArgumentUtility.validateNotNull("parameterName", name);
        String[] values  = null;
        if (parameters != null)
        {
            values = parameters.get(name);
        }
        else
        {
            values = mergeParameters().get(name);
        }
        return values;
    }

    /**
     * Iterate over the private and the public parameter list and merge it.
     * 
     * @return merged list
     */
    private Map<String, String[]> mergeParameters()
    {
        Map<String, String[]> mergedParameterMap = new HashMap<String, String[]>();
        // Put the private list first into the map, because it is required, this
        // parameters are the first in the value array.
        if (super.getPrivateParameterMap() != null)
            mergedParameterMap.putAll(super.getPrivateParameterMap());
        Map<String, String[]> publicParameterMap = super
                .getPublicParameterMap();
         //Iterate over the public parameter list
        if (publicParameterMap != null)
        {
            Set keySet = publicParameterMap.keySet();
            if (keySet != null)
            {
                Iterator<String> iterator = keySet.iterator();
                while (iterator.hasNext())
                {
                    String name = iterator.next();
                     //tests if the name already exist
                    if (mergedParameterMap.containsKey(name))
                    {
                        String[] tmp = mergedParameterMap.get(name);
                        String[] tmp2 = publicParameterMap.get(name);
                        String[] values = new String[tmp.length + tmp2.length];
                        int length = tmp.length;
                        for (int i = 0; i < length; i++)
                        {
                            values[i] = tmp[i];
                        }
                        for (int i = 0; i < tmp2.length; i++)
                        {
                            values[i + length] = tmp2[i];
                        }
                        mergedParameterMap.put(name, values);
                    }
                    else
                    {
                        mergedParameterMap.put(name, publicParameterMap
                                .get(name));
                    }
                }
            }
        }
        this.parameters = mergedParameterMap;
        return this.parameters;
    }

}
