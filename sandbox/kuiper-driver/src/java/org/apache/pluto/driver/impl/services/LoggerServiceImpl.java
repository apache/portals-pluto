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

import org.apache.pluto.services.LoggerService;
import org.apache.pluto.services.Logger;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

/** <p>LoggerService implementation which creates Loggers
 *  which use commons logging for the underlying logging
 *  implementation.</p>
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 15, 2004 at 8:17:09 AM
 */
public class LoggerServiceImpl implements LoggerService {

    private ClassLoader loader = null;
    public LoggerServiceImpl() {
        loader = Thread.currentThread().getContextClassLoader();
    }

    /** Returns a Logger which utilizes
     *  a {@link org.apache.commons.logging.Log} for it's
     *  underlying logging implementation.
     *  This method ensures that the context classloader
     *  with which this LoggerServiceImpl was constructed
     *  is used to create all Log instances so that configuration
     *  information is correct.
     */
    public Logger getLogger(Class component) {
        Thread currentThread = Thread.currentThread();
        ClassLoader temp = currentThread.getContextClassLoader();
        currentThread.setContextClassLoader(this.loader);

        Log log = LogFactory.getLog(component);
        LoggerImpl impl = new LoggerImpl(log);

        currentThread.setContextClassLoader(temp);
        return impl;
    }
}
