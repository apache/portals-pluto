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

package org.apache.pluto.driver.impl.services;

import org.apache.pluto.services.Logger;
import org.apache.commons.logging.Log;

/**
 * <B>TODO</B>: Document
 * 
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 9:46:35 AM
 */
public class LoggerImpl implements Logger {

    private Log log;

    public LoggerImpl(Log log) {
        this.log = log;
        if(log.isDebugEnabled()) {
            log.debug("New Logger Created: "+log);
        }
    }

    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    public void debug(String msg) {
        log.debug(msg);
    }

    public void debug(String msg, Throwable t) {
        log.debug(msg, t);
    }

    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    public void info(String msg) {
        log.info(msg);
    }

    public void info(String msg, Throwable t) {
        log.info(msg, t);
    }

    public boolean isWarningEnabled() {
        return log.isWarnEnabled();
    }

    public void warning(String msg) {
        log.warn(msg);
    }

    public void warning(String msg, Throwable t) {
        log.warn(msg, t);
    }

    public boolean isErrorEnabled() {
        return log.isErrorEnabled();
    }

    public void error(String msg) {
        log.error(msg);
    }

    public void error(String msg, Throwable t) {
        log.error(msg, t);
    }

    public boolean isFatalEnabled() {
        return log.isFatalEnabled();
    }

    public void fatal(String msg) {
        log.fatal(msg);
    }

    public void fatal(String msg, Throwable t) {
        log.fatal(msg, t);
    }

    public void log(String msg) {
        info(msg);
    }

    public void log(String s, Throwable t) {
        info(s, t);
    }

}
