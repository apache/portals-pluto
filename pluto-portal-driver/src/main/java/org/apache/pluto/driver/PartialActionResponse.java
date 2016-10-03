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
package org.apache.pluto.driver;

import org.apache.pluto.driver.util.RenderData;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;


/**
 * @author  Neil Griffin
 */
public class PartialActionResponse extends HttpServletResponseWrapper {

	private String contentType;
	private PrintWriter printWriter;
	private StringWriter stringWriter;

	public PartialActionResponse(HttpServletResponse response) {
		super(response);
		this.stringWriter = new StringWriter();
		this.printWriter = new PrintWriter(stringWriter);
	}

	public RenderData getRenderData() {
		return new RenderData(stringWriter.toString(), contentType);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		return printWriter;
	}

	@Override
	public void setContentLength(int contentLength) {
		// no-op
	}

	@Override
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
