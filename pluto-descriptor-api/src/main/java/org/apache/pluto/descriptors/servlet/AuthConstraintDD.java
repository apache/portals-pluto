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
package org.apache.pluto.descriptors.servlet;

import org.apache.pluto.om.servlet.AuthConstraint;

/**
 * <B>TODO</B>: Document
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version $Id: AuthConstraintDD.java 156636 2005-03-09 12:16:31Z cziegeler $
 * @since Feb 28, 2005
 */
public class AuthConstraintDD implements AuthConstraint {

    private String description;
    private String roleName;

    public AuthConstraintDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.AuthConstraint#getDescription()
	 */
    public String getDescription() {
        return description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.AuthConstraint#setDescription(java.lang.String)
	 */
    public void setDescription(String description) {
        this.description = description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.AuthConstraint#getRoleName()
	 */
    public String getRoleName() {
        return roleName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.AuthConstraint#setRoleName(java.lang.String)
	 */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}

