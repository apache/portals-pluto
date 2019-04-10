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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pluto.container.PageResourceId;
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
   
   public enum Type {CSS, SCRIPT, MARKUP};
   
   /**
    * Holds data needed to generate markup for a page resource 
    */
   private static class Source {
      Type type;
      String source;
      public Source(Type type, String source) {
         this.type = type;
         this.source = source;
      }

      public Source(Source other) {
         this.type = other.type;
         this.source = other.source;
      }
      
      @Override
      public String toString() {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Page resource source. Type: ").append(type);
         txt.append(", Source: ").append(source);
         return txt.toString();
      }
   }

   // Initialization for backward compatibility with page config files that don't 
   // define resources

   private static final Map<PageResourceId, Source> defaultResources = new HashMap<PageResourceId, Source>();
   static {
      
      PageResourceId resid;
      Source src;
      
      resid = new PageResourceId("pluto.css", "org.apache.portals", "3.0.0");
      src = new Source(Type.CSS, "/css/pluto.css");
      defaultResources.put(resid, src);
      
      resid = new PageResourceId("portlet-spec-1.0.css", "org.apache.portals", "1.0.0");
      src = new Source(Type.CSS, "/css/portlet-spec-1.0.css");
      defaultResources.put(resid, src);
      
      resid = new PageResourceId("portlet-spec-2.0.css", "org.apache.portals", "2.0.0");
      src = new Source(Type.CSS, "/css/portlet-spec-2.0.css");
      defaultResources.put(resid, src);
      
      resid = new PageResourceId("pluto.js", "org.apache.portals", "3.0.0");
      src = new Source(Type.SCRIPT, "/javascript/portletHub.js");
      defaultResources.put(resid, src);
      
   }
   
   // The map containing the current page resources

   private Map<PageResourceId, Source> resources = new HashMap<PageResourceId, Source>();
   
   public PageResources() {
   }
   
   /**
    * copy constructor
    * 
    * @param other      the other page resources
    */
   public PageResources(PageResources other) {
      for (PageResourceId id : other.resources.keySet()) {
         this.resources.put(new PageResourceId(id), new Source(other.resources.get(id)));
      }
   }
   
   /**
    * called after initial config read to set defaults if necessary
    */
   public void initialized() {
      if (resources.isEmpty()) {
         resources.putAll(defaultResources);
      }
   }
   
   /**
    * adds a resource
    */
   public void addResource(PageResourceId id, Type type, String source) {
      if (id.getName() != null && type != null && source != null) {
         resources.put(id, new Source(type, source));
      } else {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Required value null when adding page Resource");
         txt.append(", id: ").append(id.toString());
         txt.append(", type: ").append((type == null) ? "null" : type.toString());
         txt.append(", source: ").append(source);
         LOG.warn(txt.toString());
      }

      if (isDebug) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Adding page Resource");
         txt.append(", id: ").append(id.toString());
         txt.append(", type: ").append((type == null) ? "null" : type.toString());
         txt.append(", source: ").append(source);
         LOG.debug(txt.toString());
      }
   }
   
   /**
    * Implements a fuzzy matching to identify best available resource.
    * 
    * @param resid   The desired resource resource ID
    * @return        The best match page resource ID
    */
   private Source getBestMatch(PageResourceId resid) {
      if (resources.containsKey(resid)) {
         return resources.get(resid);
      }
      
      // has to at least match on name, and if the scope is provided, on scope
      
      List<PageResourceId> candidates = new ArrayList<PageResourceId>();
      for (PageResourceId id : resources.keySet()) {
         if (resid.resourceMatches(id)) {
            candidates.add(id);
         }
      }
      
      PageResourceId effectiveId = null;
      if (candidates.size() > 0) {
         if (candidates.size() == 1) {
            effectiveId = candidates.get(0);
         } else {
            
            // There are more than one candidates that differ in version.
            // Choose the first one greater than the requested or the highest available.
            
            Collections.sort(candidates);
            for (PageResourceId id : candidates) {
               if (resid.compareTo(id) <= 0) {
                  effectiveId = id;
                  break;
               }
            }
            
            if (effectiveId == null) {
               effectiveId = candidates.get(candidates.size()-1);
            }
         }
      }
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Effective page resource ID: ");
         txt.append((effectiveId == null) ? "null" : effectiveId.toString());
         LOG.debug(txt.toString());
      }
      
      if (effectiveId != null) {
         return resources.get(effectiveId);
      }
      
      return null;
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
      String markup = "";
      
      Source src = getBestMatch(resid);
      if (src != null) {
         StringBuilder txt = new StringBuilder(128);
         switch (src.type) {
         case CSS:
            txt.append("<link rel='stylesheet' type='text/css' href='");
            txt.append(contextPath).append(src.source);
            txt.append("'></link>");
            break;
         case SCRIPT:
            txt.append("<script type='text/javascript' src='");
            txt.append(contextPath).append(src.source);
            txt.append("'></script>");
            break;
         case MARKUP:
            txt.append(src.source);
            break;
         default:
            LOG.warn("Unknown page resource type: " + src.type.toString());
         }
         markup = txt.toString();
      } else {
         LOG.warn("Unknown page resource ID: " + resid.toString());
      }
      
      return markup;
   }
   
   /**
    * Takes a list of page resource IDs that can potentially contain duplicates
    * and returns the appropriate head section markup.
    * <p>
    * Duplicate resource IDs are scrubbed. If resource IDs in the list differ only by
    * version, the resource ID with the highest version number is used.
    * <p>
    * An attempt is made to maintain the inclusion order when generating the markup.
    * 
    * @param prids        List of page resource IDs
    * @param contextPath   The context path 
    * @return              Markup string that can be added to the document head section
    */
   public String getMarkup(List<PageResourceId> prids, String contextPath) {
      List<PageResourceId> resultids = new ArrayList<PageResourceId>();
      
      // build the resulting page resource ID list by examining each ID from the
      // input list, comparing it to IDs already in the result list.

      for (PageResourceId newid : prids) {
         
         // look for page resource id match (without version)
         
         int index = -1;
         for (int ii = 0; ii < resultids.size(); ii++) {
            if (resultids.get(ii).resourceMatches(newid)) {
               index = ii;
               break;
            }
         }
         
         if (index == -1) {
            
            // no match, so just add new element
            resultids.add(newid);
            
         } else {
            PageResourceId currid = resultids.get(index);
            
            // ignore exact match (throw away exact duplicates)
            if (!currid.equals(newid)) {
               
               // The Id in the list differs from the new ID only in the version. 
               // The version will be compared assuming a format similar to that 
               // described by the semantic versioning spec (see http://semver.org/).
               // Format: MAJOR.MINOR.PATCH with decimal numbers
               // If, after truncating leading and trailing characters, the result does
               // not match this format, a simple string compare is used.
               // The latest version will be kept in the list at the original index.
               
               boolean replaceId = false;
               
               if (currid.getVersion() == null) {
                  // a specified version replaces a null version
                  replaceId = true;
               }

               // place vars here to allow debug data collection
               String currVersion = null;
               String newVersion  = null;
               String[] currDecimals = new String[0];
               String[] newDecimals  = new String[0];

               if (!replaceId && newid.getVersion() != null) {
                  
                  // Extract the dotted decimal version numbers
                  String regex = "^[vV=]{0,1}(\\d+(?:\\.\\d+){0,2}).*$";
                  currVersion = currid.getVersion().replaceFirst(regex, "$1");
                  newVersion  = newid.getVersion().replaceFirst(regex, "$1");
                  
                  String dottedDecimalRegex = "^\\d+(?:\\.\\d+)*$";
                  if (currVersion.matches(dottedDecimalRegex)) {
                     
                     // the current version is conforming dotted decimal. 
                     // If the new version is also conforming, compare version numbers.
                     // otherwise ignore.
                     
                     if (newVersion.matches(dottedDecimalRegex)) {
                        currDecimals = currVersion.split("\\.");
                        newDecimals  = newVersion.split("\\.");
                        for (int ii=0; (ii < currDecimals.length) && (ii < newDecimals.length); ii++) {
                           int currDigit = Integer.parseInt(currDecimals[ii]);
                           int newDigit = Integer.parseInt(newDecimals[ii]);
                           if (newDigit > currDigit) {
                              replaceId = true;
                              break;
                           }
                        }
                        if (!replaceId) {
                           // if the new id is identical, but with more digits, replace
                           if (newDecimals.length > currDecimals.length) {
                              replaceId = true;
                           }
                        }
                     } 
                     
                  } else {
                     
                     // If new version conforms, use it, otherwise string compare
                     
                     if (newVersion.matches(dottedDecimalRegex)) {
                        replaceId = true;
                     } else {
                        replaceId = currid.getVersion().compareTo(newid.getVersion()) > 0;
                     }
                     
                  }
               }
               
               if (replaceId) {
                  
                  if (isDebug) {
                     StringBuilder txt = new StringBuilder();
                     txt.append("Replacing page resource id.");
                     txt.append(" old: ").append(currid.toString());
                     txt.append(", new: ").append(newid.toString());
                     txt.append(", index: ").append(index);
                     txt.append(", total length: ").append(resultids.size());
                     txt.append("\n   Current version string: ").append(currVersion);
                     txt.append(", New version string: ").append(newVersion);
                     txt.append(", Current digits: ").append(Arrays.asList(currDecimals));
                     txt.append(", New digits: ").append(Arrays.asList(newDecimals));
                     LOG.debug(txt.toString());
                  }
                  
                  // replace the current item in the list with the new item, as it
                  // has a later version.
                  resultids.add(index, newid);
                  resultids.remove(index+1);
                  
               }
            }
         }
         
      }
      
      // generate the markup
      StringBuilder markup = new StringBuilder(128);
      for (PageResourceId resid : resultids) {
         markup.append(getMarkup(resid, contextPath)).append("\n");
      }
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("\nConsolidated page resource IDs:");
         for (PageResourceId id : resultids) {
            txt.append("\n").append(id.toString());
         }
         txt.append("\n\nResulting markup:\n").append(markup.toString());
         LOG.debug(txt.toString());
      }
      
      return (markup.length() == 0) ? null : markup.toString();
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
