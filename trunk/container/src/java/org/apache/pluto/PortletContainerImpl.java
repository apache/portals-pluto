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
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
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
import org.apache.pluto.services.log.LogService;
import org.apache.pluto.services.log.Logger;

/**
 *  Implements the Pluto Container.
 * 
 * @version $Id$
 */
public class PortletContainerImpl implements PortletContainer
{

    private String uniqueContainerName;
    private boolean initialized;
    
    private static String CONTAINER_SUPPORTS_BUFFERING = "portletcontainer.supportsBuffering";
    private boolean supportsBuffering;

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
        
        Boolean b = (Boolean)properties.get(CONTAINER_SUPPORTS_BUFFERING);
        if (b == null) {
        	log.warn("org.apache.pluto.PortletContainerImpl#init(): " +
        			"Couldn't retrieve parameter \"" + CONTAINER_SUPPORTS_BUFFERING + "\" from" +
        			"passed properties object. Falling back to default value \"FALSE\"");
        	supportsBuffering = false;
        } else {
        	supportsBuffering = b.booleanValue();
        }
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
                                                                                  servletResponse,
                                                                                  supportsBuffering);

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
                                                                              servletResponse,
                                                                              supportsBuffering);

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
	
            PortletMode portletMode = provider.getPortletMode(portletWindow);
            WindowState windowState = provider.getWindowState(portletWindow);
            
	        // get the changings of this portlet entity that might be set during action handling
	        // change portlet mode
	        if (_actionResponse.getChangedPortletMode() != null)
	        {
                portletMode = _actionResponse.getChangedPortletMode();
	            InformationProviderAccess.getDynamicProvider(servletRequest)
	                .getPortletActionProvider(portletWindow)
	                .changePortletMode(portletMode);
	        }
	        // change window state
	        if (_actionResponse.getChangedWindowState() != null)
	        {
                windowState = _actionResponse.getChangedWindowState();
	            InformationProviderAccess.getDynamicProvider(servletRequest)
	                .getPortletActionProvider(portletWindow)
	                .changePortletWindowState(windowState);
	        }
	        // get render parameters
	        Map renderParameter = _actionResponse.getRenderParameters();
	
	        PortletURLProvider redirectURL = provider.getPortletURLProvider(portletWindow);
	
	        if (provider.getPortletMode(portletWindow)!=null)
	        {
	            redirectURL.setPortletMode(portletMode);
	        }
	        if (provider.getWindowState(portletWindow)!=null)
	        {
	            redirectURL.setWindowState(windowState);
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
