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

import org.apache.pluto.PlutoEnvironment;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.services.ServiceFactory;

import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.portlet.PortletResponse;
import java.util.Properties;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 4, 2004 at 10:54:24 PM
 */
public abstract class PortletResponseImpl
    extends HttpServletResponseWrapper
    implements PortletResponse {

    private Map props = new HashMap();

    public PortletResponseImpl(HttpServletResponse res) {
        super(res);
    }

    public String encodeURL(String path) {
        if (path.indexOf("://") == -1) {
            return super.encodeURL(path);
        }
        else if (path.startsWith("/")) {
            return super.encodeUrl(path);
        }
        else {
            throw new IllegalArgumentException("only absolute URLs or full path"
                                               +"URIs are allowed");
        }
    }

    public void addProperty(String key, String value) {
        Object val = props.get(key);
        if(val!=null && val instanceof Collection) {
            ((Collection)val).add(value);
        }
        else if(val!=null) {
            val = Arrays.asList(new Object[] {val});
        }
        else {
            val = value;
        }
        props.put(key,val);
    }

    public void setProperty(String key, String value) {
        props.put(key, value);
    }

    public Map getProperties() {
        return props;
    }

}
