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

package org.apache.pluto.services;

import org.apache.pluto.PortletWindow;

/**
 * Provide information from the portal to portlet container that are request
 * dependend.
 */
public interface DynamicInformationProvider {


    /**
     * Returns the content type the portlet should use in its response The
     * content type only includes the content type, not the character set.
     * @return the content type to use for the response
     */
    public String getResponseContentType();

    /**
     * Gets a list of mime types which the portal accepts for the response. This
     * list is ordered with the most preferable types listed first.
     * <p/>
     * The content type only includes the content type, not the character set.
     * @return an java.util.Iterator of content types for the response
     */
    public java.util.Iterator getResponseContentTypes();

    /**
     * Returns an URL pointing to the given portlet window
     * @param portletWindow the portlet Window
     * @return the URL to the given portlet
     */
    public PortletURLProvider getPortletURLProvider(
        PortletWindow portletWindow);

    /**
     * Returns the ResourceURLProvider to create URLs pointing to a resource in
     * a web application.
     * @param portletWindow the portlet Window
     * @return the URL to a resource
     */
    public ResourceURLProvider getResourceURLProvider(
        PortletWindow portletWindow);

}
