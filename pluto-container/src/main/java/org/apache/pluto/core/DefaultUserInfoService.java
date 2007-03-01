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
package org.apache.pluto.core;

import org.apache.pluto.spi.optional.UserInfoService;
import org.apache.pluto.PortletContainerException;

import javax.portlet.PortletRequest;
import java.util.Map;
import java.util.HashMap;

/**
 * UserInfo
 *
 */
public class DefaultUserInfoService implements UserInfoService {

    private Map userInfoMap = new HashMap();

    public Map getUserInfo(PortletRequest request) throws PortletContainerException {
        Map retval = null;
        if ( request.getRemoteUser() != null ) {
        	retval= (Map)userInfoMap.get(request.getRemoteUser());
        }
        if ( retval == null ) {
        	retval = new HashMap();
        }
        return retval;
    }

    public void setUserInfo(String userName, Map userInfoMap) {
        userInfoMap.put(userName, userInfoMap);
    }

    public void removeUserInfo(String userName) {
        userInfoMap.remove(userName);
    }
}
