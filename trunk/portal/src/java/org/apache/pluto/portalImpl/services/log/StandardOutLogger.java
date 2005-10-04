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

import org.apache.pluto.services.log.Logger;

/** An incredible simple Logger implementation which
 *  simply directs messages to StandardOut.  This Logger
 *  is only used in cases, such as in the Deployer, when
 *  no services are registered with the ServiceManager.
 */
public class StandardOutLogger implements Logger {

    public StandardOutLogger() {
    }

    public boolean isDebugEnabled() {
        return true;
    }

    public boolean isInfoEnabled() {
        return true;
    }

    public boolean isWarnEnabled() {
        return true;
    }

    public boolean isErrorEnabled() {
        return true;
    }

    public void debug(String aMessage) {
        System.out.println(aMessage);
    }

    public void debug(String aMessage, Throwable aThrowable) {
        System.out.println(aMessage);
        aThrowable.printStackTrace();
    }

    public void info(String aMessage) {
        System.out.println(aMessage);
    }

    public void warn(String aMessage) {
        System.out.println(aMessage);
    }

    public void error(String aMessage) {
        System.out.println(aMessage);
    }

    public void error(String aMessage, Throwable aThrowable) {
        System.out.println(aMessage);
        aThrowable.printStackTrace();
    }

    public void error(Throwable aThrowable) {
        aThrowable.printStackTrace();
    }

}
