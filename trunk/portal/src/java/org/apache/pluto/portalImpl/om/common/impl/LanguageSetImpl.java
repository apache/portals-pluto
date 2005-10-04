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

package org.apache.pluto.portalImpl.om.common.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Vector;

import org.apache.pluto.om.common.Language;
import org.apache.pluto.om.common.LanguageSet;
import org.apache.pluto.portalImpl.om.common.AbstractSupportSet;
import org.apache.pluto.portalImpl.om.common.Support;
import org.apache.pluto.util.StringUtils;

public class LanguageSetImpl extends AbstractSupportSet implements LanguageSet, java.io.Serializable, Support
{

    private String castorKeywords;

    private ClassLoader classLoader;

    /**
     * contains Locale objects for locales supported by the portlet
     */
    private Vector locales;
    private boolean resourceBundleInitialized;

    private String resources;
    private String shortTitle;

    private String title;

    public LanguageSetImpl()
    {
        locales = new Vector();
    }

    // create Language object with data from this class (title, short-title, description, keywords)
    private Language createLanguage(Locale locale, ResourceBundle bundle)
    {
        LanguageImpl lang = new LanguageImpl(locale, bundle, title, shortTitle, castorKeywords);
        return lang;
    }

    // AbstractSupportSet implementation.

    public Language get(Locale locale)
    {
        if (resources!=null && resourceBundleInitialized==false)
        {
            initResourceBundle();
            this.resourceBundleInitialized = true;
        }

        if (!locales.contains(locale))
        {
            locale = matchLocale(locale);
        }

        Iterator iterator = this.iterator();
        while (iterator.hasNext())
        {
            Language language = (Language)iterator.next();
            if (language.getLocale().equals(locale) || size()==1)
            {
                return language;
            }
        }

        return null;
    }

    public Iterator getLocales()
    {
        return locales.iterator();
    }

    public Locale getDefaultLocale()
    {
        Locale defLoc = null;

        if (locales != null && locales.size() > 0)
        {
            defLoc = (Locale)locales.firstElement();

            if (defLoc == null)
            {
                defLoc = new Locale("en","");
                locales.add(defLoc);
            }
        }
        else
        {
            defLoc = new Locale("en","");
            locales.add(defLoc);
        }

        return defLoc;
    }

    // Support implementation.

    public void postBuild(Object parameter) throws Exception
    {
    }


    public void postLoad(Object parameter) throws Exception
    {   
        locales.addAll((Collection)parameter);                 
        initInlinedInfos();
        if ( resources != null )
        	initResourceBundle();
    }

    public void postStore(Object parameter) throws Exception
    {
    }

    public void preBuild(Object parameter) throws Exception
    {
    }

    public void preStore(Object parameter) throws Exception
    {
    }


    // internal methods.

    private void initInlinedInfos() throws Exception
    {   
        // if resource-bundle is given
        // must be initialized later when classloader is known by initResourceBundle()            

        if (locales.isEmpty())
        {
            getDefaultLocale(); //the defualt gets automaticaly added to the locals
        }
        if (castorKeywords == null)
        {
            castorKeywords="";
        }
        if (shortTitle == null)
        {
            shortTitle="";
        }
        if (title == null)
        {
            title="";
        }
        boolean added = add(createLanguage(getDefaultLocale(), null));
    }

    // create and add all resource bundle information as Language objects to this set
    private void initResourceBundle()
    {
        Iterator iter = locales.iterator();
        while (iter.hasNext())
        {
            Locale locale = (Locale)iter.next();
            ResourceBundle bundle = null;
            bundle = loadResourceBundle(locale);
            if (bundle != null)
            {
                Language language = createLanguage(locale, bundle);
                remove(language);
                add(language);
            }
        }
    }

    // try to match the given locale to a supported locale
    private Locale matchLocale(Locale locale)
    {

        String variant = locale.getVariant();
        if (variant != null && variant.length() > 0)
        {
            locale = new Locale(locale.getLanguage(), locale.getCountry());                                
        }

        if (! locales.contains(locale))
        {
            String country = locale.getCountry();
            if (country != null && country.length() > 0)
            {
                locale = new Locale(locale.getLanguage(), "");
            }
        }

        if (! locales.contains(locale))
        {
            locale = getDefaultLocale();
        }

        return locale;
    }

    // additional methods.

    public String getCastorKeywords()
    {
        return this.castorKeywords;
    }

    // additional methods

    public String getResources()
    {
        return resources;
    }

    public String getShortTitle()
    {
        return this.shortTitle;
    }

    // internal methods used by castor  
    public String getTitle()
    {
        return this.title;
    }

    // loads resource bundle files from WEB-INF/classes directory
    protected ResourceBundle loadResourceBundle(Locale locale)
    {
        ResourceBundle resourceBundle = null;
        try
        {
            if (classLoader != null)
            {
                resourceBundle=ResourceBundle.getBundle(resources, locale, classLoader);
            }
            else
            {
                resourceBundle=ResourceBundle.getBundle(resources, locale, Thread.currentThread().getContextClassLoader());
            }
        }
        catch (MissingResourceException x)
        {
            return null;
        }
        return resourceBundle;
    }

    public void setCastorKeywords(String keywords)
    {
        this.castorKeywords = keywords;
    }
    // end castor methods


    public void setClassLoader(ClassLoader loader)
    {
        this.classLoader = loader;
    }

    public void setResources(String resources)
    {
        this.resources = resources;
    }

    public void setShortTitle(String shortTitle)
    {
        this.shortTitle = shortTitle;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String toString()
    {
        return toString(0);
    }

    public String toString(int indent)
    {
        StringBuffer buffer = new StringBuffer(50);
        StringUtils.newLine(buffer,indent);
        buffer.append(getClass().toString());
        buffer.append(": ");
        Iterator iterator = this.iterator();
        while (iterator.hasNext())
        {
            buffer.append(((LanguageImpl)iterator.next()).toString(indent+2));
        }
        return buffer.toString();
    }
}
