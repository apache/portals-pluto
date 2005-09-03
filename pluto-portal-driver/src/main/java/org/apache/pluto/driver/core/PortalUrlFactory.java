package org.apache.pluto.driver.core;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public class PortalUrlFactory {

    private static final String KEY = PortalURL.class.getName();

    private static PortalUrlFactory factory;

    public static PortalUrlFactory getFactory() {
        if (factory == null) {
            factory = new PortalUrlFactory();
        }
        return factory;
    }

    public PortalURL createPortalUrl(HttpServletRequest req) {
        if (req.getAttribute(KEY) == null) {
            PortalURL gnew = PortalUrlParser.getParser().parse(req);
            req.setAttribute(KEY, gnew);
        }

        PortalURL url = (PortalURL) req.getAttribute(KEY);
        return (PortalURL) url.clone();
    }

}
