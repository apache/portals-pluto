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

/** Defines a LogService that may be used when
 *  one has not been registered with the ServiceManager.
 *  This is specifically usefull in cases, such as
 *  when the Deployer is run, in which no Service are
 *  registered.
 *
 *  The StandardOutLogService is implemented as a
 *  Singleton since all log messages will be going
 *  to StandardOut no matter what! Since all behaivior
 *  will be identical, there's no reason to create
 *  multiple instances.
 */
public class StandardOutLogService extends LogService {

    private static Logger logger = null;

    private static LogService service;

    public static LogService getInstance() {
        if(service==null)
            service = new StandardOutLogService();
        return service;
    }

    private StandardOutLogService() {
        logger = new StandardOutLogger();
    }

    public Logger getLogger(String aComponent) {
        return logger;
    }
    
    public Logger getLogger(Class klass) {
        return logger;
    }

}
