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

import javax.sql.DataSource;


/**
 * Provides access to the DataSource used for Derby.
 * Provided so that advanced configuration may be
 * provided in the future.
 *
 */
public class EmbeddedDataSourceManager implements DataSourceManager {

    private String connectionString;


    private String shutdown =  "shutdownDatabase=true";

    private EmbeddedDataSource embeddedDataSource;

    public EmbeddedDataSourceManager() {
        connectionString =
            "databaseName=PLUTO_PORTAL_DRIVER;name=pluto;password=apachep0rtals;create=true";

        System.setProperty(
            "derby.system.home",
            System.getProperty("user.home") + ".pluto/portal-driver/data"
        );
    }

    public EmbeddedDataSourceManager(String connectionString, String systemDirectory) {
        this.connectionString = connectionString;
        System.setProperty("derby.system.home", systemDirectory);
    }

    public void startup() {
        embeddedDataSource = new EmbeddedDataSource();
        embeddedDataSource.setConnectionAttributes(connectionString);
        initDatabase();
    }

    public void shutdown() {
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
    private void initDatabase() {
        if(!isDatabaseInitialized()) {

        }
            // 1) Read in the PORTABLE CREATE SQL Script
            // 2) Execute the CREATE Script via JDBC
            // 3) Retrieve default data
            // 4) Insert default data via JDBC
    }

    /**
     * @return true if the database is valid
     */
    private boolean isDatabaseInitialized() {
        // 1) Test for Version Table
        return false;
    }


}
