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

import javax.portlet.EventRequest;
import javax.portlet.EventResponse;

import org.apache.pluto.container.PortletEventResponseContext;
import org.apache.pluto.container.util.ArgumentUtility;

/**
 * Implementation of JSR-286 <code>EventResponse</code>.
 *
 * @since 2.0
 */

public class EventResponseImpl extends StateAwareResponseImpl implements EventResponse
{
    public EventResponseImpl(PortletEventResponseContext responseContext)
    {
        super(responseContext);
    }
    
    protected void checkSetStateChanged()
    {
        // nothing to check or do for EventResponse
    }

	public void setRenderParameters(EventRequest request)
	{
        ArgumentUtility.validateNotNull("request", request);
        setRenderParameters(request.getParameterMap());
	}
}
