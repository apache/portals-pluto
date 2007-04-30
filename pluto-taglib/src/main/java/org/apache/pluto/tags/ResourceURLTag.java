package org.apache.pluto.tags;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.portlet.BaseURL;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSecurityException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;


/**
 * A tag handler for the <CODE>resourceURL</CODE> tag,which creates a url that
 * points to the current Portlet and triggers a resource request with the
 * supplied parameters.
 * 
 * @author <a href="mailto:olisp_jena@yahoo.de">Oliver Spindler</a> (since Nov 01, 2006)
 * @version 1.0
 */

public class ResourceURLTag extends BaseURLTag {

	protected BaseURL url;
	
	/**
	 * Process the start tag for this instance.
	 * @throws JspException
     * @return EVAL_BODY_INCLUDE
     */
	public int doStartTag() throws JspException {
		parameters= new HashMap<String,List<String>> ();
        if (var != null) {
            pageContext.removeAttribute(var, PageContext.PAGE_SCOPE);
        }
        PortletResponse portletResponse = (PortletResponse) pageContext.getRequest()
            .getAttribute(Constants.PORTLET_RESPONSE);

        if (portletResponse != null) {
            setUrl(portletResponse.createResourceURL());            
            if (secure != null) {
                try {
                    url.setSecure(getSecureBoolean());
                } catch (PortletSecurityException e) {
                    throw new JspException(e);
                }
            }
        }
        return EVAL_BODY_INCLUDE;
    }
	
	/**
	 * Process the end tag for this instance.
	 * @throws JspException
     * @return EVAL_PAGE
     */
	public int doEndTag() throws JspException{
		
		setUrlParameters(url);
		
		HttpServletResponse response=(HttpServletResponse) pageContext.getResponse();
		
		String urlString=response.encodeURL(url.toString());
		
		if(escapeXml)
		{
			urlString=doEscapeXml(urlString);
		}
		
	    if (var == null) {
            try {
                JspWriter writer = pageContext.getOut();
                writer.print(urlString);
            } catch (IOException ioe) {
                throw new JspException(
                    "resourceURL Tag Exception: cannot write to the output writer.");
            }
        } else {
            pageContext.setAttribute(var, urlString,
                                     PageContext.PAGE_SCOPE);
        }
	    
	    parameters.clear();//cleanup
	    
        return EVAL_PAGE;
	}
	
    /**
     * Gets the url property.
     * @return BaseURL
     */
    public BaseURL getUrl() {
        return url;
    }
	
    /**
     * Sets the url porperty.
     * @param url BaseUrl - The url to set.
     * @return void
     */
    public void setUrl(BaseURL url) {
        this.url = url;
    }
}
