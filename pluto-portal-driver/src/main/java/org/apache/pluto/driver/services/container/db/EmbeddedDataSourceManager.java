/*
 * Copyright 2004 The Apache Software Foundation.
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
package org.apache.pluto.driver.services.container.db;

import org.apache.derby.jdbc.EmbeddedDataSource;
import org.apache.pluto.PortletContainerException;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Provides access to the DataSource used for Derby.
 * Provided so that advanced configuration may be
 * provided in the future.
 *
 */
public class EmbeddedDataSourceManager implements DataSourceManager {

    private static final Log LOG =
            LogFactory.getLog(EmbeddedDataSourceManager.class);

    private String connectionString;

    private String shutdown =  "shutdownDatabase=true";

    private EmbeddedDataSource embeddedDataSource;

    public EmbeddedDataSourceManager() {
        connectionString =
            "databaseName=PLUTO_PORTAL_DRIVER;name=pluto;password=apachep0rtals;create=true";

        System.setProperty(
            "derby.system.home",
            System.getProperty("user.home") + "/.pluto/portal-driver/data"
        );
    }

    public EmbeddedDataSourceManager(String connectionString, String systemDirectory) {
        this.connectionString = connectionString;
        System.setProperty("derby.system.home", systemDirectory);
    }

    public void startup() throws PortletContainerException {
        embeddedDataSource = new EmbeddedDataSource();
        embeddedDataSource.setConnectionAttributes(connectionString);
        embeddedDataSource.setDatabaseName("PLUTO_PORTAL_DRIVER");
        embeddedDataSource.setCreateDatabase("true");
        initDatabase();
    }

    public void shutdown() throws PortletContainerException {
        if(embeddedDataSource != null)
            embeddedDataSource.setConnectionAttributes(connectionString+shutdown);
        embeddedDataSource = null;
    }

    public boolean isRunning() {
        return embeddedDataSource != null;
    }


    public DataSource getPortalDataSource() {
        return embeddedDataSource;
    }

    /**
     * Eventually we should ensure pooling.
     */
    private void initDatabase() throws PortletContainerException {
        if(!isDatabaseInitialized()) {
            if(LOG.isInfoEnabled()) {
                LOG.info("Pluto Database does not exist.  Creating database now.");
            }

        }
            // 1) Read in the PORTABLE CREATE SQL Script
            // 2) Execute the CREATE Script via JDBC
            // 3) Retrieve default data
            // 4) Insert default data via JDBC
    }

    /**
     * @return true if the database is valid
     */
    private boolean isDatabaseInitialized() throws PortletContainerException {
        boolean found = false;
        Connection conn = null;
        Statement  stmt = null;
        ResultSet  rs   = null;
        try {
            conn = embeddedDataSource.getConnection();
            stmt = conn.createStatement();
            rs   = stmt.executeQuery("SELECT count(*) FROM SYS.SYSTABLES WHERE TABLENAME = 'PPD_VERSION'");
            if(rs.next()) {
                found = rs.getInt(1) == 1;
            }
            else throw new SQLException("No results returned.  Should never happen for count(*)");
        }
        catch(SQLException sql) {
            throw new PortletContainerException(sql);
        }
        finally {
            cleanup(conn, stmt, rs);
        }
       return found;
    }

    private void cleanup(Connection conn, Statement stmt, ResultSet rs) {
        if(rs != null)
            try { rs.close(); } catch(SQLException sql) {
                LOG.error("Unable to close result set.", sql);
            }

        if(stmt != null)
            try { stmt.close(); } catch(SQLException sql) {
                LOG.error("Unable to close result set.", sql);
            }

        if(conn != null)
            try { conn.close(); } catch(SQLException sql) {
                LOG.error("Unable to close result set.", sql);
            }
    }


}
