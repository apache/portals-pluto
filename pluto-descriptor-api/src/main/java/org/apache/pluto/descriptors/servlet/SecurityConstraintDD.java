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
package org.apache.pluto.descriptors.servlet;

import java.util.List;

import org.apache.pluto.om.common.UserDataConstraint;
import org.apache.pluto.om.servlet.AuthConstraint;
import org.apache.pluto.om.servlet.SecurityConstraint;

/**
 * <B>TODO</B>: Document
 * @version $Id: SecurityConstraintDD.java 156636 2005-03-09 12:16:31Z cziegeler $
 * @since Feb 28, 2005
 */
public class SecurityConstraintDD implements SecurityConstraint {

    private String displayName;
    private List webResourceCollection;
    private AuthConstraint authConstraint;
    private UserDataConstraint userDataConstraint;

    public SecurityConstraintDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.SecurityConstraint#getDisplayName()
	 */
    public String getDisplayName() {
        return displayName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.SecurityConstraint#setDisplayName(java.lang.String)
	 */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.SecurityConstraint#getWebResourceCollections()
	 */
    public List getWebResourceCollections() {
        return webResourceCollection;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.SecurityConstraint#setWebResourceCollections(java.util.List)
	 */
    public void setWebResourceCollections(List webResourceCollection) {
        this.webResourceCollection = webResourceCollection;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.SecurityConstraint#getAuthConstraint()
	 */
    public AuthConstraint getAuthConstraint() {
        return authConstraint;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.SecurityConstraint#setAuthConstraint(org.apache.pluto.descriptors.servlet.AuthConstraint)
	 */
    public void setAuthConstraint(AuthConstraint authConstraint) {
        this.authConstraint = authConstraint;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.SecurityConstraint#getUserDataConstraint()
	 */
    public UserDataConstraint getUserDataConstraint() {
        return userDataConstraint;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.SecurityConstraint#setUserDataConstraint(org.apache.pluto.om.common.UserDataConstraint)
	 */
    public void setUserDataConstraint(
        UserDataConstraint userDataConstraint) {
        this.userDataConstraint = userDataConstraint;
    }


}

