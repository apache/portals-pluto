/*
 * Copyright 2003,2004 The Apache Software Foundation.
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

package org.apache.pluto.driver.impl.services;

import org.apache.pluto.driver.PortalConfig;
import org.apache.pluto.driver.Portal;
import org.apache.pluto.driver.RequestParameters;
import org.apache.pluto.PortletWindow;

import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletSecurityException;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Properties;
import java.util.Iterator;
import java.net.URL;
import java.net.MalformedURLException;

/** PortletURL implementation.
 * TODO Implement isSecure functionality.
 * 
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 14, 2004 at 1:18:53 PM
 */
public abstract class PortletURLImpl implements PortletURL {

    protected HttpServletRequest request;

    private String baseURL;
    private boolean isSecure;
    private PortletWindow window;
    private WindowState windowState;
    private PortletMode mode;
    private Map parameters;

    public PortletURLImpl(PortletWindow window, HttpServletRequest request) {
        this.window = window;
        this.request = request;
        this.parameters = new java.util.HashMap();
        this.isSecure = request.isSecure();
    }

    protected String getBaseURL() {
        if(baseURL==null) {
            init();
        }
        return baseURL;
    }

    public void setWindowState(WindowState windowState)
    throws WindowStateException {
        this.windowState = windowState;
    }

    public void setPortletMode(PortletMode portletMode)
    throws PortletModeException {
        this.mode = portletMode;
    }

    public void setParameter(String key, String value) {
        this.parameters.put(window.getPortletId()+"."+key, value);
    }

    public void setParameter(String key, String[] values) {
        this.parameters.put(window.getPortletId()+"."+key, values);
    }

    public void setParameters(Map map) {
        this.parameters = map;
    }

    public void setSecure(boolean isSecure) throws PortletSecurityException {
        this.isSecure = isSecure;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getBaseURL());
        Map parameters = new java.util.HashMap(this.parameters);

        parameters.put(
            RequestParameters.ACTION_PORTLET_ID,
            window.getPortletId()
        );

        if(windowState!=null) {
            parameters.put(
                RequestParameters.WINDOW_STATE,
                windowState.toString()
            );
        }

        if(mode!=null) {
            parameters.put(
                RequestParameters.PORTLET_MODE,
                mode.toString()
            );
        }

        Iterator it = parameters.keySet().iterator();
        String key;
        while(it.hasNext()) {
            key = it.next().toString();
            if(sb.indexOf("?")>-1) {
                sb.append("&");
            }
            else {
                sb.append("?");
            }
            Object value = parameters.get(key);
            if(value instanceof String[]) {
                String[] values = (String[])value;
                for(int i=0;i<values.length;i++) {
                    sb.append(key).append("=").append(values[i]);
                    sb.append(sb.indexOf("?")>-1?"&":"?");
                }
            }
            else {
                sb.append(key).append("=").append(value.toString());
            }
        }
        return sb.toString();
    }

    protected abstract String getResource();

    public void init() {
        String resource = getResource();
        // If we have a relative path, then we will
        // simply return the resource.
        if(resource.startsWith("/")) {
            baseURL = request.getContextPath()+resource;
            baseURL += "?pageId="+request.getParameter("pageId");
            return;
        }

        try {
            URL url = new URL(request.getRequestURL().toString());
            // Instead of basing off of the previous, we'll trust
            // isSecure (since it's defaulted allready).
            //StringBuffer base = new StringBuffer(url.getProtocol());
            StringBuffer base = new StringBuffer(isSecure?"https":"http");
            base.append("://").append(url.getHost());

            if(!isSecure && url.getPort()!=80) {
                base.append(":"+url.getPort());
            }
            else if(isSecure && url.getPort()!=443) {
                base.append(":"+url.getPort());
            }

            base.append("/");
            String filePath = url.getFile();
            if(filePath!=null
               && filePath.indexOf("/")!=filePath.lastIndexOf("/")) {
                int index = filePath.lastIndexOf("/");
                filePath = filePath.substring(0,index);
            }
            else {
                filePath = "/";
            }
            base.append(filePath);
            base.append(resource);
            base.append(base.indexOf("?")>-1?"&":"?")
                .append("pageId=")
                .append(request.getParameter("pageId"));
        }
        catch(MalformedURLException mue) {
            mue.printStackTrace();
            baseURL = "/";
        }
    }
}
