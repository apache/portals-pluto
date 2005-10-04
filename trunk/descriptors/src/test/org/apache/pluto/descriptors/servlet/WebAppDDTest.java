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
package org.apache.pluto.descriptors.servlet;

import java.util.Arrays;

import junit.framework.TestCase;

/**
 * Test Case for the Web Application configuration descriptor.
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 23, 2005
 */
public class WebAppDDTest extends TestCase {

    private WebAppDD dd;

    public WebAppDDTest() {

    }

    public void setUp() {
        dd = new WebAppDD();
    }

    public void tearDown() {
        dd = null;
    }

    public void testCollectionsNotNull() {
        assertNotNull(dd.getContextParams());
        assertNotNull(dd.getEjbRefs());
        assertNotNull(dd.getEnvEntrys());
        assertNotNull(dd.getErrorPages());
        assertNotNull(dd.getFilterMappings());
        assertNotNull(dd.getFilters());
        assertNotNull(dd.getListeners());
        assertNotNull(dd.getMimeMappings());
        assertNotNull(dd.getResourceRefs());
        assertNotNull(dd.getSecurityConstraints());
        assertNotNull(dd.getSecurityRoles());
        assertNotNull(dd.getServletMappings());
        assertNotNull(dd.getServlets());
    }

    public void testFindServlet() {
        ServletDD[] servlets = {new ServletDD(), new ServletDD()};
        servlets[0].setServletName("one");
        servlets[1].setServletName("two");
        dd.setServlets(Arrays.asList(servlets));

        assertEquals(servlets[0], dd.getServlet("one"));
        assertEquals(servlets[1], dd.getServlet("two"));
    }

    public void testFindFilter() {
        FilterDD[] filters = {new FilterDD(), new FilterDD()};
        filters[0].setFilterName("one");
        filters[1].setFilterName("two");
        dd.setFilters(Arrays.asList(filters));

        assertEquals(filters[0], dd.getFilter("one"));
        assertEquals(filters[1], dd.getFilter("two"));
    }

    public void testFindServletMapping() {
        ServletMappingDD[] servlets = {new ServletMappingDD(), new ServletMappingDD()};
        servlets[0].setUrlPattern("/test/one");
        servlets[1].setUrlPattern("/two");
        dd.setServletMappings(Arrays.asList(servlets));

        assertEquals(servlets[0], dd.getServletMapping("/test/one"));
        assertEquals(servlets[1], dd.getServletMapping("/two"));
    }
}

