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

import org.apache.commons.logging.LogFactory;
import org.apache.pluto.services.log.Logger;

/** LogService implementation which uses Commons Logging.
 *  The use of commons logging provides us with a simple yet
 *  effective way to abstract the logging implementation.  Commons
 *  Logging will be initialized in it's default manner according
 *  to: http://jakarta.apache.org/commons/logging/userguide.html.
 *
 *  If no configuraiton is found, Commons Logging will use it's
 *  SimpleLog configuration, which will log everything to standard
 *  error.
 */
public class LogServiceImpl
    extends LogService {

    public Logger getLogger(String component) {
        return new LoggerImpl(
            LogFactory.getLog(component)
        );

    }

    public Logger getLogger(Class klass) {
        return new LoggerImpl(
            LogFactory.getLog(klass)
        );
    }

}
