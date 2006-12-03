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
 * Immutable value object carrying a message and a message type to the user interface.
 *  
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 * @see PortletUiMessageType
 */
public class PortletUiMessage {

	private String message = "";
	private Throwable exception = null;
	private PortletUiMessageType messageType = PortletUiMessageType.INFO;

	private PortletUiMessage() {
		//don't use
	}
	
	public PortletUiMessage(String message, PortletUiMessageType messageType) {
		this.message = message;
		this.messageType = messageType;
	}

	public PortletUiMessage(Throwable e, PortletUiMessageType messageType) {
		this.message = e.getMessage();
		this.messageType = messageType;
		this.exception = e;
	}

	public PortletUiMessage(Throwable e) {
		this.message = e.getMessage();
		this.messageType = PortletUiMessageType.ERROR;
		this.exception = e;
	}

	public PortletUiMessage(String message, Throwable e) {
		this.message = message;
		this.messageType = PortletUiMessageType.ERROR;
		this.exception = e;
	}
	
	public String getMessage() {
		return message;
	}
	
	public PortletUiMessageType getMessageType() {
		return messageType;
	}
	
	public String getCssClass(){
		return messageType.cssClass;
	}
	
	public String toString() {
		return message;
	}

	public Throwable getException() {
		return exception;
	}
	
}
