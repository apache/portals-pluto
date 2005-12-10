/*
 * Copyright 2004 The Apache Software Foundation.
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
package org.apache.pluto.services.optional;

import org.apache.pluto.core.InternalPortletWindow;
import org.apache.pluto.core.InternalPortletRequest;
import org.apache.pluto.core.InternalPortletResponse;
import org.apache.pluto.core.InternalActionResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Factory Service for creating Portlet request and responses.
 *
 */
public interface PortletEnvironmentService {

   InternalPortletRequest createActionRequest(HttpServletRequest req,
                                               HttpServletResponse res,
                                               InternalPortletWindow window);

   InternalActionResponse createActionRespose(HttpServletRequest req,
                                               HttpServletResponse res,
                                               InternalPortletWindow window);

    InternalPortletRequest createRenderRequest(HttpServletRequest req,
                                               HttpServletResponse res,
                                               InternalPortletWindow window);

    InternalPortletResponse createRenderRespose(HttpServletRequest req,
                                                HttpServletResponse res,
                                                InternalPortletWindow window);



}
