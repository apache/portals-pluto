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

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;


/**
 * <div class='changed_added_3_0'>
 * This annotation is used within composite portlet configuration annotations to
 * represent a single public render parameter.
 * It cannot be used as a stand-alone portlet annotation.
 * </div>
 * 
 * @since 3.0
 */
@Retention(RUNTIME) @Target({ANNOTATION_TYPE})
public @interface PublicRenderParameterDefinition {
   
   /**
    * <div class='container-change changed_added_3_0'>
    * The public render parameter identifier.
    * <p>
    * This identifier is used as the public render parameter name in the
    * portlet parameter handling interfaces.
    * <p>
    * The public render parameter identifier must be unique within the portlet application. 
    * </div>
    * 
    * @see     javax.portlet.PortletConfig#getPublicRenderParameterNames() PortletConfig#getPublicRenderParameterNames
    * 
    * @return  The public render parameter identifier
    */
   String      identifier();
   
   /**
    * <div class='container-change changed_added_3_0'>
    * The public render parameter Qname.
    * <p>
    * The public render parameter qname must be unique within the portlet application. 
    * </div>
    * 
    * @see     javax.xml.namespace.QName
    * @see     <a href="http://www.w3.org/TR/2001/REC-xmlschema-2-20010502/#QName">Qname definition</a>
    * 
    * @return  The qname
    */
   PortletQName   qname();
   
   /**
    * <div class='container-change changed_added_3_0'>
    * Provides locale-specific text describing the public render parameter for use by the portal application or by tools.
    * </div>
    * 
    * @return  The public render parameter description
    */
   LocaleString[]      description() default {};
   
   /**
    * <div class='container-change changed_added_3_0'>
    * The display-name type contains a locale-specific short name that is intended to be displayed by tools. 
    * It is used by display-name elements. 
    * The display name need not be unique.
    * </div>
    * 
    * @return  The display name
    */
   LocaleString[]   displayName() default {};
}
