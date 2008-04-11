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

import org.apache.pluto.om.servlet.EjbRef;

/**
 * <B>TODO</B>: Document
 * @version $Id: EjbRefDD.java 156636 2005-03-09 12:16:31Z cziegeler $
 * @since Feb 28, 2005
 */
public class EjbRefDD implements EjbRef {

    private String description;
    private String ejbRefName;
    private String ejbRefType;
    private String home;
    private String remote;
    private String ejbLink;
    private String runAs;

    public EjbRefDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EjbRef#getDescription()
	 */
    public String getDescription() {
        return description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EjbRef#setDescription(java.lang.String)
	 */
    public void setDescription(String description) {
        this.description = description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EjbRef#getEjbRefName()
	 */
    public String getEjbRefName() {
        return ejbRefName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EjbRef#setEjbRefName(java.lang.String)
	 */
    public void setEjbRefName(String ejbRefName) {
        this.ejbRefName = ejbRefName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EjbRef#getEjbRefType()
	 */
    public String getEjbRefType() {
        return ejbRefType;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EjbRef#setEjbRefType(java.lang.String)
	 */
    public void setEjbRefType(String ejbRefType) {
        this.ejbRefType = ejbRefType;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EjbRef#getHome()
	 */
    public String getHome() {
        return home;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EjbRef#setHome(java.lang.String)
	 */
    public void setHome(String home) {
        this.home = home;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EjbRef#getRemote()
	 */
    public String getRemote() {
        return remote;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EjbRef#setRemote(java.lang.String)
	 */
    public void setRemote(String remote) {
        this.remote = remote;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EjbRef#getEjbLink()
	 */
    public String getEjbLink() {
        return ejbLink;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EjbRef#setEjbLink(java.lang.String)
	 */
    public void setEjbLink(String ejbLink) {
        this.ejbLink = ejbLink;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EjbRef#getRunAs()
	 */
    public String getRunAs() {
        return runAs;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EjbRef#setRunAs(java.lang.String)
	 */
    public void setRunAs(String runAs) {
        this.runAs = runAs;
    }

}

