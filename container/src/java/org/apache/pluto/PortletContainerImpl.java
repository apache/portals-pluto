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

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.core.InternalActionResponse;
import org.apache.pluto.factory.PortletObjectAccess;
import org.apache.pluto.invoker.PortletInvoker;
import org.apache.pluto.invoker.PortletInvokerAccess;
import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.PortletContainerEnvironment;
import org.apache.pluto.services.information.DynamicInformationProvider;
import org.apache.pluto.services.information.InformationProviderAccess;
import org.apache.pluto.services.information.PortletURLProvider;
import org.apache.pluto.services.log.Log;

/**
 *  

 */
public class PortletContainerImpl implements PortletContainer
{

    private ServletConfig servletConfig;
    private String uniqueContainerName;
    private Properties properties;
    private boolean initialized;

    public void init(String uniqueContainerName,
                     ServletConfig servletConfig,
                     PortletContainerEnvironment environment,
                     Properties properties)
    throws PortletContainerException
    {
        this.servletConfig = servletConfig;
        this.uniqueContainerName = uniqueContainerName;
        PortletContainerServices.createReference(uniqueContainerName, environment);
        this.properties = properties;
        initialized = true;
    }

    public void shutdown() throws PortletContainerException
    {
        PortletContainerServices.destroyReference(uniqueContainerName);
    }


    public void renderPortlet(PortletWindow portletWindow,
                              HttpServletRequest servletRequest,
                              HttpServletResponse servletResponse )
    throws PortletException, IOException, PortletContainerException
    {
        PortletContainerServices.prepare(uniqueContainerName);

        if (Log.isDebugEnabled("org.apache.pluto.invoker"))
        {
            Log.debug("org.apache.pluto.invoker",
                      "PortletContainerImpl.portletService(" + portletWindow.getId() + ") called.");
        }

        try
        {
            RenderRequest renderRequest = PortletObjectAccess.getRenderRequest(portletWindow, 
                                                                               servletRequest, 
                                                                               servletResponse);

            RenderResponse renderResponse = PortletObjectAccess.getRenderResponse(portletWindow, 
                                                                                  servletRequest, 
                                                                                  servletResponse);

            PortletInvoker invoker = PortletInvokerAccess.getPortletInvoker(portletWindow.getPortletEntity().getPortletDefinition());
            invoker.render(renderRequest, renderResponse);
        }
        finally
        {
            PortletContainerServices.release();
        }

    }


    public void processPortletAction(PortletWindow portletWindow,
                                     HttpServletRequest servletRequest,
                                     HttpServletResponse servletResponse)
    throws PortletException, IOException, PortletContainerException
    {
        PortletContainerServices.prepare(uniqueContainerName);

        if (Log.isDebugEnabled("org.apache.pluto.invoker"))
        {
            Log.debug("org.apache.pluto.invoker",
                      "PortletContainerImpl.performPortletAction(" + portletWindow.getId() + ") called.");
        }

        String location = null;

        InternalActionResponse _actionResponse = null;
        ActionRequest actionRequest = null;

        try
        {
            /*ActionRequest*/ 
            actionRequest = 
            PortletObjectAccess.getActionRequest(portletWindow, 
                                                 servletRequest, 
                                                 servletResponse);

            ActionResponse actionResponse = PortletObjectAccess.getActionResponse(portletWindow, 
                                                                                  servletRequest, 
                                                                                  servletResponse);
            PortletInvoker invoker = PortletInvokerAccess.getPortletInvoker(portletWindow.getPortletEntity().getPortletDefinition());

            _actionResponse = (InternalActionResponse)actionResponse;

            // call action() at the portlet
            invoker.action(actionRequest, actionResponse);

            location = _actionResponse.getRedirectLocation();
        }
        catch (PortletException e)
        {
            throw e;
        }
        catch (IOException e)
        {
            throw e;
        }
        catch (RuntimeException e)
        {
            throw e;
        }
        finally
        {
            try
            {
                if (location == null && _actionResponse != null)
                {
                    DynamicInformationProvider provider = InformationProviderAccess.getDynamicProvider(servletRequest);

                    //ToDo: don't send changes in case of exception -> PORTLET:SPEC:17

                    // get the changings of this portlet entity that might be set during action handling
                    // change portlet mode
                    if (_actionResponse.getChangedPortletMode() != null)
                    {
                        InformationProviderAccess.getDynamicProvider(servletRequest).getPortletActionProvider(portletWindow).changePortletMode(_actionResponse.getChangedPortletMode());
                    }
                    // change window state
                    if (_actionResponse.getChangedWindowState() != null)
                    {
                        InformationProviderAccess.getDynamicProvider(servletRequest).getPortletActionProvider(portletWindow).changePortletWindowState(_actionResponse.getChangedWindowState());
                    }
                    // get render parameters
                    Map renderParameter = _actionResponse.getRenderParameters();

                    PortletURLProvider redirectURL = provider.getPortletURLProvider(portletWindow);

                    if (provider.getPortletMode(portletWindow)!=null)
                    {
                        redirectURL.setPortletMode(provider.getPortletMode(portletWindow));
                    }
                    if (provider.getWindowState(portletWindow)!=null)
                    {
                        redirectURL.setWindowState(provider.getWindowState(portletWindow));
                    }
                    //            if (secure)
                    //            {
                    //                redirectURL.setSecure(); // TBD
                    //            }
                    redirectURL.clearParameters();
                    redirectURL.setParameters(renderParameter);

                    //servletResponse.sendRedirect(servletResponse.encodeRedirectURL(redirectURL.toString()));
                    location = servletResponse.encodeRedirectURL(redirectURL.toString());
                }
                //servletResponse.sendRedirect(location);

                javax.servlet.http.HttpServletResponse redirectResponse = servletResponse;
                while (redirectResponse instanceof javax.servlet.http.HttpServletResponseWrapper)
                {
                    redirectResponse = (javax.servlet.http.HttpServletResponse)
                                       ((javax.servlet.http.HttpServletResponseWrapper)redirectResponse).getResponse();
                }
                redirectResponse.sendRedirect(location);
            }
            finally
            {
                PortletContainerServices.release();
            }
        }
    }

    public void portletLoad ( PortletWindow portletWindow,
                              HttpServletRequest servletRequest,
                              HttpServletResponse servletResponse )
    throws PortletException, PortletContainerException
    {
        PortletContainerServices.prepare(uniqueContainerName);

        if (Log.isDebugEnabled("org.apache.pluto.invoker"))
            Log.debug("org.apache.pluto.invoker",
                      "PortletContainerImpl.portletLoad("+portletWindow.getId()+") called.");

        RenderRequest renderRequest = PortletObjectAccess.getRenderRequest(portletWindow, 
                                                                           servletRequest, 
                                                                           servletResponse);

        RenderResponse renderResponse = PortletObjectAccess.getRenderResponse(portletWindow, 
                                                                              servletRequest, 
                                                                              servletResponse);

        PortletInvoker invoker = PortletInvokerAccess.getPortletInvoker(portletWindow.getPortletEntity().getPortletDefinition());

        try
        {
            invoker.load(renderRequest, renderResponse);
        }
        finally
        {
            PortletContainerServices.release();
        }

    }

    public boolean isInitialized()
    {
        return initialized;
    }

}
