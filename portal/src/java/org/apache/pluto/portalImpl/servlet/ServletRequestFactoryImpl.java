/*
 * Copyright 2003,2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* 

 */

package org.apache.pluto.portalImpl.servlet;

import javax.servlet.http.HttpServletRequest;
import org.apache.pluto.om.window.PortletWindow;

public class ServletRequestFactoryImpl implements ServletRequestFactory
{

    // ServletRequestFactory implementation.

    public HttpServletRequest getServletRequest(HttpServletRequest request, PortletWindow portletWindow)
    {
        HttpServletRequest servletRequest = new ServletRequestImpl(request, portletWindow);
        return servletRequest;
    }

    // additional methods.    
    public void init(javax.servlet.ServletConfig config, java.util.Map properties) 
    throws Exception
    {
        // nothing to do
    }
    
    public void destroy()
    throws Exception
    {
        // nothing to do
    }

}
