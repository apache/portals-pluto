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

package org.apache.pluto.portalImpl.om;

import org.apache.pluto.om.*;

public class ControllerFactoryImpl implements ControllerFactory
{

    // ControllerFactory implementation.
    
    public void init(javax.servlet.ServletConfig config, 
                     java.util.Map properties) throws Exception
    {
    }
    
    // additional methods.
    
    public void destroy() throws Exception
    {
    }

    public Controller get(Model model)
    {
        if (model instanceof org.apache.pluto.portalImpl.om.common.impl.UnmodifiableSet)
        {
            model = (Model)((org.apache.pluto.portalImpl.om.common.impl.UnmodifiableSet)model).getModifiableSet();
        }
        return (Controller)model;
    }

}
