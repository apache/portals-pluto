package org.apache.pluto.spi;

import java.io.IOException;

/**
 * 
 * @author <a href="mailto:dettborn@minet.uni-jena.de">Torsten Dettborn</a>
 * 
 */

public interface SharedRenderProvider {
	
	/**
	 * Set the sharedRenderParameter for the SharedRenderProvider
	 * @param portletName
	 * @param SharedRenderParameter
	 * @throws IOException 
	 */
	public void registerSharedRenderParameter(String portletID,String SharedRenderParameter);
	/**
	 * Deletes the portletWindowID in the list from the map, with the key sharedRenderParameter  
	 * @param portletWindowID string unique WindowID
	 * @param sharedRenderParameter string
	 * @throws IOException will be thrown, if the parameter are null or the length is null;
	 */
	public void deleteRegisteredSharedRenderParameter(String portletWindowID, String sharedRenderParameter);
	/**
	 * Delete all entries in the map, which contain the portletWindowID
	 * @param portletWindowID string unique windowID 
	 */
	public void deleteRegisteredSharedRenderParameter(String portletWindowID);
	
	/**
	 * Checkes the map if it contain the renderParameter and the windowID.
	 * @param windowsID string unique windowID 
	 * @param renderParameter string 
	 * @return true
	 */
	public boolean isSharedRenderParameter(String portletWindowID, String sharedRenderParameter);
}
