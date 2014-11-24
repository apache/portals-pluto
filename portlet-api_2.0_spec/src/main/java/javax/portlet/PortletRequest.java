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

import java.util.Locale;


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
   * Used to retrieve an instance of the <code>javax.ccpp.Profile</code>
   * with the <code>getAttribute</code> call. The returned profile is based
   * on the current portlet request and may contain additional CC/PP 
   * information set by the portal / portlet container.   
   * <p>
   * The value is <code>javax.portlet.ccpp</code>.
   * 
   * @since 2.0
   */
  public static final String CCPP_PROFILE = "javax.portlet.ccpp";

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
   * P3P user information constants.
   * <p>
   * Note: these are only available in the Java SE 5.0 supported version
   * of the API.
   * 
   * @since 2.0
   */
  public enum P3PUserInfos {
      USER_BDATE_YMD_YEAR("user.bdate.ymd.year"), USER_BDATE_YMD_MONTH("user.bdate.ymd.month"),
      USER_BDATE_YMD_DAY("user.bdate.ymd.day"), USER_BDATE_HMS_HOUR("user.bdate.hms.hour"),
	  USER_BDATE_HMS_MINUTE("user.bdate.hms.minute"), USER_BDATE_HMS_SECOND("user.bdate.hms.second"),
	  USER_BDATE_FRACTIONSECOND("user.bdate.fractionsecond"), USER_BDATE_TIMEZONE("user.bdate.timezone"),
	  USER_GENDER("user.gender"), USER_EMPLOYER("user.employer"), 
      USER_DEPARTMENT("user.department"), USER_JOBTITLE("user.jobtitle"), 
      USER_NAME_PREFIX("user.name.prefix"), USER_NAME_GIVEN("user.name.given"), 
      USER_NAME_FAMILY("user.name.family"), USER_NAME_MIDDLE("user.name.middle"),
      USER_NAME_SUFFIX("user.name.suffix"), USER_NAME_NICKNAME("user.name.nickName"),
      USER_LOGIN_ID("user.login.id"),
      USER_HOMEINFO_POSTAL_NAME("user.home-info.postal.name"), 
      USER_HOMEINFO_POSTAL_STREET("user.home-info.postal.street"),
      USER_HOMEINFO_POSTAL_CITY("user.home-info.postal.city"), 
      USER_HOMEINFO_POSTAL_STATEPROV("user.home-info.postal.stateprov"),
      USER_HOMEINFO_POSTAL_POSTALCODE("user.home-info.postal.postalcode"),
      USER_HOMEINFO_POSTAL_COUNTRY("user.home-info.postal.country"), 
      USER_HOMEINFO_POSTAL_ORGANIZATION("user.home-info.postal.organization"), 
      USER_HOMEINFO_TELECOM_TELEPHONE_INTCODE("user.home-info.telecom.telephone.intcode"),
      USER_HOMEINFO_TELECOM_TELEPHONE_LOCCODE("user.home-info.telecom.telephone.loccode"),
      USER_HOMEINFO_TELECOM_TELEPHONE_NUMBER("user.home-info.telecom.telephone.number"),
      USER_HOMEINFO_TELECOM_TELEPHONE_EXT("user.home-info.telecom.telephone.ext"),
      USER_HOMEINFO_TELECOM_TELEPHONE_COMMENT("user.home-info.telecom.telephone.comment"),
      USER_HOMEINFO_TELECOM_FAX_INTCODE("user.home-info.telecom.fax.intcode"),
      USER_HOMEINFO_TELECOM_FAX_LOCCODE("user.home-info.telecom.fax.loccode"),
      USER_HOMEINFO_TELECOM_FAX_NUMBER("user.home-info.telecom.fax.number"),
      USER_HOMEINFO_TELECOM_FAX_EXT("user.home-info.telecom.fax.ext"),
      USER_HOMEINFO_TELECOM_FAX_COMMENT("user.home-info.telecom.fax.comment"),
      USER_HOMEINFO_TELECOM_MOBILE_INTCODE("user.home-info.telecom.mobile.intcode"),
      USER_HOMEINFO_TELECOM_MOBILE_LOCCODE("user.home-info.telecom.mobile.loccode"),
      USER_HOMEINFO_TELECOM_MOBILE_NUMBER("user.home-info.telecom.mobile.number"),
      USER_HOMEINFO_TELECOM_MOBILE_EXT("user.home-info.telecom.mobile.ext"),
      USER_HOMEINFO_TELECOM_MOBILE_COMMENT("user.home-info.telecom.mobile.comment"),
      USER_HOMEINFO_TELECOM_PAGER_INTCODE("user.home-info.telecom.pager.intcode"),
      USER_HOMEINFO_TELECOM_PAGER_LOCCODE("user.home-info.telecom.pager.loccode"),
      USER_HOMEINFO_TELECOM_PAGER_NUMBER("user.home-info.telecom.pager.number"),
      USER_HOMEINFO_TELECOM_PAGER_EXT("user.home-info.telecom.pager.ext"),
      USER_HOMEINFO_TELECOM_PAGER_COMMENT("user.home-info.telecom.pager.comment"),
      USER_HOMEINFO_ONLINE_EMAIL("user.home-info.online.email"),
      USER_HOMEINFO_ONLINE_URI("user.home-info.online.uri"),
      USER_BUSINESSINFO_POSTAL_NAME("user.business-info.postal.name"), 
      USER_BUSINESSINFO_POSTAL_STREET("user.business-info.postal.street"),
      USER_BUSINESSINFO_POSTAL_CITY("user.business-info.postal.city"), 
      USER_BUSINESSINFO_POSTAL_STATEPROV("user.business-info.postal.stateprov"),
      USER_BUSINESSINFO_POSTAL_POSTALCODE("user.business-info.postal.postalcode"),
      USER_BUSINESSINFO_POSTAL_COUNTRY("user.business-info.postal.country"), 
      USER_BUSINESSINFO_POSTAL_ORGANIZATION("user.business-info.postal.organization"), 
      USER_BUSINESSINFO_TELECOM_TELEPHONE_INTCODE("user.business-info.telecom.telephone.intcode"),
      USER_BUSINESSINFO_TELECOM_TELEPHONE_LOCCODE("user.business-info.telecom.telephone.loccode"),
      USER_BUSINESSINFO_TELECOM_TELEPHONE_NUMBER("user.business-info.telecom.telephone.number"),
      USER_BUSINESSINFO_TELECOM_TELEPHONE_EXT("user.business-info.telecom.telephone.ext"),
      USER_BUSINESSINFO_TELECOM_TELEPHONE_COMMENT("user.business-info.telecom.telephone.comment"),
      USER_BUSINESSINFO_TELECOM_FAX_INTCODE("user.business-info.telecom.fax.intcode"),
      USER_BUSINESSINFO_TELECOM_FAX_LOCCODE("user.business-info.telecom.fax.loccode"),
      USER_BUSINESSINFO_TELECOM_FAX_NUMBER("user.business-info.telecom.fax.number"),
      USER_BUSINESSINFO_TELECOM_FAX_EXT("user.business-info.telecom.fax.ext"),
      USER_BUSINESSINFO_TELECOM_FAX_COMMENT("user.business-info.telecom.fax.comment"),
      USER_BUSINESSINFO_TELECOM_MOBILE_INTCODE("user.business-info.telecom.mobile.intcode"),
      USER_BUSINESSINFO_TELECOM_MOBILE_LOCCODE("user.business-info.telecom.mobile.loccode"),
      USER_BUSINESSINFO_TELECOM_MOBILE_NUMBER("user.business-info.telecom.mobile.number"),
      USER_BUSINESSINFO_TELECOM_MOBILE_EXT("user.business-info.telecom.mobile.ext"),
      USER_BUSINESSINFO_TELECOM_MOBILE_COMMENT("user.business-info.telecom.mobile.comment"),
      USER_BUSINESSINFO_TELECOM_PAGER_INTCODE("user.business-info.telecom.pager.intcode"),
      USER_BUSINESSINFO_TELECOM_PAGER_LOCCODE("user.business-info.telecom.pager.loccode"),
      USER_BUSINESSINFO_TELECOM_PAGER_NUMBER("user.business-info.telecom.pager.number"),
      USER_BUSINESSINFO_TELECOM_PAGER_EXT("user.business-info.telecom.pager.ext"),
      USER_BUSINESSINFO_TELECOM_PAGER_COMMENT("user.business-info.telecom.pager.comment"),
      USER_BUSINESSINFO_ONLINE_EMAIL("user.business-info.online.email"),
      USER_BUSINESSINFO_ONLINE_URI("user.business-info.online.uri");
      P3PUserInfos(String value) {this.value = value; }
      private final String value;
      public String toString() {return value;}
  }
  
  /**
   * String identifier for the portlet action lifecycle phase. In this
   * phase the portlet request and response are from type
   * <code>ActionRequest</code> and <code>ActionResponse</code>.
   * <p>
   * The value of the constant is <code>ACTION_PHASE</code>.
   * 
   * @since 2.0
   */
  public static final String ACTION_PHASE = "ACTION_PHASE";
  
  /**
   * String identifier for the portlet event lifecycle phase. In this
   * phase the portlet request and response are from type
   * <code>EventRequest</code> and <code>EventResponse</code>.
   * <p>
   * The value of the constant is <code>EVENT_PHASE</code>.
   * 
   * @since 2.0
   */
  public static final String EVENT_PHASE = "EVENT_PHASE";
  
  /**
   * String identifier for the portlet render lifecycle phase. In this
   * phase the portlet request and response are from type
   * <code>RenderRequest</code> and <code>RenderResponse</code>.
   * <p>
   * The value of the constant is <code>RENDER_PHASE</code>.
   * 
   * @since 2.0
   */
  public static final String RENDER_PHASE = "RENDER_PHASE";
  
  /**
   * String identifier for the portlet resource serving lifecycle phase. In this
   * phase the portlet request and response are from type
   * <code>ResourceRequest</code> and <code>ResourceResponse</code>.
   * <p>
   * The value of the constant is <code>RESOURCE_PHASE</code>.
   * 
   * @since 2.0
   */
  public static final String RESOURCE_PHASE = "RESOURCE_PHASE";
    
  /**
   * Provides the portlet lifecycle phase of the current request
   * as request attribute.
   * <p>
   * Valid values are: ACTION_PHASE, EVENT_PHASE, RENDER_PHASE,
   * RESOURCE_SERVING_PHASE.
   * <p>
   * The value of the constant is <code>javax.portlet.lifecylce_phase</code>.
   * 
   * @since 2.0
   */
  public static final String LIFECYCLE_PHASE = "javax.portlet.lifecycle_phase";
  
  
  /**
   * The RENDER_PART portlet request attribute is set by portals
   * that are streaming based and therefore need to split the
   * render phase into two parts: first the RENDER_HEADERS part
   * where the portlet should only set the header related data
   * and the portlet title, and second the RENDER_MARKUP part
   * in which the portlet should produce its markup.
   * <p>
   * Non-streaming portals will not set this attribute and thus
   * the portlet should set headers, portlet title and produce
   * its markup in a single render request.
   * <p>
   * The value of the constant is <code>javax.portlet.render_part</code>.
   * 
   *  @since 2.0
   */
  public static final String RENDER_PART = "javax.portlet.render_part";
  
  /**
   * The RENDER_HEADERS is a possible value of the RENDER_PART
   * request attribute and denotes that the portlet should set
   * the intended headers and the portlet title of this render
   * request.
   * <p>
   * The value of the constant is <code>RENDER_HEADERS</code>.
   * 
   * @since 2.0
   */
  public static final String RENDER_HEADERS = "RENDER_HEADERS";

  /**
   * The RENDER_MARKUP is a possible value of the RENDER_PART
   * request attribute and denotes that the portlet should
   * produce its markup for this render request.
   * <p>
   * The value of the constant is <code>RENDER_MARKUP</code>.
   * 
   * @since 2.0
   */
  public static final String RENDER_MARKUP = "RENDER_MARKUP";

  /**
   * The action scope ID that the portlet container uses
   * for storing the current action scope as render parameter
   * if the <code>javax.portlet.actionScopedRequestAttributes</code>
   * container runtime option is used by the portlet.
   * <p>
   * The value is <code>javax.portlet.as</code>.
   * @since 2.0
   */
  public static final String ACTION_SCOPE_ID = "javax.portlet.as";
  
  
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
   * If the request did not include any properties
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
  
  public java.util.Enumeration<String> getProperties(String name); 
    
    
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

  public java.util.Enumeration<String> getPropertyNames();
    
    
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
  
  public java.util.Enumeration<String> getAttributeNames();


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

  public java.util.Enumeration<String> getParameterNames();


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

  public java.util.Map<String, String[]> getParameterMap();


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
   * The following restrictions apply:
   * <ul>
   * <li>The content type only includes the MIME type, not the
   * character set. The character set of the response
   * can be retrieved via the {@link RenderResponse#getCharacterEncoding}.</li>
   * <li>Only content types that the portlet has defined in its
   * deployment descriptor are valid return values for
   * this method call. If the portlet has defined
   * <code>'*'</code> or <code>'* / *'</code> as supported content
   * types, these may also be valid return values.</li>
   * </ul>
   * 
   * @return preferred MIME type of the response
   */

  public String getResponseContentType();


  /**
   * Gets a list of content types which the portal accepts for the response.
   * This list is ordered with the most preferable types listed first.
   * <p>
   * The following restrictions apply:
   * <ul>
   * <li>The content type only includes the MIME type, not the
   * character set.</li>
   * <li>Only content types that the portlet has defined in its
   * deployment descriptor are valid return values for
   * this method call. If the portlet has defined
   * <code>'*'</code> or <code>'* / *'</code> as supported content
   * types, these may also be valid return values.</li>
   * </ul>
   *
   * @return ordered list of MIME types for the response
   */

  public java.util.Enumeration<String> getResponseContentTypes();


  /**
   * Returns the preferred Locale in which the portal will accept content.
   * The Locale may be based on the Accept-Language header of the client.
   *
   * @return  the preferred Locale in which the portal will accept content.
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

  public java.util.Enumeration<Locale> getLocales();


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
   * <p>
   * This ID is the same that is used by the portlet container for
   * scoping the portlet-scope session attributes.
   * 
   * @since 2.0
   * @return  the portlet window ID
   */
  public String getWindowID();
  
  
  /**
   * Returns an array containing all of the Cookie properties. 
   * <p>
   * This method returns <code>null</code> if no cookies exist.
   * 
   * @since 2.0
   * @return  array of cookie properties, or 
   *          <code>null</code> if no cookies exist.
   * @see MimeResponse#addProperty(Cookie) 
   */
  public javax.servlet.http.Cookie[] getCookies();
  
  /**
   * Returns a <code>Map</code> of the private parameters of this request.
   * Private parameters are not shared with other portlets or components.  
   * The returned parameters are "x-www-form-urlencoded" decoded.
   * <p>
   * The values in the returned <code>Map</code> are from type
   * String array (<code>String[]</code>).
   * <p>
   * If no private parameters exist this method returns an empty <code>Map</code>.
   *
   * @since 2.0
   * @return     an immutable <code>Map</code> containing private parameter names as 
   *             keys and private parameter values as map values, or an empty <code>Map</code>
   *             if no private parameters exist. The keys in the parameter
   *             map are of type String. The values in the parameter map are of type
   *             String array (<code>String[]</code>).
   */
  public java.util.Map<String, String[]> getPrivateParameterMap();
  
  /**
   * Returns a <code>Map</code> of the public parameters of this request.
   * Public parameters may be shared with other portlets or components and
   * defined in the portlet deployment descriptor with the 
   * <code>supported-public-render-parameter</code> element.  
   * The returned parameters are "x-www-form-urlencoded" decoded.
   * <p>
   * The values in the returned <code>Map</code> are from type
   * String array (<code>String[]</code>).
   * <p>
   * If no public parameters exist this method returns an empty <code>Map</code>.
   *
   * @since 2.0
   * @return     an immutable <code>Map</code> containing public parameter names as 
   *             keys and public parameter values as map values, or an empty <code>Map</code>
   *             if no public parameters exist. The keys in the parameter
   *             map are of type String. The values in the parameter map are of type
   *             String array (<code>String[]</code>).
   */
  public java.util.Map<String, String[]> getPublicParameterMap();

}
