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

package org.apache.pluto.driver;

import org.apache.pluto.driver.impl.PortletWindowImpl;
import org.apache.pluto.driver.impl.services.ServiceFactoryImpl;
import org.apache.pluto.driver.impl.services.LoggerServiceImpl;
import org.apache.pluto.driver.impl.services.PortletURLServiceImpl;
import org.apache.pluto.driver.impl.PortalContextImpl;
import org.apache.pluto.PlutoContainer;
import org.apache.pluto.PlutoEnvironment;
import org.apache.pluto.PlutoException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.binding.impl.digester.DigesterXMLBinding;
import org.apache.pluto.binding.XMLBinding;
import org.apache.pluto.core.PlutoContainerImpl;
import org.apache.pluto.services.ServiceFactory;
import org.apache.pluto.services.LoggerService;
import org.apache.pluto.services.PortletURLService;
import org.apache.pluto.services.PortletInvokerService;
import org.apache.pluto.core.PlutoEnvironmentImpl;
import org.apache.pluto.core.PortletInvokerServiceImpl;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.portlet.PortletException;
import javax.portlet.PortalContext;
import java.io.IOException;
import java.util.Properties;

/**
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 8:19:24 AM
 */
public class Portal {

    private static final String PLUTO_CONFIG
        =  "/WEB-INF/pluto-container.xml";

    private static final String DRIVER_CONFIG
        = "/WEB-INF/pluto-driver-config.xml";

    private static final Log LOG
        = LogFactory.getLog(Portal.class);

    private static Portal portal;

    public static Portal getPortal() {
        if(portal==null) {
            if(LOG.isInfoEnabled()) {
                LOG.info("Portal Initialization: creating Portal Instance.");
                if(LOG.isDebugEnabled()) {
                    LOG.info("Portal Initialization: Portal must be started before use.");
                }
            }
            portal = new Portal();
        }
        return portal;
    }

    private ServletContext context;
    private PlutoContainer container;
    private PortalConfig portalConfig;
    private PageManager manager;

    private Portal() {
        System.setProperty(
                XMLBinding.class.getName(),
                DigesterXMLBinding.class.getName()
        );

        this.portalConfig = new PortalConfig();
    }

    public PageManager getPageManager() {
        return manager;
    }

    // Replaced by Nana/Pico in future?
    public void startup(ServletContext servletContext)
    throws PlutoException {
        this.context = servletContext;

        if(LOG.isDebugEnabled()) {
            LOG.debug("Portal Initialization: Starting Portal for context: "
                      +servletContext.getServletContextName());
        }

        try {
            manager = new PageManagerParser().getPageManager(
                    servletContext.getResourceAsStream(DRIVER_CONFIG)
                  );
        }
        catch(IOException io) {
            throw new PlutoException(
                "Unable to start pluto driver."
                +io.getMessage()
            );
        }

        /* @TODO I think this is where Nano/Pico Integration may
         *  make sense - need to research a little more
        try {
            InputStream configIs = servletContext.getResourceAsStream(CONFIG);
            InputStreamReader in = new InputStreamReader(configIs);
            NanoContainer nano = new NanoContainer(in, NanoContainer.XML);
            ContainerBuilder builder = nano.getContainerBuilder();
            builder.buildContainer();
        }
        catch(ClassNotFoundException cne) {

        }
        */

        /* For now I will implement without Nano Container
         */

        LoggerService loggerService = new LoggerServiceImpl();
        PortletURLService urlService =  new PortletURLServiceImpl();

        PortletInvokerService invokerService
            = new PortletInvokerServiceImpl(urlService, loggerService);

        ServiceFactory factory
            = new ServiceFactoryImpl(loggerService, urlService, invokerService);

        container = new PlutoContainerImpl(factory);


        /* Now that the container is build, we will initialize
         * the container with it's "runtime" configuration -
         * which is basically all of the components which
         * depend upon the servlet container's environment
         */

        String containerName =
            servletContext.getInitParameter("pluto-container-name");
        if(containerName==null) {
            containerName = "plutoContainer<no-name>"; //??
        }

        //@TODO runtime load properties
        Properties portalProperties = new Properties();
        PortalContext portalContext = new PortalContextImpl(portalProperties);

        PlutoEnvironment config =
            new PlutoEnvironmentImpl(containerName, portalContext, servletContext);

        container.init(config);
        container.start();
    }

    public void shutdown() {
        if(LOG.isDebugEnabled()) {
            LOG.debug("Portal Destruction: Shutting down portal for context: "
                      +context.getServletContextName());
        }
        container.stop();
        container = null;
    }

    public void doRender(PortletWindow window,
                       HttpServletRequest req,
                       HttpServletResponse res)
    throws PlutoException, PortletException, IOException {
        if(container==null && LOG.isErrorEnabled()) {
            LOG.error("Portal must be started before use.");
        }
        container.doRender(window, req, res);
    }

    public void doAction(PortletWindow window,
                         HttpServletRequest req,
                         HttpServletResponse res)
    throws PlutoException, PortletException, IOException {
        if(container==null && LOG.isErrorEnabled()) {
            LOG.error("Portal must be started before use.");
        }
        container.doAction(window, req, res);
    }

    public PortalConfig getPortalConfig() {
        return portalConfig;
    }
}
