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
/* 

 */

package org.apache.pluto.om.portlet;

/**
 * <P>
 * This interface provides access to a content type and its supported
 * portlet modes.
 * A content type is defined as part of a portlet application in the
 * portlet.xml. It is accessible via the ServletDefinition as it is
 * bound to the application code.<br>
 * </P>
 * <P>
 * This interface defines the model as known from the MVC pattern.
 * Its purpose is to provide read access to the data stored in the model.
 * </P>
 * 
 */
public interface ContentType extends org.apache.pluto.om.Model
{

    /**
     * Returns the content type
     * The return value cannot be NULL.
     * 
     * @return the content type
     */
    public String getContentType();

    /**
     * Returns all portlet modes for this content type
     * 
     * @return an iterator over <CODE>javax.portlet.PortletMode</CODE> objects
     */
    public java.util.Iterator getPortletModes();

	/**
	 * Returns true if the given portlet mode is supported for this content type.
	 * @return boolean
	 */
	public boolean supportsPortletMode(javax.portlet.PortletMode portletMode);
}
