/**
 * 
 */
package org.apache.pluto.container.spi;

import javax.ccpp.Profile;
import javax.servlet.http.HttpServletRequest;

/**
 * The CC/PP profile service defining how to get the CCPP profile
 *
 */
public interface CCPPProfileService {
	
	public Profile getCCPPProfile(HttpServletRequest httpServletRequest);

}
