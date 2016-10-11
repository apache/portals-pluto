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
   var portletName = 'PortletHubTests_SPEC_23_JSPA', msg;

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
      var update, testFunction, hub,
          pid = tck.PortletHubTests_SPEC_23_JSPA.pid;

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction1               */
      /* Details: "The portlet hub startPartialAction function can be called with   */
      /* no arguments"                                                              */
      document.getElementById('V3PortletHubTests_SPEC_23_JSPA_startPartialAction1-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSPA_startPartialAction1');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction2               */
      /* Details: "The portlet hub startPartialAction function can be called with   */
      /* an action parameters argument"                                             */
      document.getElementById('V3PortletHubTests_SPEC_23_JSPA_startPartialAction2-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSPA_startPartialAction2');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction3               */
      /* Details: "The portlet hub startPartialAction function returns a            */
      /* PartialActionInit object"                                                  */
      document.getElementById('V3PortletHubTests_SPEC_23_JSPA_startPartialAction3-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSPA_startPartialAction3');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction4               */
      /* Details: "The PartialActionInit object has a url property of type string"  */
      document.getElementById('V3PortletHubTests_SPEC_23_JSPA_startPartialAction4-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSPA_startPartialAction4');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction5               */
      /* Details: "The PartialActionInit object has a setPageState property of type */
      /* function"                                                                  */
      document.getElementById('V3PortletHubTests_SPEC_23_JSPA_startPartialAction5-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSPA_startPartialAction5');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction6               */
      /* Details: "The PartialActionInit object url property used in an XHR causes  */
      /* a token to be returned that completes the partial action when passed to    */
      /* the setPageState function"                                                 */
      document.getElementById('V3PortletHubTests_SPEC_23_JSPA_startPartialAction6-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSPA_startPartialAction6');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction7               */
      /* Details: "The onStateChange event resulting from a partial action contains */
      /* render data produced by the portlet resource method"                       */
      document.getElementById('V3PortletHubTests_SPEC_23_JSPA_startPartialAction7-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSPA_startPartialAction7');
         hub.setRenderState(state);
      }

      update = function (type, state) {
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction1               */
         /* Details: "The portlet hub startPartialAction function can be called with   */
         /* no arguments"                                                              */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSPA_startPartialAction1') {
            setSuccess('V3PortletHubTests_SPEC_23_JSPA_startPartialAction1', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction2               */
         /* Details: "The portlet hub startPartialAction function can be called with   */
         /* an action parameters argument"                                             */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSPA_startPartialAction2') {
            setSuccess('V3PortletHubTests_SPEC_23_JSPA_startPartialAction2', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction3               */
         /* Details: "The portlet hub startPartialAction function returns a            */
         /* PartialActionInit object"                                                  */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSPA_startPartialAction3') {
            setSuccess('V3PortletHubTests_SPEC_23_JSPA_startPartialAction3', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction4               */
         /* Details: "The PartialActionInit object has a url property of type string"  */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSPA_startPartialAction4') {
            setSuccess('V3PortletHubTests_SPEC_23_JSPA_startPartialAction4', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction5               */
         /* Details: "The PartialActionInit object has a setPageState property of type */
         /* function"                                                                  */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSPA_startPartialAction5') {
            setSuccess('V3PortletHubTests_SPEC_23_JSPA_startPartialAction5', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction6               */
         /* Details: "The PartialActionInit object url property used in an XHR causes  */
         /* a token to be returned that completes the partial action when passed to    */
         /* the setPageState function"                                                 */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSPA_startPartialAction6') {
            setSuccess('V3PortletHubTests_SPEC_23_JSPA_startPartialAction6', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSPA_startPartialAction7               */
         /* Details: "The onStateChange event resulting from a partial action contains */
         /* render data produced by the portlet resource method"                       */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSPA_startPartialAction7') {
            setSuccess('V3PortletHubTests_SPEC_23_JSPA_startPartialAction7', 'Not implemented.');
         }

      }

      portlet.register(pid).then(function (pi) {
         hub = pi;
         hub.addEventListener('portlet.onStateChange', update);
      });
   }

   window.addEventListener('load', execute);
}());

