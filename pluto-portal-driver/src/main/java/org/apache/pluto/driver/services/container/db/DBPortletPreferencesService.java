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

import java.sql.Connection;
import java.sql.SQLException;

import javax.portlet.PortletRequest;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.core.PortletPreference;
import org.apache.pluto.services.optional.PortletPreferencesService;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

/**
 * The Portal Driver's PortletPreferencesService implementation. This
 * implementation makes use of the embeded derby db for writing portlet preferences.
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 22, 2004
 */
public class DBPortletPreferencesService
    implements PortletPreferencesService {

    private static final Log LOG =
        LogFactory.getLog(DBPortletPreferencesService.class);

    private DataSourceManager dataSourceManager;

    public DBPortletPreferencesService(DataSourceManager dataSourceManager)
    throws InstantiationException {
        this.dataSourceManager = dataSourceManager;
        if(!dataSourceManager.isRunning()) {
            try {
                dataSourceManager.startup();
            }
            catch(PortletContainerException pce) {
                String msg =
                   "Unable to startup portlet preferences service due to dataSourceManager error."+
                   pce.getMessage();
                if(LOG.isErrorEnabled()) {
                    LOG.error(msg, pce);
                }
                throw new InstantiationException(msg);
            }
        }
    }

    public PortletPreference[] getStoredPreferences(PortletWindow window,
                                                    PortletRequest req)
    throws PortletContainerException {

        try {
            Connection conn = getConnection();
            conn.close();
        }
        catch(SQLException sql) {
            throw new PortletContainerException(sql);
        }
        return new PortletPreference[0];
    }

    public void store(PortletWindow window,
                      PortletRequest request,
                      PortletPreference[] preferences)
        throws PortletContainerException {
        try {
            Connection conn = getConnection();
            conn.close();
        }
        catch(SQLException sql) {
            throw new PortletContainerException(sql);
        }
    }

    private Connection getConnection() throws SQLException {
        return dataSourceManager.getPortalDataSource().getConnection();
    }

}

