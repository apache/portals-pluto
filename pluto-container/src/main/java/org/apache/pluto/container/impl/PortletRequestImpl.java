/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.container.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ccpp.Profile;
import javax.portlet.CacheControl;
import javax.portlet.MimeResponse;
import javax.portlet.PortalContext;
import javax.portlet.PortletContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.WindowState;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.pluto.container.ContainerServices;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletEnvironmentService;
import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletResponseContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.om.portlet.CustomPortletMode;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.SecurityRoleRef;
import org.apache.pluto.container.om.portlet.Supports;
import org.apache.pluto.container.util.ArgumentUtility;
import org.apache.pluto.container.util.StringManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Abstract <code>javax.portlet.PortletRequest</code> implementation.
 * This class also implements InternalPortletRequest.
 *
 */
public abstract class PortletRequestImpl implements PortletRequest
{
    public static final String ACCEPT_LANGUAGE = "Accept-Language";

    private static final Logger LOG = LoggerFactory.getLogger(PortletRequestImpl.class);

    private static final StringManager EXCEPTIONS =
        StringManager.getManager(PortletRequestImpl.class.getPackage().getName());

    private static final List<String> EMPTY_STRING_LIST = Collections.unmodifiableList(new ArrayList<String>(0));

    // Private Member Variables ------------------------------------------------

    /** The PortalContext within which this request is occuring. */
    private PortalContext portalContext;

    private PortletRequestContext requestContext;
    private PortletResponseContext responseContext;

    /** The portlet session. */
    private PortletSession portletSession;

    /** Response content types. */
    private ArrayList<String> contentTypes;

    private PortletPreferences portletPreferences;

    private Map<String, String[]> parameters;

    private Map<String, String[]> requestProperties;
    private List<String> requestPropertyNames;

    private Cookie[] requestCookies;

    private Map<String, String> userInfo;

    private Profile ccppProfile;

    private String contextPath;

    private final String lifecyclePhase;

    public PortletRequestImpl(PortletRequestContext requestContext, PortletResponseContext responseContext, String lifecyclePhase)
    {
        this.requestContext = requestContext;
        this.responseContext = responseContext;
        this.lifecyclePhase = lifecyclePhase;
        this.portalContext = getPortletContainer().getContainerServices().getPortalContext();
    }

    private void retrieveRequestProperties()
    {
        Map<String, String[]> properties = requestContext.getProperties();
        requestPropertyNames = new ArrayList<String>(properties.size());
        requestProperties = new HashMap<String, String[]>(properties.size());
        for (Map.Entry<String, String[]> entry : properties.entrySet())
        {
            requestPropertyNames.add(entry.getKey());
            requestProperties.put(entry.getKey().toLowerCase(), entry.getValue());
        }
    }

    private void checkInitParameterMap()
    {
        if (parameters == null)
        {
            parameters = initParameterMap();
        }
    }

    protected static Map<String, String[]> cloneParameterMap(Map<String, String[]> map)
    {
        if (!map.isEmpty())
        {
            Map<String, String[]> result = new HashMap<String, String[]>(map.size());
            for (Map.Entry<String,String[]> entry : map.entrySet())
            {
                if (entry.getValue() != null)
                {
                    result.put(entry.getKey(), entry.getValue().clone());
                }
            }
            return Collections.unmodifiableMap(result);
        }
        return Collections.emptyMap();
    }

    protected Map<String, String[]> initParameterMap()
    {
        String[] values  = null;
        Map<String, String[]> parameters = requestContext.getPrivateParameterMap();
        Map<String, String[]> publicParameters = requestContext.getPublicParameterMap();
        if (!publicParameters.isEmpty())
        {
            parameters = new HashMap<String, String[]>(parameters);
            for (Map.Entry<String,String[]> entry : publicParameters.entrySet())
            {
                values = parameters.get(entry.getKey());
                if (values == null)
                {
                    parameters.put(entry.getKey(), entry.getValue().clone());
                }
                else
                {
                    String[] copy = new String[values.length+entry.getValue().length];
                    System.arraycopy(values, 0, copy, 0, values.length);
                    System.arraycopy(entry.getValue(), 0, copy, values.length, entry.getValue().length);
                    parameters.put(entry.getKey(), copy);
                }
            }
        }
        return parameters;
    }

    protected PortletRequestContext getRequestContext()
    {
        return requestContext;
    }

    protected PortletContext getPortletContext()
    {
        return requestContext.getPortletConfig().getPortletContext();
    }

    protected PortletWindow getPortletWindow()
    {
        return requestContext.getPortletWindow();
    }

    protected PortletContainer getPortletContainer()
    {
        return requestContext.getContainer();
    }

    protected HttpServletRequest getServletRequest()
    {
        return requestContext.getServletRequest();
    }

    protected String getMimeRequestProperty(String name, CacheControl cacheControl)
    {
        if (MimeResponse.ETAG.equals(name))
        {
            return cacheControl.getETag();
        }
        else if (MimeResponse.CACHE_SCOPE.equals(name))
        {
            return cacheControl.isPublicScope() ? MimeResponse.PUBLIC_SCOPE : MimeResponse.PRIVATE_SCOPE;
        }
        else if (MimeResponse.USE_CACHED_CONTENT.equals(name))
        {
            return cacheControl.useCachedContent() ? "true" : null;
        }
        else if (MimeResponse.EXPIRATION_CACHE.equals(name))
        {
            return Integer.toString(cacheControl.getExpirationTime());
        }
        return null;
    }

    // PortletRequest Impl -----------------------------------------------------

    public Object getAttribute(String name)
    {
        ArgumentUtility.validateNotNull("attributeName", name);
        if (name.equals(PortletRequest.LIFECYCLE_PHASE))
        {
            return lifecyclePhase;
        }
        else if (name.equals(PortletRequest.USER_INFO))
        {
            if (userInfo == null)
            {
                try
                {
                    userInfo = getPortletContainer().getContainerServices().getUserInfoService().getUserInfo(this, getPortletWindow());
                }
                catch (Exception e)
                {
                    userInfo = Collections.emptyMap();
                }
            }
            return userInfo;
        }
        else if (name.equals(PortletInvokerService.REQUEST_CONTEXT))
        {
            return requestContext;
        }
        else if (name.equals(PortletInvokerService.RESPONSE_CONTEXT))
        {
            return responseContext;
        }
        else if (name.equals(PortletRequest.CCPP_PROFILE))
        {
            if (ccppProfile == null)
            {
                ccppProfile = getPortletContainer().getContainerServices().getCCPPProfileService().getCCPPProfile(getServletRequest());
            }
            return ccppProfile;
        }
        return requestContext.getAttribute(name);
    }

    public Enumeration<String> getAttributeNames()
    {
        return requestContext.getAttributeNames();
    }

    public String getAuthType()
    {
        return getServletRequest().getAuthType();
    }

    public String getContextPath()
    {
        if (contextPath == null)
        {
            contextPath = requestContext.getPortletWindow().getPortletDefinition().getApplication().getContextPath();
        }

        return contextPath;
    }

    public Cookie[] getCookies()
    {
        if (requestCookies == null)
        {
            requestCookies = requestContext.getCookies();
            if (requestCookies == null)
            {
                requestCookies = new Cookie[0];
            }
        }
        return requestCookies.length > 0 ? requestCookies.clone() : null;
    }

    public Locale getLocale()
    {
        return requestContext.getPreferredLocale();
    }

    @SuppressWarnings("unchecked")
    public Enumeration<Locale> getLocales()
    {
        Locale preferredLocale = getLocale();
        ArrayList<Locale> locales = new ArrayList<Locale>();
        locales.add(preferredLocale);
        for (Enumeration e = getServletRequest().getLocales(); e.hasMoreElements(); )
        {
            Locale locale = (Locale)e.nextElement();
            if (!locale.equals(preferredLocale))
            {
                locales.add(locale);
            }
        }
        return Collections.enumeration(locales);
    }

    public String getParameter(String name)
    {
        ArgumentUtility.validateNotNull("parameterName", name);
        checkInitParameterMap();
        String[] values = parameters.get(name);
        return values != null && values.length > 0 ? values[0] : null;
    }

    public Map<String, String[]> getParameterMap()
    {
        checkInitParameterMap();
        return cloneParameterMap(parameters);
    }

    public Enumeration<String> getParameterNames()
    {
        checkInitParameterMap();
        return Collections.enumeration(parameters.keySet());
    }

    public String[] getParameterValues(String name)
    {
        ArgumentUtility.validateNotNull("parameterName", name);
        checkInitParameterMap();
        String[] values =  parameters.get(name);
        return values != null ? values.clone() : null;
    }

    public PortalContext getPortalContext()
    {
        return portalContext;
    }

    public PortletMode getPortletMode()
    {
        return getPortletWindow().getPortletMode();
    }

    public PortletSession getPortletSession()
    {
        return getPortletSession(true);
    }

    /**
     * Returns the portlet session.
     * <p>
     * Note that since portlet request instance is created everytime the portlet
     * container receives an incoming request, the portlet session instance held
     * by the request instance is also re-created for each incoming request.
     * </p>
     */
    public PortletSession getPortletSession(boolean create)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Retreiving portlet session (create=" + create + ")");
        }
        //
        // It is critical that we don't retrieve the portlet session until the
        //   cross context dispatch has been completed.  If we do then we risk
        //   having a cached version which is invalid for the context within
        //   which it exists.
        //
        if (getPortletContext() == null)
        {
            throw new IllegalStateException(
                    EXCEPTIONS.getString("error.session.illegalState"));
        }
        //
        // We must make sure that if the session has been invalidated (perhaps
        //   through setMaxIntervalTimeout()) and the underlying request
        //   returns null that we no longer use the cached version.
        // We have to check (ourselves) if the session has exceeded its max
        //   inactive interval. If so, we should invalidate the underlying
        //   HttpSession and recreate a new one (if the create flag is set to
        //   true) -- We just cannot depend on the implementation of
        //   javax.servlet.http.HttpSession!
        //
        HttpSession httpSession = getServletRequest().getSession(create);
        if (httpSession != null)
        {
            // HttpSession is not null does NOT mean that it is valid.
            int maxInactiveInterval = httpSession.getMaxInactiveInterval();
            long lastAccesstime = httpSession.getLastAccessedTime();//lastAccesstime checks added for PLUTO-436
            if (maxInactiveInterval >= 0 && lastAccesstime > 0)
            {    // < 0 => Never expires.
                long maxInactiveTime = httpSession.getMaxInactiveInterval() * 1000L;
                long currentInactiveTime = System.currentTimeMillis() - lastAccesstime;
                if (currentInactiveTime > maxInactiveTime)
                {
                    if (LOG.isDebugEnabled())
                    {
                        LOG.debug("The underlying HttpSession is expired and "
                                + "should be invalidated.");
                    }
                    httpSession.invalidate();
                    httpSession = getServletRequest().getSession(create);
                    //Added for PLUTO-436
                    // a cached portletSession is no longer useable.
                    // a new one will be created below.
                    portletSession = null;
                }
            }
        }
        if (httpSession == null)
        {
            if (LOG.isDebugEnabled())
            {
                LOG.debug("The underlying HttpSession is not available: "
                        + "no session will be returned.");
            }
            return null;
        }
        //
        // If we reach here, we are sure that the underlying HttpSession is
        //   available. If we haven't created and cached a portlet session
        //   instance, we will create and cache one now.
        //
        if (portletSession == null)
        {
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Creating new portlet session...");
            }
            final ContainerServices containerServices = getPortletContainer().getContainerServices();
            final PortletEnvironmentService portletEnvironmentService = containerServices.getPortletEnvironmentService();

            portletSession = portletEnvironmentService.createPortletSession(getPortletContext(), getPortletWindow(), httpSession);
        }
        return portletSession;
    }

    public PortletPreferences getPreferences()
    {
        if (portletPreferences == null)
        {
            portletPreferences = new PortletPreferencesImpl(
                    getPortletContainer(),getPortletWindow(),
                    this);
        }
        return portletPreferences;
    }

    public Map<String, String[]> getPrivateParameterMap()
    {
        return cloneParameterMap(requestContext.getPrivateParameterMap());
    }

    @SuppressWarnings("unchecked")
    public Enumeration<String> getProperties(String name)
    {
        ArgumentUtility.validateNotNull("propertyName", name);

        if(ACCEPT_LANGUAGE.equalsIgnoreCase(name))
        {
            Locale preferredLocale = getLocale();
            ArrayList<String> locales = new ArrayList<String>();
            locales.add(preferredLocale.toString());
            for (Enumeration e = getServletRequest().getLocales(); e.hasMoreElements(); )
            {
                Locale locale = (Locale)e.nextElement();
                if (!locale.equals(preferredLocale))
                {
                    locales.add(locale.toString());
                }
            }
            return Collections.enumeration(locales);
        }

        if (requestProperties == null)
        {
            retrieveRequestProperties();
        }
        String[] properties = requestProperties.get(name.toLowerCase());
        if (properties == null)
        {
            return Collections.enumeration(EMPTY_STRING_LIST);
        }
        return Collections.enumeration(Arrays.asList(properties));
    }

    public String getProperty(String name)
    {
        ArgumentUtility.validateNotNull("name", name);

        if(ACCEPT_LANGUAGE.equalsIgnoreCase(name))
        {
            return getLocale().toString();
        }

        if (requestProperties == null)
        {
            retrieveRequestProperties();
        }
        String property = null;
        String[] properties = requestProperties.get(name.toLowerCase());
        if (properties != null && properties.length > 0)
        {
            property = properties[0];
        }
        return property;
    }

    public Enumeration<String> getPropertyNames()
    {
        if (requestProperties == null)
        {
            retrieveRequestProperties();
        }
        return Collections.enumeration(requestPropertyNames);
    }

    public Map<String, String[]> getPublicParameterMap()
    {
        return cloneParameterMap(requestContext.getPublicParameterMap());
    }

    public String getRemoteUser()
    {
        return getServletRequest().getRemoteUser();
    }

    public String getRequestedSessionId()
    {
        return getServletRequest().getRequestedSessionId();
    }

    public String getResponseContentType()
    {
        return getResponseContentTypes().nextElement();
    }

    public Enumeration<String> getResponseContentTypes()
    {
        if (contentTypes == null)
        {
            contentTypes = new ArrayList<String>();
            PortletDefinition dd = getPortletWindow().getPortletDefinition();
            for (Supports sup : dd.getSupports())
            {
                contentTypes.add(sup.getMimeType());
            }
            if (contentTypes.isEmpty())
            {
                contentTypes.add("text/html");
            }
        }
        return Collections.enumeration(contentTypes);
    }

    public String getScheme()
    {
        return getServletRequest().getScheme();
    }

    public String getServerName()
    {
        return getServletRequest().getServerName();
    }

    public int getServerPort()
    {
        return getServletRequest().getServerPort();
    }

    public Principal getUserPrincipal()
    {
        return getServletRequest().getUserPrincipal();
    }

    public String getWindowID()
    {
        return getPortletWindow().getId().getStringId();
    }

    public WindowState getWindowState()
    {
        return getPortletWindow().getWindowState();
    }

    public boolean isPortletModeAllowed(PortletMode mode)
    {
        if(PortletMode.VIEW.equals(mode))
        {
            return true;
        }

        String modeName = mode.toString();

        PortletDefinition dd = getPortletWindow().getPortletDefinition();

        for (Supports sup : dd.getSupports())
        {
            for (String m : sup.getPortletModes())
            {
                if (m.equalsIgnoreCase(modeName))
                {
                    // check if a portlet managed mode which is always allowed.
                    CustomPortletMode cpm = dd.getApplication().getCustomPortletMode(modeName);
                    if (cpm != null && !cpm.isPortalManaged())
                    {
                        return true;
                    }
                    Enumeration<PortletMode> supportedModes = portalContext.getSupportedPortletModes();
                    while (supportedModes.hasMoreElements())
                    {
                        if (supportedModes.nextElement().equals(mode))
                        {
                            return true;
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public boolean isRequestedSessionIdValid()
    {
        return getServletRequest().isRequestedSessionIdValid();
    }

    public boolean isSecure()
    {
        return getServletRequest().isSecure();
    }

    /**
     * Determines whether a user is mapped to the specified role.  As specified
     * in PLT-20-3, we must reference the &lt;security-role-ref&gt; mappings
     * within the deployment descriptor. If no mapping is available, then, and
     * only then, do we check use the actual role name specified against the web
     * application deployment descriptor.
     *
     * @param roleName the name of the role
     * @return true if it is determined the user has the given role.
     */
    public boolean isUserInRole(String roleName)
    {
        PortletDefinition def = getPortletWindow().getPortletDefinition();
        String link = roleName;

        for (SecurityRoleRef r : def.getSecurityRoleRefs())
        {
            if (r.getRoleName().equals(roleName))
            {
                if (r.getRoleLink() != null)
                {
                    link = r.getRoleLink();
                }
                break;
            }
        }
        return getServletRequest().isUserInRole(link);
    }

    /**
     * Determine whether or not the specified WindowState is allowed for this
     * portlet.
     *
     * @param state the state in question
     * @return true if the state is allowed.
     */
    public boolean isWindowStateAllowed(WindowState state)
    {
        for (Enumeration<WindowState> en = portalContext.getSupportedWindowStates();
        en.hasMoreElements(); )
        {
            if (en.nextElement().toString().equalsIgnoreCase(state.toString()))
            {
                return true;
            }
        }
        return false;
    }

    public void setAttribute(String name, Object value)
    {
        ArgumentUtility.validateNotEmpty("name", name);
        requestContext.setAttribute(name, value);
    }

    public void removeAttribute(String name)
    {
        ArgumentUtility.validateNotEmpty("name", name);
        requestContext.setAttribute(name, null);
    }
}
