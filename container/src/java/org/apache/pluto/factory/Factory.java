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
package org.apache.pluto.factory;

/**
 * <p>
 * This interface defines portal/container factories and their life-cycle.
 * A Pluto defines the interfaces for the factories, and the portal implements the factory.
 * A portal's factory implementation must be a derivative from this interface and implement the
 * <CODE>init()</CODE> and <CODE>destroy()</CODE> methods to meet Pluto's factory contract.
 * Factories create the shared classes between the portal and Pluto container.
 * Implementations are created by portal provided factories. Many of the classes created by the factories
 * are the implementations of the Java Portlet API interfaces.
 * <p>
 * Factory Managed Interfaces per Pluto requirements:
 * <p>
 * <a href='http://www.bluesunrise.com/portlet-api/javax/portlet/ActionRequest.html'>javax.portlet.ActionRequest</a><br>
 * <a href='http://www.bluesunrise.com/portlet-api/javax/portlet/ActionResponse.html'>javax.portlet.ActionResponse</a><br>
 * <a href='http://www.bluesunrise.com/portlet-api/javax/portlet/RenderRequest.html'>javax.portlet.RenderRequest</a><br>
 * <a href='http://www.bluesunrise.com/portlet-api/javax/portlet/RenderResponse.html'>javax.portlet.RenderResponse</a><br>
 * <a href='http://www.bluesunrise.com/portlet-api/javax/portlet/PortletSession.html'>javax.portlet.PortletSession</a><br>
 * <a href='http://www.bluesunrise.com/portlet-api/javax/portlet/PortletConfig.html'>javax.portlet.PortletConfig</a><br>
 * <a href='http://www.bluesunrise.com/portlet-api/javax/portlet/PortletContext.html'>javax.portlet.PortletContext</a><br>
 * <a href='http://www.bluesunrise.com/portlet-api/javax/portlet/PortletPreferences.html'>javax.portlet.PortletPreferences</a><br>
 * <a href='http://www.bluesunrise.com/portlet-api/javax/portlet/PortalContext.html'>javax.portlet.PortalContext</a><br>
 * <a href='http://www.bluesunrise.com/portlet-api/javax/portlet/PortletURL.html'>javax.portlet.PortletURL</a><br>
 * <a href='http://www.bluesunrise.com/portlet-api/javax/portlet/PortletPreferences.html'>javax.portlet.PortletPreferences</a><br>
 * <a href='http://www.bluesunrise.com/portlet-api/javax/portlet/PreferencesValidator.html'>javax.portlet.PreferencesValidator</a><br>
 * <a href='http://java.sun.com/products/servlet/2.3/javadoc/javax/servlet/http/HttpServletRequest.html'>javax.servlet.http.HttpServletRequest</a><br>
 * <a href='http://java.sun.com/products/servlet/2.3/javadoc/javax/servlet/http/HttpServletResponse.html'>javax.servlet.http.HttpServletResponse</a><br>
 * <a href='hhttp://portals.apache.org/pluto/multiproject/pluto/apidocs/org/apache/pluto/invoker/PortletInvoker.html'>org.apache.pluto.invoker.PortletInvoker</a><br>
 * <a href='http://portals.apache.org/pluto/multiproject/pluto/apidocs/org/apache/pluto/util/NamespaceMapper.html'>org.apache.pluto.util.NamespaceMapper</a><br>
 * <a href='http://portals.apache.org/pluto/multiproject/pluto/apidocs/org/apache/pluto/om/ControllerFactory.html'>org.apache.pluto.om.ControllerFactory</a><br>
 * <p>
 * Pluto Service Providers
 * <p>
 * <a href='http://portals.apache.org/pluto/multiproject/pluto/apidocs/org/apache/pluto/services/information/StaticInformationProvider.html'>org.apache.pluto.services.information.InformationProviderService</a><br>
 * <a href='http://portals.apache.org/pluto/multiproject/pluto/apidocs/org/apache/pluto/services/information/DynamicInformationProvider.html'>org.apache.pluto.services.information.DynamicInformationProvider</a><br>
 * <a href='http://portals.apache.org/pluto/multiproject/pluto/apidocs/org/apache/pluto/services/information/PortletActionProvider.html'>org.apache.pluto.services.information.PortletActionProvider</a><br>
 * <a href='http://portals.apache.org/pluto/multiproject/pluto/apidocs/org/apache/pluto/services/information/PortalContextProvider.html'>org.apache.pluto.services.information.PortalContextProvider</a><br>
 *
 * @version $Id$
 */
public interface Factory
{


    /**
     * Initializes the factory using the servlet configuration
     * and the factory properties.
     *
     * @param   config
     *          the servlet configuration
     * @param   properties
     *          the factory properties
     *
     * @throws   Exception
     *           if the initialization fails
     */
    public void init(javax.servlet.ServletConfig config,
                     java.util.Map properties) throws Exception;

    /**
     * Destroys the factory. This method allows the service
     * to cleanup any resources.
     *
     * @throws   Exception
     *           if the destruction fails
     */
    public void destroy() throws Exception;

}
