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
package org.apache.pluto.internal.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.ccpp.Profile;
import javax.portlet.PortalContext;
import javax.portlet.PortletContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.WindowState;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.OptionalContainerServices;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletEntity;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.internal.InternalPortletRequest;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.portlet.SecurityRoleRef;
import org.apache.pluto.om.portlet.Supports;
import org.apache.pluto.spi.PortletURLProvider;
import org.apache.pluto.spi.optional.RequestAttributeService;
import org.apache.pluto.util.ArgumentUtility;
import org.apache.pluto.util.Enumerator;
import org.apache.pluto.util.StringManager;
import org.apache.pluto.util.StringUtils;


/**
 * Abstract <code>javax.portlet.PortletRequest</code> implementation.
 * This class also implements InternalPortletRequest.
 *
 */
public abstract class PortletRequestImpl extends HttpServletRequestWrapper
implements PortletRequest, InternalPortletRequest {
	

	/** Logger. */
    private static final Log LOG = LogFactory.getLog(PortletRequestImpl.class);
    
    private static final StringManager EXCEPTIONS =
            StringManager.getManager(PortletRequestImpl.class.getPackage().getName());
    
    
    // Private Member Variables ------------------------------------------------
    
    /** The parent container within which this request was created. */
    protected PortletContainer container;
    
    /** The portlet window which is the target of this portlet request. */
    protected PortletWindow portletWindow;

    /**
     * The PortletContext associated with this Request. This PortletContext must
     * be initialized from within the <code>PortletServlet</code>.
     */
    private PortletContext portletContext;

    /** The PortalContext within which this request is occuring. */
    private PortalContext portalContext;

    /** The portlet session. */
    private PortletSession portletSession;

    /** Response content types. */
    private Vector contentTypes;
    
    /** FIXME: do we really need this?
     * Flag indicating if the HTTP-Body has been accessed. */
    private boolean bodyAccessed = false;

    /** True if we are in an include call. */
    private boolean included = false;
    
    /** True if we are in an forwarded call. */
    private boolean forwarded = false;
    
    private boolean namedRequestDispatcher;
    
    /** The corresponding servlet request. */
    private HttpServletRequest servletRequest = null;
    
    /** The parameters including parameters appended to the dispatching URI. */
    private Map parameters;
    
    /**
     * 
     */
    PortletPreferencesImpl portletPreferences;

    // Constructors ------------------------------------------------------------

    public PortletRequestImpl(InternalPortletRequest internalPortletRequest) {
        this(internalPortletRequest.getPortletContainer(),
             internalPortletRequest.getPortletWindow(),
             internalPortletRequest.getHttpServletRequest());
    }

    /**
     * Creates a PortletRequestImpl instance.
     * @param container  the portlet container.
     * @param portletWindow  the internal portlet window.
     * @param servletRequest  the underlying servlet request.
     */
    public PortletRequestImpl(PortletContainer container,
                              PortletWindow portletWindow,
                              HttpServletRequest servletRequest) {
        super(servletRequest);
        this.container = container;
        this.portletWindow = portletWindow;
        this.portalContext = container.getRequiredContainerServices().getPortalContext();
        this.servletRequest = servletRequest;
    }
    
    
    // PortletRequest Impl -----------------------------------------------------

    /* (non-Javadoc)
	 * @see javax.portlet.PortletRequest#getWindowId()
	 */
	public String getWindowId() {
		return portletWindow.getId().getStringId();
	}
    
    /**
     * Determine whether or not the specified WindowState is allowed for this
     * portlet.
     *
     * @param state the state in question
     * @return true if the state is allowed.
     */
    public boolean isWindowStateAllowed(WindowState state) {
    	for (Enumeration en = portalContext.getSupportedWindowStates();
    			en.hasMoreElements(); ) {
            if (en.nextElement().toString().equalsIgnoreCase(state.toString())) {
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
        return portletWindow.getPortletMode();
    }
    
    public WindowState getWindowState() {
        return portletWindow.getWindowState();
    }
    
    public PortletSession getPortletSession() {
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
    public PortletSession getPortletSession(boolean create) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Retreiving portlet session (create=" + create + ")");
        }
        //
        // It is critical that we don't retrieve the portlet session until the
        //   cross context dispatch has been completed.  If we do then we risk
        //   having a cached version which is invalid for the context within
        //   which it exists.
        //
        if (portletContext == null) {
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
        HttpSession httpSession = getHttpServletRequest().getSession(create);
        if (httpSession != null) {
        	// HttpSession is not null does NOT mean that it is valid.
            int maxInactiveInterval = httpSession.getMaxInactiveInterval();
            long lastAccesstime = httpSession.getLastAccessedTime();//lastAccesstime checks added for PLUTO-436
            if (maxInactiveInterval >= 0 && lastAccesstime > 0) {    // < 0 => Never expires.
                long maxInactiveTime = httpSession.getMaxInactiveInterval() * 1000L;
                long currentInactiveTime = System.currentTimeMillis() - lastAccesstime;
                if (currentInactiveTime > maxInactiveTime) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("The underlying HttpSession is expired and "
                            + "should be invalidated.");
                    }
                    httpSession.invalidate();
                    httpSession = getHttpServletRequest().getSession(create);
                    //Added for PLUTO-436
                    // a cached portletSession is no longer useable.
                    // a new one will be created below.
                    portletSession = null;
                }
            }
        }
        if (httpSession == null) {
            if (LOG.isDebugEnabled()) {
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
        if (portletSession == null) {
        	if (LOG.isDebugEnabled()) {
        		LOG.debug("Creating new portlet session...");
        	}
            portletSession = new PortletSessionImpl(
                    portletContext,
                    portletWindow,
                    httpSession);
        }
        //for RequestDispatcher
        if (isForwarded() || isIncluded())
        	((PortletSessionImpl)portletSession).setIncludeOrForward(true);
        else
        	((PortletSessionImpl)portletSession).setIncludeOrForward(false);
        
        return portletSession;
    }
    
    public String getProperty(String name){
    	ArgumentUtility.validateNotNull("propertyName", name);
        String property = this.getHttpServletRequest().getHeader(name);
        if (property == null) {
            Map propertyMap = container.getRequiredContainerServices()
                    .getPortalCallbackService()
                    .getRequestProperties(
                    		getHttpServletRequest(),
                    		portletWindow);

            if (propertyMap != null) {
                String[] properties = (String[]) propertyMap.get(name);
                if (properties != null && properties.length > 0) {
                	property = properties[0];
                }
            }
        }
        return property;
    }

    public Enumeration getProperties(String name) {
    	ArgumentUtility.validateNotNull("propertyName", name);
        Set v = new HashSet();
        Enumeration props = this.getHttpServletRequest().getHeaders(name);
        if (props != null) {
            while (props.hasMoreElements()) {
                v.add(props.nextElement());
            }
        }

        // get properties from PropertyManager
        Map map = container.getRequiredContainerServices()
                .getPortalCallbackService()
                .getRequestProperties(
                		getHttpServletRequest(),
                		portletWindow);

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
        Map map = container.getRequiredContainerServices()
                .getPortalCallbackService()
                .getRequestProperties(getHttpServletRequest(), portletWindow);

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
        return container.getRequiredContainerServices().getPortalContext();
    }

    public String getAuthType() {
        return this.getHttpServletRequest().getAuthType();
    }

    public String getContextPath() {
        String name = portletWindow.getPortletEntity().getPortletDefinition().getApplication().getName();
        if (!name.equals("")) {
            name = "/" + name;
        }
        return name;
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
        PortletEntity entity = portletWindow.getPortletEntity();
        PortletDefinition def = entity.getPortletDefinition();

        SecurityRoleRef ref = null;
        Iterator refs = def.getSecurityRoleRefs().iterator();
        while (refs.hasNext()) {
            SecurityRoleRef r = (SecurityRoleRef) refs.next();
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
    	ArgumentUtility.validateNotNull("attributeName", name);

        final OptionalContainerServices optionalContainerServices = container.getOptionalContainerServices();
        final RequestAttributeService requestAttributeService = optionalContainerServices.getRequestAttributeService();
        return requestAttributeService.getAttribute(this, this.getHttpServletRequest(), this.portletWindow, name);
    }

    public Enumeration getAttributeNames() {
        final OptionalContainerServices optionalContainerServices = container.getOptionalContainerServices();
        final RequestAttributeService requestAttributeService = optionalContainerServices.getRequestAttributeService();
        return requestAttributeService.getAttributeNames(this, this.getHttpServletRequest(), this.portletWindow);
    }
    
    public String getParameter(String name) {
    	ArgumentUtility.validateNotNull("parameterName", name);
    	List<String> publicRenderParameterNames = portletWindow.getPortletEntity().getPortletDefinition().getSupportedPublicRenderParameters();
    	PortletURLProvider urlProvider = container.getRequiredContainerServices().getPortalCallbackService().getPortletURLProvider(getHttpServletRequest(), portletWindow);
    	String[] values = null;
    	if (publicRenderParameterNames != null){
    		if (publicRenderParameterNames.contains(name))
    			values = urlProvider.getPublicRenderParameters(name);
    		else
    			values = (String[]) baseGetParameterMap().get(name);
    	}
    	else{
    			values = (String[]) baseGetParameterMap().get(name);
    	}
        if (values != null && values.length > 0) {
            return values[0];
        } else {
        	return null;
        }
    }

    public Enumeration getParameterNames() {
        return Collections.enumeration(baseGetParameterMap().keySet());
    }

    public String[] getParameterValues(String name) {
    	ArgumentUtility.validateNotNull("parameterName", name);
    	List<String> publicRenderParameterNames = portletWindow.getPortletEntity().getPortletDefinition().getSupportedPublicRenderParameters();
    	PortletURLProvider urlProvider = container.getRequiredContainerServices()
    											  .getPortalCallbackService()
    											  .getPortletURLProvider(getHttpServletRequest(), portletWindow);
    	
    	String[] values = null;
    	if (publicRenderParameterNames != null){
    		if (publicRenderParameterNames.contains(name))
    			values = urlProvider.getPublicRenderParameters(name);
    		else
    			values = (String[]) baseGetParameterMap().get(name);
    	}
    	else{
    			values = (String[]) baseGetParameterMap().get(name);
    	}
    	
        if (values != null) {
            values = StringUtils.copy(values);
        }
        return values;
    }
    
    public Map getParameterMap() {
    	Map<String, String[]>map = StringUtils.copyParameters(baseGetParameterMap());
    	List<String> publicRenderParameterNames = portletWindow.getPortletEntity().getPortletDefinition().getSupportedPublicRenderParameters();
    	if (publicRenderParameterNames!=null){
    		PortletURLProvider urlProvider = container
    			.getRequiredContainerServices()
    			.getPortalCallbackService()
    			.getPortletURLProvider(getHttpServletRequest(), portletWindow);
    		String[] values = null;
    		for (String string : publicRenderParameterNames) {
    			values = urlProvider.getPublicRenderParameters(string);
    			if (values != null){
    				map.put(string, values);
    			}
			}
    	}
    	return Collections.unmodifiableMap(map);
    }

    public boolean isSecure() {
        return this.getHttpServletRequest().isSecure();
    }

    public void setAttribute(String name, Object value) {
        final OptionalContainerServices optionalContainerServices = container.getOptionalContainerServices();
        final RequestAttributeService requestAttributeService = optionalContainerServices.getRequestAttributeService();
        requestAttributeService.setAttribute(this, this.getHttpServletRequest(), this.portletWindow, name, value);
    }

    public void removeAttribute(String name) {
    	ArgumentUtility.validateNotNull("attributeName", name);
    	
        final OptionalContainerServices optionalContainerServices = container.getOptionalContainerServices();
        final RequestAttributeService requestAttributeService = optionalContainerServices.getRequestAttributeService();
        requestAttributeService.removeAttribute(this, this.getHttpServletRequest(), this.portletWindow, name);
    }

    public String getRequestedSessionId() {
        return this.getHttpServletRequest().getRequestedSessionId();
    }

    public boolean isRequestedSessionIdValid() {
        if (LOG.isDebugEnabled()) {
            LOG.debug(" ***** IsRequestedSessionIdValid? "+getHttpServletRequest().isRequestedSessionIdValid());
        }
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
            PortletDefinition dd = portletWindow.getPortletEntity().getPortletDefinition();
            Iterator supports = dd.getSupports().iterator();
            while (supports.hasNext()) {
                Supports sup = (Supports) supports.next();
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
    
    
    // Protected Methods -------------------------------------------------------
    
    /**
     * The base method that returns the parameter map in this portlet request.
     * All parameter-related methods call this base method. Subclasses may just
     * overwrite this protected method to change behavior of all parameter-
     * related methods.
     * @return the base parameter map from which parameters are retrieved.
     */
    protected Map baseGetParameterMap() {
    	if (isIncluded() && parameters != null) {
    		setBodyAccessed();
    		return parameters;
    	} else {
    		return this.getHttpServletRequest().getParameterMap();
    	}
//        bodyAccessed = true;
//        return this.getHttpServletRequest().getParameterMap();
    }

    protected void setBodyAccessed() {
    	bodyAccessed = true;
    }
    
    
    // InternalPortletRequest Impl ---------------------------------------------

    public PortletWindow getPortletWindow() {
        return portletWindow;
    }

    public PortletContainer getPortletContainer() {
        return container;
    }

    public HttpServletRequest getHttpServletRequest() {
        return (HttpServletRequest) super.getRequest();
    }
    
    public void init(PortletContext portletContext, HttpServletRequest req) {
        this.portletContext = portletContext;
        setRequest(req);
        setCCPPProfile();
        setLifecyclePhase();
    }

	/**
     * TODO: Implement this properly.  Not required now
     */
    public void release() {
    	// FIXME: This needs to be implemented
    }
    
    
    // TODO: Additional Methods of HttpServletRequestWrapper -------------------
    
    public BufferedReader getReader()
    throws UnsupportedEncodingException, IOException {
    	// the super class will ensure that a IllegalStateException is thrown
    	//   if getInputStream() was called earlier
    	BufferedReader reader = getHttpServletRequest().getReader();
    	bodyAccessed = true;
    	return reader;
    }
    
    public ServletInputStream getInputStream() throws IOException {
    	ServletInputStream stream = getHttpServletRequest().getInputStream();
    	bodyAccessed = true;
    	return stream;
    }

    public RequestDispatcher getRequestDispatcher(String path) {
    	
        return new ServletRequestDispatcher(getHttpServletRequest().getRequestDispatcher(path));
    }
    
    /**
     * TODO: why check bodyAccessed?
     */
    public void setCharacterEncoding(String encoding)
    throws UnsupportedEncodingException {
        if (bodyAccessed) {
        	throw new IllegalStateException("Cannot set character encoding "
        			+ "after HTTP body is accessed.");
        }
        super.setCharacterEncoding(encoding);
    }
    
    // Private Methods ---------------------------------------------------------
    
    private boolean isPortletModeAllowedByPortlet(PortletMode mode) {
        if (isPortletModeMandatory(mode)) {
            return true;
        }

        PortletDefinition dd = portletWindow.getPortletEntity()
                .getPortletDefinition();

        Iterator mimes = dd.getSupports().iterator();
        while (mimes.hasNext()) {
            Iterator modes = ((Supports) mimes.next()).getPortletModes().iterator();
            while (modes.hasNext()) {
                String m = (String) modes.next();
                if (m.equalsIgnoreCase(mode.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPortletModeAllowedByPortal(PortletMode mode) {
        Enumeration supportedModes = portalContext.getSupportedPortletModes();
        while (supportedModes.hasMoreElements()) {
            if (supportedModes.nextElement().toString().equalsIgnoreCase(
                    (mode.toString()))) {
                return true;
            }
        }
        return false;
    }

    private boolean isPortletModeMandatory(PortletMode mode) {
        return PortletMode.VIEW.equals(mode) || PortletMode.EDIT.equals(mode) || PortletMode.HELP.equals(mode);
    }


// InternalRenderRequest Impl ----------------------------------------------
    
    public boolean isForwarded() {
		return forwarded;
	}

	public void setForwarded(boolean forwarded) {
		this.forwarded = forwarded;
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Portlet request's forwarded mode: " + forwarded);
        }
	}

	public void setForwardedQueryString(String queryString) {
		if (!forwarded) {
    		throw new IllegalStateException("Parameters cannot be appended to "
    				+ "render request which is not included in a dispatch.");
    	}
    	if (queryString != null && queryString.trim().length() > 0) {
    		// Copy all the original render parameters.
    		parameters = new HashMap(super.getParameterMap());
    		// Merge the appended parameters to the render parameter map.
    		// The original render parameters should not be overwritten.
    		mergeQueryString(parameters, queryString);
    		// Log the new render parameter map.
    		if (LOG.isDebugEnabled()) {
    			LOG.debug("Merged parameters: ");
    		}
    	} else {
    		if (LOG.isDebugEnabled()) {
    			LOG.debug("No query string appended to the included request.");
    		}
    	}
		
	}
    
    public void setIncluded(boolean included) {
    	this.included = included;
        if (!included) {
        	this.parameters = null;
        }
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Render request's included mode: " + included);
        }
    }

    public boolean isIncluded() {
        return included;
    }
    
    public void setIncludedQueryString(String queryString)
    throws IllegalStateException {
    	if (!included) {
    		throw new IllegalStateException("Parameters cannot be appended to "
    				+ "render request which is not included in a dispatch.");
    	}
    	if (queryString != null && queryString.trim().length() > 0) {
    		// Copy all the original render parameters.
    		parameters = new HashMap(super.getParameterMap());
    		// Merge the appended parameters to the render parameter map.
    		// The original render parameters should not be overwritten.
    		mergeQueryString(parameters, queryString);
    		// Log the new render parameter map.
    		if (LOG.isDebugEnabled()) {
    			LOG.debug("Merged parameters: ");
    		}
    	} else {
    		if (LOG.isDebugEnabled()) {
    			LOG.debug("No query string appended to the included request.");
    		}
    	}
    }
    
    /**
     * Parses the appended query string and merges the appended parameters to
     * the original parameters. Query parameters are name-value pairs separated
     * by the '<code>&amp;</code>' character.
     * @param parameters  the original parameters map.
     * @param queryString  the appended query string.
     */
    private void mergeQueryString(Map parameters, String queryString) {
    	
    	// Create the appended parameters map:
    	//   key is the parameter name as a string,
    	//   value is a List of parameter values (List of String).
        Map appendedParameters = new HashMap();
        
        // Parse the appended query string.
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("Parsing appended query string: " + queryString);
    	}
        StringTokenizer st = new StringTokenizer(queryString, "&", false);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            int equalIndex = token.indexOf("=");
            if (equalIndex > 0) {
                String key = token.substring(0, equalIndex);
                String value = null;
                if (equalIndex < token.length() - 1) {
                	value = token.substring(equalIndex + 1);
                } else {                	value = "";
                }
                List values = (List) appendedParameters.get(key);
                if (values == null) {
                	values = new ArrayList();
                }
                values.add(value);
                appendedParameters.put(key, values);
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug(appendedParameters.size() + " parameters appended.");
        }
        
        // Merge the appended parameters and the original parameters.
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Merging appended parameters and original parameters...");
        }
    	for (Iterator it = appendedParameters.keySet().iterator();
    			it.hasNext(); ) {
    		String key = (String) it.next();
    		List values = (List) appendedParameters.get(key);
    		// If the parameter name (key) exists, merge parameter values.
    		if (parameters.containsKey(key)) {
    			String[] originalValues = (String[]) parameters.get(key);
    			if (originalValues != null) {
    				for (int i = 0; i < originalValues.length; i++) {
    					values.add(originalValues[i]);
    				}
    			}
    		}
    		parameters.put(key, values.toArray(new String[values.size()]));
    	}
    }

	public PortletPreferences getPreferences() {
		if (portletPreferences == null) {
            portletPreferences = new PortletPreferencesImpl(
            		getPortletContainer(),
            		getPortletWindow(),
            		this,
            		Constants.METHOD_ACTION);
        }
        return portletPreferences;
	}

	public Map<String, String[]> getPrivateParameterMap() {
		return Collections.unmodifiableMap(StringUtils.copyParameters(baseGetParameterMap()));
	}

	public Map<String, String[]> getPublicParameterMap() {
		Map<String, String[]>map = new HashMap<String, String[]>();
		PortletURLProvider urlProvider = container
			.getRequiredContainerServices()
			.getPortalCallbackService()
			.getPortletURLProvider(getHttpServletRequest(), portletWindow);
		List<String> publicRenderParameterNames = portletWindow.getPortletEntity().getPortletDefinition().getSupportedPublicRenderParameters();
		String[] values = null;
		if (publicRenderParameterNames != null){
			for (String string : publicRenderParameterNames) {
				values = urlProvider.getPublicRenderParameters(string);
				if (values != null){
					map.put(string, values);
				}
			}
		}
		return Collections.unmodifiableMap(map);
	}
	
	public String getWindowID() {
		return portletWindow.getId().getStringId();
	}
	
	private void setLifecyclePhase() {
		String lifecyclePhase = getLifecyclePhase();
		this.setAttribute(LIFECYCLE_PHASE, lifecyclePhase);
	}
	
	@Override
	public String getLocalAddr() {
		return (isIncluded() || isForwarded()) ? null : super.getLocalAddr();
	}
	

	@Override
	public String getLocalName() {
		return (isIncluded() || isForwarded()) ? null : super.getLocalName();
	}

	@Override
	public int getLocalPort() {
		return (isIncluded() || isForwarded()) ? 0 : super.getLocalPort();
	}
	
	public String getProtocol() {
        return (isIncluded() || isForwarded()) ? "HTTP/1.1" : super.getProtocol();
    }

	@Override
	public String getRealPath(String arg0) {
		return (isIncluded() || isForwarded()) ? null : super.getRealPath(arg0);
	}

	@Override
	public String getRemoteAddr() {
		return (isIncluded() || isForwarded()) ? null : super.getRemoteAddr();
	}

	@Override
	public String getRemoteHost() {
		return (isIncluded() || isForwarded()) ? null : super.getRemoteHost();
	}

	@Override
	public int getRemotePort() {
		return (isIncluded() || isForwarded()) ? 0 : super.getRemotePort();
	}
	
	@Override
	public Cookie[] getCookies() {
		if (isIncluded() || isForwarded()){
			// TODO:return Cookies from properties
			return super.getCookies();
		}
		else
			return super.getCookies();
	}

	@Override
	public long getDateHeader(String arg0) {
		if (isIncluded() || isForwarded()){
			// TODO:return header from properties
			return 0;
		}
		else
			return super.getDateHeader(arg0);
	}

	@Override
	public String getHeader(String arg0) {
		if (isIncluded() || isForwarded()){
			// TODO:return header from properties
			return null;
		}
		else
			return super.getHeader(arg0);
	}

	@Override
	public Enumeration getHeaderNames() {
		if (isIncluded() || isForwarded()){
			// TODO:return header from properties
			return null;
		}
		else
			return super.getHeaderNames();
	}

	@Override
	public Enumeration getHeaders(String arg0) {
		if (isIncluded() || isForwarded()){
			// TODO:return header from properties
			return null;
		}
		else
			return super.getHeaders(arg0);
	}

	@Override
	public int getIntHeader(String arg0) {
		if (isIncluded() || isForwarded()){
			// TODO:return header from properties
			return 0;
		}
		else
			return super.getIntHeader(arg0);
	}
	
	public String getPathInfo() {
    	if (isIncluded())
    		return (String) super.getAttribute("javax.servlet.include.path_info");
    	else if (isForwarded())
    		return (String) super.getAttribute("javax.servlet.forward.path_info");
    	else
    		return super.getPathInfo();
    }

    public String getQueryString() {
    	if (isIncluded())
    		return (String) super.getAttribute("javax.servlet.include.query_string");
    	else if (isForwarded())
    		return (String) super.getAttribute("javax.servlet.forward.query_string");
    	else
	    	return super.getQueryString();
    }
    
    
    public String getPathTranslated() {
    	if (isIncluded() || isForwarded()){
    		String path = getServletPath() + getPathInfo() + "?" + getQueryString();
    		return getRealPath(path);
    	}
    	return super.getPathTranslated();
    }
    
    public String getRequestURI() {
    	if (isIncluded())
    		return (String) super.getAttribute("javax.servlet.include.request_uri");
    	else if (isForwarded())
    		return (String) super.getAttribute("javax.servlet.forward.request_uri");
    	else
    		return super.getRequestURI();
    }
    
    public String getServletPath() {
    	if (isIncluded())
    		return (String) super.getAttribute("javax.servlet.include.servlet_path");
    	else if (isForwarded())
    		return (String) super.getAttribute("javax.servlet.forward.servlet_path");
    	else
    		return super.getServletPath();
    }
    
    public StringBuffer getRequestURL() {
        return (isIncluded() || isForwarded()) ? null : super.getRequestURL();
    }
    
    @Override
	public HttpSession getSession() {
		if (isIncluded() || isForwarded()){
			PortletSession session = getPortletSession();
			return (HttpSession)session;
		}
		return super.getSession();
	}
    
    @Override
	public HttpSession getSession(boolean arg0) {
		if (isIncluded() || isForwarded()){
			PortletSession session = getPortletSession(arg0); 
			return (HttpSession)session;
		}
		return super.getSession();
	}
	
	// ============= private methods ==================

	public String getLifecyclePhase() {
		return null;
	}

	private void setCCPPProfile() {
		Profile profile = container.getRequiredContainerServices().getCCPPProfileService().getCCPPProfile(servletRequest);
		this.setAttribute(CCPP_PROFILE, profile);
	}
	
	public void setNamedRequestDispatcher(boolean named){
		namedRequestDispatcher = named;
	}
}

class ServletRequestDispatcher implements RequestDispatcher {
	javax.servlet.RequestDispatcher dispatcher;
	public ServletRequestDispatcher(javax.servlet.RequestDispatcher dispatcher){
		this.dispatcher = dispatcher;
	}
	
	public void forward(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		dispatcher.include(arg0, arg1);
		
	}

	public void include(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		dispatcher.include(arg0, arg1);
	}
}
