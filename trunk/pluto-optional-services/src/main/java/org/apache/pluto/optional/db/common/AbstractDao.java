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
package org.apache.pluto.optional.db.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.sql.DataSource;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

/**
 * TODO JavaDoc
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Nov 23, 2005
 */
public abstract class AbstractDao {

    private static final Log LOG =
        LogFactory.getLog(AbstractDao.class);

    private DataSource dataSource;

    public AbstractDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected abstract InstantiationResult instantiate(ResultSet rs, InstantiationResult result)
        throws SQLException;

    public class InstantiationResult {
        private Object result;
        private Object control;

        public Object getResult() {
            return result;
        }

        public void setResult(Object result) {
            this.result = result;
        }

        public Object getControl() {
            return control;
        }

        public void setControl(Object control) {
            this.control = control;
        }
    }


    /**
     * Select and instantiate a collection of items based upon
     * the provided sql.
     *
     * @param sql the sql to be executed for the select
     * @return a list of objects returned from the query
     * @throws SQLException
     */
    protected List doList(String sql) throws SQLException {
        ArrayList list = new ArrayList();

        Connection conn = null;
        Statement  stmt = null;
        ResultSet  rs   = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            InstantiationResult inst = null;
            while(rs.next()) {
                inst = instantiate(rs, inst);
                if(inst.getResult() != null)
                    list.add(inst.getResult());
            }
        }
       finally {
            cleanup(conn, stmt, rs);
        }
        return list;
    }

    /**
     * Select and instantiate a single object based upon the
     * provided sql.
     *
     * @param sql the sql to be executed
     * @return the selected object
     * @throws SQLException if a database error occurs or more than one row is returned
     */
    protected Object doSelect(String sql) throws SQLException {
        List values = doList(sql);
        if(values.size() > 1)
            throw new SQLException("SQL Query returned more than one row. ");
        return values.size() == 1 ? values.get(0) : null;
    }


    /**
     * Perform a JDBC executeUpdate in order to process an
     * SQL insert or update
     *
     * @param sql the sql that should be executed
     * @return the number of rows updated
     * @throws SQLException
     */
    protected int doSave(String sql) throws SQLException {
        Connection conn = null;
        Statement stmt =  null;
        int number = 0;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            number = stmt.executeUpdate(sql);
        }
        finally {
            cleanup(conn, stmt, null);
        }
        return number;
    }

    protected int[] doBatch(List sqls) throws SQLException {
        Connection conn = null;
        Statement stmt =  null;
        int[] number;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            Iterator it = sqls.iterator();
            while(it.hasNext()) {
                stmt.addBatch(it.next().toString());
            }
            number = stmt.executeBatch();
        }
        finally {
            cleanup(conn, stmt, null);
        }
        return number;
    }

    /**
     * Format a string value into a quoted string
     * for sql inclusion.
     *
     * @param value
     * @return the properly quoted version of the string
     */
    protected String fmt(String value) {
        return "'"+value+"'";
    }

    /**
     * Retrieve a connection for this dao.
     * @return
     * @throws SQLException
     */
    protected Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * Cleanup and close each connection, stmt, and result set.
     * @param conn
     * @param stmt
     * @param rs
     */
    protected void cleanup(Connection conn, Statement stmt, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            }
            catch(SQLException sql) {
                if(LOG.isWarnEnabled()) {
                    LOG.warn("Unable to successfully close connection");
                }
            }
        }

        if(stmt != null) {
            try {
                stmt.close();
            }
            catch(SQLException sql) {
                if(LOG.isWarnEnabled()) {
                    LOG.warn("Unable to successfully close stmtection");
                }
            }
        }

        if(conn != null) {
            try {
                conn.close();
            }
            catch(SQLException sql) {
                if(LOG.isWarnEnabled()) {
                    LOG.warn("Unable to successfully close connection");
                }
            }
        }
    }
}