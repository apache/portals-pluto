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
 * Base object that contains convenience logging methods.
 *
 * @author Craig Doremus
 *
 */
public class BaseAdminObject {

	//Name of the subclass
	private String _className = null;
	//Identifier for the logging record
	private String _logId = null;

	/**
	 * Default constructor.
	 *
	 */
	protected BaseAdminObject() {
	}

	protected BaseAdminObject(String className) {
		_className = className;
	}

	protected BaseAdminObject(String className, String logId) {
		_className = className;
		_logId = logId;
	}

	protected void logMethodStart(String methodName) {
		PlutoAdminLogger.logMethodStart(_className, methodName);
	}

	protected void logMethodEnd(String methodName) {
		PlutoAdminLogger.logMethodEnd(_className, methodName);
	}

	protected void logMethodEnd(String methodName, Object retVal) {
		PlutoAdminLogger.logMethodEnd(_className, methodName, retVal);
	}

	protected void logParam(String methodName, String paramName, Object paramVal) {
		PlutoAdminLogger.logParam(_className, methodName, paramName, paramVal);
	}

	protected void logParam(String methodName, String paramName, int paramVal) {
		PlutoAdminLogger.logParam(_className, methodName, paramName, paramVal);
	}

	protected void logParam(String methodName, String paramName, boolean paramVal) {
		PlutoAdminLogger.logParam(_className, methodName, paramName, paramVal);
	}

	protected void logVar(String methodName, String varName, Object varVal) {
		PlutoAdminLogger.logParam(_className, methodName, varName, varVal);
	}

	protected void logVar(String methodName, String varName, int varVal) {
		PlutoAdminLogger.logParam(_className, methodName, varName, varVal);
	}

	protected void logVar(String methodName, String varName, boolean varVal) {
		PlutoAdminLogger.logParam(_className, methodName, varName, varVal);
	}

	protected void logDebug(String methodName, String msg) {
		PlutoAdminLogger.logDebug(_className, methodName, msg);
	}

	protected void logWarn(String methodName, String msg) {
		PlutoAdminLogger.logWarn(_className, methodName, msg);
	}

	protected void logError(String methodName, String msg, Throwable e) {
		PlutoAdminLogger.logError(_className, methodName, msg, e);
	}

	protected void logError(String methodName, Throwable e) {
		PlutoAdminLogger.logError(_className, methodName, e);
	}
}
