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

package org.apache.pluto.portalImpl.aggregation;

import org.apache.pluto.portalImpl.om.page.*;
import org.apache.pluto.portalImpl.core.*;
import org.apache.pluto.portalImpl.util.Parameters;
import org.apache.pluto.portalImpl.aggregation.navigation.Navigation;
import org.apache.pluto.portalImpl.services.config.Config;

import org.apache.pluto.util.StringUtils;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public abstract class AbstractFragment 
implements org.apache.pluto.portalImpl.aggregation.Fragment {

    public final static String BASE_ROOT = Config.getParameters().getString(
                                               "aggregation.base.dir",
                                               "/WEB-INF/aggregation/"
                                           );

    private String id;
    private ServletConfig config;
    private org.apache.pluto.portalImpl.aggregation.Fragment parent;
    private org.apache.pluto.portalImpl.om.page.Fragment fragDesc;
    private Parameters initParameters;
    private Navigation navigation;


    public AbstractFragment(String id,
                            ServletConfig config, 
                            org.apache.pluto.portalImpl.aggregation.Fragment parent,
                            org.apache.pluto.portalImpl.om.page.Fragment fragDesc,
                            org.apache.pluto.portalImpl.aggregation.navigation.Navigation navigation)
    throws Exception 
    {
        StringBuffer compId = new StringBuffer();
        if (parent != null) {
            String parentID = parent.getId();
            if (parentID != null) {
                compId.append(parentID);
                compId.append("_");
            }

        }

        if (id != null) {
            compId.append(id);
            this.id = compId.toString();
        }

        this.config = config;
        this.parent = parent;
        this.fragDesc = fragDesc;
        this.navigation = navigation;

        if (this.fragDesc != null) {
            // prepare properties - SHESMER:TODO needs to be done better, the additonal Map should not be necessary
            Map map = new HashMap();

            Iterator iterator = this.fragDesc.getProperties().iterator();

            while (iterator.hasNext()) {
                Property property = (Property)iterator.next();

                map.put(property.getName(), property.getValue());
            }

            initParameters = new Parameters(map);
        }

        org.apache.pluto.portalImpl.services.pageregistry.PageRegistry.addFragment(this);
    }

    // org.apache.pluto.portalImpl.aggregation.Fragment implementation.

    public void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        preService(request, response);

        request.setAttribute(Constants.FRAGMENT, this);
        String jspName = StringUtils.nameOf(getClass()) + ".jsp";
        RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher(BASE_ROOT+jspName);
        rd.include(request, response);

        postService(request, response);
    }

    public org.apache.pluto.portalImpl.aggregation.Fragment getParent()
    {
        return parent;
    }

    public String getId()
    {
        return id;
    }

    public Parameters getInitParameters()
    {
        return initParameters;
    }

    abstract public Collection getChildFragments();

    abstract public void addChild(org.apache.pluto.portalImpl.aggregation.Fragment child);

    public Navigation getNavigation()
    {
        return navigation;
    }

    abstract public void createURL(PortalURL url);

    abstract public boolean isPartOfURL(PortalURL url);

    // additional methods.
    public ServletConfig getServletConfig()
    {
        return config;
    }

    public String getInitParameterValue(String name)
    {
        return initParameters.getString(name);
    }


    abstract public void preService(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException;

    abstract public void postService(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException;

    protected org.apache.pluto.portalImpl.om.page.Fragment getFragmentDescription()
    {
        return fragDesc;
    }
}
