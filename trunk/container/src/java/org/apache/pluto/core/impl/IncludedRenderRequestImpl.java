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
package org.apache.pluto.core.impl;

import java.util.Map;

import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.core.InternalPortletRequest;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 9, 2005
 */
class IncludedRenderRequestImpl extends RenderRequestImpl {

    private Map map;

    public IncludedRenderRequestImpl(InternalPortletRequest req, Map queryParams) {
        super(req.getInternalPortletWindow(), (HttpServletRequest)req);
        RenderRequest request = (RenderRequest)req;
        map = new java.util.HashMap(request.getParameterMap());
        map.putAll(queryParams);
    }

    // Only implement getParameterMap since all other parameter methods
    // utilize this method.
    public Map getParameterMap() {
        return map;
    }

}

