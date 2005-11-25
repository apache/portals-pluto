package org.apache.pluto.optional.db.support;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.optional.db.support.AbstractDao;

import javax.sql.DataSource;

/**
 * Basic CRUD operations using Apache Derby. Autocommit
 * is set to true by default unless it is set to false using
 * the single parameter constructor.
 * 
 * TODO: Add support for other schemas
 * 
 * @author <a href="mailto:cdoremus@apache.org">Craig Doremus</a>
 *
 */
public abstract class AbstractPreparedDao extends AbstractDao {

    private static final Log LOG =
        LogFactory.getLog(AbstractPreparedDao.class);

    private boolean autocommit = false;

    public AbstractPreparedDao(DataSource dataSource) {
        super(dataSource);
    }

    public AbstractPreparedDao(DataSource dataSource, boolean autocommit) {
        this(dataSource);
        this.autocommit = autocommit ;
    }


    /**
     * Do a standard SQL update using a PreparedStatement.
     *
     * @param sql SQL in PreparedStatement format
     * @param parameters Array of parameters in proper order.
     * @return The number of rows updated
     * @throws SQLException
     */
    protected int doUpdate(String sql, Object[] parameters) throws SQLException {
        int rows = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps   = conn.prepareStatement(sql);
            bindPreparedStatement(parameters, ps);
            rows = ps.executeUpdate();

        } finally {
            cleanup(conn, ps, null);
        }
        return rows;
    }

    public int doUpdate(String sql) throws SQLException {
        return doUpdate(sql, null);
    }

    /**
     * Do a standard SQL insert using a PreparedStatement.
     *
     * @param sql SQL in PreparedStatement format
     * @param parameters Array of parameters in proper order.
     * @return The new generated primary key
     * @throws SQLException
     */
    public int doInsert(String sql, Object[] parameters ) throws SQLException {
        return doUpdate(sql, parameters);
    }

    /**
     * Do a standard SQL delete using a PreparedStatement.
     *
     * @param sql SQL in PreparedStatement format
     * @param parameters Array of parameters in proper order.
     * @return The number of rows updated
     * @throws SQLException
     */
    public int doDelete(String sql, Object[] parameters ) throws SQLException {
        return doUpdate(sql, parameters);
    }

    /**
     * Do a standard SQL delete using a PreparedStatement.
     *
     * @param sql SQL in PreparedStatement format
     * @param id Key of the record(s) to be deleted.
     * @return The number of rows updated
     * @throws SQLException
     */
    public int doDelete(String sql, int id) throws SQLException {
        return doUpdate(sql, new Object[]{new Integer(id)});
    }

    /**
     * Retreives a <code>List</code> of <code>Map</code> objects representing a result set
     * row based on the sql parameter and the array of parameters sent into this method.
     * 
     * The sql field is the <code>Map's</code> key. <code>Map.get(key)</code> would be used
     * to retreive the value of each item in a results set's rows. The Derby database uppercases 
     * the key in the result set, so, for instance, the proper way to retreive the portlet_app_id
     * from a row, would be:
     * <pre>
     *         		Integer oId = (Integer)row.get("PORTLET_APP_ID");//row is a Map item in the result set List 
     * </pre>           			
     *  
     * @param sql The SQL statement to be run as a <code>PreparedStatement</code>
     * @param parameters An <code>Object</code> array of parameters for the <code>PreparedStatement</code>
     * in proper order.
     * @return A <code>List</code> of <code>Map</code> objects.
     * @throws SQLException
     */
    public List doSelect(String sql, Object[] parameters ) throws SQLException {
        List results = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            bindPreparedStatement(parameters, ps);
            rs = ps.executeQuery();
        } finally {
            cleanup(conn, ps, rs);
        }
        return results;
    }

    /**
     * Do a standard SQL select using a PreparedStatement.
     *
     * @param sql SQL in PreparedStatement format
     * @return A <code>List</code> of <code>Map</code> objects.
     * @throws SQLException
     */
    public List doSelect(String sql) throws SQLException {
        return doSelect(sql, null);
    }

    /**
     * Binds a PreparedStatement using appropraite
     * setXXX() methods.
     *
     * @param parameters Parameters
     * @param ps
     * @throws SQLException
     */
    private void bindPreparedStatement(Object[] parameters, PreparedStatement ps) throws SQLException {
        //Loop through each value, determine it's corresponding SQL type,
        //and stuff that value into the prepared statement.
        //Skip everything if parameters are null or empty.
        if (parameters != null && parameters.length > 0) {
            Object value = null;
            int len = parameters.length;
            if (LOG.isTraceEnabled()) {
                LOG.trace("Parameter count: " + parameters.length);
            }
            int colno = 0;
            for (int i = 0; i < len; i++) {
                colno = i + 1;
                value = parameters[i];
                if (value instanceof String) {
                    if (LOG.isTraceEnabled()) {
                        LOG.trace("String Parameter [" + i + "]  value=" + value);
                    }
                    if(value == null) {
                        ps.setNull(colno, Types.VARCHAR);
                    } else {
                        ps.setString(i + 1, (String) value);
                    }
                } else if (value instanceof Integer){
                    if (LOG.isTraceEnabled()) {
                        LOG.trace("Integer Parameter [" + i + "]  value=" + value);
                    }
                    if(value == null) {
                        ps.setNull(colno, Types.INTEGER);
                    } else {
                        int val = ((Integer)value).intValue();
                        ps.setInt(colno, val);
                    }
                } else if (value instanceof Timestamp){
                    if (LOG.isTraceEnabled()) {
                        LOG.trace("Timestamp Parameter [" + i + "]  value=" + value);
                    }
                    if(value == null) {
                        ps.setNull(colno, Types.TIMESTAMP);
                    } else {
                        ps.setTimestamp(colno, (Timestamp)value);
                    }
                } else {
                    if (LOG.isTraceEnabled()) {
                        LOG.trace("Object Parameter [" + i + "]  value=" + value);
                    }
                    if(value == null) {
                        ps.setNull(colno, Types.JAVA_OBJECT);
                    } else {
                        ps.setObject(colno, value);
                    }
                }
            }
        }
    }
}
