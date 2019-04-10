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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.DestroyMethod;
import javax.portlet.annotations.EventMethod;
import javax.portlet.annotations.HeaderMethod;
import javax.portlet.annotations.InitMethod;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.infomas.annotation.AnnotationDetector;

/**
 * Uses the annotation detector to find the portlet method annotations.
 * 
 * @author Scott Nicklous
 * 
 */
public class MethodAnnotationRecognizer extends PortletAnnotationRecognizer implements AnnotationDetector.MethodReporter {
   private static final Logger LOG = LoggerFactory.getLogger(MethodAnnotationRecognizer.class);
   private static final boolean isDebug = LOG.isDebugEnabled();
   
   private static final String  CLASSDIR  = "/WEB-INF/classes";
   private static final String  LIBDIR    = "/WEB-INF/lib";
   
   private AnnotationDetector ad;
   private Set<String> handledClasses = new HashSet<String>();


   public MethodAnnotationRecognizer(AnnotatedMethodStore pms, ConfigSummary summary) {
      this(pms, summary, true);
   }

   public MethodAnnotationRecognizer(AnnotatedMethodStore pms, ConfigSummary summary, boolean mvc) {
      super(pms, summary, mvc);
      ad = new AnnotationDetector(this);
   }

   /**
    * Defines the annotation classes to be scanned for
    */
   @SuppressWarnings("unchecked")
   @Override
   public Class<? extends Annotation>[] annotations() {
      return new Class[] { HeaderMethod.class, ActionMethod.class, EventMethod.class, RenderMethod.class,
            ServeResourceMethod.class, InitMethod.class, DestroyMethod.class };
   }

   /**
    * Callback when a target annotation is found. Reuses superclass functionality to
    * register all portlet annotated methods in the class.
    */
   @Override
   public void reportMethodAnnotation(Class<? extends Annotation> anno, String className, String methName) {
      
      if (!handledClasses.contains(className)) {
         handledClasses.add(className);
         
         Class<?> valClass = null;
         StringBuilder txt = new StringBuilder(128);
         try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl == null) {
               cl = this.getClass().getClassLoader();
            }
            valClass = cl.loadClass(className);
         } catch (Exception e) {
         }

         if (isDebug) {
            txt.append("Found: ").append(anno.getSimpleName());
            txt.append(", class name: ").append(className);
            txt.append(", method name: ").append(methName);
            txt.append(", class: ").append((valClass == null) ? "could not be loaded." : "loaded.");
            LOG.debug(txt.toString());
         }

         if (valClass != null) {
            checkForMethodAnnotations(valClass);
         }
      }
   }
   
   /**
    * Scans the servlet context classes and libraries for portlet method
    * annotations.
    * 
    * @param ctx     the servlet context
    */
   public void scanContext(ServletContext ctx) {
      Set<File> files;
      
      files = getClassFilesForPath(ctx, CLASSDIR);
      scanFiles(files);
      
      files = getLibFilesForPath(ctx, LIBDIR);
      scanFiles(files);
      
   }
   
   /**
    * Scans the given set of files for annotations.
    * 
    * @param files   the files to scan
    */
   public void scanFiles(Set<File> files) {
      
      long start = System.currentTimeMillis();
      try {
         ad.detect(files.toArray(new File[0]));
      } catch (IOException e) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Exception scanning for method annotations.");
         
         StringWriter sw = new StringWriter();
         PrintWriter pw = new PrintWriter(sw);
         e.printStackTrace(pw);
         pw.flush();
         txt.append(sw.toString());
         
         LOG.warn(txt.toString());
      }
      long delta = System.currentTimeMillis() - start;
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Scanned ").append(files.size()).append(" files.");
         txt.append(" Time: ").append(delta).append(" ms.");
         txt.append("Files: ");
         String sep = "";
         for (File file : files) {
            txt.append(sep).append(file.toString());
            sep = ", ";
         }
         LOG.debug(txt.toString());
      }
   }
   

   /**
    * Generates a list of all class files available on a given servlet context 
    * resource path.
    * 
    * @param ctx     the servlet context
    * @param path    the resource path
    * 
    * @return        a set of class files
    */
   private Set<File> getClassFilesForPath(ServletContext ctx, String path) {
      Set<File> files = new HashSet<File>();
      Set<String> paths = ctx.getResourcePaths(path);
      if (paths != null) {
         for (String pth : paths) {
            if (pth.endsWith("META-INF/")) {
               continue;
            } else if (pth.endsWith("/")) {
               files.addAll(getClassFilesForPath(ctx, pth));
            } else if (pth.endsWith(".class")) {
               try {
                  URL url = ctx.getResource(pth);
                  File f = new File(url.toURI());
                  files.add(f);
               } catch(Exception e) {
                  StringBuilder txt = new StringBuilder(128);
                  txt.append("Exception getting library file.");
                  txt.append(" Servlet context path: ").append(ctx.getContextPath());
                  txt.append(", File path: ").append(path).append("\n");

                  StringWriter sw = new StringWriter();
                  PrintWriter pw = new PrintWriter(sw);
                  e.printStackTrace(pw);
                  pw.flush();
                  txt.append(sw.toString());

                  LOG.warn(txt.toString());
               }
            }
         }
      }
      return files;
   }

   /**
    * Returns a set of all library files in the designated servlet context resource path.
    * 
    * @param ctx     the servlet context
    * @param path    the resource path
    * 
    * @return        a set of class files
    */
   private Set<File> getLibFilesForPath(ServletContext ctx, String path) {
      Set<File> files = new HashSet<File>();
      Set<String> libs = ctx.getResourcePaths(path);
      if (libs != null) {
         for (String lib : libs) {
            if (lib.endsWith(".jar")) {
               try {
                  URL url = ctx.getResource(lib);
                  File f = new File(url.toURI());
                  files.add(f);
               } catch(Exception e) {
                  StringBuilder txt = new StringBuilder(128);
                  txt.append("Exception getting library file.");
                  
                  StringWriter sw = new StringWriter();
                  PrintWriter pw = new PrintWriter(sw);
                  e.printStackTrace(pw);
                  pw.flush();
                  txt.append(sw.toString());
                  
                  LOG.warn(txt.toString());
               }
            }
         }
      }
      return files;
   }


}
