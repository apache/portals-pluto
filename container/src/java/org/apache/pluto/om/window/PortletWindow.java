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

package org.apache.pluto.om.window;

import org.apache.pluto.om.Model;
import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.entity.PortletEntity;

/**
 * <P>
 * The <CODE>PortletWindow</CODE> interface represents a single window
 * of a portlet instance as it can be shown only once on a single page. 
 * There is a one-to-one relation between portlet windows and portlet entities.
 * Adding the same portlet e.g. twice on a page results in two different windows.
 * </P>
 * <P>
 * This interface defines the model as known from the MVC pattern.
 * Its purpose is to provide read access to the data stored in the model.
 * </P>
 * 
 **/
public interface PortletWindow extends Model {


    /**
     * Returns the identifier of this portlet instance window as object id.
     * The return value cannot be NULL.
     * 
     * @return the object identifier
     **/
    public ObjectID getId();   

    /**
     * Returns the portlet entity.
     * The return value cannot be NULL.
     * 
     * @return the portlet entity
     **/
    public PortletEntity getPortletEntity();

}
