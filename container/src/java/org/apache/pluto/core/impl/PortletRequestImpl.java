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
package org.apache.pluto.core.impl;

import java.io.BufferedReader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.portlet.PortalContext;
import javax.portlet.PortletContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.binding.PortletDD;
import org.apache.pluto.binding.SecurityRoleRefDD;
import org.apache.pluto.binding.SupportedMimeTypeDD;
import org.apache.pluto.core.InternalPortletRequest;
import org.apache.pluto.core.InternalPortletWindow;
import org.apache.pluto.core.PortletEntity;
import org.apache.pluto.services.PropertyManagerService;
import org.apache.pluto.util.Enumerator;
import org.apache.pluto.util.NamespaceMapper;
import org.apache.pluto.util.StringUtils;
import org.apache.pluto.util.impl.NamespaceMapperImpl;

/**
 * <code>PortletRequest</code> Implementation.
 *
 */
public abstract class PortletRequestImpl extends HttpServletRequestWrapper
    implements PortletRequest, InternalPortletRequest {

    /**
     * The parent container within which this request was created.
     */
    private PortletContainer container;

    /**
     * The portlet window which is the target of this portlet request.
     */
    private InternalPortletWindow internalPortletWindow;

    /**
     * The PortletContext associated with this Request. This PortletContext must
     * be initialized from within the <code>PortletServlet</code>.
     */
    private PortletContext context;

    /**
     * The PortalContext within which this request is occuring.
     */
    private PortalContext portalContext;

    /**
     * Holds the portlet session
     */
    private PortletSession portletSession;

    /** Response content types. */
    private Vector contentTypes;

    private NamespaceMapper mapper = new NamespaceMapperImpl();

    /**
     * true if the HTTP-Body has been accessed
     */
    private boolean bodyAccessed;

    /**
     * true if we are in an include call
     */
    private boolean included;

    public PortletRequestImpl(PortletContainer container,
                              InternalPortletWindow internalPortletWindow,
                              HttpServletRequest servletRequest) {
        super(servletRequest);
        this.container = container;
        this.internalPortletWindow = internalPortletWindow;
        this.portalContext =
        container.getContainerServices().getPortalContext();

    }


    /**
     * Determine whether or not the specified WindowState is allowed for this
     * portlet.
     * @param state the state in question
     * @return true if the state is allowed.
     */
    public boolean isWindowStateAllowed(WindowState state) {
        Enumeration supportedStates = portalContext.getSupportedWindowStates();
        while (supportedStates.hasMoreElements()) {
            if (supportedStates.nextElement().toString().equals(
                (state.toString()))) {
                return true;
            }
        }
        return false;
    }


    public boolean isPortletModeAllowed(PortletMode mode) {
        return isPortletModeAllowedByPortlet(mode)
               && isPortletModeAllowedByPortal(mode);
    }

    public PortletMode getPortletMode() {
        return internalPortletWindow.getPortletMode();
    }

    public WindowState getWindowState() {
        return internalPortletWindow.getWindowState();
    }

    // needs to be implemented in each subclass
    public abstract PortletPreferences getPreferences();

    public PortletSession getPortletSession() {
        return getPortletSession(true);
    }

    public PortletSession getPortletSession(boolean create) {
        // check if the session was invalidated
        HttpSession httpSession = this.getHttpServletRequest()
            .getSession(false);

        if ((portletSession != null) && (httpSession == null)) {
            portletSession = null;
        } else if (httpSession != null) {
            create = true;
        }

        if (create && portletSession == null) {
            httpSession = this.getHttpServletRequest().getSession(create);
            if (httpSession != null) {
                portletSession =
                new PortletSessionImpl(context, internalPortletWindow,
                                       httpSession);
            }
        }

        return portletSession;
    }

    public String getProperty(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Attribute name == null");
        }

        // get properties from request header
        String prop = this.getHttpServletRequest().getHeader(name);
        if (prop == null) {
            // get properties from PropertyManager
            PropertyManagerService mgr = container.getContainerServices()
                .getPropertyManagerService();
            Map map = mgr.getRequestProperties(internalPortletWindow,
                                               this.getHttpServletRequest());
            if (map != null) {
                String[] properties = (String[]) map.get(name);
                if ((properties != null) && (properties.length > 0)) {
                    prop = properties[0];
                }
            }
        }

        return prop;
    }

    public Enumeration getProperties(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Property name == null");
        }

        Set v = new HashSet();

        // get properties from request header
        Enumeration props = this.getHttpServletRequest().getHeaders(name);
        if (props != null) {
            while (props.hasMoreElements()) {
                v.add(props.nextElement());
            }
        }

        // get properties from PropertyManager
        PropertyManagerService mgr = container.getContainerServices()
            .getPropertyManagerService();
        Map map = mgr.getRequestProperties(internalPortletWindow,
                                           this.getHttpServletRequest());
        if (map != null) {
            String[] properties = (String[]) map.get(name);

            if (properties != null) {
                // add properties to vector
                for (int i = 0; i < properties.length; i++) {
                    v.add(properties[i]);
                }
            }
        }

        return new Enumerator(v.iterator());
    }

    public Enumeration getPropertyNames() {
        Set v = new HashSet();           

        // get properties from PropertyManager
        PropertyManagerService mgr = container.getContainerServices()
            .getPropertyManagerService();
        Map map = mgr.getRequestProperties(internalPortletWindow,
                                           this.getHttpServletRequest());
        if (map != null) {
            v.addAll(map.keySet());
        }

        // get properties from request header
        Enumeration props = this.getHttpServletRequest().getHeaderNames();
        if (props != null) {
            while (props.hasMoreElements()) {
                v.add(props.nextElement());
            }
        }

        return new Enumerator(v.iterator());
    }

    public PortalContext getPortalContext() {
        return container.getContainerServices().getPortalContext();
    }

    public String getAuthType() {
        return this.getHttpServletRequest().getAuthType();
    }

    public String getContextPath() {
        return this.internalPortletWindow.getContextPath();
        //return ((HttpServletRequest)getRequest()).getContextPath();
    }

    public String getRemoteUser() {
        return this.getHttpServletRequest().getRemoteUser();
    }

    public java.security.Principal getUserPrincipal() {
        return this.getHttpServletRequest().getUserPrincipal();
    }

    /**
     * Determines whether a user is mapped to the specified role.  As specified
     * in PLT-20-3, we must reference the &lt;security-role-ref&gt; mappings
     * within the deployment descriptor. If no mapping is available, then, and
     * only then, do we check use the actual role name specified against the web
     * application deployment descriptor.
     * @param roleName the name of the role
     * @return true if it is determined the user has the given role.
     */
    public boolean isUserInRole(String roleName) {
        PortletEntity entity = internalPortletWindow.getPortletEntity();
        PortletDD def = entity.getPortletDefinition();

        SecurityRoleRefDD ref = null;
        SecurityRoleRefDD[] refs = def.getSecurityRoleRefs();
        for (int i = 0; i < refs.length; i++) {
            if (refs[i].getRoleName().equals(roleName)) {
                ref = refs[i];
                break;
            }
        }

        String link = null;
        if (ref != null && ref.getRoleLink() != null) {
            link = ref.getRoleLink();
        } else {
            link = roleName;
        }

        return this.getHttpServletRequest().isUserInRole(link);
    }

    public Object getAttribute(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Attribute name == null");
        }

        Object attribute = this.getHttpServletRequest().getAttribute(
            mapper.encode(internalPortletWindow.getId(), name));

        if (attribute == null) {
            attribute = this.getHttpServletRequest().getAttribute(name);
        }
        return attribute;
    }

    public Enumeration getAttributeNames() {
        Enumeration attributes = this.getHttpServletRequest()
            .getAttributeNames();

        Vector portletAttributes = new Vector();

        while (attributes.hasMoreElements()) {
            String attribute = (String) attributes.nextElement();

            String portletAttribute = mapper.decode(
                internalPortletWindow.getId(), attribute);

            if (portletAttribute != null) { // it is in the portlet's namespace
                portletAttributes.add(portletAttribute);
            }
        }

        return portletAttributes.elements();
    }

    public String getParameter(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Parameter name == null");
        }

        bodyAccessed = true;

        Map parameters = this.getHttpServletRequest().getParameterMap();
        String[] values = (String[]) parameters.get(name);
        if (values != null) {
            return values[0];
        }
        return null;
    }

    public java.util.Enumeration getParameterNames() {
        bodyAccessed = true;

        Map parameters = this.getHttpServletRequest().getParameterMap();
        return Collections.enumeration(parameters.keySet());
    }

    public String[] getParameterValues(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Parameter name == null");
        }

        bodyAccessed = true;

        String[] values = (String[]) this.getHttpServletRequest()
            .getParameterMap()
            .get(name);
        if (values != null) {
            values = StringUtils.copy(values);
        }
        return values;
    }

    public Map getParameterMap() {
        bodyAccessed = true;
        Map result = StringUtils.copyParameters(
            this.getHttpServletRequest().getParameterMap());
        return result;
    }

    public boolean isSecure() {
        return this.getHttpServletRequest().isSecure();
    }

    public void setAttribute(String name, Object o) {
        if (name == null) {
            throw new IllegalArgumentException("Attribute name == null");
        }

        if (o == null) {
            this.removeAttribute(name);
        } else if (isNameReserved(name)) {
            // Reserved names go directly in the underlying request
            getHttpServletRequest().setAttribute(name, o);
        } else {
            this.getHttpServletRequest().setAttribute(
                mapper.encode(internalPortletWindow.getId(), name), o);
        }
    }

    public void removeAttribute(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Attribute name == null");
        }
        if (isNameReserved(name)) {
            // Reserved names go directly in the underlying request
            getHttpServletRequest().removeAttribute(name);
        } else {

            this.getHttpServletRequest().
                removeAttribute(
                    mapper.encode(internalPortletWindow.getId(), name));
        }
    }

    public String getRequestedSessionId() {
        return this.getHttpServletRequest().getRequestedSessionId();
    }

    public boolean isRequestedSessionIdValid() {
        return this.getHttpServletRequest().isRequestedSessionIdValid();
    }

    public String getResponseContentType() {
        Enumeration enumeration = getResponseContentTypes();
        while(enumeration.hasMoreElements()) {
            return (String)enumeration.nextElement();
        }
        return "text/html";
    }

    public Enumeration getResponseContentTypes() {
        if(contentTypes == null) {
            contentTypes = new Vector();
            PortletDD dd = internalPortletWindow.getPortletEntity().getPortletDefinition();
            SupportedMimeTypeDD[] types = dd.getSupportedMimeTypes();
            for(int i=0;i<types.length;i++) {
                contentTypes.add(types[i].getMimeType());
            }
            if(contentTypes.size() < 1) {
                contentTypes.add("text/html");
            }
        }
        return contentTypes.elements();
    }

    public java.util.Locale getLocale() {
        return this.getHttpServletRequest().getLocale();
    }

    public Enumeration getLocales() {
        return this.getHttpServletRequest().getLocales();
    }

    public String getScheme() {
        return this.getHttpServletRequest().getScheme();
    }

    public String getServerName() {
        return this.getHttpServletRequest().getServerName();
    }

    public int getServerPort() {
        return this.getHttpServletRequest().getServerPort();
    }

    // --------------------------------------------------------------------------------------------

    public InternalPortletWindow getInternalPortletWindow() {
        return internalPortletWindow;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }

    public boolean isIncluded() {
        return included;
    }
    // --------------------------------------------------------------------------------------------

    // internal methods ---------------------------------------------------------------------------
    private HttpServletRequest getHttpServletRequest() {
        return (HttpServletRequest) super.getRequest();
    }

    /**
     * Is this attribute name a reserved name (by the J2EE spec)?. Reserved
     * names begin with "java." or "javax.".
     */
    private boolean isNameReserved(String name) {
        return name.startsWith("java.") || name.startsWith("javax.");
    }
    // --------------------------------------------------------------------------------------------

    // additional methods
    // .HttpServletRequestWrapper
    public java.lang.String getCharacterEncoding() {
        return this.getHttpServletRequest().getCharacterEncoding();
    }

    public java.lang.String getContentType() {
        if (included) {
            return null;
        } else {
            return this.getHttpServletRequest().getContentType();
        }
    }

    public int getContentLength() {
        if (included) {
            return 0;
        } else {
            return getHttpServletRequest().getContentLength();
        }
    }

    public BufferedReader getReader()
        throws java.io.UnsupportedEncodingException, java.io.IOException {
        if (included) {
            return null;
        } else {
            // the super class will ensure that a IllegalStateException is thrown if getInputStream() was called earlier
            BufferedReader reader = getHttpServletRequest().getReader();
            bodyAccessed = true;
            return reader;
        }
    }


    public String getPathInfo() {
        String attr = (String) super.getAttribute(
            "javax.servlet.include.path_info");
        return (attr != null) ? attr
               : super.getPathInfo();
    }

    public String getQueryString() {
        String attr = (String) super.getAttribute(
            "javax.servlet.include.query_string");
        return (attr != null) ? attr
               : super.getQueryString();
    }

    public String getPathTranslated() {
        return null;
    }

    public String getRequestURI() {
        String attr = (String) super.getAttribute(
            "javax.servlet.include.request_uri");
        return (attr != null) ? attr
               : super.getRequestURI();
    }

    public StringBuffer getRequestURL() {
        return null;
    }

    public String getServletPath() {
        String attr = (String) super.getAttribute(
            "javax.servlet.include.servlet_path");
        return (attr != null) ? attr
               : super.getServletPath();
    }


    //
    //
    // @todo WHY? Do we return null to these emthods?
    //
    //

    public String getProtocol() {
        return null;
    }

    public String getRemoteAddr() {
        return null;
    }

    public String getRemoteHost() {
        return null;
    }

    public String getRealPath(String path) {
        return null;
    }

    public void setCharacterEncoding(String env)
        throws java.io.UnsupportedEncodingException {
        if (bodyAccessed) {
            throw new IllegalStateException(
                "This method must not be called after the HTTP-Body was accessed !");
        }

        this.getHttpServletRequest().setCharacterEncoding(env);
        return;
    }

    public javax.servlet.ServletInputStream getInputStream()
        throws java.io.IOException {
        if (included) {
            return null;
        } else {
            // the super class will ensure that a IllegalStateException is thrown if getReader() was called earlier
            javax.servlet.ServletInputStream stream = getHttpServletRequest()
                .getInputStream();

            bodyAccessed = true;

            return stream;
        }
    }

    public javax.servlet.RequestDispatcher getRequestDispatcher(String path) {
        return this.getHttpServletRequest().getRequestDispatcher(path);
    }

// Internal Implementation Detailes

    public void setPortletContext(PortletContext context) {
        this.context = context;
    }

    public PortletContainer getContainer() {
        return container;
    }

    public InternalPortletWindow getWindow() {
        return internalPortletWindow;
    }

    private boolean isPortletModeAllowedByPortlet(PortletMode mode) {
        PortletDD dd = internalPortletWindow.getPortletEntity()
            .getPortletDefinition();

        SupportedMimeTypeDD[] mimes = dd.getSupportedMimeTypes();
        for (int i = 0; i < mimes.length; i++) {
            String[] modes = mimes[i].getPortletModes();
            for (int j = 0; j < modes.length; j++) {
                if (modes[j].equals(mode.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPortletModeAllowedByPortal(PortletMode mode) {
        Enumeration supportedModes = portalContext.getSupportedPortletModes();
        while (supportedModes.hasMoreElements()) {
            if (supportedModes.nextElement().toString().equals(
                (mode.toString()))) {
                return true;
            }
        }
        return false;
    }


}
