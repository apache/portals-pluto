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

package org.apache.pluto.portalImpl.om.servlet.impl;

import org.apache.pluto.util.StringUtils;

public class TagDefinitionImpl  implements java.io.Serializable {
    
    private String uri ="http://java.sun.com/portlet";
    private String location = "/WEB-INF/tld/portlet.tld";

    public TagDefinitionImpl()
    {
        super();
    }
    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @param string the new location
     */
    public void setLocation(String string) {
        location = string;
    }

    /**
     * @param string the uri
     */
    public void setUri(String string) {
        uri = string;
    }

    /**
     * Print a string representation of this tag definition.
     * The results of this toString() implementation are meant
     * for debugging purposes.
     *
     * @return String representation of this tag definition.
     */
    public String toString()
    {
        return toString(0);
    }

    public String toString(int indent)
    {
        StringBuffer buffer = new StringBuffer(50);
        StringUtils.newLine(buffer,indent);
        buffer.append(getClass().toString()); buffer.append(":");
        StringUtils.newLine(buffer,indent);
        buffer.append("{");
        StringUtils.newLine(buffer,indent);
        buffer.append("taglib-uri='"); buffer.append(this.getUri()); buffer.append("'");
        StringUtils.newLine(buffer,indent);
        buffer.append("taglib-location='"); buffer.append(this.getLocation()); buffer.append("'");
        StringUtils.newLine(buffer,indent);
        buffer.append("}");
        return buffer.toString();
    }

}
