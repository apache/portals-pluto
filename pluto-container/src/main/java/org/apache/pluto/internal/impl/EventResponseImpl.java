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

package org.apache.pluto.internal.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.internal.InternalEventResponse;
import org.apache.pluto.internal.InternalPortletWindow;

/**
 * Implementation of JSR-286 <code>EventResponse</code>.
 *
 * @since 2.0
 */

public class EventResponseImpl extends StateAwareResponseImpl
	implements EventResponse,InternalEventResponse {

    public EventResponseImpl(PortletContainer container,
                              InternalPortletWindow internalPortletWindow,
                              HttpServletRequest servletRequest,
                              HttpServletResponse servletResponse) {
        super(container, internalPortletWindow, servletRequest,
              servletResponse);
    }

	public void setRenderParameters(EventRequest request) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}

	@Override
	public void reset() {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.reset();
	}

	@Override
	public void resetBuffer() {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.resetBuffer();
	}

	@Override
	public void setBufferSize(int arg0) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setBufferSize(arg0);
	}

	@Override
	public void setCharacterEncoding(String arg0) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setCharacterEncoding(arg0);
	}

	@Override
	public void setContentLength(int arg0) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setContentLength(arg0);
	}

	@Override
	public void setContentType(String arg0) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setContentType(arg0);
	}

	@Override
	public void setLocale(Locale arg0) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setLocale(arg0);
	}

	@Override
	public ServletOutputStream getOutputStream() throws IllegalStateException, IOException {
		if (super.isForwarded() || super.isIncluded()){
			return null;
		}
		else
			return super.getOutputStream();
	}

	@Override
	public PrintWriter getWriter() throws IllegalStateException, IOException {
		if (super.isForwarded() || super.isIncluded()){
			return null;
		}
		else
			return super.getWriter();
	}

	@Override
	public void addCookie(Cookie arg0) {
		if (super.isForwarded()){
			addProperty(arg0);
		}
		else if (super.isIncluded()){
			//no operation
		}
		else
		super.addCookie(arg0);
	}

	@Override
	public void addDateHeader(String arg0, long arg1) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.addDateHeader(arg0, arg1);
	}

	@Override
	public void addHeader(String arg0, String arg1) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.addHeader(arg0, arg1);
	}

	@Override
	public void addIntHeader(String arg0, int arg1) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.addIntHeader(arg0, arg1);
	}

	@Override
	public boolean containsHeader(String arg0) {
		if (super.isForwarded() || super.isIncluded()){
			return false;
		}
		else
			return super.containsHeader(arg0);
	}

	@Override
	public String encodeRedirectUrl(String arg0) {
		if (super.isForwarded() || super.isIncluded()){
			return null;
		}
		else
		return super.encodeRedirectUrl(arg0);
	}

	@Override
	public String encodeRedirectURL(String arg0) {
		if (super.isForwarded() || super.isIncluded()){
			return null;
		}
		else
			return super.encodeRedirectURL(arg0);
	}

	@Override
	public void sendError(int arg0) throws IOException {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.sendError(arg0);
	}
	
	@Override
	public void sendError(int arg0, String arg1) throws IOException {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.sendError(arg0, arg1);
	}

	@Override
	public void setStatus(int arg0, String arg1) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setStatus(arg0, arg1);
	}

	@Override
	public void sendRedirect(String location) throws IOException {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		super.sendRedirect(location);
	}

	@Override
	public void setDateHeader(String arg0, long arg1) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setDateHeader(arg0, arg1);
	}

	@Override
	public void setHeader(String arg0, String arg1) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setHeader(arg0, arg1);
	}

	@Override
	public void setIntHeader(String arg0, int arg1) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setIntHeader(arg0, arg1);
	}

	@Override
	public void setStatus(int arg0) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setStatus(arg0);
	}

	@Override
	public void flushBuffer() throws IOException {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.flushBuffer();
	}

	@Override
	public int getBufferSize() {
		if (super.isForwarded() || super.isIncluded()){
			return 0;
		}
		else
			return super.getBufferSize();
	}

	@Override
	public String getCharacterEncoding() {
		if (super.isForwarded() || super.isIncluded()){
			return null;
		}
		else
			return super.getCharacterEncoding();
	}

	@Override
	public String getContentType() {
		if (super.isForwarded() || super.isIncluded()){
			return null;
		}
		else
			return super.getContentType();
	}

	@Override
	public Locale getLocale() {
		if (super.isForwarded() || super.isIncluded()){
			return null;
		}
		else
			return super.getLocale();
	}

	@Override
	public boolean isCommitted() {
		if (super.isForwarded() || super.isIncluded()){
			return true;
		}
		else
			return super.isCommitted();
	}
}
