/*
 * Copyright 2003,2004,2005 The Apache Software Foundation.
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
package org.apache.pluto.portlet.admin.taglib;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.pluto.Constants;
import org.apache.pluto.portlet.admin.PlutoAdminConstants;
import org.apache.pluto.portlet.admin.bean.PortletMessage;
import org.apache.pluto.portlet.admin.bean.PortletMessageType;

/**
 * Tag to print an error, info, alert, status or success message in a portlet
 * as defined by Cascading Syle Sheet classes in Appendix PLT C of the
 * Java Portlet Specification (JSR-168) version 1.0 (pg 116).
 * <p>
 * This class uses the PortletMessage and PortletMessageType classes to
 * encapsulates message information. It also can handle a Throwable
 * put in the session (see below), using the getMessage() for the message
 * and printing out the stack trace in an HTML comment. All messages are
 * wrapped in a &lt;p&gt; element containing a 'class' attribute with a
 * spec-defined CSS value, which assumes these are defined in a CSS style
 * sheet used by the JSP page. Right now this class can only handle one
 * message per JSP page.
 * </p>
 * <p>
 * There are three ways a message can be displayed using this tag:<br/>
 * 1. Use the tag's message attribute on the JSP page to set the message
 * as a String or expression that evaluates to a String. Optionally, you
 * can use the messageType attribute. Valid messageType attributes
 * are info, error, status, success and alert. The default message
 * type is status.<br/>
 * 2. Put a message in the portlet session encapsulated in a PortletMessage
 * object with a PlutoAdminConstants.MESSAGE_ATTR session key. This class
 * takes care of getting the attribute from the session, using its message and
 * type data and removing the session attribute.<br/>
 * 3. Put a Throwable in the portlet session with a PlutoAdminConstants.ERROR_ATTR
 * key.  This class takes care of getting the attribute from the session,
 * using its data and removing the session attribute. Throwables are always
 * given a messageType of error.<br/>
 * </p>
 *
 * @author Craig Doremus
 * @see org.apache.pluto.portlet.admin.bean.PortletMessage
 * @see org.apache.pluto.portlet.admin.bean.PortletMessageType
 * @see org.apache.pluto.portlet.admin.PlutoAdminConstants
 */
public class MessageTag extends TagSupport {

	private String message;
	private String messageType = "status";
	/* User-defined CSS class */
	private String cssClass = "portlet-msg-info";

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
    Throwable error = (Throwable)session.getAttribute(PlutoAdminConstants.ERROR_ATTR);
		session.removeAttribute(PlutoAdminConstants.ERROR_ATTR);
    PortletMessage oMsg = (PortletMessage)session.getAttribute(PlutoAdminConstants.MESSAGE_ATTR);
		session.removeAttribute(PlutoAdminConstants.MESSAGE_ATTR);

    try {
      JspWriter out = pageContext.getOut();
      if (message != null ) {
      	if (cssClass == null) {
      		cssClass = PortletMessageType.getTypeByName(messageType).CssClass;
      	}
	      out.print(wrapHtml(message, cssClass));
	    } else if (oMsg != null ) {
        out.print(wrapHtml(oMsg.getMessage(), oMsg.getType().CssClass));
	    } else if (error != null ) {
	    	StringBuffer sb = new StringBuffer();
	    	sb.append(error.getMessage());
        if (error.getCause() != null) {
        	sb.append("<br>Underlying Exception cause: ");
  	    	sb.append(error.getCause().getMessage());
        }
        out.print(wrapHtml(sb.toString(), MSG_ERROR_CSS_CLASS));
        //print out the stack trace in an HTML comment
       	out.println("<!-- " + PlutoAdminConstants.LS);
        PrintWriter writer = new PrintWriter(out, true);
        error.printStackTrace(writer);
       	out.print(PlutoAdminConstants.LS + "-->");
	    }
    } catch (IOException e) {
      throw new JspTagException("Error in tag MessageTag: " + e.toString());
    }
			return SKIP_BODY;
	  }

	private String wrapHtml(String msg, String css){
		StringBuffer sb = new StringBuffer();
		sb.append("<p class=\"" + css + "\">");
    sb.append(msg);
    sb.append("</p>");
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
	/**
	 * @param messageType The messageType to set.
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
}
