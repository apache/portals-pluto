package org.apache.pluto;

import java.util.ResourceBundle;

/**
 * @author <a href="david.dewolf@vivare.com">David H. DeWolf</a>
 */
public final class Environment {

    public static final ResourceBundle PROPS;

    static {
        PROPS = ResourceBundle.getBundle("org.apache.pluto.environment");
    }


    public static final String getPortletContainerName() {
        return PROPS.getString("pluto.container.name");
    }

    public static final String getPortletContainerMajorVersion() {
        return PROPS.getString("pluto.container.version.major");
    }

    public static final String getPortletContainerMinorVersion() {
        return PROPS.getString("pluto.container.version.major");
    }

    public static final String getServerInfo() {
        StringBuffer sb = new StringBuffer(getPortletContainerName())
            .append("/")
            .append(getPortletContainerMajorVersion())
            .append(".")
            .append(getPortletContainerMinorVersion());
        return sb.toString();
    }

}
