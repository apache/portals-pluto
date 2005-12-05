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

import org.apache.pluto.driver.services.portal.PortletApplicationConfig;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.optional.db.common.AbstractDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.sql.*;

/**
 * Data Access object used for persisting PortletApplications
 * and Portlets.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Nov 24, 2005
 */
class PortletRegistryDao extends AbstractDao {

    private static final Log LOG = LogFactory.getLog(PortletRegistryDao.class);

    public PortletRegistryDao(DataSource dataSource) {
        super(dataSource);
    }

    public Set getPortletApplications() throws SQLException {
        return new HashSet(doList(createPortletAppSQL(null)));
    }

    public PortletApplicationConfig getPortletApp(String context) throws SQLException {
        PortletApplicationConfig app = (PortletApplicationConfig)
                doSelect(createPortletAppSQL(context));

        return app;
    }


    public void addPortletApplication(PortletApplicationConfig config)
    throws SQLException {

    }

    public void seedPortletApplications(Collection portletApplications)
    throws SQLException {

        boolean autoCommit = false;
        Connection conn = null;

        PreparedStatement appTestStmt = null;
        PreparedStatement portletTestStmt = null;
        PreparedStatement appStmt = null;
        PreparedStatement pStmt = null;


        try {
            conn = getConnection();
            autoCommit = conn.getAutoCommit();
            conn.setAutoCommit(false);

            appTestStmt = conn.prepareStatement(TEST_APP_SQL);
            portletTestStmt = conn.prepareStatement(TEST_PORTLET_SQL);

            appStmt = conn.prepareStatement(CREATE_APP_SQL);
            pStmt = conn.prepareStatement(CREATE_PORTLET_SQL);

            Iterator it = portletApplications.iterator();
            while(it.hasNext()) {
                PortletApplicationConfig app = (PortletApplicationConfig)it.next();

                appTestStmt.setString(1, app.getContextPath());
                ResultSet rs = appTestStmt.executeQuery();

                if(!rs.next() || rs.getInt(1) < 1) {
                    if(LOG.isDebugEnabled()) {
                        LOG.debug("Auto-Publishing Portlet Application: "+app.getContextPath());
                    }
                    appStmt.setString(1, app.getContextPath());
                    appStmt.addBatch();
                }

                rs.close();

                Iterator portlets = app.getPortlets().iterator();
                while(portlets.hasNext()) {
                    PortletWindowConfig window = (PortletWindowConfig)portlets.next();
                    portletTestStmt.setString(1, app.getContextPath());
                    portletTestStmt.setString(2, window.getPortletName());
                    rs = portletTestStmt.executeQuery();

                    if(!rs.next() || rs.getInt(1) < 1) {
                        if(LOG.isDebugEnabled()) {
                            LOG.debug("Auto-Publishing Portlet: "+app.getContextPath() + " --> " + window.getPortletName());
                        }

                        pStmt.setString(1, app.getContextPath());
                        pStmt.setString(2, window.getPortletName());
                        pStmt.addBatch();
                    }
               }

                appStmt.executeBatch();
                pStmt.executeBatch();
            }
            conn.commit();
        }
        catch(SQLException sql) {
            if(conn != null)
                conn.rollback();
            LOG.error("Unable to seed portlet application.", sql);
            throw sql;
        }
        finally {
            if(conn != null)
                conn.setAutoCommit(autoCommit);
            cleanup(null, appTestStmt, null);
            cleanup(null, pStmt, null);
            cleanup(conn, appStmt, null);
        }
    }

    private static final String TEST_APP_SQL =
        "SELECT count(*) FROM portlet_app WHERE app_context = ?";

    private static final String TEST_PORTLET_SQL =
        "SELECT count(*) " +
        "  FROM portlet p, portlet_app pa " +
        " WHERE pa.app_context = ? " +
        "   AND p.portlet_app_id = pa.portlet_app_id " +
        "   AND p.portlet_name = ? ";

    private static final String CREATE_APP_SQL =
        "INSERT INTO portlet_app (app_context) VALUES (?)";

    public static final String CREATE_PORTLET_SQL =
        "INSERT INTO portlet (portlet_app_id, portlet_name) VALUES (" +
        "       (SELECT portlet_app_id FROM portlet_app WHERE app_context = ?), ?" +
        ")";

    private String createPortletAppSQL(String context) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT 'APP' as mode, app.portlet_app_id, app.app_context, ")
          .append("       p.portlet_id, p.portlet_name")
          .append("  FROM portlet_app app, portlet p ")
          .append(" WHERE p.portlet_app_id = app.portlet_app_id");
        if(context != null) {
          sb.append("   AND app.app_context = ").append(fmt(context)).append(" ");
        }
        return sb.toString();
    }

    protected InstantiationResult instantiate(ResultSet rs, InstantiationResult lastResult)
    throws SQLException {
        if("APP".equals(rs.getString("mode")))
           return instantiateApp(rs, lastResult);
        else {
            return instantiatePortlet(rs);
        }
    }

    private InstantiationResult instantiateApp(ResultSet rs, InstantiationResult lastResult) throws SQLException {
        InstantiationResult result = null;
        PortletApplicationConfig appConfig = null;

        if(lastResult == null) {
            result = new InstantiationResult();
        }
        else {
            result = lastResult;
            appConfig = (PortletApplicationConfig) lastResult.getControl();
        }

        if(appConfig == null || !appConfig.getContextPath().equals(rs.getString("app_context"))) {
            appConfig = new PortletApplicationConfig();
            appConfig.setContextPath(rs.getString("app_context"));
            result.setControl(appConfig);
            result.setResult(appConfig);
        }
        appConfig.addPortlet((PortletWindowConfig)instantiatePortlet(rs).getResult());
        return result;
    }

    private InstantiationResult instantiatePortlet(ResultSet rs) throws SQLException {
        PortletWindowConfig config = new PortletWindowConfig();
        config.setPortletName(rs.getString("portlet_name"));
        config.setContextPath(rs.getString("app_context"));

        InstantiationResult result = new InstantiationResult();
        result.setResult(config);
        return result;
    }

    public PortletWindowConfig getPortletWindowConfig(String context, String portletName)
    throws SQLException {
        return (PortletWindowConfig) doSelect(createSelectPortletSQL(context, portletName));
    }

    private String createSelectPortletSQL(String context, String portletName) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT 'PLT' as mode, portlet_id, portlet_name, a.app_context ")
          .append("  FROM portlet p, portlet_app a ")
          .append(" WHERE a.app_context = ").append(fmt(context))
          .append("   AND p.portlet_app_id = a.portlet_app_id")
          .append("   AND p.portlet_name = ").append(fmt(portletName));

        if(LOG.isDebugEnabled()) {
            LOG.debug(sb.toString());
        }
        return sb.toString();
    }
}
