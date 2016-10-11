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
      var update, testFunction, hub,
          pid = tck.PortletHubTests_SPEC_23_JSListener.pid;

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange1              */
      /* Details: "After an onStateChange listener is added, the portlet hub calls  */
      /* the onStateChange function"                                                */
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onStateChange1-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSListener_onStateChange1');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange2              */
      /* Details: "The onStateChange listener type argument has the value           */
      /* 'portlet.onStateChange'"                                                   */
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onStateChange2-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSListener_onStateChange2');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange3              */
      /* Details: "The onStateChange listener renderState argument is a valid       */
      /* RenderState object"                                                        */
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onStateChange3-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSListener_onStateChange3');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange4              */
      /* Details: "A previously added onStateChangeListener can be removed"         */
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onStateChange4-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSListener_onStateChange4');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange5              */
      /* Details: "The portlet hub throws a TypeError if a previously added         */
      /* onStateChange listener is removed twice"                                   */
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onStateChange5-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSListener_onStateChange5');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onError1                    */
      /* Details: "An onError listener can be added"                                */
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onError1-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSListener_onError1');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onError2                    */
      /* Details: "A previously added onError listener can be removed"              */
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onError2-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSListener_onError2');
         hub.setRenderState(state);
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onError3                    */
      /* Details: "The portlet hub throws a TypeError if a previously added onError */
      /* listener is removed twice"                                                 */
      document.getElementById('V3PortletHubTests_SPEC_23_JSListener_onError3-clickme').onclick = function () {
         var state = hub.newState();
         state.setValue('testcase', 'V3PortletHubTests_SPEC_23_JSListener_onError3');
         hub.setRenderState(state);
      }

      update = function (type, state) {
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange1              */
         /* Details: "After an onStateChange listener is added, the portlet hub calls  */
         /* the onStateChange function"                                                */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSListener_onStateChange1') {
            setSuccess('V3PortletHubTests_SPEC_23_JSListener_onStateChange1', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange2              */
         /* Details: "The onStateChange listener type argument has the value           */
         /* 'portlet.onStateChange'"                                                   */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSListener_onStateChange2') {
            setSuccess('V3PortletHubTests_SPEC_23_JSListener_onStateChange2', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange3              */
         /* Details: "The onStateChange listener renderState argument is a valid       */
         /* RenderState object"                                                        */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSListener_onStateChange3') {
            setSuccess('V3PortletHubTests_SPEC_23_JSListener_onStateChange3', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange4              */
         /* Details: "A previously added onStateChangeListener can be removed"         */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSListener_onStateChange4') {
            setSuccess('V3PortletHubTests_SPEC_23_JSListener_onStateChange4', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onStateChange5              */
         /* Details: "The portlet hub throws a TypeError if a previously added         */
         /* onStateChange listener is removed twice"                                   */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSListener_onStateChange5') {
            setSuccess('V3PortletHubTests_SPEC_23_JSListener_onStateChange5', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onError1                    */
         /* Details: "An onError listener can be added"                                */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSListener_onError1') {
            setSuccess('V3PortletHubTests_SPEC_23_JSListener_onError1', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onError2                    */
         /* Details: "A previously added onError listener can be removed"              */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSListener_onError2') {
            setSuccess('V3PortletHubTests_SPEC_23_JSListener_onError2', 'Not implemented.');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSListener_onError3                    */
         /* Details: "The portlet hub throws a TypeError if a previously added onError */
         /* listener is removed twice"                                                 */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSListener_onError3') {
            setSuccess('V3PortletHubTests_SPEC_23_JSListener_onError3', 'Not implemented.');
         }

      }

      portlet.register(pid).then(function (pi) {
         hub = pi;
         hub.addEventListener('portlet.onStateChange', update);
      });
   }

   window.addEventListener('load', execute);
}());

