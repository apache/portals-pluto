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


/**
 * A tag handler for the <CODE>renderURL</CODE> tag as defined in the JSR 286.
 * Creates a url that points to the current Portlet and triggers a render request 
 * with the supplied parameters.
 * 
 * @version 2.0
 */
public class RenderURLTag286 extends PortletURLTag286 {
	
	private static final long serialVersionUID = 286L;

    /**
     * Creates a render PortletURL
     * @param portletResponse PortletResponse
     * @return PortletURL
     */
	@Override
	protected PortletURL createPortletUrl(PortletResponse portletResponse){
		
		if (portletResponse instanceof RenderResponse) {
			return ((RenderResponse)portletResponse).createRenderURL();			
		}
		else if (portletResponse instanceof ResourceResponse) {
			return ((ResourceResponse)portletResponse).createRenderURL();			
		}
		
		throw new IllegalArgumentException();
	}
    
}

