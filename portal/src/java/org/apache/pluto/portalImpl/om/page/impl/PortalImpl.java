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

package org.apache.pluto.portalImpl.om.page.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletConfig;

import org.apache.pluto.util.StringUtils;

public class PortalImpl implements java.io.Serializable {

    private ArrayList fragments = new ArrayList();

    public PortalImpl()
    {
    }

    // additional methods.
    
    public Collection getFragments()
    {
        return fragments;
    }

    public org.apache.pluto.portalImpl.aggregation.RootFragment build(ServletConfig config)    
    throws Exception
    {
        org.apache.pluto.portalImpl.aggregation.RootFragment root = 
        new org.apache.pluto.portalImpl.aggregation.RootFragment(config);

        Iterator iterator = fragments.iterator();

        while (iterator.hasNext()) {
            FragmentImpl fragmentimpl = (FragmentImpl)iterator.next();

            org.apache.pluto.portalImpl.aggregation.Fragment _fragment = 
            fragmentimpl.build(config, root);
            if (_fragment!=null) {
                root.addChild(_fragment);
            }
        }

        return root;
    }

    public String toString()
    {
        StringBuffer buffer = new StringBuffer(2000);
        StringUtils.newLine(buffer,0);
        buffer.append(getClass().toString()); buffer.append(":");
        StringUtils.newLine(buffer,0);
        buffer.append("{");

        Iterator iterator = fragments.iterator();

        while (iterator.hasNext()) {
            buffer.append(((FragmentImpl)iterator.next()).toString(2));
        }

        StringUtils.newLine(buffer,0);
        buffer.append("}");
        return buffer.toString();
    }

}
