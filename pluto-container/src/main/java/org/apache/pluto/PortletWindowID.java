package org.apache.pluto;

/**
 * The portlet window ID.
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @version 1.0
 */
public interface PortletWindowID {
	
	/**
	 * Returns the unique string ID of the portlet window.
	 * <p>
	 * Depending on the implementation of <code>toString()</code> is dangerous,
	 * because the original implementation in <code>Object</code> is not
	 * qualified.
	 * </p>
	 * @return the unique string ID of the portlet window.
	 */
	public String getStringId();
	
}
