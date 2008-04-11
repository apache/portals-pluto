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

import org.apache.pluto.om.servlet.ResourceRef;

/**
 * <B>TODO</B>: Document
 * @version $Id: ResourceRefDD.java 156636 2005-03-09 12:16:31Z cziegeler $
 * @since Feb 28, 2005
 */
public class ResourceRefDD implements ResourceRef {

    private String description;
    private String resRefName;
    private String resType;
    private String resAuth;
    private String resSharingScope;

    public ResourceRefDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ResourceRef#getDescription()
	 */
    public String getDescription() {
        return description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ResourceRef#setDescription(java.lang.String)
	 */
    public void setDescription(String description) {
        this.description = description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ResourceRef#getResRefName()
	 */
    public String getResRefName() {
        return resRefName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ResourceRef#setResRefName(java.lang.String)
	 */
    public void setResRefName(String resRefName) {
        this.resRefName = resRefName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ResourceRef#getResType()
	 */
    public String getResType() {
        return resType;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ResourceRef#setResType(java.lang.String)
	 */
    public void setResType(String resType) {
        this.resType = resType;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ResourceRef#getResAuth()
	 */
    public String getResAuth() {
        return resAuth;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ResourceRef#setResAuth(java.lang.String)
	 */
    public void setResAuth(String resAuth) {
        this.resAuth = resAuth;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ResourceRef#getResSharingScope()
	 */
    public String getResSharingScope() {
        return resSharingScope;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ResourceRef#setResSharingScope(java.lang.String)
	 */
    public void setResSharingScope(String resSharingScope) {
        this.resSharingScope = resSharingScope;
    }

}

