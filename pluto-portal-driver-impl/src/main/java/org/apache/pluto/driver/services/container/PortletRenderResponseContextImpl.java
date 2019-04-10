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
package org.apache.pluto.driver.services.container;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletRenderResponseContext;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.driver.AttributeKeys;

/**
 * @version $Id$
 *
 */
public class PortletRenderResponseContextImpl extends PortletMimeResponseContextImpl implements
                PortletRenderResponseContext
{
    public PortletRenderResponseContextImpl(PortletContainer container, HttpServletRequest containerRequest,
          HttpServletResponse containerResponse, PortletWindow window, PortletRequestContext requestContext)
    {
        super(container, containerRequest, containerResponse, window, requestContext);
        setLifecycle(PortletRequest.RENDER_PHASE);
    }

    public void setNextPossiblePortletModes(Collection<PortletMode> portletModes)
    {
        // not supported
    }

    @SuppressWarnings("unchecked")
   public void setTitle(String title)
    {
        if (!isClosed())
        {
           Map<String, String> titles = (Map<String, String>) getServletRequest().getAttribute(AttributeKeys.PORTLET_TITLE);
           if (titles == null) {
              titles = new HashMap<String, String>();
              getServletRequest().setAttribute(AttributeKeys.PORTLET_TITLE, titles);
           }
           String key = getPortletWindow().getId().getStringId();
           titles.put(key, title);
        }
    }
}
