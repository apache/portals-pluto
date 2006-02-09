package org.apache.pluto.core;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.services.optional.PortletPreferencesService;

/**
 * Default implementation of the portlet preferences service.
 * 
 * @see javax.portlet.PortletPreferences
 * @see org.apache.pluto.core.PortletPreferencesImpl
 * 
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class DefaultPortletPreferencesService
implements PortletPreferencesService {
	
	/** Logger. */
	private static final Log LOG = LogFactory.getLog(
			DefaultPortletPreferencesService.class);
	
	
	// Private Member Variables ------------------------------------------------
	
	/**
	 * The in-memory portlet preferences storage: key is the preference name as
	 * a string, value is an array of PortletPreference objects.
	 */
	private Map storage = new HashMap();
	
	
	// Constructor -------------------------------------------------------------
	
	/**
	 * Default no-arg constructor.
	 */
	public DefaultPortletPreferencesService() {
		// Do nothing.
	}
	
	
	// PortletPreferencesService Impl ------------------------------------------
	
	public PortletPreference[] getStoredPreferences(PortletWindow portletWindow,
	                                                PortletRequest request)
	throws PortletContainerException {
        String key = getFormattedKey(portletWindow, request.getRemoteUser());
        PortletPreference[] prefs = (PortletPreference[]) storage.get(key);
        if (prefs == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("No portlet preferences found for: " + key);
            }
            return new PortletPreference[0];
        } else {
        	return prefs;
        }
    }
	
	/**
	 * Stores the portlet preferences to the in-memory storage. This method
	 * should be invoked after the portlet preferences are validated by the
	 * preference validator (if defined).
	 * 
	 * @see javax.portlet.PortletPreferences#store()
	 */
    public void store(PortletWindow portletWindow,
                      PortletRequest request,
                      PortletPreference[] preferences)
    throws PortletContainerException {
        String key = getFormattedKey(portletWindow, request.getRemoteUser());
        storage.put(key, preferences);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Portlet preferences stored for: " + key);
        }
    }
    
    
    // Private Methods ---------------------------------------------------------
    
    /**
     * Formats the preference key for the portlet preference using specified
     * portlet window and remote user.
     * 
     * TODO: this method depends on the impl of PortletWindow.toString()!
     * 
     * @param portletWindow  the portlet window.
     * @param user  the remote user.
     */
    private String getFormattedKey(PortletWindow portletWindow,
                                   String user) {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("user=").append(user).append(";");
    	buffer.append("portletWindow=").append(portletWindow.getPortletName());
    	return buffer.toString();
    }
    
}


