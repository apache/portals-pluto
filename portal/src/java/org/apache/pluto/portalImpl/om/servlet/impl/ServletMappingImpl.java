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

 */

package org.apache.pluto.portalImpl.om.servlet.impl;

import org.apache.pluto.util.StringUtils;

public class ServletMappingImpl implements java.io.Serializable {

    private String id;
    private String servletName;
    private String urlPattern;

    public ServletMappingImpl()
    {
    }

    // additional methods.

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getServletName()
    {
        return servletName;
    }

    public void setServletName(String servletName)
    {
        this.servletName = servletName;
    }

    public String getUrlPattern()
    {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern)
    {
        this.urlPattern = urlPattern;
    }

    // internal methods used for debugging purposes only

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
        buffer.append("id='"); buffer.append(id); buffer.append("'");
        StringUtils.newLine(buffer,indent);
        buffer.append("servletName='"); buffer.append(servletName); buffer.append("'");
        StringUtils.newLine(buffer,indent);
        buffer.append("urlPattern='"); buffer.append(urlPattern); buffer.append("'");
        StringUtils.newLine(buffer,indent);
        buffer.append("}");
        return buffer.toString();
    }

}
