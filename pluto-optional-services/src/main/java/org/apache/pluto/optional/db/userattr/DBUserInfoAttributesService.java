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
package org.apache.pluto.optional.db.userattr;

import java.sql.SQLException;
import java.util.Map;

import javax.portlet.PortletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.pluto.PortletContainerException;
import org.apache.pluto.core.UserInfoAttribute;
import org.apache.pluto.optional.db.common.DataSourceManager;
import org.apache.pluto.services.optional.UserInfoAttributesService;


/**
 * The Portal Driver's UserInfoAttributeService implementation. This
 * implementation makes use of the embeded Derby db.
 * 
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 * @version 1.0
 */
public class DBUserInfoAttributesService
    implements UserInfoAttributesService {

    private static final Log LOG =
        LogFactory.getLog(DBUserInfoAttributesService.class);

    private DataSourceManager dataSourceManager;

    private UserInfoAttributesDao dao;

    public DBUserInfoAttributesService(DataSourceManager dataSourceManager)
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
                throw new InstantiationException(msg);
            }
        }
        dao = new UserInfoAttributesDao(dataSourceManager.getPortalDataSource());
    }

    public Map getAttributes(PortletRequest req)
    	throws PortletContainerException {
    	
    	Map attribs = null;
        String user = req.getRemoteUser();
        //Acording to PLT.17.2, return null if user is unauthenticated
    	if (user == null) {
	        try {
	            attribs = dao.getAttributes(user);
	        }
	        catch(SQLException e) {
	        	LOG.error(e);
	            throw new PortletContainerException(e);
	        }
    	}
        return attribs;
    }

    public void store(UserInfoAttribute[] attributes)
        throws PortletContainerException {
    	if (attributes == null) {
    		throw new PortletContainerException("Null UserInfoAttributes array");
    	}
    	if (attributes.length == 0) {
    		LOG.warn("No user info attribs to store!");
    	}
        try {
            dao.storeAttributes(attributes);
        	//TODO: finish implementing this method
            throw new UnsupportedOperationException("Not yet implemented");
       }
        catch(SQLException e) {
        	LOG.error(e);
            throw new PortletContainerException(e);
        }
    }
}

