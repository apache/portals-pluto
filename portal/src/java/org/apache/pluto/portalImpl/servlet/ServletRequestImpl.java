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


