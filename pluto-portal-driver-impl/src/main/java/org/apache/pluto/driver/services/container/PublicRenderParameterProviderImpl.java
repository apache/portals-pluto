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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.spi.PublicRenderParameterProvider;
import org.apache.pluto.util.ArgumentUtility;

/**
 * 
 * @author <a href="mailto:dettborn@minet.uni-jena.de">Torsten Dettborn</a>
 * 
 */

public class PublicRenderParameterProviderImpl implements PublicRenderParameterProvider  {

	private static Map<String, List<String>> portalRender = new HashMap<String, List<String>>(100);
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(PublicRenderParameterProviderImpl.class);
    private static PublicRenderParameterProvider renderprovider = new PublicRenderParameterProviderImpl();
   
	public PublicRenderParameterProviderImpl(){
	}
	
	/**
     * factory method
     * gets the PublicRenderParamterProvider out of the Request, or sets a new one
     * @param request The {@link HttpServletRequest} of the PublicRenderParamterProvider
     * @return The corresponding PublicRenderParamterProvider instance
     */
    public static PublicRenderParameterProvider getPublicRenderParameterProviderImpl() {
    	return renderprovider;
    }
	
	/**
	 * Register the portletWindowID with the PublicRenderParameter, which is the key of the Map portalRender
	 * @param portletWindow String unique windowID
	 * @param renderParameter String
	 * @throws IOException will be thrown, if the parameter are null or the length is null; 
	 */
	public void registerPublicRenderParameter(String portletWindowID,String publicRenderParameter){
		LOG.debug("Register the PublicRenderParameter");
		//checks the parameter portletWindowID and PublicRenderParameter
		ArgumentUtility.validateNotNull("attributeName", portletWindowID);
		ArgumentUtility.validateNotEmpty("attributeName", portletWindowID);
		ArgumentUtility.validateNotNull("attributeName", publicRenderParameter);
		ArgumentUtility.validateNotEmpty("attributeName", publicRenderParameter);
		List<String> portletWindowIDList;
		if (!portalRender.containsKey(publicRenderParameter)){
			//If the PublicRenderParameter not exists.
			portletWindowIDList = new ArrayList<String>();
			portletWindowIDList.add(portletWindowID);
			portalRender.put(publicRenderParameter, portletWindowIDList);
		}
		else{
			portletWindowIDList = portalRender.get(publicRenderParameter);
			//If the PublicRenderParameter allready exist.
			if (!isPublicRenderParameter(portletWindowID, publicRenderParameter)){
				//The Portlet will be register, when the entry doesn't exist
				portletWindowIDList.add(portletWindowID);
			}
		}
	}
	
	/**
	 * Checkes the map if it contain the renderParameter and the windowID.
	 * @param windowsID string unique windowID 
	 * @param renderParameter string 
	 * @return true
	 */
	public boolean isPublicRenderParameter(String portletWindowID, String publicRenderParameter){
		ArgumentUtility.validateNotEmpty("attributeName", portletWindowID);		
		ArgumentUtility.validateNotEmpty("attributeName", publicRenderParameter);
		
		if (!portalRender.containsKey(publicRenderParameter)){
			return false;
		}
		else{
			List <String> portalWindowIDList = portalRender.get(publicRenderParameter);
			for (Iterator iter = portalWindowIDList.iterator(); iter.hasNext();) {
				String ID = (String) iter.next();
				if (ID.equals(portletWindowID)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Deletes the portletWindowID in the list from the map, with the key publicRenderParameter  
	 * @param portletWindowID string unique WindowID
	 * @param publicRenderParameter string
	 * @throws IOException will be thrown, if the parameter are null or the length is null;
	 */
	public void deleteRegisteredPublicRenderParameter(String portletWindowID, String publicRenderParameter){
		LOG.debug("Delete the WindowID for the PublicRenderParameter");
		ArgumentUtility.validateNotEmpty("attributeName", portletWindowID);
		ArgumentUtility.validateNotEmpty("attributeName", publicRenderParameter);
		
		if (portalRender.containsKey(publicRenderParameter)){
			List<String> portletWindowIDList = portalRender.get(publicRenderParameter);
			portletWindowIDList.remove(portletWindowID);
			if (portletWindowIDList.size()==0){
				portalRender.remove(publicRenderParameter);
			}
		}
	}
	/**
	 * Delete all entries in the map, which contain the portletWindowID
	 * @param portletWindowID string unique windowID 
	 */
	public void deleteRegisteredPublicRenderParameter(String portletWindowID){
		LOG.debug("Delete the PublicRenderParameter");
		ArgumentUtility.validateNotEmpty("attributeName", portletWindowID);
		
		if (portalRender.size()<1)
			return;
		
		
		for (Iterator iter = portalRender.keySet().iterator(); iter.hasNext();) {
			String publicRenderParam = (String) iter.next();
			List<String> portletIDs = portalRender.get(publicRenderParam);
			portletIDs.remove(portletWindowID);
		}
	}
}
