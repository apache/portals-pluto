/*
 * Copyright 2004 The Apache Software Foundation
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
package org.apache.pluto.descriptors.portlet;

import java.util.Map;
import java.util.List;

/**
 * Bare bones implementation of the Portlet descriptor.
 * Eventually this should be flushed out :), but for the sake
 * of timing I'll be lazy for now.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 6, 2005
 */
public class PortletDD {

    private String portletName;
    private String portletClass;
    private List securityRoleRefs;

    public PortletDD() {

    }

    public String getPortletName() {
        return portletName;
    }

    public void setPortletName(String portletName) {
        this.portletName = portletName;
    }

    public String getPortletClass() {
        return portletClass;
    }

    public void setPortletClass(String portletClass) {
        this.portletClass = portletClass;
    }

    public List getSecurityRoleRefs() {
        return securityRoleRefs;
    }

    public void setSecurityRoleRefs(List securityRoleRefs) {
        this.securityRoleRefs = securityRoleRefs;
    }

}

