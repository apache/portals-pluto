/**
 * 
 */
package org.apache.pluto.spi;

import javax.ccpp.Profile;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.internal.impl.DummyProfile;

/**
 *
 */
public class DummyCCPPProfileServiceImpl implements CCPPProfileService {

	/* (non-Javadoc)
	 * @see org.apache.pluto.spi.CCPPProfileService#getCCPPProfile()
	 */
	public Profile getCCPPProfile(HttpServletRequest httpServletRequest) {
		return new DummyProfile();
	}

}
