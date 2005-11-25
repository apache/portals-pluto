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
package org.apache.pluto.driver.services.container.db;

import junit.framework.TestCase;

/**
 * TODO JavaDoc
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Nov 23, 2005
 */
public class PortletPreferenceContainerTest extends TestCase {

    public void testAddPreference() {

        PortletPreferenceContainer container = new PortletPreferenceContainer();
        container.add("test", "one");
        assertEquals(1, container.createPreferences().length);
        container.add("test", "two");
        assertEquals(1, container.createPreferences().length);
        container.add("test2", "two");
        assertEquals(2, container.createPreferences().length);
    }

}
