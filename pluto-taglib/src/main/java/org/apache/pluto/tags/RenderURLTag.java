/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
package org.apache.pluto.tags;


import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;


/**
 * A tag handler for the <CODE>renderURL</CODE> tag,which creates a url that
 * points to the current Portlet and triggers a render request with the
 * supplied parameters.
 * 
 * @author <a href="mailto:olisp_jena@yahoo.de">Oliver Spindler</a> (since Nov 01, 2006)
 * @version 2.0
 */
public class RenderURLTag extends PortletURLTag {


    /**
     * Creates a renderURL
     * @param portletResponse PortletResponse
     * @return PortletURL
     */
	protected PortletURL createPortletUrl(PortletResponse portletResponse)
	{
		return portletResponse.createRenderURL();
	}
    
}

