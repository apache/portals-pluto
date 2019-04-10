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
 * represent a QName for use in portlet event and public render parameter definitions.
 * It cannot be used as a stand-alone portlet annotation.
 * <p>
 * The qname is specified as a string of the form 
 * <code>namespace-name:local-part</code>, where
 * <ul>
 * <li>
 * namespace-name is a URI specifying the namespace.
 * </li>
 * <li>
 * local-part is a non-empty String.
 * </li>
 * </ul>
 * </div>
 * 
 * @see     javax.xml.namespace.QName javax.xml.namespace.QName
 * @see     <a href="http://www.w3.org/TR/2001/REC-xmlschema-2-20010502/#QName">W3C Qname definition</a>
 * 
 * @since 3.0
 */
@Retention(RUNTIME) @Target({ANNOTATION_TYPE})
public @interface PortletQName {
   
   /**
    * <div class='changed_added_3_0'>
    * The QName namespace URI.
    * <p>
    * If the QName namespace URI is empty, the default value is used. 
    * The default value is taken from the following locations, specified in order of precedence:
    * <ul>
    * <li>
    * The value defined in the {@literal <}default-namespace{@literal >} element in the portlet
    * deployment descriptor.
    * </li>
    * <li>
    * The value defined in the {@literal <}defaultNamespace{@literal >} element in the
    * {@literal @}PortletApplication annotation.
    * </li>
    * <li>
    * The value javax.xml.XMLConstants.NULL_NS_URI
    * </li>
    * </ul>
    * </div>
    * 
    * @return  The QName namespace URI.
    * 
    * @see PortletApplication#defaultNamespaceURI()
    */
   String      namespaceURI();
   
   /**
    * <div class='changed_added_3_0'>
    * The local part.
    * <p>
    * local-part should be a non-empty String.
    * </div>
    * 
    * @return  The qname local part.
    */
   String      localPart();
}
