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

package org.apache.pluto.impl;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.PlutoEnvironment;

import javax.portlet.RenderRequest;
import javax.portlet.PortletContext;
import javax.portlet.PortalContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 10, 2004 at 11:12:05 AM
 */
public class RenderRequestImpl extends PortletRequestImpl
    implements RenderRequest {

    //private Map renderParameters;
    /** renderParameters MAY be null if action
     *  did not preceed this render request.
     * @param env
     * @param context
     * @param window
     * @param request
     * @param renderParameters
     */
    public RenderRequestImpl(PlutoEnvironment env,
                             PortletContext context,
                             PortletWindow window,
                             HttpServletRequest request,
                             Map renderParameters) {
        super(env, context, window, request);
        //this.renderParameters = renderParameters;
    }

    /*

    Eventually we need to handle parameters per the spec.
    This means if an action request no render parameters except
    for those that have been set by setRenderParameter are visible.

    Here's a possible method to do that. . .but it's not 100% flushed
    out.

    public String getParameter(String key) {
        if(renderParameters==null) {
            return super.getParameter(key);
        }
        String[] strs = getParameterValues(key);
        if(strs!=null && strs.length>0) {
            return strs[0];
        }
        else {
            return null;
        }
    }

    public String[] getParameterValues(String key) {
        if(renderParameters==null) {
            super.getParameterValues(key);
        }
        return (String[])this.renderParameters.get(key);
    }

    public Enumeration getParameterNames() {
        if(renderParameters==null) {
            return super.getParameterNames();
        }
        return new Vector(renderParameters.keySet()).elements();
    }

    public Map getParameterMap() {
        if(renderParameters==null) {
            return super.getParameterMap();
        }
        return renderParameters;
    }
    */
}
