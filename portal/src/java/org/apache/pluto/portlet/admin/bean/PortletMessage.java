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
package org.apache.pluto.portlet.admin.bean;

/**
 * Encapsulates a simple String message to be displayed in a JSP
 * usually using the MessageTag tag library.
 *
 * @author Craig Doremus
 *@see org.apache.pluto.portlet.admin.taglib.MessageTag
 */
public class PortletMessage {
	private String message = null;
	private PortletMessageType type = null;

	/**
	 *
	 */
	public PortletMessage(String message, String type) {
		super();
		this.message = message;
		this.type = PortletMessageType.getTypeByName(type);
	}

	/**
	 *
	 */
	public PortletMessage(String message, PortletMessageType type) {
		super();
		this.message = message;
		this.type = type;
	}

	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message The message to set.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return Returns the type.
	 */
	public PortletMessageType getType() {
		return type;
	}
	/**
	 * @param type The type to set.
	 */
	public void setType(PortletMessageType type) {
		this.type = type;
	}
}
