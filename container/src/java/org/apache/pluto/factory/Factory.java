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
 * <a href='http://jakarta.apache.org/pluto/apidocs/org/apache/pluto/invoker/PortletInvoker.html'>org.apache.pluto.invoker.PortletInvoker</a><br>
 * <a href='http://jakarta.apache.org/pluto/apidocs/org/apache/pluto/util/NamespaceMapper.html'>org.apache.pluto.util.NamespaceMapper</a><br>
 * <a href='http://jakarta.apache.org/pluto/apidocs/org/apache/pluto/om/ControllerFactory.html'>org.apache.pluto.om.ControllerFactory</a><br>
 * <p>
 * Pluto Service Providers
 * <p>
 * <a href='http://jakarta.apache.org/pluto/apidocs/org/apache/pluto/services/information/StaticInformationProvider.html'>org.apache.pluto.services.information.InformationProviderService</a><br>
 * <a href='http://jakarta.apache.org/pluto/apidocs/org/apache/pluto/services/information/DynamicInformationProvider.html'>org.apache.pluto.services.information.DynamicInformationProvider</a><br>
 * <a href='http://jakarta.apache.org/pluto/apidocs/org/apache/pluto/services/information/PortletActionProvider.html'>org.apache.pluto.services.information.PortletActionProvider</a><br>
 * <a href='http://jakarta.apache.org/pluto/apidocs/org/apache/pluto/services/information/PortalContextProvider.html'>org.apache.pluto.services.information.PortalContextProvider</a><br>
 * 
 * @version $Id: Factory.java,v 1.2 2004/01/08 02:20:16 taylor Exp $
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
