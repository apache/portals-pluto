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


(function() {
   'use strict';
   var portletName = 'PortletHubTests_SPEC_23_JSListener', msg;

   function setSuccess (tc, fail) {
      var el;
      el = document.getElementById(tc + '-async');
      if (el !== null) {
         if (fail) {
            el.innerHTML = fail;
         } else {
            el.innerHTML = 'Test Succeeded';
         }
         el.id = tc + '-result';
      }
   }

   function testException (func, type) {
      var ok = null;
      try {
         func();
         ok = 'Function did not throw exception';
      } catch (e) {
         if (e.name !== type) {
            ok = 'Invalid exception type: ' + e.name;
         }
      }
      return ok;
   }

   function checkParams (p1, p2) {
      var fail = null, key, keys = Object.keys(p1), ii, jj;
      if (keys.length !== Object.keys(p2).length) {
         fail = 'Cloned parameters have different numbers of keys';
      } else {
         for (ii = 0; ii < keys.length && fail === null; ii++) {
            key = keys[ii];
            if (!Array.isArray(p1[key]) || !Array.isArray(p2[key])) {
               fail = 'Parameter value is not array for key: ' + key;
               break;
            }
            if (p1[key].length !== p2[key].length) {
               fail = 'Value arrays not equal for key: ' + key;
               break;
            }
            for (jj = 0; jj < p1[key].length; jj++) {
               if (p1[key][jj] !== p2[key][jj]) {
                  fail = 'Value arrays not equal for key: ' + key;
                  break;
               }
            }
         }
      }
      return fail;
   }

   function execute () {
      var update, testFunction, hub, handle, errorHandle,
      pid = tck.PortletHubTests_SPEC_23_JSListener.pid;

      update = function (type, state) {
         var msg;

         /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange1              */
         /* Details: "After an onStateChange listener is added, the portlet hub calls  */
         /* the onStateChange function"                                                */
         msg = null;
         msg = (type) ? msg : 'Type is null or undefined.'; 
         msg = (state) ? msg : msg + ' State is null or undefined.'; 
         setSuccess('V3PortletHubTests_SPEC_23_JSListener_onStateChange1', msg);

         /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange2              */
         /* Details: "The onStateChange listener type argument has the value           */
         /* 'portlet.onStateChange'"                                                   */
         msg = null;
         if (!type || (typeof type !== 'string')){
            msg = 'Type is not a string, but instead: ' + typeof type;
         } else if (type !== 'portlet.onStateChange') {
            msg = 'type is not equal to portlet.onStateChange, but to: ' + type; 
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSListener_onStateChange2', msg);

         /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange3              */
         /* Details: "The onStateChange listener renderState argument is a valid       */
         /* RenderState object"                                                        */
         msg = null;
         if (typeof state !== 'object') {
            msg = 'State is not of type object';
         } else if (typeof state.clone  !== 'function') {
            msg = 'State object clone function is not a function';
         } else if (typeof state.setPortletMode  !== 'function') {
            msg = 'State object setPortletMode function is not a function';
         } else if (typeof state.getPortletMode  !== 'function') {
            msg = 'State object getPortletMode function is not a function';
         } else if (typeof state.setWindowState  !== 'function') {
            msg = 'State object setWindowState function is not a function';
         } else if (typeof state.getWindowState  !== 'function') {
            msg = 'State object getWindowState function is not a function';
         } else if (typeof state.setValue  !== 'function') {
            msg = 'State object setValue function is not a function';
         } else if (typeof state.getValue  !== 'function') {
            msg = 'State object getValue function is not a function';
         } else if (typeof state.getValues  !== 'function') {
            msg = 'State object getValues function is not a function';
         } else if (typeof state.remove  !== 'function') {
            msg = 'State object remove function is not a function';
         } else if (typeof state.parameters  !== 'object') {
            msg = 'State object parameters is not of type object';
         } else if (typeof state.portletMode  !== 'string') {
            msg = 'State object portletMode is not of type string';
         } else if (typeof state.windowState  !== 'string') {
            msg = 'State object windowState is not of type string';
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSListener_onStateChange3', msg);

      }

      portlet.register(pid).then(function (pi) {
         hub = pi;
         handle = hub.addEventListener('portlet.onStateChange', update);
      });


      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange4              */
      /* Details: "A previously added onStateChangeListener can be removed"         */
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onStateChange4-clickme').onclick = function () {
         msg = null;
         if (!handle) {
            msg = 'onStateChange event listener is null or undefined.';
         } else {
            try {
               hub.removeEventListener(handle);
            } catch (e) {
               msg = 'Error was thrown removing the listener: ' + e.message;
            }
         }
         if (!msg) {
            handle = hub.addEventListener('portlet.onStateChange', update);
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSListener_onStateChange4', msg);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onStateChange4-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange5              */
      /* Details: "The portlet hub throws a TypeError if a previously added         */
      /* onStateChange listener is removed twice"                                   */
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onStateChange5-clickme').onclick = function () {
         msg = null;
         hub.removeEventListener(handle);
         testFunction = function () {
            hub.removeEventListener(handle);
         }
         msg = testException(testFunction, 'TypeError');
         if (!msg) {
            handle = hub.addEventListener('portlet.onStateChange', update);
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSListener_onStateChange5', msg);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onStateChange5-notready').id='ready';
      
      function onTestError () {}

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onError1                    */
      /* Details: "An onError listener can be added"                                */
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onError1-clickme').onclick = function () {
         msg = null;
         try {
            errorHandle = hub.addEventListener('portlet.onError', onTestError);
         } catch (e) {
            msg = 'Error was thrown adding the onError listener: ' + e.message;
            errorHandle = null;
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSListener_onError1', msg);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onError1-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onError2                    */
      /* Details: "A previously added onError listener can be removed"              */
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onError2-clickme').onclick = function () {
         if (!errorHandle) {
            errorHandle = hub.addEventListener('portlet.onError', onTestError);
         }
         msg = null;
         try {
            hub.removeEventListener(errorHandle);
         } catch (e) {
            msg = 'Error was thrown removing the listener: ' + e.message;
         }
         errorHandle = null;
         
         setSuccess('V3PortletHubTests_SPEC_23_JSListener_onError2', msg);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onError2-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onError3                    */
      /* Details: "The portlet hub throws a TypeError if a previously added onError */
      /* listener is removed twice"                                                 */
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onError3-clickme').onclick = function () {
         if (!errorHandle) {
            errorHandle = hub.addEventListener('portlet.onError', onTestError);
         }
         msg = null;
         hub.removeEventListener(errorHandle);
         testFunction = function () {
            hub.removeEventListener(errorHandle);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSListener_onError3', msg);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onError3-notready').id='ready';
   }

   window.addEventListener('load', execute);
}());

