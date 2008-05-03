/**
 * 
 */
package org.apache.pluto.spi;

import javax.ccpp.Profile;
import javax.servlet.http.HttpServletRequest;

/**
 * The CC/PP profile service defining how to get the CCPP profile
 *
 */
public interface CCPPProfileService extends ContainerService {
	
	public Profile getCCPPProfile(HttpServletRequest httpServletRequest);

}
