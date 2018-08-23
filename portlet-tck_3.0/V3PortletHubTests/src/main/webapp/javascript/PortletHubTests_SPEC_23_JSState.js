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
   var portletName = 'PortletHubTests_SPEC_23_JSState', msg;

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
          pid = tck.PortletHubTests_SPEC_23_JSState.pid;

      update = function (type, state) {

      }

      portlet.register(pid).then(function (pi) {
         hub = pi;
         var state, params, newState, newParams, element;

         state = hub.newState();
         params = hub.newParameters();
         element = document.getElementById('PortletHubTests_SPEC_23_JSState-dummyForm');
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_Parameters1                    */
         /* Details: "The PortletInit object newParameters function returns a          */
         /* Parameters object"                                                         */
         if (typeof params === 'object') {
           setSuccess('V3PortletHubTests_SPEC_23_JSState_Parameters1');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_Parameters2                    */
         /* Details: "The PortletInit object newParameters function returns a          */
         /* Parameters object containing no parameters"                                */
         if (Object.keys(params).length === 0) {
           setSuccess('V3PortletHubTests_SPEC_23_JSState_Parameters2');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_Parameters3                    */
         /* Details: "The PortletInit object newParameters function returns a          */
         /* Parameters object containing cloned values if passed a parameters object"  */
         params.param1 = ['val1', 'val2'];
         newParams = hub.newParameters(params);
         msg = checkParams(params, newParams);
         setSuccess('V3PortletHubTests_SPEC_23_JSState_Parameters3', msg);
         params = hub.newParameters();
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_State1                         */
         /* Details: "The PortletInit object newState function returns a State object  */
         /* "                                                                          */
         if (typeof state === 'object') {
           setSuccess('V3PortletHubTests_SPEC_23_JSState_State1');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_State2                         */
         /* Details: "The PortletInit object newState function returns a State object  */
         /* containing no parameters if not passed a State object"                     */
         if (Object.keys(state.parameters).length === 0) {
           setSuccess('V3PortletHubTests_SPEC_23_JSState_State2');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_State3                         */
         /* Details: "The PortletInit object newState function returns a State object  */
         /* containing cloned values if passed a State object"                         */
         state.parameters.param1 = ['val1', 'val2'];
         newState = hub.newState(state);
         msg = checkParams(state.parameters, newState.parameters);
         setSuccess('V3PortletHubTests_SPEC_23_JSState_State3', msg);
         state = hub.newState();
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone                          */
         /* Details: "The RenderState object clone property is type function"          */
         if (typeof state.clone === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JSState_clone');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_setPortletMode                 */
         /* Details: "The RenderState object setPortletMode property is type function" */
         if (typeof state.setPortletMode === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JSState_setPortletMode');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getPortletMode                 */
         /* Details: "The RenderState object getPortletMode property is type function" */
         if (typeof state.getPortletMode === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JSState_getPortletMode');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_setWindowState                 */
         /* Details: "The RenderState object setWindowState property is type function" */
         if (typeof state.setWindowState === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JSState_setWindowState');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getWindowState                 */
         /* Details: "The RenderState object getWindowState property is type function" */
         if (typeof state.getWindowState === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JSState_getWindowState');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_setValue                       */
         /* Details: "The RenderState object setValue property is type function"       */
         if (typeof state.setValue === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JSState_setValue');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValue                       */
         /* Details: "The RenderState object getValue property is type function"       */
         if (typeof state.getValue === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JSState_getValue');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValues                      */
         /* Details: "The RenderState object getValues property is type function"      */
         if (typeof state.getValues === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JSState_getValues');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_remove                         */
         /* Details: "The RenderState object remove property is type function"         */
         if (typeof state.remove === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JSState_remove');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_parameters                     */
         /* Details: "The RenderState object parameters property is type object"       */
         if (typeof state.parameters === 'object') {
            setSuccess('V3PortletHubTests_SPEC_23_JSState_parameters');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_portletMode                    */
         /* Details: "The RenderState object portletMode property is type string"      */
         if (typeof state.portletMode === 'string') {
            setSuccess('V3PortletHubTests_SPEC_23_JSState_portletMode');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_windowState                    */
         /* Details: "The RenderState object windowState property is type string"      */
         if (typeof state.windowState === 'string') {
            setSuccess('V3PortletHubTests_SPEC_23_JSState_windowState');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone1                         */
         /* Details: "The RenderState object clone function returns a new object       */
         /* instance"                                                                  */
         state = hub.newState();
         state.setPortletMode('view');
         state.setWindowState('normal');
         newState = state.clone();
         msg = null;
         if (state === newState) {
            msg = 'cloned object is same instance as original.';
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_clone1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone2                         */
         /* Details: "The RenderState object clone function returns a RenderState      */
         /* object with the required properties"                                       */
         state = hub.newState();
         newState = state.clone();
         msg = null;
         if (typeof newState !== 'object') {
            msg = 'Cloned state is not of type object';
         } else if (typeof newState.clone  !== 'function') {
            msg = 'clone function is not a function';
         } else if (typeof newState.setPortletMode  !== 'function') {
            msg = 'setPortletMode function is not a function';
         } else if (typeof newState.getPortletMode  !== 'function') {
            msg = 'getPortletMode function is not a function';
         } else if (typeof newState.setWindowState  !== 'function') {
            msg = 'setWindowState function is not a function';
         } else if (typeof newState.getWindowState  !== 'function') {
            msg = 'getWindowState function is not a function';
         } else if (typeof newState.setValue  !== 'function') {
            msg = 'setValue function is not a function';
         } else if (typeof newState.getValue  !== 'function') {
            msg = 'getValue function is not a function';
         } else if (typeof newState.getValues  !== 'function') {
            msg = 'getValues function is not a function';
         } else if (typeof newState.remove  !== 'function') {
            msg = 'remove function is not a function';
         } else if (typeof newState.parameters  !== 'object') {
            msg = 'parameters is not of type object';
         } else if (typeof newState.portletMode  !== 'string') {
            msg = 'portletMode is not of type string';
         } else if (typeof newState.windowState  !== 'string') {
            msg = 'windowState is not of type string';
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_clone2', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone3                         */
         /* Details: "The RenderState object clone function returns a RenderState      */
         /* object with the same portlet mode"                                         */
         state = hub.newState();
         state.setPortletMode('view');
         state.setWindowState('normal');
         newState = state.clone();
         msg = null;
         if (state.portletMode !== 'view' || state.portletMode !== newState.portletMode) {
            msg = 'Portlet mode invalid: ' + newState.portletMode;
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_clone3', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone4                         */
         /* Details: "The RenderState object clone function returns a RenderState      */
         /* object with the same window state"                                         */
         state = hub.newState();
         state.setPortletMode('view');
         state.setWindowState('normal');
         newState = state.clone();
         msg = null;
         if (state.windowState !== 'normal' || state.windowState !== newState.windowState) {
            msg = 'Window State invalid: ' + newState.windowState;
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_clone4', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone5                         */
         /* Details: "The RenderState object clone function returns a RenderState      */
         /* object with no parameters if the original had no parameters"               */
         state = hub.newState();
         state.setPortletMode('view');
         state.setWindowState('normal');
         newState = state.clone();
         msg = null;
         params = hub.newParameters();
         msg = checkParams(state.parameters, params);
         setSuccess('V3PortletHubTests_SPEC_23_JSState_clone5', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone6                         */
         /* Details: "The RenderState object clone function returns a RenderState      */
         /* object with the same single-value parameters if the original had           */
         /* single-value parameters"                                                   */
         state = hub.newState();
         state.parameters.param1 = ['val1'];
         newState = state.clone();
         msg = checkParams(state.parameters, newState.parameters);
         setSuccess('V3PortletHubTests_SPEC_23_JSState_clone6', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_clone7                         */
         /* Details: "The RenderState object clone function returns a RenderState      */
         /* object with the same multi-value parameters if the original had            */
         /* multi-value parameters"                                                    */
         state = hub.newState();
         state.parameters.param1 = ['val1', 'val2'];
         newState = state.clone();
         msg = checkParams(state.parameters, newState.parameters);
         setSuccess('V3PortletHubTests_SPEC_23_JSState_clone7', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_setPortletMode1                */
         /* Details: "The RenderState object setPortletMode function throws a          */
         /* TypeError if the argument is not a string"                                 */
         testFunction = function () {
            state.setPortletMode(function(){});
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSState_setPortletMode1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_setPortletMode2                */
         /* Details: "The RenderState object setPortletMode function sets the portlet  */
         /* mode"                                                                      */
         state.setPortletMode('help');
         msg = null;
         if (state.portletMode !== 'help') {
            msg = 'Portlet mode incorrectly set: ' + state.portletMode;
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_setPortletMode2', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getPortletMode1                */
         /* Details: "The RenderState object getPortletMode function returns the       */
         /* portlet mode"                                                              */
         state.portletMode = 'edit';
         msg = null;
         if (state.getPortletMode() !== 'edit') {
            msg = 'Portlet mode incorrectly retrieved: ' + state.getPortletMode();
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_getPortletMode1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_setWindowState1                */
         /* Details: "The RenderState object setWindowState function throws a          */
         /* TypeError if the argument is not a string"                                 */
         testFunction = function () {
            state.setWindowState(function(){});
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSState_setWindowState1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_setWindowState2                */
         /* Details: "The RenderState object setWindowState function sets the window   */
         /* state"                                                                     */
         state.setWindowState('normal');
         msg = null;
         if (state.windowState !== 'normal') {
            msg = 'Window state incorrectly set: ' + state.windowState;
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_setWindowState2', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getWindowState1                */
         /* Details: "The RenderState object getWindowState function returns the       */
         /* window state"                                                              */
         state.windowState = 'normal';
         msg = null;
         if (state.getWindowState() !== 'normal') {
            msg = 'Window state incorrectly retrieved: ' + state.getWindowState();
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_getWindowState1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_setValue1                      */
         /* Details: "The RenderState object setValue function throws a TypeError if   */
         /* the parameter name is not a string"                                        */
         testFunction = function () {
            state.setValue(null, 'val1');
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSState_setValue1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_setValue2                      */
         /* Details: "The RenderState object setValue function throws a TypeError if   */
         /* the parameter value is not a string or array"                              */
         testFunction = function () {
            state.setValue('param1', function(){});
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSState_setValue2', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_setValue3                      */
         /* Details: "The RenderState object setValue function can set a single-valued */
         /* parameter"                                                                 */
         state = hub.newState();
         params = hub.newParameters();
         msg = null;
         params.param1 = ['val1'];
         state.setValue('param1', ['val1']);
         msg = checkParams(params, state.parameters);
         setSuccess('V3PortletHubTests_SPEC_23_JSState_setValue3', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_setValue4                      */
         /* Details: "The RenderState object setValue function can set a multi-valued  */
         /* parameter"                                                                 */
         state = hub.newState();
         params = hub.newParameters();
         msg = null;
         msg = checkParams(params, state.parameters);
         setSuccess('V3PortletHubTests_SPEC_23_JSState_setValue4', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_setValue5                      */
         /* Details: "The RenderState object setValue function can set a parameter to  */
         /* null"                                                                      */
         state = hub.newState();
         params = hub.newParameters();
         msg = null;
         params.param1 = [null];
         state.setValue('param1', null);
         msg = checkParams(params, state.parameters);
         setSuccess('V3PortletHubTests_SPEC_23_JSState_setValue5', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValue1                      */
         /* Details: "The RenderState object getValue function throws a TypeError if   */
         /* the parameter name is not a string"                                        */
         testFunction = function () {
            state.getValue(function(){});
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSState_getValue1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValue2                      */
         /* Details: "The RenderState object getValue function returns a single-valued */
         /* parameter"                                                                 */
         state = hub.newState();
         msg = null;
         state.setValue('param1', ['val1']);
         if ('val1' !== state.getValue('param1')) {
            msg = 'Bad parameter value, expecting: ' + params;
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_getValue2', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValue3                      */
         /* Details: "The RenderState object getValue function returns null if the     */
         /* parameter was set to null"                                                 */
         state = hub.newState();
         msg = null;
         state.setValue('param1', null);
         if (null !== state.getValue('param1')) {
            msg = 'Bad parameter value, expecting: ' + params;
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_getValue3', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValue4                      */
         /* Details: "The RenderState object getValue function returns the first value */
         /* of a multi-valued parameter"                                               */
         state = hub.newState();
         msg = null;
         state.setValue('param1', ['val1', 'val2']);
         if ('val1' !== state.getValue('param1')) {
            msg = 'Bad parameter value, expecting: ' + params;
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_getValue4', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValue5                      */
         /* Details: "The RenderState object getValue function returns undefined if    */
         /* the parameter name does not exist and there is no default"                 */
         state = hub.newState();
         msg = null;
         if (state.getValue('param1') !== undefined) {
            msg = 'Bad parameter value, expecting: undefined, got: ' + state.getValue('param1');
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_getValue5', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValue6                      */
         /* Details: "The RenderState object getValue function returns the default if  */
         /* the parameter name does not exist and a default is provided"               */
         state = hub.newState();
         msg = null;
         if ('val1' !== state.getValue('param1', 'val1')) {
            msg = 'Bad parameter value, expecting: ' + params;
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_getValue6', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValues1                     */
         /* Details: "The RenderState object getValues function throws a TypeError if  */
         /* the parameter name is not a string"                                        */
         testFunction = function () {
            state.getValues(function(){});
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSState_getValues1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValues2                     */
         /* Details: "The RenderState object getValues function returns an array of    */
         /* strings for a multi-valued parameter"                                      */
         state = hub.newState();
         msg = null;
         params = hub.newParameters();
         newParams = hub.newParameters();
         params.param1 = ['val1', 'val2'];
         state.setValue('param1', ['val1', 'val2']);
         newParams.param1 = state.getValues('param1');
         msg = checkParams(params, newParams);
         setSuccess('V3PortletHubTests_SPEC_23_JSState_getValues2', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValues3                     */
         /* Details: "The RenderState object getValues function returns undefined if   */
         /* the parameter name does not exist and there is no default"                 */
         state = hub.newState();
         msg = null;
         if (state.getValues('param1') !== undefined) {
            msg = 'Bad parameter value, expecting: undefined, got: ' + state.getValue('param1');
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_getValues3', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_getValues4                     */
         /* Details: "The RenderState object getValues function returns the default if */
         /* the parameter name does not exist and a default is provided"               */
         state = hub.newState();
         msg = null;
         params = hub.newParameters();
         newParams = hub.newParameters();
         params.param1 = ['val1', 'val2'];
         newParams.param1 = state.getValues('param1', ['val1', 'val2']);
         msg = checkParams(params, newParams);
         setSuccess('V3PortletHubTests_SPEC_23_JSState_getValues4', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_remove1                        */
         /* Details: "The RenderState object remove function throws a TypeError if the */
         /* parameter name is not a string"                                            */
         testFunction = function () {
            state.remove(function(){});
         }
         msg = testException(testFunction, 'TypeError');
         setSuccess('V3PortletHubTests_SPEC_23_JSState_remove1', msg);
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSState_remove2                        */
         /* Details: "The RenderState object remove function removes an existing       */
         /* parameter"                                                                 */
         state = hub.newState();
         state.setValue('param1', ['val1']);
         state.remove('param1');
         msg = null;
         if (state.getValues('param1') !== undefined) {
            msg = 'Parameter was not removed, expecting: undefined, got: ' + state.getValue('param1');
         }
         setSuccess('V3PortletHubTests_SPEC_23_JSState_remove2', msg);

      });
   }

   window.addEventListener('load', execute);
}());

