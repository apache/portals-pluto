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

package org.apache.pluto.services.log;

import org.apache.pluto.services.ContainerService;

/** Implemented in order to provides access to
 *  a custom Logger implementation. The Logger
 *  provides component aware logging capabilities.
 *
 */
public interface LogService extends ContainerService {

    /** Used to retrieve a Logger implementation
     *  which can be used to log information for the given
     *  component.
     * @param component
     * @return
     */
    Logger getLogger(String component);

    /** Used to retrieve a Logger implementation
     *  which can be used to log information for the given
     *  Class.
     * @param klass
     * @return
     */
    Logger getLogger(Class klass);

}
