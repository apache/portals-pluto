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


/**
 * <P>
 * The <CODE>Navigation</CODE> interface represents the navigational
 * information linked with one fragment.
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
public interface Navigation
{


    /**
     * Returns the title
     * 
     * @return the title as string
     */
    public String getTitle();

    /**
     * Sets the title
     * 
     * @param title   the title to be set
     */
    public void setTitle(String title);

    /**
     * Returns the description of this property
     * 
     * @return the description as string
     */
    public String getDescription();

    /**
    * Sets the description of this property
    * 
    * @param description  the description to be set
    */
    public void setDescription(String description);
    
}
