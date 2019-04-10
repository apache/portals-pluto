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


package org.apache.pluto.container.bean.processor.tests;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Methods to help handle class files.
 * 
 * @author Scott Nicklous
 *
 */
public class FileHelper {

   /**
    * Returns a set of all class files for given package.
    * 
    * @param pkg        the package
    * @return           set of classes
    * @throws URISyntaxException
    * @throws IOException
    */
   public static Set<File> getClasses(String pkg) throws URISyntaxException, IOException {
      Set<File> classes = new HashSet<File>();

      ClassLoader cl = Thread.currentThread().getContextClassLoader();
      
      List<URL> urls = Collections.list(cl.getResources(pkg.replaceAll("\\.", "/")));
      for (URL url : urls) {
         File dir = new File(url.toURI());
         if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
               if (file.isFile() && file.getAbsolutePath().endsWith(".class")) {
                  classes.add(file);
               }
            }
         }
      }

      return classes;
   }

}
