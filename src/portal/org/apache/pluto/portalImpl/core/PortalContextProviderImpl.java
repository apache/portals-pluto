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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import org.apache.pluto.portalImpl.services.config.Config;
import org.apache.pluto.services.information.PortalContextProvider;

/**

 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class PortalContextProviderImpl implements PortalContextProvider {


    /** Portal information */
    private String info = null;

    /** supported portlet modes by this portal */
    private Vector modes;

    /** supported window states by this portal */
    private Vector states;

    /** portal properties */
    private HashMap properties = new HashMap();


    public PortalContextProviderImpl()
    {        // these are the minimum modes that the portal needs to support        modes = getDefaultModes();
        // these are the minimum states that the portal needs to support        states = getDefaultStates(); 
        // set info        info = "Pluto/1.0";   
    }

    // PortalContextProvider implementation.

    public java.lang.String getProperty(java.lang.String name)
    {
        if (name == null) {
            throw new IllegalArgumentException("Property name == null");
        }

        return(String) properties.get(name);
    }


    public java.util.Collection getPropertyNames()
    {
        return properties.keySet();
    }


    public java.util.Collection getSupportedPortletModes()
    {
        return modes;
    }


    public java.util.Collection getSupportedWindowStates()
    {
        return states;
    }


    public String getPortalInfo()
    {
        return info;
    }

    // internal methods.

    private Vector getDefaultModes()
    {

        Vector m = new Vector();

        String[] supportedModes = Config.getParameters().getStrings("supported.portletmode");

        for (int i=0; i<supportedModes.length; i++) {
            m.add(new PortletMode(supportedModes[i].toString().toLowerCase()));
        }

        return m;
    }

    private Vector getDefaultStates()
    {
        Vector s = new Vector();

        String[] supportedStates = Config.getParameters().getStrings("supported.windowstate");

        for (int i=0; i<supportedStates.length; i++) {
            s.add(new WindowState(supportedStates[i].toString().toLowerCase()));
        }

        return s;
    }

    // additional methods.

    // methods used container internally to set

    public void setProperty(String name, String value)
    {
        if (name == null) {
            throw new IllegalArgumentException("Property name == null");
        }

        properties.put(name, value);
    }      


    // expects enumeration of PortletMode objects
    public void setSupportedPortletModes(Enumeration portletModes)
    {
        Vector v = new Vector();
        while (portletModes.hasMoreElements()) {
            v.add(portletModes.nextElement());
        }
        modes = v;
    }

    // expects enumeration of WindowState objects
    public void setSupportedWindowStates(Enumeration windowStates)
    {
        Vector v = new Vector();
        while (windowStates.hasMoreElements()) {
            v.add(windowStates.nextElement());
        }
        states = v;
    }

    /**
     * reset all values to default portlet modes and window states;
     * delete all properties and set the given portlet information
     * as portlet info string.
     * 
     * @param  
     * @param portalInfo  portal information string that will be returned
     *                    by the <code>getPortalInfo</code> call.
     */
    public void reset(String portalInfo)
    {
        info = new String(portalInfo);

        // these are the minimum modes that the portal needs to support
        modes = getDefaultModes();
        // these are the minimum states that the portal needs to support
        states = getDefaultStates();    

        properties.clear();
    }



}
