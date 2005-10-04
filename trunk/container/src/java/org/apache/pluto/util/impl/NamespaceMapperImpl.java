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

package org.apache.pluto.util.impl;

import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.util.NamespaceMapper;

/**
 **/

public class NamespaceMapperImpl implements NamespaceMapper
{
    public NamespaceMapperImpl()
    {
    }

    // org.apache.pluto.util.NamespaceMapper implementation ---------------------------------------
    public String encode(ObjectID ns, String name)
    {
        StringBuffer buffer = new StringBuffer(50);
        buffer.append("Pluto_");
        buffer.append(ns);
        buffer.append('_');
        buffer.append(name);
        return buffer.toString();
    }

    public String encode(ObjectID ns1, ObjectID ns2, String name)
    {
        StringBuffer buffer = new StringBuffer(50);
        buffer.append("Pluto_");
        buffer.append(ns1);
        buffer.append('_');
        buffer.append(ns2);
        buffer.append('_');
        buffer.append(name);
        return buffer.toString();
    }

    public String decode(ObjectID ns, String name)
    {
        if (!name.startsWith("Pluto_"))
        {
            return null;
        }
        StringBuffer buffer = new StringBuffer(50);
        buffer.append("Pluto_");
        buffer.append(ns);
        buffer.append('_');
        if (!name.startsWith(buffer.toString()))
        {
            return null;
        }
        return name.substring(buffer.length());
    }
    // --------------------------------------------------------------------------------------------
}
