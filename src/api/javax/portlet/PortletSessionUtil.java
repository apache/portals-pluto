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
 * The <CODE>PortletSessionUtil</CODE>  class helps identify and decode
 * attributes in the <CODE>PORTLET_SCOPE</CODE> scope of the PortletSession
 * when accessed through the HttpSession an from within calls to methods
 * of the HttpSessionBindingListener interface.
 */
public class PortletSessionUtil
{


  private static final String PORTLET_SCOPE_NAMESPACE = "javax.portlet.p.";
  
  /**
   * Returns the attribute name of an attribute in the 
   * <code>PORTLET_SCOPE</code>. If the attribute is in the
   * <code>APPLICATION_SCOPE</code> it returns the attribute name unchanged.
   *
   * @param name		a string specifying the name of the
   *                            encoded portlet attribute
   *
   * @return			the decoded attribute name
   */

  public static java.lang.String decodeAttributeName(java.lang.String name)
  {
    if (name.startsWith(PORTLET_SCOPE_NAMESPACE)) {
      int index = name.indexOf('?');
      if (index>-1) {
	name = name.substring(index+1);
      }
    }
    return name;
  }


  /**
   * Returns the portlet attribute scope from an encoded portlet
   * attribute.
   * <br>Possible return values are:
   * <ul>
   * <li><code>PortletSession.APPLICATION_SCOPE</code></li>
   * <li><code>PortletSession.PORTLET_SCOPE</code></li>
   * </ul>
   *
   * @param name		a string specifying the name of the
   *                            encoded portlet attribute
   *
   * @return			the decoded attribute scope
   * @see PortletSession
   */

  public static int decodeScope(java.lang.String name)
  {
    int scope = PortletSession.APPLICATION_SCOPE; // APP
    if (name.startsWith(PORTLET_SCOPE_NAMESPACE)) {
      int index = name.indexOf('?');
      if (index>-1) {
	scope = PortletSession.PORTLET_SCOPE; // PORTLET
      }
    }
    return scope;
  }
}


