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

package org.apache.pluto.portalImpl.services.pageregistry;

import org.apache.pluto.portalImpl.aggregation.Fragment;
import org.apache.pluto.portalImpl.aggregation.RootFragment;
import org.apache.pluto.portalImpl.services.ServiceManager;

/**
 * This class is a static accessor for a <code>PageRegistryService</code>
 * implementation.
 * 

 */
public class PageRegistry
{


    private final static PageRegistryService cService = 
        (PageRegistryService) ServiceManager.getService (PageRegistryService.class);

    /**
     * Returns the description of the complete portal site
     * 
     * @return the object model description
     */
    public static RootFragment getRootFragment()
    {
        return cService.getRootFragment();
    }

    /**
     * Returns the fragment with the given id
     *
     * return the fragment object with this id
     **/
    public static Fragment getFragment(String id) {
        return cService.getFragment(id);
    }

    /**
     * Add a fragment to the page registry
     * 
     * @param fragment the fragment to add
     **/
    public static void addFragment(Fragment fragment) throws Exception{
        cService.addFragment(fragment);
    }
}
