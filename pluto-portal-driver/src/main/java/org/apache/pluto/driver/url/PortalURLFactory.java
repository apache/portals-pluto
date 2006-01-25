package org.apache.pluto.driver.url;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class PortalURLFactory {

    private static final String KEY = PortalURL.class.getName();
    
    /** The singleton factory instance. */
    private static final PortalURLFactory FACTORY = new PortalURLFactory();
    
    
    // Constructor -------------------------------------------------------------
    
    /**
     * Private constructor that prevents external instantiation.
     */
    private PortalURLFactory() {
    	// Do nothing.
    }
    
    /**
     * Returns the singleton factory instance.
     * @return the singleton factory instance.
     */
    public static PortalURLFactory getFactory() {
        return FACTORY;
    }
    
    
    // Public Methods ----------------------------------------------------------
    
    /**
     * Creates a portal URL from the servlet request. If the servlet request
     * does not contain a portal URL (in request scope), the method creates a
     * portal URL and saves it into the request scope.
     * @param request  the servlet request.
     * @return a portal URL created from the servlet request.
     */
    public PortalURL createPortalURL(HttpServletRequest request) {
    	PortalURL portalURL = (PortalURL) request.getAttribute(KEY);
        if (portalURL == null) {
            portalURL = PortalURLParser.getParser().parse(request);
            request.setAttribute(KEY, portalURL);
        }
        return (PortalURL) portalURL.clone();
    }

}
