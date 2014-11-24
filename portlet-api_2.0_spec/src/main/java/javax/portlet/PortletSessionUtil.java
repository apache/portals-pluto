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


