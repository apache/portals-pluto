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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


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

            boolean autoCommit = false;
            Connection conn = null;
            Statement  stmt = null;
            try {
                List script = readScript();
                conn = embeddedDataSource.getConnection();
                autoCommit = conn.getAutoCommit();
                conn.setAutoCommit(false);

                stmt = conn.createStatement();
                Iterator it = script.iterator();
                int results = 0;
                while(it.hasNext()) {
                    String sql = it.next().toString();
                    if(sql.trim().length() > 0) {
                       results += stmt.executeUpdate(sql);
                    }
                }
                conn.commit();
                if(LOG.isDebugEnabled()) {
                    LOG.debug("Created "+results+ " database objects");
                }
           }
            catch(IOException io) {
                if(LOG.isErrorEnabled()) {
                    LOG.error("Error reading script file", io);
                }

                throw new PortletContainerException(io);
            }
            catch(SQLException sql) {
                try {
                    if(conn != null)
                        conn.rollback();
                } catch(SQLException sqle) {
                    if(LOG.isErrorEnabled()) {
                        LOG.error("SQLException rolling back connection", sqle);
                    }
                }


                if(LOG.isErrorEnabled()) {
                    LOG.error("Error creating database schema", sql);
                }
                throw new PortletContainerException(sql);
            }
            finally {
                try {
                    conn.setAutoCommit(autoCommit);
                }
                catch(SQLException sql) {
                    if(LOG.isErrorEnabled()) {
                        LOG.error("Error resetting autocommit.",sql);
                    }
                }
                cleanup(conn, stmt, null);
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
            rs   = stmt.executeQuery("SELECT count(*) FROM SYS.SYSTABLES WHERE TABLENAME = 'VERSION'");
            if(rs.next()) {
                found = rs.getInt(1) == 1;
            }
            else throw new SQLException("No results returned.  Should never happen for count(*)");
        }
        catch(SQLException sql) {
            if(LOG.isErrorEnabled()) {
                LOG.error("Error testing database validity", sql);
            }
            throw new PortletContainerException(sql);
        }
        finally {
            cleanup(conn, stmt, rs);
        }
       return found;
    }

    private ArrayList readScript() throws IOException {
        InputStream in = getClass().getResourceAsStream("/create_schema.sql");
        if(in == null) {
            throw new IOException("Unable to find schemal data definition");
        }

        BufferedReader input = new BufferedReader(new InputStreamReader(in));

        ArrayList commands = new ArrayList();
        StringBuffer sb = new StringBuffer();
        String read;

        if(LOG.isDebugEnabled()) {
            LOG.debug("Adding SQL Commands for schema creation");
        }

        while( (read = input.readLine()) != null) {
            read = read.trim();
            if(read.startsWith("--"))
                continue;

           if(read.indexOf(';') > -0) {
                read = read.replace(';', ' ');
                if(LOG.isDebugEnabled()) {
                    LOG.debug(sb.toString());
                }
                commands.add(sb.append(read).toString());
                sb = new StringBuffer();
               continue;
            }

            if(read.length() > 0) {
                sb.append(read).append(" ");
           }
        }

        input.close();
        return commands;
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
