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
import org.apache.pluto.services.log.Logger;
import org.apache.pluto.services.log.LogService;

/**
 *  Implements the Pluto Container.
 * 
 * @version $Id: PortletContainerImpl.java,v 1.7 2004/05/27 11:53:43 cziegeler Exp $
 */
public class PortletContainerImpl implements PortletContainer
{

    private String uniqueContainerName;
    private boolean initialized;

    private Logger log = null;

    public void init(String uniqueContainerName,
                     ServletConfig servletConfig,
                     PortletContainerEnvironment environment,
                     Properties properties)
    throws PortletContainerException
    {
        this.uniqueContainerName = uniqueContainerName;
        PortletContainerServices.createReference(uniqueContainerName, environment);
        initialized = true;

        // Initialize the Logger that we will use
        // from here forward for this Container:
        log = ((LogService)environment
                .getContainerService(LogService.class))
                .getLogger(getClass());
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
        PortletInvoker invoker = null;
        
        if (log.isDebugEnabled())
        {
            log.debug("PortletContainerImpl.portletService(" + portletWindow.getId() + ") called.");
        }

        try
        {
            RenderRequest renderRequest = PortletObjectAccess.getRenderRequest(portletWindow, 
                                                                               servletRequest, 
                                                                               servletResponse);

            RenderResponse renderResponse = PortletObjectAccess.getRenderResponse(portletWindow, 
                                                                                  servletRequest, 
                                                                                  servletResponse);

            invoker = PortletInvokerAccess.getPortletInvoker(portletWindow.getPortletEntity().getPortletDefinition());
            invoker.render(renderRequest, renderResponse);
        }
        finally
        {
            PortletInvokerAccess.releasePortletInvoker(invoker);            
            PortletContainerServices.release();
        }

    }


    public void processPortletAction(PortletWindow portletWindow,
                                     HttpServletRequest servletRequest,
                                     HttpServletResponse servletResponse)
    throws PortletException, IOException, PortletContainerException
    {
        PortletContainerServices.prepare(uniqueContainerName);
        PortletInvoker invoker = null;

        if (log.isDebugEnabled())
        {
            log.debug("PortletContainerImpl.performPortletAction(" + portletWindow.getId() + ") called.");
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
            invoker = PortletInvokerAccess.getPortletInvoker(portletWindow.getPortletEntity().getPortletDefinition());

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
				redirect(location, portletWindow, servletRequest, servletResponse, _actionResponse);
            }
            finally
            {
                PortletInvokerAccess.releasePortletInvoker(invoker);                            
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
        PortletInvoker invoker = null;

        if (log.isDebugEnabled())
            log.debug("PortletContainerImpl.portletLoad("+portletWindow.getId()+") called.");

        RenderRequest renderRequest = PortletObjectAccess.getRenderRequest(portletWindow, 
                                                                           servletRequest, 
                                                                           servletResponse);

        RenderResponse renderResponse = PortletObjectAccess.getRenderResponse(portletWindow, 
                                                                              servletRequest, 
                                                                              servletResponse);

        invoker = PortletInvokerAccess.getPortletInvoker(portletWindow.getPortletEntity().getPortletDefinition());

        try
        {
            invoker.load(renderRequest, renderResponse);
        }
        finally
        {
            PortletInvokerAccess.releasePortletInvoker(invoker);                        
            PortletContainerServices.release();            
        }

    }

    public boolean isInitialized()
    {
        return initialized;
    }

    protected void redirect(String location, 
                              PortletWindow portletWindow, 
                              HttpServletRequest servletRequest, 
                              HttpServletResponse servletResponse, 
                              InternalActionResponse _actionResponse) 
    throws IOException {
	    if (location == null && _actionResponse != null)
	    {
	        DynamicInformationProvider provider = InformationProviderAccess.getDynamicProvider(servletRequest);
	
	        //TODO: don't send changes in case of exception -> PORTLET:SPEC:17
	
	        // get the changings of this portlet entity that might be set during action handling
	        // change portlet mode
	        if (_actionResponse.getChangedPortletMode() != null)
	        {
	            InformationProviderAccess.getDynamicProvider(servletRequest)
	                .getPortletActionProvider(portletWindow)
	                .changePortletMode(_actionResponse.getChangedPortletMode());
	        }
	        // change window state
	        if (_actionResponse.getChangedWindowState() != null)
	        {
	            InformationProviderAccess.getDynamicProvider(servletRequest)
	                .getPortletActionProvider(portletWindow)
	                .changePortletWindowState(_actionResponse.getChangedWindowState());
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
	        if (servletRequest.isSecure())
	        {
	            redirectURL.setSecure(); // TBD
	        }
	        redirectURL.clearParameters();
	        redirectURL.setParameters(renderParameter);
	
	        location = servletResponse.encodeRedirectURL(redirectURL.toString());
	    }
	
	    javax.servlet.http.HttpServletResponse redirectResponse = servletResponse;
	    while (redirectResponse instanceof javax.servlet.http.HttpServletResponseWrapper)
	    {
	        redirectResponse = (javax.servlet.http.HttpServletResponse)
	                           ((javax.servlet.http.HttpServletResponseWrapper)redirectResponse).getResponse();
	    }
	    redirectResponse.sendRedirect(location);
	
	    }
}
