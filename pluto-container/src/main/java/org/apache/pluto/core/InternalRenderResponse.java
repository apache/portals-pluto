package org.apache.pluto.core;

/**
 * The internal render response interface extends the internal portlet response
 * interface and provides some render-specific methods.
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @since 2006-02-17
 */
public interface InternalRenderResponse extends InternalPortletResponse {
	
    public void setIncluded(boolean included);

    public boolean isIncluded();

}
