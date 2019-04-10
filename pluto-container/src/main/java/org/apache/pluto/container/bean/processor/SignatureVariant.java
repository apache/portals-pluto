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


package org.apache.pluto.container.bean.processor;

/**
 * Enum to identify the signature variant for annotated methods that allow
 * multiple method signatures.
 * 
 * @author Scott Nicklous
 */
public enum SignatureVariant {

   /**
    * The default signature for the method.
    */
   DEFAULT,

   /**
    * Signature variant for ActionMethod, with return value String and
    * taking a ActionRequest and ActionResponse as arguments.
    */
   STRING_ACTIONREQ_ACTIONRESP,

   /**
    * Signature variant for RenderMethod, with return value String and
    * taking a RenderRequest and RenderResponse as arguments.
    */
   STRING_RENDERREQ_RENDERRESP,

   /**
    * Signature variant for ResourceMethod, with return value String and
    * taking a ResourceRequest and ResourceResponse as arguments.
    */
   STRING_RESOURCEREQ_RESOURCERESP,

   /**
    * Signature variant for render, header, and resource methods, with return
    * value String and taking no arguments.
    */
   STRING_VOID,

   /**
    * Signature variant for HeaderMethod, with return value void and 
    * taking a HeaderRequest and HeaderResponse as arguments.
    */
   VOID_HEADERREQ_HEADERRESP,
   
   /**
    * Signature variant for RenderMethod, with return value void and 
    * taking a RenderRequest and RenderResponse as arguments.
    */
   VOID_RENDERREQ_RENDERRESP,
   
   /**
    * Signature variant for ResourceMethod, with return value void and 
    * taking a ResourceRequest and ResourceResponse as arguments.
    */
   VOID_RESOURCEREQ_RESOURCERESP,

   /**
    * Signature variant for render, header, and resource methods, with return 
    * value void and taking no arguments.
    */
   VOID_VOID,
   
}
