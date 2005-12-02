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
import org.apache.pluto.driver.services.impl.resource.ResourceConfig;
import org.apache.pluto.driver.services.impl.resource.ResourceConfigReader;
import org.apache.pluto.driver.config.DriverConfigurationException;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.optional.db.common.DataSourceManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContext;
import java.util.Set;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * TODO JavaDoc
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Nov 24, 2005
 */
public class DBPortletRegistryService implements PortletRegistryService {

    private static final Log LOG = LogFactory.getLog(DBPortletRegistryService.class);

    private ResourceConfig config;

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

        if(LOG.isDebugEnabled()) {
            LOG.debug("Registering portlet applications. . .");
        }

        try {
            InputStream in = ctx.getResourceAsStream(ResourceConfigReader.CONFIG_FILE);
            config = ResourceConfigReader.getFactory().parse(in);

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

    public void addPortletApplication(PortletApplicationConfig app) {

    }
}
