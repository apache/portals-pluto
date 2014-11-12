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

/**
 * @fileOverview
 * This module provides mock data & functions for the mock portlet hub.
 * <p>
 * The functions encapsulate all mockup-specific implementation details.
 * The intention is that support for a different portal can added by 
 * reimplementing these functions.
 * <p>
 * To implement the portlet hub for your portal, implement the methods 
 * described under "portlet.impl".
 * In order to make the Jasmine tests work with your implementation, the
 * test functions will need to be modified appropiately as well.
 * <p>
 * Sets up data that is used by the Jasmine unit tests as well as by the 
 * portlet hub implementation. In particular, the Jasmine tests need initialization
 * data for the portlets on the page. The portlet hub requires this
 * data as well, so it is being provided through the global name space to be used both
 * by the hub and by the test code.
 * <p> 
 * Later, it should hopefully be possible to use the Jasmine tests with a "live" 
 * portlet hub implementation by making the portlet info on the page 
 * available to Jasmine through this mechanism.
 * <p>
 * A "real" portlet hub implementation would likely obtain this information in a 
 * different manner.
 * 
 * @author Scott Nicklous
 * @copyright IBM Corp., 2014
 */
var portlet = portlet || {};

(function () {
   'use strict';

   var isInitialized = false,

   /**
    * The object holding the portlet data for each portlet on the page.
    * This an object indexed by portlet ID.
    * @property   {PortletData} {string}  
    *    The object holds one portlet data object for each portlet. The string
    *    property name is the portlet ID.
    * @private
    */
   pageState,
   
   
   /**
    * Determines if the specified portlet ID is present.
    * @param   {string}    pid      The portlet ID
    * @returns {boolean}            true if the portlet ID can be found
    * @function
    * @private
    */
   isValidId = function (pid) {
      var id;
      for (id in pageState) {
         if (!pageState.hasOwnProperty(id)) {
            continue;
         }
         if (pid === id) {
            return true;
         }
      }
      return false;
   },

   /**
    * get the available portlet IDs in an array 
    */
   getIds = function () {
      var id, ids = [];
      for (id in pageState) {
         if (pageState.hasOwnProperty(id)) {
            ids.push(id);
         }
      }
      return ids;
   },
      
   /**
    * gets parameter value
    */
   getParmVal = function (pid, name) {
      return pageState[pid].state.parameters[name];
   },
   
   /**
    * gets parameter value
    */
   setParmVal = function (pid, name, val) {
      if (val === undefined) {
         delete pageState[pid].state.parameters[name];
      } else {
         pageState[pid].state.parameters[name] = val.slice(0);
      }
   },

   /**
    * Compares the values of two parameters and returns true if they are equal
    *
    * @param {string[]} parm1 First parameter
    * @param {string[]} parm2 2nd parameter
    * @returns {boolean} true if the new parm value is equal to the current value
    * @private
    */
   _isParmEqual = function(parm1, parm2) {
      var ii;

      // The values are either string arrays or undefined.

      if ((parm1 === undefined) && (parm2 === undefined)) {
         return true;
      }
      
      if ((parm1 === undefined) || (parm2 === undefined)) {
         return false;
      }
      
      if (parm1.length !== parm2.length) {
         return false;
      }
      
      
      for (ii = parm1.length - 1; ii >= 0; ii--) {
         if (parm1[ii] !== parm2[ii]) {
            return false;
         }
      }

      return true;
   },

   /**
    * Compares the values of the named parameter in the new portlet state
    * with the values of that parameter in the current state.
    *
    * @param      {string}       pid      The portlet ID
    * @param      {PortletState} state    The new portlet state
    * @param      {string}       name     The parameter name to check
    * @returns    {boolean}               true if the new parm value is different
    *                                     from the current value
    * @private
    */
   isParmInStateEqual = function (pid, state, name) {
      var newVal = state.parameters[name], oldVal = getParmVal(pid, name);

      return _isParmEqual(newVal, oldVal);
   },
      
   /**
    * gets defeined PRPs for the portlet
    */
   getPRPNames = function (pid) {
      return pageState[pid].pubParms;
   },
   
   /**
    * function for checking if the parameter is private
    */
   isPRP = function (pid, name) {
      var ii, result = false;
      for (ii = 0; ii < pageState[pid].pubParms.length; ii++) {
         if (name === pageState[pid].pubParms[ii]) {
            result = true;
         }
      }
      return result;
   },


   /**
    * Gets the updated public parameters for the given portlet
    * ID and new portlet state.
    * Returns an object whose properties are the names of the
    * updated public parameters. The values are the new public
    * parameter values.
    *
    * @param      {string}       pid      The portlet ID
    * @param      {PortletState} state    The new portlet state
    * @returns    {object}                object containing the updated PRPs
    * @private
    */
   getUpdatedPRPs = function (pid, state) {
      var prps = {}, ii = 0, prpNames = getPRPNames(pid), name;

      for (ii = 0; ii < prpNames.length; ii++) {
         name = prpNames[ii];
         if (isParmInStateEqual(pid, state, name) === false) {
            prps[name] = state.parameters[name];
         }
      }

      return prps;
   },

      
   /**
    * Returns a deep-copy clone of the input portlet state object.
    * Used to provide the portlet client with a copy of the current 
    * state data rather than a reference to the live state itself.
    * 
    * @param      {PortletState} state    The portlet state object to check
    * @returns    {PortletState}          Clone of the input portlet state
    * @private
    */
   cloneState = function (aState) {
      var newParams = {},
      newState = {
            portletMode : aState.portletMode,
            windowState : aState.windowState,
            parameters : newParams
      }, key, oldParams = aState.parameters;
   
      for (key in oldParams) {
         newParams[key] = oldParams[key].slice(0); 
      }
   
      return newState;
   },

   /**
    * Get allowed window states for portlet
    */
   getAllowedWS = function (pid) {
      return pageState[pid].allowedWS.slice(0);
   },
   
   /**
    * Get allowed portlet modes for portlet
    */
   getAllowedPM = function (pid) {
      return pageState[pid].allowedPM.slice(0);
   },
   
   
   /**
    * gets render data for the portlet
    */
   getRenderData = function (pid) {
      return pageState[pid].renderData;
   },
         
   /**
    * gets state for the portlet
    */
   getState = function (pid) {
      return pageState[pid].state;
   },
   
   /**
    * sets state for the portlet. returns
    * array of IDs for portlets that were affected by the change, 
    * taking into account the public render parameters.
    */
   setState = function (pid, state) {
      var pids, prps = getUpdatedPRPs(pid, state), prp, ii, tpid, upids = [], newVal, oldVal, prpNames;
         
      // For each updated PRP for the
      // initiating portlet, update that PRP in the other portlets.
      for (prp in prps) {
         if (prps.hasOwnProperty(prp)) {
      
            newVal = prps[prp];
            
            // process each portlet ID
            pids = getIds();
            for (ii = 0; ii < pids.length; ii++) {
               tpid = pids[ii];
               
               // don't update for initiating portlet. that's done after the loop
               if (tpid !== pid) {
            
                  oldVal = getParmVal(tpid, prp);
                  prpNames = getPRPNames(tpid);
                  
                  // check for public parameter and if the value has changed
                  if ((prpNames.indexOf(prp) >= 0) && 
                      (_isParmEqual(oldVal, newVal) === false)) {
                  
                     if (newVal === undefined) {
                        delete pageState[tpid].state.parameters[prp];
                     } else {
                        pageState[tpid].state.parameters[prp] = newVal.slice(0);
                     }
                     upids.push(tpid);
                     
                  }
               }
            }
         }
      }
      
      // update state for the initiating portlet
      pageState[pid].state = state;
      upids.push(pid);

      
      // Use Promise to allow for potential server communication - 
      return new Promise(function (resolve, reject) {
         var simval = '';
         if (pid === 'SimulateCommError' && state.parameters.SimulateError !== undefined) {
            simval = state.parameters.SimulateError[0];
         }

         // reject promise of an error is to be simulated
         if (simval === 'reject') {
            reject(new Error("Simulated error occurred when setting state!"));
         } else {
            resolve(upids);
         }
      });
   },

      
   /**
    * updates page state from string and returns array of portlet IDs
    * to be updated.
    * 
    * @param   {string}    ustr     The 
    * @param   {string}    pid      The portlet ID
    * @private 
    */
   updatePageStateFromString = function (ustr, pid) {
      var states, tpid, state, upids = [];

      states = decodeUpdateString(ustr, pid);

      // Update states and collect IDs of affected portlets. 
      for (tpid in states) {
         if (states.hasOwnProperty(tpid)) {
            state = states[tpid];
            pageState[tpid].state = state;
            upids.push(tpid);
         }
      }

      return upids;
   },

      
   /**
    * performs the actual action.
    * 
    * @param   {string}    type     The URL type
    * @param   {string}    pid      The portlet ID
    * @param   {PortletParameters}    parms      
    *                Additional parameters. May be <code>null</code>
    * @param   {HTMLFormElement}    Form to be submitted
    *                               May be <code>null</code> 
    * @private 
    */
   executeAction = function (pid, parms, element) {
      var states, ustr, tpid, state, upids = [];
   
      // pretend to create a url, etc. ... for the mockup
      // we don't need the parms or element
   
      // get the mockup data update string and make it into an object.
      // update each affected portlet client. Makes use of a 
      // test function for decoding. 
      
      ustr = portlet.test.data.updateStrings[pid];
      upids = updatePageStateFromString(ustr, pid);
      
      // Use Promise to allow for potential server communication - 
      return new Promise(function (resolve, reject) {
         var simval = '';
         if (pid === 'SimulateCommError' && (parms)) {
            simval = parms.SimulateError;
            if (simval) {
               simval = simval[0];
            }
         }
            
         // reject promise of an error is to be simulated
         if (simval === 'reject') {
            reject(new Error("Simulated error occurred during action!"));
         } else {
            resolve(upids);
         }
      });

   },
   
   /**
    * Function to encode url tokens as Pluto likes it
    */
   plutoEncode = function (istr) {
      var ENCODINGS = {
            "_" :  "0x1",
            "." :  "0x2",
            "/" :  "0x3",
            "\r" : "0x4",
            "\n" : "0x5",
            "<" :  "0x6",
            ">" :  "0x7",
            " " :  "0x8",
            "#" :  "0x9",
            "?" :  "0xa",
            "\\" : "0xb",
            "%" :  "0xc",
            "|" :  "%7C"
                      }, ii, ostr = "";
      
      for (ii=0; ii < istr.length; ii++) {
         if (ENCODINGS[istr.charAt(ii)]) {
            ostr += ENCODINGS[istr.charAt(ii)];
         } else {
            ostr += istr.charAt(ii);
         }
      }

      return ostr;
   },
   
   
   // Constants used for URL Encoding/Decoding (copied from Pluto impl code)  ----------

   PREFIX = "__",
   DELIM = "_",
   PORTLET_ID = "pd",
   ACTION = "ac",
   RESOURCE = "rs",
   RESOURCE_ID = "ri",
   CACHE_LEVEL = "cl",
   RENDER_PARAM = "rp",
   PRIVATE_RENDER_PARAM = "pr",
   PUBLIC_RENDER_PARAM = "sp",
   WINDOW_STATE = "ws",
   PORTLET_MODE = "pm",
   VALUE_DELIM = "0x0",

   AJAX_ACTION = "aa",              // new for portlet spec 3
   PARTIAL_ACTION = "pa",           // new for portlet spec 3

   
   /**
    * Helper for generating parameter strings for the URL
    */
   genParmString = function (pid, name, type) {
      var vals, jj, sep, str = "", wid = "";
      vals = pageState[pid].state.parameters[name];
      
      // If encoding a render parameter, insert the pid in Pluto internal form 
      // as opposed to namespace form -
      
      if (type === RENDER_PARAM) {
         wid = plutoEncode(pageState[pid].urlpid)
      }
      
      // If values are present, encode the multivalued parameter string
      
      if (vals) {
         sep = "";
         str += "/" + PREFIX + type + wid + DELIM + encodeURIComponent(name) + "/";
         for (jj=0; jj < vals.length; jj++) {
            str += sep + encodeURIComponent(vals[jj]);
            sep = VALUE_DELIM;
         }
      }
      return str;
   },
   
   
   /**
    * Helper for generating portlet mode & window state strings for the URL
    */
   genPMWSString = function (pid) {
      var pm = pageState[pid].state.portletMode, 
          ws = pageState[pid].state.windowState, 
          wid = plutoEncode(pageState[pid].urlpid), str = "";

      str += "/" + PREFIX + PORTLET_MODE + wid + DELIM + encodeURIComponent(pm);
      str += "/" + PREFIX + WINDOW_STATE + wid + DELIM + encodeURIComponent(ws);

      return str;
   },
   
   
   /**
    * Returns a URL of the specified type.
    * 
    * @param   {string}    type     The URL type
    * @param   {string}    pid      The portlet ID
    * @param   {PortletParameters}    parms      
    *                Additional parameters. May be <code>null</code>
    * @param   {string}    cache    Cacheability. Must be present if 
    *                type = "RESOURCE". May be <code>null</code> 
    * @private 
    */
   getUrl = function (type, pid, parms, cache) {
   
      var url = portlet.impl.getUrlBase(), ca = 'cacheLevelPage', parm, 
          sep = "", name, names, val, vals, ii, jj, str, id, ids;

      // First add the appropriate window identifier according to URL type.
      // Note that no special window ID is added to a RENDER URL. 
      
      if (type === "RESOURCE") {
         // If generating resource URL, add resource window & cacheability
         url += "/" + PREFIX + RESOURCE + plutoEncode(pageState[pid].urlpid);
         if (cache) {
            ca = cache;
         }
         url += "/" + PREFIX + CACHE_LEVEL + plutoEncode(ca);
      } else if (type === "ACTION") {
         // Add Ajax Action window
         url += "/" + PREFIX + AJAX_ACTION + plutoEncode(pageState[pid].urlpid);
      } else if (type === "PARTIAL_ACTION") {
         // Add Partial Action window
         url += "/" + PREFIX + PARTIAL_ACTION + plutoEncode(pageState[pid].urlpid);
      }
      
      // Now add the state to the URL, taking into account cacheability if
      // we're dealing with a resource URL. 

      // Put the private & public parameters on the URL if cacheability != FULL
      if ((type !== "RESOURCE") || (ca !== "cacheLevelFull")) {

         // If cacheability = PAGE, add the state for the non-target portlets
         if ((type !== "RESOURCE") || (ca === "cacheLevelPage")) {

            ids = getIds();
            for (ii = 0; ii < ids.length; ii++) {
               id = ids[ii];
               if (id !== pid) {  // only for non-target portlets
                  url += genPMWSString(id);  // portlet mode & window state
                  str = "";
                  names = pageState[id].state.parameters;
                  for (name in names) {
                     // Public render parameters are encoded separately
                     if (names.hasOwnProperty(name) && !isPRP(id, name)) {
                        str += genParmString(id, name, RENDER_PARAM);
                     }
                  }
                  url += str;
               }
            }

         }

         // add the state for the target portlet
         url += genPMWSString(pid);  // portlet mode & window state
         str = "";
         names = pageState[pid].state.parameters;
         for (name in names) {
            // Public render parameters are encoded separately
            if (names.hasOwnProperty(name) && !isPRP(pid, name)) {
               str += genParmString(pid, name, PRIVATE_RENDER_PARAM);
            }
         }
         url += str;

         // Add the public render parameters
         str = "";
         names = pageState[pid].pubParms;
         for (ii=0; ii < names.length; ii++) {
            name = names[ii];
            str += genParmString(pid, name, PUBLIC_RENDER_PARAM);
         }
         url += str;

      }

      // Encode resource or action parameters as query string
      if (parms) {
         str = "?"; sep = "";
         for (parm in parms) {
            if (parms.hasOwnProperty(parm)) {
               vals = parms[parm];
               for (ii=0; ii < vals.length; ii++) {
                  str += sep + encodeURIComponent(parm) + "=" + encodeURIComponent(vals[ii]);
                  sep = "&";
               }
            }
         }
         url += str;
      }

      // Use Promise to allow for potential server communication - 
      return new Promise(function (resolve, reject) {
         resolve(url);
      });
   },
   
   
   /**
    * Exception thrown when a portlet hub method is provided with an invalid argument.
    * @typedef    IllegalArgumentException 
    * @property   {string}    name     The exception name, equal to "IllegalArgumentException"
    * @property   {string}    message  An optional message that provides more detail about the exception
    */
   throwIllegalArgumentException = function (msg) {
      throw {
         name : "IllegalArgumentException",
         message : msg
      };
   },

   
   // decodes the update strings
   decodeUpdateString = function (ustr) {
      var states = {}, state, pid, ii, ind,
          pids = ustr.match(/~~&.*?&/g); // reluctant match
      
      // If there is no match, bad input data
      if (pids === null) {
         throwIllegalArgumentException("Invalid update string.");
      }
      
      // For each portlet being updated, get the new data
      ii = pids.length;
      while ((ii = ii -1) >= 0) {
         if (pids[ii].length < 5) {
            // the portlet ID must be at least 1 character long
            throwIllegalArgumentException("Invalid portlet ID in update string.");
         }
         
         // trim extra stuff off of the portlet id
         ind = pids[ii].length - 1;
         pid = pids[ii].substring(3, ind);
      
         state = portlet.test.action.getState(ustr, pid);
         states[pid] = state;
         
      }
      
      return states;
   };

   
   /**
    * Register a portlet. The impl is passed the portlet ID for the portlet.
    * The impl must retrieve the information for the portlet in an appropriate
    * manner. It must return a Promise that is fulfilled when data for the 
    * portlet becomes available and is rejected if an error occurs or if the
    * portlet ID is invalid.
    * 
    * @param   {string}    pid      Portlet ID
    * 
    * @returns {Promise}            fulfilled when data is available
    * 
    * @function
    * @private
    */
   portlet.impl = portlet.impl || {};
   portlet.impl.register = function (pid) {

      // take care of moc data initialization      
      if (!isInitialized) {
         pageState = portlet.impl.getInitData();
         isInitialized = true;
      }

      // stubs for accessing data for this portlet
      var stubs = {
   
			/**
			 * Get allowed window states for portlet
			 */
			getAllowedWS : function () {return getAllowedWS(pid);},
   
			/**
			 * Get allowed portlet modes for portlet
			 */
			getAllowedPM : function () {return getAllowedPM(pid);},
   
			/**
			 * Get render data for portlet, if any
			 */
			getRenderData : function () {return getRenderData(pid);},
   
			/**
			 * Get current portlet state
			 */
			getState : function () {return getState(pid);},
   
			/**
			 * Set new portlet state. Returns promise fullfilled with an array of
			 * IDs of portlets whose state have been modified.
			 */
			setState : function (state) {return setState(pid, state);},
   
			/**
			 * Perform the Ajax action request
			 */
			executeAction : function (parms, element, callback, onError) {return executeAction(pid, parms, element, callback, onError);},
   
			/**
			 * Get a URL of the specified type - resource or partial action
			 */
			getUrl : function (type, parms, cache) {return getUrl(type, pid, parms, cache);},
   
			/**
			 * Decode the update string returned by the partial action request.
			 * Returns array of IDs of portlets to be updated.
			 */
			decodeUpdateString : function (ustr) {return updatePageStateFromString(ustr, pid);},
   
      };            
      
      return new Promise(
         function(resolve, reject) {
            
            // verify the input pid 
            if (isValidId(pid)) {
               
               switch(pid) {
               case 'SimulateLongWait':
                  window.setTimeout(function () {resolve(stubs);}, 500);
                  break;
               case 'SimulateError':
                  window.setTimeout(function () {reject(new Error("Bad error happened!"));}, 100);
                  break;
               default:
                  window.setTimeout(function () {resolve(stubs);}, 10);
               }
               
            } else {
               reject(new Error("Invalid portlet ID: " + pid));
            }
         }
      );
   };
   
   // Expose some internal functions for test purposes - 
   
   portlet.test = {
      getIds : getIds
   }; 
   
})();
