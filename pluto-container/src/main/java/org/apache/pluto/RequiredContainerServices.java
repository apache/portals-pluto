package org.apache.pluto;

import org.apache.pluto.services.PortalCallbackService;

import javax.portlet.PortalContext;

/**
 * This interface defines the services required for integration between the
 * Pluto Portlet Container and a Portal.
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 */
public interface RequiredContainerServices {

    /**
     * Returns the PortalContext instance associated with this group of
     * portlet container services.
     * @return a PortalContext implementation.
     */
    public PortalContext getPortalContext();

    /**
     * Returns the portal callback service implementation instance associated
     * with this group of portlet container services. 
     * @return a PortalCallbackService implementation.
     */
    public PortalCallbackService getPortalCallbackService();
    
}
