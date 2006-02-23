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
package org.apache.pluto.optional.db.preferences;

//import java.sql.Connection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.core.PortletPreference;
import org.apache.pluto.optional.db.common.DataSourceManager;
import org.apache.pluto.spi.optional.PortletPreferencesService;

import javax.portlet.PortletRequest;
import java.sql.SQLException;

/**
 * The Portal Driver's PortletPreferencesService implementation. This
 * implementation makes use of the embeded derby db for writing portlet preferences.
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 * @version 1.0
 * @since Sep 22, 2004
 */
public class DBPortletPreferencesService
    implements PortletPreferencesService {

    private static final Log LOG =
        LogFactory.getLog(DBPortletPreferencesService.class);

    private DataSourceManager dataSourceManager;

    private PreferencesDao dao;

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
                LOG.error(msg, pce);
                try {
					dataSourceManager.shutdown();
				} catch (PortletContainerException e) {
	                throw new InstantiationException(msg + e.getMessage());
				}
                throw new InstantiationException(msg);
            }
        }
        dao = new PreferencesDao(dataSourceManager.getPortalDataSource());
    }

    public PortletPreference[] getStoredPreferences(PortletWindow window,
                                                    PortletRequest req)
    throws PortletContainerException {
    	PortletPreference[] prefs = null;
        try {

        	if (window == null) {
        		throw new PortletContainerException("Null PortletWindow");
        	}

            String user = req.getRemoteUser();
        	if (user == null) {
        		user = "ANONYMOUS";
        	}

            String context = window.getContextPath();
        	String portlet = window.getPortletName();

            if (LOG.isDebugEnabled()) {
        		LOG.debug("Retrieving preferences for user '" + user +
        				"' at context '" + context +
        				"' for portlet '" + portlet + "'");
        	}
            prefs = dao.getPreferences(context, portlet, user);
        }
        catch(SQLException e) {
        	LOG.error(e);
            throw new PortletContainerException(e);
        }

        return prefs;
    }

    public void store(PortletWindow window,
                      PortletRequest request,
                      PortletPreference[] preferences)
        throws PortletContainerException {
        try {
        	if (window == null) {

        		throw new PortletContainerException("Null PortletWindow");
        	}
        	if (preferences == null) {
        		throw new PortletContainerException("Null PortletPreference array");
        	}
        	if (preferences.length == 0) {
        		LOG.warn("No preferences to store!");
        	}
        	String user = request.getRemoteUser();
        	if (user == null) {
        		user = "ANONYMOUS";
        	}
        	String context = window.getContextPath();
        	String portlet = window.getPortletName();
        	if (LOG.isDebugEnabled()) {
        		LOG.debug("Retrieving preferences for user '" + user +
        				"' at context '" + context +
        				"' for portlet '" + portlet + "'");
        	}
            dao.storePreferences(context, portlet, user, preferences);
       }
        catch(SQLException e) {
        	LOG.error(e);
            throw new PortletContainerException(e);
        }
    }
}

