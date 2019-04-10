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


package javax.portlet;

/**
 * <div class="changed_added_3_0">
 * Tag interface designating a header request object.
 * <p>
 * The portlet programming interface provides a mechanism to assist portlets when 
 * the aggregated portal markup is an HTML or similar document that requires markup
 * for the document <code>HEAD</code> section to be written and HTTP headers to be 
 * set before the render markup for each individual portlet is aggregated.
 * This mechanism is represented in the portlet API by the {@link HeaderPortlet}, 
 * {@link HeaderRequest}, and {@link HeaderResponse} interfaces.
 * <p>  
 * The <CODE>HeaderRequest</CODE> provides the portlet with information about
 * the request.
 * </div>
 *
 *@see HeaderResponse
 *@see HeaderPortlet
 * 
 * @since 3.0
 */
public interface HeaderRequest extends RenderRequest {

}
