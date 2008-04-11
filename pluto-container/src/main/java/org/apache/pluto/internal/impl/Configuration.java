package org.apache.pluto.internal.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Configuration {
	
	private static final Log LOG = 
        LogFactory.getLog(Configuration.class);

	public static final ResourceBundle BUNDLE =
        PropertyResourceBundle.getBundle("org.apache.pluto.core.pluto-configuration");
	
	private static final String CONTAINER_RUNTIME_OPTIONS =
    	"org.apache.pluto.container.supportedContainerRuntimeOptions";
	
	public static List<String> getSupportedContainerRuntimeOptions() {
    	String options =  BUNDLE.getString(CONTAINER_RUNTIME_OPTIONS);
    	List<String> result = new ArrayList<String>();
    	String[] s = options.split(",");
    	for (String string : s) {
			result.add(string);
		}
    	return result;
    }
}
