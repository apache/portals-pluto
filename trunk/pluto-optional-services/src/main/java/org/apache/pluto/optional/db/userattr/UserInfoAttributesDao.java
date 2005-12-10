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
package org.apache.pluto.optional.db.userattr;

import org.apache.pluto.core.UserInfoAttribute;
import org.apache.pluto.optional.db.common.AbstractPreparedDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * Dao for user information attrubute persistence.
 *
 * @author <a href="mailto:cdoremus@apache.org">Craig Doremus</a>:
 * @version 1.0
 */
class UserInfoAttributesDao extends AbstractPreparedDao {

    private static final Log LOG =  LogFactory.getLog(UserInfoAttributesDao.class);

    UserInfoAttributesDao(DataSource dataSource) {
        super(dataSource);
    }

    Map getAttributes(String authUser)
    	throws SQLException {
    	UserInfoAttribute[] attributes = null;
        if(LOG.isDebugEnabled()) {
            LOG.debug("Retrieving user info attributes for: " +authUser);
        }

        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ua.attribute_name, uav.attribute_value ")
          .append("  FROM user_info_attribute ua, user_info_attriute_value uav ")
          .append("   WHERE uav.auth_user = ").append(fmt(authUser))
          .append("   AND ua.user_info_attribute_id = uav.user_info_attribute_id");

        if(LOG.isDebugEnabled()) {
            LOG.debug("Executing SQL to retrieve user info attribs: \n"+sb.toString());
        }

        List list = super.doList(sb.toString());
//        PortletPreferenceContainer container = new PortletPreferenceContainer();
//        container.add(list);
//        return container.createPreferences();
        //TODO: finish impl
        throw new UnsupportedOperationException("Not yet implemented");
//        return attributes;
    }


    private String createUserInfoAttributesInsertSql() {
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO user_info_attribute_value (preference_id, preference_value) ")
          .append("     VALUES ( " )
          .append("             (SELECT preference_id " )
          .append("                FROM preference pr, portlet plt, portlet_app pa ")
          .append("               WHERE pa.app_context = ? ")
          .append("                 AND plt.portlet_app_id = pa.portlet_app_id ")
          .append("                 AND plt.portlet_name = ? ")
          .append("                 AND pr.portlet_id = plt.portlet_id ")
          .append("                 AND pr.preference_name = ?")
          .append(        "), ?)");
        return sb.toString();
    }

   void storeAttributes(UserInfoAttribute[] attributes)
    throws SQLException {

       boolean autoCommit = false;

       Connection conn = null;

       PreparedStatement stmt = null;
       //TODO: delete old attributes or update them

       try {
           conn = getConnection();
           autoCommit = conn.getAutoCommit();
           conn.setAutoCommit(false);

           stmt = conn.prepareStatement(createUserInfoAttributesInsertSql());


           for(int i=0; i < attributes.length; i++) {

               stmt.setString(1, attributes[i].getName());
               stmt.setString(2, attributes[i].getValue());
               stmt.setString(3, attributes[i].getAuthUser());

               stmt.addBatch();

           }
//      		stmt.executeBatch();

           conn.commit();
           //TODO: finish impl
           throw new UnsupportedOperationException("Not yet implemented");
       }
       catch(SQLException e) {
           if(LOG.isErrorEnabled()) {
               LOG.error("Error saving preferences: ", e);
           }
           if (conn != null) {
        	   conn.rollback();
           }
           throw e;
       }
       catch(Throwable e) {
           if(LOG.isErrorEnabled()) {
               LOG.error("Error saving preferences: ", e);
           }
           if (conn != null) {
        	   conn.rollback();
           }
           //Make sure the client knows about problem
           SQLException e1 = new SQLException();
           e1.initCause(e);
           throw e1;
       } 
       finally {
           conn.setAutoCommit(autoCommit);
           cleanup(null, stmt, null);
       }
    }

    protected InstantiationResult instantiate(ResultSet rs, InstantiationResult result) throws SQLException {
        String name  = rs.getString("attribute_name");
        String value = rs.getString("attribute_value");
        //TODO: finish impl
        throw new UnsupportedOperationException("Not yet implemented");
//        return new UserInfoAttributesImpl(name value);
    }

}
