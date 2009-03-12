package org.apache.pluto.driver.url;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: ddewolf
 * Date: Sep 4, 2006
 * Time: 5:49:37 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PortalURLParser {
    PortalURL parse(HttpServletRequest request);
    String toString(PortalURL portalURL);
}
