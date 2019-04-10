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
 * This module provides the implementation for the Pluto portlet hub.
 * <p>
 * 
 * @author Scott Nicklous
 * @copyright IBM Corp., 2014
 */
var portlet = portlet || {};

(function () {
   'use strict';

   var isInitialized = false,

   /**
    * The object holding the portlet data for each portlet on the page along with
    * mapping information for public render paramters. 
    * The portlet data is indexed by portlet ID.
    * @property   {PortletData} {string}  
    *    The object holds one portlet data object for each portlet. The string
    *    property name is the portlet ID.
    * @property   {prpMap} {"<groupIndex>" : {"pid" : "<prpName>"}}  
    * @private
    */
   pageState = {},
   
   /**
    * Flag specifying whether history is to be processed (true if browser supports HTML5 session history APIs)
    * @property   {boolean} doHistory
    * @private
    */
    doHistory = (window.history && window.history.pushState),
   
   /**
    * Callback function provided to the portlet hub to allow the the implementation
    * to initiate an unsolicited render state update for an array of portlet IDs.
    * @param   {string[]}  pid      An array of portlet IDs
    * @returns {void}
    * @function
    * @private
    */
   updateWhenIdle,
   
   
   /**
    * Determines if the specified portlet ID is present.
    * @param   {string}    pid      The portlet ID
    * @returns {boolean}            true if the portlet ID can be found
    * @function
    * @private
    */
   isValidId = function (pid) {
      var id;
      for (id in pageState.portlets) {
         if (pageState.portlets.hasOwnProperty(id)) {
            if (pid === id) {
               return true;
            }
         }
      }
      return false;
   },

   /**
    * get the available portlet IDs in an array 
    */
   getIds = function () {
      var id, ids = [];
      for (id in pageState.portlets) {
         if (pageState.portlets.hasOwnProperty(id)) {
            ids.push(id);
         }
      }
      return ids;
   },
      
   /**
    * gets parameter value
    */
   getParmVal = function (pid, name) {
      return pageState.portlets[pid].state.parameters[name];
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
    * Returns true if input state differs from the current page state.
    * Throws exception if input state is malformed.
    */
   stateChanged = function (nstate, pid) {
      var ostate, pname, nparm, oparm, result = false;
      
      ostate = pageState.portlets[pid].state;
      
      if (!nstate.portletMode || !nstate.windowState || !nstate.parameters) {
         throw new Error ("Error decoding state: " + nstate);
      }
      
      if (nstate.portletMode !== ostate.portletMode) {
         result = true;
      } else {
         if (nstate.windowState !== ostate.windowState) {
            result = true;
         } else {
            
            // Has a parameter changed or been added?
            for (pname in nstate.parameters) {
               if (nstate.parameters.hasOwnProperty(pname)) {
                  nparm = nstate.parameters[pname];
                  oparm = ostate.parameters[pname];
                  if (!_isParmEqual(nparm, oparm)) {
                     result = true;
                  }
               }
            }
            
            // make sure no parameter was deleted
            for (pname in ostate.parameters) {
               if (ostate.parameters.hasOwnProperty(pname)) {
                  if (!nstate.parameters[pname]) {
                     result = true;
                  }
               }
            }
         }
      }
      
      return result;
   },

   /**
    * Compares the values of the named parameter in the new render state
    * with the values of that parameter in the current state.
    *
    * @param      {string}       pid      The portlet ID
    * @param      {RenderState} state    The new render state
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
      return pageState.portlets[pid].pubParms;
   },
   
   /**
    * function for checking if the parameter is public
    */
   isPRP = function (pid, name) {
      var prp, result = false, prps = pageState.portlets[pid].pubParms;
      for (prp in prps) {
         if (prps.hasOwnProperty(prp)) {
            if (name === prp) {
               result = true;
            }
         }
      }
      return result;
   },


   /**
    * Gets the updated public parameters for the given portlet
    * ID and new render state.
    * Returns an object whose properties are the gruop indexes of the
    * updated public parameters. The values are the new public
    * parameter values.
    *
    * @param      {string}       pid      The portlet ID
    * @param      {RenderState} state    The new render state
    * @returns    {object}                object containing the updated PRPs
    * @private
    */
   getUpdatedPRPs = function (pid, state) {
      var prps = {}, prpNames = getPRPNames(pid), name, group;

      for (name in prpNames) {
         if (prpNames.hasOwnProperty(name)) {
            if (isParmInStateEqual(pid, state, name) === false) {
               group = prpNames[name];
               prps[group] = state.parameters[name];
            }
         }
      }

      return prps;
   },

   /**
    * Get allowed window states for portlet
    */
   getAllowedWS = function (pid) {
      return pageState.portlets[pid].allowedWS.slice(0);
   },
   
   /**
    * Get allowed portlet modes for portlet
    */
   getAllowedPM = function (pid) {
      return pageState.portlets[pid].allowedPM.slice(0);
   },
   
   
   /**
    * gets render data for the portlet
    */
   getRenderData = function (pid) {
      return pageState.portlets[pid].renderData;
   },
         
   /**
    * gets state for the portlet
    */
   getState = function (pid) {
      return pageState.portlets[pid].state;
   },
   
   
   // Constants used for URL Encoding/Decoding (copied from Pluto impl code)  ----------
   
   PREFIX = "__",
   PORTLET_ID = "pd",
   RESOURCE_ID = "ri",
   CACHE_LEVEL = "cl",
   WINDOW_STATE = "ws",
   PORTLET_MODE = "pm",
   
   // The delimiter & special chars for the value encoding are chosen
   // from the URL reserved delimiter characters that ARE ENCODED by the URLEncoder
   // so that they will not appear encoded parameter names or values.
   // See RFC 3986 & URLEncoder documentation.
   VALUE_DELIM = ":",
   VALUE_NULL = ",",
   VALUE_ARRAY_EMPTY = "@",
   DELIM = ";",
   TOKEN_DELIM = "/",

   ACTION = "ac",
   RESOURCE = "rs",
   AJAX_ACTION = "aa",       // new for portlet spec 3
   PARTIAL_ACTION = "pa",    // new for portlet spec 3
   RENDER = "re",            // new for portlet spec 3
   
   ACTION_PARAM = "av",      // new for portlet spec 3
   RESOURCE_PARAM = "rv",    // new for portlet spec 3
   RENDER_PARAM = "rp",
   PUBLIC_RENDER_PARAM = "sp",
   
   
   // constants for checking if portlet mode & window state have default values
   VIEW = "VIEW",
   NORMAL = "NORMAL",

   
   pidMap = {},
   
   /**
    * Set up the portlet ID mapping table for URL generation
    */
   getPidMap = function () {
      var pid, pids = getIds(), ii, urlmap = "";
      
      pidMap = {};
      for (ii = 0; ii < pids.length; ii++) {
         pid = pids[ii];
         pidMap[pid] = ii;
         urlmap += TOKEN_DELIM + PREFIX + PORTLET_ID;
         urlmap += encodeURIComponent(pageState.portlets[pid].urlpid);
         urlmap += DELIM + ii;
      }
      
      return urlmap;
   },

   /**
    * Helper for encoding a multivalued parameter
    */
   encodeParameter = function (name, vals) {
	   var str = "", jj;
	   if (vals) {
		   str += encodeURIComponent(name);
		   if (vals.length === 0) {
			   str += VALUE_DELIM + VALUE_ARRAY_EMPTY;
		   } else {
			   for (jj=0; jj < vals.length; jj++) {
				   if (vals[jj] === null) {
					   str += VALUE_DELIM + VALUE_NULL;
				   } else {
					   str += VALUE_DELIM + encodeURIComponent(vals[jj]);
				   }
			   }
		   }
	   }
	   return str;
   },
   
   /**
    * Helper for generating parameter strings for the URL
    */
   genParmString = function (pid, name, type, group) {
      var vals, str = "", wid = "", grpstr = "";
      vals = pageState.portlets[pid].state.parameters[name];
      
      // if there are no values, return the empty string
      if (vals !== undefined) {

    	  // If encoding a render parameter, insert the pid in Pluto internal form 
    	  // as opposed to namespace form -

    	  if (type === RENDER_PARAM || type === PUBLIC_RENDER_PARAM
    			  || type === ACTION_PARAM || type === RESOURCE_PARAM) {
    		  wid = pidMap[pid];
    	  }

    	  if (type === PUBLIC_RENDER_PARAM) {
    		  grpstr = DELIM + encodeURIComponent(group);
    	  }

    	  // If values are present, encode the multivalued parameter string

    	  str += TOKEN_DELIM + PREFIX + type + wid + grpstr + DELIM + encodeParameter(name, vals);
      }
      return str;
   },
   
   
   /**
    * Helper for generating portlet mode & window state strings for the URL
    */
   genPMWSString = function (pid) {
      var pm = pageState.portlets[pid].state.portletMode, 
          ws = pageState.portlets[pid].state.windowState, 
          wid = pidMap[pid], str = "";

      // Only add PM & WS if the values are not default
      if (pm.toUpperCase() !== VIEW) {
    	  str += TOKEN_DELIM + PREFIX + PORTLET_MODE + wid + DELIM + encodeURIComponent(pm);
      }
      if (ws.toUpperCase() !== NORMAL) {
    	  str += TOKEN_DELIM + PREFIX + WINDOW_STATE + wid + DELIM + encodeURIComponent(ws);
      }

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
    * @param   {string}    resid    Resource ID. May be present if 
    *                type = "RESOURCE". May be <code>null</code> 
    * @private 
    */
   getUrl = function (type, pid, parms, cache, resid) {
   
      var url = portlet.impl.getUrlBase(), ca = 'cacheLevelPage', parm, isAction = false,
          name, names, ii, str, id, ids, tpid, prpstrings, group, ptype;
          
      url += getPidMap();
       
      // If target portlet not defined for render URL, set it to null
      if ((type === "RENDER") && pid === undefined) {
         pid = null;
      }

      // First add the appropriate window identifier according to URL type.
      // Note that no special window ID is added to a RENDER URL. 
      
      if (type === "RESOURCE") {
         // If generating resource URL, add resource window & cacheability
         url += TOKEN_DELIM + PREFIX + RESOURCE + pidMap[pid];
         if (cache) {
            ca = cache;
         }
         url += TOKEN_DELIM + PREFIX + CACHE_LEVEL + encodeURIComponent(ca);
         if (resid) {
        	 url += TOKEN_DELIM + PREFIX + RESOURCE_ID + encodeURIComponent(resid);
         }
      } else if (type === "RENDER" && pid !== null) {
         // Add Render window
         url += TOKEN_DELIM + PREFIX + RENDER + pidMap[pid];
      } else if (type === "ACTION") {
          // Add Ajax Action window
          isAction = true;
          url += TOKEN_DELIM + PREFIX + AJAX_ACTION + pidMap[pid];
      } else if (type === "PARTIAL_ACTION") {
         // Add Partial Action window
         isAction = true;
         url += TOKEN_DELIM + PREFIX + PARTIAL_ACTION + pidMap[pid];
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
                  names = pageState.portlets[id].state.parameters;
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

         // add the state for the target portlet, if there is one.
         // (for a render URL, pid can be null, and the state will have
         // been added previously)
         if (pid !== null) {
            url += genPMWSString(pid);  // portlet mode & window state
            str = "";
            names = pageState.portlets[pid].state.parameters;
            for (name in names) {
               // Public render parameters are encoded separately
               if (names.hasOwnProperty(name) && !isPRP(pid, name)) {
                  str += genParmString(pid, name, RENDER_PARAM);
               }
            }
            url += str;
         }

         // Add the public render parameters for all portlets

         str = "";
         prpstrings = {};
         for (group in pageState.prpMap) {
            if (pageState.prpMap.hasOwnProperty(group)) {
               for (tpid in pageState.prpMap[group]) {
                  if (pageState.prpMap[group].hasOwnProperty(tpid)) {
                     name = pageState.prpMap[group][tpid];
                     // only need to add parameter once, since it is shared
                     if (!prpstrings.hasOwnProperty(group)) {
                        prpstrings[group] = genParmString(tpid, name, PUBLIC_RENDER_PARAM, group);
                        str += prpstrings[group];
                     }
                  }
               }
            }
         }
         url += str;

      }

      // Encode resource or action parameters
      if (parms) {
    	  str = "";
    	  ptype = isAction ? ACTION_PARAM : RESOURCE_PARAM;
    	  for (parm in parms) {
    		  if (parms.hasOwnProperty(parm)) {
    	          str += TOKEN_DELIM + PREFIX + ptype + pidMap[pid] + DELIM;
    			  str += encodeParameter(parm, parms[parm]);
    		  }
    	  }
    	  url += str;
      }

      if (isAction) {
          url += TOKEN_DELIM + PREFIX + ptype + pidMap[pid] + DELIM;
          url += portlet.impl.getCsrfParameterName() + VALUE_DELIM + portlet.impl.getCsrfParameterValue();
      }

      // Use Promise to allow for potential server communication - 
      return new Promise(function (resolve) {
         resolve(url);
      });
   },
   
   /**
    * Called when the page state has been updated to allow the
    * browser history to be taken care of.
    * @param      {boolean} replace    replace the state rather than pushing
    */
   updateHistory = function (replace) {
      if (doHistory) {
         getUrl('RENDER', null, {}).then(function (url) {
            var token = JSON.stringify(pageState);
            console.log("Updating history. URL =" + url + ", token length =" + token.length 
               + ", token 30 chars =" + token.substring(0,30));
            if (replace) {
               history.replaceState(token, "");
            } else {
               history.pushState(token, "", url);
            }
         });
      }
   },
   
   /**
    * sets state for the portlet. returns
    * array of IDs for portlets that were affected by the change, 
    * taking into account the public render parameters.
    */
   setState = function (pid, state) {
      var prps = getUpdatedPRPs(pid, state), group, tpid, upids = [], ii, newVal, prpName, groupMap;
         
      // For each updated PRP group for the
      // initiating portlet, update that PRP in the other portlets.
      for (group in prps) {
         if (prps.hasOwnProperty(group)) {
      
            newVal = prps[group];
            
            // access the PRP map to get the affected portlets
            groupMap = pageState.prpMap[group];
            for (tpid in groupMap) {
               if (groupMap.hasOwnProperty(tpid) && (tpid !== pid)) {
                  prpName = groupMap[tpid];
                  
                  if (newVal === undefined) {
                     delete pageState.portlets[tpid].state.parameters[prpName];
                  } else {
                     pageState.portlets[tpid].state.parameters[prpName] = newVal.slice(0);
                  }
                  upids.push(tpid);
                  
               }
            }
         }
      }
      
      // update state for the initiating portlet
      pageState.portlets[pid].state = state;
      upids.push(pid);
      
      // delete render data for all affected portlets in order to avoid dispatching
      // stale render data
      for (ii = 0; ii < upids.length; ii++) {
         tpid = upids[ii];
         pageState.portlets[tpid].renderData.content = null;
      }
      
      // update history for back-button support
      updateHistory();

      
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

   
   // decodes the update strings. The update string is 
   // a JSON object containing the entire page state. This decoder 
   // returns an object containing the portlet data for portlets whose 
   // state has changed as compared to the current page state.
   decodeUpdateString = function (ustr) {
      var portlets = {}, ostate, nstate, pid, ps, npids = 0, cpids = 0;
      
      console.log("Decoding string: >>" + ustr + "<<");

      ps = JSON.parse(ustr);
      for (pid in ps.portlets) {
         if (ps.portlets.hasOwnProperty(pid)) {
            npids++;
            nstate = ps.portlets[pid].state;
            ostate = pageState.portlets[pid].state;
            
            if (!nstate || !ostate) {
               throw new Error ("Invalid update string. ostate=" + ostate + ", nstate=" + nstate);
            }
            
            if (stateChanged(nstate, pid)) {
               portlets[pid] = ps.portlets[pid];
               cpids++;
            }
         }
      }
      
      console.log("decoded state for " + npids + " portlets. # changed = " + cpids);
      
      return portlets;
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
      var portlets, tpid, portlet, upids = [], stateUpdated = false;

      portlets = decodeUpdateString(ustr);

      // Update portlets and collect IDs of affected portlets. 
      for (tpid in portlets) {
         if (portlets.hasOwnProperty(tpid)) {
            portlet = portlets[tpid];
            pageState.portlets[tpid] = portlet;
            upids.push(tpid);
            stateUpdated = true;
         }
      }
      
      // pid will be null or undefined when called from onpopstate routine.
      // In that case, don't update history.
      if (stateUpdated && pid) {
         updateHistory();
      }

      return upids;
   },
   
   
   /**
    * Update page state passed in after partial action. The list of 
    * ID's of updated portlets is passed back through a promise in order
    * to decouple the layers.
    * 
    * @param   {string}    ustr     The 
    * @param   {string}    pid      The portlet ID
    * @private 
    */
   updatePageState = function (ustr, pid) {
            
      // Use Promise to allow for potential server communication - 
      return new Promise(function (resolve, reject) {
         var upids;
               
         try {
            upids = updatePageStateFromString(ustr, pid);
            resolve(upids);
         } catch (e) {
            reject(new Error("Partial Action Action decode status: " + e.message));
         }
      });

   },
   
   /**
    * function to extract data from form and encode it as an 'application/x-www-form-urlencoded' string
    * 
    * @param   {HTMLFormElement}  form    Form to be submitted
    * @private 
    */
   encodeFormAsString = function (form) {
      var fstr = "", parm, parms = [], ii, jj, el, name, val, tag, type;
      for (ii = 0; ii < form.elements.length; ii++) {
         el = form.elements[ii];
         name = el.name;
         val = el.value;
         tag = el.nodeName.toUpperCase();
         if (tag === 'INPUT') {
            type = el.type.toUpperCase();
         } else {
            type = "";
         }
         // we don't support file type with enctype = 'application/x-www-form-urlencoded' (hub checks for this case)
         if (name && !el.disabled && (type !== 'FILE')) {
            if ((tag === 'SELECT') && (el.multiple === true)) {
               // multiple select boxes need to be handled differently
               for (jj = 0; jj < el.options.length; jj++) {
                  if (el.options[jj].checked) {
                     val = el.options[jj].value;
                     parm = encodeURIComponent(name) + '=' + encodeURIComponent(val);
                     parms.push(parm);
                  }
               }
            } else {
               if (((type !== 'CHECKBOX') && (type !== 'RADIO')) || (el.checked === true)) {
                  parm = encodeURIComponent(name) + '=' + encodeURIComponent(val);
                  parms.push(parm);
               }
            }
         }
      }
      fstr = parms.join('&');
      return fstr;
   },

      
   /**
    * performs the actual action.
    * 
    * @param   {string}    pid      The portlet ID
    * @param   {PortletParameters}    parms      
    *                Additional parameters. May be <code>null</code>
    * @param   {HTMLFormElement}    Form to be submitted
    *                               May be <code>null</code> 
    * @private 
    */
   executeAction = function (pid, parms, element) {

      console.log("impl: executing action. parms=" + parms + ", element=" + element);

      // create & return promise to caller. 

      return new Promise(function (resolve, reject) {

         // get the ajax action URL. The Pluto impl creates the URL in JS
         // therefore no error handling 
         getUrl("ACTION", pid, parms).then(function (url) {
            var xhr, upids, fd, method = 'POST', enctype, fstr;

            console.log("ajax action URL: " + url);
            
            xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
               if (xhr.readyState === 4) {
                  if (xhr.status === 200) {
                     try {
                        upids = updatePageStateFromString(xhr.responseText, pid);
                        resolve(upids);
                     } catch (e) {
                        reject(new Error("Ajax Action decode status: " + e.message));
                     }
                  } else {
                     reject(new Error("Ajax Action xhr status: " + xhr.statusText));
                  }
               }
            };
            
            if (element) {
               enctype = element.enctype;
               if (enctype === 'multipart\/form-data') {
                  // multipart/form-data is always POSTed using FormData 
                  fd = new FormData(element);
                  console.log("ajax action: POST using FormData object: " + fd);
                  xhr.open(method, url, true);
                  xhr.send(fd);
               } else {
                  // has to be 'application\/x-www-form-urlencoded', as the hub does not support text/plain
                  method = element.method ? element.method.toUpperCase() : 'GET';      // may be GET or POST; GET is default
                  fstr = encodeFormAsString(element);
                  console.log("ajax action: " + method + " using urlencoded form data: " + fstr);
                  if (method === 'GET') {   
                     // send form data as part of URL
                     if (url.indexOf('?') >= 0) {
                        url += '&' + fstr;
                     } else {
                        url += '?' + fstr;
                     }
                     xhr.open(method, url, true);
                     xhr.send();
                  } else {
                     // has to be post, since we only support GET & POST
                     xhr.open(method, url, true);
                     xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
                     xhr.setRequestHeader('Content-Length', fstr.length);
                     xhr.send(fstr);
                  }
               }
            } else {
               xhr.open(method, url, true);
               console.log("ajax action: POST using URL with parameters");
               xhr.send();
            }
         });
            
      });

   };
   
   /**
    * Handler for history event that is fired when the back button is pressed.
    */
   if (doHistory) {
      window.addEventListener('popstate', function (ev) {
         if (ev.state) {
            console.log("onpopstate fired. State = " + ev.state.substr(0, 30) + " ...<more>");
            updateWhenIdle().then(function (doUpdate) {
               var upids = updatePageStateFromString(ev.state);
               doUpdate(upids);
            });
         }
      });
   }

   
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
   portlet.impl.register = function (pid, updateFunction) {

      // take care of moc data initialization      
      if (!isInitialized) {
         pageState = portlet.impl.getInitData();
         updateHistory(true);
         isInitialized = true;
      }
      
      updateWhenIdle = updateFunction;

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
          * Get current render state
          */
         getState : function () {return getState(pid);},
   
         /**
          * Set new render state. Returns promise fullfilled with an array of
          * IDs of portlets whose state have been modified.
          */
         setState : function (state) {return setState(pid, state);},
   
         /**
          * Perform the Ajax action request
          */
         executeAction : function (parms, element) {return executeAction(pid, parms, element);},
   
         /**
          * Get a URL of the specified type - resource or partial action
          */
         getUrl : function (type, parms, cache, resid) {return getUrl(type, pid, parms, cache, resid);},
   
         /**
          * Decode the update string returned by the partial action request.
          * Returns array of IDs of portlets to be updated.
          */
         decodeUpdateString : function (ustr) {return updatePageState(ustr, pid);}
   
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
   
}());
