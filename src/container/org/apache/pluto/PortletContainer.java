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

package org.apache.pluto;

import java.util.Properties;
import java.io.IOException;

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
 * <P>
 * The methods of this class have to be called in the following order:
 * <UL>
 * <LI>only once</LI>
 *   <UL>
 *   <LI>init</LI>
 *   <LI>destroy</LI>
 *   </UL>
 * <LI>for each request</LI>
 *   <UL>
 *   <LI>renderPortlet (for each portlet)</LI>
 *   </UL>
 * <LI>optional for each request</LI>
 *   <UL>
 *   <LI>processPortletAction (for portlet receiving the action request)</LI>
 *   </UL>
 * </UL>
 * 

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
     * @param request  the servlet request
     * @param response the servlet response
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
