/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.testsuite.test.jsr286;

import java.io.IOException;

import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.pluto.testsuite.test.jsr286.event.ComplexPayloadEventTest;
import org.apache.pluto.testsuite.test.jsr286.event.ComposedObject;
import org.apache.pluto.testsuite.test.jsr286.event.SimplePayloadEventTest;

public class TestCompanionPortlet extends GenericPortlet {

    public static final String EVENT_INFO_PARAM = "eventInfoParameter";
    
    @Override
    protected void doView(RenderRequest request, RenderResponse response)
            throws PortletException, IOException {
        response.setContentType("text/html");
        
        String eventInfo = request.getParameter(EVENT_INFO_PARAM); 
        request.setAttribute("eventInfo", eventInfo);
        
        getPortletContext()
            .getRequestDispatcher("/jsp/TestCompanionPortlet.jsp")
                .include(request, response);
    }

    @ProcessEvent(name = SimplePayloadEventTest.SIMPLE_PAYLOAD_EVENT)
    public void processSimplePayload(EventRequest request, 
            EventResponse response) throws PortletException, IOException {
        
        StringBuilder feedback = new StringBuilder();
        feedback.append("Simple Payload Event received.");

        if (!SimplePayloadEventTest.SIMPLE_VALUE_PAYLOAD.equals(
                request.getEvent().getValue())) {
            feedback.append("  Payload DID NOT match expected value.");
        } else {
            feedback.append("  Payload matched expected value.");
        }
        
        response.setRenderParameter(EVENT_INFO_PARAM, feedback.toString());
    }
    
    @ProcessEvent(name = ComplexPayloadEventTest.COMPLEX_PAYLOAD_EVENT)
    public void processComplexPayload(EventRequest request, 
            EventResponse response) throws PortletException, IOException {
        
        StringBuilder feedback = new StringBuilder();
        feedback.append("Complex Payload Event received.");

        boolean failed = false;
        ComposedObject value = (ComposedObject) request.getEvent().getValue();
        if (!ComplexPayloadEventTest.TEST_COLOR.equals(value.getColor())) {
            feedback.append("  Color DID NOT match expected value.");
            failed = true;
        }
        if (!ComplexPayloadEventTest.TEST_POINT.equals(value.getPoint())) {
            feedback.append("  Point DID NOT match expected value.");
            failed = true;
        }
        if (!failed) {
            feedback.append("  Payload matched expected values.");
        }
        
        response.setRenderParameter(EVENT_INFO_PARAM, feedback.toString());
    }
        
}