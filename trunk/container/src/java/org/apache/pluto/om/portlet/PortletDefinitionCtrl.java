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

package org.apache.pluto.om.portlet;

import org.apache.pluto.om.common.DescriptionSet;
import org.apache.pluto.om.common.DisplayNameSet;

/**
 * <P>
 * The <CODE>PortletDefinitionCtrl</CODE> interface ...
 * </P>
 * <P>
 * This interface defines the controller as known from the MVC pattern.
 * Its purpose is to provide write access to the data stored in the model.
 * </P>
 * 

 */
public interface PortletDefinitionCtrl extends org.apache.pluto.om.Controller
{


    /**
     * Binds an identifier to this portlet
     * 
     * @param id the new identifier
     */
    public void setId(String id);

    /**
     * Sets the new class name
     * 
     * @param className the new class name
     */
    public void setClassName(String className);

    /**
     * Binds an administrative name
     * 
     * @param name the new administrative name
     */
    public void setName(String name);

    /**
     * Sets the descriptions
     * 
     * @param descriptions the new description
     */
    public void setDescriptions(DescriptionSet descriptions);

    /**
     * Sets the display names
     * 
     * @param displayNames the new display names
     */
    public void setDisplayNames(DisplayNameSet displayNames);


    /**
     * Sets the class loader of the portlet
     * 
     * @param loader
     */
    public void setPortletClassLoader(ClassLoader loader);

    /**
     * Stores the object persistently
     * 
     * @exception java.io.IOException
     *                   in case of trouble fulfilling the request
     */
    public void store() throws java.io.IOException;


}
