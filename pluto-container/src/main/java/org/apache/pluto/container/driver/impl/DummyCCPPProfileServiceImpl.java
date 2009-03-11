/**
 * 
 */
package org.apache.pluto.container.driver.impl;

import javax.ccpp.Profile;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.container.CCPPProfileService;

/**
 *
 */
public class DummyCCPPProfileServiceImpl implements CCPPProfileService {

	/* (non-Javadoc)
	 * @see org.apache.pluto.spi.CCPPProfileService#getCCPPProfile()
	 */
	public Profile getCCPPProfile(HttpServletRequest httpServletRequest) {
		return new DummyProfile();
		// FIXME: Here we have to return a "real" javax.ccpp.Profile
	}

}
