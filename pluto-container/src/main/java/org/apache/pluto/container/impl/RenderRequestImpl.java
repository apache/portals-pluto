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
package org.apache.pluto.container.impl;

import javax.portlet.CacheControl;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;

import org.apache.pluto.container.PortletRenderResponseContext;
import org.apache.pluto.container.PortletRequestContext;

/**
 * Implementation of the <code>javax.portlet.RenderRequest</code> interface.
 * 
 */
public class RenderRequestImpl extends PortletRequestImpl implements RenderRequest 
{
    private CacheControl cacheControl;
    
    public RenderRequestImpl(PortletRequestContext requestContext, PortletRenderResponseContext responseContext) 
    {
        super(requestContext, responseContext, PortletRequest.RENDER_PHASE);
        this.cacheControl = responseContext.getCacheControl();
    }

    @Override
    public String getProperty(String name)
    {
        String result = getMimeRequestProperty(name, cacheControl);
        return result != null ? result : super.getProperty(name);
   }

    public String getETag()
    {
        return cacheControl.getETag();
    }
}
