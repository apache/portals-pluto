package org.apache.pluto.core;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.spi.optional.PortletInfoService;


public class DefaultPortletInfoService implements PortletInfoService {

    public String getTitle(PortletWindow window) {
        if (window instanceof InternalPortletWindow) {
            return getPortletDefinition((InternalPortletWindow) window)
                .getPortletInfo().getTitle();
        }
        return null;
    }

    public String getShortTitle(PortletWindow window) {
        if (window instanceof InternalPortletWindow) {
            return getPortletDefinition((InternalPortletWindow) window)
                .getPortletInfo().getTitle();
        }
        return null;
    }

    public String getKeywords(PortletWindow window) {
        if (window instanceof InternalPortletWindow) {
            return getPortletDefinition((InternalPortletWindow) window)
                .getPortletInfo().getTitle();
        }
        return null;
    }

    private PortletDD getPortletDefinition(InternalPortletWindow window) {
        return window.getPortletEntity().getPortletDefinition();
    }
}
