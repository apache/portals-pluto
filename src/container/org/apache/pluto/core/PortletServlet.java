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

package org.apache.pluto.core;

import javax.portlet.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.*;

import org.apache.pluto.factory.PortletObjectAccess;
import org.apache.pluto.om.*;
import org.apache.pluto.om.portlet.*;
import org.apache.pluto.services.information.InformationProviderAccess;

public class PortletServlet extends HttpServlet
{

    private boolean portletInitialized = false;
    private Portlet portletClass = null;

    private PortletContext portletContext;
    private PortletConfig portletConfig;

    // HttpServlet --------------------------------------------------------------------------------
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        portletInitialized = false;

        String classString = config.getInitParameter("portlet-class");
        try
        {
            portletClass = (Portlet)Thread.currentThread().getContextClassLoader().loadClass(classString).newInstance();
        }
        catch (ClassNotFoundException e)
        {
            throw new ServletException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new ServletException(e);
        }
        catch (InstantiationException e)
        {
            throw new ServletException(e);
        }

        // we can create the objects here and call init as we forbid the
        // <load-on-startup>. This flag has to be false

        // TBD - I should not use
        String portletGUID = config.getInitParameter("portlet-guid");
        PortletDefinition portletDefinition = 
        InformationProviderAccess.getStaticProvider().getPortletDefinition(org.apache.pluto.util.ObjectIDAccess.createObjectID(portletGUID));
        if (portletDefinition==null)
        {
            throw new ServletException("portlet definition not found from GUID: " + portletGUID);
        }
        else
        {
            PortletDefinitionCtrl portletDefCtrl = (PortletDefinitionCtrl)ControllerObjectAccess.get(portletDefinition);
            portletDefCtrl.setPortletClassLoader(Thread.currentThread().getContextClassLoader());
        }

        portletContext = PortletObjectAccess.getPortletContext(config.getServletContext(),
                                                               portletDefinition.getPortletApplicationDefinition());
        portletConfig = PortletObjectAccess.getPortletConfig(config, 
                                                             portletContext,
                                                             portletDefinition);

        try
        {
            portletClass.init(portletConfig);
        }
        catch (PortletException e)
        {
            throw new ServletException(e);
        }

        portletInitialized = true;

    }

    public void init() throws ServletException
    {
    }

    public final ServletConfig getServletConfig ()
    {
        return super.getServletConfig();
    }

    public final String getInitParameter(String name)
    {
        return getServletConfig().getInitParameter(name);
    }

    public final Enumeration getInitParameterNames()
    {
        return getServletConfig().getInitParameterNames();
    }

    public ServletContext getServletContext()
    {
        return getServletConfig().getServletContext();
    }

    protected long getLastModified(HttpServletRequest req)
    {
        return -1;
    }

    public String getServletInfo()
    {
        return "";
    }

    public final void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        super.service(request,response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        dispatch(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        dispatch(req,resp);
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        dispatch(req,resp);
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doDelete(req,resp);
    }

    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doOptions(req,resp);
    }

    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doTrace(req,resp);
    }

    public void destroy()
    {
        if (portletClass != null)
        {
            portletClass.destroy();
        }
        super.destroy();
    }
    // --------------------------------------------------------------------------------------------

    // internal methods ---------------------------------------------------------------------------
    private void dispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (!portletInitialized)
        {
            throw new ServletException("this portlet uses the <load-on-startup> flag. You have to turn it off");
        }
        try
        {
            // fill attribute, so that JSPs/servlets can access the config
            request.setAttribute("javax.portlet.config", portletConfig);

            Integer method_id = (Integer)request.getAttribute(org.apache.pluto.Constants.METHOD_ID);
            if (method_id == org.apache.pluto.Constants.METHOD_RENDER)
            {
                RenderRequest renderRequest = (RenderRequest)request.getAttribute(org.apache.pluto.Constants.PORTLET_REQUEST);
                RenderResponse renderResponse = (RenderResponse)request.getAttribute(org.apache.pluto.Constants.PORTLET_RESPONSE);

                // prepare container objects to run in this webModule
                prepareRenderRequest(renderRequest, request);
                prepareRenderResponse(renderResponse, request, response);

                portletClass.render(renderRequest,renderResponse);
            }
            else if (method_id==org.apache.pluto.Constants.METHOD_ACTION)
            {
                ActionRequest actionRequest = (ActionRequest)request.getAttribute(org.apache.pluto.Constants.PORTLET_REQUEST);
                ActionResponse actionResponse = (ActionResponse)request.getAttribute(org.apache.pluto.Constants.PORTLET_RESPONSE);

                // prepare container objects to run in this webModule
                prepareActionRequest(actionRequest, request);
                prepareActionResponse(actionResponse, request, response);

                portletClass.processAction(actionRequest,actionResponse);
            }
            else if (method_id == org.apache.pluto.Constants.METHOD_NOOP)
            {
                //nothing to do
            }

        }
        catch (javax.portlet.UnavailableException e)
        {
            /*if (e.isPermanent()) {
                throw new javax.servlet.UnavailableException(e.getMessage());
            } else {
                throw new javax.servlet.UnavailableException(e.getMessage(), e.getUnavailableSeconds());
            }*/

            // destroy isn't called by Tomcat, so we have to fix it
            try
            {
                portletClass.destroy();
            }
            catch (Throwable t)
            {
                // don't care for Exception
            }

            // handle everything as permanently for now
            throw new javax.servlet.UnavailableException(e.getMessage());
        }
        catch (PortletException e)
        {
            throw new ServletException(e);
        }
        finally
        {
            request.removeAttribute("javax.portlet.config");
        }

    }

    private void prepareActionRequest(ActionRequest portletRequest,
                                      HttpServletRequest servletRequest)
    {
        InternalPortletRequest internalPortletRequest = 
        CoreUtils.getInternalRequest(portletRequest);

        internalPortletRequest.lateInit(servletRequest);
    }

    private void prepareRenderRequest(RenderRequest portletRequest,
                                      HttpServletRequest servletRequest)
    {
        InternalPortletRequest internalPortletRequest = 
        CoreUtils.getInternalRequest(portletRequest);

        internalPortletRequest.lateInit(servletRequest);
    }

    private void prepareRenderResponse(RenderResponse portletResponse,
                                       HttpServletRequest servletRequest,
                                       HttpServletResponse servletResponse)
    {
        InternalPortletResponse internalPortletResponse = 
        CoreUtils.getInternalResponse(portletResponse);

        internalPortletResponse.lateInit(servletRequest, servletResponse);
    }

    private void prepareActionResponse(ActionResponse portletResponse,
                                       HttpServletRequest servletRequest,
                                       HttpServletResponse servletResponse)
    {
        InternalPortletResponse internalPortletResponse = 
        CoreUtils.getInternalResponse(portletResponse);

        internalPortletResponse.lateInit(servletRequest, servletResponse);
    }
    // --------------------------------------------------------------------------------------------
}
