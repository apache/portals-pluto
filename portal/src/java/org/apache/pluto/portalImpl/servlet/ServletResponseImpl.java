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

package org.apache.pluto.portalImpl.servlet;

import javax.servlet.http.*;

public class ServletResponseImpl extends javax.servlet.http.HttpServletResponseWrapper 
{

    public ServletResponseImpl(HttpServletResponse response)
    {
        super(response);
    }

    private javax.servlet.http.HttpServletResponse _getHttpServletResponse()
    {
        return(javax.servlet.http.HttpServletResponse) super.getResponse();
    }

    public void setResponse(HttpServletResponse response) 
    {
        super.setResponse(response);
    }
    
// HttpServletResponseWrapper overlay

}
