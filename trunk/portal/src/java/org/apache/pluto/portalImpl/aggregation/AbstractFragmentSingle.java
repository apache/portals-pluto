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

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.portalImpl.core.PortalURL;

public abstract class AbstractFragmentSingle extends AbstractFragment
{

    public AbstractFragmentSingle(String id,
                                  ServletConfig config, 
                                  org.apache.pluto.portalImpl.aggregation.Fragment parent,
                                  org.apache.pluto.portalImpl.om.page.Fragment fragDesc,
                                  org.apache.pluto.portalImpl.aggregation.navigation.Navigation navigation)
    throws Exception 
    {
        super(id, config, parent, fragDesc, navigation);
    }

    public void preService(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
    }

    public void postService(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
    }

    public Collection getChildFragments()
    {
        return Collections.EMPTY_LIST;
    }

    public void addChild(org.apache.pluto.portalImpl.aggregation.Fragment child)
    {
        // do nothing
    }

    abstract public void createURL(PortalURL url);

    abstract public boolean isPartOfURL(PortalURL url);

}
