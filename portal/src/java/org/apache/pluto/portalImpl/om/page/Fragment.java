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

package org.apache.pluto.portalImpl.om.page;

import java.util.*;

/**
 * <P>
 * The <CODE>Fragment</CODE> interface represents a single fragment on a site,
 * such as a page, a row, or even a portlet fragment
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
public interface Fragment
{


    /**
     * Returns the administrative name of this fragment
     * 
     * @return the administrative name
     */
    public String getName();

    /**
     * binds an administrative name to this fragment
     * 
     * @param name the administrative name
     */
    public void setName(String name);

    /**
     * Returns the type of the class bound to this fragment
     * 
     * @return the type
     */
    public String getType();

    /**
     * binds a type to this fragment
     * 
     * @param type the type
     */
    public void setType(String type);

    /**
     * Returns the classname of the class bound to this fragment
     * 
     * @return the classname
     */
    public String getClassname();

    /**
     * binds a classname to this fragment
     * 
     * @param classname the classname
     */
    public void setClassname(String classname);

    /**
     * Returns the navigational information linked with this fragment.
     * The return value may be NULL, if no navigational information is defined.
     * 
     * @return the navigational information
     */
    public Navigation getNavigation();

    /**
     * binds navigational information to this fragment
     * 
     * @param navigation the navigational information
     */
    public void setNavigation(Navigation navigation);

    /**
     * Returns all fragments used in this node. This may be
     * a page fragment or even directly a portlet fragment
     * 
     * @return a collection containing Fragment objects
     */
    public Collection getFragments();

    /**
     * Returns all properties describing this fragment. Only the
     * implementation of the "classname" knows how to handle the
     * properties
     * 
     * @return a collection containing Property objects
     */
    public Collection getProperties();

}
