/*
 * Copyright 2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.driver.config;

/**
 * @author <a href="david.dewolf@vivare.com">David H. DeWolf</a>
 */
public class PortletWindowConfig {

    private String contextPath;
    private String portletName;

    public PortletWindowConfig() {
    }

    public String getId() {
        return createPortletId(contextPath, portletName);
    }

    public String getContextPath() {
        return contextPath;
    }

    /**
     * Should only be set by the application upon being added.
     * @param contextPath
     */
    void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getPortletName() {
        return portletName;
    }

    public void setPortletName(String portletName) {
        this.portletName = portletName;
    }

    public static String createPortletId(String contextPath,
                                         String portletName) {
        return contextPath + "." + portletName;
    }

}
