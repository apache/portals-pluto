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
package org.apache.pluto.spi;

import java.io.IOException;

/**
 * 
 * @author <a href="mailto:dettborn@minet.uni-jena.de">Torsten Dettborn</a>
 * 
 */

public interface PublicRenderParameterProvider {
	
	/**
	 * Set the publicRenderParameters for the PublicRenderParameterProvider
	 * @param portletName
	 * @param PublicRenderParameter
	 * @throws IOException 
	 */
	public void registerPublicRenderParameter(String portletID,String publicRenderParameter);
	/**
	 * Deletes the portletWindowID in the list from the map, with the key publicRenderParameter  
	 * @param portletWindowID string unique WindowID
	 * @param publicRenderParameter string
	 * @throws IOException will be thrown, if the parameter are null or the length is null;
	 */
	public void deleteRegisteredPublicRenderParameter(String portletWindowID, String publicRenderParameter);
	/**
	 * Delete all entries in the map, which contain the portletWindowID
	 * @param portletWindowID string unique windowID 
	 */
	public void deleteRegisteredPublicRenderParameter(String portletWindowID);
	
	/**
	 * Checkes the map if it contain the renderParameter and the windowID.
	 * @param windowsID string unique windowID 
	 * @param renderParameter string 
	 * @return true
	 */
	public boolean isPublicRenderParameter(String portletWindowID, String publicRenderParameter);
}
