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

package org.apache.pluto.portalImpl.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Iterator;

/**
 ** This class loads name/value pairs from a properties
 ** file. The properties file is specified as input stream
 ** and follows the usual convention for Java properties files.
 **/

public class Properties extends NameValuePairs
{

    /**
     ** Loads name/value pairs from the given input stream.
     **/

    public void load (InputStream aInputStream) throws IOException
    {
        if (aInputStream == null)
            return;

        BufferedReader reader = new BufferedReader (new InputStreamReader (aInputStream, "UTF-8"));

        String line;

        while ((line = reader.readLine ()) != null)
        {
            if (line.startsWith ("#") ||
                line.startsWith ("//"))
            {
                continue;
            }

            int index = line.indexOf ('=');

            if (index > 0)
            {
                String name  = line.substring (0, index).trim ();

                if (name.length () == 0)
                    name = null;

                String value = null;

                if (index + 1 < line.length ())
                {
                    value = line.substring (index + 1).trim ();

                    if (value.length () == 0)
                        value = null;
                }

                if (name != null && value != null)
                {
                    add (name, value);
                }
            }
        }
    }


    /**
     ** Returns a subset of the NameValuePairs where the names are starting with the specified prefix.
     ** As keys of the result set all start with the same prefix, this prfix is cut off.</br>
     ** E.g:</br>
     ** Given following set: {[A1,x], [A2,y], [A3,z], [B1,x], [B2,y]]}</br>
     ** getSubSet("A") returns {[1,x], [2,y], [3,z]}</p>
     **
     ** Please note: the implementation of this method is <b>slow</b>, to be used only for initialisation tasks or alike!
     **
     ** @param   aNamePrefix
     **          the prefix that all returned pair names have in common.
     **/

    public Properties getSubSet (String aNamePrefix)
    {
        Properties subset = new Properties();
        int prefixLength = aNamePrefix.length();
        String name;

        for (Iterator iter = this.names (); iter.hasNext () ; )
        {
            name = (String) iter.next ();

            if (name.startsWith(aNamePrefix))
            {
                subset.add( name.substring(prefixLength), getStrings(name));
            }
        }
        return (subset);
    }
}
