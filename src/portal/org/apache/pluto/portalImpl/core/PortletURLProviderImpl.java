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

package org.apache.pluto.portalImpl.core;

import java.util.Iterator;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.information.PortletURLProvider;

public class PortletURLProviderImpl implements PortletURLProvider {

    private DynamicInformationProviderImpl provider;
    private PortletWindow portletWindow;
    private PortletMode mode;
    private WindowState state;
    private boolean action;
    private boolean secure;
    private boolean clearParameters;
    private Map parameters;

    public PortletURLProviderImpl(DynamicInformationProviderImpl provider,
                                  PortletWindow portletWindow)
    {
        this.provider = provider;
        this.portletWindow = portletWindow;
    }

    // PortletURLProvider implementation.

    public void setPortletMode(PortletMode mode)
    {
        this.mode = mode;
    }

    public void setWindowState(WindowState state)
    {
        this.state = state;
    }

    public void setAction()
    {
        action = true;
    }

    public void setSecure()
    {
        secure = true;
    }

    public void clearParameters()
    {
        clearParameters = true;
    }

    public void setParameters(Map parameters)
    {
        this.parameters = parameters;
    }

    public String toString()
    {
        PortalURL url = PortalEnvironment.getPortalEnvironment(provider.request).getRequestedPortalURL();

        PortalControlParameter controlURL = new PortalControlParameter(url);

        if (mode != null) {
            controlURL.setMode(portletWindow, mode);
        }

        if (state != null) {
            controlURL.setState(portletWindow, state);
        }

        if (clearParameters) {
            controlURL.clearRenderParameters(portletWindow);
        }

        // set portlet id for associated request parms
        controlURL.setPortletId(portletWindow);
        if (action) {
            controlURL.setAction(portletWindow);
        }


        if (parameters != null) {
            Iterator names = parameters.keySet().iterator();
            while (names.hasNext()) {
                String name = (String)names.next();
                Object value = parameters.get(name);
                String[] values = value instanceof String ? new String[] {(String)value} : (String[])value;
                if (action) {
                    //					controlURL.setRequestParam(NamespaceMapperAccess.getNamespaceMapper().encode(portletWindow.getId(), name),values);
                    controlURL.setRequestParam(name,values);
                } else {
                    controlURL.setRenderParam(portletWindow, name, values );
                }
            }
        }

        return url.toString(controlURL,new Boolean(secure));
    }

}
