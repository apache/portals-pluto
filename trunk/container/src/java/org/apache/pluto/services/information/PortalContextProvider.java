/*
 * Copyright 2003,2004 The Apache Software Foundation.
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

 */

package org.apache.pluto.services.information;


/**
 * Provide information about the calling portal.
 */
public interface PortalContextProvider 
{
 
    /**
     * Returns the portal property with the given name, 
     * or a <code>null</code> if there is 
     * no property by that name.
     *
     * @param  name    property name
     *
     * @return  portal property with key <code>name</code>
     *
     * @exception	java.lang.IllegalArgumentException	
     *                      if name is <code>null</code>.
     */

    public java.lang.String getProperty(java.lang.String name);


    /**
     * Returns all portal property names as strings,
     * or an empty <code>Collection</code> if 
     * there are no property names.
     *
     * @return  portal property names
     */
    public java.util.Collection getPropertyNames();


    /**
     * Returns the portlet modes that the portal supports 
     * as <code>javax.portlet.PortletMode</code> objects.
     * <p>
     * The portlet modes must at least include the
     * standard portlet modes <code>EDIT, HELP, VIEW</code>.
     *
     * @return  list of supported portlet modes
     */
 
    public java.util.Collection getSupportedPortletModes();


    /**
     * Returns the window states that the portal supports
     * as <code>javax.portlet.WindowState</code> objects.
     * <p>
     * The window states must at least include the
     * standard window states <code> MINIMIZED, NORMAL, MAXIMIZED</code>.
     *
     * @return  list of supported window states
     */

    public java.util.Collection getSupportedWindowStates();


    /**
     * Returns information about the portal like vendor, version, etc.
     * <p>
     * The returned string starts with <br>
     * <I>servername/versionnumber</I>
     * Other optional information follow the primary string in parentheses. 
     * 
     * @return a <CODE>String</CODE> containing at least the portal name and version number
     */

    public java.lang.String getPortalInfo();

}
