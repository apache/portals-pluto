/*
 * Copyright 2005 The Apache Software Foundation
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

import java.io.InputStream;
import java.io.OutputStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.pluto.descriptors.services.impl.StreamPortletAppDescriptorServiceImpl;

/**
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version $Id$
 * @since Mar 4, 2005
 */
public class CastorMappingTest extends TestCase {

    private boolean debug = false;


//
    public void setUp() throws Exception {
        this.debug = false;
    }

    public void testUnmarshalWebXml() throws Exception {
        InputStream in = getClass().getResourceAsStream("portlet.xml");
        PortletAppDD config =
            new StreamPortletAppDescriptorServiceImpl(
                "test", in, (OutputStream)null
            ).read();

        assertTrue(config!=null);
        assertTrue(config.getPortlets()!=null);
        assertTrue(config.getPortlets().size() > 0);
    }

    /**
     * Start the tests.
     *
     * @param theArgs the arguments. Not used
     */
    public static void main(String[] theArgs) {
        junit.awtui.TestRunner.main(
            new String[] { CastorMappingTest.class.getName()});
    }

    /**
     * @return a test suite (<code>TestSuite</code>) that includes all methods
     *         starting with "test"
     */
    public static Test suite() {
        // All methods starting with "test" will be executed in the test suite.
        return new TestSuite(CastorMappingTest.class);
    }

}

