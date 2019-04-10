/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.container;

import java.util.Collection;

import javax.portlet.PortletConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletURLProvider.TYPE;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

/**
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public interface PortletResponseContext
{
    void init(PortletConfig portletConfig, HttpServletRequest servletRequest, HttpServletResponse servletResponse);
    PortletContainer getContainer();
    HttpServletRequest getContainerRequest();
    HttpServletResponse getContainerResponse();
    PortletConfig getPortletConfig();
    HttpServletRequest getServletRequest();
    HttpServletResponse getServletResponse();
    PortletWindow getPortletWindow();
    
    // needed for header processing
    void setLifecycle(String lifecycle);
    String getLifecycle();
    void setPropsAllowed(boolean isSetPropsAllowed);
    boolean isSetPropsAllowed();
    HeaderData getHeaderData();
    
    ResourceURLProvider getResourceURLProvider();
    PortletURLProvider getPortletURLProvider(TYPE type);
    void addProperty(Cookie cookie);
    void addProperty(String key, Element element);
    void addProperty(String key, String value);
    void setProperty(String key, String value);
    Element createElement(String tagName) throws DOMException;
    String getProperty(String key);
    Collection<String> getPropertyValues(String name);
    Collection<String> getPropertyNames();
    void processHttpHeaders();

    /**
     * Closing the response context means processing has been completed and
     * internal storage can be flushed and written out to the Portal.
     * It is not required for the Portal to do internal buffering, except for
     * the PortletEventResponseContext as the portlet spec explicitely states that
     * any changes during a processEvent should be ignored if an exception occurs,
     * in which case the portlet container should only call release() and not close().
     */
    void close();
    
    /**
     * Releasing the response context means its internal storage can be released as well.
     * If any outstanding changes have not been processed yet, those will be lost.
     */
    void release();
    
    // needed for action scoped request attribute processing
    void setActionScopedId(String windowId, String[] values);
}
