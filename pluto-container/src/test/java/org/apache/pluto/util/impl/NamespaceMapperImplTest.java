package org.apache.pluto.util.impl;

import org.apache.pluto.util.PlutoTestCase;
import org.apache.pluto.util.NamespaceMapper;
import org.apache.pluto.om.ObjectID;
import junit.framework.Assert;

/**
 * Test Class
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since June 1, 2005
 */
public class NamespaceMapperImplTest extends PlutoTestCase {

    private NamespaceMapper mapper = new NamespaceMapperImpl();
    private ObjectID id1;
    private ObjectID id2;

    public void setUp() throws Exception {
        super.setUp();
        id1 = new InternalObjectID();
        id2 = new InternalObjectID();
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
    private class InternalObjectID implements ObjectID {
        private int id;

        public InternalObjectID() {
            id = objectIDCounter++;
        }

        public String toString() {
            return "uniqueId"+id;
        }
    }
}
