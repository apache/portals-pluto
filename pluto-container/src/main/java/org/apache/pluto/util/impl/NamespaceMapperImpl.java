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

import org.apache.pluto.PortletWindowID;
import org.apache.pluto.util.NamespaceMapper;

/**
 * Default implementation of <code>NamespaceMapper</code> interface.
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class NamespaceMapperImpl implements NamespaceMapper {
	
    public NamespaceMapperImpl() {
    	// Do nothing.
    }
    
    
    // NamespaceMapper Impl ----------------------------------------------------
    
    public String encode(PortletWindowID ns, String name) {
        StringBuffer buffer = new StringBuffer(50);
        buffer.append("Pluto_");
        buffer.append(ns);
        buffer.append('_');
        buffer.append(name);
        return buffer.toString();
    }

    public String encode(PortletWindowID ns1, PortletWindowID ns2, String name) {
        StringBuffer buffer = new StringBuffer(50);
        buffer.append("Pluto_");
        buffer.append(ns1);
        buffer.append('_');
        buffer.append(ns2);
        buffer.append('_');
        buffer.append(name);
        return buffer.toString();
    }

    public String decode(PortletWindowID ns, String name) {
        if (!name.startsWith("Pluto_")) {
            return null;
        }
        StringBuffer buffer = new StringBuffer(50);
        buffer.append("Pluto_");
        buffer.append(ns);
        buffer.append('_');
        if (!name.startsWith(buffer.toString())) {
            return null;
        }
        return name.substring(buffer.length());
    }
    
}
