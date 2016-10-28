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
   var portletName = 'PortletHubTests_SPEC_23_JSURL', msg;

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
      var update, testFunction, hub, myPromise, doUpdate = false, doResolve, doReject,
          pid = tck.PortletHubTests_SPEC_23_JSURL.pid;
      
      function doPromise (resolve, reject) {
         doResolve = resolve;
         doReject = reject;
         doUpdate = true;
      }
      
      function doCreateUrl (createFunction, tc, expectFull) {

         // set up initial conditions
         var state = hub.newState();
         state.setValue('testcase', tc);
         hub.setRenderState(state);
         
         // when the initial conditions are ready, do the action
         myPromise = new Promise(doPromise);
         myPromise.then(function () {
            createFunction().then(function (url) {
               var xhr = new XMLHttpRequest();
               xhr.onreadystatechange = function () {
                  var status;
                  if (xhr.readyState === 4) {
                     msg = null;
                     if (xhr.status === 200) {
                        if (xhr.responseText.length > 0) {
                           status = xhr.responseText;
                           if (status !== 'OK') {
                              if (!expectFull || status !== 'OK cacheLevelFull') {
                                 msg = status;
                              }
                           }
                        } else {
                           msg = 'Failed. No response from server.';
                        }
                     } else {
                        msg = 'Bad response status: ' + xhr.status; 
                     }
                     setSuccess(tc, msg);
                  }
               };
               xhr.open("GET",url,true);
               xhr.send();
            });
         });

      }

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl1               */
      /* Details: "The portlet hub createResourceUrl function returns a string if   */
      /* called with no arguments"                                                  */
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl1-clickme').onclick = function () {
         doCreateUrl(function () {
            return hub.createResourceUrl();
         }, 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl1');
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl1-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl2               */
      /* Details: "The portlet hub createResourceUrl function returns a string if   */
      /* called with a resource parameters argument"                                */
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl2-clickme').onclick = function () {
         doCreateUrl(function () {
            var p = hub.newParameters();
            p.param1 = ['val1'];
            return hub.createResourceUrl(p);
         }, 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl2');
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl2-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl3               */
      /* Details: "The portlet hub createResourceUrl function returns a string if   */
      /* called with resource parameters and cacheability arguments"                */
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl3-clickme').onclick = function () {
         doCreateUrl(function () {
            var p = hub.newParameters();
            p.param1 = ['val1'];
            return hub.createResourceUrl(p, hub.constants.PAGE);
         }, 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl3');
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl3-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl4               */
      /* Details: "The portlet hub createResourceUrl function returns a string if   */
      /* called with resource parameters, cacheability, and resource ID arguments"  */
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl4-clickme').onclick = function () {
         doCreateUrl(function () {
            var p = hub.newParameters();
            p.param1 = ['val1'];
            return hub.createResourceUrl(p, hub.constants.PAGE, 'resourceId');
         }, 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl4');
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl4-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl5               */
      /* Details: "The portlet hub createResourceUrl function returns a string if   */
      /* called with a resource ID argument and with the resource parameters and    */
      /* cacheability arguments null "                                              */
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl5-clickme').onclick = function () {
         doCreateUrl(function () {
            return hub.createResourceUrl(null, null, 'resourceId');
         }, 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl5');
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl5-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl6               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* cacheability set to \"cacheLevelPage\""                                    */
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl6-clickme').onclick = function () {
         doCreateUrl(function () {
            var p = hub.newParameters();
            p.param1 = ['val1'];
            return hub.createResourceUrl(p, hub.constants.PAGE);
         }, 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl6');
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl6-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl7               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* cacheability set to \"cacheLevelPortlet\""                                 */
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl7-clickme').onclick = function () {
         doCreateUrl(function () {
            var p = hub.newParameters();
            p.param1 = ['val1'];
            return hub.createResourceUrl(p, hub.constants.PORTLET);
         }, 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl7');
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl7-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl8               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* cacheability set to \"cacheLevelFull\""                                    */
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl8-clickme').onclick = function () {
         doCreateUrl(function () {
            return hub.createResourceUrl(null, hub.constants.FULL);
         }, 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl8', true);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl8-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl9               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* the resource parameters set as expected"                                   */
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl9-clickme').onclick = function () {
         doCreateUrl(function () {
            var p = hub.newParameters();
            p.param1 = ['val1'];
            return hub.createResourceUrl(p);
         }, 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl9');
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl9-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl0               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* multivalued resource parameters set as expected"                           */
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl0-clickme').onclick = function () {
         doCreateUrl(function () {
            var p = hub.newParameters();
            p.param1 = ['val1', 'val2'];
            return hub.createResourceUrl(p);
         }, 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl0');
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrl0-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlA               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* multivalued resource parameters containing null set as expected"           */
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrlA-clickme').onclick = function () {
         doCreateUrl(function () {
            var p = hub.newParameters();
            p.param1 = ['val1', 'val2', null];
            return hub.createResourceUrl(p);
         }, 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrlA');
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrlA-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlB               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* the render state set when cacheability = cacheLevelPage"                   */
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrlB-clickme').onclick = function () {
         doCreateUrl(function () {
            var p = hub.newParameters();
            p.param1 = ['val1'];
            return hub.createResourceUrl(p, hub.constants.PAGE);
         }, 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrlB');
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrlB-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlC               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with    */
      /* the render state set when cacheability = cacheLevelPortlet"                */
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrlC-clickme').onclick = function () {
         doCreateUrl(function () {
            var p = hub.newParameters();
            p.param1 = ['val1'];
            return hub.createResourceUrl(p, hub.constants.PORTLET);
         }, 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrlC');
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrlC-notready').id='ready';

      /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlD               */
      /* Details: "The portlet hub createResourceUrl function returns a URL with no */
      /* render state set when cacheability = cacheLevelFull"                       */
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrlD-clickme').onclick = function () {
         doCreateUrl(function () {
            var p = hub.newParameters();
            p.param1 = ['val1'];
            return hub.createResourceUrl(p, hub.constants.FULL);
         }, 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrlD', true);
      }
      document.getElementById('V3PortletHubTests_SPEC_23_JSURL_createResourceUrlD-notready').id='ready';

      update = function (type, state) {
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl1               */
         /* Details: "The portlet hub createResourceUrl function returns a string if   */
         /* called with no arguments"                                                  */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl1') {
            if (doUpdate) {
               doUpdate = false;
               doResolve();
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl2               */
         /* Details: "The portlet hub createResourceUrl function returns a string if   */
         /* called with a resource parameters argument"                                */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl2') {
            if (doUpdate) {
               doUpdate = false;
               doResolve();
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl3               */
         /* Details: "The portlet hub createResourceUrl function returns a string if   */
         /* called with resource parameters and cacheability arguments"                */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl3') {
            if (doUpdate) {
               doUpdate = false;
               doResolve();
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl4               */
         /* Details: "The portlet hub createResourceUrl function returns a string if   */
         /* called with resource parameters, cacheability, and resource ID arguments"  */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl4') {
            if (doUpdate) {
               doUpdate = false;
               doResolve();
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl5               */
         /* Details: "The portlet hub createResourceUrl function returns a string if   */
         /* called with a resource ID argument and with the resource parameters and    */
         /* cacheability arguments null "                                              */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl5') {
            if (doUpdate) {
               doUpdate = false;
               doResolve();
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl6               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* cacheability set to \"cacheLevelPage\""                                    */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl6') {
            if (doUpdate) {
               doUpdate = false;
               doResolve();
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl7               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* cacheability set to \"cacheLevelPortlet\""                                 */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl7') {
            if (doUpdate) {
               doUpdate = false;
               doResolve();
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl8               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* cacheability set to \"cacheLevelFull\""                                    */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl8') {
            if (doUpdate) {
               doUpdate = false;
               doResolve();
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl9               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* the resource parameters set as expected"                                   */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl9') {
            if (doUpdate) {
               doUpdate = false;
               doResolve();
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrl0               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* multivalued resource parameters set as expected"                           */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrl0') {
            if (doUpdate) {
               doUpdate = false;
               doResolve();
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlA               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* multivalued resource parameters containing null set as expected"           */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrlA') {
            if (doUpdate) {
               doUpdate = false;
               doResolve();
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlB               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* the render state set when cacheability = cacheLevelPage"                   */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrlB') {
            if (doUpdate) {
               doUpdate = false;
               doResolve();
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlC               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with    */
         /* the render state set when cacheability = cacheLevelPortlet"                */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrlC') {
            if (doUpdate) {
               doUpdate = false;
               doResolve();
            }
         }
   
         /* TestCase: V3PortletHubTests_SPEC_23_JSURL_createResourceUrlD               */
         /* Details: "The portlet hub createResourceUrl function returns a URL with no */
         /* render state set when cacheability = cacheLevelFull"                       */
         if (state.getValue('testcase') === 'V3PortletHubTests_SPEC_23_JSURL_createResourceUrlD') {
            if (doUpdate) {
               doUpdate = false;
               doResolve();
            }
         }

      }

      portlet.register(pid).then(function (pi) {
         hub = pi;
         hub.addEventListener('portlet.onStateChange', update);
      });
   }

   window.addEventListener('load', execute);
}());

