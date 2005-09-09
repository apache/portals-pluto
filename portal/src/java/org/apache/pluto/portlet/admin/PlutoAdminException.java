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
package org.apache.pluto.portlet.admin;

/**
 * The main application exception that is a RuntimeException and
 * can wrap an underlying exception (i.e. the cause).
 *
 * @author Craig Doremus
 *
 */
public class PlutoAdminException extends RuntimeException {

	private Throwable _cause;

	/**
	 *
	 */
	private PlutoAdminException() {
		super();
	}

	/**
	 * @param message
	 */
	public PlutoAdminException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PlutoAdminException(Throwable cause) {
		super(cause.getMessage());
		_cause = cause;
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PlutoAdminException(String message, Throwable cause) {
		super(message);
		_cause = cause;
	}

	/**
	 * @return Returns the cause.
	 */
	public Throwable getCause() {
		return _cause;
	}
	public String toString() {
		StringBuffer msg = new StringBuffer();
		msg.append(getMessage());
		if (_cause != null) {
			msg.append(" Underlying cause: ");
			msg.append(_cause.getClass().getName());
			msg.append(". Underlying cause message: ");
			msg.append(_cause.getMessage());
		}
		return msg.toString();
	}
}
