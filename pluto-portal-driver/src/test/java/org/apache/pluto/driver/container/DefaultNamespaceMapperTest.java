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
package org.apache.pluto.driver.container;

import org.apache.pluto.container.NamespaceMapper;
import org.apache.pluto.container.PortletWindowID;
import org.apache.pluto.driver.container.DefaultNamespaceMapper;

/**
 * Test Class
 *
 * @version 1.0
 * @since June 1, 2005
 */
public class DefaultNamespaceMapperTest extends PlutoTestCase {

    private NamespaceMapper mapper = new DefaultNamespaceMapper();
    private PortletWindowID id1;
    private PortletWindowID id2;

    public void setUp() throws Exception {
        super.setUp();
        id1 = new InternalPortletWindowID();
        id2 = new InternalPortletWindowID();
    }

    public void testEncodeUniquenessWithSameName() {
        String mappedA = mapper.encode(id1, "testNumber1");
        String mappedB = mapper.encode(id2, "testNumber1");
        assertFalse(mappedA.equals(mappedB));
    }

    public void testEncodeUniquenessWithSameObjectID() {
        String mappedA = mapper.encode(id1, "testNumber1");
        String mappedB = mapper.encode(id1, "testNumber2");
        assertFalse(mappedA.equals(mappedB));
    }

    public void testDecode() {
        String original = "original";
        String mappedA = mapper.encode(id1, original);
        assertEquals(original, mapper.decode(id1, mappedA));
    }

    public void testDecodeInvalidId() {
        assertNull(mapper.decode(id1, mapper.encode(id2, "test")));
    }

    private static int objectIDCounter = 1;


    private class InternalPortletWindowID implements PortletWindowID {

        private int id;

        public InternalPortletWindowID() {
            id = objectIDCounter++;
        }

        public String getStringId() {
            return "uniqueId"+id;
        }
    }
}
