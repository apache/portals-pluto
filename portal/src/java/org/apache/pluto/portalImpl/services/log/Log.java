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

import org.apache.pluto.portalImpl.services.ServiceManager;
import org.apache.pluto.services.log.Logger;

/**
 ** This is the static accessor for the <code>Logger</code>.
 ** All log messages logged using this classes static log
 ** methods log to the org.apache.pluto.portalImpl category.
 **
 ** @see   org.apache.pluto.services.log.Logger
 **/

public class Log
{

    private static Logger log =
        getService().getLogger("org.apache.pluto.portalImpl");

    public static boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    public static boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    public static boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }

    public static boolean isErrorEnabled() {
        return log.isErrorEnabled();
    }

    public static void debug(String aMessage) {
        log.debug(aMessage);
    }

    public static void debug(String aMessage, Throwable aThrowable) {
        log.debug(aMessage, aThrowable);
    }

    public static void info(String aMessage) {
        log.info(aMessage);
    }

    public static void warn(String aMessage) {
        log.warn(aMessage);
    }

    public static void error(String aMessage) {
        log.error(aMessage);
    }

    public static void error(String aMessage, Throwable aThrowable) {
        log.error(aMessage, aThrowable);
    }

    public static void error(Throwable aThrowable) {
        log.error(aThrowable);
    }

    /**
     *  Returns the LogService which has been registered
     *  with the ServiceManager. If one does not yet exist,
     *  the StandardOutLogService (LogServiceImpl) is
     *  and returned.  This must take place since the
     *  Deployer (which does not register services) requires
     *  a valid log.
     *
     * @return the {@link LogService} used for static logging.
     */
    public static LogService getService() {
        LogService ls = (LogService)
                ServiceManager.getService(LogService.class);
        if(ls==null)
            ls = StandardOutLogService.getInstance();
        return ls;
    }

}
