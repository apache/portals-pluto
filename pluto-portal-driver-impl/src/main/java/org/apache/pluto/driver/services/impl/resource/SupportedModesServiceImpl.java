package org.apache.pluto.driver.services.impl.resource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.List;

import javax.portlet.PortletMode;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.OptionalContainerServices;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.portlet.SupportsDD;
import org.apache.pluto.spi.optional.PortletRegistryService;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfigurationException;
import org.apache.pluto.driver.services.portal.PropertyConfigService;
import org.apache.pluto.driver.services.portal.SupportedModesService;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;

/**
 * Allows clients to determine if a particular PortletMode is supported
 * by the portal, a particular portlet, or both.
 * 
 * This implementation depends on {@link PropertyConfigService},  
 * {@link org.apache.pluto.spi.optional.PortletRegistryService}, and {@link PortletContainer}.
 * The two services are injected by Spring, and the container is obtained
 * from the <code>ServletContext</code>. 
 * 
 * @author <a href="mailto:esm@apache.org">Elliot Metsger</a>
 * @version $Id$
 * @since September 9, 2006
 * @todo How will hot-deploy of portlets via the admin portlet work with this impl?
 */
public class SupportedModesServiceImpl implements SupportedModesService 
{
    /** Logger */
    private static final Log LOG = LogFactory.getLog(SupportedModesServiceImpl.class);

    /** PortletMode objects supported by the portal */
    private Set supportedPortletModesByPortal = new HashSet();        
    
    /** PortletContainer used to obtain Portlet Descriptors (PortletAppDD) */
    private PortletContainer container = null;
    
    /** PortletRegistryService used to obtain PortletApplicationConfig objects */
    private PortletRegistryService portletRegistry = null;

    /** PropertyConfig Service used to obtain supported portal modes */
    private PropertyConfigService propertySvc = null;
    
    
    /**
     * Constructs a SupportedModesService with its dependencies.
     * 
     * @param propertySvc the PropertyConfigService
     */
    public SupportedModesServiceImpl(PropertyConfigService propertySvc) {
        this.propertySvc = propertySvc;
    }
    
    //  SupportedModesService Implementation -----------------
    
    public boolean isPortletModeSupported(String portletId, String mode)  {
        return isPortletModeSupportedByPortal(mode) &&
            isPortletModeSupportedByPortlet(portletId, mode);
    }

    public boolean isPortletModeSupportedByPortal(String mode)  {
        return supportedPortletModesByPortal.contains(new PortletMode(mode));
    }

    public boolean isPortletModeSupportedByPortlet(String portletId, String mode) {
        String applicationId = PortletWindowConfig.parseContextPath(portletId);
        String portletName = PortletWindowConfig.parsePortletName(portletId);

        try {
            PortletAppDD ctx = portletRegistry.getPortletApplicationDescriptor(applicationId);
            Iterator i = ctx.getPortlets().iterator();
            while(i.hasNext()) {
                PortletDD dd = (PortletDD)i.next();
                if(portletName.equals(dd.getPortletName())) {
                    Iterator i2 = dd.getSupports().iterator();
                    while(i2.hasNext()) {
                        SupportsDD sd = (SupportsDD)i2.next();
                        Iterator pd = sd.getPortletModes().iterator();
                        while(pd.hasNext()) {
                            if(mode.equalsIgnoreCase((String)pd.next())) {
                                return true;
                            }
                        }
                    }
                }
            }

        } catch (PortletContainerException e) {
            LOG.error("Error determining mode support.", e);
        }
        LOG.info("Portlet mode '"+mode+"' not found for portletId: '"+portletId+"'");
        return false;
    }

    // DriverConfiguration Lifecycle Implementation ---------
    
    public void destroy() throws DriverConfigurationException 
    {
        LOG.debug("Destroying Supported Modes Service...");
        supportedPortletModesByPortal = null;
        container = null;
        portletRegistry = null;
        propertySvc = null;
        LOG.debug("Supported Modes Service destroyed.");
    }

    public void init(ServletContext ctx) throws DriverConfigurationException {
        container = (PortletContainer)ctx.getAttribute(AttributeKeys.PORTLET_CONTAINER);
        OptionalContainerServices services = container.getOptionalContainerServices();
        portletRegistry = services.getPortletRegistryService();
        loadPortalModes();
    }

        /** Populates the supportedPortletModesByPortal set. */
    private void loadPortalModes()
    {
        // Add the PortletModes supported by the portal to the
        // supportedPortletModesByPortal set.
        LOG.debug("Loading supported portal modes...");
        Iterator modes = propertySvc.getSupportedPortletModes().iterator();
        while (modes.hasNext()) {
            String mode = (String) modes.next();
            LOG.debug("Loading mode [" + mode + "]");
            supportedPortletModesByPortal.add(new PortletMode(mode));
        }
        LOG.debug("Loaded [" + supportedPortletModesByPortal.size() + "] supported portal modes");
    }


}
