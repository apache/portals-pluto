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

package org.apache.pluto.impl;

import org.apache.pluto.PlutoConstants;
import org.apache.pluto.services.Logger;
import org.apache.pluto.services.ServiceFactory;
import org.apache.pluto.services.LoggerService;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletException;
import javax.servlet.ServletContext;
import java.io.InputStream;
import java.util.Set;
import java.util.Enumeration;
import java.util.HashMap;
import java.net.URL;
import java.net.MalformedURLException;

/** PortletContext implementation.
 *  This implementation leverages the underlying ServletContext
 *  by acting as a decorator.
 *
 *  <P>NOTE: The {@link LoggerService} for this implementation
 *  not only provides internal logging facilities, it also
 *  is used to provide the default portlet context log which
 *  will be used for all {@link #log(java.lang.String)} and
 *  {@link #log(java.lang.String, java.lang.Throwable)}
 *  requests. The name associated with this log is
 *  org.apache.pluto.impl.portlet_context_log.
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 4, 2004 at 11:31:43 PM
 */
public class PortletContextImpl implements PortletContext {

    private ServletContext context;
    private Logger logger;
    private HashMap attributes;

    public PortletContextImpl(ServletContext context,
                              LoggerService service) {
        this.context = context;
        this.attributes = new HashMap();
        this.logger = service.getLogger(PortletContextImpl.class);
    }


    public String getServerInfo() {
        return PlutoConstants.CONTAINER_NAME+"/"+
                PlutoConstants.MAJOR_VERSION+"."+
                PlutoConstants.MINOR_VERSION;
    }

    public PortletRequestDispatcher getRequestDispatcher(String s) {
        return new PortletRequestDispatcherImpl(context.getRequestDispatcher(s));
    }

    public PortletRequestDispatcher getNamedDispatcher(String s) {
        return new PortletRequestDispatcherImpl(context.getNamedDispatcher(s));
    }

    public InputStream getResourceAsStream(String s) {
        return context.getResourceAsStream(s);
    }

    public int getMajorVersion() {
        return PlutoConstants.MAJOR_VERSION;
    }

    public int getMinorVersion() {
        return PlutoConstants.MINOR_VERSION;
    }

    public String getMimeType(String uri) {
        return context.getMimeType(uri);
    }

    public String getRealPath(String uri) {
        return context.getRealPath(uri);
    }

    public Set getResourcePaths(String uri) {
        return context.getResourcePaths(uri);
    }

    public URL getResource(String uri) throws MalformedURLException {
        return context.getResource(uri);
    }

    public Object getAttribute(String key) {
        return context.getAttribute(key);
    }

    public Enumeration getAttributeNames() {
        return context.getAttributeNames();
    }

    public String getInitParameter(String key) {
        return context.getInitParameter(key);
    }

    public Enumeration getInitParameterNames() {
        return context.getInitParameterNames();
    }

    public void log(String msg) {
        logger.log(msg);
    }

    public void log(String msg, Throwable throwable) {
        logger.log(msg, throwable);
    }

    public void removeAttribute(String key) {
        attributes.remove(key);
    }

    public void setAttribute(String key, Object value) {
        attributes.put(key, value);
    }

    public String getPortletContextName() {
        return context.getServletContextName();
    }
}
