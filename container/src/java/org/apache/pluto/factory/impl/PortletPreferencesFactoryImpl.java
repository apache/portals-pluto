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

package org.apache.pluto.factory.impl;

import javax.portlet.*;

import org.apache.pluto.factory.*;
import org.apache.pluto.core.impl.PortletPreferencesImpl;
import org.apache.pluto.om.entity.PortletEntity;
import org.apache.pluto.om.portlet.PortletDefinition;


public class PortletPreferencesFactoryImpl implements PortletPreferencesFactory {

    public void init(javax.servlet.ServletConfig config, java.util.Map properties) throws Exception
    {
    }

    // org.apache.pluto.factory.PortletPreferencesFactory -----------------------------------------
    public PortletPreferences getPortletPreferences(Integer methodId, PortletEntity portletEntity)
    {
        return new PortletPreferencesImpl(methodId, portletEntity);
    }

    public PortletPreferences getPortletPreferences(Integer methodId, PortletDefinition portletDefinition)
    {
        return new PortletPreferencesImpl(methodId, portletDefinition);
    }
    // --------------------------------------------------------------------------------------------

    // additional methods -------------------------------------------------------------------------
    public void destroy() throws Exception
    {
    }
    // --------------------------------------------------------------------------------------------
}
