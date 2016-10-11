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
   var portletName = 'PortletHubTests_SPEC_23_JSRS', msg;

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
          pid = tck.PortletHubTests_SPEC_23_JSRS.pid;

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState1                   */
      /* Details: "The portlet hub setRenderState function causes the onStateChange */
      /* listener to be called"                                                     */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState1-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState1');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState2                   */
      /* Details: "The portlet hub setRenderState function allows the portlet mode  */
      /* to be set to \"EDIT\""                                                     */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState2-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState2');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState3                   */
      /* Details: "The portlet hub setRenderState function allows the portlet mode  */
      /* to be set to \"VIEW\""                                                     */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState3-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState3');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState4                   */
      /* Details: "The portlet hub setRenderState function allows the window state  */
      /* to be set to \"MAXIMIZED\""                                                */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState4-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState4');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState5                   */
      /* Details: "The portlet hub setRenderState function allows the window state  */
      /* to be set to \"NORMAL\""                                                   */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState5-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState5');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState6                   */
      /* Details: "The portlet hub setRenderState function allows a new parameter   */
      /* \"NewParm\" to be set to \"NewVal\""                                       */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState6-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState6');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState7                   */
      /* Details: "The portlet hub setRenderState function allows parameter         */
      /* \"NewParm\" to be set to [\"NewVal1\", \"NewVal2\"]"                       */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState7-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState7');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState8                   */
      /* Details: "The portlet hub setRenderState function allows a new parameter   */
      /* \"NewParm\" to be deleted"                                                 */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState8-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState8');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState9                   */
      /* Details: "The portlet hub setRenderState function allows all parameters to */
      /* be deleted"                                                                */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState9-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState9');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState0                   */
      /* Details: "The portlet hub setRenderState function allows several           */
      /* parameters to be set"                                                      */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState0-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState0');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderStateA                   */
      /* Details: "The portlet hub setRenderState function allows setting the state */
      /* back to the original test data"                                            */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderStateA-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderStateA');
         hub.setRenderState(state);
      }

      update = function (type, state) {
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState1                   */
         /* Details: "The portlet hub setRenderState function causes the onStateChange */
         /* listener to be called"                                                     */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState1') {
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState1', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState2                   */
         /* Details: "The portlet hub setRenderState function allows the portlet mode  */
         /* to be set to \"EDIT\""                                                     */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState2') {
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState2', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState3                   */
         /* Details: "The portlet hub setRenderState function allows the portlet mode  */
         /* to be set to \"VIEW\""                                                     */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState3') {
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState3', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState4                   */
         /* Details: "The portlet hub setRenderState function allows the window state  */
         /* to be set to \"MAXIMIZED\""                                                */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState4') {
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState4', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState5                   */
         /* Details: "The portlet hub setRenderState function allows the window state  */
         /* to be set to \"NORMAL\""                                                   */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState5') {
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState5', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState6                   */
         /* Details: "The portlet hub setRenderState function allows a new parameter   */
         /* \"NewParm\" to be set to \"NewVal\""                                       */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState6') {
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState6', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState7                   */
         /* Details: "The portlet hub setRenderState function allows parameter         */
         /* \"NewParm\" to be set to [\"NewVal1\", \"NewVal2\"]"                       */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState7') {
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState7', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState8                   */
         /* Details: "The portlet hub setRenderState function allows a new parameter   */
         /* \"NewParm\" to be deleted"                                                 */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState8') {
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState8', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState9                   */
         /* Details: "The portlet hub setRenderState function allows all parameters to */
         /* be deleted"                                                                */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState9') {
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState9', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState0                   */
         /* Details: "The portlet hub setRenderState function allows several           */
         /* parameters to be set"                                                      */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState0') {
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState0', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderStateA                   */
         /* Details: "The portlet hub setRenderState function allows setting the state */
         /* back to the original test data"                                            */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderStateA') {
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderStateA', 'Not implemented.');
         }

      }

      portlet.register(pid).then(function (pi) {
         hub = pi;
         hub.addEventListener('portlet.onStateChange', update);
      });
   }

   window.addEventListener('load', execute);
}());

