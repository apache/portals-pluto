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
package org.apache.pluto.descriptors.servlet;

import java.util.Set;

/**
 * <B>TODO</B>: Document
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 4, 2005
 */
public class WebResourceCollectionDD {

    private String webResourceName;
    private String description;
    private Set httpMethods;
    private Set urlPatterns;

    public WebResourceCollectionDD() {

    }

    public String getWebResourceName() {
        return webResourceName;
    }

    public void setWebResourceName(String webResourceName) {
        this.webResourceName = webResourceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set getHttpMethods() {
        return httpMethods;
    }

    public void setHttpMethods(Set httpMethods) {
        this.httpMethods = httpMethods;
    }

    public Set getUrlPatterns() {
        return urlPatterns;
    }

    public void setUrlPatterns(Set urlPatterns) {
        this.urlPatterns = urlPatterns;
    }


}

