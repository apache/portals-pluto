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
   var portletName = 'PortletHubTests_SPEC_23_JSAction', msg;

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
          pid = tck.PortletHubTests_SPEC_23_JSAction.pid;

      /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action1                       */
      /* Details: "The portlet hub action function can be called with no arguments" */
      document.getElementById('V3PortletHubTests_SPEC_23_JSAction_Action1-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSAction_Action1');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action2                       */
      /* Details: "The portlet hub action function can be called with an action     */
      /* parameters argument"                                                       */
      document.getElementById('V3PortletHubTests_SPEC_23_JSAction_Action2-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSAction_Action2');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action3                       */
      /* Details: "The portlet hub action function can be called with a form        */
      /* element argument"                                                          */
      document.getElementById('V3PortletHubTests_SPEC_23_JSAction_Action3-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSAction_Action3');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action4                       */
      /* Details: "The portlet hub action function can be called with both action   */
      /* parameters and form element arguments"                                     */
      document.getElementById('V3PortletHubTests_SPEC_23_JSAction_Action4-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSAction_Action4');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action5                       */
      /* Details: "The portlet hub action function can cause a private render       */
      /* parameter to be set for the initiating portlet"                            */
      document.getElementById('V3PortletHubTests_SPEC_23_JSAction_Action5-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSAction_Action5');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action6                       */
      /* Details: "The portlet hub action function can cause a private render       */
      /* parameter to be set for a portlet that is target of an event"              */
      document.getElementById('V3PortletHubTests_SPEC_23_JSAction_Action6-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSAction_Action6');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action7                       */
      /* Details: "The portlet hub action function fulfills the promise when the    */
      /* action is complete"                                                        */
      document.getElementById('V3PortletHubTests_SPEC_23_JSAction_Action7-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSAction_Action7');
         hub.setRenderState(state);
      }

      update = function (type, state) {
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action1                       */
         /* Details: "The portlet hub action function can be called with no arguments" */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSAction_Action1') {
            setSuccess('V3PortletHubTests_SPEC_23_JSAction_Action1', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action2                       */
         /* Details: "The portlet hub action function can be called with an action     */
         /* parameters argument"                                                       */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSAction_Action2') {
            setSuccess('V3PortletHubTests_SPEC_23_JSAction_Action2', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action3                       */
         /* Details: "The portlet hub action function can be called with a form        */
         /* element argument"                                                          */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSAction_Action3') {
            setSuccess('V3PortletHubTests_SPEC_23_JSAction_Action3', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action4                       */
         /* Details: "The portlet hub action function can be called with both action   */
         /* parameters and form element arguments"                                     */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSAction_Action4') {
            setSuccess('V3PortletHubTests_SPEC_23_JSAction_Action4', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action5                       */
         /* Details: "The portlet hub action function can cause a private render       */
         /* parameter to be set for the initiating portlet"                            */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSAction_Action5') {
            setSuccess('V3PortletHubTests_SPEC_23_JSAction_Action5', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action6                       */
         /* Details: "The portlet hub action function can cause a private render       */
         /* parameter to be set for a portlet that is target of an event"              */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSAction_Action6') {
            setSuccess('V3PortletHubTests_SPEC_23_JSAction_Action6', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSAction_Action7                       */
         /* Details: "The portlet hub action function fulfills the promise when the    */
         /* action is complete"                                                        */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSAction_Action7') {
            setSuccess('V3PortletHubTests_SPEC_23_JSAction_Action7', 'Not implemented.');
         }

      }

      portlet.register(pid).then(function (pi) {
         hub = pi;
         hub.addEventListener('portlet.onStateChange', update);
      });
   }

   window.addEventListener('load', execute);
}());

