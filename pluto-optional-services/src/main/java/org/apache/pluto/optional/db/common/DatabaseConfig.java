package org.apache.pluto.optional.db.common;

/**
 * Holds static methods to access database configuration information.
 *  These methods should get their data from a configuration file.
 *  
 * @author <a href="mailto:cdoremus@apache.org">Craig Doremus</a>
 */
public class DatabaseConfig {

	
    public static String getDatabaseName() {
    	return "PLUTO_PORTAL_DRIVER" ;
    }
    
    public static String getUsername() {
    	return "pluto_portal_driver";
    }

    public static String getPassword() {
    	return "apachep0rtals";
    }

    /**
     * Relevant for Derby. The database will be in a subdirectory
     * of the return value from this method with the directory named the 
     * same as the database name. 
     * The value returned from this method corresponds to the system property
     * derby.system.home.
     * 
     * @return Path to directory holding the database.
     */
    public static String getDatabasePath() {
    	StringBuffer sb = new StringBuffer();
    	sb.append(System.getProperty("user.home"));
    	sb.append("/.pluto/portal-driver/data");
    	return sb.toString();
    }


}
