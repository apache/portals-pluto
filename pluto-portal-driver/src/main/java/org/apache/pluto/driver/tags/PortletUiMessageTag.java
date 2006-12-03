/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.driver.tags;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.util.ui.PortletUiMessage;

/**
 * Tag to print an error, info, alert, status or success message in a portlet
 * as defined by Cascading Syle Sheet classes in Appendix PLT C of the
 * Java Portlet Specification (JSR-168) version 1.0 (pg 116).
 * <p>
 * This class uses the PortletUiMessage to encapsulates message information. 
 * Messages are wrapped in a &lt;div&gt; element containing a 'class' attribute with a
 * spec-defined CSS value, which assumes these are defined in a CSS style
 * sheet used by the JSP page. Right now this class can only handle one
 * message per JSP page. Error information can be found in the
 * Throwable member of the PortletUiMessage class. If this is non-null,
 * the stack trace will be displayed in an HTML comment.
 * </p>
 * <p>
 * There are two ways a message can be displayed using this tag:<br/>
 * 1. Use the tag's message attribute on the JSP page to set the message
 * as a String or expression that evaluates to a String. Optionally, the
 * message can be a key to a value in a ResourceBundle. If so, the
 * bundle attribute must be set to the ResourceBundle where the message
 * can be found.<br/>
 * 2. Put a message in the portlet session encapsulated in a PortletMessage
 * object with a AttributeKeys.PORTLET_MSG key ("protlet_msg"). This class
 * takes care of getting the attribute from the session.<br/>
 * </p>
 *
 * @author <a href=mailto:cdoremus@apache.org>Craig Doremus</a>
 * 
 * @see PortletUiMessage
 * @see PortletUiMessageType
 */
public class PortletUiMessageTag extends TagSupport {
	private static final Log LOG = LogFactory.getLog(PortletUiMessage.class);
	private String message = null;
	/* User-defined CSS class */
	private String cssClass = "portlet-msg-info";
	private String bundle = "AdminDeploymentPortlet";
	
	/************ JSR-168 defined CSS classes for messages ************/
	/** CSS class for Error messages. Example: Portlet not available*/
	public static final String MSG_ERROR_CSS_CLASS = "portlet-msg-error";
	/** CSS class for Help messages, general additional information, etc. Example: Info about */
	public static final String MSG_INFO_CSS_CLASS = "portlet-msg-info";
	/** CSS class for Status of the current operation. Example: Progress: 80% */
	public static final String MSG_STATUS_CSS_CLASS = "portlet-msg-status";
	/** CSS class for Warning messages. Example: Timeout occurred, try again later */
	public static final String MSG_ALERT_CSS_CLASS = "portlet-msg-alert";
	/** CSS class for Verification of the successful completion of a task. Example: Operation completed successfully */
	public static final String MSG_SUCCESS_CSS_CLASS = "portlet-msg-success";
	/* ************************************************************* */

	/**
	 * Does the work of the tag.
	 */
	public int doStartTag()	throws JspException {

	    PortletRequest request = (PortletRequest)pageContext.getRequest().getAttribute(Constants.PORTLET_REQUEST);
	    PortletSession session = request.getPortletSession();
	    PortletUiMessage oMsg = (PortletUiMessage)session.getAttribute(AttributeKeys.PORTLET_MSG);
		session.removeAttribute(AttributeKeys.PORTLET_MSG);
	    Throwable error = null;
	    if (oMsg != null) {
	        error = oMsg.getException();
	    }
	
	    try {
	      final String NL = System.getProperty("line.separator");	
	      JspWriter out = pageContext.getOut();
	      if (oMsg != null) {
	          message = oMsg.getMessage();    	  
	      }
	      //print out message
	      if (message != null ) {
	    	//First, check resource bundle using 'message' as the key
	    	  boolean bundleFound = false;
	    	  try {
				ResourceBundle rb = ResourceBundle.getBundle(bundle);
				bundleFound = true;
				message = rb.getString(message);
			} catch (MissingResourceException e) {
				if (bundleFound) {
					if (LOG.isWarnEnabled()) {
						LOG.warn("Missing resource from ResourceBundle '" + bundle + "'. Key used: " + message);											
					}
				} else {
					if (LOG.isWarnEnabled()) {
						LOG.warn("Missing ResourceBundle '" + bundle + "'.");						
					}
				}
			}
	    	//Get css class 
	      	if (oMsg != null && oMsg.getCssClass() != null) {
	      		cssClass = oMsg.getCssClass();
	      	}
		      	out.print(wrapHtml(message, cssClass));
	      }  	
		    //print out error info if present  	
	      	if (error != null ) {
		    	StringBuffer sb = new StringBuffer();
		    	sb.append(error.getMessage());
		        if (error.getCause() != null) {
		        	sb.append("<br>Underlying Exception cause: ");
		  	    	sb.append(error.getCause().getMessage());
		        }
	        out.print(wrapHtml(sb.toString(), MSG_ERROR_CSS_CLASS));
	        //print out the stack trace in an HTML comment
	       	out.println("<!-- " + NL);
	        PrintWriter writer = new PrintWriter(out, true);
	        error.printStackTrace(writer);
	       	out.print(NL + "-->");
		    } 
	    } catch (IOException e) {
	    	String msg = "Problem in PortletUiMessageTag";
	    	LOG.error(msg, e);
	    	JspTagException jte = new JspTagException(msg);
	    	jte.initCause(e);
	    	throw jte;
	    }
		return SKIP_BODY;
	}

	private String wrapHtml(String msg, String css){
		StringBuffer sb = new StringBuffer();
		sb.append("<div class=\"" + css + "\">");
	    sb.append(msg);
	    sb.append("</div>");
	    return sb.toString();
	}

	/**
	 * @param message The error message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param cssClass The cssClass to set.
	 */
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public void setBundle(String bundle) {
		this.bundle = bundle;
	}
}