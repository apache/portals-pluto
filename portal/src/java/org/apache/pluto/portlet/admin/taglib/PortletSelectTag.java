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
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.pluto.Constants;
import org.apache.pluto.portlet.admin.PlutoAdminConstants;
import org.apache.pluto.portlet.admin.bean.PortletTO;

/**
 * Taglib that creates an HTML select control containing portlet
 * names and values as defined in the <code>PortletTO</code>
 * class.
 *
 * @author Craig Doremus
 * @see org.apache.pluto.portlet.admin.bean.PortletTO
 *
 */
public class PortletSelectTag extends TagSupport {

	private Map portletMap = null;
	private int row = 1;
	private int column = 1;

	public int doStartTag()	throws JspException {
    PortletRequest request = (PortletRequest)pageContext.getRequest().getAttribute(Constants.PORTLET_REQUEST);
    PortletSession session = request.getPortletSession();
    List portlets = (List)session.getAttribute(PlutoAdminConstants.PORTLET_APP_LIST_ATTR);

    if (portletMap != null ) {
	      try {
	        JspWriter out = pageContext.getOut();
	        out.println("<select name=\"portlet" + row + "." + column + "\">");
	        Set vals = portletMap.entrySet();
	        Iterator iter = vals.iterator();
	        while (iter.hasNext()) {
	        	Map.Entry item = (Map.Entry) iter.next();
	        	String name = (String)item.getKey();
	        	String val = (String)item.getValue();
		        out.print("<option value=\"" + name + "_" + val + "\"");
		        //find out what portlet should be the 'checked' one
		        if (portlets != null) {
		        	Iterator iter2 = portlets.iterator();
		        	while(iter.hasNext()) {
		        		PortletTO plet = (PortletTO)iter2.next();
		        		int currrow = plet.getRow();
		        		int currcol = plet.getCol();
		        		if (row == currrow && column == currcol) {
		  		        out.print(" checked ");
		  		        break;
		        		}
		        	}
		        }
		        out.print(">");
		        out.print(name);
		        out.print("</option>");
	        }
	        out.println("</select>");
	      } catch (IOException e) {
	        throw new JspTagException("Error: " + e.toString());
	      }
	    }
			return SKIP_BODY;
	  }

	/**
	 * @param portletMap The portletMap to set.
	 */
	public void setPortletMap(Map portletMap) {
		this.portletMap = portletMap;
	}
	/**
	 * @param column The column to set.
	 */
	public void setColumn(int column) {
		this.column = column;
	}
	/**
	 * @param row The row to set.
	 */
	public void setRow(int row) {
		this.row = row;
	}
}
