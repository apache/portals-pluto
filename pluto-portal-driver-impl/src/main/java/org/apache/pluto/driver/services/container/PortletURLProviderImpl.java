/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.pluto.driver.services.container;

import java.util.Iterator;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURLParameter;
import org.apache.pluto.driver.url.impl.PortalURLParserImpl;
import org.apache.pluto.spi.PortletURLProvider;

/**
 * 
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 */
public class PortletURLProviderImpl implements PortletURLProvider {

    private PortalURL url;
    private String window;
    
    private static final String KEY = PortalURL.class.getName();

    public PortletURLProviderImpl(HttpServletRequest request,
                                  PortletWindow internalPortletWindow) {
    	PortalURL portalURL = (PortalURL) request.getAttribute(KEY);
        if (portalURL == null) {
        	PortalRequestContext ctx = (PortalRequestContext)
    			request.getAttribute(PortalRequestContext.REQUEST_KEY);
        	url = ctx.createPortalURL();
            request.setAttribute(KEY, portalURL);
            
        }
        else {
        	url = (PortalURL) portalURL.clone();
        }

        this.window = internalPortletWindow.getId().getStringId();
    }

    public void setPortletMode(PortletMode mode) {
        url.setPortletMode(window, mode);
    }

    public void setWindowState(WindowState state) {
        url.setWindowState(window, state);
    }
    
    public void setResourceServing(boolean resourceServing) {
        if (resourceServing) {
            url.setResourceWindow(window);
        } else {
            url.setResourceWindow(null);
        }
    }

    public void setAction(boolean action) {
        if (action) {
            url.setActionWindow(window);
        } else {
            url.setActionWindow(null);
        }
    }

    public void setSecure() {
        //url.setSecure(true);
    }

    public void clearParameters() {
        url.clearParameters(window);
    }

    
    public void setParameters(Map parameters) {
        Iterator it = parameters.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            PortalURLParameter param = new PortalURLParameter(
            		window,
            		(String) entry.getKey(),
            		(String[]) entry.getValue());
            url.addParameter(param);
        }
    }
    
    public String[] getPublicRenderParameters(String name){
    	Map publicRenderParaMap = url.getPublicParameters();
    	String[] values = null;
    	for (Iterator it=publicRenderParaMap.keySet().iterator();it.hasNext();){
    		String tmp = (String) it.next();
    		if (tmp.equals(name)){
    			values = (String[])publicRenderParaMap.get(tmp);
    		}
    	}
    	return values;
    }
    
    public void setPublicRenderParameters(Map parameters) {
		url.addPublicRenderParametersNew(parameters);
	}

    public String toString() {
        return url.toString();
    }

	public void savePortalURL(HttpServletRequest request) {
		PortalRequestContext ctx = (PortalRequestContext)
			request.getAttribute(PortalRequestContext.REQUEST_KEY);
		ctx.setPortalURL(url);		
	}

	

}
