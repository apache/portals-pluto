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

package org.apache.pluto.portalImpl.services.log;

import org.apache.commons.logging.Log;
import org.apache.pluto.services.log.Logger;

public class LoggerImpl implements Logger {

    private Log log = null;

    public LoggerImpl(Log log) {
        this.log = log;
    }

    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    public boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }

    public boolean isErrorEnabled() {
        return log.isErrorEnabled();
    }

    public void debug(String aMessage) {
        log.debug(aMessage);
    }

    public void debug(String aMessage, Throwable aThrowable) {
        log.debug(aMessage, aThrowable);
    }

    public void info(String aMessage) {
        log.info(aMessage);
    }

    public void warn(String aMessage) {
        log.warn(aMessage);
    }

    public void error(String aMessage) {
        log.error(aMessage);
    }

    public void error(String aMessage, Throwable aThrowable) {
        log.error(aMessage);
    }

    public void error(Throwable aThrowable) {
        log.error("Exception caught: ", aThrowable);
    }

}
