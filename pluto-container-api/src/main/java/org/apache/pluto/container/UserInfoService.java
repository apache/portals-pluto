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
package org.apache.pluto.container;

import java.util.Map;

import javax.portlet.PortletRequest;


/**
 * Used to access user information attributes as described in
 * PLT.17.2 of the JSR-168 specificiation. Attribute persistence is
 * not covered by the spec so it is not done here.
 *
 */
public interface UserInfoService {
    /**
     * Retrieve the user attribues and their values associated with the given
     * request and window. This can return null if the user associated with the
     * request is un-authenticated.
     * 
     * The result map will contain only the named attributes as defined on the
     * portlet definition for the PortletWindow.
     *  
     * @param request Used to extract the authenticated user name.
     * @param window The portlet window to get user attributes for.
     * @return A map of names and values of user information attributes
     *         for a particular authenticated user. null if the user is not authenticated.
     */
    Map<String, String> getUserInfo(PortletRequest request, PortletWindow window) throws PortletContainerException;
}