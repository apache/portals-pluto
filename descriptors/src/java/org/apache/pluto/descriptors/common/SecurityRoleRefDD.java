/*
 * Copyright 2005 The Apache Software Foundation
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
package org.apache.pluto.descriptors.common;

/**
 * Security Role Reference Configuration.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version $Id$
 * @since Feb 28, 2005
 */
public class SecurityRoleRefDD {

    /** The name of the role reference. */
    private String roleName;

    /** The role to which the reference is linked. */
    private String roleLink;

    /** The description of what the role is utilized for. */
    private String description;

    /**
     * Default Constructor.
     */
    public SecurityRoleRefDD() {

    }

    /**
     * Retrieve the name of the role reference.
     * @return
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Set the name of the role reference.
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Retrieve then role to which the reference is linked.
     * @return
     */
    public String getRoleLink() {
        return roleLink;
    }

    /**
     * Set the role to which the reference is linked.
     * @param roleLink
     */
    public void setRoleLink(String roleLink) {
        this.roleLink = roleLink;
    }

    /**
     * Retrieve the description of the role reference.
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the role reference.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}

