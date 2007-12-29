/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.testsuite.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A PortletTest implementation can be marked to have all of its test methods
 * run in a certain portlet lifecycle phase by default.  Individual methods
 * annotated with TestPhase will override this setting.  The argument value 
 * should be of the _PHASE constants on javax.portlet.PortletRequest, i.e.,
 * RENDER_PHASE, ACTION_PHASE, RESOURCE_PHASE, EVENT_PHASE
 * 
 * @author Benjamin C. Gould
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultTestPhase {

    public String value();
    
}
