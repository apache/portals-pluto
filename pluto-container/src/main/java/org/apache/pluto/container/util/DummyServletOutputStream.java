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

import javax.servlet.ServletOutputStream;

public final class DummyServletOutputStream extends ServletOutputStream{

    private static final ServletOutputStream instance = new DummyServletOutputStream();
    
    public static ServletOutputStream getInstance()
    {
        return instance;
    }
    
    private DummyServletOutputStream()
    {
    }
    
	@Override
	public void write(int b) throws IOException {
	}

	@Override
	public void print(boolean arg0) throws IOException {
	}

	@Override
	public void print(char arg0) throws IOException {
	}

	@Override
	public void print(double arg0) throws IOException {
	}

	@Override
	public void print(float arg0) throws IOException {
	}

	@Override
	public void print(int arg0) throws IOException {
	}

	@Override
	public void print(long arg0) throws IOException {
	}

	@Override
	public void print(String arg0) throws IOException {
	}

	@Override
	public void println() throws IOException {
	}

	@Override
	public void println(boolean arg0) throws IOException {
	}

	@Override
	public void println(char arg0) throws IOException {
	}

	@Override
	public void println(double arg0) throws IOException {
	}

	@Override
	public void println(float arg0) throws IOException {
	}

	@Override
	public void println(int arg0) throws IOException {
	}

	@Override
	public void println(long arg0) throws IOException {
	}

	@Override
	public void println(String arg0) throws IOException {
	}

	@Override
	public void close() throws IOException {
	}

	@Override
	public void flush() throws IOException {
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
	}

	@Override
	public void write(byte[] b) throws IOException {
	}

	
}
