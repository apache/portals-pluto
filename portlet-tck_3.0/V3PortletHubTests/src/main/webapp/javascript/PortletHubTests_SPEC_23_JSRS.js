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
   var portletName = 'PortletHubTests_SPEC_23_JSRS', msg,  doUpdate = false, doResolve, doReject;

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

   function doPromise (resolve, reject) {
      doResolve = resolve;
      doReject = reject;
      doUpdate = true;
   }
   
   function execute () {
      var update, testFunction, hub, myPromise, deleteAllParameters = false, 
          pid = tck.PortletHubTests_SPEC_23_JSRS.pid;

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState1                   */
      /* Details: "The portlet hub setRenderState function causes the onStateChange */
      /* listener to be called"                                                     */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState1-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState1');
         hub.setRenderState(state);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState1-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState2                   */
      /* Details: "The portlet hub setRenderState function allows the portlet mode  */
      /* to be set to \"edit\""                                                     */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState2-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState2');
         state.setPortletMode(hub.constants.EDIT);
         hub.setRenderState(state);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState2-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState3                   */
      /* Details: "The portlet hub setRenderState function allows the portlet mode  */
      /* to be set to \"view\""                                                     */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState3-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState3');
         state.setPortletMode(hub.constants.VIEW);
         hub.setRenderState(state);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState3-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState4                   */
      /* Details: "The portlet hub setRenderState function allows the window state  */
      /* to be set to \"maximized\""                                                */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState4-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState4');
         state.setWindowState(hub.constants.MAXIMIZED);
         hub.setRenderState(state);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState4-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState5                   */
      /* Details: "The portlet hub setRenderState function allows the window state  */
      /* to be set to \"normal\""                                                   */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState5-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState5');
         state.setWindowState(hub.constants.NORMAL);
         hub.setRenderState(state);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState5-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState6                   */
      /* Details: "The portlet hub setRenderState function allows a new parameter   */
      /* \"NewParm\" to be set to \"NewVal\""                                       */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState6-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState6');
         state.setValue('newParam', 'newVal');
         hub.setRenderState(state);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState6-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState7                   */
      /* Details: "The portlet hub setRenderState function allows parameter         */
      /* \"NewParm\" to be set to [\"NewVal1\", \"NewVal2\"]"                       */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState7-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState7');
         state.setValue('newParam', ['newVal1', 'newVal2']);
         hub.setRenderState(state);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState7-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState8                   */
      /* Details: "The portlet hub setRenderState function allows a new parameter   */
      /* \"NewParm\" to be deleted"                                                 */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState8-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState8');
         state.setValue('toBeDeleted', 'someValue');
         hub.setRenderState(state);

         myPromise = new Promise(doPromise);
         myPromise.then(
               function (newState) {
                  newState.remove('toBeDeleted');
                  hub.setRenderState(newState);
               });
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState8-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState9                   */
      /* Details: "The portlet hub setRenderState function allows all parameters to */
      /* be deleted"                                                                */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState9-clickme').onclick = function () {
         var state = hub.newState();
         deleteAllParameters = true;
         hub.setRenderState(state);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState9-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState0                   */
      /* Details: "The portlet hub setRenderState function allows several           */
      /* parameters to be set"                                                      */
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState0-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSRS_setRenderState0');
         state.setValue('param1', 'val1');
         state.setValue('param2', ['val1', 'val2']);
         hub.setRenderState(state);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSRS_setRenderState0-notready').id='ready';

      update = function (type, state) {
         var msg, params, cnt, param;
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState1                   */
         /* Details: "The portlet hub setRenderState function causes the onStateChange */
         /* listener to be called"                                                     */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState1') {
            msg = null;
            msg = (type) ? msg : 'Type is null or undefined.'; 
            msg = (state) ? msg : msg + ' State is null or undefined.'; 
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState1', msg);
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState2                   */
         /* Details: "The portlet hub setRenderState function allows the portlet mode  */
         /* to be set to \"edit\""                                                     */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState2') {
            msg = null;
            if (state.getPortletMode().toLowerCase() !== 'edit') {
               msg = 'Portlet mode is not set to edit, but to: ' + state.getPortletMode(); 
            }
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState2', msg);
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState3                   */
         /* Details: "The portlet hub setRenderState function allows the portlet mode  */
         /* to be set to \"view\""                                                     */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState3') {
            msg = null;
            if (state.getPortletMode().toLowerCase() !== 'view') {
               msg = 'Portlet mode is not set to view, but to: ' + state.getPortletMode(); 
            }
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState3', msg);
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState4                   */
         /* Details: "The portlet hub setRenderState function allows the window state  */
         /* to be set to \"maximized\""                                                */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState4') {
            msg = null;
            if (state.getWindowState().toLowerCase() !== 'maximized') {
               msg = 'Window state is not set to maximized, but to: ' + state.getWindowState(); 
            }
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState4', msg);
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState5                   */
         /* Details: "The portlet hub setRenderState function allows the window state  */
         /* to be set to \"normal\""                                                   */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState5') {
            msg = null;
            if (state.getWindowState().toLowerCase() !== 'normal') {
               msg = 'Window state is not set to normal, but to: ' + state.getWindowState(); 
            }
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState5', msg);
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState6                   */
         /* Details: "The portlet hub setRenderState function allows a new parameter   */
         /* \"NewParm\" to be set to \"NewVal\""                                       */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState6') {
            var params = {};
            params.newParam = ['newVal'];
            params.testcase = ['V3PortletHubTests_SPEC_23_JSRS_setRenderState6'];
            msg = checkParams(params, state.parameters);
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState6', msg);
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState7                   */
         /* Details: "The portlet hub setRenderState function allows parameter         */
         /* \"NewParm\" to be set to [\"NewVal1\", \"NewVal2\"]"                       */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState7') {
            var params = {};
            params.newParam = ['newVal1', 'newVal2'];
            params.testcase = ['V3PortletHubTests_SPEC_23_JSRS_setRenderState7'];
            msg = checkParams(params, state.parameters);
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState7', msg);
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState8                   */
         /* Details: "The portlet hub setRenderState function allows a new parameter   */
         /* \"NewParm\" to be deleted"                                                 */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState8') {
            if (doUpdate) {
               doUpdate = false;
               // make sure that 'toBeDeleted' is present
               if (!state.getValue('toBeDeleted')) {
                  setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState8', 'Expected parameter toBeDeleted not set.');
                  doReject();
               } else {
                  doResolve(hub.newState(state));
               }
            } else {
               // make sure that 'toBeDeleted' is NOT present
               msg = null;
               if (state.getValue('toBeDeleted')) {
                  msg = 'Parameter toBeDeleted unexpectedly set.';
               }
               setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState8', msg);
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState9                   */
         /* Details: "The portlet hub setRenderState function allows all parameters to */
         /* be deleted"                                                                */
         if (deleteAllParameters) {
            deleteAllParameters = false;
            cnt = 0; 
            params = state.parameters;
            for (var param in params) {
               if (params.hasOwnProperty(param)) {
                  cnt++;
               }
            }
            msg = null;
            if (cnt !== 0) {
               msg = 'Parameters are still present.';
            }
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState9', msg);
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSRS_setRenderState0                   */
         /* Details: "The portlet hub setRenderState function allows several           */
         /* parameters to be set"                                                      */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSRS_setRenderState0') {
            var params = {};
            params.param1 = ['val1'];
            params.param2 = ['val1', 'val2'];
            params.testcase = ['V3PortletHubTests_SPEC_23_JSRS_setRenderState0'];
            msg = checkParams(params, state.parameters);
            setSuccess('V3PortletHubTests_SPEC_23_JSRS_setRenderState0', msg);
         }

      }

      portlet.register(pid).then(function (pi) {
         hub = pi;
         hub.addEventListener('portlet.onStateChange', update);
      });
   }

   window.addEventListener('load', execute);
}());

