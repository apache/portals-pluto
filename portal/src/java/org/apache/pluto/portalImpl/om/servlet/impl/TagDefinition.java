/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
/* 
 * (C) Copyright IBM Corp. 2003 
 */
package org.apache.pluto.portalImpl.om.servlet.impl;

public class TagDefinition  {
    
    private String uri ="http://java.sun.com/portlet";
    private String location = "/WEB-INF/tld/portlet.tld";
    
    /**
     * Retrieve the location of the tag definition.
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Retrieve the uri of the tag definition.
     * @return uri
     */
    public String getUri() {
        return uri;
    }

    /**
     *  Set the location of the tag definition.
     * @param string
     */
    public void setLocation(String string) {
        location = string;
    }

    /**
     * Set the uri of the tag definition.
     * @param string
     */
    public void setUri(String string) {
        uri = string;
    }

}
