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

package org.apache.pluto.spi.impl;

import java.util.Collection;

import javax.portlet.PortletMode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.spi.optional.PortletRenderResponseContext;

/**
 * @version $Id$
 *
 */
public class PortletRenderResponseContextImpl extends PortletMimeResponseContextImpl implements
                PortletRenderResponseContext
{
    public PortletRenderResponseContextImpl(PortletContainer container, HttpServletRequest request,
                                            HttpServletResponse response, PortletWindow window)
    {
        super(container, request, response, window);
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRenderResponseContext#setNextPossiblePortletModes(java.util.Collection)
     */
    public void setNextPossiblePortletModes(Collection<PortletMode> portletModes)
    {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRenderResponseContext#setTitle(java.lang.String)
     */
    public void setTitle(String title)
    {
        // TODO Auto-generated method stub
    }
}
