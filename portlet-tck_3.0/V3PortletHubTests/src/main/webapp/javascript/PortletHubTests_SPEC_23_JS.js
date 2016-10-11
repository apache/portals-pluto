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
   var portletName = 'PortletHubTests_SPEC_23_JS', msg;

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
          pid = tck.PortletHubTests_SPEC_23_JS.pid;

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register1                           */
      /* Details: "The portlet hub provides a global namespace var portlet of type  */
      /* object"                                                                    */
      if (typeof portlet === 'object') {
         setSuccess('V3PortletHubTests_SPEC_23_JS_register1');
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register2                           */
      /* Details: "The global portlet object register property is type function"    */
      if (typeof portlet.register === 'function') {
         setSuccess('V3PortletHubTests_SPEC_23_JS_register2');
      }

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register3                           */
      /* Details: "The portlet hub register function throws a TypeError if no       */
      /* portlet ID argument is provided"                                           */
      testFunction = function () {
         portlet.register();
      }
      msg = testException(testFunction, "TypeError");
      setSuccess('V3PortletHubTests_SPEC_23_JS_register3', msg);

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register4                           */
      /* Details: "The portlet hub register function throws a TypeError if too many */
      /* (&gt;1) arguments are provided"                                            */
      testFunction = function () {
         portlet.register("InvalidPortletID1", "InvalidPortletID2");
      }
      msg = testException(testFunction, "TypeError");
      setSuccess('V3PortletHubTests_SPEC_23_JS_register4', msg);

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register5                           */
      /* Details: "The portlet hub register function throws a TypeError if the      */
      /* portlet ID is not a string"                                                */
      testFunction = function () {
         portlet.register(89);
      }
      msg = testException(testFunction, "TypeError");
      setSuccess('V3PortletHubTests_SPEC_23_JS_register5', msg);

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register6                           */
      /* Details: "The portlet hub register function throws a TypeError if the      */
      /* portlet ID is undefined"                                                   */
      testFunction = function () {
         portlet.register(undefined);
      }
      msg = testException(testFunction, "TypeError");
      setSuccess('V3PortletHubTests_SPEC_23_JS_register6', msg);

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register7                           */
      /* Details: "The portlet hub register function throws a TypeError if the      */
      /* portlet ID is null"                                                        */
      testFunction = function () {
         portlet.register(null);
      }
      msg = testException(testFunction, "TypeError");
      setSuccess('V3PortletHubTests_SPEC_23_JS_register7', msg);

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register8                           */
      /* Details: "The portlet hub register function The promise fails if the       */
      /* portlet ID is not defined for the portlet hub"                             */
      try {
        portlet.register("invalidPortletID").then( 
             function (pi) {
             }, 
             function (err) {
                setSuccess('V3PortletHubTests_SPEC_23_JS_register8');
             } 
          );
      } catch (e) {}

      update = function (type, state) {

      }

      portlet.register(pid).then(function (pi) {
         hub = pi;
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_register9                           */
         /* Details: "The portlet hub register function returns a PortletInit object   */
         /* when provided with a valid portlet ID"                                     */
         if (typeof hub === 'object') {
            setSuccess('V3PortletHubTests_SPEC_23_JS_register9');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit1                        */
         /* Details: "The PortletInit object portletModes property is an array"        */
         if (Array.isArray(hub.portletModes)) {
            setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit1');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit2                        */
         /* Details: "The PortletInit object windowStates property is an array"        */
         if (Array.isArray(hub.windowStates)) {
            setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit2');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit3                        */
         /* Details: "The PortletInit object action property is type function"         */
         if (typeof hub.action === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit3');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit4                        */
         /* Details: "The PortletInit object addEventListener property is type         */
         /* function"                                                                  */
         if (typeof hub.addEventListener === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit4');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit5                        */
         /* Details: "The PortletInit object createResourceUrl property is type        */
         /* function"                                                                  */
         if (typeof hub.createResourceUrl === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit5');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit6                        */
         /* Details: "The PortletInit object dispatchClientEvent property is type      */
         /* function"                                                                  */
         if (typeof hub.dispatchClientEvent === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit6');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit7                        */
         /* Details: "The PortletInit object isInProgress property is type function"   */
         if (typeof hub.isInProgress === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit7');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit8                        */
         /* Details: "The PortletInit object newParameters property is type function"  */
         if (typeof hub.newParameters === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit8');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit9                        */
         /* Details: "The PortletInit object newState property is type function"       */
         if (typeof hub.newState === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit9');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInitA                        */
         /* Details: "The PortletInit object removeEventListener property is type      */
         /* function"                                                                  */
         if (typeof hub.removeEventListener === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInitA');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInitB                        */
         /* Details: "The PortletInit object setRenderState property is type function" */
         if (typeof hub.setRenderState === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInitB');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInitC                        */
         /* Details: "The PortletInit object startPartialAction property is type       */
         /* function"                                                                  */
         if (typeof hub.startPartialAction === 'function') {
            setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInitC');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInitD                        */
         /* Details: "The PortletInit object constants property is type object"        */
         if (typeof hub.constants === 'object') {
            setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInitD');
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants1                          */
         /* Details: "The Constants object VIEW property is type string and equal to   */
         /* 'view'"                                                                    */
         if (typeof hub.constants.VIEW === 'string') {
            if (hub.constants.VIEW === 'view') {
              setSuccess('V3PortletHubTests_SPEC_23_JS_Constants1');
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants2                          */
         /* Details: "The Constants object EDIT property is type string and equal to   */
         /* 'edit'"                                                                    */
         if (typeof hub.constants.EDIT === 'string') {
            if (hub.constants.EDIT === 'edit') {
              setSuccess('V3PortletHubTests_SPEC_23_JS_Constants2');
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants3                          */
         /* Details: "The Constants object HELP property is type string and equal to   */
         /* 'help'"                                                                    */
         if (typeof hub.constants.HELP === 'string') {
            if (hub.constants.HELP === 'help') {
              setSuccess('V3PortletHubTests_SPEC_23_JS_Constants3');
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants4                          */
         /* Details: "The Constants object NORMAL property is type string and equal to */
         /* 'normal'"                                                                  */
         if (typeof hub.constants.NORMAL === 'string') {
            if (hub.constants.NORMAL === 'normal') {
              setSuccess('V3PortletHubTests_SPEC_23_JS_Constants4');
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants5                          */
         /* Details: "The Constants object MINIMIZED property is type string and equal */
         /* to 'minimized'"                                                            */
         if (typeof hub.constants.MINIMIZED === 'string') {
            if (hub.constants.MINIMIZED === 'minimized') {
              setSuccess('V3PortletHubTests_SPEC_23_JS_Constants5');
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants6                          */
         /* Details: "The Constants object MAXIMIZED property is type string and equal */
         /* to 'maximized'"                                                            */
         if (typeof hub.constants.MAXIMIZED === 'string') {
            if (hub.constants.MAXIMIZED === 'maximized') {
              setSuccess('V3PortletHubTests_SPEC_23_JS_Constants6');
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants7                          */
         /* Details: "The Constants object FULL property is type string and equal to   */
         /* 'cacheLevelFull'"                                                          */
         if (typeof hub.constants.FULL === 'string') {
            if (hub.constants.FULL === 'cacheLevelFull') {
              setSuccess('V3PortletHubTests_SPEC_23_JS_Constants7');
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants8                          */
         /* Details: "The Constants object PORTLET property is type string and equal   */
         /* to 'cacheLevelPortlet'"                                                    */
         if (typeof hub.constants.PORTLET === 'string') {
            if (hub.constants.PORTLET === 'cacheLevelPortlet') {
              setSuccess('V3PortletHubTests_SPEC_23_JS_Constants8');
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants9                          */
         /* Details: "The Constants object PAGE property is type string and equal to   */
         /* 'cacheLevelPage'"                                                          */
         if (typeof hub.constants.PAGE === 'string') {
            if (hub.constants.PAGE === 'cacheLevelPage') {
              setSuccess('V3PortletHubTests_SPEC_23_JS_Constants9');
            }
         }

      });
   }

   window.addEventListener('load', execute);
}());

