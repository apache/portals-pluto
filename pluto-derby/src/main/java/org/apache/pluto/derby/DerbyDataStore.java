package org.apache.pluto.derby;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Basic CRUD operations using Apache Derby.
 * 
 * TODO: Add support for other schemas
 * 
 * @author <a href="mailto:cdoremus@apache.org">Craig Doremus</a>
 *
 */
public class DerbyDataStore {

    private static final Log LOG =
        LogFactory.getLog(DerbyDataStore.class);
    //TODO: We need to support other DB schemas
    public static final String DB_USER = "container";
    public static final String DB_PWD = "container";
    private static final String DRIVER =  "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String DATABASE_NAME = "PlutoDB";
    private static final String PROTOCOL = "jdbc:derby:" + DATABASE_NAME;
    private Connection conn = null;
    private boolean autocommit = true;
    
    static {
    	init();
    }
    
	 public DerbyDataStore() {
		super();
		
	}

	 public DerbyDataStore(boolean autocommit) {
			super();
			this.autocommit = autocommit ;
		}

	 /**
	  * 
	  *
	  */
	 private static void init() {
	    	String userhome = System.getProperty("user.home");
	    	File home = new File (userhome + "/.pluto/derby");
    		String dbhome = home.getAbsolutePath();
    		if (LOG.isDebugEnabled()) {
    			LOG.debug("Database home: " + dbhome);
    		}
	    	System.setProperty("derby.system.home", dbhome);		 
    		File dbdir = new File(home.getAbsolutePath() + "/" + DATABASE_NAME);
	    	if (!dbdir.exists()) {
	    		StringBuffer msg = new StringBuffer();
	    		msg.append("The Derby database needs to be created. ");
	    		msg.append("Run the build-container.sql script to do this. ");	    		
	    		msg.append("Make sure the settings for MAVEN_REPO in env.bat points to your local maven2 repository. ");
	    		IllegalStateException e = new IllegalStateException(msg.toString());
	    		LOG.error(e);
	    		throw e;
	    	}
    			    	
	 }
	 
	public int doUpdate(String sql, Object[] parameters ) throws SQLException {
    	int rows = 0;
    	PreparedStatement ps = null;
    	try {
			createConnection();
			ps = conn.prepareStatement(sql);
			populatePreparedStatement(parameters, ps);
			rows = ps.executeUpdate();
			if (autocommit) {
				conn.commit();
			}
    	} catch (SQLException e) {
			LOG.error(e);
    		if (autocommit && conn != null) {
    			conn.rollback();
    		}
    		throw e;
    	} catch (Throwable e) {
			LOG.error(e);
    		if (autocommit && conn != null) {
    			conn.rollback();
    		}
    		SQLException e1 = new SQLException();
    		e1.initCause(e);
    		throw e1;
    	} finally {
    		cleanup(ps, null);
    	}
		return rows;
    }

    public int doInsert(String sql, Object[] parameters ) throws SQLException {
    	doUpdate(sql, parameters);
    	return getGeneratedId();
    }    

    public int doDelete(String sql, Object[] parameters ) throws SQLException {
    	return doUpdate(sql, parameters);
    }    

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
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
			createConnection();
			ps = conn.prepareStatement(sql);
			populatePreparedStatement(parameters, ps);
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int len = md.getColumnCount();
			if (LOG.isDebugEnabled()) {
				LOG.debug("Number of columns in ResultSet=" + len);
			}
			Map row = null;
			int rows = 0;
			while (rs.next()) {
				rows++;
				row = new HashMap();
				//go through each column
				for (int i = 0; i < len; i++) {
					int colno = i + 1;
					int type = md.getColumnType(colno);
					String name = md.getColumnName(colno);
					if (LOG.isTraceEnabled()) {
						LOG.trace("Col " + colno + " name=" + name + " type=" + type);
					}
					if (type == Types.VARCHAR ||
							type == Types.CHAR) {
//						LOG.debug("String col" + colno + " name=" + name + " type=" + type);
						String val = rs.getString(colno);
						row.put(name, val);
					} else if (type == Types.INTEGER) {
//						LOG.debug("Int col" + colno + " name=" + name + " type=" + type);
						Integer val = new Integer(rs.getInt(colno));
						row.put(name, val);
					} else if (type == Types.DECIMAL  ||
							type == Types.DOUBLE ||				
							type == Types.FLOAT ) {				
						BigDecimal val = rs.getBigDecimal(colno);
						row.put(name, val);
					} else if (type == Types.TIMESTAMP) {
						Timestamp val = rs.getTimestamp(colno);
						row.put(name, val);
					} else {
						Object val = rs.getObject(colno);
						row.put(name, val);
					}
				}
				if (LOG.isDebugEnabled()) {
					Set keys = row.keySet();
					Iterator iter = keys.iterator();
					while (iter.hasNext()) {
						String key = (String)iter.next();
						Object val = row.get(key);
						LOG.debug("Field name=" + key + " value=" + val);
					}
				}				
				results.add(row);
			}
			if (LOG.isTraceEnabled()) {
				LOG.trace("Rows in ResultSet=" + rows);
			}
			conn.commit();
    	} catch (SQLException e) {
    		LOG.error(e);
    		if (autocommit && conn != null) {
    			conn.rollback();
    		}
    		throw e;			
    	} catch (Throwable e) {
    		LOG.error(e);
    		if (autocommit && conn != null) {
    			conn.rollback();
    		}
    		SQLException e1 = new SQLException();
    		e1.initCause(e);//add underlying cause
    		throw e1;			
    	} finally {
    		cleanup(ps, rs);
    	}
		return results;
    }

    /**
     * Gets the most recently generated primary key using the
     * IDENTITY_VAL_LOCAL() function. 
     * 
     * @return
     * @throws SQLException
     */
    public int getGeneratedId() throws SQLException {
    	int id = 0;
    	String sql = "select IDENTITY_VAL_LOCAL() from portlet";
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
			createConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			ResultSetMetaData md = rs.getMetaData();
			if (LOG.isTraceEnabled()) {
				LOG.trace("Col count=" + md.getColumnCount());
			}
			int type = md.getColumnType(1);
			String name = md.getColumnName(1);
			if (LOG.isTraceEnabled()) {
				LOG.trace("Col name=" + name + "; Col type=" + type);
			}
			
			id = rs.getInt(1);
			conn.commit();
    	} catch (SQLException e) {
    		LOG.error(e);
    		if (autocommit && conn != null) {
    			conn.rollback();
    		}
    		throw e;			
    	} finally {
    		cleanup(ps, rs);    		
    	}

		if (LOG.isTraceEnabled()) {
			LOG.trace("Id retreived=" + id);
		}    	
    	return new Long(id).intValue();
    }

	/**
	 * @param ps
	 * @param rs
	 * @throws SQLException
	 */
	private void cleanup(PreparedStatement ps, ResultSet rs) throws SQLException {
		if (ps != null) {
			ps.close();
		}
		if (rs != null) {
			rs.close();
		}
	}
    	
    /**
	 * 
	 * 
	 * @param parameters
	 * @param ps
	 * @throws SQLException
	 */
	private void populatePreparedStatement(Object[] parameters, PreparedStatement ps) throws SQLException {
		//Loop through each value, determine it's corresponding SQL type,
		//and stuff that value into the prepared statement.
		Object value = null;
		int len = parameters.length;
		if (LOG.isTraceEnabled()) {
			LOG.trace("Parameter count: " + parameters.length);
		}
		int colno = 0;
		for (int i = 0; i < len; i++) {
			colno = i + 1;
			value = parameters[i];
//			if (LOG.isTraceEnabled()) {
//				LOG.trace("Parameter value=" + value);
//			}
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

	/**
	 * @param props
	 * @return
	 * @throws SQLException
	 */
	private void createConnection() throws SQLException {
		if (conn == null) {
	        /*
	        The driver is installed by loading its class.
	        In an embedded environment, this will start up Derby, since it is not already running.
	      */
			try {
				Class.forName(DRIVER).newInstance();
			} catch (InstantiationException e) {
				LOG.error(e);
				SQLException se = new SQLException();
				se.initCause(e);
				throw se;
			} catch (IllegalAccessException e) {
				LOG.error(e);
				SQLException se = new SQLException();
				se.initCause(e);
				throw se;
			} catch (ClassNotFoundException e) {
				LOG.error(e);
				SQLException se = new SQLException();
				se.initCause(e);
				throw se;
			}
			
	        Properties props = new Properties();
	        props.put("user", DB_USER);
	        props.put("password", DB_PWD);
			/*
			   The connection specifies create=true to cause
			   the database to be created. To remove the database,
			   remove the directory derbyDB and its contents.
			   The directory derbyDB will be created under
			   the directory that the system property
			   derby.system.home points to, or the current
			   directory if derby.system.home is not set.
			 */
			conn = DriverManager.getConnection(PROTOCOL, props);
	
		}
		conn.setAutoCommit(autocommit);
		return ;
	}

	public void commit(){
		if (conn != null) {
			try {
				conn.commit();
			} catch (SQLException e) {
				LOG.warn("Database connection could not be committed.", e);
			}
			if (autocommit) {
				closeConnection();
			}
		}
	}

	public void rollback(){
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				LOG.warn("Database connection could not be rollbacked.", e);
			}
			if (autocommit) {
				closeConnection();
			}
		}
	}
	
	public void closeConnection() {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				LOG.warn("Database connection could not be closed.", e);
			}
//			shutdown();
		}
	}
	
	/**
		   In embedded mode, an application should shut down Derby.
		   If the application fails to shut down Derby explicitly,
		   the Derby does not perform a checkpoint when the JVM shuts down, 
		   which means  that the next connection will be slower.
		   Explicitly shutting down Derby with the URL is preferred.
		   This style of shutdown will always throw an "exception".
	 * 
	 */
	public static void shutdown() {
		
		boolean gotSQLExc = false;

		    try
		    {
		        DriverManager.getConnection("jdbc:derby:;shutdown=true");
		    }
		    catch (SQLException se)
		    {
		        gotSQLExc = true;
		    }

		    if (!gotSQLExc)
		    {
		        LOG.warn("Database did not shut down normally");
		    }
	}
}
