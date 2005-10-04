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

import javax.servlet.ServletConfig;

import org.apache.pluto.portalImpl.aggregation.navigation.Navigation;
import org.apache.pluto.portalImpl.core.PortalURL;

public class RootFragment extends AbstractFragmentContainer
{


    public RootFragment(ServletConfig config)
    throws Exception
    {
        super(null, 
              config, 
              null, 
              null, 
              new Navigation(null,
                             null) );
        getNavigation().setLinkedFragment(this);
    }

    public void createURL(PortalURL url)
    {
        // do nothing
        // we assume that the given url points already to the base portal servlet
    }

    public boolean isPartOfURL(PortalURL url)
    {
        return true;
    }

}
