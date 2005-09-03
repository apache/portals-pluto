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
/*

 */
 
package org.apache.pluto.portalImpl.core;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.portalImpl.aggregation.Fragment;
import org.apache.pluto.portalImpl.services.config.Config;

public class PortalURL {

    private static final String insecureServlet;
    private static final String secureServlet;
    static {
        insecureServlet = Config.getParameters().getString("servlet.insecure");
        secureServlet = Config.getParameters().getString("servlet.secure");
    }

    /**
     * Creates and URL pointing to the home of the portal
     *
     * @param request   the servlet request
     * @return the portal URL
     */
    public String getBasePortalURL(HttpServletRequest request) {
        return getBasePortalURL(PortalEnvironment.getPortalEnvironment(request));
    }

    /**
     * Creates and URL pointing to the home of the portal
     *
     * @param env     the portal environment
     * @return the portal URL
     */
    public String getBasePortalURL(PortalEnvironment env)
    {
        StringBuffer result = new StringBuffer(256);
        /*
                result.append(secure?hostNameHTTPS:hostNameHTTP);
        */
        result.append(env.getRequest().getContextPath());
        result.append(env.getRequest().getServletPath());

        return result.toString();
    }

    private List startGlobalNavigation = new ArrayList();
    private List startLocalNavigation = new ArrayList();
    private HashMap encodedStartControlParameter = new HashMap();
    private HashMap startStateLessControlParameter = new HashMap();
    private boolean analyzed = false;

    private PortalEnvironment environment;

    /**
     * Creates and URL pointing to the home of the portal
     *
     * @param env     the portal environment
     */
    public PortalURL(PortalEnvironment env)
    {
        environment = env;
    }

    /**
     * Creates and URL pointing to the home of the portal
     *
     * @param request     the servlet request
     */
    public PortalURL(HttpServletRequest request)
    {
        this(PortalEnvironment.getPortalEnvironment(request));
    }

    /**
     * Creates and URL pointing to the given fragment of the portal
     *
     * @param request   the servlet request
     * @param pointTo the fragment to point to
     */
    public PortalURL(HttpServletRequest request, Fragment pointTo)
    {
        this(request);
        pointTo.createURL(this);
    }

    /**
     * Creates and URL pointing to the given fragment of the portal
     *
     * @param env     the portal environment
     * @param pointTo the fragment to point to
     */
    public PortalURL(PortalEnvironment env, Fragment pointTo)
    {
        this(env);
        pointTo.createURL(this);
    }

    /**
     * Adds a navigational information pointing to a portal part, e.g. PageGroups
     * or Pages
     *
     * @param nav    the string pointing to a portal part
     */
    public void addGlobalNavigation(String nav)
    {
        startGlobalNavigation.add(nav);
    }

    /**
     * Sets the local navigation. Because the local navigation is always handled
     * by the Browser, therefore the local navigation cleared.
     */
    public void setLocalNavigation()
    {
        startLocalNavigation = new ArrayList();
    }

    /**
     * Adds a navigational information pointing to a local portal part inside
     * of a global portal part, for example, a portlet on a page.
     *
     * @param nav    the string pointing to a local portal part
     */
    public void addLocalNavigation(String nav)
    {
        startLocalNavigation.add(nav);
    }

    /**
     * Returns true if the given string is part of the global navigation of this URL
     *
     * @param nav    the string to check
     * @return true, if the string is part of the navigation
     */
    public boolean isPartOfGlobalNavigation(String nav)
    {
        return startGlobalNavigation.contains(nav);
    }

    /**
     * Returns true if the given string is part of the local navigation of this URL
     *
     * @param nav    the string to check
     * @return true, if the string is part of the navigation
     */
    public boolean isPartOfLocalNavigation(String nav)
    {
        return startLocalNavigation.contains(nav);
    }
    
    private String urlEncode(String value) {
        value = URLEncoder.encode(value);
        // java.net.URLEncoder encodes space (' ') as a plus sign ('+'),
        // instead of %20 thus it will not be decoded properly by tomcat when the
        // request is parsed. Therefore replace all '+' by '%20'.
        // If there would have been any plus signs in the original string, they would
        // have been encoded by URLEncoder.encode()
        // control = control.replace("+", "%20");//only works with JDK 1.5
        value = value.replaceAll("\\+", "%20");
        return value;
    }    

    public String getGlobalNavigationAsString()
    {
        StringBuffer result = new StringBuffer(200);
        Iterator iterator = startGlobalNavigation.iterator();
        if (iterator.hasNext()) {
            result.append((String)iterator.next());
            while (iterator.hasNext()) {
                result.append("/");
                String st = (String)iterator.next();
                result.append(st);
            }
        }
        return result.toString();
    }

    public String getLocalNavigationAsString()
    {
        StringBuffer result = new StringBuffer(30);
        Iterator iterator = startLocalNavigation.iterator();
        if (iterator.hasNext()) {
            result.append((String)iterator.next());
            while (iterator.hasNext()) {
                result.append(".");
                result.append((String)iterator.next());
            }
        }
        return result.toString();
    }

    public String getControlParameterAsString(PortalControlParameter controlParam) {
        Map encodedStateFullParams = encodedStartControlParameter;
        if (controlParam != null) {
            encodedStateFullParams = controlParam.getEncodedStateFullControlParameter();
        }

        StringBuffer result = new StringBuffer(100);
        Iterator iterator = encodedStateFullParams.keySet().iterator();
        while (iterator.hasNext()) {
            result.append("/");
            String encodedName = (String)iterator.next();
            String encodedValue = (String)encodedStateFullParams.get(encodedName);
            if(encodedValue != null) {
                // appends the prefix (currently "_") in front of the encoded parameter name
                result.append(PortalControlParameter.encodeParameterName(encodedName));
                result.append("/");
                result.append(urlEncode(encodedValue));
            }
        }

        return result.toString();
    }

    public String getRequestParameterAsString(PortalControlParameter controlParam)
    {
        if (controlParam!=null) {
            Map requestParams = controlParam.getRequestParameter();

            StringBuffer result = new StringBuffer(100);
            Iterator iterator = requestParams.keySet().iterator();
            boolean hasNext = iterator.hasNext();
            if (hasNext) {
                result.append("?");
            }

            while (hasNext) {
                String name = (String)iterator.next();
                Object value = requestParams.get(name);
                String[] values = value instanceof String ? new String[] {(String)value} : (String[])value;

                result.append(urlEncode(name));
                result.append("=");
                result.append(urlEncode(values[0]));
                for (int i = 1; i < values.length; i++) {
                    result.append("&");
                    result.append(urlEncode(name));
                    result.append("=");
                    result.append(urlEncode(values[i]));
                }

                hasNext=iterator.hasNext();
                if (hasNext) {
                    result.append("&");
                }
            }

            return result.toString();
        }
        return "";
    }

    public String toString()
    {
        return toString(null,null);
    }

    public String toString(PortalControlParameter controlParam,Boolean p_secure)
    {

        StringBuffer urlBase = new StringBuffer(256);

        boolean secure=false;
        if (p_secure!=null) {
            secure=p_secure.booleanValue();
        } else {
            secure=environment.getRequest().isSecure();
        }
        urlBase.append(environment.getRequest().getContextPath());
        urlBase.append(secure ? secureServlet : insecureServlet);

        String url = urlBase.toString();
        String global = getGlobalNavigationAsString();
        if (global.length() > 0) {
            url += "/";
            url += global;
        }

        String control = getControlParameterAsString(controlParam);
        if (control.length() > 0) {
            url += control;
        }

        String requestParam = getRequestParameterAsString(controlParam);
        if (requestParam.length() > 0) {
            url += requestParam;
        }

        String local = getLocalNavigationAsString();
        if (local.length() > 0) {
            url += "#";
            url += local;
        }

        return environment.getResponse().encodeURL(url);
    }

    Map getClonedEncodedStateFullControlParameter()
    {
        analyzeRequestInformation();
        return(Map)encodedStartControlParameter.clone();
    }

    Map getClonedStateLessControlParameter()
    {
        analyzeRequestInformation();
        return(Map)startStateLessControlParameter.clone();
    }

    void analyzeControlInformation(PortalControlParameter control)
    {
        encodedStartControlParameter = (HashMap)control.getEncodedStateFullControlParameter();
        startStateLessControlParameter = (HashMap)control.getStateLessControlParameter();
    }

    void analyzeRequestInformation() {
        if (analyzed) return;

        startGlobalNavigation = new ArrayList();
        startLocalNavigation = new ArrayList();
        encodedStartControlParameter = new HashMap();
        startStateLessControlParameter = new HashMap();

        // check the complete pathInfo for
        // * navigational information
        // * control information

        if (environment.getRequest().getPathInfo() != null)
        {
            String pathInfo = environment.getRequest().getPathInfo();
            StringTokenizer tokenizer = new StringTokenizer(pathInfo, "/");

            int mode = 0; // 0=navigation, 1=control information
            String encodedName = null;
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (PortalControlParameter.isControlParameter(token)) {
                    mode = 1;
                    encodedName = token;
                } else if (mode==0) {
                    startGlobalNavigation.add(token);
                } else if (mode==1) {
                    if ((PortalControlParameter.isStateFullParameter(encodedName))) {
                    	// cut the prefix before saving the parameter name
                    	encodedName = PortalControlParameter.decodeParameterName(encodedName);
                        encodedStartControlParameter.put(encodedName, token);
                    } else {
                        startStateLessControlParameter.put(PortalControlParameter.decodeParameterName(encodedName),
                                                           PortalControlParameter.decodeParameterValue(encodedName,token));
                    }
                    mode = 0;
                }
            }
        }
        analyzed = true;

    }

    public void setRenderParameter(PortletWindow portletWindow,
                                   String name,
                                   String[] values)
    {
        encodedStartControlParameter.put(PortalControlParameter.encodeRenderParamName(portletWindow, name),
                                  PortalControlParameter.encodeRenderParamValues(values));

    }

    public void clearRenderParameters(PortletWindow portletWindow) {
        String prefix = PortalControlParameter.getRenderParamKey(portletWindow);
        Iterator keyIterator = encodedStartControlParameter.keySet().iterator();
        while (keyIterator.hasNext()) {
            String name = (String)keyIterator.next();
            if (name.startsWith(prefix)) {
                keyIterator.remove();
            }
        }
    }

}
