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

import org.apache.pluto.core.CoreUtils;
import org.apache.pluto.core.InternalPortletRequest;
import org.apache.pluto.core.InternalPortletResponse;
import org.apache.pluto.services.log.Log;
import org.apache.pluto.invoker.PortletInvoker;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.servlet.ServletDefinition;

public class PortletInvokerImpl implements PortletInvoker
{
    private javax.servlet.ServletConfig servletConfig;
    private PortletDefinition portletDefinition;

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
            Log.error("org.apache.pluto.invoker",
                      "PortletInvokerImpl.load() - Error while dispatching portlet.",e);
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
                Log.error("org.apache.pluto.invoker",
                          "PortletInvokerImpl.invoke() - Error while dispatching portlet.",e);
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
                    Log.error("org.apache.pluto.invoker",
                              "PortletInvokerImpl.render() - Error while dispatching portlet.",
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
                    Log.error("org.apache.pluto.invoker",
                              "PortletInvokerImpl.invoke() - Error while dispatching portlet.",
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
            Log.error("org.apache.pluto.invoker",
                      "PortletInvokerImpl.action() - Unable to find RequestDispatcher.");
        }
    }
    // --------------------------------------------------------------------------------------------
}
