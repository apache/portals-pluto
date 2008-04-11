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

import java.util.ArrayList;
import java.util.List;

import org.apache.pluto.om.servlet.WebResourceCollection;

/**
 * Web Resource Collection configuration.
 *
 * @version $Id: WebResourceCollectionDD.java 157475 2005-03-14 22:13:18Z ddewolf $
 * @since Mar 4, 2005
 */
public class WebResourceCollectionDD implements WebResourceCollection {

    private String webResourceName;
    private String description;
    private List httpMethods = new ArrayList();
    private List urlPatterns = new ArrayList();

    public WebResourceCollectionDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebResourceCollection#getWebResourceName()
	 */
    public String getWebResourceName() {
        return webResourceName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebResourceCollection#setWebResourceName(java.lang.String)
	 */
    public void setWebResourceName(String webResourceName) {
        this.webResourceName = webResourceName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebResourceCollection#getDescription()
	 */
    public String getDescription() {
        return description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebResourceCollection#setDescription(java.lang.String)
	 */
    public void setDescription(String description) {
        this.description = description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebResourceCollection#getHttpMethods()
	 */
    public List getHttpMethods() {
        return httpMethods;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebResourceCollection#setHttpMethods(java.util.List)
	 */
    public void setHttpMethods(List httpMethods) {
        this.httpMethods = httpMethods;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebResourceCollection#getUrlPatterns()
	 */
    public List getUrlPatterns() {
        return urlPatterns;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebResourceCollection#setUrlPatterns(java.util.List)
	 */
    public void setUrlPatterns(List urlPatterns) {
        this.urlPatterns = urlPatterns;
    }


}

