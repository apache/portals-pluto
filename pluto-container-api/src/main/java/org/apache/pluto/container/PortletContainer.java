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
package org.apache.pluto.container;

import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The publicized entry point into Pluto. The base functionality of the portlet
 * container can be enhanced or even modified by PortletContainerServices.
 * <p/>
 * <P> The methods of this class have to be called in the following order:
 * <TABLE> <TR><TH>Method</TH><TH>Description</TH><TH>Constraints</TH></TR>
 * <TR><TD>{@link #init()}</TD> <TD>Initialized the
 * portlet container.</TD> <TD>Performed only once per container
 * lifecycle.</TD></TR>
 * <p/>
 * <TR><TD>{@link #doAction(PortletWindow,
 * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}</TD>
 * <TD>Perform the action for the targeted portlet</TD> <TD>Optionally performed
 * for a single portlet per request</TD></TR>
 * <p/>
 * <TR><TD>{@link #doRender(PortletWindow,
 * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}</TD>
 * <TD>Render the portlet</TD> <TD>Performed once for each portlet per
 * request.</TD></TR>
 * <p/>
 * <TR><TD>{@link #destroy()}</TD> <TD>Destroy and remove container from
 * service.</TD> <TD>Performed only once per container lifecylce</TD></TR>
 */
public interface PortletContainer {

    /**
     * Initializes the container
     * @throws PortletContainerException if an error occurs.
     */
    void init() throws PortletContainerException;

    /**
     * Shuts down the container. After calling this method it is no longer valid
     * to call any method on the portlet container.
     * @throws PortletContainerException if an error occurs while shutting down
     *                                   the container
     */
    void destroy() throws PortletContainerException;

    /**
     * Calls the render method of the given portlet window.
     * @param portletWindow the portlet Window
     * @param request               the servlet request
     * @param response              the servlet response
     * @throws PortletException          if one portlet has trouble fulfilling
     *                                   the request
     * @throws IOException               if the streaming causes an I/O problem
     * @throws PortletContainerException if the portlet container implementation
     *                                   has trouble fulfilling the request
     */
    void doRender(PortletWindow portletWindow,
            HttpServletRequest request,
            HttpServletResponse response)
    throws PortletException, IOException, PortletContainerException;

    /**
     * Indicates that a portlet resource Serving occured in the current request and calls
     * the processServeResource method of this portlet.
     * @param portletWindow the portlet Window
     * @param request               the servlet request
     * @param response              the servlet response
     * @throws PortletException          if one portlet has trouble fulfilling
     *                                   the request
     * @throws PortletContainerException if the portlet container implementation
     *                                   has trouble fulfilling the request
     */
    void doServeResource(PortletWindow portletWindow,
            HttpServletRequest request,
            HttpServletResponse response)
    throws PortletException, IOException, PortletContainerException;

    /**
     * Indicates that a portlet action occured in the current request and calls
     * the processAction method of this portlet.
     * @param portletWindow the portlet Window
     * @param request               the servlet request
     * @param response              the servlet response
     * @throws PortletException          if one portlet has trouble fulfilling
     *                                   the request
     * @throws PortletContainerException if the portlet container implementation
     *                                   has trouble fulfilling the request
     */
    void doAction(PortletWindow portletWindow,
            HttpServletRequest request,
            HttpServletResponse response)
    throws PortletException, IOException, PortletContainerException;

    /**
     * Indicates that the portlet must be initialized
     * @param portletWindow the portlet Window
     * @param servletRequest        the servlet request
     * @param servletResponse       the servlet response
     * @throws PortletException          if one portlet has trouble fulfilling
     *                                   the request
     * @throws PortletContainerException if the portlet container implementation
     *                                   has trouble fulfilling the request
     */
    void doLoad(PortletWindow portletWindow,
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse)
    throws PortletException, IOException, PortletContainerException;

    /**
     * Indicates that the portal needs to perform administrative
     * actions upon the portlet and/or portlet application.  An
     * administrative request will be spawned and any registered
     * handlers invoked.
     * @param portletWindow   the portlet window
     * @param servletRequest  the servlet request
     * @param servletResponse the servlet response
     * @throws PortletException          if one portlet has trouble fulfilling
     *                                   the request
     * @throws PortletContainerException if the portlet container implementation
     *                                   has trouble fulfilling the request
     */
    void doAdmin(PortletWindow portletWindow,
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse)
    throws PortletException, IOException, PortletContainerException;

    /**
     * Indicates that an event should be fired in the current request and calls
     * the processEvent method of this portlet.
     * @param portletWindow   the portlet Window
     * @param request         the servlet request
     * @param response        the servlet response
     * @param event The event.
     * @throws PortletException          if one portlet has trouble fulfilling
     *                                   the request
     * @throws PortletContainerException if the portlet container implementation
     *                                   has trouble fulfilling the request
     */
    public void doEvent(PortletWindow portletWindow,
            HttpServletRequest request,
            HttpServletResponse response,
            Event event)
    throws PortletException, IOException, PortletContainerException;

    /**
     * Returns whether the container is already initialized or not.
     * @return <code>true</code> if the container is initialized
     */
    boolean isInitialized();

    /**
     * Retrieve the unique container name
     * @return the container name.
     */
    String getName();

    /**
     * Retreive the container services associated with this container.
     * @return the container services associated with this container.
     */
    ContainerServices getContainerServices();
}
