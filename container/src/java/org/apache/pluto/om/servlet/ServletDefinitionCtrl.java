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

package org.apache.pluto.om.servlet;

import org.apache.pluto.om.common.DescriptionSet;
import org.apache.pluto.om.common.DisplayNameSet;

/**
 * <P>
 * The <CODE>ServletDefinitionCtrl</CODE> interface ...
 * </P>
 * <P>
 * This interface defines the controller as known from the MVC pattern.
 * Its purpose is to provide write access to the data stored in the model.
 * </P>
 */
public interface ServletDefinitionCtrl extends org.apache.pluto.om.Controller
{


    /**
     * Binds an identifier to this servlet
     * 
     * @param id the new  identifier
     */
    public void setId(String id);

    /**
     * Binds an servlet name to this servlet
     * 
     * @param name the new servlet name
     */
    public void setServletName(String name);

   /**
     * Sets the descriptions
     * 
     * @param name the new description
     */
    public void setDescriptions(DescriptionSet descriptions);

    /**
     * Sets the display names
     * 
     * @param name the new display names
     */
    public void setDisplayNames(DisplayNameSet displayNames);

    /**
     * Sets the class name of this servlet
     * 
     * @param name the new class name
     */
    public void setServletClass(String servletClass);
    
    /**
     * Sets the available date/time for this servlet, in milliseconds since the
     * epoch.  If this date/time is in the future the servlet is unavailable.
     *
     * @param available The new available date/time
     */
    public void setAvailable(long available);
}
