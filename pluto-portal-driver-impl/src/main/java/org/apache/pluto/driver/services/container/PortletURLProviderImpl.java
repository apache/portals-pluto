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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.portlet.PortletMode;
import javax.portlet.PortletSecurityException;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURLParameter;
import org.apache.pluto.spi.PortletURLProvider;

/**
 * 
 */
public class PortletURLProviderImpl implements PortletURLProvider {

    private PortalURL url;
    private String window;
    /** The parameters including parameters appended to the dispatching URI. */
    protected Map<String, String[]> parameters = null;    

    public PortletURLProviderImpl(HttpServletRequest request,
                                  PortletWindow portletWindow) {
        PortalRequestContext ctx = (PortalRequestContext)
            request.getAttribute(PortalRequestContext.REQUEST_KEY);
        url = ctx.createPortalURL();

        this.window = portletWindow.getId().getStringId();
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

    public boolean isResourceServing(){
    	if (url.getResourceWindow() != null)
    		return true;
    	else
    		return false;
    }
    
    public void setAction(boolean action) {
        if (action) {
            url.setActionWindow(window);
        } else {
            url.setActionWindow(null);
        }
    }

    public void setSecure() throws PortletSecurityException {
        throw new PortletSecurityException("Secure URLs (via PortletURLProvider.setSecure()) is not supported.");
    }

    public boolean isSecureSupported() {
        return false;
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
    
    public String[] getPrivateRenderParameters(String name){
    	String[] values = null;
    	for (Iterator it=url.getParameters().iterator();it.hasNext();){
    		PortalURLParameter param = (PortalURLParameter)it.next();
    		if (param.getName().equals(name))
    			values = param.getValues();
    	}
    	return values;
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

    public Map<String, String[]> getRenderParameters()
    {
        return this.parameters;
    }

    public Map<String, String[]> parseRenderParameters(Map<String, String[]> parentMap, String queryString)
    {
        if (parentMap == null)
        {
            parameters = null;
        }
        else
        {
            // Copy all the original render parameters.
            parameters = new HashMap<String, String[]>(parentMap);        
            if (queryString != null && queryString.trim().length() > 0)
            {
                // Merge the appended parameters to the render parameter map.
                // The original render parameters should not be overwritten.
                mergeQueryString(parameters, queryString);
            }
        }
        return parameters;
    }
    
    /**
     * Parses the appended query string and merges the appended parameters to
     * the original parameters. Query parameters are name-value pairs separated
     * by the '<code>&amp;</code>' character.
     * 
     * @param parameters
     *            the original parameters map.
     * @param queryString
     *            the appended query string.
     */
    private void mergeQueryString(Map parameters, String queryString)
    {

        // Create the appended parameters map:
        // key is the parameter name as a string,
        // value is a List of parameter values (List of String).
        Map appendedParameters = new HashMap();

        StringTokenizer st = new StringTokenizer(queryString, "&", false);
        while (st.hasMoreTokens())
        {
            String token = st.nextToken();
            int equalIndex = token.indexOf("=");
            if (equalIndex > 0)
            {
                String key = token.substring(0, equalIndex);
                String value = null;
                if (equalIndex < token.length() - 1)
                {
                    value = token.substring(equalIndex + 1);
                }
                else
                {
                    value = "";
                }
                List values = (List) appendedParameters.get(key);
                if (values == null)
                {
                    values = new ArrayList();
                }
                values.add(value);
                appendedParameters.put(key, values);
            }
        }

        // Merge the appended parameters and the original parameters.
        for (Iterator it = appendedParameters.keySet().iterator(); it.hasNext();)
        {
            String key = (String) it.next();
            List values = (List) appendedParameters.get(key);
            // If the parameter name (key) exists, merge parameter values.
            if (parameters.containsKey(key))
            {
                String[] originalValues = (String[]) parameters.get(key);
                if (originalValues != null)
                {
                    for (int i = 0; i < originalValues.length; i++)
                    {
                        values.add(originalValues[i]);
                    }
                }
            }
            parameters.put(key, values.toArray(new String[values.size()]));
        }
    }
    
    
}
