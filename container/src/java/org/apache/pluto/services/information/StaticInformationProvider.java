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
 
package org.apache.pluto.services.information;

import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.portlet.PortletDefinition;
/**
 * Provide information from the portal to portlet container
 * that don't change between requests.
 */

public interface StaticInformationProvider
{
 
    /**
     * Returns the portal context
     *
     * @return the portal context
     */
     public PortalContextProvider getPortalContextProvider();


    /**
     * Returns the portlet model to the passed guid
     * 
     * @param portletGUID
     *               the GUID of the portlet model to be returned
     * 
     * @return the portlet model
     */
    public PortletDefinition getPortletDefinition(ObjectID portletGUID);

}
