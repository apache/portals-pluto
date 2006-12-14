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
import org.apache.pluto.spi.SharedRenderProvider;
import org.apache.pluto.util.ArgumentUtility;

/**
 * 
 * @author <a href="mailto:dettborn@minet.uni-jena.de">Torsten Dettborn</a>
 * 
 */

public class SharedRenderProviderImpl implements SharedRenderProvider  {

	private static Map<String, List<String>> portalRender = new HashMap<String, List<String>>(100);
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(SharedRenderProviderImpl.class);
    private static SharedRenderProvider renderprovider = new SharedRenderProviderImpl();
   
	public SharedRenderProviderImpl(){
	}
	
	/**
     * factory method
     * gets the SharedRenderProvider out of the Request, or sets a new one
     * @param request The {@link HttpServletRequest} of the SharedRenderProvider
     * @return The corresponding SharedRenderProvider instance
     */
    public static SharedRenderProvider getSharedRenderProviderImpl() {
    	return renderprovider;
    }
	
	/**
	 * Register the portletWindowID with the SharedRenderParameter, which is the key of the Map portalRender
	 * @param portletWindow String unique windowID
	 * @param renderParameter String
	 * @throws IOException will be thrown, if the parameter are null or the length is null; 
	 */
	public void registerSharedRenderParameter(String portletWindowID,String sharedRenderParameter){
		LOG.debug("Register the SharedRenderParameter");
		//checks the parameter portletWindowID and SharedRenderParameter
		ArgumentUtility.validateNotNull("attributeName", portletWindowID);
		ArgumentUtility.validateNotEmpty("attributeName", portletWindowID);
		ArgumentUtility.validateNotNull("attributeName", sharedRenderParameter);
		ArgumentUtility.validateNotEmpty("attributeName", sharedRenderParameter);
		List<String> portletWindowIDList;
		if (!portalRender.containsKey(sharedRenderParameter)){
			//If the SharedRenderParameter not exists.
			portletWindowIDList = new ArrayList<String>();
			portletWindowIDList.add(portletWindowID);
			portalRender.put(sharedRenderParameter, portletWindowIDList);
		}
		else{
			portletWindowIDList = portalRender.get(sharedRenderParameter);
			//If the SharedRenderParameter allready exist.
			if (!isSharedRenderParameter(portletWindowID, sharedRenderParameter)){
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
	public boolean isSharedRenderParameter(String portletWindowID, String sharedRenderParameter){
		ArgumentUtility.validateNotEmpty("attributeName", portletWindowID);		
		ArgumentUtility.validateNotEmpty("attributeName", sharedRenderParameter);
		
		if (!portalRender.containsKey(sharedRenderParameter)){
			return false;
		}
		else{
			List <String> portalWindowIDList = portalRender.get(sharedRenderParameter);
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
	 * Deletes the portletWindowID in the list from the map, with the key sharedRenderParameter  
	 * @param portletWindowID string unique WindowID
	 * @param sharedRenderParameter string
	 * @throws IOException will be thrown, if the parameter are null or the length is null;
	 */
	public void deleteRegisteredSharedRenderParameter(String portletWindowID, String sharedRenderParameter){
		LOG.debug("Delete the WindowID for the SharedRenderParameter");
		ArgumentUtility.validateNotEmpty("attributeName", portletWindowID);
		ArgumentUtility.validateNotEmpty("attributeName", sharedRenderParameter);
		
		if (portalRender.containsKey(sharedRenderParameter)){
			List<String> portletWindowIDList = portalRender.get(sharedRenderParameter);
			portletWindowIDList.remove(portletWindowID);
			if (portletWindowIDList.size()==0){
				portalRender.remove(sharedRenderParameter);
			}
		}
	}
	/**
	 * Delete all entries in the map, which contain the portletWindowID
	 * @param portletWindowID string unique windowID 
	 */
	public void deleteRegisteredSharedRenderParameter(String portletWindowID){
		LOG.debug("Delete the SharedRenderParameter");
		ArgumentUtility.validateNotEmpty("attributeName", portletWindowID);
		
		if (portalRender.size()<1)
			return;
		
		
		for (Iterator iter = portalRender.keySet().iterator(); iter.hasNext();) {
			String sharedRenderParam = (String) iter.next();
			List<String> portletIDs = portalRender.get(sharedRenderParam);
			portletIDs.remove(portletWindowID);
		}
	}
}
