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




/**
 * The <CODE>PortletConfig</CODE> interface provides the portlet with
 * its configuration. The configuration holds information about the
 * portlet that is valid for all users. The configuration is retrieved
 * from the portlet definition in the deployment descriptor.
 * The portlet can only read the configuration data.
 * <p>
 * The configuration information contains the portlet name, the portlet 
 * initialization parameters, the portlet resource bundle and the portlet 
 * application context.
 * 
 * @see Portlet
 */
public interface PortletConfig
{


  /**
   * Returns the name of the portlet.
   * <P>
   * The name may be provided via server administration, assigned in the
   * portlet application deployment descriptor with the <code>portlet-name</code>
   * tag.
   *
   * @return   the portlet name
   */

  public String getPortletName ();


  /**
   * Returns the <code>PortletContext</code> of the portlet application 
   * the portlet is in.
   *
   * @return   a <code>PortletContext</code> object, used by the 
   *           caller to interact with its portlet container
   *
   * @see PortletContext
   */

  public PortletContext getPortletContext ();


  /**
   * Gets the resource bundle for the given locale based on the
   * resource bundle defined in the deployment descriptor
   * with <code>resource-bundle</code> tag or the inlined resources
   * defined in the deployment descriptor.
   *
   * @param    locale    the locale for which to retrieve the resource bundle
   * 
   * @return   the resource bundle for the given locale
   *
   */

  public java.util.ResourceBundle getResourceBundle(java.util.Locale locale);


  /**
   * Returns a String containing the value of the named initialization parameter, 
   * or null if the parameter does not exist.
   *
   * @param name	a <code>String</code> specifying the name
   *			of the initialization parameter
   *
   * @return		a <code>String</code> containing the value 
   *			of the initialization parameter
   *
   * @exception	java.lang.IllegalArgumentException	
   *                      if name is <code>null</code>.
   */

  public String getInitParameter(java.lang.String name);


  /**
   * Returns the names of the portlet initialization parameters as an 
   * <code>Enumeration</code> of String objects, or an empty <code>Enumeration</code> if the 
   * portlet has no initialization parameters.    
   *
   * @return		an <code>Enumeration</code> of <code>String</code> 
   *			objects containing the names of the portlet 
   *			initialization parameters, or an empty <code>Enumeration</code> if the 
   *                    portlet has no initialization parameters. 
   */

  public java.util.Enumeration<String> getInitParameterNames();
  

  /**
   * Returns the names of the public render parameters supported by the portlet
   * as an <code>Enumeration</code> of <code>String</code> objects, 
   * or an empty <code>Enumeration</code> if the 
   * portlet has not defined public render parameters.
   * <p>
   * Public render parameters are defined in the portlet deployment descriptor
   * with the <code>supported-public-render-parameter</code> element.    
   *
   * @return		an <code>Enumeration</code> of <code>String</code> 
   *			objects containing the names of the public 
   *			render parameters, or an empty <code>Enumeration</code> if the 
   *                    portlet has not defined support for any public render parameters
   *                    in the portlet deployment descriptor.
   * @since 2.0 
   */

  public java.util.Enumeration<String> getPublicRenderParameterNames();
  
  
  /**
   * Returns the default namespace for events and public render parameters.
   * This namespace is defined in the portlet deployment descriptor
   * with the <code>default-namespace</code> element.
   * <p>
   * If no default namespace is defined in the portlet deployment
   * descriptor this methods returns the XML default namespace 
   * <code>XMLConstants.NULL_NS_URI</code>.
   * 
   * @return the default namespace defined in the portlet deployment
   *         descriptor, or <code>XMLConstants.NULL_NS_URI</code> is non is
   *         defined.
   * @since 2.0
   */
  public java.lang.String getDefaultNamespace();
  
  
  /**
   * Returns the QNames of the publishing events supported by the portlet
   * as an <code>Enumeration</code> of <code>QName</code> objects, 
   * or an empty <code>Enumeration</code> if the 
   * portlet has not defined any publishing events.    
   * <p>
   * Publishing events are defined in the portlet deployment descriptor
   * with the <code>supported-publishing-event</code> element.    
   * <p>
   * Note that this call does not return any events published that have not been
   * declared in the deployment descriptor as supported.
   * <p>
   * If the event was defined using the <code>name</code> element instead of 
   * the <code>qname</code> element the defined default namespace 
   * is added as namespace for the returned QName.
   * 
   * @return		an <code>Enumeration</code> of <code>QName</code> 
   *			objects containing the names of the publishing events, 
   *			or an empty <code>Enumeration</code> if the 
   *                    portlet has not defined any support for publishing events in
   *                    the deployment descriptor.
   * @since 2.0 
   */
  public java.util.Enumeration<javax.xml.namespace.QName> getPublishingEventQNames();

  
  /**
   * Returns the QNames of the processing events supported by the portlet
   * as an <code>Enumeration</code> of <code>QName</code> objects, 
   * or an empty <code>Enumeration</code> if the 
   * portlet has not defined any processing events.    
   * <p>
   * Processing events are defined in the portlet deployment descriptor
   * with the <code>supported-processing-event</code> element.    
   * <p>
   * If the event was defined using the <code>name</code> element instead of 
   * the <code>qname</code> element the defined default namespace 
   * is added as namespace for the returned QName.
   *   
   * @return		an <code>Enumeration</code> of <code>QName</code> 
   *			objects containing the names of the processing events, 
   *			or an empty <code>Enumeration</code> if the 
   *                    portlet has not defined any support for processing events in
   *                    the deployment descriptor.
   * @since 2.0 
   */
  public java.util.Enumeration<javax.xml.namespace.QName> getProcessingEventQNames();

  /**
   * Returns the locales supported by the portlet
   * as an <code>Enumeration</code> of <code>Locale</code> objects, 
   * or an empty <code>Enumeration</code> if the 
   * portlet has not defined any supported locales.    
   * <p>
   * Supported locales are defined in the portlet deployment descriptor
   * with the <code>supported-locale</code> element.    
   * 
   * @return		an <code>Enumeration</code> of <code>Locale</code> 
   *			objects containing the supported locales, 
   *			or an empty <code>Enumeration</code> if the 
   *                    portlet has not defined any supported locales in
   *                    the deployment descriptor.
   * @since 2.0
   */
  public java.util.Enumeration<java.util.Locale> getSupportedLocales();
  
  /**
   * Returns the container runtime options
   * and values for this portlet.
   * <p>
   * The portlet can set container runtime
   * options in the <code>portlet.xml</code> via the
   * <code>container-runtime-option</code> element with a name and a
   * value on the application and portlet level.<br>
   * If a container runtime option is set on the portlet application 
   * level and on the portlet level with the same name the setting 
   * on the portlet level takes precedence and overwrites the one 
   * set on the portal application level.
   * <p>
   * The map returned from this method will provide the subset the
   * portlet container supports of the options the portlet has specified 
   * in the <code>portlet.xml</code>. Options that the portlet container
   * does not support will not be returned in this map.
   * <p>
   * The map will contain name of the runtime option as key of type String
   * and the runtime options as values of type String array (<code>String[]</code>)
   * with the values specified in the <code>portlet.xml</code> deployment descriptor.
   * 
   * @since 2.0
   *  
   * @return  an immutable <code>Map</code> containing portlet
   *          container runtime options names as keys and the 
   *          container runtime values as map values, or an empty <code>Map</code>
   *          if no portlet container runtime options are set
   *          in the <code>portlet.xml</code> or supported by this portlet container. 
   *          The keys in the map are of type String. The values in the map are of type
   *          String array (<code>String[]</code>).
   */
  public java.util.Map<String, String[]> getContainerRuntimeOptions();
}

