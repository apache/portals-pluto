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
 * The <CODE>WindowState</CODE> class represents
 * the possible window states that a portlet window can assume.
 * <P>
 * This class defines a standard set of the most basic portlet window states.
 * Additional window states may be defined by calling the constructor of
 * this class. If a portal/portlet-container does not support a 
 * custom window state defined in the portlet application deployment descriptor, 
 * the custom window state will be ignored by the portal/portlet container.
 */

public class WindowState
{


  /**
   * The <code>NORMAL</code> window state indicates that a portlet 
   * may be sharing the page with other portlets. It may also 
   * indicate that the target device has limited display capabilities.
   * Therefore, a portlet should restrict the size of its rendered 
   * output in this window state.
   * <p>
   * The string value for this state is <code>"normal"</code>.
   */
  public final static WindowState NORMAL = new WindowState ("normal");

  /**
   * The <code>MAXIMIZED</code> window state is an indication 
   * that a portlet may be the only portlet being rendered in the 
   * portal page, or that the portlet has more space compared to other portlets
   * in the portal page. A portlet may generate richer content 
   * when its window state is <code>MAXIMIZED</code>.
   * <p>
   * The string value for this state is <code>"maximized"</code>.
   */
  public final static WindowState MAXIMIZED = new WindowState ("maximized");
  
  /**
   * When a portlet is in <code>MINIMIZED</code> window state, 
   * the portlet should only render minimal output or no output at all.
   * <p>
   * The string value for this state is <code>"minimized"</code>.
   */
  public final static WindowState MINIMIZED = new WindowState ("minimized");



  private String _name;


  /**
   * Creates a new window state with the given name.
   * <p>
   * Upper case letters in the name are converted to
   * lower case letters.
   *
   * @param name The name of the portlet mode
   */
  public WindowState(String name) {
    if (name==null) {
      throw new IllegalArgumentException("WindowState name can not be NULL");
    }
    _name = name.toLowerCase();
  }

  /**
   * Returns a String representation of this window state.
   * Window state names are always lower case names.
   *
   * @return  String representation of this window state.
   */

  public String toString() {
    return _name;
  }


  /**
   * Returns the hash code value for this window state.
   * The hash code is constructed by producing the
   * hash value of the String value of this window state.
   *
   * @return  hash code value for this window state
   */

  public int hashCode() {
    return _name.hashCode();
  }


  /**
   * Compares the specified object with this window state
   * for equality. Returns <code>true</code> if the
   * Strings <code>equals</code> method for the String
   * representing the two window states returns <code>true</code>.
   * 
   * @param   the window state to compare this window state with.
   * 
   * @return  true, if the specified object is equal with this window state.
   */

  public boolean equals(Object object) {
    if ( object instanceof WindowState )
      return _name.equals(((WindowState) object)._name);
    else
      return false;
  }
}

