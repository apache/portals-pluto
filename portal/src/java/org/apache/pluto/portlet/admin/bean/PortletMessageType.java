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
 * Typesafe enum (pre-JDK 1.5) that represents a Portlet Message Type
 *
 * @author Craig Doremus
 *
 */
public class PortletMessageType {

	public static PortletMessageType INFO = new PortletMessageType("info", "portlet-msg-info");
	public static PortletMessageType ERROR = new PortletMessageType("error", "portlet-msg-error");
	public static PortletMessageType STATUS = new PortletMessageType("status", "portlet-msg-status");
	public static PortletMessageType ALERT = new PortletMessageType("alert", "portlet-msg-alert");
	public static PortletMessageType SUCCESS = new PortletMessageType("success", "portlet-msg-success");

	public String name = null;
	public String CssClass = null;

	/**
	 *
	 */
	private PortletMessageType(String name, String cssClass) {
		this.name = name;
		this.CssClass = cssClass;
	}

	public static PortletMessageType getTypeByName(String testName) {
		if (testName.equalsIgnoreCase("info")){
			return INFO;
		} else if (testName.equalsIgnoreCase("error")){
			return ERROR;
		} else if (testName.equalsIgnoreCase("status")){
			return STATUS;
		} else if (testName.equalsIgnoreCase("alert")){
			return ALERT;
		} else if (testName.equalsIgnoreCase("success")){
			return SUCCESS;
		} else {
			throw new IllegalArgumentException("PortletMessageType with name '" + testName + "' does not exist.");
		}
	}

	public String toString(){
		return name;
	}

	public static boolean equals(PortletMessageType msgType, String testName) {
		if (msgType == getTypeByName(testName)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean equals(Object obj) {
		if (obj instanceof PortletMessageType) {
			PortletMessageType comp = (PortletMessageType)obj;
			return name.equals(comp.name);
		} else {
			return false;
		}
	}
}
