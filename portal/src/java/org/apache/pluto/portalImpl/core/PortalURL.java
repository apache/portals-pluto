/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
/* 

 */

package org.apache.pluto.portalImpl.core;

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

    static public final String URI_CONTEXT_PATH = "portal.contextroot";

    static String hostNameHTTP;
    static String hostNameHTTPS;
    static String contextRoot;

    static
    {
        contextRoot   = Config.getParameters().getString (URI_CONTEXT_PATH, "");

        String hostName      = Config.getParameters().getString ("host.name", "localhost");
        String hostPortHTTP  = Config.getParameters().getString ("host.port.http", "80");
        String hostPortHTTPS = Config.getParameters().getString ("host.port.https", "443");

        StringBuffer hostHTTP = new StringBuffer("http://");
        hostHTTP.append(hostName);
        if (!hostPortHTTP.equals("80")) {
            hostHTTP.append(":");
            hostHTTP.append(hostPortHTTP);
        }
        hostNameHTTP = hostHTTP.toString();

        StringBuffer hostHTTPS = new StringBuffer("https://");
        hostHTTPS.append(hostName);
        if (!hostPortHTTPS.equals("443")) {
            hostHTTPS.append(":");
            hostHTTPS.append(hostPortHTTPS);
        }
        hostNameHTTPS = hostHTTPS.toString();
    }

    /**
     * Creates and URL pointing to the home of the portal
     * 
     * @param request   the servlet request
     * @return the portal URL
     */
    public String getBasePortalURL(HttpServletRequest request)
    {
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

    static public String getBaseURLexcludeContext()
    {
        StringBuffer result = new StringBuffer(256);

        result.append(hostNameHTTP);

        return result.toString();
    }

    static public String getBaseURLincludeContext()
    {
        StringBuffer result = new StringBuffer(256);

        result.append(hostNameHTTP);
        result.append('/');
        result.append(contextRoot);

        return result.toString();
    }

    private String base;
    private List startGlobalNavigation = new ArrayList();
    private List startLocalNavigation = new ArrayList();
    private HashMap startControlParameter = new HashMap();
    private HashMap startStateLessControlParameter = new HashMap();
    private boolean analyzed = false;
    private boolean secure;

    private PortalEnvironment environment;

    /**
     * Creates and URL pointing to the home of the portal
     * 
     * @param env     the portal environment
     */
    public PortalURL(PortalEnvironment env)
    {
        environment = env;
        this.base = getBasePortalURL(environment);
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
     * of a global portal part, e.g. a portlet on a page
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

    public String getGlobalNavigationAsString()
    {
        StringBuffer result = new StringBuffer(200);
        Iterator iterator = startGlobalNavigation.iterator();
        if (iterator.hasNext()) {
            result.append((String)iterator.next());
            while (iterator.hasNext()) {
                result.append("/");
                result.append((String)iterator.next());
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

    public String getControlParameterAsString(PortalControlParameter controlParam)
    {
        Map stateFullParams = startControlParameter;
        Map stateLessParams = null;
        if (controlParam != null) {
            stateFullParams = controlParam.getStateFullControlParameter();
            stateLessParams = controlParam.getStateLessControlParameter();
        }

        StringBuffer result = new StringBuffer(100);
        Iterator iterator = stateFullParams.keySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.hasNext()) result.append("/");
            String name = (String)iterator.next();
            result.append(PortalControlParameter.encodeParameter(name));
            result.append("/");
            result.append((String)stateFullParams.get(name));
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

                result.append(name);
                result.append("=");
                result.append(values[0]);
                for (int i = 1; i < values.length; i++) {
                    result.append("&");
                    result.append(name);
                    result.append("=");
                    result.append(values[i]);
                };

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
        urlBase.append(secure?hostNameHTTPS:hostNameHTTP);
        urlBase.append(base);

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

    Map getClonedStateFullControlParameter()
    {
        analyzeRequestInformation();
        return(Map)startControlParameter.clone();
    }

    Map getClonedStateLessControlParameter()
    {
        analyzeRequestInformation();
        return(Map)startStateLessControlParameter.clone();
    }

    void analyzeControlInformation(PortalControlParameter control)
    {
        startControlParameter = (HashMap)control.getStateFullControlParameter();
        startStateLessControlParameter = (HashMap)control.getStateLessControlParameter();
    }

    void analyzeRequestInformation()
    {
        if (analyzed) return;

        startGlobalNavigation = new ArrayList();
        startLocalNavigation = new ArrayList();
        startControlParameter = new HashMap();
        startStateLessControlParameter = new HashMap();

        // check the complete pathInfo for
        // * navigational information
        // * control information
        String pathInfo = environment.getRequest().getPathInfo();

        if (pathInfo != null) {
            StringTokenizer tokenizer = new StringTokenizer(pathInfo, "/.");

            int mode = 0; // 0=navigation, 1=control information
            String name = null;
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (PortalControlParameter.isControlParameter(token)) {
                    mode = 1;
                    name = token;
                } else if (mode==0) {
                    startGlobalNavigation.add(token);
                } else if (mode==1) {
                    if ((PortalControlParameter.isStateFullParameter(name))) {
                        startControlParameter.put(PortalControlParameter.decodeParameterName(name),
                                                  PortalControlParameter.decodeParameterValue(name,token));
                    } else {
                        startStateLessControlParameter.put(PortalControlParameter.decodeParameterName(name),
                                                           PortalControlParameter.decodeParameterValue(name,token));
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
        startControlParameter.put(PortalControlParameter.encodeRenderParamName(portletWindow,name),
                                  PortalControlParameter.encodeRenderParamValues(values));

    }

    public void clearRenderParameters(PortletWindow portletWindow)
    {
        String prefix = PortalControlParameter.getRenderParamKey(portletWindow);
        Iterator keyIterator = startControlParameter.keySet().iterator();

        while (keyIterator.hasNext()) {
            String name = (String)keyIterator.next();
            if (name.startsWith(prefix)) {
                keyIterator.remove();
            }
        }
    }

}
