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
package org.apache.pluto.driver.services.impl.db;

import org.apache.pluto.driver.services.portal.PortletRegistryService;
import org.apache.pluto.driver.services.portal.PortletApplicationConfig;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.services.portal.admin.PortletRegistryAdminService;
import org.apache.pluto.driver.services.portal.admin.DriverAdministrationException;
import org.apache.pluto.driver.services.impl.resource.ResourceConfig;
import org.apache.pluto.driver.services.impl.resource.ResourceConfigReader;
import org.apache.pluto.driver.config.DriverConfigurationException;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.core.PortletDescriptorRegistry;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.optional.db.common.DataSourceManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContext;
import java.util.Set;
import java.util.Iterator;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * TODO JavaDoc
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Nov 24, 2005
 */
public class DBPortletRegistryService
    implements PortletRegistryService, PortletRegistryAdminService {

    private static final Log LOG = LogFactory.getLog(DBPortletRegistryService.class);

    private ServletContext servletContext;

    private DataSourceManager dataSourceManager;

    private PortletRegistryDao dao;

    public DBPortletRegistryService(DataSourceManager dataSourceManager)
    throws InstantiationException {
        this.dataSourceManager = dataSourceManager;
        if(!dataSourceManager.isRunning()) {
            try {
                dataSourceManager.startup();
            }
            catch(PortletContainerException pce) {
                String msg =
                   "Unable to startup portlet registry service due to dataSourceManager error."+
                   pce.getMessage();
                if(LOG.isErrorEnabled()) {
                    LOG.error(msg, pce);
                }
                throw new InstantiationException(msg);
            }
        }
        dao = new PortletRegistryDao(dataSourceManager.getPortalDataSource());
    }

    public void init(ServletContext ctx) throws DriverConfigurationException {
        this.servletContext = ctx;

        if(LOG.isDebugEnabled()) {
            LOG.debug("Registering portlet applications. . .");
        }

        try {
            InputStream in = ctx.getResourceAsStream(ResourceConfigReader.CONFIG_FILE);
            ResourceConfig config = ResourceConfigReader.getFactory().parse(in);

            dao.seedPortletApplications(config.getPortletApplications());
        }
        catch(Exception sql) {
            if(LOG.isErrorEnabled()) {
                LOG.error("Unable to initialize portlet registry services: ", sql);
            }
           throw new DriverConfigurationException("Unable to initialize portlet registry service: ", sql);
        }

    }

    public void destroy() throws DriverConfigurationException {
        if(dataSourceManager != null) {
            try {
                dataSourceManager.shutdown();
            }
            catch(PortletContainerException pce) {
                LOG.error("Unable to shutdown dataSourceManager: "+pce.getMessage(), pce);
            }
        }
    }

    public Set getPortletApplications() {
        try {
            return dao.getPortletApplications();
        }
        catch(SQLException sqle) {
            throw new DriverConfigurationException(sqle);
        }
    }

    public PortletApplicationConfig getPortletApplication(String id) {
        try {
            return dao.getPortletApp(id);
        }
        catch(SQLException sqle) {
            throw new DriverConfigurationException("Unable to find portlet app configuration for portlet : "+id+" / "+sqle.getMessage(), sqle);
        }
    }

    public PortletWindowConfig getPortlet(String id) {
        if(id == null) {
            return null;
        }
        try {
            String appContext = PortletWindowConfig.parseContextPath(id);
            String portletName = PortletWindowConfig.parsePortletName(id);
            return dao.getPortletWindowConfig(appContext, portletName);
        }
        catch(SQLException sqle) {
            throw new DriverConfigurationException("Unable to find portlet configuration for portlet : "+ id+" / "+sqle.getMessage(), sqle);
        }
    }

    public void addPortletApplication(String contextPath)
    throws DriverAdministrationException {
        if(contextPath == null)
            throw new IllegalArgumentException("Can not add servlet context 'null'.");

        try {
            PortletApplicationConfig app = new PortletApplicationConfig();
            app.setContextPath(contextPath);

            ServletContext portletContext = servletContext.getContext(contextPath);
            if(portletContext == null) {
                throw new DriverAdministrationException("Unable to locate context: "+contextPath+". Ensure that crossContext support is enabled and the portlet application has been deployed.");
            }

            PortletAppDD descriptor = getPortletDescriptor(portletContext);
            Iterator it = descriptor.getPortlets().iterator();
            while(it.hasNext()) {
                PortletDD portlet = (PortletDD)it.next();
                PortletWindowConfig config = new PortletWindowConfig();
                config.setContextPath(contextPath);
                config.setPortletName(portlet.getPortletName());
                app.addPortlet(config);
            }
            dao.addPortletApplication(app);
        }

        catch(PortletContainerException pce) {
            throw new DriverAdministrationException("Unable to load descriptor. ", pce);
        }
       catch(SQLException sqle) {
            throw new DriverAdministrationException("Unable to add portlet application due to database error.", sqle);
        }
    }


    private PortletAppDD getPortletDescriptor(ServletContext context)
    throws PortletContainerException {
        return PortletDescriptorRegistry.getRegistry().getPortletAppDD(context);
    }
}
