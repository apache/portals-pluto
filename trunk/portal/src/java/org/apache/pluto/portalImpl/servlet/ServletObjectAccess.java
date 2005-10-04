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

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.portalImpl.services.factorymanager.FactoryManager;

public class ServletObjectAccess
{

    public static HttpServletRequest getServletRequest(HttpServletRequest request, PortletWindow portletWindow)
    {
        return getRequestFactory().getServletRequest(request, portletWindow);
    }

    public static HttpServletResponse getServletResponse(HttpServletResponse response)
    {
        return getResponseFactory().getServletResponse(response);
    }

    public static HttpServletResponse getStoredServletResponse(HttpServletResponse response, PrintWriter writer)
    {
        return getResponseFactory().getStoredServletResponse(response, writer);
    }


    private static ServletRequestFactory getRequestFactory()
    {
        return (ServletRequestFactory)FactoryManager.getFactory(javax.servlet.http.HttpServletRequest.class);
    }
    private static ServletResponseFactory getResponseFactory()
    {
        return (ServletResponseFactory)FactoryManager.getFactory(javax.servlet.http.HttpServletResponse.class);
    }
}
