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

// ~~~~~~~~~~~~~~~~~~~~~~~~~~ Test Data ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
   
/**
 * Mock data for portlets
 * @namespace
 * @private        
 */
portlet.test = portlet.test || {};
portlet.test.data  = {
   
   // get initial data for the portlets
   initialPageState : {
      'PortletA' : {
         'state' : {
            'parameters' : {
               'parm1' : ['val1'], 
               'parm2' : ['val2', 'val3']
            }, 
            'portletMode' : 'view', 
            'windowState' : 'normal'
         },
         'pubParms' : [],
         'allowedPM' : ['view', 'edit', 'help'],
         'allowedWS' : ['normal', 'minimized', 'maximized'],
         'renderData' : {
            'content' : null,
            'mimeType' : "text/plain"
         }
      },
      'PortletB' : {
         'state' : {
            'parameters' : {
               'parm1' : ['val1'], 
               'pubparm1' : ['pubval1'], 
               'parm2' : ['val2', 'val3']
            }, 
            'portletMode' : 'view', 
            'windowState' : 'normal'
         },
         'pubParms' : ['pubparm1'],
         'allowedPM' : ['view', 'edit', 'help'],
         'allowedWS' : ['normal', 'minimized', 'maximized'],
         'renderData' : null
      },
      'PortletC' : {
         'state' : {
            'parameters' : {
               'parm1' : ['val1'], 
               'pubparm1' : ['pubval1'], 
               'pubparm2' : ['pubval2'], 
               'parm2' : ['val2', 'val3']
            }, 
            'portletMode' : 'view', 
            'windowState' : 'normal'
         },
         'pubParms' : ['pubparm1', 'pubparm2'],
         'allowedPM' : ['view', 'edit', 'help'],
         'allowedWS' : ['normal', 'minimized', 'maximized']
      },
      'PortletD' : {
         'state' : {
            'parameters' : {
               'pubparm1' : ['private_val1'], 
               'pubparm2' : ['pubval2'], 
               'parm2' : ['val2', 'val3']
            }, 
            'portletMode' : 'view', 
            'windowState' : 'normal'
         },
         'pubParms' : ['pubparm2'],
         'allowedPM' : ['view', 'edit', 'help'],
         'allowedWS' : ['normal', 'minimized', 'maximized'],
         'renderData' : {
            'content' : "Some render data.",
            'mimeType' : "text/plain"
         }
      },
      'PortletE' : {
         'state' : {
            'parameters' : {
               'parm1' : ['val1'], 
               'pubparm1' : ['pubval1'], 
               'pubparm2' : ['pubval2'], 
               'parm2' : ['val2', 'val3']
            }, 
            'portletMode' : 'view', 
            'windowState' : 'normal'
         },
         'pubParms' : ['pubparm1', 'pubparm2'],
         'allowedPM' : ['view', 'edit', 'help'],
         'allowedWS' : ['normal', 'minimized', 'maximized'],
         'renderData' : {
            'content' : "Some render data.",
            'mimeType' : "text/plain"
         }
      },
      'PortletF' : {
         'state' : {
            'parameters' : {
            }, 
            'portletMode' : 'view', 
            'windowState' : 'normal'
         },
         'pubParms' : [],
         'allowedPM' : ['view', 'edit', 'help'],
         'allowedWS' : ['normal', 'minimized', 'maximized'],
         'renderData' : {
            'content' : "Some render data.",
            'mimeType' : "text/plain"
         }
      },
      
      // When the following IDs are used, the mock hub simulates various error
      // conditions. Used for Jasmine tests that check error handling of API 
      // portion of portlet hub.
      
      'SimulateLongWait' : {
         'state' : {
            'parameters' : {
               'parm1' : ['val1'], 
            }, 
            'portletMode' : 'view', 
            'windowState' : 'normal'
         },
         'pubParms' : ['pubparm1', 'pubparm2'],
         'allowedPM' : ['view', 'edit', 'help'],
         'allowedWS' : ['normal', 'minimized', 'maximized']
      },
      'SimulateCommError' : {
         'state' : {
            'parameters' : {
               'parm1' : ['val1'], 
            }, 
            'portletMode' : 'view', 
            'windowState' : 'normal'
         },
         'pubParms' : ['pubparm1', 'pubparm2'],
         'allowedPM' : ['view', 'edit', 'help'],
         'allowedWS' : ['normal', 'minimized', 'maximized']
      },
      'SimulateError' : {
         'state' : {
            'parameters' : {
               'parm1' : ['val1'], 
            }, 
            'portletMode' : 'view', 
            'windowState' : 'normal'
         },
         'pubParms' : ['pubparm1', 'pubparm2'],
         'allowedPM' : ['view', 'edit', 'help'],
         'allowedWS' : ['normal', 'minimized', 'maximized']
      }
   },
   
   // For each portlet, there is a mock update string that         
   // causes a state update for one or more parameters.        
   // The string is decoded and turned into an object by the   
   // decodeUpdateString function. These strings are used
   // by both the action() and the setPageState() code.
   updateStrings : {
      // just updates PortletA
      "PortletA" : "&~~~&PortletA&mode=view&ws=normal&parm1=Fred&parm2=Barney" +
      "&~~~",
      
      // updates portlets B & C
      "PortletB" : "&~~~&PortletB&mode=view&ws=normal&parm1=val1&pubparm1=pubval1&parm2=val2&parm2=val3" +
      "&~~~&PortletC&mode=view&ws=normal&parm1=val1&pubparm1=pubval1&pubparm2=pubval2&parm2=val2&parm2=val3" +
      "&~~~",
      
      // Updates A, B, C, & D
      "PortletC" : "&~~~&PortletA&mode=view&ws=normal&parm1=Fred&parm2=Barney" +
      "&~~~&PortletB&mode=view&ws=normal&parm1=val1&pubparm1=pubval1&parm2=val2&parm2=val3" +
      "&~~~&PortletC&mode=view&ws=normal&parm1=val1&pubparm1=pubval1&pubparm2=pubval2&parm2=val2&parm2=val3" +
      "&~~~&PortletD&mode=view&ws=normal&pubparm1=private_val1&pubparm2=pubval2&parm2=val2&parm2=val3" +
      "&~~~",
      
      "PortletD" : "",
      "PortletE" : "",
      "PortletF" : "",

      // For special portlet ID that causes error sto be simulated
      "SimulateCommError" : "&~~~&SimulateCommError&mode=view&ws=normal&parm1=Fred&parm2=Barney" +
      "&~~~"
   }
};

// get initial data for the portlets. Clone it so that the test
// code has a separate copy than the mockup hub.
portlet.test.getInitData = function () {
   'use strict';
   return JSON.parse(JSON.stringify(portlet.test.data.initialPageState));
};

/**
 * get the available portlet IDs in an array 
 */
portlet.test.getIds = function () {
   'use strict';
   var id, ids = [], pageState = portlet.test.data.initialPageState;
   for (id in pageState) {
      if (pageState.hasOwnProperty(id)) {
         ids.push(id);
      }
   }
   return ids;
};

// ~~~~~~~~~~~~~~~~~~~~~~ End Test Data ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   

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
   testdata = portlet.test.data.initialPageState,
   
   
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
      return pageState[pid].pubParms;
   },

   /**
    * Gets the updated public parameters for the given portlet
    * ID and new render state.
    * Returns an object whose properties are the names of the
    * updated public parameters. The values are the new public
    * parameter values.
    *
    * @param      {string}       pid      The portlet ID
    * @param      {RenderState} state    The new render state
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
    * Returns a deep-copy clone of the input render state object.
    * Used to provide the portlet client with a copy of the current 
    * state data rather than a reference to the live state itself.
    * 
    * @param      {RenderState} state    The render state object to check
    * @returns    {RenderState}          Clone of the input render state
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
   
      var url = "http://www.dummyportal.com/some/context/";
          var qparms = [], rparms, qp, state, tpid, val, pids, ii, jj;
          
      // for a mockup, should be good enough ...
      // optimized for easy parsing by the test code. 
      // see "portlet.test" below.
      
      // This is how it should look:
      //  http://www.dummyportal.com/some/context/PortletA/ACTION/PAGE/?&rp1=resVal&RENDERPARMS
      //  &~~~&PortletA&mode=view&ws=normal&parm1=Fred&parm2=Wilma&parm2=Pebbles&parm3=Barney&parm3=Betty&parm3=Bam%20Bam
      //  &~~~&PortletB&mode=view&ws=normal&parm1=val1&pubparm1=pubval1&parm2=val2&parm2=val3
      //  &~~~&PortletC&mode=view&ws=normal&parm1=val1&pubparm1=pubval1&pubparm2=pubval2&parm2=val2&parm2=val3
      //  &~~~&PortletD&mode=view&ws=normal&pubparm1=private_val1&pubparm2=pubval2&parm2=val2&parm2=val3
      //  &~~~&PortletE&mode=view&ws=normal&parm1=val1&parm2=val2&parm2=val3&pubparm1=pubval1&pubparm2=pubval2
      //  &~~~&PortletF&mode=view&ws=normal&~~~
      
      url += pid + "/" + type + "/"; 
      url += (((cache===undefined)||(cache===null))?"cacheLevelPage":cache) + "/?";
          
      // put the additional parameters on the URL
      if (parms !== null) {
         for (qp in parms) {
            for (var ii=0; ii<parms[qp].length; ii++) {
               val = (parms[qp][ii] === null) ? "" : "=" + encodeURIComponent(parms[qp][ii]);
               qparms.push(encodeURIComponent(qp) + val);
            }
         }
      }
   
      qparms.push("RENDERPARMS")
      qparms.push("~~~")
   
      // Don't put any render parameters on it cache=cacheLevelFull
      if ((type !== "RESOURCE") || 
          ((type === "RESOURCE") && (cache !== "cacheLevelFull"))) {
         
         pids = getIds();
         jj = pids.length;
         while ((jj = jj - 1) >= 0) {
            tpid = pids[jj];
            
            // If cache=cacheLevelPortlet, only put on the parms for that portlet
            if ((type === "RESOURCE") && (cache === "cacheLevelPortlet") && (pid !== tpid)) {
               continue;
            }
            
            // put the render state parameters on the URL
            state = getState(tpid);
            
            qparms.push(encodeURIComponent(tpid));
            qparms.push("mode=" + state.portletMode);
            qparms.push("ws=" + state.windowState);
         
            rparms = state.parameters;
            for (qp in rparms) {
               for (ii=0; ii<rparms[qp].length; ii++) {
                  val = (rparms[qp][ii] === null) ? "" : "=" + encodeURIComponent(rparms[qp][ii]);
                  qparms.push(encodeURIComponent(qp) + val);
               }
            }
            qparms.push("~~~");
            
         }
      }
      
      // put on the query parms
      while (qparms.length > 0) {
         url += "&" + qparms.shift();
      }
      
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
            reject(new Error("Simulated error occurred when getting a URL!"));
         } else {
            resolve(url);
         }
      });
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



   portlet.impl = {

      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      // The page state is an object containing one member of the following
      // structure for each portlet:
      //
      // 'PortletA' : {
      //    'state' : {
      //       'parameters' : {
      //          'parm1' : ['val1'],
      //          'parm2' : ['val2', 'val3']
      //       },
      //       'portletMode' : 'view',
      //       'windowState' : 'normal',
      //    },
      //    'pubParms' : [],
      //    'allowedPM' : ['view', 'edit', 'help'],
      //    'allowedWS' : ['normal', 'minimized', 'maximized'],
      // }
      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

      // get initial data for the portlets. Clone it so that the test
      // code has a separate copy than the mockup hub.
      getInitData : function () {
         return JSON.parse(JSON.stringify(portlet.test.data.initialPageState));
      }
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
			executeAction : function (parms, element, callback, onError) {return executeAction(pid, parms, element, callback, onError);},
   
			/**
			 * Get a URL of the specified type - resource or partial action
			 */
			getUrl : function (type, parms, cache) {return getUrl(type, pid, parms, cache);},
   
			/**
			 * Decode the update string returned by the partial action request.
			 * Returns array of IDs of portlets to be updated.
			 */
			decodeUpdateString : function (ustr) {return updatePageState(ustr, pid);},
   
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
   }

   /**
    * Some test functions that are implementation dependent
    * @namespace
    * @private
    */
   // portlet.test = {

         // test needs the data & IDs & decoder too
         // portlet.test.getInitData = portlet.impl.getInitData;
         // portlet.test.getIds = portlet.impl.getIds;
         portlet.test.decodeUpdateString = decodeUpdateString;

   // };

   /**
    * Exception thrown when a portlet hub method is provided with an invalid argument.
    * @typedef    IllegalArgumentException 
    * @property   {string}    name     The exception name, equal to "IllegalArgumentException"
    * @property   {string}    message  An optional message that provides more detail about the exception
    */
   var throwIllegalArgumentException = function (msg) {
      throw {
         name : "IllegalArgumentException",
         message : msg
      };
   };

   /**
    * Utility function to convert a query string encoded according to 
    * mockup rules into a portlet parameters object.
    * <p>
    * Note that this function performs no special handling for
    * for any wondow state or portlet mode parameters that may be present.
    * 
    * @param qps   {string}             query string
    * 
    * @returns     {PortletParameters}  portlet parameters object
    * 
    * @private    
    */
   function qps2parms (qps) {
      var parms = {}, tparms, nameval, ii, pname, pval; 
      
      if (qps !== null && qps !== "") {
         tparms = qps.split("&");
         ii = tparms.length;
        
         // first element is always "", since query string begins with &
         while ((ii=ii-1) > 0) {
            
            nameval = tparms[ii].split("=");
            pname = decodeURIComponent(nameval[0]);
            pval = (nameval.length < 2) ? null : decodeURIComponent(nameval[1]);
            
            if (parms.hasOwnProperty(pname) === true) {
               parms[pname].unshift(pval);      // the order of values in the array matters.
            } else {
               parms[pname] = [];
               parms[pname].unshift(pval);
            }
         }
      }
      return parms;
   } 

   
   // Since the URL is encoded in a proprietary manner, the implementation
   // needs to provide functions that the test setup can use to decode them.
   // The following decode the action URL generated by the mock implementation.
   // also provided are the update strings for action and partial action testing.
   portlet.test.action  = {
         
         // gets the portlet ID from the URL
         getInitiatingPortletId : function (url) {
            var str = url.match(/context.*\?/);
            if (str !== null) {
               str = str[0].split("/")[1]; 
            }
            return str;
         },
         
         // tests if action URL
         isActionUrl : function (url) {
            var flag = false, str = url.match(/context.*\?/);
            if (str !== null) {
               str = str[0].split("/")[2];
               if (str === "ACTION") {
                  flag = true;
               }
            }
            return flag;
         },
         
         // tests if action URL
         isPartialActionUrl : function (url) {
            var flag = false, str = url.match(/context.*\?/);
            if (str !== null) {
               str = str[0].split("/")[2];
               if (str === "PARTIAL_ACTION") {
                  flag = true;
               }
            }
            return flag;
         },
         
         // gets the action parameters from the URL
         getActionParms : function (url) {
            var str = url.replace(/^.*\?(.*)&RENDER.*$/, "$1");
            return qps2parms(str);
         },
         
         // gets the render state for given portlet id
         getState : function (url, pid) {
            var parms, state = {}, 
            // URI encode because the pid in the URL was URI encoded. afterwards escape for regex.
            encpid = encodeURIComponent(pid).replace(/[-\/\\^$*+?.()|[\]{}]/g, '\\$&'),
            reg = "^.*&" + encpid + "(.*?)(?=&~~~).*$",  
            regexp = new RegExp(reg), str;

            if (url.match(regexp) !== null) {

               str = url.replace(regexp, "$1");
               parms = qps2parms(str);

               // test for parms being available -
               if (parms.ws !== undefined) {

                  // don't worry about deep copy.
                  state.windowState = parms.ws[0]; 
                  delete parms.ws;
                  state.portletMode = parms.mode[0];
                  delete parms.mode;
                  state.parameters = parms;

               }
            }
             
            return state;
         },
         
   };
   
   // Since the URL is encoded in a proprietary manner, the implementation
   // needs to provide functions that the test setup can use to decode them.
   // The following decode the resource URL generated by the mock implementation.
   portlet.test.resource = {
         
         // gets the portlet ID from the URL
         getInitiatingPortletId : function (url) {
            var str = url.match(/context.*\?/);
            if (str !== null) {
               str = str[0].split("/")[1]; 
            }
            return str;
         },
         
         // tests if resource URL
         isResourceUrl : function (url) {
            var flag = false, str = url.match(/context.*\?/);
            if (str !== null) {
               str = str[0].split("/")[2];
               if (str === "RESOURCE") {
                  flag = true;
               }
            }
            return flag;
         },
         
         // gets the cacheability from the URL
         getCacheability : function (url) {
            var str = url.match(/context.*\?/);
            if (str !== null) {
               str = str[0].split("/")[3]; 
            }
            return str;
         },
         
         // gets the resource parameters from the URL
         getResourceParms : function (url) {
            var str = url.replace(/^.*\?(.*)&RENDER.*$/, "$1");
            return qps2parms(str);
         },
         
         // gets the render state for given portlet id
         getState : function (url, pid) {
            var parms, state = {}, encpid = encodeURIComponent(pid),
            reg = "^.*&" + encpid + "(.*?)(?=&~~~).*$",  
            regexp = new RegExp(reg), str;

            if (url.match(regexp) !== null) {

               str = url.replace(regexp, "$1");
               parms = qps2parms(str);

               // test for parms being available -
               if (parms.ws !== undefined) {

                  // don't worry about deep copy.
                  state.windowState = parms.ws[0]; 
                  delete parms.ws;
                  state.portletMode = parms.mode[0];
                  delete parms.mode;
                  state.parameters = parms;

               }
            }
             
            return state;
         },
         
   };
   
})();
