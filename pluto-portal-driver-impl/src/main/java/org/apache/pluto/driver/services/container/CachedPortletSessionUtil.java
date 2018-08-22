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
package org.apache.pluto.driver.services.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class contains a ClassLoader singleton {@link Map} named {@link #INVALIDATED_SESSIONS} that is used to work-
 * around a Tomcat issue such that invalidated {@link javax.servlet.http.HttpSession} objects are recycled in a cross-
 * context environment.
 */
public class CachedPortletSessionUtil {

	public static final Map<String, Boolean> INVALIDATED_SESSIONS = new ConcurrentHashMap<>();
}
