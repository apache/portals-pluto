/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.tags;

import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceResponse;
import javax.servlet.jsp.JspException;

/**
 * 
 * A tag handler for the <CODE>actionURL</CODE> tag as defined in the JSR 286,
 * which creates a url that points to the current Portlet and triggers 
 * an action request with the supplied parameters.
 * 
 * @version 2.0
 */
public class ActionURLTag286 extends PortletURLTag286 {
	
	private static final long serialVersionUID = 286L;

	private String 	name = null;
	
	
	
    /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	

	/* (non-Javadoc)
	 * @see org.apache.pluto.tags.PortletURLTag#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		
		if(name != null){
			addParameter("javax.portlet.action", name);
		}
		
		return super.doEndTag();
	}



	/**
     * Creates an action PortletURL 
     * @param portletResponse PortletResponse
     * @return PortletURL
     */
	@Override
	protected PortletURL createPortletUrl(PortletResponse portletResponse){
		if (portletResponse instanceof RenderResponse) {
			return ((RenderResponse)portletResponse).createActionURL();			
		}
		else if (portletResponse instanceof ResourceResponse) {
			return ((ResourceResponse)portletResponse).createActionURL();			
		}
		throw new IllegalArgumentException();
	}
    
    
}

