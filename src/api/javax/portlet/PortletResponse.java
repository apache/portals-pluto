/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 * ====================================================================
 *
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet;


/**
 * The <CODE>PortletResponse</CODE> defines the base interface to assist a
 * portlet in creating and sending a response to the client.
 * The portlet container uses two specialized versions of this interface
 * when invoking a portlet, <CODE>ActionResponse</CODE> and
 * <CODE>RenderResponse</CODE>. The  portlet container creates these
 * objects and passes them as arguments to the portlet's <CODE>processAction</CODE>
 * and <CODE>render</CODE> methods.
 * 
 * @see ActionResponse
 * @see RenderResponse
 */
public interface PortletResponse
{



  /**
   * Adds a String property to an existing key to be returned to the portal.
   * <p>
   * This method allows response properties to have multiple values.
   * <p>
   * Properties can be used by portlets to provide vendor specific 
   * information to the portal.
   *
   * @param  key    the key of the property to be returned to the portal
   * @param  value  the value of the property to be returned to the portal
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if key is <code>null</code>.
   */

  public void addProperty(String key, String value);


  /**
   * Sets a String property to be returned to the portal.
   * <p>
   * Properties can be used by portlets to provide vendor specific 
   * information to the portal.
   * <p>
   * This method resets all properties previously added with the same key.
   *
   * @param  key    the key of the property to be returned to the portal
   * @param  value  the value of the property to be returned to the portal
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if key is <code>null</code>.
   */

  public void setProperty(String key, String value);


  /**
   * Returns the encoded URL of the resource, like servlets,
   * JSPs, images and other static files, at the given path.
   * <p>
   * Some portal/portlet-container implementation may require 
   * those URLs to contain implementation specific data encoded
   * in it. Because of that, portlets should use this method to 
   * create such URLs.
   * <p>
   * The <code>encodeURL</code> method may include the session ID 
   * and other portal/portlet-container specific information into the URL. 
   * If encoding is not needed, it returns the URL unchanged. 
   *
   * @param   path
   *          the URI path to the resource. This must be either
   *          an absolute URL (e.g. 
   *          <code>http://my.co/myportal/mywebap/myfolder/myresource.gif</code>)
   *          or a full path URI (e.g. <code>/myportal/mywebap/myfolder/myresource.gif</code>).
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if path doesn't have a leading slash or is not an absolute URL
   * 
   * @return   the encoded resource URL as string
   */

  public String encodeURL (String path);





}


