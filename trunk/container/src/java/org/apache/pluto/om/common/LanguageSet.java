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

import java.util.Iterator;
import java.util.Locale;

/**
 * <P>
 * This interface provides access to a set of <CODE>Language</CODE> objects.
 * </P>
 * <P>
 * This interface defines the model as known from the MVC pattern.
 * Its purpose is to provide read access to the data stored in the model.
 * </P>
 * 

 */
public interface LanguageSet extends org.apache.pluto.om.Model
{

    /**
     * Returns all elements of this set as iterator
     * The return value cannot be NULL.
     * 
     * @return An iterator containing all language objects 
     */
    public Iterator iterator();

    /**
     * Returns a iterator of all supported locales by this portlet
     * The return value cannot be NULL.
     *
     * @return an iterator containing all supported locales as java.util.Locale objects
     */
    public Iterator getLocales();

    /**
     * Returns the language object of the given locale.
     * If the given locale is not supported the Language of the preferred locale 
     * will be returned.
     * The return value may be NULL if there is no preferred locale as well.
     * 
     * @return the language object of the given locale
     */
    public Language get(Locale locale); 

    /**
     * Returns the default locale object or NULL if there is no default locale
     * 
     * @return the default locale object or NULL if there is no default locale
     */
    public java.util.Locale getDefaultLocale();
}
