/*
 * Copyright 2004 The Apache Software Foundation
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
package org.apache.pluto.descriptors.portlet;

import junit.framework.TestCase;

/**
 * Portlet Deployment Descriptor Configuration.
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 23, 2005
 */
public class PortletAppDDTest extends TestCase {

    private PortletAppDD dd;

    public PortletAppDDTest() {

    }

    public void setUp() {
        dd = new PortletAppDD();
    }

    public void tearDown() {
        dd = null;
    }

    public void testCollectionsNotNull() {
        assertNotNull(dd.getPortlets());
    }

}

