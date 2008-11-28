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
package org.apache.pluto.driver.services.portal;

import junit.framework.TestCase;

/**
 * TODO JavaDoc
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Dec 1, 2005
 */
public class PortletWindowConfigTest extends TestCase {


    public void testCreatePortletId() {
//        assertEquals("context.PortletName", PortletWindowConfig.createPortletId("context", "PortletName"));
//        assertEquals("c.PortletName", PortletWindowConfig.createPortletId("c", "PortletName"));
//        assertEquals("context.P", PortletWindowConfig.createPortletId("context", "P"));
//        assertEquals("c.P", PortletWindowConfig.createPortletId("c", "P"));
    }

    public void testParsePortletName() {
        assertEquals("PortletName", PortletWindowConfig.parsePortletName("context.PortletName"));
        assertEquals("PortletName", PortletWindowConfig.parsePortletName("c.PortletName"));
        assertEquals("P", PortletWindowConfig.parsePortletName("context.P"));
        assertEquals("P", PortletWindowConfig.parsePortletName("c.P"));
    }

    public void testParseContextPath() {
        assertEquals("/context", PortletWindowConfig.parseContextPath("context.PortletName"));
        assertEquals("/c", PortletWindowConfig.parseContextPath("c.PortletName"));
        assertEquals("/context", PortletWindowConfig.parseContextPath("context.P"));
        assertEquals("/c", PortletWindowConfig.parseContextPath("c.P"));
    }

    public void testParseInvalidId() {
        testParseInvalid("Use/Slash");
        testParseInvalid("NoPortlet.");
    }

    private void testParseInvalid(String id) {
        try {
            PortletWindowConfig.parseContextPath(id);
            fail("Exception should have been thrown.");
        }
        catch(IllegalArgumentException iae) {

        }
    }

}
