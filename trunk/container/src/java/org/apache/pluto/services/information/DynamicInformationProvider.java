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

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import org.apache.pluto.om.window.PortletWindow;
 
/**
 * Provide information from the portal to portlet container
 * that are request dependend.
 */
public interface DynamicInformationProvider
{


     /**
      * Returns the content type the portlet should use in its response
      * The content type only includes the content type, not the character set.
      *
      * @return the content type to use for the response
      */
     public String getResponseContentType();

     /**
      * Gets a list of mime types which the portal accepts for the response.
      * This list is ordered with the most preferable types listed first.
      * <p>
      * The content type only includes the content type, not the
      * character set.
      * 
      * @return an java.util.Iterator of content types for the response
      */ 
     public java.util.Iterator getResponseContentTypes();

    /**
     * Returns an URL pointing to the given portlet window
     *
     * @param portletWindow    the portlet Window
     * 
     * @return the URL to the given portlet
     */
     public PortletURLProvider getPortletURLProvider(PortletWindow portletWindow);

    /**
     * Returns the ResourceURLProvider to create URLs pointing to a resource 
     * in a web application.
     *
     * @param portletWindow    the portlet Window
     * 
     * @return the URL to a resource
     */
     public ResourceURLProvider getResourceURLProvider(PortletWindow portletWindow);

    /**
     * Returns the portlet action provider for the given portlet window
     *
     * @param portletWindow    the portlet Window
     * 
     * @return the action provider for the given portlet
     */
     public PortletActionProvider getPortletActionProvider(PortletWindow portletWindow);

    /**
     * Returns the current <CODE>PortletMode</CODE> of the given portlet window.
     *
     * @param portletWindow    the portlet Window
     * @return the portlet mode
     */
    public PortletMode getPortletMode(PortletWindow portletWindow);

    /**
     * Returns the <CODE>WindowState</CODE> of the given portlet window.
     *
     * @param portletWindow    the portlet window
     * @return the portlet window state
     */
    public WindowState getWindowState(PortletWindow portletWindow);

    /**
     * Returns true if the portal supports the requested
     * portlet mode.
     *
     * @param mode portlet mode requested to support
     *
     * @return  true, if the portal support requested portlet mode
     */

    public boolean isPortletModeAllowed(PortletMode mode);


    /**
     * Returns true if the portal supports the requested
     * window state.
     *
     * @param state window state requested to support
     *
     * @return  true, if the portal support requested window state
     */

    public boolean isWindowStateAllowed(WindowState state);

}
