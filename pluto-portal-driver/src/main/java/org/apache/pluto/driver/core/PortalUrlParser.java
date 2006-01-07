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
package org.apache.pluto.driver.core;

import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.ArrayList;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 30, 2004
 */
class PortalUrlParser {

    private static PortalUrlParser parser;

    private static final Log LOG = LogFactory.getLog(PortalUrlParser.class);


    public static PortalUrlParser getParser() {
        if (parser == null) {
            parser = new PortalUrlParser();
        }
        return parser;
    }

    public PortalURL parse(HttpServletRequest req) {
        if(LOG.isDebugEnabled()) {
            LOG.debug("Parsing url: "+req.getRequestURI());
        }

        String protocol = req.isSecure() ? "https://" : "http://";
        String server = req.getServerName();
        int port = req.getServerPort();

        PortalURL url;
        if ((req.isSecure() && port != 443) ||
            (!req.isSecure() && port != 80)) {
            url = new PortalURL(protocol, server, port);
        } else {
            url = new PortalURL(protocol, server);
        }

        url.setControllerPath(req.getContextPath(), req.getServletPath());

        if(LOG.isDebugEnabled()) {
            LOG.debug("Parsing parameters for request: "+req.getPathInfo());
        }
        StringBuffer renderPath = new StringBuffer();
        if (req.getPathInfo() == null) {
            return url;
        }

       StringTokenizer st = new StringTokenizer(req.getPathInfo(), "/", false);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            // render path
            if (!token.startsWith(PREFIX)) {
                renderPath.append(token);
            } else if (token.startsWith(PREFIX + ACTION)) {
                url.setActionWindow(decode(token)[0]);
            } else if (token.startsWith(PREFIX + WINDOW_STATE)) {
                String[] decoded = decode(token);
                url.setWindowState(decoded[0], new WindowState(decoded[1]));
            } else if (token.startsWith(PREFIX + PORTLET_MODE)) {
                String[] decoded = decode(token);
                url.setPortletMode(decoded[0], new PortletMode(decoded[1]));
            } else {
                String value = null;
                if (st.hasMoreTokens()) {
                    value = st.nextToken();
                }
                url.addParameter(decode(token, value));
            }
        }

        if (renderPath.length() > 0) {
            url.setRenderPath(renderPath.toString());
        }

        return url;
    }

    public String toString(PortalURL url) {
        StringBuffer sb = new StringBuffer();
        // 1)  The Servlet Path
        sb.append(url.getServerUri()).append(url.getControllerPath());

        // 2) Start the PathInfo with the Path to the Render URL (Page).
        if (url.getRenderPath() != null) {
            sb.append("/");
            sb.append(url.getRenderPath());
        }

        // 3) Add the action window, if it exists
        if (url.getActionWindow() != null) {
            sb.append("/");
            sb.append(PREFIX).append(ACTION).append(encode(url.getActionWindow()));
        }

        Iterator it = url.getPortletModes().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            sb.append("/").append(
                encode(PORTLET_MODE, entry.getKey().toString(),
                       entry.getValue().toString()));
        }


        it = url.getWindowStates().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            sb.append("/").append(
                encode(WINDOW_STATE, entry.getKey().toString(),
                       entry.getValue().toString()));
        }

        // 4) Add parameters
        StringBuffer query = new StringBuffer("?");

        it = url.getParameters().iterator();
        while (it.hasNext()) {
            PortalUrlParameter param = (PortalUrlParameter) it.next();
            if (url.getActionWindow() != null &&
                url.getActionWindow().equals(param.getWindowId())) {
                for(int i=0;i<param.getValues().length;i++) {
                    query.append("&").append(param.getName()).append("=").append(param.getValues()[i]);
                }
            } else if (param.getValues() != null &&
                       param.getValues().length > 0) {
                String valueString = encode(param.getValues());
                if (valueString.length() > 0) {
                    sb.append("/").append(
                        encode(RENDER_PARAM, param.getWindowId(),
                               param.getName()));
                    sb.append("/").append(valueString);
                }
            }
        }

        // 5) Add local nav

        return sb.append(query).toString();
    }

    private static final String PREFIX = "__";
    private static final String DELIM = "_";
    private static final String PORTLET_ID = "pd";
    private static final String ACTION = "ac";
    private static final String RENDER_PARAM = "rp";
    private static final String WINDOW_STATE = "ws";
    private static final String PORTLET_MODE = "pm";
    private static final String VALUE_DELIM = "0x0";

    private static final String[][] ENCODINGS =
        new String[][]{
            new String[]{"_", "0x1"},
            new String[]{".", "0x2"},
            new String[]{"/", "0x3"},
            new String[]{"\r", "0x4"},
            new String[]{"\n", "0x5"},
            new String[]{"<", "0x6"},
            new String[]{">", "0x7"},
            new String[]{" ", "0x8"}
        };

    private String encode(String type, String windowId, String name) {
        return PREFIX + type + encode(windowId) + DELIM + name;
    }

    private String encode(String[] values) {
        String value = "";
        for (int i = 0; i < values.length; i++) {
            value += values[i]==null?"":values[i];
            if (i + 1 != values.length) {
                value += ",";
            }
        }
        for (int i = 0; i < ENCODINGS.length; i++) {
            value =
            StringUtils.replace(value, ENCODINGS[i][0], ENCODINGS[i][1]);
        }
        return value;
    }

    /**
     * Parse a control parameter into the porlet which it effects and it's
     * original value.
     * @param ctl
     * @return values
     */
    private String[] decode(String ctl) {
        int length = (PREFIX + PORTLET_ID).length();
        ctl = ctl.substring(length);
        String[] vals = new String[2];
        if (ctl.indexOf(DELIM) > -1) {
            vals[0] = ctl.substring(0, ctl.indexOf(DELIM));
            vals[1] = ctl.substring(ctl.indexOf(DELIM) + 1);
            for (int i = 0; i < ENCODINGS.length; i++) {
                vals[0] =
                StringUtils.replace(vals[0], ENCODINGS[i][1], ENCODINGS[i][0]);
                vals[1] =
                StringUtils.replace(vals[1], ENCODINGS[i][1], ENCODINGS[i][0]);
            }
        } else {
            vals[0] = ctl;
            for (int i = 0; i < ENCODINGS.length; i++) {
                vals[0] =
                StringUtils.replace(vals[0], ENCODINGS[i][1], ENCODINGS[i][0]);
            }
        }
        return vals;
    }

    /**
     * Decode a parameter
     * @param name
     * @param value
     * @return url parameter
     */
    private PortalUrlParameter decode(String name, String value) {
        if(LOG.isDebugEnabled()) {
            LOG.debug("Decoding parameter (name="+name+" : value="+value+")");
        }

        String nopre = name.substring((PREFIX + PORTLET_ID).length());
        String windowId = nopre.substring(0, nopre.indexOf(DELIM));
        String param = nopre.substring(nopre.indexOf(DELIM) + 1);

        ArrayList values = new ArrayList();
        for (int i = 0; i < ENCODINGS.length; i++) {
            windowId =
            StringUtils.replace(windowId, ENCODINGS[i][1], ENCODINGS[i][0]);
            if (value != null) {
                value =
                StringUtils.replace(value, ENCODINGS[i][1], ENCODINGS[i][0]);
            }

           StringTokenizer st = new StringTokenizer(value, VALUE_DELIM, false);
            while(st.hasMoreTokens()) {
                values.add(st.nextToken());
            }
            /*
            int idx, start = 0;
            while( (idx = value.indexOf(VALUE_DELIM, start)) > -1) {
                values.add(value.substring(start, idx));
                start = idx;
            }
            */
        }
        String[] vals = (String[])values.toArray(new String[values.size()]);
        return new PortalUrlParameter(windowId, param, vals);
    }

    private String encode(String string) {
        for (int i = 0; i < ENCODINGS.length; i++) {
            string =
            StringUtils.replace(string, ENCODINGS[i][0], ENCODINGS[i][1]);
        }
        return string;
    }

    private String convert(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
            if (i + 1 != strings.length) {
                sb.append(VALUE_DELIM);
            }
        }
        return sb.toString();
    }

}

