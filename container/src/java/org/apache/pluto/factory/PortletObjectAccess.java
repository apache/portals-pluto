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
