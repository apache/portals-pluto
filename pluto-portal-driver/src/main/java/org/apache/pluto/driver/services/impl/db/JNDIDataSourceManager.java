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
package org.apache.pluto.driver.services.impl.db;

import org.apache.pluto.PortletContainerException;
import org.apache.pluto.driver.services.impl.db.DataSourceManager;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 * Provides access to the DataSource used for Derby.
 * Provided so that advanced configuration may be
 * provided in the future.
 *
 */
public class JNDIDataSourceManager implements DataSourceManager {

    private String jndiName;

    private DataSource dataSource;

    public JNDIDataSourceManager(String jndiName) {
        this.jndiName = jndiName;
    }


    public void startup() throws PortletContainerException {
        try {
            Context ctx = new InitialContext();
            ctx = (Context)ctx.lookup("java:comp/env");
            dataSource = (DataSource)ctx.lookup(jndiName);
        }
        catch(NamingException ne) {
           throw new PortletContainerException(ne);
        }
   }

    public void shutdown() throws PortletContainerException {
        if(dataSource != null)
            dataSource = null;
    }

    public boolean isRunning() {
        return dataSource != null;
    }


    public DataSource getPortalDataSource() {
        return dataSource;
    }
}
