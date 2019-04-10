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

import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * Verifies the method signature according to the constructor parameters.
 * 
 * @author nick
 *
 */
public class MethodDescription {
   
   // Constants for standard portlet class methods
   //==============================================
   
   public static MethodDescription METH_INI = new MethodDescription(void.class, 
         new Class<?>[] {PortletConfig.class},  
         new Class<?>[] {PortletException.class, java.io.IOException.class}, 
         MethodType.INIT);
   
   public static MethodDescription METH_DES = new MethodDescription(void.class, 
         new Class<?>[] {},  
         new Class<?>[] {}, 
         MethodType.DESTROY);
   
   public static MethodDescription METH_ACT = new MethodDescription(void.class, 
         new Class<?>[] {ActionRequest.class, ActionResponse.class},  
         new Class<?>[] {PortletException.class, java.io.IOException.class}, 
         MethodType.ACTION);
   
   public static MethodDescription METH_EVT = new MethodDescription(void.class, 
         new Class<?>[] {EventRequest.class, EventResponse.class},  
         new Class<?>[] {PortletException.class, java.io.IOException.class}, 
         MethodType.EVENT);

   public static MethodDescription METH_REN = new MethodDescription(void.class, 
         new Class<?>[] {RenderRequest.class, RenderResponse.class},  
         new Class<?>[] {PortletException.class, java.io.IOException.class}, 
         MethodType.RENDER);
   static {
      METH_REN.setAllowMultiple(true);
      METH_REN.setVariant(SignatureVariant.VOID_RENDERREQ_RENDERRESP);
   }

   public static MethodDescription METH_RES = new MethodDescription(void.class, 
         new Class<?>[] {ResourceRequest.class, ResourceResponse.class},  
         new Class<?>[] {PortletException.class, java.io.IOException.class}, 
         MethodType.RESOURCE);
   static {
      METH_RES.setAllowMultiple(true);
      METH_RES.setVariant(SignatureVariant.VOID_RESOURCEREQ_RESOURCERESP);
   }
   
   public static MethodDescription METH_HDR = new MethodDescription(void.class, 
         new Class<?>[] {HeaderRequest.class, HeaderResponse.class},  
         new Class<?>[] {PortletException.class, java.io.IOException.class}, 
         MethodType.HEADER);
   static {
      METH_HDR.setAllowMultiple(true);
      METH_HDR.setVariant(SignatureVariant.VOID_HEADERREQ_HEADERRESP);
   }

   //==============================================
   
   private final Class<?>     retType;
   private final Class<?>[]   argTypes;
   private final Class<?>[]   expTypes;
   
   // The lifecycle method type
   private final MethodType   type;

   // The method signature variant 
   private SignatureVariant   variant = SignatureVariant.DEFAULT;
   
   // If true, the declared exceptions are verified as part of the method signature
   private boolean            checkExceptions = false;
   
   // If true, multiple methods of this type are allowed
   private boolean            allowMultiple = false;

   // If true, it is a method signature required for MVC
   private boolean            mvc = false;
   
   // Message string used during method matching.
   private final StringBuilder errtxt = new StringBuilder(128);

   public MethodDescription(Class<?> rt, Class<?>[] at, Class<?>[] et, MethodType mt) {
      this.retType = rt;
      this.argTypes = at;
      this.expTypes = et;
      this.type = mt;
   }
   
   /**
    * gets the argument types for extracting a method from a class.
    * 
    * @return the argument types
    */
   public Class<?>[] getArgTypes() {
      return argTypes;
   }

   /**
    * @return the checkExceptions
    */
   public boolean isCheckExceptions() {
      return checkExceptions;
   }

   /**
    * @param checkExceptions the checkExceptions to set
    */
   public void setCheckExceptions(boolean checkExceptions) {
      this.checkExceptions = checkExceptions;
   }
   
   /**
    * @return the type
    */
   public MethodType getType() {
      return type;
   }

   public boolean isAllowMultiple() {
      return allowMultiple;
   }

   public void setAllowMultiple(boolean allowMultiple) {
      this.allowMultiple = allowMultiple;
   }

   public SignatureVariant getVariant() {
      return variant;
   }

   public void setVariant(SignatureVariant variant) {
      this.variant = variant;
   }
   
   /**
    * Returns <code>true</code> if the given method matches this method definition.
    * <p>
    * Sets the error text for potential later retrieval & display.
    * 
    * @param meth
    * @return                 <code>true</code> if the method matches
    */
   public boolean isMethodMatched(Method meth) {
      boolean ok = true;
      errtxt.setLength(0);
      
      if (!retType.isAssignableFrom(meth.getReturnType())) {
         ok = false;
         errtxt.append("Unexpected return value. Actual: ")
               .append(meth.getReturnType().getCanonicalName());
      }
      
      if (ok) {

         // Compare argument type arrays

         Class<?>[] types = meth.getParameterTypes();
         if (types.length != argTypes.length) {
            ok = false;
         } else {
            for (int ii = 0; ii < types.length; ii++) {
               if (!types[ii].isAssignableFrom(argTypes[ii])) {
                  ok = false;
               }
            }
         }
         
         if (!ok) {
            ArrayList<String> tmp = new ArrayList<String>();
            for (Class<?> c : types) {
               tmp.add(c.getCanonicalName());
            }
            errtxt.append("Parameter type mismatch.  Actual: ").append(tmp.toString());
         }

         // Compare exception type arrays. The order in which the exceptions are 
         // specified is not relevant. If exceptions are being checked, the method 
         // under test must have a subset of the allowed exceptions. 

         if (ok && checkExceptions) {
            types = meth.getExceptionTypes();
            if (types.length > expTypes.length) {
               ok = false;
            } else {
               for (int ii = 0; ii < types.length && ok; ii++) {
                  ok = false;
                  for (int jj = 0; jj < expTypes.length && !ok; jj++) {
                     if (expTypes[jj].isAssignableFrom(types[ii])) {
                        ok = true;
                     }
                  }
               }
            }
            if (!ok) {
               ArrayList<String> tmp = new ArrayList<String>();
               for (Class<?> c : types) {
                  tmp.add(c.getCanonicalName());
               }
               errtxt.append("Exception type mismatch. Actual: ").append(tmp.toString());
            }
         }
      }

      return ok;
   }

   public boolean isMvc() {
      return mvc;
   }

   public void setMvc(boolean mvc) {
      this.mvc = mvc;
   }

   /**
    * Returns the expected method signature in string form, optionally
    * showing the preceeding error message, if any.
    * 
    * @param showErrorString  If true, the error message is shown.
    * @return                 The method signature
    */
   public String getExpectedSignature(boolean showErrorString) {
      if (!showErrorString) {
         errtxt.setLength(0);
      } else {
         errtxt.append(", Expected signature:\n");
      }
      
      // return value
      errtxt.append(retType.getCanonicalName());

      // method name ( arguments
      errtxt.append(" &lt;name&gt;(");
      String sep = "";
      for (Class<?> c : argTypes) {
         errtxt.append(sep).append(c.getCanonicalName());
         sep = ", ";
      }
      errtxt.append(")");
      
      // exceptions, if any
      if (expTypes.length > 0) {
         errtxt.append(" throws ");
         sep = "";
         for (Class<?> c : expTypes) {
            errtxt.append(sep).append(c.getCanonicalName());
            sep = ", ";
         }
      }
      
      return errtxt.toString();
   }
   
   /**
    * shows all info about this description
    */
   public String toString() {
      StringBuilder txt = new StringBuilder(128);
      
      txt.append(getExpectedSignature(false));
      txt.append("/ type=").append(type);
      txt.append(", variant=").append(variant);
      txt.append(", checkExceptions=").append(checkExceptions);
      txt.append(", allowMultiple=").append(allowMultiple);
      
      return txt.toString();
   }

}
