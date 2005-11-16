package org.apache.pluto.derby;

import java.io.File;
import java.io.IOException;
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
 * TODO: transactional support 
 * TODO: support for other schemas
 * 
 * @author cdoremus
 *
 */
public class DerbyDataStore {

    private static final Log LOG =
        LogFactory.getLog(DerbyDataStore.class);
    //TODO: We need to support other DB schemas
    private static final String DB_USER = "container";
    private static final String DB_PWD = "container";
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DATABASE = "PlutoDB";
    private static final String PROTOCOL = "jdbc:derby:" + DATABASE;

    static {
    	init();
    }
    
	 public DerbyDataStore() {
		super();
	}

	 public DerbyDataStore(boolean autocommit) {
			super();
			// FIXME: Not yet implemented
			// TODO: Add autocommit field and commit() method
			//	for manual commits/ transactions.
			throw new UnsupportedOperationException("Manual commit and transactional support needs to be implemented");
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
    		File dbdir = new File(home.getAbsolutePath() + "/" + DATABASE);
	    	if (!dbdir.exists()) {
	    		StringBuffer msg = new StringBuffer();
	    		msg.append("The Derby database needs to be created. ");
	    		msg.append("Run the build-container.sql script to do this. ");	    		
	    		msg.append("Make sure the settings for MAVEN_REPO in env.bat points to your local maven2 repository. ");
    			throw new IllegalStateException(msg.toString());	    		
	    	}
    		
    		/* TODO: MOVE THIS INTO A MAVEN PLUGIN
    		//Create derby database	    		
	    	if (!home.exists()) {

	    		if (!home.mkdirs()) {
	    			throw new IllegalStateException("Data directories not properly created.");
	    		}
		    	//create the Database if not exist
	    		File database = new File(home.getAbsolutePath() + "/" + DATABASE);
	    		if (!database.exists()) {
	    			//run ij to create the database
	    			System.setProperty("ij.protocol", "jdbc:derby:");	    			
	    			System.setProperty("ij.database", DATABASE + ";create=true;name=" + DB_USER + ";password=" + DB_PWD);
	    			//set argument to script location
	    			//FIXME: add proper script location
	    			String[] args = {""};
	    			try {
						ij.main(args);
					} catch (IOException e) {
						LOG.error("Problem running ij.",e);
					}
	    		}
	    	}
*/	    		
	    	
	 }
	 
	public int doUpdate(String sql, Object[] parameters ) throws SQLException {
    	int rows = 0;
    	PreparedStatement ps = null;
    	Connection conn = null;
    	try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			populatePreparedStatement(parameters, ps);
			rows = ps.executeUpdate();
			conn.commit();
    	} catch (SQLException e) {
    		if (conn != null) {
    			conn.rollback();
    		}
    		throw e;
    	} finally {
    		if (ps != null) {
    			ps.close();
    		}
    		closeConnection(conn);
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
    	Connection conn = null;
    	ResultSet rs = null;
    	try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			populatePreparedStatement(parameters, ps);
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int len = md.getColumnCount();
			Map row = null;
			while (rs.next()) {
				row = new HashMap();
				//go through each column
				for (int i = 0; i < len; i++) {
					int colno = i + 1;
					int type = md.getColumnType(colno);
					String name = md.getColumnName(colno);
					if (LOG.isDebugEnabled()) {
//						LOG.debug("Col " + colno + " name=" + name + " type=" + type);
					}
					if (type == Types.VARCHAR ||
							type == Types.CHAR) {				
//						LOG.debug("String col" + colno + " name=" + name + " type=" + type);
						row.put(name, rs.getString(colno));
					} else if (type == Types.INTEGER) {
//						LOG.debug("Int col" + colno + " name=" + name + " type=" + type);
						row.put(name, new Integer(rs.getInt(colno)));
					} else if (type == Types.DECIMAL  ||
							type == Types.DOUBLE ||				
							type == Types.FLOAT ) {				
						row.put(name, rs.getBigDecimal(colno));
					} else if (type == Types.TIMESTAMP) {
						row.put(name, rs.getTimestamp(colno));
					} else {
						row.put(name, rs.getObject(colno));
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
    	} finally {
    		if (ps != null) {
    			ps.close();
    		}
    		if (rs != null) {
    			rs.close();
    		}
    		if (conn != null) {
    			conn.commit();
    		}
    		closeConnection(conn);
    	}
		return results;
    }

    private int getGeneratedId() throws SQLException {
    	int id = 0;
    	String sql = "values IDENTITY_VAL_LOCAL()";
    	PreparedStatement ps = null;
    	Connection conn = null;
    	ResultSet rs = null;
    	try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			ResultSetMetaData md = rs.getMetaData();
			if (LOG.isDebugEnabled()) {
				LOG.debug("Col count=" + md.getColumnCount());
			}
			int type = md.getColumnType(1);
			String name = md.getColumnName(1);
			if (LOG.isDebugEnabled()) {
				LOG.debug("Col name=" + name + "; Col type=" + type);
			}
//			if (LOG.isDebugEnabled()) {
//				LOG.debug("id: " + rs.getObject(1));
//			}
			
			id = rs.getInt(1);
			
    	} finally {
    		if (ps != null) {
    			ps.close();
    		}
    		if (rs != null) {
    			rs.close();
    		}
    		if (conn != null) {
    			conn.commit();
    		}
    		closeConnection(conn);
    	}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Id retreived=" + id);
		}    	
    	return new Long(id).intValue();
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
		for (int i = 0; i < parameters.length; i++) {
			
			value = parameters[i];
			//FIXME: Need to handle null values
			if (value instanceof String) {
				
				ps.setString(i + 1, (String) value);
				
			} else if (value instanceof Integer){
				int val = ((Integer)value).intValue();
				ps.setInt(i + 1, val);
			} else if (value instanceof Timestamp){
				ps.setTimestamp(i + 1, (Timestamp)value);
			} else {
				ps.setObject(i + 1, value);
			}
		}
	}

/*	
    private void go(String[] args)
    {

        Connection conn = null;

        try
        {

            conn = getConnection();

            Statement s = conn.createStatement();

            s.execute("create table derbyDB(num int, addr varchar(40))");
            System.out.println("Created table derbyDB");
            s.execute("insert into derbyDB values (1956,'Webster St.')");
            System.out.println("Inserted 1956 Webster");
            s.execute("insert into derbyDB values (1910,'Union St.')");
            System.out.println("Inserted 1910 Union");
            s.execute(
                "update derbyDB set num=180, addr='Grand Ave.' where num=1956");
            System.out.println("Updated 1956 Webster to 180 Grand");

            s.execute(
                "update derbyDB set num=300, addr='Lakeshore Ave.' where num=180");
            System.out.println("Updated 180 Grand to 300 Lakeshore");

            ResultSet rs = s.executeQuery(
                    "SELECT num, addr FROM derbyDB ORDER BY num");


            if (!rs.next())
            {
                throw new Exception("Wrong number of rows");
            }


            rs.close();
            s.close();
            System.out.println("Closed result set and statement");

			conn.commit();

        }
        catch (Throwable e)
        {
            System.out.println("exception thrown:");

            if (e instanceof SQLException)
            {
                printSQLError((SQLException) e);
            }
            else
            {
                e.printStackTrace();
            }
        } finally {
         try {
			 conn.close();
			 System.out.println("Committed transaction and closed connection");

			 shutdown();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        	
        }

        System.out.println("SimpleApp finished");
    }
*/

	/**
	 * @param props
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		Connection conn;
        /*
        The driver is installed by loading its class.
        In an embedded environment, this will start up Derby, since it is not already running.
      */
		try {
			Class.forName(DRIVER).newInstance();
		} catch (InstantiationException e) {
			SQLException se = new SQLException();
			se.initCause(e);
			throw se;
		} catch (IllegalAccessException e) {
			SQLException se = new SQLException();
			se.initCause(e);
			throw se;
		} catch (ClassNotFoundException e) {
			SQLException se = new SQLException();
			se.initCause(e);
			throw se;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Loaded the appropriate driver");			
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

		if (LOG.isDebugEnabled()) {
		    LOG.debug("Connected to database PlutoDB");
		}
		conn.setAutoCommit(false);
		return conn;
	}

	private void closeConnection(Connection conn) {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				LOG.warn("Database connection could not be closed.", e);
			}
			shutdown();
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
	private void shutdown() {
		
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
		    else
		    {
		    	if (LOG.isDebugEnabled()) {
			        LOG.debug("Database shut down normally");		    		
		    	}
		    }
	}

    static void printSQLError(SQLException e)
    {
        while (e != null)
        {
            System.out.println(e.toString());
            e = e.getNextException();
        }
    }

}
