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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.portlet.ClientDataRequest;
import javax.portlet.PortletRequest;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public class HttpServletPortletRequestWrapper extends HttpServletRequestWrapper
{
    private static final Logger logger = LoggerFactory.getLogger(HttpServletPortletRequestWrapper.class);
    
    protected static final String INCLUDE_CONTEXT_PATH = "javax.servlet.include.context_path";
    protected static final String INCLUDE_PATH_INFO = "javax.servlet.include.path_info";
    protected static final String INCLUDE_QUERY_STRING = "javax.servlet.include.query_string";
    protected static final String INCLUDE_REQUEST_URI = "javax.servlet.include.request_uri";
    protected static final String INCLUDE_SERVLET_PATH = "javax.servlet.include.servlet_path";
    protected static final String FORWARD_CONTEXT_PATH = "javax.servlet.forward.context_path";
    protected static final String FORWARD_PATH_INFO = "javax.servlet.forward.path_info";
    protected static final String FORWARD_QUERY_STRING = "javax.servlet.forward.query_string";
    protected static final String FORWARD_REQUEST_URI = "javax.servlet.forward.request_uri";
    protected static final String FORWARD_SERVLET_PATH = "javax.servlet.forward.servlet_path";

    protected static final String[] PATH_ATTRIBUTE_INCLUDE_NAMES = { INCLUDE_CONTEXT_PATH,
                                                                     INCLUDE_PATH_INFO,
                                                                     INCLUDE_QUERY_STRING,
                                                                     INCLUDE_REQUEST_URI,
                                                                     INCLUDE_SERVLET_PATH };

    protected static final String[] PATH_ATTRIBUTE_FORWARD_NAMES = { FORWARD_CONTEXT_PATH,
                                                                     FORWARD_PATH_INFO,
                                                                     FORWARD_QUERY_STRING,
                                                                     FORWARD_REQUEST_URI,
                                                                     FORWARD_SERVLET_PATH };

    protected static final String[] PATH_ATTRIBUTE_NAMES = { INCLUDE_CONTEXT_PATH,
                                                             INCLUDE_PATH_INFO,
                                                             INCLUDE_QUERY_STRING,
                                                             INCLUDE_REQUEST_URI,
                                                             INCLUDE_SERVLET_PATH,
                                                             FORWARD_CONTEXT_PATH,
                                                             FORWARD_PATH_INFO,
                                                             FORWARD_QUERY_STRING,
                                                             FORWARD_REQUEST_URI,
                                                             FORWARD_SERVLET_PATH };
    
    protected static final HashSet<String> PATH_ATTRIBUTE_NAMES_SET = 
        new HashSet<String>(Arrays.asList(PATH_ATTRIBUTE_NAMES));
    
    /**
     * PathMethodValues contains the values of a HttpServletRequest PATH methods.
     */
    protected static final class PathMethodValues
    {
        String contextPath;
        String servletPath;
        String pathInfo;
        String queryString;
        String requestURI;
        
        PathMethodValues(){}
                
        PathMethodValues copy(PathMethodValues pmv)
        {
            this.contextPath = pmv.contextPath;
            this.servletPath = pmv.servletPath;
            this.pathInfo = pmv.pathInfo;
            this.queryString = pmv.queryString;
            this.requestURI = pmv.requestURI;
            return this;
        }
    }
    
    protected static final String[] DEFAULT_SERVLET_CONTAINER_MANAGED_ATTRIBUTES = { "org.apache.catalina.core.DISPATCHER_TYPE", 
    																				 "org.apache.catalina.core.DISPATCHER_REQUEST_PATH" };
    
    /**
     * <p>
     * Some servlet containers like Tomcat (Catalina) use "injected" request attributes within their own Request (dispatch)
     * wrapper objects to keep track of their current state. Such "injected" attributes are never really "set" or (supposed to be)
     * visible by the current application request processing logic.
     * </p><p>
     * Such special attributes therefore cannot be reliably "managed" or isolated per (portlet) servlet request window as it never
     * can be known if or when such attributes (value) might change.
     * </p><p>
     * And, as these attributes are used internally by the servlet container providing back the wrong (or no) value very easily
     * can break the expected behavior.
     * </p><p>
     * On Tomcat this for instance happens when a forwarded portlet request itself would try an (servlet) include request. Then, its
     * internal state using "injected" attribute "org.apache.catalina.DISPATCHER_TYPE" is changed.
     * </p><p>
     * To support such servlet container internal/injected attribute handling, a static servletContainerManagedAttributes HashSet
     * is maintained containing the attribute names which value should <em>always</em> be retrieved from the current (injected) parent request.
     * </p><p>
     * As default the currently known two Tomcat internal/injected attribute names are used.
     * </p><p>
     * For other containers which might use a similar approach these reserved attribute names can be (re)set through the static
     * method setServletContainerManagedAttributes(String[]), e.g. like with a Springframework based initialization of the container.
     * </p>
     */
    protected static HashSet<String> servletContainerManagedAttributes =
    	new HashSet<String>(Arrays.asList(DEFAULT_SERVLET_CONTAINER_MANAGED_ATTRIBUTES));
    
    /**
     * DispatchDetection defines how a (nested) RequestDispatcher include/forward call will be detected.
     * <p>
     * The dispatch detection is used to optimize building the custom parameters map as returned from the
     * getParametersMap method as rebuilding the parameters map for each and every access can be quite expensive.
     * </p>
     * <p>
     * A parameter map is constant within the scope of one (level of) request dispatching, but a nested request
     * dispatch using an additional query string on the dispatch path requires merging of its query string parameters
     * for the duration of that (nested) dispatch.
     * </p>
     * <p>
     * DispatchDetection defines how such a nested dispatch is detected:
     * <ul>
     *   <li>CHECK_STATE: full compare of the current getRequest().getParameterMap() against the initial getParameterMap()</li>
     *   <li>CHECK_REQUEST_WRAPPER_STACK: check if the webcontainer injected a HttpServletRequestWrapper <em>above</em> this
     *       request as Tomcat does (which usually will be less time/cpu consuming if many parameters are passed in)</li>
     *   <li>EVALUATE:  auto detect on first getParameterMap() call if CHECK_REQUEST_WRAPPER_STACK can be used and then switch
     *       to either CHECK_STATE or CHECK_REQUEST_WRAPPER_STACK DispatchDetection</li>
     * </ul>
     * </p>
     * <p>
     * By default the CHECK_STATE method is used which in most cases is more optimal except when often many request parameters are used.
     * </p>
     */
    static enum DispatchDetection { CHECK_STATE, CHECK_REQUEST_WRAPPER_STACK, EVALUATE };
    
    /**
     * Current DispatchDetection mode used, defaults to DispatchDetection.CHECK_STATE
     */
    static volatile DispatchDetection dispatchDetection = DispatchDetection.CHECK_STATE;
    
    /**
     * Cache for parsed dateHeader values.
     */
    protected static final HashMap<String,Long> dateHeaderParseCache = new HashMap<String,Long>();
    
    /**
     * The set of SimpleDateFormat formats to use in getDateHeader().
     *
     * Notice that because SimpleDateFormat is not thread-safe, we can't
     * declare formats[] as a static variable.
     */
    protected SimpleDateFormat dateHeaderFormats[] = 
    {
        new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US),
        new SimpleDateFormat("EEEEEE, dd-MMM-yy HH:mm:ss zzz", Locale.US),
        new SimpleDateFormat("EEE MMMM d HH:mm:ss yyyy", Locale.US)
    };

    /**
     * Map of the current, web container provided, PATH_ATTRIBUTE_NAMES attribute values.
     */
    protected Map<String,Object> currPathAttributeValues = new HashMap<String,Object>();
    
    /**
     * Map of the first, or first after a (PortletRequestDispatcher initiated nested dispatch, web container provided, PATH_ATTRIBUTE_NAMES attribute values.
     */
    protected Map<String,Object> dispPathAttributeValues = new HashMap<String, Object>();
    
    /**
     * Map of the PATH_ATTRIBUTE_NAMES attribute values provided to the invoking servlet as derived for the current (initial or nested) request dispatch.
     */
    protected Map<String,Object> pathAttributeValues = new HashMap<String, Object>();
    
    /**
     * Cache of PATH_ATTRIBUTE_NAMES attribute values possibly set using setAttribute.
     * <p>
     * This read-through cache protects against concurrent writing to the client request attribute map(s) when using multi-threaded rendering.
     * </p>
     */
    protected Map<String,Object> pathAttributeCache = new HashMap<String, Object>();
    
    /**
     * Current getRequest() PATH method values
     */
    protected PathMethodValues currPathMethodValues = new PathMethodValues();
    
    /**
     * The first, or first after a (PortletRequestDispatcher initiated nested dispatch, web container provided, PATH method values.
     */
    protected PathMethodValues dispPathMethodValues = new PathMethodValues();
    
    /**
     * PATH method values provided to the invoking servlet as derived for the current (initial or nested) request dispatch
     */
    protected PathMethodValues pathMethodValues = new PathMethodValues();
    
    /**
     * The initial, web container provided, PATH method values.
     * <p>
     * These values are kept separately from the dispPathMethodValues are the Portlet API retaining those for all further (nested) dispatching.
     * But this actually only makes sense if the fist dispatch is not done using a NamedDispatcher.
     * </p>
     */
    protected PathMethodValues initPathMethodValues;
    
    /**
     * Flag indicating if the current, web container provided, PATH_ATTRIBUTE_INCLUDE_NAMES attribute values are modified
     */
    protected boolean attributeIncludeValuesModified;

    /**
     * Flag indicating if the current, web container provided, PATH_ATTRIBUTE_FORWARD_NAMES attribute values are modified
     */
    protected boolean attributeForwardValuesModified;

    /**
     * Flag indicating if the current, web container provided, PATH method values are modified
     */
    protected boolean methodValuesModified;
    
    /**
     * Flag indicating if the current (possibly nested) request dispatch is based upon a NamedDispatcher.
     */
    protected boolean namedDispatch;
    
    /**
     * Flag indicating if the current (possibly nested) request dispatch is <em>intentionally</em> using RequestDispatcher.forward.
     * <p>Note: it depends on isForwardingPossible() if an actual forward is used or "faked" while performing an include call.</p>
     */
    protected boolean forwarded;
    
    /**
     * Flag indicating if the initial level of dispatch is detected.
     */
    protected boolean dispatched;
    
    /**
     * Flag indicating if a nested dispatch is detected.
     */
    protected boolean nested;

    /**
     * Current size of the nested HttpServletRequestWrapper stack size, counted from this request up.
     * <p>
     * Used together with DispatchDetection mode CHECK_REQUEST_WRAPPER_STACK or EVALUATE to determine if
     * the current request dispatching "stack" has changed and thus the parameter map needs rebuilding.
     * </p>
     * <p>
     * This type of DispatchDetection only works for web containers like Tomcat which "inject" (and remove) a HttpServletRequestWrapper
     * of their own on each nested request dispatch call.
     * </p>
     */
    protected int requestWrapperStackSize;
    
    /**
     * Initial parameters map as provided by the web container <em>before</em> the initial request dispatch.
     * <p>
     * Used for comparision with the current web container provided parameters map to calculate (possible)
     * merged parameters when the initial (or a nested) request dispatcher was created using additional query string parameters.
     * </p>
     */
    protected Map<String, String[]> origParameterMap;
    
    /**
     * Cache of current parameters map as provided by the web container.
     * <p>
     * Only used with DispatchDetection != CHECK_REQUEST_WRAPPER_STACK for comparision with the current
     * current web container provided parameters map to detect a possible nested request dispatch
     * with additional query string parameters (or a return thereof).
     * </p>
     */
    protected Map<String, String[]> currParameterMap;
    
    /**
     * Cache of the derived parameters map to be provided to invoking servlet.
     * <p>
     * This parameter map is (re)build on first access to getParametersMap after a (nested) request dispatch or a
     * return thereof.
     * </p>
     */
    protected Map<String, String[]> parameterMap;
    
    protected final PortletRequestContext requestContext;
    protected final ServletContext servletContext;
    protected final PortletRequest portletRequest;
    protected final ClientDataRequest clientDataRequest;
    protected final String lifecyclePhase;
    protected final boolean renderPhase;
    
    protected HttpSession session;
    
    /**
     * Set the Servlet container managed (projected) attribute names which cannot be isolated per portlet/servlet request window
     * and therefore need to be retrieved directly from the parent (injected) servlet request object.
     * @param names array of protected servlet container attribute names
     */
    public static void setServletContainerManagedAttributes(String[] names)
    {
    	if (names == null)
    	{
    		servletContainerManagedAttributes.clear();
    	}
    	else
    	{
    		servletContainerManagedAttributes = new HashSet<String>(Arrays.asList(names));
    	}
    }
    
    @SuppressWarnings("unchecked")
    public HttpServletPortletRequestWrapper(HttpServletRequest request, ServletContext servletContext, HttpSession session, PortletRequest portletRequest, boolean included, boolean namedDispatch)
    {
        super(request);
        this.servletContext = servletContext;
        this.session = session;
        this.portletRequest = portletRequest;
        lifecyclePhase = (String)portletRequest.getAttribute(PortletRequest.LIFECYCLE_PHASE);
        clientDataRequest = PortletRequest.ACTION_PHASE.equals(lifecyclePhase) || PortletRequest.RESOURCE_PHASE.equals(lifecyclePhase) ? (ClientDataRequest)portletRequest : null;
        renderPhase = PortletRequest.RENDER_PHASE.equals(lifecyclePhase);
        requestContext = (PortletRequestContext )portletRequest.getAttribute(PortletInvokerService.REQUEST_CONTEXT);
        this.forwarded = !included;
        this.namedDispatch = namedDispatch;
        origParameterMap = new HashMap<String,String[]>(request.getParameterMap());
        currParameterMap = origParameterMap;
        for (String name : PATH_ATTRIBUTE_NAMES)
        {
            currPathAttributeValues.put(name,request.getAttribute(name));
        }
        currPathMethodValues.contextPath = request.getContextPath();
        currPathMethodValues.servletPath = request.getServletPath();
        currPathMethodValues.pathInfo = request.getPathInfo();
        currPathMethodValues.queryString = request.getQueryString();
        currPathMethodValues.requestURI = request.getRequestURI();
        if (dispatchDetection != DispatchDetection.CHECK_STATE)
        {            
            HttpServletRequestWrapper currentRequest = this;
            while ((currentRequest.getRequest()) instanceof HttpServletRequestWrapper)
            {
                requestWrapperStackSize++;
                currentRequest = (HttpServletRequestWrapper)currentRequest.getRequest();
            }
        }
    }
    
    /**
     * Try to parse the given date as a HTTP date. Borrowed and adapted from
     * Tomcat FastHttpDateFormat
     */
    private long parseDateHeader(String value)
    {
        Long dateValue = null;
        try
        {
            dateValue = dateHeaderParseCache.get(value);
        }
        catch (Exception e)
        {
        }
        if (dateValue == null)
        {
            for (int i = 0; i < dateHeaderFormats.length; i++)
            {
                try
                {
                    Date date = dateHeaderFormats[i].parse(value);
                    dateValue = new Long(date.getTime());
                }
                catch (ParseException e)
                {
                }
            }
            if (dateValue != null)
            {
                synchronized (dateHeaderParseCache)
                {
                    if (dateHeaderParseCache.size() > 1000)
                    {
                        dateHeaderParseCache.clear();
                    }
                    dateHeaderParseCache.put(value, dateValue);
                }
            }
            else
            {
                throw new IllegalArgumentException(value);
            }
        }
        return dateValue.longValue();
    }
    
    boolean isForwardingPossible()
    {
        return !renderPhase;
    }
    
    /**
     * Returns the current forwarding state to be cached by the PortletRequestDispatcherImpl
     * during a nested forward. This state needs to be restored with the restoreFromNestedForward method afterwards.
     */
    boolean isForwarded()
    {
        return forwarded;
    }
    
    /**
     * Returns the current namedDispatch state to be cached by the PortletRequestDispatcherImpl
     * during a nested forward. This state needs to be restored with the restoreFromNestedForward method afterwards.
     */
    boolean isNamedDispatch()
    {
        return namedDispatch;
    }
    
    /**
     * Returns a <em>copy</em> of the current dispPathAttributeValues to be cached by the PortletRequestDispatcherImpl
     * during a nested forward. These need to be restored with the restoreFromNestedForward method afterwards.
     */
    Map<String, Object> getPathAttributeValues()
    {
        return new HashMap<String, Object>(dispPathAttributeValues);
    }
    
    /**
     * Returns a <em>copy</em> of the current initPathMethodValues (or null) to be cached by the PortletRequestDispatcherImpl
     * during a nested forward. These need to be restored with the restoreFromNestedForward method afterwards.
     */
    PathMethodValues getInitPathMethodValues()
    {
        return initPathMethodValues != null ? new PathMethodValues().copy(initPathMethodValues) : null;
    }
    
    /**
     * Initiates a nested forward from the PortletRequestDispatcherImpl.
     */
    void setNestedForward()
    {
        dispatched = false;        
        forwarded = true;
        namedDispatch = false;
    }
    
    /**
     * Restores the previous request path state as cached by the PortletRequestDispatcherImpl after returning from a nested forward.
     */
    void restoreFromNestedForward(boolean forwarded, boolean namedDispatch, 
                                  PathMethodValues pathMethodValues, Map<String, Object> pathAttributeValues)
    {
        this.forwarded = forwarded;
        this.namedDispatch = namedDispatch;
        dispPathAttributeValues.clear();
        dispPathAttributeValues.putAll(pathAttributeValues);
        updateRequestPathState();
    }
    
    /**
     * Method to check the current web container provided request path state with the cached state to determine if a (nested)
     * request dispatch has occurred.
     * <p>
     * If a (nested) request dispatch has been determined, the derived pathMethodValues and pathAttributeValues are (re)created
     * to be provided to the invoking servlet as override of the web container "view" of this state.
     * </p>
     */
    protected void updateRequestPathState()
    {
        // synchronize current web container path method and attribute values and detect modifications
        syncDispatcherPathValues();
        
        // check and evaluate (significant) modifications to the path state
        if (checkDispatcherPathValuesChanged())
        {
            // dispatch detected
            
            if (!dispatched)
            {
                //initial dispatch or initial dispatch after a nested forward (from PortletRequestDispatcherImpl) detected
                initFirstDispatchPathValues();
            }
            else
            {
                // check if (still) within a nested dispatch or returning back to the initial dispatch
                checkNestedDispatch();
            }
            if (!nested)
            {
                // (back to) initial dispatch
                setupFirstDispatchPathValues();
            }
            else // nested
            {
                // (still) within a nested dispatch
                setupNestedDispatchPathValues();
            }
        }
    }
    
    private static boolean compareAttributes(Object o1, Object o2)
    {
        return (o1 == null && o2 == null) || (o1 != null && o2 != null && o1.equals(o2));
    }
    
    private static String asString(Object o)
    {
        return o != null ? o.toString() : null;
    }
    
    /**
     * Synchronize and compare current web container provided path state with the previously determined path state.
     */
    protected void syncDispatcherPathValues()
    {
        HttpServletRequest request = (HttpServletRequest)getRequest();
        Object attrValue;
        String methodValue;

        attributeIncludeValuesModified = false;
        attributeForwardValuesModified = false;
        methodValuesModified = false;
        
        for (String name : PATH_ATTRIBUTE_INCLUDE_NAMES)
        {
            // first check possible cached path attributes as set through setAttribute
            attrValue = pathAttributeCache.get(name);
            if (attrValue == null)
            {
                // not cached: get current value from web container
                attrValue = request.getAttribute(name);
            }
            // determine if modified
            attributeIncludeValuesModified = !attributeIncludeValuesModified ? !compareAttributes(currPathAttributeValues.get(name), attrValue) : true;
            // save new value for further usage and future modification check
            currPathAttributeValues.put(name, attrValue);
        }
        for (String name : PATH_ATTRIBUTE_FORWARD_NAMES)
        {
            // first check possible cached path attributes as set through setAttribute
            attrValue = pathAttributeCache.get(name);
            if (attrValue == null)
            {
                // not cached: get current value from web container
                attrValue = request.getAttribute(name);
            }
            // determine if modified
            attributeForwardValuesModified = !attributeForwardValuesModified ? !compareAttributes(currPathAttributeValues.get(name), attrValue) : true;
            // save new value for further usage and future modification check
            currPathAttributeValues.put(name, attrValue);
        }
        
        // for all path method values:
        //   retrieve them from the current web container
        //   determine if modified
        //   save them further usage and future modification check
        
        methodValue = request.getContextPath();
        methodValuesModified = methodValuesModified ? true : !compareAttributes(currPathMethodValues.contextPath, methodValue);
        currPathMethodValues.contextPath = methodValue;
        
        methodValue = request.getServletPath();
        methodValuesModified = methodValuesModified ? true : !compareAttributes(currPathMethodValues.servletPath, methodValue);
        currPathMethodValues.servletPath = methodValue;

        methodValue = request.getPathInfo();
        methodValuesModified = methodValuesModified ? true : !compareAttributes(currPathMethodValues.pathInfo, methodValue);
        currPathMethodValues.pathInfo = methodValue;

        methodValue = request.getQueryString();
        methodValuesModified = methodValuesModified ? true : !compareAttributes(currPathMethodValues.queryString, methodValue);
        currPathMethodValues.queryString = methodValue;

        methodValue = request.getRequestURI();
        methodValuesModified = methodValuesModified ? true : !compareAttributes(currPathMethodValues.requestURI, methodValue);
        currPathMethodValues.requestURI = methodValue;
    }
    
    /**
     * Check and evaluate (significant) modifications to the path state.
     */
    protected boolean checkDispatcherPathValuesChanged()
    {
        // initial "clearing" of current request path method and/or attribute values might be done by the container while
        // still preparing for the dispatch: ignore and "swallow" those changes
        if (methodValuesModified && currPathMethodValues.servletPath == null)
        {
            methodValuesModified = false;
        }
        if (attributeIncludeValuesModified && currPathAttributeValues.get(INCLUDE_SERVLET_PATH) == null)
        {
            attributeIncludeValuesModified = false;
        }
        if (attributeForwardValuesModified && currPathAttributeValues.get(FORWARD_SERVLET_PATH) == null)
        {
            attributeForwardValuesModified = false;
        }
        return (attributeIncludeValuesModified || attributeForwardValuesModified || methodValuesModified);
    }
    
    /**
     * Initialize first dispatch path state
     */
    protected void initFirstDispatchPathValues()
    {
        dispatched = true;
        dispPathMethodValues.copy(currPathMethodValues);
        dispPathAttributeValues.putAll(currPathAttributeValues);
    }
    
    /**
     * Determine if new dispatch path state represents the first dispatch or the first after a nested forward initiated from
     * RequestDispatcherImpl, or a nested dispatch through ServletContext.getRequestDispatcher() or an include initiated from
     * PortletRequestDispatcherImpl.
     */
    protected void checkNestedDispatch()
    {
        nested = false;
        for (String name : PATH_ATTRIBUTE_NAMES)
        {
            if (!compareAttributes(dispPathAttributeValues.get(name), currPathAttributeValues.get(name)))
            {
                nested = true;
                break;
            }
        }
        nested = nested ? true : !compareAttributes(dispPathMethodValues.contextPath, currPathMethodValues.contextPath);
        nested = nested ? true : !compareAttributes(dispPathMethodValues.servletPath, currPathMethodValues.servletPath);
        nested = nested ? true : !compareAttributes(dispPathMethodValues.pathInfo, currPathMethodValues.pathInfo);
        nested = nested ? true : !compareAttributes(dispPathMethodValues.queryString, currPathMethodValues.queryString);
        nested = nested ? true : !compareAttributes(dispPathMethodValues.requestURI, currPathMethodValues.requestURI);
    }
    
    /**
     * Deriving the path state values as should be provided to the invoking servlet for the first dispatch level.
     * <p>
     * Note: we also come here after returning back to the initial dispatch from a nested dispatch
     * </p>
     * <pre>
     * If (namedDispatch):
     *   - All request attribute path values should be "hidden"
     *   - No path method values can/should be provided either, except for getContextPath()
     *     Note: this is a use-case not properly recognized in the portlet spec!
     *     Possibly, we might be *required* to keep the existing path method values as provided by the
     *     web container or maybe provide (only) a "/" as servletPath?
     * else:
     *   - If (!forwarded) || (forwarded && !isForwardingPossible()):
     *        if (initial path method values determined) // see next If step below
     *          - use initial path method values
     *        else
     *          - use javax.servlet.include.* request attribute values as derived path method values (PLT.19.3.8)
     *     else: // (forwarded && isForwardingPossible())
     *       current (forward) path method values are OK
     *   - If (first dispatched && !namedDispatch)
     *       The current path method values need to be retained for all further (nested) dispatching (see above and below)
     *       - save current path method values as initial path values
     *   - If (!forwarded):
     *       - current javax.servlet.include.* request attribute values are OK
     *       - "hide" possible javax.servlet.forward.* request attribute values
     *   - else if (initial path method values determined) // see previous If step above
     *       - use initial path method values for javax.servlet.forward.* request attribute values
     *   - else if (forwarded && isForwardingPossible()):
     *       - use current path method values for javax.servlet.forward.* request attribute values (PLT.19.4.2)
     *       - "hide" possible javax.servlet.include.* request attribute values
     *   - else: // (forwarded && !isForwardingPossible())
     *       - remap javax.servlet.include.* request attribute values to javax.servlet.forward.* values
     *       - "hide" javax.servlet.include.* request attribute values
     * </pre>
     */
    protected void setupFirstDispatchPathValues()
    {
      // Clear possible previously derived pathAttributeValues from a nested dispatch
      pathAttributeValues.clear();
      if (namedDispatch)
      {
          // only can/must support request.getContextPath()
          pathMethodValues.contextPath = dispPathMethodValues.contextPath;
      }
      else
      {
          if (!forwarded || !isForwardingPossible())
          {
              if (initPathMethodValues != null)
              {
                  pathMethodValues.copy(initPathMethodValues);
              }
              else
              {
                  pathMethodValues.contextPath = asString(dispPathAttributeValues.get(INCLUDE_CONTEXT_PATH));
                  pathMethodValues.servletPath = asString(dispPathAttributeValues.get(INCLUDE_SERVLET_PATH));
                  pathMethodValues.pathInfo = asString(dispPathAttributeValues.get(INCLUDE_PATH_INFO));
                  pathMethodValues.queryString = asString(dispPathAttributeValues.get(INCLUDE_QUERY_STRING));
                  pathMethodValues.requestURI = asString(dispPathAttributeValues.get(INCLUDE_REQUEST_URI));
              }
          }
          else // forwarded && isForwardingPossible()
          {
              pathMethodValues.copy(dispPathMethodValues);
          }
          
          // Save *first time* path method values as the portlet spec requires
          // retaining those for all further (nested) dispatching:
          // - includes: these values will override the path method values
          // - forwards: these values will override the forward attribute values
          // Note: this only make "sense" after a first !namedDispatch dispatch, e.g. .servletPath != null
          if (initPathMethodValues == null && pathMethodValues.servletPath != null)
          {
              initPathMethodValues = new PathMethodValues().copy(pathMethodValues);
          }
          
          if (!forwarded)
          {
              pathAttributeValues.put(INCLUDE_CONTEXT_PATH, dispPathAttributeValues.get(INCLUDE_CONTEXT_PATH));
              pathAttributeValues.put(INCLUDE_SERVLET_PATH, dispPathAttributeValues.get(INCLUDE_SERVLET_PATH));
              pathAttributeValues.put(INCLUDE_PATH_INFO, dispPathAttributeValues.get(INCLUDE_PATH_INFO));
              pathAttributeValues.put(INCLUDE_QUERY_STRING, dispPathAttributeValues.get(INCLUDE_QUERY_STRING));
              pathAttributeValues.put(INCLUDE_REQUEST_URI, dispPathAttributeValues.get(INCLUDE_REQUEST_URI));
          }
          else if (initPathMethodValues != null)
          {
              pathAttributeValues.put(FORWARD_CONTEXT_PATH, initPathMethodValues.contextPath);
              pathAttributeValues.put(FORWARD_SERVLET_PATH, initPathMethodValues.servletPath);
              pathAttributeValues.put(FORWARD_PATH_INFO, initPathMethodValues.pathInfo);
              pathAttributeValues.put(FORWARD_QUERY_STRING, initPathMethodValues.queryString);
              pathAttributeValues.put(FORWARD_REQUEST_URI, initPathMethodValues.requestURI);
          }
          else if (forwarded && isForwardingPossible())
          {
              pathAttributeValues.put(FORWARD_CONTEXT_PATH, dispPathMethodValues.contextPath);
              pathAttributeValues.put(FORWARD_SERVLET_PATH, dispPathMethodValues.servletPath);
              pathAttributeValues.put(FORWARD_PATH_INFO, dispPathMethodValues.pathInfo);
              pathAttributeValues.put(FORWARD_QUERY_STRING, dispPathMethodValues.queryString);
              pathAttributeValues.put(FORWARD_REQUEST_URI, dispPathMethodValues.requestURI);
          }
          else // forwarded && !isForwardingPossible()
          {
              pathAttributeValues.put(FORWARD_CONTEXT_PATH, dispPathAttributeValues.get(INCLUDE_CONTEXT_PATH));
              pathAttributeValues.put(FORWARD_SERVLET_PATH, dispPathAttributeValues.get(INCLUDE_SERVLET_PATH));
              pathAttributeValues.put(FORWARD_PATH_INFO, dispPathAttributeValues.get(INCLUDE_PATH_INFO));
              pathAttributeValues.put(FORWARD_QUERY_STRING, dispPathAttributeValues.get(INCLUDE_QUERY_STRING));
              pathAttributeValues.put(FORWARD_REQUEST_URI, dispPathAttributeValues.get(INCLUDE_REQUEST_URI));
          }
      }
    }
    
    /**
     * Deriving the path state values as should be provided to the invoking servlet for a nested dispatch.
     * <p>
     * We are not properly in "control" here anymore but can only assume the nested dispatch is still within
     * the current portlet application and therefore need to reset to the initial path method values during includes.
     * </p>
     * <p>
     * Furthermore, we assume at least the path INCLUDE attribute values as/if provided by the web container to be correct.
     * </p>
     * <p>
     * However we need to retain the initial dispatch forward path attribute values <em>if</em> no new values are provided.
     * </p>
     */
    protected void setupNestedDispatchPathValues()
    {
        if (namedDispatch)
        {
            // only can/must support request.getContextPath()
            pathMethodValues.contextPath = dispPathMethodValues.contextPath;
        }
        else
        {
            if (!forwarded || !isForwardingPossible())
            {
                pathMethodValues.copy(initPathMethodValues);
            }
            else // forwarded && isForwardingPossible()
            {
                pathMethodValues.copy(dispPathMethodValues);
            }
        }
        
        // whatever the current attribute include path values: assume them correct (even if null)
        pathAttributeValues.put(INCLUDE_CONTEXT_PATH, currPathAttributeValues.get(INCLUDE_CONTEXT_PATH));
        pathAttributeValues.put(INCLUDE_SERVLET_PATH, currPathAttributeValues.get(INCLUDE_SERVLET_PATH));
        pathAttributeValues.put(INCLUDE_PATH_INFO, currPathAttributeValues.get(INCLUDE_PATH_INFO));
        pathAttributeValues.put(INCLUDE_QUERY_STRING, currPathAttributeValues.get(INCLUDE_QUERY_STRING));
        pathAttributeValues.put(INCLUDE_REQUEST_URI, currPathAttributeValues.get(INCLUDE_REQUEST_URI));
        
        // However: we need to retain our initial dispatch forward path attribute values *if* no new values are provided
        // To determine if current forward path attributes are set, only need to check the context path
        if (attributeForwardValuesModified && currPathAttributeValues.get(FORWARD_CONTEXT_PATH) != null)
        {
            pathAttributeValues.put(FORWARD_CONTEXT_PATH, currPathAttributeValues.get(FORWARD_CONTEXT_PATH));
            pathAttributeValues.put(FORWARD_SERVLET_PATH, currPathAttributeValues.get(FORWARD_SERVLET_PATH));
            pathAttributeValues.put(FORWARD_PATH_INFO, currPathAttributeValues.get(FORWARD_PATH_INFO));
            pathAttributeValues.put(FORWARD_QUERY_STRING, currPathAttributeValues.get(FORWARD_QUERY_STRING));
            pathAttributeValues.put(FORWARD_REQUEST_URI, currPathAttributeValues.get(FORWARD_REQUEST_URI));
        }
    }
    
    /**
     * Determine if the web container modified the current HttpServletRequestWrapper stack.
     * <p>
     * The current HttpServletRequestWrapper hierachy (stack) size is determined and compared against
     * the previous size.
     * </p>
     * <p>
     * If the size is different the web container "injected" (or removed) a request wrapper of its own
     * to manage request dispatcher logic like merging additional dispatcher query string parameters.
     * </p>
     * <p>
     * This DispatchDetection solution only works on web containers like Tomcat.
     * </p>
     * @return true if the request wrapper stack (size) changed.
     */
    protected boolean isRequestWrapperStackChanged()
    {
        HttpServletRequestWrapper currentRequest = this;
        int currentRequestWrapperStackSize = 0;
        while ((currentRequest.getRequest()) instanceof HttpServletRequestWrapper)
        {
            currentRequestWrapperStackSize++;
            currentRequest = (HttpServletRequestWrapper)currentRequest.getRequest();
        }
        if (currentRequestWrapperStackSize != requestWrapperStackSize)
        {
            requestWrapperStackSize = currentRequestWrapperStackSize;
            return true;
        }
        return false;
    }
    /**
     * Returns a derived parameters map for the invoking servlet, merging the web container provided parameter map with the portletRequest parameter map
     * which might contain additional parameters like public render parameters.
     * <p>
     * The derived parameters map is cached for the duration of the current request dispatch, and rebuild for every nested dispatch or return thereof.
     * </p>
     * <p>
     * To determine if a nested dispatch occurred (or a return thereof), the current DispatchDetection mode is used:
     * <ul>
     *   <li>CHECK_STATE: full compare of the current getRequest().getParameterMap() against the initial getParameterMap()</li>
     *   <li>CHECK_REQUEST_WRAPPER_STACK: check if the webcontainer injected a HttpServletRequestWrapper <em>above</em> this
     *       request as Tomcat does (which usually will be less time/cpu consuming if many parameters are passed in)</li>
     *   <li>EVALUATE:  auto detect on first getParameterMap() call if CHECK_REQUEST_WRAPPER_STACK can be used and then switch
     *       to either CHECK_STATE or CHECK_REQUEST_WRAPPER_STACK DispatchDetection</li>
     * </ul>
     * </p>
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, String[]> getParameterMap()
    {
        boolean dispatchDetected = false;
        Map<String, String[]> newParameterMap = null;
        
        if (dispatchDetection == DispatchDetection.CHECK_REQUEST_WRAPPER_STACK)
        {
            if (isRequestWrapperStackChanged())
            {
                dispatchDetected = true;
            }
        }
        else
        {
            if (dispatchDetection == DispatchDetection.EVALUATE)
            {
                if (isRequestWrapperStackChanged())
                {
                    dispatchDetected = true;
                    
                    if (logger.isDebugEnabled())
                    {
                        logger.debug("DispatchDetection: changing from EVALUATE to CHECK_WEBCONTAINER_REQUEST");
                    }
                    dispatchDetection = DispatchDetection.CHECK_REQUEST_WRAPPER_STACK;
                }
            }
            if (!dispatchDetected)
            {
                // Use parameters maps comparision to determine if a (nested) dispatch occurred or a return thereof.
                // Note: if a nested dispatch didn't use additional query string parameters,
                // no change will (need to) be detected.
                newParameterMap = getRequest().getParameterMap();
                if (newParameterMap.size() != currParameterMap.size())
                {
                    dispatchDetected = true;
                }
                else
                {
                    for (Map.Entry<String,String[]> entry : newParameterMap.entrySet())
                    {
                        String[] newValues = entry.getValue();
                        String[] currValues = currParameterMap.get(entry.getKey());
                        if (currValues == null || newValues.length != currValues.length)
                        {
                            // no need to compare the actual parameter values as per the servlet spec additional
                            // query string parameters always must be prepended so doing a length check is enough.
                            dispatchDetected = true;
                            break;
                        }
                    }
                }
                if (dispatchDetected && dispatchDetection == DispatchDetection.EVALUATE)
                {
                    if (logger.isDebugEnabled())
                    {
                        logger.debug("DispatchDetection: changing from EVALUATE to CHECK_STATE");
                    }
                    dispatchDetection = DispatchDetection.CHECK_STATE;
                }
            }
        }

        if (dispatchDetected || parameterMap == null)
        {
            if (newParameterMap == null)
            {
                newParameterMap = getRequest().getParameterMap();
            }
            
            if (dispatchDetection != DispatchDetection.CHECK_REQUEST_WRAPPER_STACK)
            {
                // Save the current parameters map for future comparision
                // Note: this *must* be a copy as some web containers like WebSphere use
                // a "dynamic" parameters map where the content of the current
                // parameters map itself is modified...
                currParameterMap = new HashMap<String,String[]>(newParameterMap);
            }
            Map<String, String[]> diffParameterMap = new HashMap<String, String[]>();
            
            // determine the "diff" between the original parameters map and the current one
            for (Map.Entry<String,String[]> entry : newParameterMap.entrySet())
            {
                String[] values = entry.getValue();
                String[] original = origParameterMap.get(entry.getKey());
                String[] diff = null;
                if ( original == null )
                {
                    // a new parameter
                    diff = values.clone();
                }
                else if ( values.length > original.length )
                {
                    // we've got some additional query string parameter value(s)
                    diff = new String[values.length - original.length];
                    System.arraycopy(values,0,diff,0,values.length-original.length);
                }
                if ( diff != null )
                {
                    diffParameterMap.put(entry.getKey(), diff);
                }
            }
            // we might actually see an empty diff when using DispatchDetection.CHECK_REQUEST_WRAPPER_STACK
            // in which case the work above turned out to be not needed after all and we can retain the
            // current cached parametersMap...
            if (!diffParameterMap.isEmpty())
            {
                // build a new parametersMap by merging the diffParametersMap with the portletRequest.parametersMap
                newParameterMap = new HashMap<String,String[]>(portletRequest.getParameterMap());
                for (Map.Entry<String, String[]> entry : diffParameterMap.entrySet())
                {
                    String[] diff = entry.getValue();
                    String[] curr = newParameterMap.get(entry.getKey());
                    if ( curr == null )
                    {
                        newParameterMap.put(entry.getKey(), diff);
                    }
                    else
                    {
                        // we've got some additional query string parameter value(s)
                        String[] copy = new String[curr.length+diff.length];
                        System.arraycopy(diff,0,copy,0,diff.length);
                        System.arraycopy(curr,0,copy,diff.length,curr.length);
                        newParameterMap.put(entry.getKey(), copy);
                    }
                }
                parameterMap = Collections.unmodifiableMap(newParameterMap);
            }
        }        
        if (parameterMap == null)
        {
            // first time and no web container provided parameters
            parameterMap = portletRequest.getParameterMap();
        }
        return parameterMap;
    }

    @Override
    public String getParameter(String name)
    {
        // derive from getParametersMap() to ensure the cached parameters map is rebuild
        // when needed for the current (nested) request dispatch
        String[] values = this.getParameterMap().get(name);
        return values != null ? values[0] : null;
    }
    
    @Override
    public Enumeration<String> getParameterNames()
    {
        // derive from getParametersMap() to ensure the cached parameters map is rebuild
        // when needed for the current (nested) request dispatch
        return Collections.enumeration(this.getParameterMap().keySet());
    }

    @Override
    public String[] getParameterValues(String name)
    {
        // derive from getParametersMap() to ensure the cached parameters map is rebuild
        // when needed for the current (nested) request dispatch
        return this.getParameterMap().get(name);
    }

    @Override
    public String getContextPath()
    {
        // synchronize the derived path state values first
        updateRequestPathState();
        // return the derived path method value
        return pathMethodValues.contextPath;
    }

    @Override
    public String getPathInfo()
    {
        // synchronize the derived path state values first
        updateRequestPathState();
        // return the derived path method value
        return pathMethodValues.pathInfo;
    }

    @Override
    public String getPathTranslated()
    {
        // synchronize the derived path state values first
        updateRequestPathState();
        // base the return value on the derived path method value
        if (pathMethodValues.pathInfo != null && pathMethodValues.contextPath.equals(portletRequest.getContextPath()))
        {
            // can only (and possibly) do this while still within the same context
            return servletContext.getRealPath(pathMethodValues.pathInfo);
        }
        return null;
    }

    @Override
    public String getQueryString()
    {
        // synchronize the derived path state values first
        updateRequestPathState();
        // return the derived path method value
        return pathMethodValues.queryString;
    }

    @Override
    public String getRequestURI()
    {
        // synchronize the derived path state values first
        updateRequestPathState();
        // return the derived path method value
        return pathMethodValues.requestURI;
    }

    @Override
    public String getServletPath()
    {
        // synchronize the derived path state values first
        updateRequestPathState();
        // return the derived path method value
        return pathMethodValues.servletPath;
    }

    @Override
    public Object getAttribute(String name)
    {
        if (PATH_ATTRIBUTE_NAMES_SET.contains(name))
        {
            // synchronize the derived path state values first
            updateRequestPathState();
            // return the derived path attribute value
            return pathAttributeValues.get(name);
        }
        // First try to retrieve the attribute from the (possibly buffered/cached/previously set) portletRequest
        // except for servlet container injected (managed) attributes which cannot reliably be retrieved from the portletRequest
        Object value = servletContainerManagedAttributes.contains(name) ? null : portletRequest.getAttribute(name);
        // if null, fall back to retrieve the attribute from the web container itself
        return value != null ? value : requestContext.getAttribute(name, getRequest());
    }

    @Override
    public void setAttribute(String name, Object o)
    {
        if (PATH_ATTRIBUTE_NAMES_SET.contains(name))
        {
            // path attributes are never set/removed directly to/from the
            // web container but maintained in a separate cache map to 
            // protect against concurrent writing to the client request attribute map(s)
            // when using multi-threaded rendering.
            pathAttributeCache.put(name, o);
        }
        else
        {
            portletRequest.setAttribute(name, o);
        }
    }

    @Override
    public void removeAttribute(String name)
    {
        if (PATH_ATTRIBUTE_NAMES_SET.contains(name))
        {
            // path attributes are never set/removed directly to/from the
            // web container but maintained in a separate cache map to 
            // protect against concurrent writing to the client request attribute map(s)
            // when using multi-threaded rendering.
            pathAttributeCache.remove(name);
        }
        else
        {
            portletRequest.removeAttribute(name);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Enumeration<String> getAttributeNames()
    {
        HashSet<String> names = new HashSet<String>();
        Enumeration<String> e;
        for (e = getRequest().getAttributeNames(); e.hasMoreElements();  )
        {
            try
            {
                names.add(e.nextElement());
            }
            catch(NoSuchElementException nse)
            {
                // ignore potential concurrent changes when run in parallel mode
            }
        }
        for (e = portletRequest.getAttributeNames(); e.hasMoreElements();  )
        {
            try
            {
                names.add(e.nextElement());
            }
            catch(NoSuchElementException nse)
            {
                // ignore potential concurrent changes when run in parallel mode
            }
        }
        // now synchronize the derived path state values before overriding with (or possibly removing from)
        // the actual names set to enumerate
        updateRequestPathState();
        for (String name : PATH_ATTRIBUTE_NAMES)
        {
            if (pathAttributeValues.get(name) != null)
            {
                // ensure the derived path attribute name is present in the set
                names.add(name);
            }
            else
            {
                // remove a possibly web container provided path attribute name
                // if it currently should not be present based on our derived path state
                names.remove(name);
            }
        }
        return Collections.enumeration(names);
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path)
    {
        if (path != null)
        {
            // first determine if the web container does know how to dispatch to this path
            RequestDispatcher dispatcher = super.getRequestDispatcher(path);
            if (dispatcher != null)
            {
                // we have a RequestDispatcher
                if (!dispatched)
                {
                    // unlikely, but for sanity sake making sure our internal initial state is created
                    updateRequestPathState();
                }
                
                if (forwarded && isForwardingPossible())
                {
                    // The webcontainer already will have set the initial request forward path attributes
                    // and a subsequent forward (or include) won't need any further special handling
                    // therefore we can simply let the webcontainer handle this itself
                    return dispatcher;
                }
                else
                {
                    // !forwarded || !isForwardingPossible() can and needs to be handled by PortletRequestDispatcherImpl
                    // when the dispatch is going to be done using forward because that will require special overriding
                    // handling because of portlet spec requirements.
                    return new PortletRequestDispatcherImpl(dispatcher, false);
                }
            }
        }
        return null;
    }

    @Override
    public long getDateHeader(String name)
    {
        String value = portletRequest.getProperty(name);
        if (value == null)
        { 
            return (-1L);
        }
        // Attempt to convert the date header in a variety of formats
        return parseDateHeader(value);
    }

    @Override
    public String getAuthType()
    {
        return portletRequest.getAuthType();
    }

    @Override
    public Cookie[] getCookies()
    {
        return portletRequest.getCookies();
    }

    @Override
    public String getHeader(String name)
    {
        return portletRequest.getProperty(name);
    }

    @Override
    public Enumeration<String> getHeaderNames()
    {
        return portletRequest.getPropertyNames();
    }

    @Override
    public Enumeration<String> getHeaders(String name)
    {
        return portletRequest.getProperties(name);
    }

    @Override
    public int getIntHeader(String name)
    {
        String property = portletRequest.getProperty(name);
        if (property == null)
        {
            return -1;
        }
        return Integer.parseInt(property);
    }

    @Override
    public String getMethod()
    {
        return renderPhase ? "GET" : super.getMethod();
    }
    
    @Override
    public HttpSession getSession()
    {
        return session !=  null ? session : super.getSession();
    }

    @Override
    public HttpSession getSession(boolean create)
    {
        return session != null ? session : super.getSession(create);
    }

    @Override
    public String getRemoteUser()
    {
        return portletRequest.getRemoteUser();
    }

    @Override
    public String getRequestedSessionId()
    {
        return portletRequest.getRequestedSessionId();
    }

    @Override
    public StringBuffer getRequestURL()
    {
        return null;
    }

    @Override
    public Principal getUserPrincipal()
    {
        return portletRequest.getUserPrincipal();
    }

    @Override
    public boolean isRequestedSessionIdValid()
    {
        return portletRequest.isRequestedSessionIdValid();
    }

    @Override
    public boolean isUserInRole(String role)
    {
        return portletRequest.isUserInRole(role);
    }

    @Override
    public String getCharacterEncoding()
    {
        return clientDataRequest != null ? clientDataRequest.getCharacterEncoding() : null;
    }

    @Override
    public void setCharacterEncoding(String enc) throws UnsupportedEncodingException
    {
        if (clientDataRequest != null)
        {
            clientDataRequest.setCharacterEncoding(enc);
        }
    }    
    
    @Override
    public int getContentLength()
    {
        return clientDataRequest != null ? clientDataRequest.getContentLength() : 0;
    }

    @Override
    public String getContentType()
    {
        return clientDataRequest != null ? clientDataRequest.getContentType() : null;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException
    {
        return clientDataRequest != null ? (ServletInputStream)clientDataRequest.getPortletInputStream() : null;
    }

    @Override
    public String getLocalAddr()
    {
        return null;
    }

    @Override
    public Locale getLocale()
    {
        return portletRequest.getLocale();
    }

    @Override
    public Enumeration<Locale> getLocales()
    {
        return portletRequest.getLocales();
    }

    @Override
    public String getLocalName()
    {
        return null;
    }

    @Override
    public int getLocalPort()
    {
        return 0;
    }

    @Override
    public String getProtocol()
    {
        return "HTTP/1.1";
    }

    @Override
    public BufferedReader getReader() throws IOException
    {
        return clientDataRequest != null ? clientDataRequest.getReader() : null;
    }

    @Override
    public String getRealPath(String path)
    {
        return null;
    }

    @Override
    public String getRemoteAddr()
    {
        return null;
    }

    @Override
    public String getRemoteHost()
    {
        return null;
    }

    @Override
    public int getRemotePort()
    {
        return 0;
    }

    @Override
    public String getScheme()
    {
        return portletRequest.getScheme();
    }

    @Override
    public String getServerName()
    {
        return portletRequest.getServerName();
    }

    @Override
    public int getServerPort()
    {
        return portletRequest.getServerPort();
    }

    @Override
    public boolean isSecure()
    {
        return portletRequest.isSecure();
    }
}
