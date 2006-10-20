/*
 * Copyright 2006 The Apache Software Foundation
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
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */
/*
 * Copyright 2006 IBM Corporation.
 */
package javax.portlet;


/**
 * The <CODE>PortletRequest</CODE> defines the base interface to provide client
 * request information to a portlet. The portlet container uses two specialized
 * versions of this interface when invoking a portlet, <CODE>ActionRequest</CODE>
 * and <CODE>RenderRequest</CODE>. The portlet container creates these objects and 
 * passes them as  arguments to the portlet's <CODE>processAction</CODE> and
 * <CODE>render</CODE> methods.
 * 
 * @see ActionRequest
 * @see RenderRequest
 */
public interface PortletRequest
{

  /** Used to retrieve user information attributes with the 
   * <code>getAttribute</code> call. The user information is returned 
   * as a <code>Map</code> object. The portlet must define the 
   * user information attribute it is interested in inside the 
   * <code>user-attribute</code> section of the deployment descriptor.
   * If an attribute is not supported
   * by the current runtime system it will not show up in the user
   * attribute map.<BR>
   * If the user-attribute is supported by the runtime system, but not 
   * defined for a particular user, then for that user the attribute 
   * exists in the returned map and the attribute has a <code>null</code> value.
   * <p>
   * If the user-attribute is not defined for the current user it
   * will not show up in the Map.
   * <p>
   * The value is <code>javax.portlet.userinfo</code>.
   */
  public static final String USER_INFO = "javax.portlet.userinfo";


  /**
   * String identifier for Basic authentication. Value "BASIC".
   */
  public static final String BASIC_AUTH = "BASIC";

  /**
   * String identifier for Form based authentication. Value "FORM".
   */
  public static final String FORM_AUTH = "FORM";

  /**
   * String identifier for Certification based authentication. Value "CLIENT_CERT".
   */
  public static final String CLIENT_CERT_AUTH = "CLIENT_CERT";

  /**
   * String identifier for Digest based authentication. Value "DIGEST".
   */
  public static final String DIGEST_AUTH = "DIGEST";


  /**
   * Returns true, if the given window state is valid
   * to be set for this portlet in the context
   * of the current request.
   *
   * @param  state    window state to checked
   *
   * @return    true, if it is valid for this portlet
   *             in this request to change to the
   *            given window state
   *
   */
  public boolean isWindowStateAllowed(WindowState state);


/**
   * Returns true, if the given portlet mode is a valid
   * one to set for this portlet  in the context
   * of the current request.
   *
   * @param  mode    portlet mode to check
   *
   * @return    true, if it is valid for this portlet
   *             in this request to change to the
   *            given portlet mode
   *
   */

  public boolean isPortletModeAllowed(PortletMode mode);


  /**
   * Returns the current portlet mode of the portlet.
   *
   * @return   the portlet mode
   */

  public PortletMode getPortletMode ();


  /**
   * Returns the current window state of the portlet.
   *
   * @return   the window state
   */

  public WindowState getWindowState ();


  /**
   * Returns the preferences object associated with the portlet.
   *
   * @return the portlet preferences
   */
  public PortletPreferences getPreferences ();


  /**
   * Returns the current portlet session or, if there is no current session,
   * creates one and returns the new session.
   *  <p>
   * Creating a new portlet session will result in creating
   * a new <code>HttpSession</code> on which the portlet session is based on.
   *
   * @return the portlet session
   */

  public PortletSession getPortletSession ();


  /**
   * Returns the current portlet session or, if there is no current session
   * and the given flag is <CODE>true</CODE>, creates one and returns
   * the new session.
   * <P>
   * If the given flag is <CODE>false</CODE> and there is no current
   * portlet session, this method returns <CODE>null</CODE>.
   *  <p>
   * Creating a new portlet session will result in creating
   * a new <code>HttpSession</code> on which the portlet session is based on.
   * 
   * @param create
   *               <CODE>true</CODE> to create a new session, <BR>
   *               <CODE>false</CODE> to return <CODE>null</CODE> if there
   *               is no current session
   * @return the portlet session
   * 
   */

  public PortletSession getPortletSession (boolean create);


  /**
   * Returns the value of the specified request property
   * as a <code>String</code>. If the request did not include a property
   * of the specified name, this method returns <code>null</code>.
   * <p>
   * A portlet can access portal/portlet-container specific properties 
   * through this method and, if available, the
   * headers of the HTTP client request.
   * <p>
   * This method should only be used if the 
   * property has only one value. If the property might have
   * more than one value, use {@link #getProperties}.
   * <p>
   * If this method is used with a multivalued
   * parameter, the value returned is equal to the first value
   * in the Enumeration returned by <code>getProperties</code>.
   *
   * @param name		a <code>String</code> specifying the
   *				property name
   *
   * @return			a <code>String</code> containing the
   *				value of the requested
   *				property, or <code>null</code>
   *				if the request does not
   *				have a property of that name.
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if name is <code>null</code>.
   */			

  public String getProperty(String name); 


  /**
   * Returns all the values of the specified request property
   * as a <code>Enumeration</code> of <code>String</code> objects.
   * <p>
   * If the request did not include any propertys
   * of the specified name, this method returns an empty
   * <code>Enumeration</code>.
   * The property name is case insensitive. You can use
   * this method with any request property.
   *
   * @param name		a <code>String</code> specifying the
   *				property name
   *
   * @return		a <code>Enumeration</code> containing
   *                  	the values of the requested property. If
   *                  	the request does not have any properties of
   *                  	that name return an empty <code>Enumeration</code>.
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if name is <code>null</code>.
   */			
  
  public java.util.Enumeration getProperties(String name); 
    
    
  /**
   *
   * Returns a <code>Enumeration</code> of all the property names
   * this request contains. If the request has no
   * properties, this method returns an empty <code>Enumeration</code>.
   *
   *
   * @return			an <code>Enumeration</code> of all the
   *				property names sent with this
   *				request; if the request has
   *				no properties, an empty <code>Enumeration</code>.
   */

  public java.util.Enumeration getPropertyNames();
    
    
  /**
   * Returns the context of the calling portal.
   *
   * @return the context of the calling portal
   */

  public PortalContext getPortalContext();


  /**
   * Returns the name of the authentication scheme used for the 
   * connection between client and portal,
   * for example, <code>BASIC_AUTH</code>, <code>CLIENT_CERT_AUTH</code>, 
   * a custom one or <code>null</code> if there was no authentication.
   *
   * @return		one of the static members <code>BASIC_AUTH</code>, 
   *			<code>FORM_AUTH</code>, <code>CLIENT_CERT_AUTH</code>, 
   *                    <code>DIGEST_AUTH</code> (suitable for == comparison) 
   *			indicating the authentication scheme, 
   *                    a custom one, or 
   *			<code>null</code> if the request was 
   *			not authenticated.     
   */

  public java.lang.String getAuthType();
  

   /**
    * Returns the context path which is the path prefix associated with the deployed 
    * portlet application. If the portlet application is rooted at the
    * base of the web server URL namespace (also known as "default" context), 
    * this path must be an empty string. Otherwise, it must be the path the
    * portlet application is rooted to, the path must start with a '/' and 
    * it must not end with a '/' character.
    * <p>
    * To encode a URL the {@link PortletResponse#encodeURL} method must be used.
    *
    * @return		a <code>String</code> specifying the
    *			portion of the request URL that indicates the context
    *			of the request
    *
    * @see PortletResponse#encodeURL
    */

  public String getContextPath();


  /**
   * Returns the login of the user making this request, if the user 
   * has been authenticated, or null if the user has not been authenticated.
   *
   * @return		a <code>String</code> specifying the login
   *			of the user making this request, or <code>null</code>
   *			if the user login is not known.
   *
   */

  public java.lang.String getRemoteUser();


  /**
   * Returns a java.security.Principal object containing the name of the 
   * current authenticated user.
   *
   * @return		a <code>java.security.Principal</code> containing
   *			the name of the user making this request, or
   *			<code>null</code> if the user has not been 
   *			authenticated.
   */

  public java.security.Principal getUserPrincipal();


  /**
   * Returns a boolean indicating whether the authenticated user is 
   * included in the specified logical "role".  Roles and role membership can be
   * defined using deployment descriptors.  If the user has not been
   * authenticated, the method returns <code>false</code>.
   *
   * @param role		a <code>String</code> specifying the name
   *				of the role
   *
   * @return		a <code>boolean</code> indicating whether
   *			the user making this request belongs to a given role;
   *			<code>false</code> if the user has not been 
   *			authenticated.
   */

  public boolean isUserInRole(java.lang.String role);


  /**
   *
   * Returns the value of the named attribute as an <code>Object</code>,
   * or <code>null</code> if no attribute of the given name exists. 
   * <p>
   * Attribute names should follow the same conventions as package
   * names. This specification reserves names matching <code>java.*</code>,
   * and <code>javax.*</code>. 
   * <p>
   * In a distributed portlet web application the <code>Object</code>
   * needs to be serializable.
   *
   * @param name	a <code>String</code> specifying the name of 
   *			the attribute
   *
   * @return		an <code>Object</code> containing the value 
   *			of the attribute, or <code>null</code> if
   *			the attribute does not exist.
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if name is <code>null</code>.
   *
   */

  public Object getAttribute(String name);


  /**
   * Returns an <code>Enumeration</code> containing the
   * names of the attributes available to this request. 
   * This method returns an empty <code>Enumeration</code>
   * if the request has no attributes available to it.
   * 
   *
   * @return		an <code>Enumeration</code> of strings 
   *			containing the names 
   * 			of the request attributes, or an empty 
   *                    <code>Enumeration</code> if the request 
   *                    has no attributes available to it.
   */
  
  public java.util.Enumeration getAttributeNames();


  /**
   * Returns the value of a request parameter as a <code>String</code>,
   * or <code>null</code> if the parameter does not exist. Request parameters
   * are extra information sent with the request. The returned parameter 
   * are "x-www-form-urlencoded" decoded.
   * <p>
   * Only parameters targeted to the current portlet are accessible.
   * <p>
   * This method should only be used if the 
   * parameter has only one value. If the parameter might have
   * more than one value, use {@link #getParameterValues}.
   * <p>
   * If this method is used with a multivalued
   * parameter, the value returned is equal to the first value
   * in the array returned by <code>getParameterValues</code>.
   *
   *
   *
   * @param name 	a <code>String</code> specifying the 
   *			name of the parameter
   *
   * @return		a <code>String</code> representing the 
   *			single value of the parameter
   *
   * @see 		#getParameterValues
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if name is <code>null</code>.
   *
   */
  
  public String getParameter(String name);


  /**
   *
   * Returns an <code>Enumeration</code> of <code>String</code>
   * objects containing the names of the parameters contained
   * in this request. If the request has 
   * no parameters, the method returns an 
   * empty <code>Enumeration</code>. 
   * <p>
   * Only parameters targeted to the current portlet are returned.
   *
   *
   * @return		an <code>Enumeration</code> of <code>String</code>
   *			objects, each <code>String</code> containing
   * 			the name of a request parameter; or an 
   *			empty <code>Enumeration</code> if the
   *			request has no parameters.
   */

  public java.util.Enumeration getParameterNames();


  /**
   * Returns an array of <code>String</code> objects containing 
   * all of the values the given request parameter has, or 
   * <code>null</code> if the parameter does not exist.
   * The returned parameters are "x-www-form-urlencoded" decoded.
   * <p>
   * If the parameter has a single value, the array has a length
   * of 1.
   *
   *
   * @param name	a <code>String</code> containing the name of 
   *			the parameter the value of which is requested
   *
   * @return		an array of <code>String</code> objects 
   *			containing the parameter values.
   *
   * @see		#getParameter
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if name is <code>null</code>.
   *
   */

  public String[] getParameterValues(String name);


  /** 
   * Returns a <code>Map</code> of the parameters of this request.
   * Request parameters are extra information sent with the request.  
   * The returned parameters are "x-www-form-urlencoded" decoded.
   * <p>
   * The values in the returned <code>Map</code> are from type
   * String array (<code>String[]</code>).
   * <p>
   * If no parameters exist this method returns an empty <code>Map</code>.
   *
   * @return     an immutable <code>Map</code> containing parameter names as 
   *             keys and parameter values as map values, or an empty <code>Map</code>
   *             if no parameters exist. The keys in the parameter
   *             map are of type String. The values in the parameter map are of type
   *             String array (<code>String[]</code>).
   */

  public java.util.Map getParameterMap();


  /**
   * Returns a boolean indicating whether this request was made 
   * using a secure channel between client and the portal, such as HTTPS.
   * 
   * @return  true, if the request was made using a secure channel.
   */

  public boolean isSecure();


  /**
   * Stores an attribute in this request.
   *
   * <p>Attribute names should follow the same conventions as
   * package names. Names beginning with <code>java.*</code>,
   * <code>javax.*</code>, and <code>com.sun.*</code> are
   * reserved.
   *<br> If the value passed into this method is <code>null</code>, 
   * the effect is the same as calling {@link #removeAttribute}.
   *
   *
   * @param name			a <code>String</code> specifying 
   *					the name of the attribute
   *
   * @param o				the <code>Object</code> to be stored
   *
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if name is <code>null</code>.
   */
  
  public void setAttribute(String name, Object o);


  /**
   *
   * Removes an attribute from this request.  This method is not
   * generally needed, as attributes only persist as long as the request
   * is being handled.
   *
   * <p>Attribute names should follow the same conventions as
   * package names. Names beginning with <code>java.*</code>,
   * <code>javax.*</code>, and <code>com.sun.*</code> are
   * reserved.
   *
   * @param name			a <code>String</code> specifying 
   *					the name of the attribute to be removed
   *
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if name is <code>null</code>.
   */

  public void removeAttribute(String name);

   
  /**
   *
   * Returns the session ID indicated in the client request.
   * This session ID may not be a valid one, it may be an old 
   * one that has expired or has been invalidated.
   * If the client request
   * did not specify a session ID, this method returns
   * <code>null</code>.
   *
   * @return		a <code>String</code> specifying the session
   *			ID, or <code>null</code> if the request did
   *			not specify a session ID
   *
   * @see		#isRequestedSessionIdValid
   *
   */

  public String getRequestedSessionId();


  /**
   *
   * Checks whether the requested session ID is still valid.
   *
   * @return			<code>true</code> if this
   *				request has an id for a valid session
   *				in the current session context;
   *				<code>false</code> otherwise
   *
   * @see			#getRequestedSessionId
   * @see			#getPortletSession
   */

  public boolean isRequestedSessionIdValid();


  /**
   * Returns the portal preferred content type for the response.
   * <p>
   * The content type only includes the MIME type, not the
   * character set.
   * <p>
   * Only content types that the portlet has defined in its
   * deployment descriptor are valid return values for
   * this method call. If the portlet has defined
   * <code>'*'</code> or <code>'* / *'</code> as supported content
   * types, these may also be valid return values.
   *
   * @return preferred MIME type of the response
   */

  public String getResponseContentType();


  /**
   * Gets a list of content types which the portal accepts for the response.
   * This list is ordered with the most preferable types listed first.
   * <p>
   * The content type only includes the MIME type, not the
   * character set.
   * <p>
   * Only content types that the portlet has defined in its
   * deployment descriptor are valid return values for
   * this method call. If the portlet has defined
   * <code>'*'</code> or <code>'* / *'</code> as supported content
   * types, these may also be valid return values.
   *
   * @return ordered list of MIME types for the response
   */

  public java.util.Enumeration getResponseContentTypes();


  /**
   * Returns the preferred Locale in which the portal will accept content.
   * The Locale may be based on the Accept-Language header of the client.
   *
   * @return  the prefered Locale in which the portal will accept content.
   */

  public java.util.Locale getLocale();


  /**
   * Returns an Enumeration of Locale objects indicating, in decreasing
   * order starting with the preferred locale in which the portal will
   * accept content for this request.
   * The Locales may be based on the Accept-Language header of the client.
   * 
   * @return  an Enumeration of Locales, in decreasing order, in which 
   *           the portal will accept content for this request
   */

  public java.util.Enumeration getLocales();


  /**
   * Returns the name of the scheme used to make this request.
   * For example, <code>http</code>, <code>https</code>, or <code>ftp</code>.
   * Different schemes have different rules for constructing URLs,
   * as noted in RFC 1738.
   *
   * @return		a <code>String</code> containing the name 
   *			of the scheme used to make this request
   */

  public String getScheme();
    

  /**
   * Returns the host name of the server that received the request.
   *
   * @return		a <code>String</code> containing the name 
   *			of the server to which the request was sent
   */

  public String getServerName();
    
    
  /**
   * Returns the port number on which this request was received.
   *
   * @return		an integer specifying the port number
   */

  public int getServerPort();

  /**
   * Returns the portlet window ID. The portlet window ID is 
   * unique for this portlet window and is constant for the lifetime
   * of the portlet window.
   * 
   * @since 2.0
   * @return  the portlet window ID
   */
  public String getWindowId();
  
}
