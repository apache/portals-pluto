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

/** Implemented in order to provide component aware
 *  logging.
 *
 * @see LogService
 *
 */
public interface Logger extends ContainerService
{

    public boolean isDebugEnabled();
    public boolean isInfoEnabled();
    public boolean isWarnEnabled();
    public boolean isErrorEnabled();

    public void debug(String aMessage);
    public void debug(String aMessage, Throwable aThrowable);
    public void info(String aMessage);
    public void warn(String aMessage);
    public void error(String aMessage);
    public void error(String aMessage, Throwable aThrowable);
    public void error(Throwable aThrowable);

}
