/**
 * 
 */
package org.apache.pluto.container.driver.impl;

import java.util.Set;

import javax.ccpp.Attribute;
import javax.ccpp.Component;
import javax.ccpp.Profile;
import javax.ccpp.ProfileDescription;

/**
 * A dummy replace for a real CCPP Implementation (TBD)
 */
public class DummyProfile implements Profile {

	/* (non-Javadoc)
	 * @see javax.ccpp.Profile#getAttribute(java.lang.String)
	 */
	public Attribute getAttribute(String arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.ccpp.Profile#getAttributes()
	 */
	@SuppressWarnings("unchecked")
    public Set getAttributes() {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.ccpp.Profile#getComponent(java.lang.String)
	 */
	public Component getComponent(String arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.ccpp.Profile#getComponents()
	 */
	@SuppressWarnings("unchecked")
    public Set getComponents() {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.ccpp.Profile#getDescription()
	 */
	public ProfileDescription getDescription() {
		return null;
	}

}
