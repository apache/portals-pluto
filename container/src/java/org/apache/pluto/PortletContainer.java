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
package org.apache.pluto;

import java.io.IOException;
import java.util.Properties;

import javax.portlet.PortletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.PortletContainerEnvironment;

/**
 * The <CODE>PortletContainer</CODE> interface is the entrance point of the portlet
 * container. This singleton is normally called by the aggregation in a specific
 * order, meaning that each method of this singleton has to be called in a
 * defined way.<P>
 * The base functionality of the portlet container can be enhanced or even
 * modified by PortletContainerServices.
 *
 * <P>
 * The methods of this class have to be called in the following order:
 * <UL>
 * <LI>only once</LI>
 *   <UL>
 *   <LI>{@link #init(java.lang.String, javax.servlet.ServletConfig, org.apache.pluto.services.PortletContainerEnvironment, java.util.Properties)}</LI>
 *   <LI>{@link #shutdown()}</LI>
 *   </UL>
 * <LI>for each request</LI>
 *   <UL>
 *   <LI>{@link #renderPortlet(org.apache.pluto.om.window.PortletWindow, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)} (for each portlet)</LI>
 *   </UL>
 * <LI>optional for each request</LI>
 *   <UL>
 *   <LI>{@link #processPortletAction(org.apache.pluto.om.window.PortletWindow, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)} (for portlet receiving the action request)</LI>
 *   </UL>
 * </UL>
 * 
 * @version $Id$
 */
public interface PortletContainer
{

    /**
     * Initializes the portlet container.
     * 
     * @param uniqueContainerName container name that must be unqiue across all containers defined within this JVM. This name must be identical across JVMs.
     * @param servletConfig the servlet configuration
     * @param environment the portlet container environment including all services
     * @param properties the portlet container specific properties may vary from container to container
     * @exception PortletContainerException
     *                if an error occurs while initializing the container
     */
    public void init(String uniqueContainerName,
                     ServletConfig servletConfig,
                     PortletContainerEnvironment environment,
                     Properties properties) throws PortletContainerException;

    /**
     * Shuts down the portlet container.
     * After calling this method it is no longer valid to call any method on the portlet container.
     * 
     * @exception PortletContainerException
     *                if an error occurs while shutting down the container
     */
    public void shutdown() throws PortletContainerException;

    /**
     * Calls the render method of the given portlet window.
     * 
     * @param portletWindow
     *                 the portlet Window
     * @param request  the servlet request
     * @param response the servlet response
     * @exception PortletException
     *                   if one portlet has trouble fulfilling the request
     * @exception IOException
     *                   if the streaming causes an I/O problem
     * @exception PortletContainerException
     *                   if the portlet container implementation has trouble fulfilling the request
     */
    public void renderPortlet(PortletWindow portletWindow,
                              HttpServletRequest request,
                              HttpServletResponse response)
    throws PortletException, IOException, PortletContainerException;


    /**
     * Indicates that a portlet action occured in the current request and
     * calls the processAction method of this portlet.
     * 
     * @param portletWindow
     *                 the portlet Window
     * @param request  the servlet request
     * @param response the servlet response
     * @exception PortletException
     *                   if one portlet has trouble fulfilling the request
     * @exception PortletContainerException
     *                   if the portlet container implementation has trouble fulfilling the request
     */
    public void processPortletAction(PortletWindow portletWindow,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
    throws PortletException, IOException, PortletContainerException;

    /**
     * Indicates that the portlet must be initialized
     * 
     * @param portletWindow
     *                 the portlet Window
     * @param servletRequest  the servlet request
     * @param servletResponse the servlet response
     * @exception PortletException
     *                   if one portlet has trouble fulfilling the request
     * @exception PortletContainerException
     *                   if the portlet container implementation has trouble fulfilling the request
     */
    public void portletLoad(PortletWindow portletWindow,
                            HttpServletRequest servletRequest,
                            HttpServletResponse servletResponse )
    throws PortletException, PortletContainerException;

    /**
     * Returns whether the container is already initialized or not.
     * 
     * @return <code>true</code> if the container is initialized
     */
    public boolean isInitialized();
}
