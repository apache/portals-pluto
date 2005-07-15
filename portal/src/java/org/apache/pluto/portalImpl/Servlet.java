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
import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.portalImpl.aggregation.RootFragment;
import org.apache.pluto.portalImpl.core.PortalControlParameter;
import org.apache.pluto.portalImpl.core.PortalEnvironment;
import org.apache.pluto.portalImpl.core.PortalURL;
import org.apache.pluto.portalImpl.core.PortletContainerEnvironment;
import org.apache.pluto.portalImpl.core.PortletContainerFactory;
import org.apache.pluto.portalImpl.factory.FactoryAccess;
import org.apache.pluto.portalImpl.services.ServiceManager;
import org.apache.pluto.portalImpl.services.config.Config;
import org.apache.pluto.portalImpl.services.factorymanager.FactoryManager;
import org.apache.pluto.portalImpl.services.log.Log;
import org.apache.pluto.portalImpl.services.pageregistry.PageRegistry;
import org.apache.pluto.portalImpl.servlet.ServletObjectAccess;
import org.apache.pluto.services.log.Logger;


public class Servlet extends HttpServlet
{

    private static String CONTENT_TYPE = "text/html";
    
    /**
     * Stores whether the portlet container used supports buffering
     */
    private static String CONTAINER_SUPPORTS_BUFFERING = "portletcontainer.supportsBuffering";

    private Logger log = null;

    public String getServletInfo()
    {
        return "portalImpl - Pluto Driver";
    }

    public void init (ServletConfig config) throws ServletException
    {
        super.init (config);
        
        String charset = config.getInitParameter("charset");
        if (charset != null && charset.length() > 0) {
            CONTENT_TYPE = "text/html; charset=" + charset;
        }

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
    
            String allowSetBufferSizeString = Config.getParameters().getString(CONTAINER_SUPPORTS_BUFFERING);
            boolean allowSetBufferSize = false;
            if (allowSetBufferSizeString == null) {
            	log.warn("org.apache.pluto.portalImpl.Servlet#init(): " +
            			"Couldn't read property \"pluto.allowSetBufferSize\" " +
            			"from config file ConfigService.properties");
            } else {
            	allowSetBufferSize = allowSetBufferSizeString.equalsIgnoreCase("yes");
            }
            Properties containerProperties = new Properties();

            containerProperties.put(CONTAINER_SUPPORTS_BUFFERING, new Boolean(allowSetBufferSize));
            
//    		Properties properties = new Properties();
    		
            try
            {
                PortletContainerFactory.
                    getPortletContainer().
//                        init(uniqueContainerName, config, environment, properties);
                    	init(uniqueContainerName, config, environment, containerProperties);
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
        servletResponse.setContentType(CONTENT_TYPE);

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
            // nothing to do
        }
   
    }

    public void doPost (HttpServletRequest request,
                              HttpServletResponse response) throws IOException, ServletException
    {
        doGet (request, response);
    }

}
