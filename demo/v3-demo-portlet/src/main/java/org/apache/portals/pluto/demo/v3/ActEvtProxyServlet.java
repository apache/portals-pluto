/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.portals.pluto.demo.v3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.apache.portals.pluto.demo.v3.TagLibPortlet.ATTRIB_TXT;
import static org.apache.portals.pluto.demo.v3.TagLibPortlet.PROXY;
import static org.apache.portals.pluto.demo.v3.TagLibPortlet.TEST;

/**
 * Servlet used by the {@link TagLibPortlet}.
 */
@WebServlet(urlPatterns = PROXY)
public class ActEvtProxyServlet extends HttpServlet {
	private static final long serialVersionUID = -1798128019502989930L;
	private static final Logger logger = LoggerFactory.getLogger(ActEvtProxyServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
		ServletException, IOException {
		ProxyRespWrapper wrapped = new ProxyRespWrapper(resp);
		String ttype = req.getParameter(TEST);
		RequestDispatcher rd = req.getRequestDispatcher(ParamUtil.getJsp(ttype));
		rd.include(req, wrapped);
		String output = wrapped.getOutput();
		req.getSession().setAttribute(ATTRIB_TXT, output);
		logger.debug("Proxy executed. Output length: " + ((output == null) ? "null" : output.length()));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	private static class ProxyRespWrapper extends HttpServletResponseWrapper {

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		public ProxyRespWrapper(HttpServletResponse response) {
			super(response);
		}

		public String getOutput() {
			pw.flush();
			return sw.toString();
		}

		@Override
		public PrintWriter getWriter() throws IOException {
			return pw;
		}

	}
}
