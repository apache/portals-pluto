/*
 * Copyright 2003,2004,2005 The Apache Software Foundation.
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
package org.apache.pluto.portlet.admin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.pluto.portlet.admin.PlutoAdminConstants;
import org.apache.pluto.portlet.admin.PlutoAdminException;
import org.apache.pluto.portlet.admin.PlutoAdminLogger;

/**
 * A singleton factory that holds methods to get various data on
 * the Pluto install such as the path to the Pluto home directory
 * held within properties files. A HashMap cache is used to store
 * the properties (as a Properties object) when they are first
 * loaded.
 *
 * @author Craig Doremus
 *
 */
public class PlutoAdminContext  {

	private static final String CLASS_NAME = "PlutoAdminContext";
	/** Home for the container (servlet engine) that Pluto sits inside of. In Tomcat, this is
	 *  */
	private static String _containerHome;
	private static String _plutoHome;
	private static String _plutoContext;
	private static String _deploymentPath;
	private static Map _cache = new HashMap();
	private static PlutoAdminContext _instance = new PlutoAdminContext();

	/**
	 *
	 */
	private PlutoAdminContext() {
	}

	public static PlutoAdminContext getInstance(){
		return _instance;
	}

	/**
	 * Accessor for the full path to the pageregistry.xml file using
	 * the getPlutoHome() method.
	 *
	 * @return The absolute path to pageregistry.xml
	 * @see #getPlutoHome()
	 */
	public String getPageRegistryPath() {
		String path = getPlutoHome() + PlutoAdminConstants.FS + getRelDataDir() + PlutoAdminConstants.FS + getProperties().getProperty("pageregistry-file");
		return path;
	}

	/**
	 * Accessor for the full path to the portletentityregistry.xml file using
	 * the getPlutoHome() method.
	 *
	 * @return The absolute path to portletentityregistry.xml
	 * @see #getPlutoHome()
	 */
	public String getPortletEntityRegistryPath() {
		String path = getPlutoHome() + PlutoAdminConstants.FS + getRelDataDir() + PlutoAdminConstants.FS + getProperties().getProperty("portletentityregistry-file");
		return path;
	}

	/**
	 * Uses properties in pluto-admin.properties to get the
	 * full path to the installed Pluto home directory, which in
	 * Tomcat is Pluto's webapps directory (usually 'pluto').
	 * @return The absolute path to the directory where the Pluto
	 * container is installed.
	 */
	public String getPlutoHome(){
	    final String METHOD_NAME = "getPlutoHome()";
//		String plutoHome = null;
//		Properties props = getProperties();
//		String plutoContext = props.getProperty("pluto-web-context");
//		plutoHome = getWebappsPath() + PlutoAdminConstants.FS + plutoContext;
//		return plutoHome;
//	    if (_plutoHome == null) {
//	        String msg ="The _plutoHome variable must be set (setPlutoHome()) inside" +
//	        		" of the ControllerPortlet.init() method using before this method is called";
//	        IllegalStateException e = new IllegalStateException(msg); 
//	        PlutoAdminLogger.logError(CLASS_NAME, METHOD_NAME, msg, e);
//	        throw e;
//	    }
	    return _plutoHome;
	}

	/**
	 * Uses properties in pluto-admin.properties to get the
	 * full path to the installed Pluto home directory, which in
	 * Tomcat is Pluto's webapps directory (usually 'pluto').
	 * @return The absolute path to the directory where the Pluto
	 * container is installed.
	 */
//	public String getWebappsPath(){
//		String path = null;
//		Properties props = getProperties();
//		String tomcatHome = getTomcatHome();
//		path = tomcatHome + "/webapps";
//		return path;
//	}

	/**
	 * Returns the Properties object from a properties file that is in the
	 * classpath. After it's first access, the properties are stored
	 * in a cache.
	 *
	 * @param propFileName Name of the properties file.
	 * @return Properties The filled properties object
	 * @throws IOException If there is a problem loading the properties
	 * from the file
	 * @throws NullPointerException If the InputStream accessing the properties
	 * file is null.
	 */
	public static Properties getProperties(String propFileName){
		final String METHOD_NAME = "getProperties(propFileName)";
		Properties props = null;
		//retreive from cache if available
		props = (Properties)_cache.get(propFileName);
		if ( props == null) {
	    //get the properties from prop file
	    InputStream stream = PlutoAdminContext.class.getClassLoader().getResourceAsStream(propFileName);
	    if (stream == null) {
	    	String logMsg = "Null InputStream." +
	    	" Please make sure the properties file exists and is in the classpath.";
				NullPointerException e = new NullPointerException(logMsg);
	    		PlutoAdminLogger.logError(CLASS_NAME, METHOD_NAME, e);
				throw e;
			}
	    props = new Properties();
			try {
				props.load(stream);
			} catch (IOException e) {
				PlutoAdminLogger.logError(CLASS_NAME, METHOD_NAME, e);
				throw new PlutoAdminException(e);
			}
			//add props to the cache
			_cache.put(propFileName, props);
			return props;
		} else {
			return props;
		}
	}

	public static Properties getProperties(){
		return getProperties(PlutoAdminConstants.PROP_FILENAME);
	}

	private String getRelDataDir(){
		String dir = getProperties().getProperty("data-dir-relative-path");
		return dir;
	}

	/**
	 * Accessor for the full path to the portletcontexts.txt file
	 * @return
	 */
	public String getPortletContextsPath() {
		String path = getPlutoHome() + PlutoAdminConstants.FS + getRelDataDir() + PlutoAdminConstants.FS + getProperties().getProperty("portletcontexts-file");
		return path;
	}

	/**
	 * Finds home directory of the container that holds Pluto (usually Tomcat)
	 * 
	 * @return
	 */
	public static String getContainerHome(){
			final String METHOD_NAME = "getContainerHome()";
			return _containerHome;
		}

	/** 
		 * Parses out paths from the Pluto Home directory sent in from
		 * PortletContext.getRealPath("") call in ControllerPortlet.init()
		 * 
     * @param home The _plutoHome to set.
     */
    public static void parseDeploymentPaths(String plutoHome) {
  			final String METHOD_NAME = "parseDeploymentPaths(plutoHome)";
  			//TODO: test for null and use of alternate path in pluto-admin.properties
  			int lastSlash = 0;
  			if (plutoHome == null) {
  			    _plutoHome = getProperties().getProperty("pluto-home");
  			    if (_plutoHome == null || _plutoHome.equals("")) {
  			        throw new PlutoAdminException("pluto-home needs to be set in pluto-admin.properties.");
  			    }
		    //get rid of last slash if it is the last character
  			} else if (plutoHome.lastIndexOf(PlutoAdminConstants.FS) == plutoHome.length()-1) {
  			    lastSlash = plutoHome.lastIndexOf(PlutoAdminConstants.FS);
  			    _plutoHome = plutoHome.substring(0, lastSlash);
  			} else {
  			    _plutoHome = plutoHome;  			    
  			}
    		PlutoAdminLogger.logDebug(CLASS_NAME, METHOD_NAME, "Pluto home: " + _plutoHome);
    		//Parse out context (default=pluto)
  			lastSlash = _plutoHome.lastIndexOf(PlutoAdminConstants.FS);
		    _plutoContext = _plutoHome.substring(lastSlash + 1);
  			PlutoAdminLogger.logDebug(CLASS_NAME, METHOD_NAME, "Pluto web context: " + _plutoContext);
    		//Parse out path to deployment dir
  			_deploymentPath = _plutoHome.substring(0, lastSlash);
    		PlutoAdminLogger.logDebug(CLASS_NAME, METHOD_NAME, "Portlet deployment path: " + _deploymentPath);
    		//Parse out container path (CATALINA_HOME if using Tomcat)
    		lastSlash = _deploymentPath.lastIndexOf(PlutoAdminConstants.FS);
  			_containerHome = _deploymentPath.substring(0, lastSlash);
    		PlutoAdminLogger.logDebug(CLASS_NAME, METHOD_NAME, "Container (Tomcat) home: " + _containerHome);
    }
    
    /**
     * Accessor for the path to the portlet deployment directory (webapps in Tomcat container) 
     * @return
     */
    public static String getDeploymentPath(){
        return _deploymentPath;        
    }
    
    /**
     * Accessor for the web context for Pluto (default=pluto)
     * @return
     */
    public static String getPlutoWebContext(){
        return _plutoContext;        
    }
}
