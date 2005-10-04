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
import org.apache.pluto.portalImpl.services.Service;

/**
 * <P>
 * The <CODE>PageRegistryService</CODE> interface represents a complete site
 * with all pages, windows and portlet entries on it. It is accessed
 * by the datastore layer to get information about the site.
 * </P>
 * <P>
 * The interfaces defined in this package represent an abstract object
 * model (OM) that is applicable for different implementations.
 * The abstract OM defines only how the data is stored and accessed
 * in the memory. Each implementation can store the data in different ways.
 * </P>
 * <P>
 * This abstraction layer helps to generalize the portlet container from
 * special implementations like data storage and moreover it is not bound
 * to a special Application Server.
 * </P>
 * 

 */
public abstract class PageRegistryService extends Service
{


    /**
     * Returns the description of the complete portal site.
     * 
     * @return the object model description
     */
    public abstract RootFragment getRootFragment();

    /**
     * Returns the fragment with the given id.
     *
     * return the fragment object with this id
     **/
    public abstract Fragment getFragment(String id);
    
   /**
    * Add a fragment to the page registry.
    * 
    * @param fragment the fragment to add
    **/
    public abstract void addFragment(Fragment fragment) throws Exception;
}
