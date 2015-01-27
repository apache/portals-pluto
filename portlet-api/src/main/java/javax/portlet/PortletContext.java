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

import java.net.MalformedURLException;




/**
 * The <CODE>PortletContext</CODE> interface defines a portlet view
 * of the portlet container.
 * The <CODE>PortletContext</CODE> also makes resources available
 * to the portlet. Using the context, a portlet can access
 * the portlet log, and obtain URL references to resources.
 * 
 * <p>There is one context per "portlet application" per Java Virtual Machine.  (A
 * "portlet application" is a collection of portlets, servlets, and content installed
 * under a specific subset of the server URL namespace, such as <code>/catalog</code>.
 * They are possibly installed via a <code>.war</code> file.)
 * As a web application, a portlet application also has a servlet context.
 * The portlet context leverages most of its functionality from the
 * servlet context of the portlet application.
 * <p>
 * Attributes stored in the context are global for <I>all</I> users and <I>all</I>
 * components in the portlet application.
 * <p>
 * In the case of a web
 * application marked "distributed" in its deployment descriptor, there will
 * be one context instance for each virtual machine.  In this situation, the
 * context cannot be used as a location to share global information (because
 * the information is not truly global). Use an external resource, such as
 * a database to achieve sharing on a global scope.
 */
public interface PortletContext
{

  /**
   * Returns the name and version of the portlet container in which the
   * portlet is running.
   *
   * <P>
   * The form of the returned string is <code>containername/versionnumber</code>.
   *
   *
   * @return   the string containing at least name and version number
   */
  
  public String getServerInfo ();

  /**
   * Returns a {@link PortletRequestDispatcher} object that acts
   * as a wrapper for the resource located at the given path.
   * A <code>PortletRequestDispatcher</code> object can be used include the
   * resource in a response. The resource can be dynamic or static.
   * 
   * <p>The pathname must begin with a slash (<code> / </code>) and is interpreted as relative
   * to the current context root.
   * 
   * <p>This method returns <code>null</code> if the <code>PortletContext</code>
   * cannot return a <code>PortletRequestDispatcher</code>
   * for any reason.
   * 
   *
   * @param path   a <code>String</code> specifying the pathname
   *               to the resource
   * @return a <code>PortletRequestDispatcher</code> object
   *         that acts as a wrapper for the resource
   *         at the specified path.
   * @see PortletRequestDispatcher
   */

  public PortletRequestDispatcher getRequestDispatcher(String path);



  /**
   * Returns a {@link PortletRequestDispatcher} object that acts
   * as a wrapper for the named servlet.
   *
   * <p>Servlets (and also JSP pages) may be given names via server 
   * administration or via a web application deployment descriptor.
   *
   * <p>This method returns <code>null</code> if the 
   * <code>PortletContext</code> cannot return a 
   * <code>PortletRequestDispatcher</code> for any reason.
   *
   *
   * @param name 	a <code>String</code> specifying the name
   *			of a servlet to be wrapped
   *
   * @return 		a <code>PortletRequestDispatcher</code> object
   *			that acts as a wrapper for the named servlet
   *
   * @see 		PortletRequestDispatcher
   *
   */

  public PortletRequestDispatcher getNamedDispatcher(String name);


  /**
   * Returns the resource located at the given path as an InputStream object.
   * The data in the InputStream can be of any type or length. The method returns 
   * null if no resource exists at the given path.
   * <p>
   * In order to access protected resources the path has to be prefixed with 
   * <code>/WEB-INF/</code> (for example <code>/WEB-INF/myportlet/myportlet.jsp</code>). 
   * Otherwise, the direct path is used
   * (for example <code>/myportlet/myportlet.jsp</code>).
   *
   * @param path     the path to the resource
   *
   * @return    the input stream
   */
  public java.io.InputStream getResourceAsStream (String path);



  /**
   * Returns the major version of the Portlet API that this portlet
   * container supports.
   *
   * @return   the major version
   *
   * @see   #getMinorVersion()
   */

  public int getMajorVersion ();


  /**
   * Returns the minor version of the Portlet API that this portlet
   * container supports.
   *
   * @return   the minor version
   *
   * @see   #getMajorVersion()
   */

  public int getMinorVersion ();


  /**
   * Returns the MIME type of the specified file, or <code>null</code> if 
   * the MIME type is not known. The MIME type is determined
   * by the configuration of the portlet container and may be specified
   * in a web application deployment descriptor. Common MIME
   * types are <code>text/html</code> and <code>image/gif</code>.
   *
   *
   * @param   file    a <code>String</code> specifying the name
   *			of a file
   *
   * @return 		a <code>String</code> specifying the MIME type of the file
   *
   */

  public String getMimeType(String file);

  
  /**
   * Returns a <code>String</code> containing the real path 
   * for a given virtual path. For example, the path <code>/index.html</code>
   * returns the absolute file path of the portlet container file system.
   *
   * <p>The real path returned will be in a form
   * appropriate to the computer and operating system on
   * which the portlet container is running, including the
   * proper path separators. This method returns <code>null</code>
   * if the portlet container cannot translate the virtual path
   * to a real path for any reason (such as when the content is
   * being made available from a <code>.war</code> archive).
   *
   * @param path 	a <code>String</code> specifying a virtual path
   *
   * @return 		a <code>String</code> specifying the real path,
   *                    or null if the transformation cannot be performed.
   */
  
  public String getRealPath(String path);

  
  /**
   * Returns a directory-like listing of all the paths to resources within 
   * the web application longest sub-path of which 
   * matches the supplied path argument. Paths indicating subdirectory paths 
   * end with a slash (<code>/</code>). The returned paths are all 
   * relative to the root of the web application and have a leading slash. 
   * For example, for a web application 
   * containing<br><br>
   * <code>
   * /welcome.html<br>
   * /catalog/index.html<br>
   * /catalog/products.html<br>
   * /catalog/offers/books.html<br>
   * /catalog/offers/music.html<br>
   * /customer/login.jsp<br>
   * /WEB-INF/web.xml<br>
   * /WEB-INF/classes/com.acme.OrderPortlet.class,<br><br>
   * </code>
   *
   * <code>getResourcePaths("/")</code> returns 
   * <code>{"/welcome.html", "/catalog/", "/customer/", "/WEB-INF/"}</code><br>
   * <code>getResourcePaths("/catalog/")</code> returns 
   * <code>{"/catalog/index.html", "/catalog/products.html", "/catalog/offers/"}</code>.<br>
   *
   * @param     path
   *              the partial path used to match the resources, which must start with a slash
   * @return     a Set containing the directory listing, or <code>null</code> if there 
   *             are no resources in the web application of which the path
   *             begins with the supplied path.
   */
    
  public java.util.Set<String> getResourcePaths(String path);
    

  
  /**
   * Returns a URL to the resource that is mapped to a specified
   * path. The path must begin with a slash (<code>/</code>) and is interpreted
   * as relative to the current context root.
   *
   * <p>This method allows the portlet container to make a resource 
   * available to portlets from any source. Resources 
   * can be located on a local or remote
   * file system, in a database, or in a <code>.war</code> file. 
   *
   * <p>The portlet container must implement the URL handlers
   * and <code>URLConnection</code> objects that are necessary
   * to access the resource.
   *
   * <p>This method returns <code>null</code>
   * if no resource is mapped to the pathname.
   *
   * <p>Some containers may allow writing to the URL returned by
   * this method using the methods of the URL class.
   *
   * <p>The resource content is returned directly, so be aware that 
   * requesting a <code>.jsp</code> page returns the JSP source code.
   * Use a <code>RequestDispatcher</code> instead to include results of 
   * an execution.
   *
   * <p>This method has a different purpose than
   * <code>java.lang.Class.getResource</code>,
   * which looks up resources based on a class loader. This
   * method does not use class loaders.
   * 
   * @param path 				a <code>String</code> specifying
   *						the path to the resource
   *
   * @return 					the resource located at the named path,
   * 						or <code>null</code> if there is no resource
   *						at that path
   *
   * @exception MalformedURLException 	        if the pathname is not given in 
   * 						the correct form
   *
   */
    
  public java.net.URL getResource(String path) throws java.net.MalformedURLException;


  /**
   * Returns the portlet container attribute with the given name, 
   * or null if there is no attribute by that name.
   * An attribute allows a portlet container to give the
   * portlet additional information not
   * already provided by this interface.
   * A list of supported attributes can be retrieved using
   * <code>getAttributeNames</code>.
   *
   * <p>The attribute is returned as a <code>java.lang.Object</code>
   * or some subclass.
   * Attribute names should follow the same convention as package
   * names. The Java Portlet API specification reserves names
   * matching <code>java.*</code>, <code>javax.*</code>,
   * and <code>sun.*</code>.
   *
   *
   * @param name 	a <code>String</code> specifying the name 
   *			of the attribute
   *
   * @return 		an <code>Object</code> containing the value 
   *			of the attribute, or <code>null</code>
   *			if no attribute exists matching the given
   *			name
   *
   * @see 		#getAttributeNames
   *
   * @exception	java.lang.IllegalArgumentException	
   *                      if name is <code>null</code>.
   */

  public java.lang.Object getAttribute(java.lang.String name);
  

  /**
   * Returns an <code>Enumeration</code> containing the attribute names 
   * available within this portlet context, or an empty
   * <code>Enumeration</code> if no attributes are available. Use the
   * {@link #getAttribute} method with an attribute name
   * to get the value of an attribute.
   *
   * @return 		an <code>Enumeration</code> of attribute names
   *
   * @see		#getAttribute
   */

  public java.util.Enumeration<String> getAttributeNames();


  /**
   * Returns a String containing the value of the named context-wide 
   * initialization parameter, or <code>null</code> if the parameter does not exist.
   * This method provides configuration information which may be useful for 
   * an entire "portlet application".
   *
   * @param	name	a <code>String</code> containing the name of the
   *                    requested parameter 
   * 
   * @return 		a <code>String</code> containing the value
   *			of the initialization parameter, or 
   *                    <code>null</code> if the parameter does not exist.
   *
   * @see  #getInitParameterNames
   *
   * @exception	java.lang.IllegalArgumentException	
   *                      if name is <code>null</code>.
   */

  public java.lang.String getInitParameter(java.lang.String name);


  /**
   * Returns the names of the context initialization parameters as an 
   * <code>Enumeration</code> of String objects, or an empty Enumeration if the context 
   * has no initialization parameters.
   *
   * @return 	      an <code>Enumeration</code> of <code>String</code> 
   *                  objects containing the names of the context
   *                  initialization parameters
   *
   * @see  #getInitParameter
   */

  public java.util.Enumeration<String> getInitParameterNames();


  /**
   * Writes the specified message to a portlet log file, usually an event log.
   * The name and type of the portlet log file is specific to the portlet container.
   * <p>
   * This method mapps to the <code>ServletContext.log</code> method.
   * The portlet container may in addition log this message in a
   * portlet container specific log file.
   *
   * @param msg 	a <code>String</code> specifying the 
   *			message to be written to the log file
   */

  public void log(java.lang.String msg);


  /**
   * Writes an explanatory message and a stack trace for a given 
   * Throwable exception to the portlet log file.
   * The name and type of the portlet log file is specific to the 
   * portlet container, usually an event log.
   * <p>
   * This method is mapped to the <code>ServletContext.log</code> method.
   * The portlet container may in addition log this message in a
   * portlet container specific log file.
   *
   * @param message 		a <code>String</code> that 
   *				describes the error or exception
   * @param throwable 	        the <code>Throwable</code> error 
   *				or exception
   */

  public void log(java.lang.String message, java.lang.Throwable throwable);


  /**
   * Removes the attribute with the given name from the portlet context.
   * After removal, subsequent calls to
   * {@link #getAttribute} to retrieve the attribute's value
   * will return <code>null</code>.
   *
   * @param name	a <code>String</code> specifying the name 
   * 			of the attribute to be removed
   *
   * @exception	java.lang.IllegalArgumentException	
   *                      if name is <code>null</code>.
   */

  public void removeAttribute(java.lang.String name);


  /**
   * Binds an object to a given attribute name in this portlet context.
   * If the name specified is already used for an attribute, this method 
   * removes the old attribute and binds the name to the new attribute.
   * <p>
   * If a null value is passed, the effect is the same as calling 
   * <code>removeAttribute()</code>.
   * 
   * <p>Attribute names should follow the same convention as package
   * names. The Java Portlet API specification reserves names
   * matching <code>java.*</code>, <code>javax.*</code>, and
   * <code>sun.*</code>.
   *
   * @param name 	a <code>String</code> specifying the name 
   *			of the attribute
   * @param object 	an <code>Object</code> representing the
   *			attribute to be bound
   *
   * @exception	java.lang.IllegalArgumentException	
   *                      if name is <code>null</code>.
   */

  public void setAttribute(java.lang.String name, java.lang.Object object);


  /**
   * Returns the name of this portlet application correponding to this PortletContext as specified 
   * in the <code>web.xml</code> deployment descriptor for this web application by the 
   * <code>display-name</code> element.
   *
   *
   * @return  The name of the web application or null if no name has been declared in the deployment descriptor.
   */
    
  public String getPortletContextName();

  
  /**
   * Returns the container container runtime options
   * keys supported by this portlet container.
   * 
   * @since 2.0
   *  
   * @return  container runtime options keys supported by this 
   *          container as String values.
   */
  public java.util.Enumeration<String> getContainerRuntimeOptions();
}
