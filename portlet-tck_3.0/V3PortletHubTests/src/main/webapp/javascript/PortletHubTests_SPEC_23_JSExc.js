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
   var portletName = 'PortletHubTests_SPEC_23_JSExc', msg;

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
          pid = tck.PortletHubTests_SPEC_23_JSExc.pid;

      update = function (type, state) {

      }

      portlet.register(pid).then(function (pi) {
         hub = pi;
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener1                */
         /* Details: "The PortletInit object addEventListener function throws a        */
         /* TypeError if no argument is provided"                                      */
         testFunction = function () {
            hub.addEventListener();
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_addEventListener1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener2                */
         /* Details: "The PortletInit object addEventListener function throws a        */
         /* TypeError if 1 argument is provided"                                       */
         testFunction = function () {
            hub.addEventListener('portlet.onStateChange');
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_addEventListener2', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener3                */
         /* Details: "The PortletInit object addEventListener function throws a        */
         /* TypeError if too many (&gt;2) arguments are provided"                      */
         testFunction = function () {
            hub.addEventListener('portlet.onStateChange', update, 'extra param');
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_addEventListener3', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener4                */
         /* Details: "The PortletInit object addEventListener function throws a        */
         /* TypeError if the type argument is not a string"                            */
         testFunction = function () {
            hub.addEventListener(42, update);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_addEventListener4', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener5                */
         /* Details: "The PortletInit object addEventListener function throws a        */
         /* TypeError if the function argument is not a function"                      */
         testFunction = function () {
            hub.addEventListener('portlet.onStateChange', 'invalid');
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_addEventListener5', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener6                */
         /* Details: "The PortletInit object addEventListener function throws a        */
         /* TypeError if the type is null"                                             */
         testFunction = function () {
            hub.addEventListener(null, null);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_addEventListener6', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener7                */
         /* Details: "The PortletInit object addEventListener function throws a        */
         /* TypeError if the function is null"                                         */
         testFunction = function () {
            hub.addEventListener(null, null);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_addEventListener7', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_addEventListener8                */
         /* Details: "The PortletInit object addEventListener function throws a        */
         /* TypeError if the type begins with \"portlet.\" but is neither              */
         /* \"portlet.onStateChange\" or \"portlet.onError\""                          */
         testFunction = function () {
            hub.addEventListener('portlet.Invalid', update);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_addEventListener8', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_removeEventListener1             */
         /* Details: "The PortletInit object removeEventListener function throws a     */
         /* TypeError if no argument is provided"                                      */
         testFunction = function () {
            hub.removeEventListener();
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_removeEventListener1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_removeEventListener2             */
         /* Details: "The PortletInit object removeEventListener function throws a     */
         /* TypeError if too many (&gt;1) arguments are provided"                      */
         testFunction = function () {
            hub.removeEventListener('invalid 0', 'invalid 1');
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_removeEventListener2', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_removeEventListener3             */
         /* Details: "The PortletInit object removeEventListener function throws a     */
         /* TypeError if the handle is null"                                           */
         testFunction = function () {
            hub.removeEventListener(null);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_removeEventListener3', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_removeEventListener4             */
         /* Details: "The PortletInit object removeEventListener function throws a     */
         /* TypeError if the handle is undefined"                                      */
         testFunction = function () {
            hub.removeEventListener(undefined);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_removeEventListener4', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_removeEventListener5             */
         /* Details: "The PortletInit object removeEventListener function throws a     */
         /* TypeError if the handle has an invalid value"                              */
         testFunction = function () {
            hub.removeEventListener('some invalid handle');
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_removeEventListener5', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_createResourceUrl1               */
         /* Details: "The PortletInit object createResourceUrl function throws a       */
         /* TypeError if too many (&gt;3) arguments are provided"                      */
         testFunction = function () {
            var params = hub.newParameters();
            hub.createResourceUrl(params, hub.constants.FULL, 'resid', 'invalid arg');
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_createResourceUrl1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_createResourceUrl2               */
         /* Details: "The PortletInit object createResourceUrl function throws a       */
         /* TypeError if resource parameters is invalid"                               */
         testFunction = function () {
            var params = 'invalid parameters';
            hub.createResourceUrl(params);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_createResourceUrl2', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_createResourceUrl3               */
         /* Details: "The PortletInit object createResourceUrl function throws a       */
         /* TypeError if the cacheability argument is invalid"                         */
         testFunction = function () {
            hub.createResourceUrl(null, 'invalidCacheability');
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_createResourceUrl3', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState1                  */
         /* Details: "The PortletInit object setRenderState function throws a          */
         /* TypeError if no argument is provided"                                      */
         testFunction = function () {
            hub.setRenderState();
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_setRenderState1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState2                  */
         /* Details: "The PortletInit object setRenderState function throws a          */
         /* TypeError if too many (&gt;1) arguments are provided"                      */
         testFunction = function () {
            var state = hub.newState();
            hub.setRenderState(state, 'invalid param');
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_setRenderState2', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState3                  */
         /* Details: "The PortletInit object setRenderState function throws a          */
         /* TypeError if the argument is not an object"                                */
         testFunction = function () {
            hub.setRenderState(42);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_setRenderState3', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState4                  */
         /* Details: "The PortletInit object setRenderState function throws a          */
         /* TypeError if the single argument is null"                                  */
         testFunction = function () {
            hub.setRenderState(null);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_setRenderState4', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState5                  */
         /* Details: "The PortletInit object setRenderState function throws a          */
         /* TypeError if the argument does not have a \"parameters\" property"         */
         testFunction = function () {
            var params = {};
            hub.setRenderState(params);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_setRenderState5', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState6                  */
         /* Details: "The PortletInit object setRenderState function throws a          */
         /* TypeError if the argument does not have a \"windowState\" property"        */
         testFunction = function () {
            var params = {};
            hub.setRenderState(params);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_setRenderState6', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState7                  */
         /* Details: "The PortletInit object setRenderState function throws a          */
         /* TypeError if the argument does not have a \"portletMode\" property"        */
         testFunction = function () {
            var params = {};
            hub.setRenderState(params);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_setRenderState7', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderState9                  */
         /* Details: "The PortletInit object setRenderState function throws an         */
         /* NotInitializedException if no onStateChange listener is registered"        */
         testFunction = function () {
            var state = hub.newState();
            hub.setRenderState(state);
         }
         msg = testException(testFunction, 'NotInitializedException');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_setRenderState9', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderStateA                  */
         /* Details: "The PortletInit object setRenderState function throws a          */
         /* TypeError if \"windowState\" has an invalid value"                         */
         testFunction = function () {
            var state = hub.newState();
            state.portletMode = 'BadMode';
            state.windowState = 'BadState';
            hub.setRenderState(state);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_setRenderStateA', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_setRenderStateB                  */
         /* Details: "The PortletInit object setRenderState function throws a          */
         /* TypeError if \"portletMode\" has an invalid value"                         */
         testFunction = function () {
            var state = hub.newState();
            state.portletMode = 'BadMode';
            state.windowState = 'BadState';
            hub.setRenderState(state);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_setRenderStateB', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action1                          */
         /* Details: "The PortletInit object action function throws a TypeError if too */
         /* many (&gt;2) arguments are provided"                                       */
         testFunction = function () {
            var params = hub.newParameters();
            var element = document.getElementById('PortletHubTests_SPEC_23_JSExc-dummyForm');
            hub.action(params, element, 'invalid arg');
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_action1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action2                          */
         /* Details: "The PortletInit object action function throws a TypeError if a   */
         /* single argument is null"                                                   */
         testFunction = function () {
            hub.action(null);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_action2', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action3                          */
         /* Details: "The PortletInit object action function throws a TypeError if the */
         /* element argument is null"                                                  */
         testFunction = function () {
            var params = hub.newParameters();
            hub.action(params, null);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_action3', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action4                          */
         /* Details: "The PortletInit object action function throws a TypeError if     */
         /* action parameters is null"                                                 */
         testFunction = function () {
            var element = document.getElementById('PortletHubTests_SPEC_23_JSExc-dummyForm');
            hub.action(null, element);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_action4', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action5                          */
         /* Details: "The PortletInit object action function throws a TypeError if     */
         /* action parameters is invalid"                                              */
         testFunction = function () {
            var params = 'invalid parameters';
            hub.action(params);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_action5', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action6                          */
         /* Details: "The PortletInit object action function throws a TypeError if the */
         /* element argument is invalid"                                               */
         testFunction = function () {
            var params = hub.newParameters();
            hub.action(params, 'invalid');
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_action6', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action7                          */
         /* Details: "The PortletInit object action function throws a TypeError if     */
         /* there are 2 element arguments"                                             */
         testFunction = function () {
            var element = document.getElementById('PortletHubTests_SPEC_23_JSExc-dummyForm');
            hub.action(element, element);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_action7', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_action8                          */
         /* Details: "The PortletInit object action function throws a TypeError if     */
         /* there are 2 action parameters arguments"                                   */
         testFunction = function () {
            var params = hub.newParameters();
            hub.action(params, params);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_action8', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_actionA                          */
         /* Details: "The PortletInit object action function throws an                 */
         /* NotInitializedException if no onStateChange listener is registered."       */
         testFunction = function () {
            hub.action();
         }
         msg = testException(testFunction, 'NotInitializedException');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_actionA', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_startPartialAction1              */
         /* Details: "The PortletInit object startPartialAction function throws a      */
         /* TypeError if too many (&gt;1) arguments are provided"                      */
         testFunction = function () {
            var params = hub.newParameters();
            hub.startPartialAction(params, 'invalid arg');
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_startPartialAction1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_startPartialAction2              */
         /* Details: "The PortletInit object startPartialAction function throws a      */
         /* TypeError if the single argument is null"                                  */
         testFunction = function () {
            hub.startPartialAction(null);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_startPartialAction2', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_startPartialAction3              */
         /* Details: "The PortletInit object startPartialAction function throws a      */
         /* TypeError if action parameters is invalid"                                 */
         testFunction = function () {
            var params = 'invalid parameters';
            hub.startPartialAction(params);
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_startPartialAction3', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSExc_startPartialAction4              */
         /* Details: "The PortletInit object startPartialAction function throws an     */
         /* NotInitializedException if no onStateChange listener is registered."       */
         testFunction = function () {
            hub.startPartialAction();
         }
         msg = testException(testFunction, 'NotInitializedException');
         setSuccess('V3PortletHubTests_SPEC_23_JSExc_startPartialAction4', msg);

      });
   }

   window.addEventListener('load', execute);
}());

