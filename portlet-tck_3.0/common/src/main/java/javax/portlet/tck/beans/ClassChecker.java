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
package javax.portlet.tck.beans;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tool for checking class properties such as implemented interfaces, superclass, methods with signatures, etc.
 * 
 * @author nick
 */
public class ClassChecker {
   private final Logger        LOGGER    = LoggerFactory.getLogger(ClassChecker.class);

   private Class<?>            cut;
   private ArrayList<Class<?>> ifList;

   /**
    * Construct with the class to be checked.
    * 
    * @param c
    *           class under test
    */
   public ClassChecker(Class<?> c) {
      cut = c;
      ifList = getAllInterfaces(cut);
   }

   /**
    * Returns true if the class under test has a field by the specified name.
    * 
    * @param fname
    *           Field name
    * @return true if the class under test defines the field
    */
   public boolean hasField(String fname) {
      boolean result = false;

      try {
         cut.getField(fname);
         result = true;
      } catch (Exception e) {
      }

      return result;
   }

   /**
    * Returns true if the class under test has a field by the specified name and value.
    * 
    * @param fname
    *           Field name
    * @param value
    *           Field value
    * @return true if the class under test defines the field with the specified value
    */
   public boolean hasField(String fname, String value) {
      boolean result = false;

      try {
         Field f = cut.getField(fname);
         String fValue = (String) f.get(null);
         if (fValue.equals(value)) {
            result = true;
         }
      } catch (Exception e) {
      }

      return result;
   }

   /**
    * Returns true if the class under test has a field by the specified name and value.
    * 
    * @param fname
    *           Field name
    * @param value
    *           Field value
    * @return true if the class under test defines the field with the specified value
    */
   public boolean hasField(String fname, int value) {
      boolean result = false;

      try {
         Field f = cut.getField(fname);
         int fValue = f.getInt(null);
         if (fValue == value) {
            result = true;
         }
      } catch (Exception e) {
      }

      return result;
   }

   /**
    * Returns true if the class under test has a field by the specified name and value.
    * 
    * @param fname
    *           Field name
    * @param value
    *           Field value
    * @return true if the class under test defines the field with the specified value
    */
   public boolean hasField(String fname, PortletMode value) {
      boolean result = false;

      try {
         Field f = cut.getField(fname);
         PortletMode fValue = (PortletMode) f.get(null);
         if (fValue.equals(value)) {
            result = true;
         }
      } catch (Exception e) {
      }

      return result;
   }

   /**
    * Returns true if the class under test has a field by the specified name and value.
    * 
    * @param fname
    *           Field name
    * @param value
    *           Field value
    * @return true if the class under test defines the field with the specified value
    */
   public boolean hasField(String fname, WindowState value) {
      boolean result = false;

      try {
         Field f = cut.getField(fname);
         WindowState fValue = (WindowState) f.get(null);
         if (fValue.equals(value)) {
            result = true;
         }
      } catch (Exception e) {
      }

      return result;
   }

   /**
    * Tests whether class under test implements given interface
    * 
    * @param ifType
    *           class of interface to be checked for
    * @return true if the cut implements the interface
    */
   public boolean implementsInterface(Class<?> ifType) {
      boolean result = false;

      if (ifList.contains(ifType)) {
         result = true;
      }
      return result;
   }

   /**
    * Tests whether class under test has the designated constructor
    * 
    * @param parmTypes
    *           argument types for constructor.
    * @return true if the cut implements the interface
    */
   public boolean hasConstructor(Class<?>... parmTypes) {
      boolean result = false;

      try {
         cut.getConstructor(parmTypes);
         result = true;
      } catch (Exception e) {
      }

      return result;
   }

   /**
    * Tests whether class under test implements given interface
    * 
    * @param name
    *           Method name
    * @param parms
    *           list of parameter types
    * @param exceptions
    *           list of exception types
    * @return true, if there exists such a method
    */
   public boolean hasMethod(String name, Class<?>[] parms, Class<?>[] exceptions) {
      boolean result = false;

      try {

         HashSet<Class<?>> exParm = new HashSet<Class<?>>();
         if (exceptions != null) {
            exParm.addAll(Arrays.asList(exceptions));
         }

         // if it isn't public, it might be protected
         Method m = null;
         try {
            m = cut.getMethod(name, parms);
         } catch (Exception e) {
            m = cut.getDeclaredMethod(name, parms);
         }

         HashSet<Class<?>> mexs = new HashSet<Class<?>>();
         mexs.addAll(Arrays.asList(m.getExceptionTypes()));

         LOGGER.trace("hasMethod: added exception types");

         if (exParm.isEmpty() && mexs.isEmpty()) {
            LOGGER.trace("hasMethod: no exceptions to check");
            result = true;
         } else {
            result = mexs.containsAll(exParm);
            if (result == false) {
               StringBuilder sb = new StringBuilder(512);
               sb.append("Method name: ").append(name).append("\n");
               sb.append("results of exception check: ").append(result).append("\n");
               sb.append("method exceptions: ").append(mexs).append("\n");
               sb.append("expected exceptions: ").append(exParm).append("\n");
               LOGGER.warn("hasMethod: {}", sb);
            }
         }

      } catch (Exception e) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Could not get method: ").append(name);
         LOGGER.warn(txt.toString(), e);
      }

      return result;
   }

   /**
    * Tests whether the class method has specified return type.
    * 
    * @param name
    *           Method name
    * @param retType
    *           return type
    * @param parms
    *           list of parameter types
    * @return true, if the method has the return type
    */
   public boolean methodHasReturnType(String name, Class<?> retType, Class<?>[] parms) {
      boolean result = false;

      try {

         // if it isn't public, it might be protected
         Method m = null;
         try {
            m = cut.getMethod(name, parms);
         } catch (Exception e) {
            m = cut.getDeclaredMethod(name, parms);
         }

         Class<?> cutRT = m.getReturnType();
         result = cutRT.equals(retType);
         if (result == false) {
            result = retType.isAssignableFrom(cutRT);
         }
      } catch (Exception e) {
      }

      return result;
   }

   /**
    * Tests whether class under test implements given interface
    * 
    * @param scType
    * @return true if the cut implements the interface
    */
   public boolean hasSuperclass(Class<?> scType) {
      boolean result = false;

      Class<?> c = cut.getSuperclass();
      result = c.equals(scType);

      return result;
   }

   /**
    * Tests whether the class under test is an annotation
    * 
    * @return true if the class under test is an annotation
    */
   public boolean isAnnotation() {
      return cut.isAnnotation();
   }

   /**
    * Tests whether the class under test is an Enum
    * 
    * @return true if the class under test is an Enum
    */
   public boolean isEnum() {
      return cut.isEnum();
   }

   private ArrayList<Class<?>> getAllInterfaces(Class<?> c) {
      ArrayList<Class<?>> ifs = new ArrayList<Class<?>>();

      Class<?>[] cs = c.getInterfaces();
      for (Class<?> cls : cs) {
         ifs.add(cls);
         ifs.addAll(getAllInterfaces(cls));
      }

      return ifs;
   }

}
