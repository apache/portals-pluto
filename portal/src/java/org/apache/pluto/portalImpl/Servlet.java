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

package org.apache.pluto.portalImpl;

import java.io.IOException;
import java.util.Properties;

import javax.portlet.PortletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.PortletContainerException;
import org.apache.pluto.services.log.Logger;
import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.portalImpl.aggregation.RootFragment;
import org.apache.pluto.portalImpl.core.PortalControlParameter;
import org.apache.pluto.portalImpl.core.PortalEnvironment;
import org.apache.pluto.portalImpl.core.PortalURL;
import org.apache.pluto.portalImpl.core.PortletContainerEnvironment;
import org.apache.pluto.portalImpl.core.PortletContainerFactory;
import org.apache.pluto.portalImpl.services.ServiceManager;
import org.apache.pluto.portalImpl.services.log.Log;
import org.apache.pluto.portalImpl.services.factorymanager.FactoryManager;
import org.apache.pluto.portalImpl.factory.FactoryAccess;
import org.apache.pluto.portalImpl.services.config.Config;
import org.apache.pluto.portalImpl.services.pageregistry.PageRegistry;
import org.apache.pluto.portalImpl.servlet.ServletObjectAccess;


public class Servlet extends HttpServlet
{

    private Logger log = null;

    public String getServletInfo()
    {
        return "portalImpl - Pluto Driver";
    }

    public void init (ServletConfig config) throws ServletException
    {
        super.init (config);

        try
        {
            ServiceManager.init (config);
        }
        catch (Throwable exc)
        {
            log ("Initialization failed!", exc);

            throw (new javax.servlet.UnavailableException ("Initialization of one or more services failed."));
        }

        try {

            ServiceManager.postInit(config);

        } catch (Throwable expos) {
            
            log ("Post initialization failed!", expos);

            throw (new javax.servlet.UnavailableException ("Post initialization of one or more services failed."));
        }

        log = Log.getService().getLogger(getClass());

        if (!PortletContainerFactory.getPortletContainer().isInitialized()) {
            String uniqueContainerName =
               Config.getParameters().getString("portletcontainer.uniquename", "pluto");

            if(log.isInfoEnabled())
                log.info("Initializing PortletContainer ["
                          +uniqueContainerName+"]...");
    
            PortletContainerEnvironment environment
                = new PortletContainerEnvironment();

            environment.addContainerService(Log.getService());
            environment.addContainerService(FactoryManager.getService());
            environment.addContainerService(FactoryAccess.getInformationProviderContainerService());
            environment.addContainerService(FactoryAccess.getDynamicTitleContainerService());
    
    		Properties properties = new Properties();
    		
            try
            {
                PortletContainerFactory.
                    getPortletContainer().
                        init(uniqueContainerName, config, environment, properties);
            }
            catch (PortletContainerException exc)
            {
                log.error("Initialization of the portlet container failed!", exc);
                throw (new javax.servlet.UnavailableException ("Initialization of the portlet container failed."));
            }
        } else if(log.isInfoEnabled()) {
            log.info("PortletContainer already initialized");
        }

        log.debug("Ready to serve you.");
    }

    public void destroy()
    {
        if(log.isInfoEnabled())
            log.info("Shutting down portlet container. . .");
        try
        {
            PortletContainerFactory.
                getPortletContainer().
                    shutdown();

            // destroy all services

            ServiceManager.destroy (getServletConfig ());

            System.gc ();
        }
        catch (Throwable t)
        {
            log ("Destruction failed!", t);
        }
    }

    public void doGet (HttpServletRequest servletRequest,
                             HttpServletResponse servletResponse) throws IOException, ServletException
    {
        servletResponse.setContentType("text/html");

        PortalEnvironment env =
            new PortalEnvironment(servletRequest,
                                  servletResponse,
                                  getServletConfig());

        PortalURL currentURL = env.getRequestedPortalURL();
        PortalControlParameter control = new PortalControlParameter(currentURL);
        PortletWindow actionWindow = control.getPortletWindowOfAction();
        if (actionWindow!=null)
        {
            try {
                PortletContainerFactory.
                    getPortletContainer().
                        processPortletAction(actionWindow,
                                             ServletObjectAccess.getServletRequest(servletRequest, actionWindow),
                                             ServletObjectAccess.getServletResponse(servletResponse));
            }
            catch (PortletException e)
            {
                e.printStackTrace(System.err);
            }
            catch (PortletContainerException e)
            {
                e.printStackTrace(System.err);
            }
            // This catch block is for compliance
            // of TCK's Portlet.ProcessActionIOExceptionTest
            catch (Exception e)
            {
                e.printStackTrace(System.err);
            }

            return; // we issued an redirect, so return directly
        }

        try
        {
            RootFragment root = PageRegistry.getRootFragment();
            root.service(servletRequest, servletResponse);
        }
        catch (Throwable t)
        {
            ;
        }
        finally
        {

        }

    }

    public void doPost (HttpServletRequest request,
                              HttpServletResponse response) throws IOException, ServletException
    {
        doGet (request, response);
    }

}
