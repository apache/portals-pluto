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
package org.apache.pluto.util.ui;

/**
 * Typesafe enum (pre-JDK-1.4) representing different message
 * types and the Cascading Style Sheet class that should be
 * used to render the message (see PLT.C.3 in JSR-168 spec).
 *
 * TODO: Convert to JDK 1.5+ enum
 *
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 * @see PortletUiMessage
 */
public final class PortletUiMessageType {
//TODO: Add methods to allow implemention of Serializable
	
	public static final PortletUiMessageType INFO = new PortletUiMessageType("info", "portlet-msg-info");
	public static final PortletUiMessageType ERROR = new PortletUiMessageType("error", "portlet-msg-error");
	public static final PortletUiMessageType STATUS = new PortletUiMessageType("status", "portlet-msg-status");
	public static final PortletUiMessageType ALERT = new PortletUiMessageType("alert", "portlet-msg-alert");
	public static final PortletUiMessageType SUCCESS = new PortletUiMessageType("success", "portlet-msg-success");

	public final String name;
	public final String cssClass;
	
	private PortletUiMessageType(String name, String cssClass){
		this.name = name;
		this.cssClass = cssClass;
	}
	
	public static final PortletUiMessageType[] values() {
		PortletUiMessageType[] vals = {INFO, ERROR, STATUS, ALERT, SUCCESS}; 
		return vals;
	}

	public String toString(){
		return name;
	}
	
	public boolean equals(Object obj) {
		return name.equals(obj);
	}

	public int hashCode() {
		return name.hashCode();
	}
	

	
	
}
