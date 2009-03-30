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
package org.apache.pluto.tags;

/**
 * Backwards compatibility Pluto 1.0.1 RenderURLTag providing support for old
 * Pluto 1.0.1 portlet.tld usages.
 * <p>
 * Although a portlet.tld should not be provided by Portlet Applications
 * themselves but "injected" by the target portlet container, fact is many
 * have them embedded in the application anyway. This class ensures those
 * applications still can use their old portlet.tld.
 * </p>
 * @version $Id$
 * @deprecated
 */
public class RenderURLTag extends RenderURLTag168
{
    private static final long serialVersionUID = 286L;
}
