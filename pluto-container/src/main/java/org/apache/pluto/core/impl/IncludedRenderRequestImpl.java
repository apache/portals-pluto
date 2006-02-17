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

import org.apache.pluto.core.InternalPortletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.portlet.RenderRequest;
import java.util.Map;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @since Aug 3, 2005
 */
public class IncludedRenderRequestImpl extends RenderRequestImpl {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(IncludedRenderRequestImpl.class);

    private Map map;

    public IncludedRenderRequestImpl(InternalPortletRequest req, Map queryParams) {
        super(req);
        RenderRequest request = (RenderRequest)req;
        map = new java.util.HashMap(request.getParameterMap());
        map.putAll(queryParams);
        if(LOG.isDebugEnabled()) {
            LOG.debug("Parameter Map: "+map.toString());
        }
    }

    // Only implement getParameterMap since all other parameter methods
    // utilize this method.
    public Map getParameterMap() {
        return map;
    }

    public String getParameter(String key) {
        String[] values = (String[])map.get(key);
        if(values != null && values.length > 0) {
            return values[0];
        }
        return null;
    }

    public Enumeration getParameterNames() {
        return new Vector(map.keySet()).elements();
    }

    public String[] getParameterValues(String key) {
        return (String[])map.get(key);
    }

}
