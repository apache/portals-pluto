package org.apache.pluto.driver.url;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import java.util.Collection;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ddewolf
 * Date: Sep 4, 2006
 * Time: 5:17:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PortalURL extends Cloneable {
    void setRenderPath(String renderPath);

    String getRenderPath();

    void addParameter(PortalURLParameter param);

    Collection getParameters();

    void setActionWindow(String actionWindow);

    String getActionWindow();

    Map getPortletModes();

    PortletMode getPortletMode(String windowId);

    void setPortletMode(String windowId, PortletMode portletMode);

    Map getWindowStates();

    WindowState getWindowState(String windowId);

    void setWindowState(String windowId, WindowState windowState);

    void clearParameters(String windowId);

    String toString();

    String getServerURI();

    String getServletPath();

    Object clone();
}
