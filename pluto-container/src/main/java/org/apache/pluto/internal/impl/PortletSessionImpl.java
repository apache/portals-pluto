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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.portlet.PortletContext;
import javax.portlet.PortletSession;
import javax.portlet.PortletSessionUtil;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.util.ArgumentUtility;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Implementation of the <code>javax.portlet.PortletSession</code> interface.
 * 
 */
public class PortletSessionImpl implements PortletSession, HttpSession {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(PortletSessionImpl.class);
    
    /** The default scope (<code>PORTLET_SCOPE</code>) for storing objects. */
    private static final int DEFAULT_SCOPE = PortletSession.PORTLET_SCOPE;
    
    /** The portlet scope namespace as defined in PLT. 15.3. */
    private static final String PORTLET_SCOPE_NAMESPACE = "javax.portlet.p.";
    
    /** The portlet window ID / attribute name separator as defined in PLT. 15.3. */
    private static final char ID_NAME_SEPARATOR = '?';

    
    // Private Member Variables ------------------------------------------------
    
    /** The wrapped HttpSession object. */
    private HttpSession httpSession;
    
    /** The portlet context. */
    private PortletContext portletContext;
    
    /** The internal portlet window. */
    private InternalPortletWindow internalPortletWindow;
    
    //
    private boolean isIncludeOrForward = false;
    
    // Constructor -------------------------------------------------------------
    
    /**
     * Constructs an instance.
     */
    public PortletSessionImpl(PortletContext portletContext,
                              InternalPortletWindow internalPortletWindow,
                              HttpSession httpSession) {
        this.portletContext = portletContext;
        this.internalPortletWindow = internalPortletWindow;
        this.httpSession = httpSession;
    }
    
    
    // PortletSession Impl: Attributes -----------------------------------------
    
    public Object getAttribute(String name) {
    	if (isIncludeOrForward)
    		return getAttribute(name, APPLICATION_SCOPE);
        return getAttribute(name, DEFAULT_SCOPE);
    }
    
    /**
     * Returns the attribute of the specified name under the given scope.
     * 
     * @param name  the attribute name.
     * @param scope  the scope under which the attribute object is stored.
     * @return the attribute object.
     */
    public Object getAttribute(String name, int scope) {
    	ArgumentUtility.validateNotNull("attributeName", name);
    	String key = (scope == PortletSession.APPLICATION_SCOPE)
    			? name : createPortletScopedId(name);
    	return httpSession.getAttribute(key);
    }
    
    public Enumeration getAttributeNames() {
    	if (isIncludeOrForward)
    		return getAttributeNames(APPLICATION_SCOPE);
        return getAttributeNames(DEFAULT_SCOPE);
    }
    
    public Enumeration<String> getAttributeNames(int scope) {
    	// Return all attribute names in the nested HttpSession object.
        if (scope == PortletSession.APPLICATION_SCOPE) {
            return httpSession.getAttributeNames();
        }
        // Return attribute names with the portlet-scoped prefix.
        Vector<String> portletScopedNames = new Vector<String>();
        for (Enumeration<String> en = httpSession.getAttributeNames();
        en.hasMoreElements(); ) {
        	String name = en.nextElement();
        	if (isInCurrentPortletScope(name)) {
        		portletScopedNames.add(
        				PortletSessionUtil.decodeAttributeName(name));
        	}
        }
        return portletScopedNames.elements();
        
    }
    
    public void removeAttribute(String name) {
    	if(isIncludeOrForward)
    		removeAttribute(name, APPLICATION_SCOPE);
    	else
    		removeAttribute(name, DEFAULT_SCOPE);
    }

    public void removeAttribute(String name, int scope) {
    	ArgumentUtility.validateNotNull("attributeName", name);
    	if (scope == PortletSession.APPLICATION_SCOPE) {
    		httpSession.removeAttribute(name);
    	} else {
    		httpSession.removeAttribute(createPortletScopedId(name));
    	}
    }
    
    public void setAttribute(String name, Object value) {
    	if (isIncludeOrForward)
    		setAttribute(name, value, PortletSession.APPLICATION_SCOPE);
    	else
    		setAttribute(name, value, DEFAULT_SCOPE);
    }

    public void setAttribute(String name, Object value, int scope) {
    	ArgumentUtility.validateNotNull("attributeName", name);
    	if (scope == PortletSession.APPLICATION_SCOPE) {
    		httpSession.setAttribute(name, value);
    	} else {
    		httpSession.setAttribute(createPortletScopedId(name),  value);
    	}
    }

    
    // PortletSession Impl: Other Methods --------------------------------------
    
    public PortletContext getPortletContext() {
        return portletContext;
    }

    public long getCreationTime() {
        return httpSession.getCreationTime();
    }

    public String getId() {
        return httpSession.getId();
    }

    public long getLastAccessedTime() {
        return httpSession.getLastAccessedTime();
    }

    public int getMaxInactiveInterval() {
        return httpSession.getMaxInactiveInterval();
    }

    public void invalidate() throws IllegalStateException {
        httpSession.invalidate();
    }

    public boolean isNew() throws IllegalStateException {
        return httpSession.isNew();
    }
    
    /**
     * Specifies the time, in seconds, between client requests, before the
     * portlet container invalidates this session. A negative time indicates
     * the session should never timeout.
     * <p>
     * [Portlet Spec. PLT. 15.4.] If the PortletSession object is invalidated
     * by a portlet, the portlet container must invalidate the associated
     * HttpSession object.
     * </p>
     * @param interval  an integer specifying the number of seconds.
     */ 
    public void setMaxInactiveInterval(int interval) {
        httpSession.setMaxInactiveInterval(interval);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Session timeout set to: " + interval);
        }
    }
    
    
    // Private Methods ---------------------------------------------------------
    
    /**
     * Creates portlet-scoped ID for the specified attribute name.
     * Portlet-scoped ID for a given attribute name has the following form:
     * <code>javax.portlet.p.&lt;ID&gt;?&lt;name&gt;</code>
     * where <code>ID</code> is a unique identification for the portlet window
     * (assigned by the portal/portlet-container) that must not contain a '?'
     * character. <code>name</code> is the attribute name.
     * <p>
     * Refer to Portlet Specification PLT. 15.3 for more details.
     * </p>
     * @param name  the attribute name.
     * @return portlet-scoped ID for the attribute name.
     */
    private String createPortletScopedId(String name) {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append(PORTLET_SCOPE_NAMESPACE);
    	buffer.append(internalPortletWindow.getId().getStringId());
    	buffer.append(ID_NAME_SEPARATOR);
    	buffer.append(name);
    	return buffer.toString();
    }
    
    /**
     * Checks if the attribute name in APPLICATION_SCOPE is in the current
     * portlet scope. 
     * @param name  the attribute name to check.
     * @return true if the attribute name is in the current portlet scope.
     * @see #createPortletScopedId(String)
     */
    private boolean isInCurrentPortletScope(String name) {
    	// Portlet-scoped attribute names MUST start with "javax.portlet.p.",
    	//   and contain the ID-name separator '?'.
    	if (name.startsWith(PORTLET_SCOPE_NAMESPACE)
    			&& name.indexOf(ID_NAME_SEPARATOR) > -1) {
        	String id = name.substring(PORTLET_SCOPE_NAMESPACE.length(),
        	                           name.indexOf(ID_NAME_SEPARATOR));
        	return (id.equals(internalPortletWindow.getId().getStringId()));
        }
    	// Application-scoped attribute names are not in portlet scope.
    	else {
        	return false;
        }
    }
    
    
    // HttpSession Impl --------------------------------------------------------
    
    public ServletContext getServletContext() {
        return httpSession.getServletContext();
    }

    /**
     * DEPRECATED: implemented for backwards compatability with HttpSession.
     * @deprecated
     */
    public HttpSessionContext getSessionContext() {
        return httpSession.getSessionContext();
    }

    public Object getValue(String name) {
    	if (isIncludeOrForward)
    		return this.getAttribute(name, APPLICATION_SCOPE);
    	else
    		return this.getAttribute(name, DEFAULT_SCOPE);
    }

    /**
     * DEPRECATED: Implemented for backwards compatibility with HttpSession.
     * @deprecated
     */
    public String[] getValueNames() {
        return httpSession.getValueNames();
    }

    public void putValue(String name, Object value) {
    	if (isIncludeOrForward)
    		this.setAttribute(name, value, APPLICATION_SCOPE);
        this.setAttribute(name, value, DEFAULT_SCOPE);
    }

    public void removeValue(String name) {
    	if (isIncludeOrForward)
    		this.removeAttribute(name, APPLICATION_SCOPE);
        this.removeAttribute(name, DEFAULT_SCOPE);
    }


	public Map<String, Object> getMap() {
		List<String> paramNames = getAttributeNamesAsList(DEFAULT_SCOPE);		
		return fillMap(paramNames, DEFAULT_SCOPE);	
	}

	public Map<String, Object> getMap(int scope) {
		List<String> paramNames = getAttributeNamesAsList(scope);		
		return fillMap(paramNames, scope);
	}
    
// ***** private methods *****

	/**
	 * transforms the getAttributeNames enumeration to a list
	 * @return list of getAttributeNames
	 */
	private List<String> getAttributeNamesAsList(int scope) {
		//transform Enum to List
		List<String> paramNames = new ArrayList<String>();
		Enumeration<String> e = getAttributeNames(scope);
		while (e.hasMoreElements()){
			paramNames.add(e.nextElement());
		}
		return paramNames;
	}
	
	/**
	 * @param paramNames list of the attribute names to be filled in the map
	 * @return the filled map
	 */
	private Map<String, Object> fillMap(List<String> paramNames, int scope) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		for (String string : paramNames) {
			resultMap.put(string, getAttribute(string,scope));
		}
		return resultMap;
	}


	public void setIncludeOrForward(boolean isIncludeOrForward) {
		this.isIncludeOrForward = isIncludeOrForward;
	}
	/** 
	   * Returns a <code>Map</code> of the session attributes in
	   * the portlet session scope.
	   * <p>
	   * The keys are of type <code>String</code> and the values in the 
	   * returned <code>Map</code> are from type <code>Object</code>.
	   * <p>
	   * If no session attributes exist this method returns an empty <code>Map</code>.
	   *
	   * @return     an immutable <code>Map</code> containing the session attributes in the  
	   *             portlet session scope as keys and attribute values as map values, or an empty <code>Map</code>
	   *             if no session attributes exist. The keys in the
	   *             map are of type String, the values of type
	   *             Object.
	   *  @since 2.0
	   */
	  public Map<String, Object> getAttributeMap(int scope){
		  return getMap(scope); 
	  }
	  /** 
	   * Returns a <code>Map</code> of the session attributes in
	   * the portlet session scope.
	   * <p>
	   * The keys are of type <code>String</code> and the values in the 
	   * returned <code>Map</code> are from type <code>Object</code>.
	   * <p>
	   * If no session attributes exist this method returns an empty <code>Map</code>.
	   *
	   * @return     an immutable <code>Map</code> containing the session attributes in the  
	   *             portlet session scope as keys and attribute values as map values, or an empty <code>Map</code>
	   *             if no session attributes exist. The keys in the
	   *             map are of type String, the values of type
	   *             Object.
	   *  @since 2.0
	   */
	  public Map<String, Object> getAttributeMap(){
		  return getMap();
	  }
}
