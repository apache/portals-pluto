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

package org.apache.pluto.om.common;

/**
 * <P>
 * The <CODE>Preference</CODE> interface provides access to a preference and its attributes.
 * </P>
 * <P>
 * This interface defines the model as known from the MVC pattern.
 * Its purpose is to provide read access to the data stored in the model.
 * </P>
 * 

 */
public interface Preference extends org.apache.pluto.om.Model
{


    /**
     * Returns the name
     * 
     * @return the name
     */
    public String getName();

    /**
     * Returns the values in a readonly collection
     * 
     * @return the values
     */
    public java.util.Iterator getValues();

    /**
     * Returns whether this preference is modifiable
     * 
     * @return true, if this preference is modifiable
     */
    public boolean isReadOnly();
    
    /**
     * Returns whether this preference is set or not
     *              
     * @return <code>true</code>, if this preference is set
     */
    public boolean isValueSet();
}
