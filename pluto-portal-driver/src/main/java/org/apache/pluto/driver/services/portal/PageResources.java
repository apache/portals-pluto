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


package org.apache.pluto.driver.services.portal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a container for configured resources such as style sheets and javascript 
 * files that can be added to a portal page in the document head section.
 * 
 * @author Scott Nicklous
 *
 */
public class PageResources {
   private static final Logger LOG = LoggerFactory.getLogger(PageResources.class);
   private static final boolean isDebug = LOG.isDebugEnabled();
   @SuppressWarnings("unused")
   private static final boolean isTrace = LOG.isTraceEnabled();
   
   
   
   private static class Source {
      String type;
      String source;
      public Source(String type, String source) {
         this.type = type;
         this.source = source;
      }
      
      @Override
      public String toString() {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Page resource source. Type: ").append(type);
         txt.append(", Source: ").append(source);
         return txt.toString();
      }
   }
   
   private Map<PageResourceId, Source> resources = new HashMap<PageResourceId, Source>();
   
   public PageResources() {
   }
   
   public void addResource(PageResourceId id, String type, String source) {
      if (id.getName() != null && id.getScope() != null  && id.getVersion() != null && type != null && source != null) {
         resources.put(id, new Source(type.toUpperCase(), source));
      } else {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Required value null when adding page Resource");
         txt.append(", id: ").append(id.toString());
         txt.append(", type: ").append(type.toUpperCase());
         txt.append(", source: ").append(source);
         LOG.warn(txt.toString());
      }

      if (isDebug) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Adding page Resource");
         txt.append(", id: ").append(id.toString());
         txt.append(", type: ").append(type.toUpperCase());
         txt.append(", source: ").append(source);
         LOG.debug(txt.toString());
      }
   }
   
   /**
    * Returns the markup for a given page resource ID, properly fixed
    * up with the context path, if necessary.
    *  
    * @param resid         the page resource ID
    * @param contextPath   the context path
    * @return              the markup for the page resource, or <code>null</code> if ID not found
    */
   public String getMarkup(PageResourceId resid, String contextPath) {
      String markup = null;
      
      if (resources.containsKey(resid)) {
         Source src = resources.get(resid);
         StringBuilder txt = new StringBuilder(128);
         switch (src.type) {
         case "CSS":
            txt.append("<link rel='stylesheet' type='text/css' href='");
            txt.append(contextPath).append(src.source);
            txt.append("'></link>");
            break;
         case "SCRIPT":
            txt.append("<script type='text/javascript' src='");
            txt.append(contextPath).append(src.source);
            txt.append("'></script>");
            break;
         case "MARKUP":
            txt.append(src.source);
            break;
         default:
            LOG.warn("Unknown page resource type: " + src.type);
         }
         if (txt.length() > 0) {
            markup = txt.toString();
         }
      }
      
      return markup;
   }
   
   public String getMarkup(List<PageResourceId> resids, String contextPath) {
      StringBuilder txt = new StringBuilder(128);
      
      for (PageResourceId resid : resids) {
         txt.append(getMarkup(resid, contextPath)).append("\n");
      }
      
      return (txt.length() == 0) ? null : txt.toString();
   }

   @Override
   public String toString() {
      StringBuilder txt = new StringBuilder(128);
      txt.append("Available resources:");
      for (PageResourceId id : resources.keySet()) {
         txt.append("\n   ").append(id.toString());
         txt.append(" : ").append(resources.get(id).toString());
      }
      return txt.toString();
   }
}
