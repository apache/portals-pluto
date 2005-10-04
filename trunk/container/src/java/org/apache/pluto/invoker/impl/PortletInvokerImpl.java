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

package org.apache.pluto.invoker.impl;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.pluto.PortletContainerServices;
import org.apache.pluto.core.CoreUtils;
import org.apache.pluto.core.InternalPortletRequest;
import org.apache.pluto.core.InternalPortletResponse;
import org.apache.pluto.invoker.PortletInvoker;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.servlet.ServletDefinition;
import org.apache.pluto.services.log.LogService;
import org.apache.pluto.services.log.Logger;

public class PortletInvokerImpl implements PortletInvoker
{
    private javax.servlet.ServletConfig servletConfig;
    private PortletDefinition portletDefinition;

    /* This Logger can be saved due to the
     * fact that a unique instance of PortletInvoker
     * will be used for each request. We load it
     * lazily since we only log exceptions at
     * this point.
     */
    private Logger log = null;

    public PortletInvokerImpl(PortletDefinition portletDefinition,
                              javax.servlet.ServletConfig servletConfig)
    {
        this.portletDefinition = portletDefinition;
        this.servletConfig = servletConfig;
    }

    // org.apache.pluto.invoker.PortletInvoker implementation -------------------------------------
    public void action(ActionRequest request, ActionResponse response) throws PortletException,IOException
    {
        invoke(request,response,org.apache.pluto.Constants.METHOD_ACTION);
    }

    public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException
    {
        invoke(request,response,org.apache.pluto.Constants.METHOD_RENDER);
    }

    public void load(PortletRequest request, RenderResponse response) throws PortletException
    {
        try
        {
            invoke(request,response,org.apache.pluto.Constants.METHOD_NOOP);
        }
        catch (IOException e)
        {
            getLog().error("PortletInvokerImpl.load() - Error while dispatching portlet.",e);
            throw new PortletException(e);
        }
    }
    // --------------------------------------------------------------------------------------------

    // additional methods -------------------------------------------------------------------------
    /*
     * generic method to be used called by both, action and render
     */
    protected void invoke(PortletRequest portletRequest, PortletResponse portletResponse, Integer methodID) 
    throws PortletException,IOException
    {
        InternalPortletRequest internalPortletRequest = CoreUtils.getInternalRequest(portletRequest);

        InternalPortletResponse internalPortletResponse = CoreUtils.getInternalResponse(portletResponse);

        // gather all required data from request and response
        ServletRequest servletRequest = ((javax.servlet.http.HttpServletRequestWrapper)internalPortletRequest).getRequest();

        ServletResponse servletResponse = ((javax.servlet.http.HttpServletResponseWrapper)internalPortletResponse).getResponse();

        ServletDefinition servletDefinition = portletDefinition.getServletDefinition();
        ServletContext servletContext = servletConfig.getServletContext();

        javax.servlet.RequestDispatcher dispatcher = servletDefinition.getRequestDispatcher(servletContext);

        if (dispatcher != null)
        {
            try
            {
                servletRequest.setAttribute(org.apache.pluto.Constants.METHOD_ID, methodID);

                servletRequest.setAttribute(org.apache.pluto.Constants.PORTLET_REQUEST, portletRequest);
                servletRequest.setAttribute(org.apache.pluto.Constants.PORTLET_RESPONSE, portletResponse);

                dispatcher.include(servletRequest, servletResponse);
            }
            catch (javax.servlet.UnavailableException e)
            {
                getLog().error("PortletInvokerImpl.invoke() - Error while dispatching portlet.",e);
                if (e.isPermanent())
                {
                    throw new javax.portlet.UnavailableException(e.getMessage());
                }
                else
                {
                    throw new javax.portlet.UnavailableException(e.getMessage(), e.getUnavailableSeconds());
                }
            }
            catch (javax.servlet.ServletException e)
            {
                if (e.getRootCause() != null)
                {
                    getLog().error("PortletInvokerImpl.render() - Error while dispatching portlet.",
                              e.getRootCause());
                    if (e.getRootCause() instanceof PortletException)
                    {
                        throw (PortletException)e.getRootCause();
                    }
                    else
                    {
                        throw new PortletException(e.getRootCause());
                    }
                }
                else
                {
                    getLog().error("PortletInvokerImpl.invoke() - Error while dispatching portlet.",
                              e);
                    throw new PortletException(e);
                }
            }
            finally
            {
                servletRequest.removeAttribute(org.apache.pluto.Constants.METHOD_ID);
                servletRequest.removeAttribute(org.apache.pluto.Constants.PORTLET_REQUEST);
                servletRequest.removeAttribute(org.apache.pluto.Constants.PORTLET_RESPONSE);
            }
        }
        else
        {
            getLog().error("PortletInvokerImpl.action() - Unable to find RequestDispatcher.");
            throw new PortletException("Unable to find dispatcher for context: "+servletContext.getServletContextName());
        }
    }
    // --------------------------------------------------------------------------------------------

    /** Provides lazy instantiation of the Logger.
     *  This is usefull since the log is currently only
     *  used when an error occurs.  B/C of this, there is
     *  no reason to retrieve the log until needed.
     * @return
     */
    private Logger getLog() {
        if(log==null) {
        // from here forward for this Container:
            log = ((LogService)PortletContainerServices
                .get(LogService.class))
                .getLogger(getClass());
        }
        return log;
    }
}
