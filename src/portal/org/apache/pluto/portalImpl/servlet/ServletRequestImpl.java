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
 */
/* 

 */

package org.apache.pluto.portalImpl.servlet;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.portalImpl.core.PortalControlParameter;
import org.apache.pluto.portalImpl.core.PortalEnvironment;

public class ServletRequestImpl extends javax.servlet.http.HttpServletRequestWrapper 
{

    PortalControlParameter control = null;
    PortletWindow portletWindow = null;

    public ServletRequestImpl(javax.servlet.http.HttpServletRequest servletRequest, PortletWindow window)
    {
        super(servletRequest);

        this.portletWindow = window;
        control = new PortalControlParameter(
            PortalEnvironment.getPortalEnvironment(servletRequest).getRequestedPortalURL());

    }

    private javax.servlet.http.HttpServletRequest _getHttpServletRequest()
    {
        return(javax.servlet.http.HttpServletRequest) super.getRequest();
    }

// HttpServletRequestWrapper overlay
          
    public java.lang.String getContentType()
    {
        String contentType = "text/html";
        if (getCharacterEncoding()!=null)
        {
            contentType += ";" + getCharacterEncoding();
        }
        return contentType;
    }

// ServletRequestWrapper overlay

    public String getParameter(String name) 
    {
        return (String) this.getParameterMap().get(name);

    }
    
    public Map getParameterMap() 
    {
        //get control params
        Map portletParameters = new HashMap();
             
        Iterator iterator = control.getRenderParamNames(portletWindow);
        while (iterator.hasNext())
        {
            String name = (String)iterator.next();

            String[] values = control.getRenderParamValues(portletWindow, name);

            portletParameters.put(name, values );

        }

        //get request params      
        String pid = control.getPIDValue();
        String wid = portletWindow.getId().toString();
        if (pid.equals(wid)) {
            for (Enumeration parameters = super.getParameterNames(); parameters.hasMoreElements();) {
                String   paramName   = (String)parameters.nextElement();
                String[] paramValues = (String[])super.getParameterValues(paramName);
                String[] values      = (String[])portletParameters.get(paramName);
    
                if (values != null) {
                    String[] temp = new String[paramValues.length + values.length];
                    System.arraycopy(paramValues, 0, temp, 0, paramValues.length);
                    System.arraycopy(values, 0, temp, paramValues.length, values.length);
                    paramValues = temp;
                }
                portletParameters.put(paramName, paramValues);
            }
        }

        return Collections.unmodifiableMap(portletParameters);
    }
    
    public Enumeration getParameterNames() 
    {
        return Collections.enumeration(this.getParameterMap().keySet());
    }

    public String[] getParameterValues(String name) 
    {
        return (String[]) this.getParameterMap().get(name);
    }

}


