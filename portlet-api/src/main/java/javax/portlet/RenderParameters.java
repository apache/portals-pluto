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

package javax.portlet;


/**
 * <div class="changed_added_3_0">
 * Provides access to render parameters, which make up part of the render state.
 * </div>
 * @see     PortletParameters
 * @see     MutableRenderParameters
 * @since   3.0
 */
public interface RenderParameters extends PortletParameters
{

   
   /**
    * <div class="changed_added_3_0">
    * Returns a <code>MutableRenderParameters</code> object encapsulating a copy of the same
    * parameters as the original object.
    * Changing a mutable copy will not influence the source object. 
    * </div>
    * 
    * @return Mutable clone of RenderParameters object
    */
   
   public MutableRenderParameters clone();

   
   /**
    * <div class="changed_added_3_0">
    * Returns a boolean value indicating whether the given
    * parameter name represents a public render parameter.
    * Note that if <code>true</code> is returned, it does not mean that a public 
    * render parameter value is set.
    * </div> 
    *
    * @param   name
    *          the parameter name
    *
    * @return  <code>true</code> if the given parameter
    *           name represents a public render parameter.
    *           <code>false</code> otherwise
    *
    * @exception  java.lang.IllegalArgumentException 
    *                            if name is <code>null</code>.
    */

   public boolean isPublic (String name);

}
