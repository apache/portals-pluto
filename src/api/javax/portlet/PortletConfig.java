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

  public java.util.Enumeration getInitParameterNames();
}

