/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
/* 

 */

package org.apache.pluto.factory;

import javax.portlet.*;

import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.om.entity.PortletEntity;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.services.factory.FactoryManager;

public class PortletObjectAccess {

    public static RenderRequest getRenderRequest(PortletWindow portletWindow,
                                                 javax.servlet.http.HttpServletRequest servletRequest,
                                                 javax.servlet.http.HttpServletResponse servletResponse)
    {
        return getRequestFactory().getRenderRequest(portletWindow,
                                                    servletRequest,
                                                    servletResponse);
    }

    public static RenderResponse getRenderResponse(PortletWindow portletWindow,
                                                   javax.servlet.http.HttpServletRequest servletRequest,
                                                   javax.servlet.http.HttpServletResponse servletResponse)
    {
        return getResponseFactory().getRenderResponse(portletWindow,
                                                      servletRequest,
                                                      servletResponse);
    }

    public static PortletSession getPortletSession(PortletWindow portletWindow,
                                                   javax.servlet.http.HttpSession httpSession)
    {
        return getSessionFactory().getPortletSession(portletWindow,
                                                     httpSession);
    }

    public static PortletConfig getPortletConfig(javax.servlet.ServletConfig servletConfig,
                                                 PortletContext portletContext,
                                                 PortletDefinition portletDefinition)
    {
        return getConfigFactory().getPortletConfig(servletConfig,
                                                   portletContext,
                                                   portletDefinition);
    }

    public static PortletContext getPortletContext(javax.servlet.ServletContext servletContext,
                                                   PortletApplicationDefinition portletApplicationDefinition)
    {
        return getContextFactory().getPortletContext(servletContext, 
                                                     portletApplicationDefinition);
    }

    public static ActionRequest getActionRequest(PortletWindow portletWindow,
                                                 javax.servlet.http.HttpServletRequest servletRequest,
                                                 javax.servlet.http.HttpServletResponse servletResponse)
    {
        return getActionRequestFactory().getActionRequest(portletWindow,
                                                          servletRequest,
                                                          servletResponse);
    }

    public static ActionResponse getActionResponse(PortletWindow portletWindow,
                                                   javax.servlet.http.HttpServletRequest servletRequest,
                                                   javax.servlet.http.HttpServletResponse servletResponse)
    {
        return getActionResponseFactory().getActionResponse(portletWindow,
                                                            servletRequest,
                                                            servletResponse);
    } 

    public static PortletURL getPortletURL(PortletWindow portletWindow,
                                           javax.servlet.http.HttpServletRequest servletRequest,
                                           javax.servlet.http.HttpServletResponse servletResponse)
    {
        return getPortletURL(portletWindow, servletRequest, servletResponse, false);
    }

    public static PortletURL getPortletURL(PortletWindow portletWindow,
                                           javax.servlet.http.HttpServletRequest servletRequest,
                                           javax.servlet.http.HttpServletResponse servletResponse,
                                           boolean isAction)
    {
        return getPortletURLFactory().getPortletURL(portletWindow,
                                                    servletRequest,
                                                    servletResponse,
                                                    isAction);
    }

    public static PortalContext getPortalContext()
    {
        return getPortalContextFactory().getPortalContext();
    }

    public static PortletPreferences getPortletPreferences(Integer methodId, PortletEntity portletEntity)
    {
        return getPortletPreferencesFactory().getPortletPreferences(methodId, portletEntity);
    }

    public static PortletPreferences getPortletPreferences(Integer methodId, PortletDefinition portletDefinition)
    {
        return getPortletPreferencesFactory().getPortletPreferences(methodId, portletDefinition);
    }

    private static RenderRequestFactory getRequestFactory()
    {
        return (RenderRequestFactory)FactoryManager.getFactory(javax.portlet.RenderRequest.class);
    }

    private static RenderResponseFactory getResponseFactory()
    {
        return (RenderResponseFactory)FactoryManager.getFactory(javax.portlet.RenderResponse.class);
    }

    private static PortletSessionFactory getSessionFactory()
    {
        return (PortletSessionFactory)FactoryManager.getFactory(javax.portlet.PortletSession.class);
    }

    private static PortletConfigFactory getConfigFactory()
    {
        return (PortletConfigFactory)FactoryManager.getFactory(javax.portlet.PortletConfig.class);
    }

    private static PortletContextFactory getContextFactory()
    {
        return (PortletContextFactory)FactoryManager.getFactory(javax.portlet.PortletContext.class);
    }

    private static ActionRequestFactory getActionRequestFactory()
    {
        return (ActionRequestFactory)FactoryManager.getFactory(javax.portlet.ActionRequest.class);
    }

    private static ActionResponseFactory getActionResponseFactory()
    {
        return (ActionResponseFactory)FactoryManager.getFactory(javax.portlet.ActionResponse.class);
    }

    private static PortletURLFactory getPortletURLFactory()
    {
        return (PortletURLFactory)FactoryManager.getFactory(javax.portlet.PortletURL.class);
    }

    private static PortalContextFactory getPortalContextFactory()
    {
        return (PortalContextFactory)FactoryManager.getFactory(javax.portlet.PortalContext.class);
    }

    private static PortletPreferencesFactory getPortletPreferencesFactory()
    { 
        return (PortletPreferencesFactory)FactoryManager.getFactory(javax.portlet.PortletPreferences.class);
    }
}
