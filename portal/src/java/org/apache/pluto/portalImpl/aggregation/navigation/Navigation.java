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

package org.apache.pluto.portalImpl.aggregation.navigation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.pluto.util.StringUtils;

public class Navigation
{

    private org.apache.pluto.portalImpl.om.page.Navigation navigation = null;
    private org.apache.pluto.portalImpl.aggregation.navigation.Navigation parent = null;
    private org.apache.pluto.portalImpl.aggregation.Fragment linkedFragment = null;
    private Collection children = new ArrayList();

    public Navigation(org.apache.pluto.portalImpl.aggregation.navigation.Navigation parent,
                      org.apache.pluto.portalImpl.om.page.Navigation navigation)
    {
        this.parent = parent;
        this.navigation = navigation;
        
        if (this.parent != null)
        {
            this.parent.getChildren().add(this);
        }
    }

    public boolean isRootNavigation()
    {
        return navigation == null;
    }

    public String getTitle()
    {
        if (isRootNavigation()) {
            return null;
        } else {
            return navigation.getTitle();
        }
    }

    public String getDescription()
    {
        if (isRootNavigation()) {
            return null;
        } else {
            return navigation.getDescription();
        }
    }

    public Navigation getParent()
    {
        return parent;
    }

    public Collection getChildren()
    {
        return children;
    }

    public org.apache.pluto.portalImpl.aggregation.Fragment getLinkedFragment()
    {
        return linkedFragment;
    }

    public void setLinkedFragment(org.apache.pluto.portalImpl.aggregation.Fragment linkedFragment)
    {
        this.linkedFragment = linkedFragment;
    }

    public String toString()
    {
        return toString(0);
    }

    public String toString(int indent)
    {
        StringBuffer buffer = new StringBuffer(200);
        StringUtils.newLine(buffer,indent);
        buffer.append(getClass().toString()); buffer.append(":");
        StringUtils.newLine(buffer,indent);
        buffer.append("{");
        if (navigation != null)
        {
            buffer.append(((org.apache.pluto.portalImpl.om.page.impl.NavigationImpl)navigation).toString(indent));
        }
        Iterator iterator = children.iterator();
        if (iterator.hasNext())
        {
            StringUtils.newLine(buffer,indent);
            buffer.append("Children:");
        }
        while (iterator.hasNext())
        {
            buffer.append(((Navigation)iterator.next()).toString(indent+2));
        }
        StringUtils.newLine(buffer,indent);
        buffer.append("}");
        return buffer.toString();
    }

}
