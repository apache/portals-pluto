package org.apache.pluto.derby;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.derby.tools.ij;


/**
 * Builds the container database and populates it with data
 * using the Apache Derby ij utility.
 * <p>
 * The main() method requires the full path to the scripts 
 * directory to be sent in or else it uses the current
 * working directory as the scripts dir.
 * </p>
 * <p> 
 * This script also assumes that the database is found in 
 * <user.home>/.pluto/derby/PlutoDB.
 * </p>
 * 
 * @author <a href="mailto:cdoremus@apache.org">Craig Doremus</a>
 *
 */
public class ContainerDatabaseBuilder {

    private static final Log LOG =
        LogFactory.getLog(ContainerDatabaseBuilder.class);

    private static final String DATABASE = "PlutoDB";
    private static final String PROTOCOL = "jdbc:derby:";
    private static final String DB_USER = "container";
    private static final String DB_PWD = "container";
    /** Build scripts to run */
    private static final String[] BUILD_SCRIPTS = {
    		"build-container.sql", //builds database
    		"insert-testsuite.sql" //populates testsuite data
    		};
    
   /**
    * Runs the program.
    * 
	* @param args The path to the scripts directory.
	*/
	public static void main(String[] args) {
		ContainerDatabaseBuilder builder = new ContainerDatabaseBuilder();
		String scriptDirPath = args[0];
		try {
			builder.runIJ(scriptDirPath);
		} catch (IOException e) {
			e.printStackTrace();
			LOG.error(e);
		}
		System.out.println("Done!");
	}

	/**
	 * Runs the 'ij' utility for the path set in or
	 * current working directory (user.dir).
	 * 
	 * @param path The full path to the scripts directory. If
	 * null, the working directory (user.dir) is used.
	 */
	public void runIJ(String path) throws IOException {
    	String userhome = System.getProperty("user.home");
    	File home = new File (userhome + "/.pluto/derby");
    	home.mkdirs();
		String dbhome = home.getAbsolutePath();
    	System.setProperty("derby.system.home", dbhome);		 
		//run ij for each script
		System.setProperty("ij.protocol", PROTOCOL);	    			
		System.setProperty("ij.database", DATABASE + ";create=true;name=" + DB_USER + ";password=" + DB_PWD);
		//if path is null, set to working directory
		if (path == null) {
			path = System.getProperty("user.dir"); 
		}
		String script = null;
		for (int i = 0; i < BUILD_SCRIPTS.length; i++) {
			script = path + "/" + BUILD_SCRIPTS[i];
			if (LOG.isDebugEnabled()) {
				LOG.debug("Running script: '" + script + "'.");
			}
			//check that the script exists
			File spath = new File(script);
			if (!spath.exists()) {
				throw new FileNotFoundException("Script '" + script + "' does not exist.");
			}
			String[] args = {script};
			ij.main(args);
		}
	}
}
