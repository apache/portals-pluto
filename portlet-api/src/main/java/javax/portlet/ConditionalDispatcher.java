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

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * <div class="changed_added_3_0">
 * This interface provides methods to be implemented in order to implement conditional 
 * method dispatching.
 * </div>
 *
 */
public interface ConditionalDispatcher {

   /**
    * <div class="changed_added_3_0">
    * Called by the portlet container when an {@literal @}RenderMethod annotated 
    * method is to be dispatched.
    * <p>
    * The method should analyze the given <code>Set</code> of candidate methods using
    * the annotations available from each <code>MethodToken</code> 
    * based on the current request and
    * create a list of method tokens representing the methods to be invoked. 
    * The output list may be empty or <code>null</code>. 
    * A given method token may appear in the output list more than once.  
    * <p>
    * If the method returns a non-<code>null</code> List object, the portlet container will
    * invoke the methods in the order they appear in the list, and then 
    * perform no further dispatching operation for the current request.
    * <p>
    * If the method returns <code>null</code>, the portlet container will dispatch the 
    * method using its implementation-specific algorithm.
    * <p>
    * If the method throws an exception, it will be treated as an unhandled exception
    * during render request processing. The portlet container will perform no 
    * further dispatching.
    * </div>
    *  
    * @param request    The render render request
    * @param response   The render render response
    * @param methods    A <code>Set</code> containing the 
    *                   method tokens representing the candidate methods for this dispatch action.
    * @return           A list of method tokens if the dispatch has been handled. The list may be empty.
    *                   <code>null</code> if the portlet container is to continue with 
    *                   dispatching.
    * @throws IOException        If an I/O error occurs
    * @throws PortletException   If an unexpected condition arises
    * 
    * @see  MethodToken
    * @see  javax.portlet.annotations.RenderMethod
    */
   public List<MethodToken> dispatch(RenderRequest request, RenderResponse response, 
                                     Set<MethodToken> methods) 
                                     throws IOException, PortletException;

   /**
    * <div class="changed_added_3_0">
    * Called by the portlet container when an {@literal @}HeaderMethod annotated 
    * method is to be dispatched.
    * <p>
    * The method should analyze the given <code>Set</code> of candidate methods using
    * the annotations available from each <code>MethodToken</code> 
    * based on the current request and
    * create a list of method tokens representing the methods to be invoked. 
    * The output list may be empty or <code>null</code>. 
    * A given method token may appear in the output list more than once.  
    * <p>
    * If the method returns a non-<code>null</code> List object, the portlet container will
    * invoke the methods in the order they appear in the list, and then 
    * perform no further dispatching operation for the current request.
    * <p>
    * If the method returns <code>null</code>, the portlet container will dispatch the 
    * method using its implementation-specific algorithm.
    * <p>
    * If the method throws an exception, it will be treated as an unhandled exception
    * during header request processing. The portlet container will perform no 
    * further dispatching.
    * </div>
    *  
    * @param request    The header request
    * @param response   The header  response
    * @param methods    A <code>Set</code> containing the 
    *                   method tokens representing the candidate methods for this dispatch action.
    * @return           A list of method tokens if the dispatch has been handled. The list may be empty.
    *                   <code>null</code> if the portlet container is to continue with 
    *                   dispatching.
    * @throws IOException        If an I/O error occurs
    * @throws PortletException   If an unexpected condition arises
    * 
    * @see  MethodToken
    * @see  javax.portlet.annotations.HeaderMethod
    */
   public List<MethodToken> dispatch(HeaderRequest request,  HeaderResponse response, 
                                     Set<MethodToken> methods)
                                     throws IOException, PortletException;

   /**
    * <div class="changed_added_3_0">
    * Called by the portlet container when an {@literal @}ServeResourceMethod annotated 
    * method is to be dispatched.
    * <p>
    * The method should analyze the given <code>Set</code> of candidate methods using
    * the annotations available from each <code>MethodToken</code> 
    * based on the current request and
    * create a list of method tokens representing the methods to be invoked. 
    * The output list may be empty or <code>null</code>. 
    * A given method token may appear in the output list more than once.  
    * <p>
    * If the method returns a non-<code>null</code> List object, the portlet container will
    * invoke the methods in the order they appear in the list, and then 
    * perform no further dispatching operation for the current request.
    * <p>
    * If the method returns <code>null</code>, the portlet container will dispatch the 
    * method using its implementation-specific algorithm.
    * <p>
    * If the method throws an exception, it will be treated as an unhandled exception
    * during resource request processing. The portlet container will perform no 
    * further dispatching.
    * </div>
    *  
    * @param request    The resource request
    * @param response   The resource response
    * @param methods    A <code>Set</code> containing the 
    *                   method tokens representing the candidate methods for this dispatch action.
    * @return           A list of method tokens if the dispatch has been handled. The list may be empty.
    *                   <code>null</code> if the portlet container is to continue with 
    *                   dispatching.
    * @throws IOException        If an I/O error occurs
    * @throws PortletException   If an unexpected condition arises
    * 
    * @see  MethodToken
    * @see  javax.portlet.annotations.ServeResourceMethod
    */
   public List<MethodToken> dispatch(ResourceRequest request,  ResourceResponse response,
                                     Set<MethodToken> methods) 
                                     throws IOException, PortletException;
}
