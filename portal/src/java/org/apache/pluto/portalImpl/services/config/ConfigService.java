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

package org.apache.pluto.portalImpl.services.config;

import org.apache.pluto.portalImpl.services.Service;
import org.apache.pluto.portalImpl.util.Parameters;

/**
 ** The <CODE>ConfigService</CODE> holds the basic portal
 ** configuration.
 **
 ** @see   Config
 **/

public abstract class ConfigService extends Service
{

    /**
     ** Returns the configuration parameters managed by this service.
     **
     ** @return   the configuration parameters
     **/

    public abstract Parameters getParameters ();


    public String getString (String name)
    {
        return getParameters().getString(name);
    }

    public String getString (String name, String defaultValue)
    {
        return getParameters().getString(name, defaultValue);
    }

    public Integer getInteger (String name)
    {
        return getParameters().getInteger(name);
    }

    public Integer getInteger (String name, Integer defaultValue)
    {
        return getParameters().getInteger(name, defaultValue);
    }

    public int getInteger (String name, int defaultValue)
    {
        return getParameters().getInteger(name, defaultValue);
    }

    public Boolean getBoolean (String name)
    {
        return getParameters().getBoolean(name);
    }

    public Boolean getBoolean (String name, Boolean defaultValue)
    {
        return getParameters().getBoolean(name, defaultValue);
    }

    public boolean getBoolean (String name, boolean defaultValue)
    {
        return getParameters().getBoolean(name, defaultValue);
    }

    public java.util.Iterator keys ()
    {
        return getParameters().keys();
    }

}
