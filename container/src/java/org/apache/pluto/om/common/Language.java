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

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * <P>
 * This interface provides access to a language and its attributes. 
 * A language is defined in the portlet.xml of a portlet application archive
 * file.
 * </P>
 * <P>
 * This interface defines the model as known from the MVC pattern.
 * Its purpose is to provide read access to the data stored in the model.
 * </P>
 * 

 */
public interface Language extends org.apache.pluto.om.Model
{


    /**
     * Returns the locale
     * 
     * @return the locale
     */
    public Locale getLocale();

    /**
     * Returns the title
     * 
     * @return the title
     */
    public String getTitle();

    /**
     * Returns the short title. The return value may be NULL.
     * 
     * @return the short title
     */
    public String getShortTitle();

    /**
     * Returns the keywords
     * 
     * @return a readonly collection containg the keywords
     */
    public java.util.Iterator getKeywords();

    /**
     * Returns the resource bundle for the portlet for the locale of the language     
     * will be returned.     
     * 
     * @return a resource bundle
     **/
    public ResourceBundle getResourceBundle();
}
