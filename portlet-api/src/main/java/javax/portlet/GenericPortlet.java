/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import javax.xml.namespace.QName;

/**
 * <span class="changed_modified_3_0">The</span>
 * <CODE>GenericPortlet</CODE> class provides a default implementation for
 * the <CODE>Portlet</CODE> interface.
 * <p>
 * It provides an abstract class to be subclassed to create portlets. A subclass
 * of <CODE>GenericPortlet</CODE> should either use one of the following annotations:
 * <ul>
 * <li><code>@ProcessAction</code></li>
 * <li><code>@ProcessEvent</code></li>
 * <li><code>@RenderMode</code></li>
 * </ul>
 * or override at least one method, usually
 * one of the following:
 * <ul>
 * <li>processAction, to handle action requests</li>
 * <li>doView, to handle render requests when in VIEW mode</li>
 * <li>doEdit, to handle render requests when in EDIT mode</li>
 * <li>doHelp, to handle render request when in HELP mode</li>
 * <li>init and destroy, to manage resources that are held for the life of the
 * servlet</li>
 * </ul>
 * <p>
 * Normally there is no need to override the render or the doDispatch methods.
 * Render handles render requests setting the title of the portlet in the
 * response and invoking doDispatch. doDispatch dispatches the request to one of
 * the doView, doEdit or doHelp method depending on the portlet mode indicated
 * in the request.
 * <p>
 * Portlets typically run on multithreaded servers, so please note that a
 * portlet must handle concurrent requests and be careful to synchronize access
 * to shared resources. Shared resources include in-memory data such as instance
 * or class variables and external objects such as files, database connections,
 * and network connections.
 */
public abstract class GenericPortlet implements Portlet, PortletConfig, EventPortlet, ResourceServingPortlet, HeaderPortlet {

   /**
    * <div class="changed_added_3_0">
    * This property is set by the container if the container
    * has a cached response for the given validation tag. The property can be
    * retrieved using the <code>getProperty</code> method. 
    * <P>
    * The value is <code>"javax.portlet.automaticResourceDispatching"</code>.
    * </div>
    * 
    * @since 3.0
    */
   public static final String AUTOMATIC_RESOURCE_DISPATCH = "javax.portlet.automaticResourceDispatching";

	private transient PortletConfig config;

	private transient Map<String, Method> processActionHandlingMethodsMap = new HashMap<String, Method>();
	private transient Map<String, Method> processEventHandlingMethodsMap = new HashMap<String, Method>();
	private transient Map<String, Method> renderModeHandlingMethodsMap = new HashMap<String, Method>();

	/**
	 * Does nothing.
	 */

	public GenericPortlet() {
	}

	/**
	 * Called by the portlet container to indicate to a portlet that the portlet
	 * is being placed into service.
	 * <p>
	 * The default implementation stores the <code>PortletConfig</code> object
	 * and checks for annotated methods with the annotations
	 * <ul>
	 * <li>@ProcessAction</li>
	 * <li>@ProcessEvent</li>
	 * <li>@RenderMode</li>
	 * </ul>
	 * and stores these in a hashmap for later dispatching.
	 * <p>
	 * The portlet container calls the <code>init</code> method exactly once
	 * after instantiating the portlet. The <code>init</code> method must
	 * complete successfully before the portlet can receive any requests.
	 * 
	 * <p>
	 * The portlet container cannot place the portlet into service if the
	 * <code>init</code> method does one of the following:
	 * <ol>
	 * <li>it throws a <code>PortletException</code>
	 * <li>it does not return within a time period defined by the Web server
	 * </ol>
	 * 
	 * 
	 * @param config
	 *            a <code>PortletConfig</code> object containing the portlet
	 *            configuration and initialization parameters
	 * 
	 * @exception PortletException
	 *                if an exception has occurred that interferes with the
	 *                portlet normal operation.
	 * @exception UnavailableException
	 *                if the portlet cannot perform the initialization at this
	 *                time.
	 */
	public void init(PortletConfig config) throws PortletException {
		this.config = config;
		cacheAnnotatedMethods();
		this.init();
	}


	/**
	 * 
	 * A convenience method which can be overridden so that there's no need to
	 * call <code>super.init(config)</code>.
	 * 
	 * <p>
	 * Instead of overriding {@link #init(PortletConfig)}, simply override this
	 * method and it will be called by
	 * <code>GenericPortlet.init(PortletConfig config)</code>. The
	 * <code>PortletConfig</code> object can still be retrieved via {@link
	 * #getPortletConfig}.
	 * 
	 * @exception PortletException
	 *                if an exception has occurred that interferes with the
	 *                portlet normal operation.
	 * @exception UnavailableException
	 *                if the portlet is unavailable to perform init
	 */
	public void init() throws PortletException {
	}

	/**
	 * Called by the portlet container to allow the portlet to process an action
	 * request. This method is called if the client request was originated by a
	 * URL created (by the portlet) with the
	 * <code>RenderResponse.createActionURL()</code> method.
	 * <p>
	 * The default implementation tries to dispatch to a method
	 * annotated with <code>@ProcessAction</code> that matches the action parameter 
	 * value <code>ActionRequest.ACTION_NAME</code> or, if no
	 * such method is found throws a <code>PortletException</code>.<br>
 	 * Note that the annotated methods needs to be public in order
	 * to be allowed to be called by <code>GenericPortlet</code>.

	 * 
	 * @param request
	 *            the action request
	 * @param response
	 *            the action response
	 * @exception PortletException
	 *                if the portlet cannot fulfill the request
	 * @exception UnavailableException
	 *                if the portlet is unavailable to process the action at
	 *                this time
	 * @exception PortletSecurityException
	 *                if the portlet cannot fulfill this request due to
	 *                security reasons
	 * @exception java.io.IOException
	 *                if the streaming causes an I/O problem
	 */
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException,
			java.io.IOException {
		@SuppressWarnings("deprecation")
		String action = request.getParameter(ActionRequest.ACTION_NAME);

		try {
			// check if action is cached
			Method actionMethod = processActionHandlingMethodsMap.get(action);
			if (actionMethod != null) {
				actionMethod.invoke(this, request, response);
				return;
			}
		} catch (Exception e) {
         // PORTLETSPEC3-23 : Allow annotated methods to throw PortletException and IOException
         if (e instanceof InvocationTargetException) {
            Throwable th = e.getCause();
            if (th != null) {
               if (th instanceof IOException) throw (IOException)th;
               if (th instanceof PortletException) throw (PortletException)th;
               if (th instanceof RuntimeException) throw (RuntimeException)th;
            }
         }
			throw new PortletException(e);
		}

		// if no action processing method was found throw exc
		throw new PortletException("processAction method not implemented");
	}

	/**
	 * V3 method implementing the headers stage within the render phase. The default
	 * implementation does nothing.
	 * <p>
	 * Version 3 portlets should override this method to set HTTP headers, cookies, and
	 * to provide markup for the overall document <code>HEAD</code> section.
	 */
   public void renderHeaders(HeaderRequest request, HeaderResponse response) throws PortletException, java.io.IOException {
   }


	/**
	 * The default implementation of this method sets the headers using the
	 * <code>doHeaders</code> method, sets the title using the
	 * <code>getTitle</code> method and invokes the <code>doDispatch</code>
	 * method.
	 * <p>
	 * It also evaluates the <code>RENDER_PART</code> request attribute and if
	 * set calls the <code>doHeaders, getNextPossiblePortletModes</code> and
	 * <code>getTitle</code> methods for the <code>RENDER_HEADERS</code>
	 * part and the <code>doDispatch</code> method for the
	 * <code>RENDER_MARKUP</code> part.<br>
	 * If the <code>RENDER_PART</code> request attribute is not set all of the
	 * above methods will be called.
	 * 
	 * @param request
	 *            the render request
	 * @param response
	 *            the render response
	 * 
	 * @exception PortletException
	 *                if the portlet cannot fulfill the request
	 * @exception UnavailableException
	 *                if the portlet is unavailable to perform render at this
	 *                time
	 * @exception PortletSecurityException
	 *                if the portlet cannot fulfill this request due to
	 *                security reasons
	 * @exception java.io.IOException
	 *                if the streaming causes an I/O problem
	 * 
	 */
	@SuppressWarnings("deprecation")
   public void render(RenderRequest request, RenderResponse response) throws PortletException, java.io.IOException {
		Object renderPartAttrValue = request.getAttribute(RenderRequest.RENDER_PART);
		if (renderPartAttrValue != null) {
			// streaming portal calling
			if (renderPartAttrValue.equals(RenderRequest.RENDER_HEADERS)) {
				doHeaders(request, response);
				Collection<PortletMode> nextModes = getNextPossiblePortletModes(request);
				if (nextModes != null)
					response.setNextPossiblePortletModes(nextModes);
				response.setTitle(getTitle(request));
			} else if (renderPartAttrValue.equals(RenderRequest.RENDER_MARKUP)) {
				doDispatch(request, response);
			} else {
				throw new PortletException("Unknown value of the 'javax.portlet.render_part' request attribute");
			}
		} else {
			// buffered portal calling
			doHeaders(request, response);
			Collection<PortletMode> nextModes = getNextPossiblePortletModes(request);
			if (nextModes != null)
				response.setNextPossiblePortletModes(nextModes);
			response.setTitle(getTitle(request));
			doDispatch(request, response);
		}
	}

	/**
	 * Used by the render method to get the title.
	 * <p>
	 * The default implementation gets the title from the ResourceBundle of the
	 * PortletConfig of the portlet. The title is retrieved using the
	 * 'javax.portlet.title' resource name.
	 * <p>
	 * Portlets can overwrite this method to provide dynamic titles (e.g. based
	 * on locale, client, and session information). Examples are:
	 * <UL>
	 * <LI>language-dependent titles for multi-lingual portals</li>
	 * <LI>shorter titles for WAP phones</li>
	 * <LI>the number of messages in a mailbox portlet</li>
	 * </UL>
	 * 
	 * @return the portlet title for this window
	 * @throws java.lang.IllegalStateException
	 *             if no portlet config object is available
	 */
	protected java.lang.String getTitle(RenderRequest request) {
		if (config == null)
			throw new java.lang.IllegalStateException(
					"Config is null, please ensure that your init(config) method calls super.init(config)");

		return config.getResourceBundle(request.getLocale()).getString("javax.portlet.title");
	}

	/**
	 * The default implementation of this method routes the render request to:
	 * <ol>
	 * <li>
	 * method annotated with <code>@RenderMode</code> and the name of the portlet mode
	 * </li>
	 * <li>
	 * a set of helper methods depending on the current portlet mode the portlet
	 * 		 is currently in. These methods are:
	 * 		<ul>
	 * 			<li><code>doView</code> for handling <code>view</code> requests</li>
	 * 			<li><code>doEdit</code> for handling <code>edit</code> requests</li>
	 * 			<li><code>doHelp</code> for handling <code>help</code> requests</li>
	 * 		</ul>
	 *	</li>
	 * </ol>
	 * <p>
	 * If the window state of this portlet is <code>minimized</code>, this
	 * method does not invoke any of the portlet mode rendering methods.
	 * <p>
	 * For handling custom portlet modes the portlet should either use the
	 * <code>@RenderMode</code> annotation or override this
	 * method. Note that the annotated methods needs to be public in order
	 * to be allowed to be called by <code>GenericPortlet</code>.
	 * 
	 * @param request
	 *            the render request
	 * @param response
	 *            the render response
	 * 
	 * @exception PortletException
	 *                if the portlet cannot fulfill the request
	 * @exception UnavailableException
	 *                if the portlet is unavailable to perform render at this
	 *                time
	 * @exception PortletSecurityException
	 *                if the portlet cannot fulfill this request due to
	 *                security reasons
	 * @exception java.io.IOException
	 *                if the streaming causes an I/O problem
	 * 
	 * @see #doView(RenderRequest, RenderResponse)
	 * @see #doEdit(RenderRequest, RenderResponse)
	 * @see #doHelp(RenderRequest, RenderResponse)
	 */
	protected void doDispatch(RenderRequest request, RenderResponse response) throws PortletException,
			java.io.IOException {
		WindowState state = request.getWindowState();

		if (!state.equals(WindowState.MINIMIZED)) {
			PortletMode mode = request.getPortletMode();
			// first look if there are methods annotated for
			// handling the rendering of this mode
			try {
				// check if mode is cached
				Method renderMethod = renderModeHandlingMethodsMap.get(mode.toString());
				if (renderMethod != null) {
					renderMethod.invoke(this, request, response);
					return;
				}
			} catch (Exception e) {
			   // PORTLETSPEC3-23 : Allow annotated methods to throw PortletException and IOException
			   if (e instanceof InvocationTargetException) {
			      Throwable th = e.getCause();
			      if (th != null) {
			         if (th instanceof IOException) throw (IOException)th;
			         if (th instanceof PortletException) throw (PortletException)th;
			         if (th instanceof RuntimeException) throw (RuntimeException)th;
			      }
			   }
				throw new PortletException(e);
			}

			// if not, try the default doXYZ methods
			if (mode.equals(PortletMode.VIEW)) {
				doView(request, response);
			} else if (mode.equals(PortletMode.EDIT)) {
				doEdit(request, response);
			} else if (mode.equals(PortletMode.HELP)) {
				doHelp(request, response);
			} else {
				throw new PortletException("unknown portlet mode: " + mode);
			}
		}
	}

	/**
	 * Helper method to serve up the mandatory <code>view</code> mode.
	 * <p>
	 * The default implementation throws an exception.
	 * 
	 * @param request
	 *            the portlet request
	 * @param response
	 *            the render response
	 * 
	 * @exception PortletException
	 *                if the portlet cannot fulfill the request
	 * @exception UnavailableException
	 *                if the portlet is unavailable to perform render at this
	 *                time
	 * @exception PortletSecurityException
	 *                if the portlet cannot fulfill this request due to
	 *                security reasons
	 * @exception java.io.IOException
	 *                if the streaming causes an I/O problem
	 * 
	 */
	protected void doView(RenderRequest request, RenderResponse response) throws PortletException, java.io.IOException {
		throw new PortletException("doView method not implemented");
	}

	/**
	 * Helper method to serve up the <code>edit</code> mode.
	 * <p>
	 * The default implementation throws an exception.
	 * 
	 * @param request
	 *            the portlet request
	 * @param response
	 *            the render response
	 * 
	 * @exception PortletException
	 *                if the portlet cannot fulfill the request
	 * @exception UnavailableException
	 *                if the portlet is unavailable to perform render at this
	 *                time
	 * @exception PortletSecurityException
	 *                if the portlet cannot fulfill this request due to
	 *                security reasons
	 * @exception java.io.IOException
	 *                if the streaming causes an I/O problem
	 * 
	 */
	protected void doEdit(RenderRequest request, RenderResponse response) throws PortletException, java.io.IOException {
		throw new PortletException("doEdit method not implemented");
	}

	/**
	 * Helper method to serve up the <code>help</code> mode.
	 * <p>
	 * The default implementation throws an exception.
	 * 
	 * @param request
	 *            the portlet request
	 * @param response
	 *            the render response
	 * 
	 * @exception PortletException
	 *                if the portlet cannot fulfill the request
	 * @exception UnavailableException
	 *                if the portlet is unavailable to perform render at this
	 *                time
	 * @exception PortletSecurityException
	 *                if the portlet cannot fulfill this request due to
	 *                security reasons
	 * @exception java.io.IOException
	 *                if the streaming causes an I/O problem
	 */
	protected void doHelp(RenderRequest request, RenderResponse response) throws PortletException, java.io.IOException {
		throw new PortletException("doHelp method not implemented");
	}

	/**
	 * Returns the PortletConfig object of this portlet.
	 * 
	 * @return the PortletConfig object of this portlet
	 */
	public PortletConfig getPortletConfig() {
		return config;
	}

	/**
	 * Called by the portlet container to indicate to a portlet that the portlet
	 * is being taken out of service.
	 * <p>
	 * The default implementation does nothing.
	 * 
	 */
	public void destroy() {
		// do nothing
	}

	// -------------------------------------------------------------------------
	// implement PortletConfig
	// -------------------------------------------------------------------------

	/**
	 * Returns the name of this portlet.
	 * 
	 * @return the portlet name
	 * 
	 * @see PortletConfig#getPortletName()
	 */
	public String getPortletName() {
		if (config == null)
			throw new java.lang.IllegalStateException(
					"Config is null, please ensure that your init(config) method calls super.init(config)");

		return config.getPortletName();
	}

	/**
	 * Returns the <code>PortletContext</code> of the portlet application the
	 * portlet is in.
	 * 
	 * @return the portlet application context
	 */
	public PortletContext getPortletContext() {
		if (config == null)
			throw new java.lang.IllegalStateException(
					"Config is null, please ensure that your init(config) method calls super.init(config)");

		return config.getPortletContext();
	}

	/**
	 * Gets the resource bundle for the given locale based on the resource
	 * bundle defined in the deployment descriptor with
	 * <code>resource-bundle</code> tag or the inlined resources defined in
	 * the deployment descriptor.
	 * 
	 * @return the resource bundle for the given locale
	 */
	public java.util.ResourceBundle getResourceBundle(java.util.Locale locale) {
		if (config == null)
			throw new java.lang.IllegalStateException(
					"Config is null, please ensure that your init(config) method calls super.init(config)");

		return config.getResourceBundle(locale);
	}

	/**
	 * Returns a String containing the value of the named initialization	 * parameter, or null if the parameter does not exist.
	 * 
	 * @param name
	 *            a <code>String</code> specifying the name of the
	 *            initialization parameter
	 * 
	 * @return a <code>String</code> containing the value of the
	 *         initialization parameter
	 * 
	 * @exception java.lang.IllegalArgumentException
	 *                if name is <code>null</code>.
	 */
	public String getInitParameter(java.lang.String name) {
		if (config == null)
			throw new java.lang.IllegalStateException(
					"Config is null, please ensure that your init(config) method calls super.init(config)");

		return config.getInitParameter(name);
	}

	/**
	 * Returns the names of the portlet initialization parameters as an
	 * Enumeration of String objects, or an empty Enumeration if the portlet has
	 * no initialization parameters.
	 * 
	 * @return an <code>Enumeration</code> of <code>String</code> objects
	 *         containing the names of the portlet initialization parameters, or
	 *         an empty Enumeration if the portlet has no initialization
	 *         parameters.
	 */
	public java.util.Enumeration<String> getInitParameterNames() {
		if (config == null)
			throw new java.lang.IllegalStateException(
					"Config is null, please ensure that your init(config) method calls super.init(config)");

		return config.getInitParameterNames();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.portlet.PortletConfig#getProcessingEventQNames()
	 */
	public Enumeration<QName> getProcessingEventQNames() {
		if (config == null)
			throw new java.lang.IllegalStateException(
					"Config is null, please ensure that your init(config) method calls super.init(config)");

		return config.getProcessingEventQNames();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.portlet.PortletConfig#getPublishingEventQNames()
	 */
	public Enumeration<QName> getPublishingEventQNames() {
		if (config == null)
			throw new java.lang.IllegalStateException(
					"Config is null, please ensure that your init(config) method calls super.init(config)");

		return config.getPublishingEventQNames();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.portlet.PortletConfig#getSupportedLocales()
	 */
	public Enumeration<Locale> getSupportedLocales() {
		if (config == null)
			throw new java.lang.IllegalStateException(
					"Config is null, please ensure that your init(config) method calls super.init(config)");

		return config.getSupportedLocales();
	}

	/* (non-Javadoc)
	 * @see javax.portlet.PortletConfig#getContainerRuntimeOptions()
	 */
	public Map<String, String[]> getContainerRuntimeOptions() {
		return config.getContainerRuntimeOptions();
	}

	// -------------------------------------------------------------------------
	// V 2.0 additions
	// -------------------------------------------------------------------------

	/**
	 * Default resource serving.
	 * <p>
	 * The default implementation of this method does nothing.
	 * <p>
	 * However, if the reserved portlet initialization parameter 
	 * {@link #AUTOMATIC_RESOURCE_DISPATCH} 
	 * (= "javax.portlet.automaticResourceDispatching")
	 * is set to <code>true</code>, the default
	 * implementation will perform a
	 * <code>PortletRequestDispatcher.forward</code> to the location designated by
	 * the ResourceID of the ResourceRequest.
	 * If no ResourceID is set on the resource URL the default implementation
	 * does nothing.
	 * 
	 * @since 2.0
	 */
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
	   String autofwd = getInitParameter(AUTOMATIC_RESOURCE_DISPATCH);
	   if (autofwd != null && autofwd.equalsIgnoreCase("true")) {
		if (request.getResourceID() != null) {
			PortletRequestDispatcher rd = getPortletConfig().getPortletContext().getRequestDispatcher(
					request.getResourceID());
			if (rd != null)
				rd.forward(request, response);
		}
	}
	}

	/**
	 * The default implementation tries to dispatch to a method
	 * annotated with <code>@ProcessEvent</code> that matches the 
	 * event name or, if no
	 * such method is found just sets the current render parameters on
	 * the response.<br>
 	 * Note that the annotated methods needs to be public in order
	 * to be allowed to be called by <code>GenericPortlet</code>.
	 * 
	 * @see javax.portlet.EventPortlet#processEvent(javax.portlet.EventRequest,
	 *      javax.portlet.EventResponse)
	 * @since 2.0
	 */
	@SuppressWarnings("deprecation")
	public void processEvent(EventRequest request, EventResponse response) throws PortletException, IOException {
		String eventName = request.getEvent().getQName().toString();

		try {
			// check for exact match
			Method eventMethod = processEventHandlingMethodsMap.get(eventName);
			if (eventMethod != null) {
				eventMethod.invoke(this, request, response);
				return;
			} else {
				// Search for the longest possible matching wildcard annotation
				int endPos = eventName.indexOf('}');
				int dotPos = eventName.lastIndexOf('.');
				while (dotPos > endPos) {
					String wildcardLookup = eventName.substring(0, dotPos + 1);
					eventMethod = processEventHandlingMethodsMap.get(wildcardLookup);
					if (eventMethod != null) {
						eventMethod.invoke(this, request, response);
						return;
					}
					if (dotPos == 0) {
						break;
					}
					dotPos = eventName.lastIndexOf('.', dotPos - 1);
				}
			}
		} catch (Exception e) {
         // PORTLETSPEC3-23 : Allow annotated methods to throw PortletException and IOException
         if (e instanceof InvocationTargetException) {
            Throwable th = e.getCause();
            if (th != null) {
               if (th instanceof IOException) throw (IOException)th;
               if (th instanceof PortletException) throw (PortletException)th;
               if (th instanceof RuntimeException) throw (RuntimeException)th;
            }
         }
			throw new PortletException(e);
		}

		// if no event processing method was found just keep render params
		response.setRenderParameters(request);
	}

	/**
    * <span class="changed_modified_3_0">Used</span>
	 * by the render method to set the response properties and headers.
	 * <p>
	 * The portlet should override this method and set its response header using
	 * this method in order to ensure that they are set before anything is
	 * written to the output stream.
	 * <p>
	 * The default implemention of this method is emtpy.
	 * 
	 * @param request  the render request
	 * @param response the render response
    * 
    * @exception PortletException
    *                <span class="changed_added_3_0">if the portlet cannot fulfill the request</span>
    * @exception UnavailableException
    *                <span class="changed_added_3_0">if the portlet is unavailable to perform render at this
    *                time</span>
    * @exception PortletSecurityException
    *                <span class="changed_added_3_0">if the portlet cannot fulfill this request due to
    *                security reasons</span>
    * @exception java.io.IOException
    *                <span class="changed_added_3_0">if the streaming causes an I/O problem</span>
	 * @since 2.0
	 */
	protected void doHeaders(RenderRequest request, RenderResponse response) 
	      throws PortletException, java.io.IOException {
		return;
	}

	/**
	 * Used by the render method to set the next possible portlet modes.
	 * <p>
	 * The portlet should override this method and set the next possible portlet
	 * modes using this method in order to ensure that they are set before
	 * anything is written to the output stream.
	 * <p>
	 * The default implemention of this method returns <code>null</code>.
	 * 
	 * @since 2.0
	 */
	protected java.util.Collection<PortletMode> getNextPossiblePortletModes(RenderRequest request) {
		return null;
	}

	/**
	 * Returns the names of the public render parameters supported by the
	 * portlet as an <code>Enumeration</code> of String objects, or an empty
	 * <code>Enumeration</code> if the portlet has no public render
	 * parameters.
	 * 
	 * @return an <code>Enumeration</code> of <code>String</code> objects
	 *         containing the names of the public render parameters, or an empty
	 *         <code>Enumeration</code> if the portlet does not define any
	 *         public render parameters.
	 * 
	 * @see javax.portlet.PortletConfig#getPublicRenderParameterNames()
	 */
	public Enumeration<String> getPublicRenderParameterNames() {
		if (config == null)
			throw new java.lang.IllegalStateException(
					"Config is null, please ensure that your init(config) method calls super.init(config)");

		return config.getPublicRenderParameterNames();
	}

	/**
	 * Returns the default namespace for events and public parameters. This
	 * namespace is defined in the portlet deployment descriptor with the
	 * <code>default-namespace</code> element.
	 * <p>
	 * If no default namespace is defined in the portlet deployment descriptor
	 * this methods returns the XML default namespace
	 * <code>XMLConstants.NULL_NS_URI</code>.
	 * 
	 * @return the default namespace defined in the portlet deployment
	 *         descriptor, or <code>XMLConstants.NULL_NS_URI</code> is non is
	 *         defined.
	 * 
	 * @see javax.portlet.PortletConfig#getDefaultNamespace()
	 */
	public String getDefaultNamespace() {
		if (config == null)
			throw new java.lang.IllegalStateException(
					"Config is null, please ensure that your init(config) method calls super.init(config)");

		return config.getDefaultNamespace();
	}

	// -------------------------------------------------------------------------
   // V 3.0 additions
   // -------------------------------------------------------------------------


     /**
      * <div class="changed_added_3_0"> 
      * Returns an <code>Enumeration</code> of PortletMode objects that are defined
      * for the portlet for the given MIME type. 
      * <p>
      * Note that a supported portlet mode may not be allowed in all situations
      * due to security or other reasons. To
      * determine whether a portlet mode is allowed during a request, use the
      * {@link PortletRequest#isPortletModeAllowed(PortletMode)} method. 
      * To determine which portlet modes are supported by the portal, use
      * {@link PortalContext#getSupportedPortletModes()}  
      * </div>
      * 
      * @param mimeType    MIME type
      *
      *
      * @since 3.0
	   * 
	   * @see PortletMode
	   * @see PortletRequest#isPortletModeAllowed(PortletMode)
	   * 
	   * @return      an <code>Enumeration</code> of <code>PortletMode</code> 
	   *        objects containing the defined and supported portlet modes.
	   */
	  public java.util.Enumeration<PortletMode> getPortletModes(String mimeType) {
	      if (config == null)
	         throw new java.lang.IllegalStateException(
	               "Config is null, please ensure that your init(config) method calls super.init(config)");
	      return config.getPortletModes(mimeType);
	  }


	  /**
      * <div class="changed_added_3_0"> 
      * Returns an <code>Enumeration</code> of WindowState objects that are defined
      * for the portlet for the given MIME type. 
      * <p>
      * Note that a supported window state may not be allowed in all situations
      * due to security or other reasons. To
      * determine whether a window state is allowed during a request, use the
      * {@link PortletRequest#isWindowStateAllowed(WindowState)} method. 
      * To determine which window states are supported by the portal, use
      * {@link PortalContext#getSupportedWindowStates()}. 
      * </div>
      * 
      * @param mimeType    MIME type
	   * @since 3.0
	   * 
	   * @see WindowState
	   * @see PortletRequest#isWindowStateAllowed(WindowState)
	   * 
	   * @return      an <code>Enumeration</code> of <code>WindowState</code> 
	   *        objects containing the defined and supported window states.
	   */
	  public java.util.Enumeration<WindowState> getWindowStates(String mimeType) {
        if (config == null)
           throw new java.lang.IllegalStateException(
                 "Config is null, please ensure that your init(config) method calls super.init(config)");
        return config.getWindowStates(mimeType);
	  }


	  /**
	   * <div class="changed_added_3_0"> 
	   * Returns a Map of public render parameter names to their qualified names.
	   * The names are the values returned by the 
	   * {@link PortletConfig#getPublicRenderParameterNames()} method.
	   * The values are the <code>QName</code> values associated with the public 
	   * render parameter. 
	   * <p>
	   * If the public render parameter is specified in the portlet descriptor
	   * using the <code>&lt.name&gt.</code> tag rather than the 
	   * <code>&lt.qname&gt.</code> tag, the QName is built from the default namespace
	   * from the deployment descriptor
	   * together with the value from the <code>&lt.name&gt.</code> tag.
	   * </div>
	   * 
	   * @since 3.0
	   * 
	   * @see PortletConfig#getPublicRenderParameterNames()
	   * 
	   * @return      an <code>Map</code> of <code>String</code> to <code>QName</code> 
	   */
	  public Map<String, QName> getPublicRenderParameterDefinitions() {
        if (config == null)
           throw new java.lang.IllegalStateException(
                 "Config is null, please ensure that your init(config) method calls super.init(config)");
        return config.getPublicRenderParameterDefinitions();
	  }

	
	/**
	 * <div class="changed_added_3_0">
	 * Dispatches an action request to an annotated action method.
	 * <p>
	 * Retrieves an action method annotated with the provided name and
	 * invokes it. Returns <code>true</code> if the method could be 
	 * successfully located and invoked, and <code>false</code> if no
	 * annotated action method by that name could be found.
	 * <p>
	 * This method allows a portlet to extend annotation processing 
	 * for the action method. 
	 * </div>
	 * 
	 * @param name      Annotation name
	 * @param request   Action request
	 * @param response  Action response
    * 
    * @return 
    *    <code>true</code>, if the request was dispatched,
    *    <code>false</code>, if no annotated method matching the specified action 
    *                        method name could be found.
    *
    * @exception PortletException
    *                if the portlet cannot fulfill the request
    * @exception UnavailableException
    *                if the portlet is unavailable to process the action at
    *                this time
    * @exception PortletSecurityException
    *                if the portlet cannot fulfill this request due to
    *                security reasons
    * @exception java.io.IOException
    *                if the streaming causes an I/O problem
    * 
    * @see #processAction(ActionRequest, ActionResponse)
    * 
    * @since 3.0
    */
	protected boolean dispatchAnnotatedActionMethod(String name, ActionRequest request, 
	      ActionResponse response) throws PortletException, java.io.IOException {
	   
	   boolean methodInvoked = false;
	   
      try {
         // check if action is cached
         Method actionMethod = processActionHandlingMethodsMap.get(name);
         if (actionMethod != null) {
            actionMethod.invoke(this, request, response);
            methodInvoked = true;
         }
      } catch (Exception e) {
         // PORTLETSPEC3-23 : Allow annotated methods to throw PortletException and IOException
         if (e instanceof InvocationTargetException) {
            Throwable th = e.getCause();
            if (th != null) {
               if (th instanceof IOException) throw (IOException)th;
               if (th instanceof PortletException) throw (PortletException)th;
               if (th instanceof RuntimeException) throw (RuntimeException)th;
            }
         }
         throw new PortletException(e);
      }
      return methodInvoked;
	}

   
   /**
    * <div class="changed_added_3_0">
    * Dispatches an event request to an annotated event method.
    * <p>
    * Retrieves an action method annotated with the provided name and
    * invokes it. Returns <code>true</code> if the method could be 
    * successfully located and invoked, and <code>false</code> if no
    * annotated event method by that name could be found.
    * <p>
    * This method allows a portlet to extend annotation processing 
    * for portlet events.
    * </div>
    * 
    * @param name      Annotation name
    * @param request   Event request
    * @param response  Event response
    * 
    * @return 
    *    <code>true</code>, if the request was dispatched,
    *    <code>false</code>, if no annotated method matching the specified event 
    *                        method name could be found.
    *
    * @exception PortletException
    *                if the portlet cannot fulfill the request
    * @exception UnavailableException
    *                if the portlet is unavailable to process the action at
    *                this time
    * @exception PortletSecurityException
    *                if the portlet cannot fulfill this request due to
    *                security reasons
    * @exception java.io.IOException
    *                if the streaming causes an I/O problem
    * 
    * @see #processEvent(EventRequest, EventResponse)
    * 
    * @since 3.0
    */
   protected boolean dispatchAnnotatedEventMethod(String name, EventRequest request, 
         EventResponse response) throws PortletException, java.io.IOException {
      
      boolean methodInvoked = false;
      
      String eventName = request.getEvent().getQName().toString();

      try {
         // check for exact match
         Method eventMethod = processEventHandlingMethodsMap.get(eventName);
         if (eventMethod != null) {
            eventMethod.invoke(this, request, response);
            methodInvoked = true;
         }
      } catch (Exception e) {
         // PORTLETSPEC3-23 : Allow annotated methods to throw PortletException and IOException
         if (e instanceof InvocationTargetException) {
            Throwable th = e.getCause();
            if (th != null) {
               if (th instanceof IOException) throw (IOException)th;
               if (th instanceof PortletException) throw (PortletException)th;
               if (th instanceof RuntimeException) throw (RuntimeException)th;
            }
         }
         throw new PortletException(e);
      }

      return methodInvoked;
   }

   
   /**
    * <div class="changed_added_3_0">
    * Dispatches an render request to an annotated render method.
    * <p>
    * Retrieves an render method annotated with the provided name and
    * invokes it. Returns <code>true</code> if the method could be 
    * successfully located and invoked, and <code>false</code> if no
    * annotated render method by that name could be found.
    * <p>
    * This method allows a portlet to extend annotation processing 
    * for the render methods. 
    * </div>
    * 
    * @param name      Annotation name
    * @param request   Render request
    * @param response  Render response
    * 
    * @return 
    *    <code>true</code>, if the request was dispatched,
    *    <code>false</code>, if no annotated method matching the specified render 
    *                        method name could be found.
    *
    * @exception PortletException
    *                if the portlet cannot fulfill the request
    * @exception UnavailableException
    *                if the portlet is unavailable to process the render at
    *                this time
    * @exception PortletSecurityException
    *                if the portlet cannot fulfill this request due to
    *                security reasons
    * @exception java.io.IOException
    *                if the streaming causes an I/O problem
    * 
    * @see #doDispatch(RenderRequest, RenderResponse)
    * 
    * @since 3.0
    */
   protected boolean dispatchAnnotatedRenderMethod(String name, RenderRequest request, 
         RenderResponse response) throws PortletException, java.io.IOException {
      
      boolean methodInvoked = false;
      
      try {
         // check if action is cached
         Method renderMethod = renderModeHandlingMethodsMap.get(name);
         if (renderMethod != null) {
            renderMethod.invoke(this, request, response);
            methodInvoked = true;
         }
      } catch (Exception e) {
         // PORTLETSPEC3-23 : Allow annotated methods to throw PortletException and IOException
         if (e instanceof InvocationTargetException) {
            Throwable th = e.getCause();
            if (th != null) {
               if (th instanceof IOException) throw (IOException)th;
               if (th instanceof PortletException) throw (PortletException)th;
               if (th instanceof RuntimeException) throw (RuntimeException)th;
            }
         }
         throw new PortletException(e);
      }
      
      return methodInvoked;
   }

   
   // -------------------------------------------------------------------------
   // Private Methods
   // -------------------------------------------------------------------------

	private void cacheAnnotatedMethods() {
		// cache all annotated and visible public methods
		for (Method method : this.getClass().getMethods()) {
			Annotation[] annotations = method.getAnnotations();
			if (annotations != null) {
				for (Annotation annotation : annotations) {
					Class<? extends Annotation> annotationType = annotation.annotationType();
					if (ProcessAction.class.equals(annotationType)) {
						String name = ((ProcessAction) annotation).name();
						if (name != null && name.length() > 0) {
						   // PORTLETSPEC3-15
							addToMap(processActionHandlingMethodsMap, name, method);
						}
					} else if (ProcessEvent.class.equals(annotationType)) {
						String qname = ((ProcessEvent) annotation).qname();
						if (qname == null || qname.length() <= 0) {
							if (config == null)
								throw new java.lang.IllegalStateException(
										"Config is null, please ensure that your init(config) method calls super.init(config)");

							String name = ((ProcessEvent) annotation).name();
							if (name != null && name.length() > 0) {
								qname = new QName(config.getDefaultNamespace(), name).toString();
								// PORTLETSPEC3-15
								addToMap(processEventHandlingMethodsMap, qname, method);
							}
						} else {
						   // PORTLETSPEC3-15
							addToMap(processEventHandlingMethodsMap, qname, method);
							}
					} else if (RenderMode.class.equals(annotationType)) {
						String name = ((RenderMode) annotation).name();
						if (name != null && name.length() > 0) {
						   // PORTLETSPEC3-15
							addToMap(renderModeHandlingMethodsMap, name.toLowerCase(), method);
						}
					}
					}
				}
			}
		}
	
   // PORTLETSPEC3-15: An annotation in a subclass should override the same 
   // annotation in a superclass, however, getMethods() returns the methods in no order.
	private void addToMap(Map<String, Method> map, String name, Method newMethod) {
      Method mapMethod = map.get(name);

      // Adds new method to map if method does not exist in map
      // or if class of new method is subclass of class of method in map.
	   if ((mapMethod != null) && (newMethod != null)) {
	      
	      // get the class hierarchy. 
	      ArrayList<Class<?>> classHierarchy = new ArrayList<Class<?>>();
	      for (Class<?> cls=this.getClass(); cls != null; cls=cls.getSuperclass()) {
	         classHierarchy.add(cls);
	      }
	      
	      int classLevelMap = classHierarchy.indexOf(mapMethod.getDeclaringClass());
	      int classLevelNew = classHierarchy.indexOf(newMethod.getDeclaringClass());
	      if (classLevelMap <= classLevelNew) {
	         return;
	      }
	   }
	   map.put(name, newMethod);
	}
}
