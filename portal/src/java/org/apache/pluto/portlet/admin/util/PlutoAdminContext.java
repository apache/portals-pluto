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
		String plutoHome = null;
		Properties props = getProperties();
		String plutoContext = props.getProperty("pluto-web-context");
		plutoHome = getWebappsPath() + PlutoAdminConstants.FS + plutoContext;
		return plutoHome;
	}

	/**
	 * Uses properties in pluto-admin.properties to get the
	 * full path to the installed Pluto home directory, which in
	 * Tomcat is Pluto's webapps directory (usually 'pluto').
	 * @return The absolute path to the directory where the Pluto
	 * container is installed.
	 */
	public String getWebappsPath(){
		String path = null;
		Properties props = getProperties();
//		String tomcatHome = props.getProperty("tomcat-home");
		String tomcatHome = getTomcatHome();
		path = tomcatHome + "/webapps";
		return path;
	}

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
	public Properties getProperties(String propFileName){
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

	public Properties getProperties(){
		return getProperties(PlutoAdminConstants.PROP_FILENAME);
	}

	private String getRelDataDir(){
		String dir = getProperties().getProperty("data-dir-relative-path");
		return dir;
	}

	public String getPortletContextsPath() {
		String path = getPlutoHome() + PlutoAdminConstants.FS + getRelDataDir() + PlutoAdminConstants.FS + getProperties().getProperty("portletcontexts-file");
		return path;
	}

	public String getTomcatHome(){
		final String METHOD_NAME = "getTomcatHome()";
		Properties props = System.getProperties();
		String home = (String)props.get("catalina.base");
		if (home == null) {
			String msg = "The System Property catalina.home has not been set!";
			PlutoAdminLogger.logError(CLASS_NAME, METHOD_NAME, msg);
			throw new PlutoAdminException(msg);
		}
		return home;
	}
}
