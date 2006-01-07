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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.core.InternalPortletRequest;
import org.apache.pluto.core.InternalPortletWindow;
import org.apache.pluto.core.PortletEntity;
import org.apache.pluto.descriptors.common.SecurityRoleRefDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.portlet.SupportsDD;
import org.apache.pluto.util.Enumerator;
import org.apache.pluto.util.NamespaceMapper;
import org.apache.pluto.util.StringManager;
import org.apache.pluto.util.StringUtils;
import org.apache.pluto.util.impl.NamespaceMapperImpl;

import javax.portlet.PortalContext;
import javax.portlet.PortletContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.WindowState;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.Locale;
import java.security.Principal;

/**
 * Abstract <code>javax.portlet.PortletRequest</code> implementation.
 * This class also implements InternalPortletRequest.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public abstract class PortletRequestImpl extends HttpServletRequestWrapper
        implements PortletRequest, InternalPortletRequest {

    private static final StringManager EXCEPTIONS =
            StringManager.getManager(PortletRequestImpl.class.getPackage().getName());

    private static final Log LOG =
            LogFactory.getLog(PortletRequestImpl.class);

    /**
     * The parent container within which this request was created.
     */
    private PortletContainer container = null;

    /**
     * The portlet window which is the target of this portlet request.
     */
    private InternalPortletWindow internalPortletWindow = null;

    /**
     * The PortletContext associated with this Request. This PortletContext must
     * be initialized from within the <code>PortletServlet</code>.
     */
    private PortletContext portletContext = null;

    /**
     * The PortalContext within which this request is occuring.
     */
    private PortalContext portalContext = null;

    /**
     * Holds the portlet session.
     */
    private PortletSession portletSession = null;

    /**
     * Response content types.
     */
    private Vector contentTypes = null;

    private NamespaceMapper mapper = new NamespaceMapperImpl();

    /**
     * Flag indicating if the HTTP-Body has been accessed.
     */
    private boolean bodyAccessed = false;

    /**
     * true if we are in an include call.
     * FIXME: the included flag should only exist for a render request.
     */
    private boolean included = false;

    // Constructors ------------------------------------------------------------

    public PortletRequestImpl(InternalPortletRequest internalPortletRequest) {
        this(internalPortletRequest.getPortletContainer(),
                internalPortletRequest.getInternalPortletWindow(),
                internalPortletRequest.getHttpServletRequest());
    }

    /**
     * Create a PortletRequestImpl instance.
     *
     * @param container             the portlet container.
     * @param internalPortletWindow the internal portlet window.
     * @param servletRequest        the underlying servlet request.
     */
    public PortletRequestImpl(PortletContainer container,
                              InternalPortletWindow internalPortletWindow,
                              HttpServletRequest servletRequest) {
        super(servletRequest);
        this.container = container;
        this.internalPortletWindow = internalPortletWindow;
        this.portalContext = container.getContainerServices().getPortalContext();
    }

    // javax.portlet.PortletRequest Impl ---------------------------------------

    /**
     * Determine whether or not the specified WindowState is allowed for this
     * portlet.
     *
     * @param state the state in question
     * @return true if the state is allowed.
     */
    public boolean isWindowStateAllowed(WindowState state) {
        Enumeration supportedStates = portalContext.getSupportedWindowStates();
        while (supportedStates.hasMoreElements()) {
            if (supportedStates.nextElement().toString().equals(
                    state.toString())) {
                return true;
            }
        }
        return false;
    }


    public boolean isPortletModeAllowed(PortletMode mode) {
        return (isPortletModeAllowedByPortlet(mode)
                && isPortletModeAllowedByPortal(mode));
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
        if(LOG.isDebugEnabled()) {
            LOG.debug("Retreiving portlet session (create="+create+")");
        }
        //
        // It is critical that we don't retrieve the
        //    portlet session until the cross context
        //    dispatch has been completed.  If we do
        //    then we risk having a cached version which
        //    is invalid for the context within which it
        //    exists.
        //
        if (portletContext == null) {
            throw new IllegalStateException(
                    EXCEPTIONS.getString("error.session.illegalState")
            );
        }

        HttpSession http = getHttpServletRequest().getSession(create);
        // We must make sure that if the session
        // has been invalidated (perhaps through setMaxIntervalTimeout())
        // and the underlying request returns null that we no longer
        // use the cached version.
        //
        if(http == null) {
            if(LOG.isDebugEnabled()) {
                LOG.debug("Underlying Http session is null; No session will be returned.");
            }
            return null;
        }

        if (portletSession == null) {
            portletSession = new PortletSessionImpl(
                    portletContext,
                    internalPortletWindow,
                    http
            );
        }

        return portletSession;
    }

    public String getProperty(String name) throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException(
                EXCEPTIONS.getString("error.propertyName.null")
            );
        }

        String prop = this.getHttpServletRequest().getHeader(name);
        if (prop == null) {
            Map propertyMap = container.getContainerServices()
                    .getPortalCallbackService()
                    .getRequestProperties(
                        getHttpServletRequest(),
                        internalPortletWindow
                    );

            if (propertyMap != null) {
                String[] properties = (String[]) propertyMap.get(name);
                if (properties != null && properties.length > 0) {
                    prop = properties[0];
                }
            }
        }
        return prop;
    }

    public Enumeration getProperties(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Property name cannot be null");
        }

        Set v = new HashSet();

        Enumeration props = this.getHttpServletRequest().getHeaders(name);
        if (props != null) {
            while (props.hasMoreElements()) {
                v.add(props.nextElement());
            }
        }

        // get properties from PropertyManager
        Map map = container.getContainerServices()
                .getPortalCallbackService()
                .getRequestProperties(getHttpServletRequest(), internalPortletWindow);

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
        Map map = container.getContainerServices()
                .getPortalCallbackService()
                .getRequestProperties(getHttpServletRequest(), internalPortletWindow);

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

    public Principal getUserPrincipal() {
        return this.getHttpServletRequest().getUserPrincipal();
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
    public boolean isUserInRole(String roleName) {
        PortletEntity entity = internalPortletWindow.getPortletEntity();
        PortletDD def = entity.getPortletDefinition();

        SecurityRoleRefDD ref = null;
        Iterator refs = def.getSecurityRoleRefs().iterator();
        while (refs.hasNext()) {
            SecurityRoleRefDD r = (SecurityRoleRefDD) refs.next();
            if (r.getRoleName().equals(roleName)) {
                ref = r;
                break;
            }
        }

        String link;
        if (ref != null && ref.getRoleLink() != null) {
            link = ref.getRoleLink();
        } else {
            link = roleName;
        }

        return this.getHttpServletRequest().isUserInRole(link);
    }

    public Object getAttribute(String name) {
        if (name == null) {
            throw new IllegalArgumentException(
                    EXCEPTIONS.getString("error.attributeName.null")
            );
        }

        String encodedName = isNameReserved(name) ?
                name :
                mapper.encode(internalPortletWindow.getId(), name);

        Object attribute = getHttpServletRequest()
                .getAttribute(encodedName);

        if (attribute == null) {
            attribute = getHttpServletRequest().getAttribute(name);
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

    public Enumeration getParameterNames() {
        bodyAccessed = true;

        Map parameters = this.getHttpServletRequest().getParameterMap();
        return Collections.enumeration(parameters.keySet());
    }

    public String[] getParameterValues(String name) {
        if (name == null) {
            throw new IllegalArgumentException(
                EXCEPTIONS.getString("error.null", "Parameter Name ")
            );
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
        return StringUtils.copyParameters(
                this.getHttpServletRequest().getParameterMap());
    }

    public boolean isSecure() {
        return this.getHttpServletRequest().isSecure();
    }

    public void setAttribute(String name, Object value) {
        if (name == null) {
            throw new IllegalArgumentException(
                    EXCEPTIONS.getString("error.null", "Attribute Name ")
            );
        }

        String encodedName = isNameReserved(name) ?
                name : mapper.encode(internalPortletWindow.getId(), name);

        if (value == null) {
            removeAttribute(name);
        } else {
            getHttpServletRequest().setAttribute(encodedName, value);
        }
    }

    public void removeAttribute(String name) {
        if (name == null) {
            throw new IllegalArgumentException(
                EXCEPTIONS.getString("error.null", "Attribute Name ")
            );
        }

        String encodedName = isNameReserved(name) ?
                name : mapper.encode(internalPortletWindow.getId(), name);

        getHttpServletRequest().removeAttribute(encodedName);
    }

    public String getRequestedSessionId() {
        return this.getHttpServletRequest().getRequestedSessionId();
    }

    public boolean isRequestedSessionIdValid() {
        return getHttpServletRequest().isRequestedSessionIdValid();
    }

    public String getResponseContentType() {
        Enumeration enumeration = getResponseContentTypes();
        while (enumeration.hasMoreElements()) {
            return (String) enumeration.nextElement();
        }
        return "text/html";
    }

    public Enumeration getResponseContentTypes() {
        if (contentTypes == null) {
            contentTypes = new Vector();
            PortletDD dd = internalPortletWindow.getPortletEntity().getPortletDefinition();
            Iterator supports = dd.getSupports().iterator();
            while (supports.hasNext()) {
                SupportsDD sup = (SupportsDD) supports.next();
                contentTypes.add(sup.getMimeType());
            }
            if (contentTypes.size() < 1) {
                contentTypes.add("text/html");
            }
        }
        return contentTypes.elements();
    }

    public Locale getLocale() {
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

    public PortletContainer getPortletContainer() {
        return this.container;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }

    public boolean isIncluded() {
        return included;
    }
    // --------------------------------------------------------------------------------------------

    // internal methods ---------------------------------------------------------------------------
    public HttpServletRequest getHttpServletRequest() {
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
            throws UnsupportedEncodingException, java.io.IOException {
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
            throws UnsupportedEncodingException {
        if (bodyAccessed) {
            throw new IllegalStateException(
                    "This method must not be called after the HTTP-Body was accessed !");
        }

        getHttpServletRequest().setCharacterEncoding(env);
    }

    public ServletInputStream getInputStream()
    throws IOException {
        if (included) {
            return null;
        } else {
            ServletInputStream stream = getHttpServletRequest().getInputStream();
            bodyAccessed = true;
            return stream;
        }
    }

    public RequestDispatcher getRequestDispatcher(String path) {
        return this.getHttpServletRequest().getRequestDispatcher(path);
    }

// Internal Implementation Detailes

    public void init(PortletContext portletContext, HttpServletRequest req) {
        this.portletContext = portletContext;
        setRequest(req);
    }

    /**
     * @todo Implement this properly.  Not required now
     */
    public void release() {

    }

    public PortletContainer getContainer() {
        return container;
    }

    public InternalPortletWindow getWindow() {
        return internalPortletWindow;
    }

    private boolean isPortletModeAllowedByPortlet(PortletMode mode) {
        if(isPortletModeMandatory(mode)) {
            return true;
        }

        PortletDD dd = internalPortletWindow.getPortletEntity()
                .getPortletDefinition();

        Iterator mimes = dd.getSupports().iterator();
        while (mimes.hasNext()) {
            Iterator modes = ((SupportsDD) mimes.next()).getPortletModes().iterator();
            while (modes.hasNext()) {
                String m = (String) modes.next();
                if (m.equals(mode.toString())) {
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

    private boolean isPortletModeMandatory(PortletMode mode) {
        return PortletMode.VIEW.equals(mode) || PortletMode.EDIT.equals(mode) || PortletMode.HELP.equals(mode);
    }


}
