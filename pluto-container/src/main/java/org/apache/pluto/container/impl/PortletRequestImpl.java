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
import javax.portlet.RenderParameters;
import javax.portlet.WindowState;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletResponseContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.om.portlet.CustomPortletMode;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.SecurityRoleRef;
import org.apache.pluto.container.om.portlet.Supports;
import org.apache.pluto.container.util.ArgumentUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract <code>javax.portlet.PortletRequest</code> implementation. This class also implements InternalPortletRequest.
 * 
 */
public abstract class PortletRequestImpl implements PortletRequest {
   public static final String             ACCEPT_LANGUAGE   = "Accept-Language";
   public static final String             USER_AGENT        = "User-Agent";

   private static final Logger            LOG               = LoggerFactory.getLogger(PortletRequestImpl.class);
   @SuppressWarnings("unused")
   private static boolean                 isDebug           = LOG.isDebugEnabled();

   private static final List<String>      EMPTY_STRING_LIST = Collections.unmodifiableList(new ArrayList<String>(0));

   // Private Member Variables ------------------------------------------------

   /** The PortalContext within which this request is occurring. */
   protected final PortalContext          portalContext;

   protected final PortletRequestContext  requestContext;
   protected final PortletResponseContext responseContext;

   /** Response content types. */
   private ArrayList<String>              contentTypes;

   private PortletPreferences             portletPreferences;

   private Map<String, String[]>          requestProperties;
   private List<String>                   requestPropertyNames;

   private Cookie[]                       requestCookies;

   private Map<String, String>            userInfo;

   private Profile                        ccppProfile;

   private String                         contextPath;

   private final String                   lifecyclePhase;

   public PortletRequestImpl(PortletRequestContext requestContext, PortletResponseContext responseContext, String lifecyclePhase) {
      this.requestContext = requestContext;
      this.responseContext = responseContext;
      this.lifecyclePhase = lifecyclePhase;
      this.portalContext = getPortletContainer().getContainerServices().getPortalContext();
   }

   private void retrieveRequestProperties() {
      Map<String, String[]> properties = requestContext.getProperties();
      requestPropertyNames = new ArrayList<String>(properties.size());
      requestProperties = new HashMap<String, String[]>(properties.size());
      for (Map.Entry<String, String[]> entry : properties.entrySet()) {
         requestPropertyNames.add(entry.getKey());
         requestProperties.put(entry.getKey().toLowerCase(), entry.getValue());
      }
   }

   protected static Map<String, String[]> cloneParameterMap(Map<String, String[]> map) {
      Map<String, String[]> newMap = new HashMap<String, String[]>();
      for (String pn : map.keySet()) {
         newMap.put(pn, map.get(pn).clone());
      }
      return newMap;
   }

   protected PortletRequestContext getRequestContext() {
      return requestContext;
   }

   protected PortletWindow getPortletWindow() {
      return requestContext.getPortletWindow();
   }

   protected PortletContainer getPortletContainer() {
      return requestContext.getContainer();
   }

   protected HttpServletRequest getServletRequest() {
      return requestContext.getServletRequest();
   }

   protected HttpServletResponse getServletResponse() {
      return requestContext.getServletResponse();
   }

   protected String getMimeRequestProperty(String name, CacheControl cacheControl) {
      if (MimeResponse.ETAG.equals(name)) {
         return cacheControl.getETag();
      } else if (MimeResponse.CACHE_SCOPE.equals(name)) {
         return cacheControl.isPublicScope() ? MimeResponse.PUBLIC_SCOPE : MimeResponse.PRIVATE_SCOPE;
      } else if (MimeResponse.USE_CACHED_CONTENT.equals(name)) {
         return cacheControl.useCachedContent() ? "true" : null;
      } else if (MimeResponse.EXPIRATION_CACHE.equals(name)) {
         return Integer.toString(cacheControl.getExpirationTime());
      }
      return null;
   }

   // PortletRequest Impl -----------------------------------------------------

   @Override
   public Object getAttribute(String name) {
      ArgumentUtility.validateNotNull("attributeName", name);
      if (name.equals(PortletRequest.LIFECYCLE_PHASE)) {
         return lifecyclePhase;
      } else if (name.equals(PortletRequest.USER_INFO)) {
         if (userInfo == null) {
            try {
               userInfo = getPortletContainer().getContainerServices().getUserInfoService().getUserInfo(this, getPortletWindow());
            } catch (Exception e) {
               userInfo = Collections.emptyMap();
            }
         }
         return userInfo;
      } else if (name.equals(PortletInvokerService.REQUEST_CONTEXT)) {
         return requestContext;
      } else if (name.equals(PortletInvokerService.RESPONSE_CONTEXT)) {
         return responseContext;
      } else if (name.equals(PortletRequest.CCPP_PROFILE)) {
         if (ccppProfile == null) {
            ccppProfile = getPortletContainer().getContainerServices().getCCPPProfileService().getCCPPProfile(getServletRequest());
         }
         return ccppProfile;
      } else if (name.equals("javax.portlet.debug.ServletRequest")) {
         return requestContext.getServletRequest();
      } else if (name.equals("javax.portlet.debug.ServletResponse")) {
         return requestContext.getServletResponse();
      } else if (name.equals("javax.portlet.debug.ServletContext")) {
         return requestContext.getServletContext();
      }
      return requestContext.getAttribute(name);
   }

   @Override
   public Enumeration<String> getAttributeNames() {
      return requestContext.getAttributeNames();
   }

   @Override
   public String getAuthType() {
      return getServletRequest().getAuthType();
   }

   @Override
   public String getContextPath() {
      if (contextPath == null) {
         contextPath = requestContext.getPortletWindow().getPortletDefinition().getApplication().getContextPath();
      }

      return contextPath;
   }

   @Override
   public Cookie[] getCookies() {
      if (requestCookies == null) {
         requestCookies = requestContext.getCookies();
         if (requestCookies == null) {
            requestCookies = new Cookie[0];
         }
      }
      return requestCookies.length > 0 ? requestCookies.clone() : null;
   }

   @Override
   public Locale getLocale() {
      return requestContext.getPreferredLocale();
   }

   @Override
   public Enumeration<Locale> getLocales() {
      Locale preferredLocale = getLocale();
      ArrayList<Locale> locales = new ArrayList<Locale>();
      locales.add(preferredLocale);
      for (Enumeration<Locale> e = getServletRequest().getLocales(); e.hasMoreElements();) {
         Locale locale = e.nextElement();
         if (!locale.equals(preferredLocale)) {
            locales.add(locale);
         }
      }
      return Collections.enumeration(locales);
   }

   @Override
   public String getParameter(String name) {
      ArgumentUtility.validateNotNull("parameterName", name);
      String[] values = requestContext.getParameterMap().get(name);
      return values != null && values.length > 0 ? values[0] : null;
   }

   @Override
   public Map<String, String[]> getParameterMap() {
      return cloneParameterMap(requestContext.getParameterMap());
   }

   @Override
   public Enumeration<String> getParameterNames() {
      return Collections.enumeration(requestContext.getParameterMap().keySet());
   }

   @Override
   public String[] getParameterValues(String name) {
      ArgumentUtility.validateNotNull("parameterName", name);
      String[] values = requestContext.getParameterMap().get(name);
      return values != null ? values.clone() : null;
   }

   @Override
   public PortalContext getPortalContext() {
      return portalContext;
   }

   @Override
   public PortletContext getPortletContext() {
      return requestContext.getPortletConfig().getPortletContext();
   }

   @Override
   public PortletMode getPortletMode() {
      return getPortletWindow().getPortletMode();
   }

   @Override
   public PortletSession getPortletSession() {
      return requestContext.getPortletSession(true);
   }

   /**
    * Returns the portlet session.
    * <p>
    * Note that since portlet request instance is created everytime the portlet container receives an incoming request,
    * the portlet session instance held by the request instance is also re-created for each incoming request.
    * </p>
    */
   @Override
   public PortletSession getPortletSession(boolean create) {
      return requestContext.getPortletSession(create);
   }

   @Override
   public PortletPreferences getPreferences() {
      if (portletPreferences == null) {
         portletPreferences = new PortletPreferencesImpl(getPortletContainer(), getPortletWindow(), this);
      }
      return portletPreferences;
   }

   @Override
   public Map<String, String[]> getPrivateParameterMap() {
      return cloneParameterMap(requestContext.getPrivateParameterMap());
   }

   @Override
   public Enumeration<String> getProperties(String name) {
      ArgumentUtility.validateNotNull("propertyName", name);

      if (ACCEPT_LANGUAGE.equalsIgnoreCase(name)) {
         Locale preferredLocale = getLocale();
         ArrayList<String> locales = new ArrayList<String>();
         locales.add(preferredLocale.toString());
         for (Enumeration<Locale> e = getServletRequest().getLocales(); e.hasMoreElements();) {
            Locale locale = e.nextElement();
            if (!locale.equals(preferredLocale)) {
               locales.add(locale.toString());
            }
         }
         return Collections.enumeration(locales);
      }

      if (requestProperties == null) {
         retrieveRequestProperties();
      }
      String[] properties = requestProperties.get(name.toLowerCase());
      if (properties == null) {
         return Collections.enumeration(EMPTY_STRING_LIST);
      }
      return Collections.enumeration(Arrays.asList(properties));
   }

   @Override
   public String getProperty(String name) {
      ArgumentUtility.validateNotNull("name", name);

      if (ACCEPT_LANGUAGE.equalsIgnoreCase(name)) {
         return getLocale().toString();
      }

      if (requestProperties == null) {
         retrieveRequestProperties();
      }
      String property = null;
      String[] properties = requestProperties.get(name.toLowerCase());
      if (properties != null && properties.length > 0) {
         property = properties[0];
      }
      return property;
   }

   @Override
   public Enumeration<String> getPropertyNames() {
      if (requestProperties == null) {
         retrieveRequestProperties();
      }
      return Collections.enumeration(requestPropertyNames);
   }

   @Override
   public Map<String, String[]> getPublicParameterMap() {
      return cloneParameterMap(requestContext.getPublicParameterMap());
   }

   @Override
   public String getRemoteUser() {
      return getServletRequest().getRemoteUser();
   }

   @Override
   public String getRequestedSessionId() {
      return getServletRequest().getRequestedSessionId();
   }

   @Override
   public String getResponseContentType() {
      return getResponseContentTypes().nextElement();
   }

   @Override
   public Enumeration<String> getResponseContentTypes() {
      if (contentTypes == null) {
         contentTypes = new ArrayList<String>();
         String type = getServletResponse().getContentType();
         if (type == null) {
            // default MIME type for Pluto
            type = "text/html";
         } else {
            // ignore charset parameter
            type = type.replaceAll("([^;]*).*", "$1");
         }
         contentTypes.add(type);
      }
      return Collections.enumeration(contentTypes);
   }

   @Override
   public String getScheme() {
      return getServletRequest().getScheme();
   }

   @Override
   public String getServerName() {
      return getServletRequest().getServerName();
   }

   @Override
   public int getServerPort() {
      return getServletRequest().getServerPort();
   }

   @Override
   public Principal getUserPrincipal() {
      return getServletRequest().getUserPrincipal();
   }

   @Override
   public String getWindowID() {
      return getPortletWindow().getId().getStringId();
   }

   @Override
   public WindowState getWindowState() {
      return getPortletWindow().getWindowState();
   }

   @Override
   public boolean isPortletModeAllowed(PortletMode mode) {
      if (PortletMode.VIEW.equals(mode)) {
         return true;
      }

      String modeName = mode.toString();

      PortletDefinition dd = getPortletWindow().getPortletDefinition();

      for (Supports sup : dd.getSupports()) {
         for (String m : sup.getPortletModes()) {
            if (m.equalsIgnoreCase(modeName)) {
               // check if a portlet managed mode which is always allowed.
               CustomPortletMode cpm = dd.getApplication().getCustomPortletMode(modeName);
               if (cpm != null && !cpm.isPortalManaged()) {
                  return true;
               }
               Enumeration<PortletMode> supportedModes = portalContext.getSupportedPortletModes();
               while (supportedModes.hasMoreElements()) {
                  if (supportedModes.nextElement().equals(mode)) {
                     return true;
                  }
               }
               return false;
            }
         }
      }
      return false;
   }

   @Override
   public boolean isRequestedSessionIdValid() {
      return getServletRequest().isRequestedSessionIdValid();
   }

   @Override
   public boolean isSecure() {
      return getServletRequest().isSecure();
   }

   /**
    * Determines whether a user is mapped to the specified role. As specified in PLT-20-3, we must reference the
    * &lt;security-role-ref&gt; mappings within the deployment descriptor. If no mapping is available, then, and only
    * then, do we check use the actual role name specified against the web application deployment descriptor.
    * 
    * @param roleName
    *           the name of the role
    * @return true if it is determined the user has the given role.
    */
   @Override
   public boolean isUserInRole(String roleName) {
      PortletDefinition def = getPortletWindow().getPortletDefinition();
      String link = roleName;

      for (SecurityRoleRef r : def.getSecurityRoleRefs()) {
         if (r.getRoleName().equals(roleName)) {
            if (r.getRoleLink() != null) {
               link = r.getRoleLink();
            }
            break;
         }
      }
      return getServletRequest().isUserInRole(link);
   }

   /**
    * Determine whether or not the specified WindowState is allowed for this portlet.
    * 
    * @param state
    *           the state in question
    * @return true if the state is allowed.
    */
   @Override
   public boolean isWindowStateAllowed(WindowState state) {
      for (Enumeration<WindowState> en = portalContext.getSupportedWindowStates(); en.hasMoreElements();) {
         if (en.nextElement().toString().equalsIgnoreCase(state.toString())) {
            return true;
         }
      }
      return false;
   }

   @Override
   public void setAttribute(String name, Object value) {
      ArgumentUtility.validateNotEmpty("name", name);
      requestContext.setAttribute(name, value);
   }

   @Override
   public void removeAttribute(String name) {
      ArgumentUtility.validateNotEmpty("name", name);
      requestContext.setAttribute(name, null);
   }

   @Override
   public RenderParameters getRenderParameters() {
      return requestContext.getRenderParameters();
   }

   @Override
   public String getUserAgent() {
      return getProperty(USER_AGENT);
   }
}
