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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Class containing convenience logging methods.
 *
 * @author Craig Doremus
 *
 */
public class PlutoAdminLogger {
	private static Log _log = LogFactory.getLog(PlutoAdminLogger.class);
	private static final String MSG_SEP = " | ";


	/**
	 * Default constructor.
	 *
	 */
	private PlutoAdminLogger() {
	}


	public static void logMethodStart(String className, String methodName) {
		if (_log.isInfoEnabled()) {
			_log.info(getLogMessage(className, methodName, "Start of method . . ."));
		}
	}

	public static void logMethodEnd(String className, String methodName) {
		if (_log.isInfoEnabled()) {
			_log.info(getLogMessage(className, methodName, ". . .end of method"));
		}
	}

	public static void logMethodEnd(String className, String methodName, Object retVal) {
		if (_log.isInfoEnabled()) {
			_log.info(getLogMessage(className, methodName, ". . .end of method with return value = " + (retVal == null ? "null" : retVal.toString())));
		}
	}

	public static void logParam(String className, String methodName, String paramName, Object paramVal) {
		if (_log.isInfoEnabled()) {
			_log.info(getLogMessage(className, methodName, "Parameter '" + paramName + "' has value=" + (paramVal == null ? "null" : paramVal.toString())));
		}
	}

	public static void logParam(String className, String methodName, String paramName, int paramVal) {
		if (_log.isInfoEnabled()) {
			_log.info(getLogMessage(className, methodName, "Parameter '" + paramName + "' has value=" + paramVal));
		}
	}

	public static void logParam(String className, String methodName, String paramName, boolean paramVal) {
		if (_log.isInfoEnabled()) {
			_log.info(getLogMessage(className, methodName, "Parameter '" + paramName + "' has value=" + (paramVal ? "true" : "false")));
		}
	}

	public static void logVar(String className, String methodName, String varName, Object varVal) {
		if (_log.isDebugEnabled()) {
			_log.debug(getLogMessage(className, methodName, "Variable '" + varName + "' has value=" + (varVal == null ? "null" : varVal.toString())));
		}
	}

	public static void logVar(String className, String methodName, String varName, int varVal) {
		if (_log.isDebugEnabled()) {
			_log.debug(getLogMessage(className, methodName, "Variable '" + varName + "' has value=" + varVal));
		}
	}

	public static void logVar(String className, String methodName, String varName, boolean varVal) {
		if (_log.isDebugEnabled()) {
			_log.debug(getLogMessage(className, methodName, "Variable '" + varName + "' has value=" + (varVal ? "true" : "false")));
		}
	}

	public static void logDebug(String className, String methodName, String msg) {
		if (_log.isDebugEnabled()) {
			_log.debug(getLogMessage(className, methodName, msg));
		}
	}

	public static void logWarn(String className, String methodName, String msg) {
		if (_log.isWarnEnabled()) {
			_log.warn(getLogMessage(className, methodName, msg));
		}
	}

	public static void logError(String className, String methodName, String msg, Throwable e) {
		if (_log.isErrorEnabled()) {
			_log.error(getLogMessage(className, methodName, msg), e);
		}
	}

	public static void logError(String className, String methodName, Throwable e) {
		if (_log.isErrorEnabled()) {
			_log.error(getLogMessage(className, methodName, e != null ? e.toString() : ""), e);
		}
	}

	public static void logError(String className, String methodName, String msg) {
		if (_log.isErrorEnabled()) {
			_log.error(getLogMessage(className, methodName, msg));
		}
	}

	private static String getLogMessage(String className, String methodName, String msg) {
		StringBuffer retMsg = new StringBuffer();
		if (className == null) {
			throw new IllegalStateException("Null class name. Please set class name in the constructor.");
		}
		if (methodName == null) {
			throw new IllegalArgumentException("Null method name.");
		}
//		if (_logId != null) {
//			retMsg.append(_logId);
//			retMsg.append(MSG_SEP);
//		}
		retMsg.append(className);
		retMsg.append(".");
		retMsg.append(methodName);
		retMsg.append(MSG_SEP);
		retMsg.append(msg == null ? "" : msg);
		return retMsg.toString();
	}
}
