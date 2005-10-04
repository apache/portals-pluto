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

package org.apache.pluto.om.entity;

import org.apache.pluto.om.portlet.PortletDefinition;

/**
 * <P>
 * The <CODE>PortletEntityCtrl</CODE> interface represents a single portlet occurance,
 * that can be shown on a single page or on multiple pages.
 * </P>
 * <P>
 * This interface defines the controller as known from the MVC pattern.
 * Its purpose is to provide write access to the data stored in the model.
 * </P>
 * 

 */
public interface PortletEntityCtrl extends org.apache.pluto.om.Controller
{


    /**
     * binds an identifier to this portlet instance
     * 
     * @param id the new identifier
     */
    public void setId(String id);

    /**
     * Sets the portlet definition for this entity.
     * This value should not be null
     * 
     * @param portletDefinition the portlet description
     */
    public void setPortletDefinition(PortletDefinition portletDefinition);

    /**
     * Stores the object persistently
     * 
     * @exception java.io.IOException
     *                   in case of trouble fulfilling the request
     */
    public void store() throws java.io.IOException;

    /**
     * Reset all changes made until the last <code>store</code>
     * call in the persistent store.
     * 
     * @exception java.io.IOException
     *                   in case of trouble fulfilling the request
     */
    public void reset() throws java.io.IOException;

}
