package org.apache.pluto.internal.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
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

    /**
     * org.apache.pluto.PREVENT_UNECESSARY_CROSS_CONTEXT
     */
    private static final String PREVENT_UNECESSARY_CROSS_CONTEXT =
        "org.apache.pluto.PREVENT_UNECESSARY_CROSS_CONTEXT";

	
	public static List<String> getSupportedContainerRuntimeOptions() {
    	String options =  BUNDLE.getString(CONTAINER_RUNTIME_OPTIONS);
    	List<String> result = new ArrayList<String>();
    	String[] s = options.split(",");
    	for (String string : s) {
			result.add(string);
		}
    	return result;
    }

    private static Boolean prevent;

    public static boolean preventUnecessaryCrossContext() {
        if (prevent == null) {
            try {
                String test = BUNDLE.getString(PREVENT_UNECESSARY_CROSS_CONTEXT);
                prevent = new Boolean(test);
            } catch (MissingResourceException mre) {
            	LOG.warn(mre.getMessage());
                prevent = Boolean.FALSE;
            }
        }
        return prevent.booleanValue();
    }
}
