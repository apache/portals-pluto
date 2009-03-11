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
package org.apache.pluto.container.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;

/**
 * This is a specialized class implementing a ServletOutputStream that works in
 * conjunction with a PrintWriter to send data to the browser. It is used when a
 * J2EE server throws an IllegalStateException when you call getOutputStream on
 * a response which someone has previously called getWriter on.
 */
public class PrintWriterServletOutputStream extends ServletOutputStream {

    /**
     * The PrintWriter that is wrapped on top of the base input stream
     */
    PrintWriter mPrintWriter;

    /**
     * The character encoding of the response.
     */
    private String characterEncoding;

    public PrintWriterServletOutputStream(PrintWriter pw, String encoding)
    {
        super();
        mPrintWriter = pw;
        characterEncoding = encoding;
    }
    
    /**
     * Writes an array of bytes
     * @param pBuf the array to be written
     * @throws IOException if an I/O error occurred
     */
    public void write(byte[] pBuf) throws IOException {
        this.write(pBuf, 0, pBuf.length);
    }

    /**
     * Writes a single byte to the output stream
     */
    public void write(int pVal) throws IOException {
        mPrintWriter.write(pVal);
    }

    /**
     * Writes a subarray of bytes
     * @param pBuf    the array to be written
     * @param pOffset the offset into the array
     * @param pLength the number of bytes to write
     * @throws IOException if an I/O error occurred
     */
    public void write(byte[] pBuf, int pOffset, int pLength)
        throws IOException {
        String strValue = null;
        if(characterEncoding != null && !"".equals(characterEncoding)) {
            try {
                strValue = new String(pBuf, pOffset, pLength, characterEncoding);
            }
            catch(UnsupportedEncodingException uee) {
                // ignore and allow the null to handle.
            }
        }

        if(strValue == null) {
            strValue = new String(pBuf, pOffset, pLength);
        }

        mPrintWriter.write(strValue);
    }

    /**
     * Flushes the stream, writing any buffered output bytes
     * @throws IOException if an I/O error occurred
     */
    public void flush() throws IOException {
        mPrintWriter.flush();
    }

    /**
     * Closes the stream
     * @throws IOException if an I/O error occurred
     */
    public void close() throws IOException {
        mPrintWriter.close();
    }

    /**
     * Prints a string.
     * @param pVal the String to be printed
     * @throws IOException if an I/O error has occurred
     */
    public void print(String pVal) throws IOException {
        mPrintWriter.print(pVal);
    }

    /**
     * Prints an string followed by a CRLF.
     * @param pVal the String to be printed
     * @throws IOException if an I/O error has occurred
     */
    public void println(String pVal) throws IOException {
        mPrintWriter.println(pVal);
    }

    /**
     * Prints a CRLF
     * @throws IOException if an I/O error has occurred
     */
    public void println() throws IOException {
        mPrintWriter.println();
    }
}
