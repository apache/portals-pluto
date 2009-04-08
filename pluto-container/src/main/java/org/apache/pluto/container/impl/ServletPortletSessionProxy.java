/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.container.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.pluto.container.util.NamespacedNamesEnumeration;

/**
 * Proxy for a Servlet HttpSession to attach to a PortletSession, providing only access to PORTLET_SCOPE session attributes
 * and hiding the APPLICATION_SCOPE attributes from the Servlet.
 * <br/>
 * This Proxy can be used to isolate two instances of the same Portlet dispatching to Servlets so they don't overwrite or read
 * each others session attributes.
 * 
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public class ServletPortletSessionProxy implements InvocationHandler
{
    HttpSession servletSession;
    String portletWindowId;
    String portletScopeAttrNamePrefix;

    public static HttpSession createProxy(HttpServletRequest request, String portletWindowId)
    {
        HttpSession servletSession = request.getSession();
        HashSet<Class<? extends Object>> interfaces = new HashSet<Class<? extends Object>>();
        interfaces.add(HttpSession.class);
        Class<? extends Object> current = servletSession.getClass();
        while (current != null)
        {
            try
            {
                @SuppressWarnings("unchecked")
                Class<? extends Object>[] currentInterfaces = current.getInterfaces();
                for (int i = 0; i < currentInterfaces.length; i++)
                {
                    interfaces.add(currentInterfaces[i]);
                }
                current = current.getSuperclass();
            }
            catch (Exception e)
            {
                current = null;
            }
        }
        Object proxy = Proxy.newProxyInstance(servletSession.getClass().getClassLoader(),
                interfaces.toArray(new Class[interfaces.size()]),
                new ServletPortletSessionProxy(request.getSession(), portletWindowId));
        return (HttpSession)proxy;
    }

    private ServletPortletSessionProxy(HttpSession servletSession, String portletWindowId)
    {
        this.servletSession = servletSession;
        this.portletWindowId = portletWindowId;
        this.portletScopeAttrNamePrefix = PortletSessionImpl.PORTLET_SCOPE_NAMESPACE + this.portletWindowId + PortletSessionImpl.ID_NAME_SEPARATOR;
    }

    /**
     * (non-Javadoc)
     * 
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
     *      java.lang.reflect.Method, java.lang.Object[])
     */
    @SuppressWarnings("unchecked")
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
    {
        Object retval = null;
        if (("getAttribute".equals(m.getName()) || "getValue".equals(m.getName())) && args.length == 1 && args[0] instanceof String)
        {
            retval = servletSession.getAttribute(this.portletScopeAttrNamePrefix + (String) args[0]);
        }
        else if (("setAttribute".equals(m.getName()) || "putValue".equals(m.getName())) && args.length == 2 && args[0] instanceof String)
        {
            servletSession.setAttribute(this.portletScopeAttrNamePrefix + (String) args[0], args[1]);
        }
        else if (("removeAttribute".equals(m.getName()) || "removeValue".equals(m.getName())) && args.length == 1 && args[0] instanceof String)
        {
            servletSession.removeAttribute(this.portletScopeAttrNamePrefix + (String) args[0]);
        }
        else if ("getAttributeNames".equals(m.getName()) && args == null)
        {
            retval = new NamespacedNamesEnumeration(servletSession.getAttributeNames(), this.portletScopeAttrNamePrefix);
        }
        else if ("getValueNames".equals(m.getName()) && args == null)
        {
            final List<String> list = new ArrayList<String>();
            Enumeration<String> e = new NamespacedNamesEnumeration(servletSession.getAttributeNames(), this.portletScopeAttrNamePrefix);
            while (e.hasMoreElements())
            {
                list.add(e.nextElement());
            }
            retval = list.toArray(new String[list.size()]);
        }
        else
        {
            try
            {
                retval = m.invoke(servletSession, args);
            }
            catch (InvocationTargetException ite)
            {
                throw ite.getTargetException();
            }
        }
        return retval;
    }
}
