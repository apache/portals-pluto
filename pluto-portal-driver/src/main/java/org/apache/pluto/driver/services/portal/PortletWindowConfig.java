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
package org.apache.pluto.driver.services.portal;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public class PortletWindowConfig {

    private String id;
    private String contextPath;
    private String portletName;

    public PortletWindowConfig() {
    }

    public String getId() {
        if(id == null) {
            return createPortletId(contextPath, portletName);
        }
        return id;
    }

    public String getContextPath() {
        return contextPath;
    }

   public void setContextPath(String contextPath) {
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

    public static String parseContextPath(String portletId) {
        int idx = portletId.indexOf('.');
        if(idx < 1 || idx == portletId.length() -1) {
            throw new IllegalArgumentException("Invalid Portlet Id: "+portletId);
        }
        return portletId.substring(0, idx);
    }

    public static String parsePortletName(String portletId) {
        int idx = portletId.indexOf('.');
        if(idx < 1 || idx == portletId.length() -1) {
            throw new IllegalArgumentException("Invalid Portlet Id: "+portletId);
        }
        return portletId.substring(idx+1, portletId.length());
    }
}
