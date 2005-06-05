/*
 * Copyright 2005 The Apache Software Foundation.
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
package org.apache.pluto.util;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.Writer;

import org.jmock.Mock;
import org.jmock.core.InvocationMatcher;
import org.jmock.core.matcher.InvokeAtLeastOnceMatcher;

/**
 * Test Class
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since June 1, 2005
 */
public class PrintWriterServletOutputStreamTest extends PlutoTestCase {

    private InternalWriter internalWriter;
    private PrintWriterServletOutputStream outputStream;

    public void setUp() {
        internalWriter = new InternalWriter();
        PrintWriter pw = new PrintWriter(internalWriter);
        outputStream = new PrintWriterServletOutputStream(pw);
    }

    public void testFlush() throws IOException {
        outputStream.write("flush".getBytes());
        outputStream.flush();
        internalWriter.assertFlush();
    }

    public void testClose() throws IOException {
        outputStream.close();
        internalWriter.assertClose();
    }

    public void testWrite() throws IOException {
        String test = "This is a test";
        outputStream.write(test.getBytes(), 0, test.length());
        internalWriter.assertWriteContents(test);
    }

    public void testWriteSimple() throws IOException {
        String test = "This is a simple test";
        outputStream.write(test.getBytes());
        internalWriter.assertWriteContents(test);
    }

    public void testWriteByte() throws IOException {
        Character c = new Character('T');
        outputStream.write(c.charValue());
        outputStream.flush();
        internalWriter.assertWriteContents(c.toString());
    }

    public void testPrint() throws IOException {
        String test = "Print Test";
        outputStream.print(test);
        internalWriter.assertWriteContents(test);
    }

    public void testPrintln() throws IOException {
        String test = "Print Test";
        outputStream.println(test);
        internalWriter.assertWriteContents(test+System.getProperty("line.separator"));
    }

    public void testPrintlnEmpty() throws IOException {
        outputStream.println();
        internalWriter.assertWriteContents(System.getProperty("line.separator"));
    }
    private class InternalWriter extends Writer {
        private boolean flush = false;
        private boolean write = false;
        private boolean close = false;
        private StringBuffer written = new StringBuffer();

        public void write(char cbuf[], int off, int len) throws IOException {
            write = true;
            written.append(cbuf, off, len);
        }

        public void flush() throws IOException {
            flush = true;
        }

        public void close() throws IOException {
            close = true;
        }

        public void assertFlush() {
            assertTrue("flush was not invoked in the underlying outputStream.", flush);
        }

        public void assertWrite() {
            assertTrue("write was not invoked in the underlying outputStream.", write);

        }

        public void assertClose() {
            assertTrue("close was not invoked in the underlying outputStream.", close);
        }

        public void assertWriteContents(String expectedResults) {
            assertWrite();
            assertEquals(expectedResults, written.toString());
        }
    }


}
