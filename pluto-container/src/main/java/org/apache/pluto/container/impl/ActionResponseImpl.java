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

import javax.portlet.ActionResponse;

import org.apache.pluto.container.PortletActionResponseContext;
import org.apache.pluto.container.ResourceURLProvider;
import org.apache.pluto.container.util.ArgumentUtility;

public class ActionResponseImpl extends StateAwareResponseImpl implements ActionResponse
{
    private boolean stateChanged;
    protected boolean redirected;
    
    public ActionResponseImpl(PortletActionResponseContext responseContext)
    {
        super(responseContext);
    }

    protected void checkSetRedirected()
    {
        if (stateChanged)
        {
            throw new IllegalStateException("sendRedirect no longer allowed after navigational state changes");
        }
        if (redirected)
        {
            throw new IllegalStateException("sendRedirect already called");
        }
        redirected = true;
    }
    
    protected void checkSetStateChanged()
    {
        if (redirected)
        {
            throw new IllegalStateException("State change no longer allowed after a sendRedirect");
        }
        stateChanged = true;
    }
    
    protected String getRedirectLocation(String location)
    {
        ArgumentUtility.validateNotEmpty("location", location);
        ResourceURLProvider provider = getResponseContext().getResourceURLProvider();

        if (location.indexOf("://") != -1)
        {
            provider.setAbsoluteURL(location);
        } 
        else 
        {
            provider.setFullPath(location);
        }
        location = getServletResponse().encodeRedirectURL(provider.toString());
        if (location.indexOf("/") == -1)
        {
            throw new IllegalArgumentException("There is a relative path given, an IllegalArgumentException must be thrown.");
        }
        return location;
    }
    
    public void sendRedirect(String location) throws IOException
    {
        location = getRedirectLocation(location);
        checkSetRedirected();
        ((PortletActionResponseContext)getResponseContext()).setRedirect(location);
    }
    
	public void sendRedirect(String location, String renderUrlParamName) throws IOException 
	{
        ArgumentUtility.validateNotEmpty("renderUrlParamName", renderUrlParamName);
        location = getRedirectLocation(location);
        if (!redirected)
        {
            stateChanged = false;
        }
        checkSetRedirected();
        ((PortletActionResponseContext)getResponseContext()).setRedirect(location, renderUrlParamName);
	}
}
