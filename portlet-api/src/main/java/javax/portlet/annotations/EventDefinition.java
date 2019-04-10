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
 * represent a single event.
 * It cannot be used as a stand-alone portlet annotation.
 * </div>
 * 
 * @since 3.0
 */
@Retention(RUNTIME) @Target({ANNOTATION_TYPE})
public @interface EventDefinition {
   
   /**
    * <div class='changed_added_3_0'>
    * The event Qname.
    * <p>
    * The local part of the QName should be a non-empty String.
    * The local part is used as the event name in the portlet API 
    * event handling methods.
    * <p>
    * The event qname must be unique within the portlet application. 
    * </div>
    * 
    * @see     javax.portlet.Event
    * @see     javax.portlet.StateAwareResponse#setEvent(javax.xml.namespace.QName, java.io.Serializable)
    * @see     javax.portlet.StateAwareResponse#setEvent(String, java.io.Serializable)
    * @see     javax.portlet.PortletConfig#getProcessingEventQNames() PortletConfig#getProcessingEventQNames
    * @see     javax.portlet.PortletConfig#getPublishingEventQNames() PortletConfig#getPublishingEventQNames
    * 
    * @return  The event qname
    */
   PortletQName   qname();

   /**
    * <div class='changed_added_3_0'>
    * The event payload type associated with the specified QName.
    * Each QName may have only a single event payload type associated with it.
    * The payload type must be serializable and must have a valid JAXB binding.
    * <p>
    * The default value <code>void.class</code> indicates that the event has no payload. 
    * </div>
    * 
    * @see     javax.portlet.Event
    * @see     javax.portlet.StateAwareResponse#setEvent(javax.xml.namespace.QName, java.io.Serializable)
    * @see     javax.portlet.StateAwareResponse#setEvent(String, java.io.Serializable)
    * 
    * @return     A class representing the payload type
    */
   Class<?>    payloadType() default void.class;
   
   /**
    * <div class='container-change changed_added_3_0'>
    * Provides locale-specific text describing the event for use by the portal application or by tools.
    * </div>
    * 
    * @return  The event description
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

   /**
    * <div class='container-change changed_added_3_0'>
    * The qualified name aliases for this event.
    * </div>
    * 
    * @return the qualified name aliases
    */
   PortletQName[]    alias() default {};
}
