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

package org.apache.pluto.driver.services.container;

import static javax.portlet.PortletRequest.ACTION_PHASE;
import static javax.portlet.PortletRequest.ACTION_SCOPE_ID;
import static javax.portlet.PortletRequest.EVENT_PHASE;
import static javax.portlet.PortletRequest.RENDER_PHASE;
import static javax.portlet.PortletRequest.RESOURCE_PHASE;
import static org.apache.pluto.driver.url.PortalURLParameter.PARAM_TYPE_RENDER;
import static org.apache.pluto.driver.url.PortalURLParameter.PARAM_TYPE_RESOURCE;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import javax.portlet.PortletSession;

import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletResponseContext;
import org.apache.pluto.driver.url.PortletParameterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides the functionality for the action scoped request attribute runtime option. The action scoped request
 * attributes are stored in a map in the portlet session.
 * 
 * @author Scott Nicklous
 */
public class ActionScopedRequestAttributeHandler {
   private static final Logger       LOG                = LoggerFactory.getLogger(ActionScopedRequestAttributeHandler.class);
   private static final boolean      isDebug            = LOG.isDebugEnabled();
   @SuppressWarnings("unused")
   private static final boolean      isTrace            = LOG.isTraceEnabled();

   // for checking the attribute names
   private static final List<String> disallowedPrefixes = new ArrayList<String>();
   private static final List<String> disallowedNames    = new ArrayList<String>();
   static {
      ResourceBundle configBundle = null;
      try {
         configBundle = ResourceBundle.getBundle("org.apache.pluto.driver.services.container.ActionScopedRequestAttributeHandler");
      } catch (Throwable t) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Exception getting configuration file: \n");
         StringWriter sw = new StringWriter();
         PrintWriter pw = new PrintWriter(sw);
         t.printStackTrace(pw);
         pw.flush();
         txt.append(sw.toString());
         LOG.warn(txt.toString());
      }

      if (configBundle != null) {
         String val = configBundle.getString("prefixes");
         if (val != null) {
            disallowedPrefixes.addAll(Arrays.asList(val.split(";")));
         }
         val = configBundle.getString("names");
         if (val != null) {
            disallowedNames.addAll(Arrays.asList(val.split(";")));
         }
      }

      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Bundle could be read: ").append(configBundle != null);
         txt.append(", disallowed prefixes: ").append(disallowedPrefixes.toString());
         txt.append(", disallowed names: ").append(disallowedNames.toString());
         LOG.debug(txt.toString());
      }
   }

   private static final String       ATTRIB_NAME        = "javax.portlet.asraSessionData";

   // for synchronization
   private static final Object       LOCK               = new Object();

   /**
    * This is the data structure that is actually stored in the session.
    */
   private static class SessionData implements Serializable {
      private static final long                serialVersionUID = 7680043718084556191L;

      public Map<Integer, Map<String, Object>> attribs          = new HashMap<Integer, Map<String, Object>>();
      public boolean                           rendered         = false;
      public final long                        id;

      public SessionData() {
         id = (new Random()).nextLong();
      }
   }

   // private fields

   private final PortletRequestContext   requestContext;
   private final PortletParameterFactory paramFactory;
   private final String                  phase;

   private String                        windowId;
   private boolean                       active       = false;
   private boolean                       settable     = false;
   private int                           numScopes    = -1;

   private SessionData                   sessionData  = null;
   private Map<String, Object>           activeMap    = null;

   private Integer                       currentIndex = null;

   /**
    * Constructor.
    */
   public ActionScopedRequestAttributeHandler(PortletRequestContext requestContext, PortletParameterFactory paramFactory, String phase) {
      this.paramFactory = paramFactory;
      this.requestContext = requestContext;
      this.phase = phase;
   }

   /**
    * Initialize when portletConfig is available.
    */
   public void init(PortletResponseContext responseContext) {
      this.windowId = requestContext.getPortletWindow().getId().getStringId();
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("requestContext null: ").append(requestContext == null);
         if (requestContext != null) {
            txt.append(", portletConfig null: ").append(requestContext.getPortletConfig() == null);
         }
         LOG.debug(txt.toString());
      }

      Map<String, String[]> options = requestContext.getPortletConfig().getContainerRuntimeOptions();
      String[] vals = null;
      if (options != null) {
         vals = options.get("javax.portlet.actionScopedRequestAttributes");
         if (vals != null && vals.length > 0 && Boolean.parseBoolean(vals[0]) == true) {

            if (vals.length == 1) {
               numScopes = 4;
            } else if (vals.length == 3 && vals[1].equalsIgnoreCase("numberOfCachedScopes") && vals[2].matches("\\d+")) {
               numScopes = Integer.parseInt(vals[2]);
            }
         }
      }

      active = (numScopes > 0);
      settable = active && (phase.equals(ACTION_PHASE) || phase.equals(EVENT_PHASE));

      if (!active && vals != null) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Bad actionScopedRequestAttributes runtime option. Values: ");
         txt.append(Arrays.toString(vals));
         LOG.warn(txt.toString());
      }
      
      String[] scopeId = null;

      if (active) {
         synchronized (LOCK) {

            PortletSession ps = requestContext.getPortletSession(true);
            if (active && ps != null) {
               sessionData = (SessionData) ps.getAttribute(ATTRIB_NAME);
               if (sessionData != null) {
                  currentIndex = getCurrentIndex();
                  if (phase.equals(RENDER_PHASE)) {
                     sessionData.rendered = true;
                  }
               }
            }

            if (sessionData != null) {
               if (currentIndex == null) {

                  // If session data exists, but the index is null, it means that the portlet window
                  // was accessed with a URL that does not contain a scope ID that matches any of the
                  // currently stored scopes. In this case, delete the stale stored session data.

                  sessionData = null;
                  activeMap = null;
                  ps.removeAttribute(ATTRIB_NAME);

               } else {
                  // session data is available and there is a current index
                  activeMap = sessionData.attribs.get(currentIndex);
               }
            }

            // now handle the case where a new scope needs to be created

            if (phase.equals(ACTION_PHASE) || (phase.equals(EVENT_PHASE) && sessionData == null) || (phase.equals(EVENT_PHASE) && sessionData.rendered)) {

               if (sessionData == null) {

                  // create new data structures & scope

                  sessionData = new SessionData();
                  currentIndex = 0;

                  sessionData.attribs.put(currentIndex, new ConcurrentHashMap<String, Object>());
                  sessionData.rendered = false;
                  activeMap = sessionData.attribs.get(currentIndex);
                  ps.setAttribute(ATTRIB_NAME, sessionData);

               } else {

                  // Create a new scope. Make sure the current scope is the top one, then increment.
                  // If, after the increment, the number of scopes is too big, delete the bottom one.

                  List<Integer> activeScopes = new ArrayList<Integer>(sessionData.attribs.keySet());
                  Collections.sort(activeScopes);

                  int index = activeScopes.indexOf(currentIndex);
                  for (int ii = index + 1; ii < activeScopes.size(); ii++) {
                     sessionData.attribs.remove(activeScopes.get(ii));
                  }

                  currentIndex++;
                  sessionData.attribs.put(currentIndex, new ConcurrentHashMap<String, Object>());
                  sessionData.rendered = false;

                  activeMap = sessionData.attribs.get(currentIndex);

                  if (sessionData.attribs.size() > numScopes) {
                     sessionData.attribs.remove(activeScopes.get(0));
                  }
               }
            }
         }

         // now we have a scope if we need one, so handle the scope id parameter

         if (sessionData != null) {
            scopeId = new String[] { Long.toString(sessionData.id), currentIndex.toString() };
         }

         // Set the parameter on the response
         responseContext.setActionScopedId(windowId, scopeId);
      }

      // and finally output some debugging stuff

      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("isActive: ").append(active);
         txt.append(", isSettable: ").append(settable);
         txt.append(", phase: ").append(phase);
         txt.append(", rendered: ").append((sessionData == null) ? "n/a" : sessionData.rendered);
         txt.append(", session data: ").append((sessionData != null) ? "not null" : "null");
         txt.append(", scope id: ").append((scopeId == null) ? "null" : Arrays.toString(scopeId));
         txt.append(", current index: ").append(currentIndex);
         txt.append(", option values: ").append((vals == null) ? "null" : Arrays.toString(vals));
         LOG.debug(txt.toString());
      }

   }

   // private methods

   /**
    * Gets the current index from the render parameter.
    * 
    * @return the current index
    */
   private Integer getCurrentIndex() {
      Long id = null;
      Integer index = null;
      String type = PARAM_TYPE_RENDER;
      if (phase.equals(RESOURCE_PHASE)) {
         type = PARAM_TYPE_RESOURCE;
      }
      Map<String, String[]> params = paramFactory.getParameterMap(windowId, type);
      String[] asvals = params.get(ACTION_SCOPE_ID);
      if (sessionData != null && asvals != null && asvals.length == 2) {
         try {
            id = new Long(asvals[0]);
            index = new Integer(asvals[1]);
            if (id != sessionData.id || !sessionData.attribs.containsKey(index)) {
               index = null;
            }
         } catch (Exception e) {
         }
      }

      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("isActive: ").append(active);
         txt.append(", session data exists: ").append(sessionData != null);
         txt.append(", request id: ").append(id);
         txt.append(", scope id: ").append((sessionData == null) ? "null" : sessionData.id);
         txt.append(", index: ").append(index);
         txt.append(", action scope param values: ").append((asvals == null) ? "null" : Arrays.toString(asvals));
         LOG.debug(txt.toString());
      }

      return index;
   }

   /**
    * Returns <code>true</code> if the given name can be stored as an action scopes request attribute.
    * 
    * @param name
    *           the name
    * @return <code>true</code> if attribute by this name can be stored.
    */
   private boolean isNameOk(String name) {
      boolean isOk = true;
      for (String prefix : disallowedPrefixes) {
         if (name.startsWith(prefix)) {
            isOk = false;
            break;
         }
      }
      if (disallowedNames.contains(name)) {
         isOk = false;
      }
      return isOk;
   }

   // public methods

   /**
    * @return the active
    */
   public boolean isActive() {
      return active;
   }

   /**
    * @return the settable
    */
   public boolean isSettable() {
      return settable;
   }

   /**
    * Gets the attribute from the current attribute map for the given name.
    * 
    * @param name
    *           the attribute name
    * @return the attribute value
    */
   public Object getAttribute(String name) {
      Object value = null;
      if (active && name != null && activeMap != null) {
         value = activeMap.get(name);
      }

      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Name: ").append(name);
         txt.append(", value is null: ").append(value == null);
         txt.append(", index: ").append(currentIndex);
         txt.append(", active: ").append(active);
         txt.append(", active map is null: ").append(activeMap == null);
         LOG.debug(txt.toString());
      }

      return value;
   }

   /**
    * Removes the given attribute
    * 
    * @param name
    *           the attribute name
    */
   public void removeAttribute(String name) {
      if (active && activeMap != null) {
         activeMap.remove(name);
      }

      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Name: ").append(name);
         txt.append(", index: ").append(currentIndex);
         txt.append(", active: ").append(active);
         txt.append(", active map is null: ").append(activeMap == null);
         LOG.debug(txt.toString());
      }

   }

   /**
    * Returns the attribute names stored in the scope.
    * 
    * @return the list of attribute names
    */
   public List<String> getAttributeNames() {
      List<String> names = new ArrayList<String>();

      if (active && activeMap != null) {
         names.addAll(activeMap.keySet());
      }

      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Attribute names: ").append(names.toString());
         txt.append(", index: ").append(currentIndex);
         txt.append(", active: ").append(active);
         txt.append(", active map is null: ").append(activeMap == null);
         LOG.debug(txt.toString());
      }

      return names;
   }

   /**
    * Sets an action scoped attribute if possible. Returns <code>true</code> if the attribute was set, and
    * <code>false</code> otherwise.
    * 
    * @param name
    *           the attribute name
    * @param value
    *           the attribute value
    * @return <code>true</code> if the attribute was successfully stored
    */
   public boolean setAttribute(String name, Object value) {
      boolean attribSet = false;
      if (settable && isNameOk(name)) {
         if (activeMap != null) {
            activeMap.put(name, value);
            attribSet = true;
         }
      }

      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Attribute name: ").append(name);
         txt.append(", value is null: ").append(value == null);
         txt.append(", attribSet: ").append(attribSet);
         txt.append(", index: ").append(currentIndex);
         txt.append(", settable: ").append(settable);
         txt.append(", active map is null: ").append(activeMap == null);
         LOG.debug(txt.toString());
      }

      return attribSet;
   }
}
