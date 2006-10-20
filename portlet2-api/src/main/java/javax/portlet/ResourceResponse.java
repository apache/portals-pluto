/*
 * Copyright 2006 The Apache Software Foundation
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
/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */
/*
 * Copyright 2006 IBM Corporation.
 */
package javax.portlet;

/**
 * The <CODE>ResourceResponse</CODE> defines an object to assist a portlet 
 * for rendering a resource.
 * It extends the <CODE>RenderResponse</CODE> interface.<br>
 * The difference between the <CODE>RenderResponse</CODE> is that for the 
 * <CODE>ResourceResponse</CODE> the output of this response is delivered
 * directly to the client without any additional markup added by the portal.
 * It is therefore allowed for the portlet to return binary content in this
 * response.
 * <p>
 * A portlet can set HTTP headers for the response via the setProperty or 
 * addProperty call in the <CODE>ResourceResponse</CODE>. 
 * To be successfully transmitted back to the client, headers must be set 
 * before the response is committed. Headers set after the response is 
 * committed will be ignored by the portlet container.
 * <p>
 * The portlet container creates a <CODE>RenderResponse</CODE> object and 
 * passes it as argument to the portlet's <CODE>render</CODE> method.
 * 
 * @see RenderResponse
 */
public interface ResourceResponse extends RenderResponse {

}
