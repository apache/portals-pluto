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

import org.apache.pluto.factory.NamespaceMapperFactory;
import org.apache.pluto.util.NamespaceMapper;

public class NamespaceMapperFactoryImpl implements NamespaceMapperFactory
{

    private javax.servlet.ServletConfig servletConfig;
    private NamespaceMapperImpl namespaceMapper;
    
    public void init(javax.servlet.ServletConfig config, java.util.Map properties) throws Exception
    {
        servletConfig = config;
        namespaceMapper = new NamespaceMapperImpl();
    }
    
    public void destroy() throws Exception
    {
    }

    public NamespaceMapper getNamespaceMapper()
    {
        return namespaceMapper;
    }

}
