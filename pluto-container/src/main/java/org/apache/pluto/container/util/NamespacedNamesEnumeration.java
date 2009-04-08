/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.container.util;


import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public class NamespacedNamesEnumeration implements Enumeration<String>
{
    private Enumeration<String> namesEnumeration;
    private String      namespace;

    private String nextName;
    private boolean done;

    public NamespacedNamesEnumeration(Enumeration<String> namesEnumeration, String namespace)
    {
        this.namesEnumeration = namesEnumeration;
        this.namespace = namespace;
        hasMoreElements();
    }

    public boolean hasMoreElements()
    {
        if (!done)
        {
            if (nextName == null)
            {
                while (namesEnumeration.hasMoreElements())
                {
                    String name = namesEnumeration.nextElement();
                    if ( name.startsWith(namespace))
                    {
                        nextName = name.substring(namespace.length());
                        break;
                    }
                }
                done = nextName == null;
            }
        }
        return !done;
    }

    public String nextElement()
    {
        if (done)
        {
            throw new NoSuchElementException();
        }
        String name = nextName;
        nextName = null;
        return name;
    }
}
