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

import java.util.List;


/**
 * <P>
 * This interface provides access to change a set of <CODE>Preference</CODE> objects.
 * </P>
 * <P>
 * This interface defines the controller as known from the MVC pattern.
 * Its purpose is to provide write access to the data stored in the model.
 * </P>
 */

public interface PreferenceSetCtrl extends org.apache.pluto.om.Controller
{


    /**
     * Creates a new preference and adds it to the set
     * The return value cannot be NULL.
     * 
     * @param name   the name of the new preference
     * @param values  the values of the new preference
     * 
     * @return the new preference
     */
    public Preference add(String name, List values);

    /**
     * Removes the preference with the given name
     * from the set
     * The return value may be NULL.
     * 
     * @param name   the name of the preference to be removed
     * 
     * @return the removed preference
     */
    public Preference remove(String name);

    /**
     * Removes the given preference from the set
     * 
     * @param preference the preference to be removed
     */
    public void remove(Preference preference);

}
