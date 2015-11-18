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


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;


/**
 * <div class='changed_added_3_0'>
 * Qualifier that specifies an resource parameter for injection.
 * The parameter will be <code>null</code> if accessed outside of a serve resource method.
 * <p>
 * Note that this method will only return resource parameters, not render parameters.
 * To access render parameters within a serve resource method, use the
 * {@link RenderParam} annotation.
 * However, if the specified name addresses both a resource parameter and a private render
 * parameter, the injected bean will contain both sets of values, with the 
 * render parameter entries following the resource parameter entries in the values array.
 * <p>
 * The type of the injection target must be <code>String</code> or <code>String[]</code>.
 * <p>
 * This annotation may only be used in <code>{@literal @}RequestScoped</code> or
 * <code>{@literal @}PortletStateScoped</code> beans.
 * <p>
 * Example:
 * <div class='codebox'>      
 * {@literal @}Inject {@literal @}ResourceParam("paramName")<br/>   
 * private String[] paramValues;
 * </div>                    
 * </div>
 * 
 * @see javax.portlet.PortletRequest#getParameter(String) getParameter
 * @see javax.portlet.PortletRequest#getParameterValues(String) getParameterValues
 * @see javax.portlet.ResourceRequest#getPrivateRenderParameterMap() getPrivateRenderParameterMap
 * 
 * @see RenderParam
 */

@Qualifier @Retention(RUNTIME) @Target({METHOD, FIELD, PARAMETER})
public @interface ResourceParam {
   
   /**
    * The parameter name.
    * 
    * @return     The parameter name.
    */
   @Nonbinding String   value();
}
