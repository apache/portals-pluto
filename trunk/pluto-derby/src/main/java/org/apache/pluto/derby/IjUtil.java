package org.apache.pluto.derby;

import java.io.File;
import java.io.IOException;

import org.apache.derby.tools.ij;


/**
 * Contains methods to use IJ utility.
 * TODO: Allow use of different schemas. Only container schema is currently supported.
 * 
 * @author <a href="mailto:cdoremus@apache.org">Craig Doremus</a>
 *
 */
public class IjUtil {

    private static final String DATABASE = "PlutoDB";
    private static final String PROTOCOL = "jdbc:derby:";
    private static final String DB_USER = "container";
    private static final String DB_PWD = "container";

    static {
    	init();
    }

    /**
	 * Initialize system properties.
	 */
	public static void init(){
    	String userhome = System.getProperty("user.home");
    	File home = new File (userhome + "/.pluto/derby");
    	//make sure the directories are there
    	home.mkdirs();
		String dbhome = home.getAbsolutePath();
    	System.setProperty("derby.system.home", dbhome);		 
		System.setProperty("ij.protocol", PROTOCOL);	    			
		System.setProperty("ij.database", DATABASE + ";create=true;name=" + DB_USER + ";password=" + DB_PWD);		
	}
	
	/**
	 * Runs a script using the Derby IJ utility.
	 * 
	 * @param script Full path to the script.
	 * @throws IOException
	 */
	public static void runScript(String script) throws IOException {
		String[] args = {script};
		ij.main(args);	
	}
}
