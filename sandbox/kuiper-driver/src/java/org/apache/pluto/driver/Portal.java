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

import org.apache.pluto.driver.impl.PortalContextImpl;
import org.apache.pluto.PlutoContainer;
import org.apache.pluto.PlutoEnvironment;
import org.apache.pluto.PlutoException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.binding.impl.digester.DigesterXMLBinding;
import org.apache.pluto.binding.XMLBinding;
import org.apache.pluto.core.PlutoEnvironmentImpl;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.nanocontainer.NanoContainer;
import org.nanocontainer.integrationkit.ContainerBuilder;
import org.picocontainer.defaults.ObjectReference;
import org.picocontainer.defaults.SimpleReference;
import org.picocontainer.defaults.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.portlet.PortletException;
import javax.portlet.PortalContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 8:19:24 AM
 */
public class Portal {

    /** Context resource used to configure the
     *  PlutoContainer.
     */
    private static final String PLUTO_CONFIG
        =  "/WEB-INF/pluto-config.xml";

    /** Configuration for Portal Specifics (PageManager,
     *  etc. . .)
     */
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

    /** The ServletContext in which this Portal resides. */
    private ServletContext context;

    /** The PlutoContainer which we use to service requests. */
    private PlutoContainer container;

    /** The PortalConfig used to construct the PlutoContainer. */
    private PortalConfig portalConfig;

    /** Out PageManager instance. */
    private PageManager manager;

    /** Private Constructor. */
    private Portal() {
        // I can't remember why I put this here,
        // it probably needs to be configurable.
        System.setProperty(
                XMLBinding.class.getName(),
                DigesterXMLBinding.class.getName()
        );

        this.portalConfig = new PortalConfig();
    }

    /** Retrieve the PageManager for this Portal. */
    public PageManager getPageManager() {
        return manager;
    }

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

        try {
            LOG.info("Using NanoContainer to create container.");
            InputStream configIs = servletContext.getResourceAsStream(PLUTO_CONFIG);
            InputStreamReader in = new InputStreamReader(configIs);

            ObjectReference containerRef = new SimpleReference();

            // The CONSTANTS are wrong and cause a ClassNotFoundException.
            NanoContainer nano = new NanoContainer(
                in,
                "org.nanocontainer.script.xml.XMLContainerBuilder"
            );
            ContainerBuilder builder = nano.getContainerBuilder();
            builder.buildContainer(containerRef, null, null);
            MutablePicoContainer pico =
                (MutablePicoContainer)containerRef.get();

            // We've read in all of the configuration parameters.
            // Now we must registry the runtime objects that can't
            // be configured (like ServletContext).
            //
            // For now, I consider PlutoEnvironment a runtime obj,
            // but once I figure out how to register the container
            // name string as a parameter, this won't be necessary

            String containerName =
                servletContext.getInitParameter("pluto-container-name");

            if(containerName==null) {
                containerName = "plutoContainer<no-name>"; //??
            }

            Properties portalProperties = new Properties();
            PortalContext portalContext =
                new PortalContextImpl(portalProperties);

            PlutoEnvironment environment =
                new PlutoEnvironmentImpl(
                    containerName,
                    portalContext,
                    servletContext
                );

            pico.registerComponentInstance(
                "javax.servlet.ServletContext",
                servletContext
            );

            pico.registerComponentInstance(
                "org.apache.pluto.PlutoEnvironment",
                environment
            );

            container = (PlutoContainer)pico.
                            getComponentInstanceOfType(PlutoContainer.class);
        }
        catch(ClassNotFoundException cne) {
            LOG.fatal("Unable to build container", cne);
            cne.printStackTrace();
            throw new PlutoException("Unable to configure container.");
        }


        container.start();
    }

    public void shutdown() {
        if(LOG.isDebugEnabled()) {
            LOG.debug("Portal Destruction: Shutting down portal for context: "
                      +context.getServletContextName());
        }
        if(container!=null) {
            container.stop();
            container = null;
        }
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
