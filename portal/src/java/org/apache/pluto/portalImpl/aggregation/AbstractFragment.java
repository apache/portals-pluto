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
