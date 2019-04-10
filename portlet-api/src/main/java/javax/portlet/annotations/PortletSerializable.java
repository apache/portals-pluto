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

/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet.annotations;

/**
 * <div class='changed_added_3_0'>
 * This interface must be implemented by {@link RenderStateScoped} beans
 * in order to allow the bean portlet container to intialize the bean at the
 * beginning of a request and passivate the bean at the end of the request.
 * <p>
 * These methods are not intended to be called by application code.
 * <p>
 * A <code>{@literal @}RenderStateScoped</code> bean must be a valid bean; in particular,
 * it must provide a default constructor or be constructable through an 
 * <code>{@literal @}Produces</code> method or field.
 * <p>
 * Note that only changes made to the bean state during <code>ActionMethod</code>
 * or <code>EventMethod</code> execution are stored in the render state.
 * Changes made during <code>RenderMethod</code>, <code>ServeResourceMethod</code>,
 * or <code>HeaderMethod</code> execution will not be available during subsequent requests.
 * </div>
 * 
 * @see RenderStateScoped
 * 
 * @since 3.0
 */
public interface PortletSerializable {
   
   /**
    * <div class='changed_added_3_0'>
    * The portlet bean container calls this method after {@link ActionMethod}
    * or {@link EventMethod} execution to obtain the bean state.
    * <p>
    * The bean developer should take care to include all internal bean data in the
    * returned state that is necessary for properly initializing the bean when the
    * portlet bean container calls the 
    * {@link PortletSerializable#deserialize(String[]) deserialize} method.
    * <p>
    * If no bean data has been set, this method should return an empty array or 
    * <code>null</code> in order to avoid setting extraneous parameters.
    * </div>
    * 
    * @return     The bean state as a string array.
    */
   public String[]   serialize();
   
   /**
    * <div class='changed_added_3_0'>
    * The bean portlet container calls this method at the beginning of every portlet
    * request method that uses the bean. 
    * <p> 
    * The string array render state data is the same array provided to the container
    * by the {@link PortletSerializable#serialize() serialize} method.
    * The bean should reconstruct its internal state during execution of this method.
    * <p>
    * If no data is available for the portlet, for example because because no 
    * {@link ActionMethod} or {@link EventMethod} has been executed for the portlet, 
    * the state parameter will be an empty array.
    * <p>
    * If the state array is empty, the bean implementation should provide approriate 
    * default values for its internal variables.
    * </div>
    * 
    * @param state      The bean state as string array.
    *                   The array will be empty if bean data has not yet been set.
    */
   public void       deserialize(String[] state); 
}
