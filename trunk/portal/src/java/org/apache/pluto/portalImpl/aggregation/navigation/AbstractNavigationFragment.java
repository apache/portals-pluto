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

import javax.servlet.ServletConfig;

import org.apache.pluto.portalImpl.aggregation.AbstractFragmentSingle;
import org.apache.pluto.portalImpl.core.PortalURL;

public abstract class AbstractNavigationFragment extends AbstractFragmentSingle
{

    public AbstractNavigationFragment(String id,
                                      ServletConfig config, 
                                      org.apache.pluto.portalImpl.aggregation.Fragment parent,
                                      org.apache.pluto.portalImpl.om.page.Fragment fragDesc,
                                      org.apache.pluto.portalImpl.aggregation.navigation.Navigation navigation)
    throws Exception 
    {
        super(id, config, parent, fragDesc, navigation);
    }

    public void createURL(PortalURL url)
    {
        getParent().createURL(url);
        url.addGlobalNavigation(getId());
    }

    public boolean isPartOfURL(PortalURL url)
    {
        return url.isPartOfGlobalNavigation(getId());
    }

    public org.apache.pluto.portalImpl.aggregation.navigation.Navigation getRootNavigation()
    {
        org.apache.pluto.portalImpl.aggregation.Fragment returnvalue = this;
        for (; returnvalue.getParent() != null; returnvalue = returnvalue.getParent()) {
        }
        return returnvalue.getNavigation();
    }

    /**
     * If the given parent is NULL, the method returns the first fragment containing
     * navigational information after the root element.
     * <P>
     * if the given parent points to a fragment, the method returns the first child
     * fragment that contains navigational information
     * 
     * @param parent the parent fragment or NULL
     * @return Returns the first fragment that contains navigational information.
     */
/*
    public org.apache.pluto.portalImpl.aggregation.Fragment 
        getFirstNavigation(org.apache.pluto.portalImpl.aggregation.Fragment parent)
    {
        org.apache.pluto.portalImpl.aggregation.Fragment returnvalue = null;
        if (parent==null)
        {
            returnvalue = this;
            // get root fragment...this does not need to have a navigation
            for (; returnvalue.getParent()!=null; returnvalue = returnvalue.getParent()) {}
            
            // root element does not have a navigation information
            if (returnvalue.getNavigation()==null)
            {
                returnvalue = getFirstNavigation(returnvalue);
            }

        }
        else
        {
            Iterator iterator = parent.getChildFragments().iterator();
            while (iterator.hasNext())
            {
                org.apache.pluto.portalImpl.aggregation.Fragment fragment =
                    (org.apache.pluto.portalImpl.aggregation.Fragment)iterator.next();
                if (fragment.getNavigation()!=null)
                {
                    returnvalue = fragment;
                    break;
                }
            }

            // no fragment with navigational information found yet, so try a deep search
            if (returnvalue==null)
            {
                iterator = parent.getChildFragments().iterator();
                while (iterator.hasNext())
                {
                    org.apache.pluto.portalImpl.aggregation.Fragment fragment =
                        (org.apache.pluto.portalImpl.aggregation.Fragment)iterator.next();

                    returnvalue = getFirstNavigation(fragment);

                    if (returnvalue!=null)
                        break;

                }

            }

        }
        return returnvalue;
    }

    public org.apache.pluto.portalImpl.aggregation.Fragment 
        getNextNavigation(org.apache.pluto.portalImpl.aggregation.Fragment previous)
    {
        if (previous==null)
            throw new IllegalArgumentException("previous navigation mus not be null!");


        return null;
    }
*/
}
