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

package org.apache.pluto.services.factory;

import org.apache.pluto.factory.Factory;
import org.apache.pluto.services.ContainerService;

/**
 * The interfaces defined in this package represent an abstract object
 * model (OM) that is applicable for different implementations.
 * <P>
 * This abstraction layer helps to generalize the portlet container from
 * special implementations like data storage and moreover it is not bound
 * to a special implementation.
 */
public interface FactoryManagerService extends ContainerService {

    /**
     * Returns the factory implementation for the given interface class, or
     * <CODE>null</CODE> if no such interface is registered.
     *
     * @param   theClass
     *          the interface class
     *
     * @return   the factory implementation
     */

    public Factory getFactory(Class theClass);

}
