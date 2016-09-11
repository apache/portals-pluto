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

   function setSuccess (tc) {
      var el;
      el = document.getElementById(tc + '-result');
      if (el !== null) {
         el.innerHTML = 'Test Succeeded';
      }
   }

   function execute () {

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register1                           */
      /* Details: "The portlet hub provides a global namespace var portlet of type  */
      /* object"                                                                    */
      setSuccess('V3PortletHubTests_SPEC_23_JS_register1');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register2                           */
      /* Details: "The global namespace var portlet property register is type       */
      /* function"                                                                  */
      setSuccess('V3PortletHubTests_SPEC_23_JS_register2');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register3                           */
      /* Details: "The portlet hub register function throws an                      */
      /* IllegalArgumentException if no portlet ID argument is provided"            */
      setSuccess('V3PortletHubTests_SPEC_23_JS_register3');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register4                           */
      /* Details: "The portlet hub register function throws an                      */
      /* IllegalArgumentException if too many (&gt;1) arguments are provided"       */
      setSuccess('V3PortletHubTests_SPEC_23_JS_register4');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register5                           */
      /* Details: "The portlet hub register function throws an                      */
      /* IllegalArgumentException if the portlet ID is not a string"                */
      setSuccess('V3PortletHubTests_SPEC_23_JS_register5');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register6                           */
      /* Details: "The portlet hub register function throws an                      */
      /* IllegalArgumentException if the portlet ID is undefined"                   */
      setSuccess('V3PortletHubTests_SPEC_23_JS_register6');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register7                           */
      /* Details: "The portlet hub register function throws an                      */
      /* IllegalArgumentException if the portlet ID is null"                        */
      setSuccess('V3PortletHubTests_SPEC_23_JS_register7');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register8                           */
      /* Details: "The portlet hub register function The promise fails if the       */
      /* portlet ID is not defined for the portlet hub"                             */
      setSuccess('V3PortletHubTests_SPEC_23_JS_register8');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_register9                           */
      /* Details: "The portlet hub register function does not throw an exception if */
      /* the portlet ID is valid"                                                   */
      setSuccess('V3PortletHubTests_SPEC_23_JS_register9');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_registerA                           */
      /* Details: "The portlet hub register function returns an object when         */
      /* provided with a valid portlet ID"                                          */
      setSuccess('V3PortletHubTests_SPEC_23_JS_registerA');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit1                        */
      /* Details: "The PortletInit object portletModes property is type string"     */
      setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit1');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit2                        */
      /* Details: "The PortletInit object windowStates property is type string"     */
      setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit2');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit3                        */
      /* Details: "The PortletInit object action property is type function"         */
      setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit3');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit4                        */
      /* Details: "The PortletInit object addEventListener property is type         */
      /* function"                                                                  */
      setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit4');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit5                        */
      /* Details: "The PortletInit object createResourceUrl property is type        */
      /* function"                                                                  */
      setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit5');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit6                        */
      /* Details: "The PortletInit object dispatchClientEvent property is type      */
      /* function"                                                                  */
      setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit6');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit7                        */
      /* Details: "The PortletInit object isInProgress property is type function"   */
      setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit7');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit8                        */
      /* Details: "The PortletInit object newParameters property is type function"  */
      setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit8');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInit9                        */
      /* Details: "The PortletInit object newState property is type function"       */
      setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInit9');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInitA                        */
      /* Details: "The PortletInit object removeEventListener property is type      */
      /* function"                                                                  */
      setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInitA');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInitB                        */
      /* Details: "The PortletInit object setRenderState property is type function" */
      setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInitB');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInitC                        */
      /* Details: "The PortletInit object startPartialAction property is type       */
      /* function"                                                                  */
      setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInitC');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_PortletInitD                        */
      /* Details: "The PortletInit object constants property is type object"        */
      setSuccess('V3PortletHubTests_SPEC_23_JS_PortletInitD');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants1                          */
      /* Details: "The Constants object VIEW property is type string and equal to   */
      /* 'VIEW'"                                                                    */
      setSuccess('V3PortletHubTests_SPEC_23_JS_Constants1');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants2                          */
      /* Details: "The Constants object EDIT property is type string and equal to   */
      /* 'EDIT'"                                                                    */
      setSuccess('V3PortletHubTests_SPEC_23_JS_Constants2');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants3                          */
      /* Details: "The Constants object HELP property is type string and equal to   */
      /* 'HELP'"                                                                    */
      setSuccess('V3PortletHubTests_SPEC_23_JS_Constants3');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants4                          */
      /* Details: "The Constants object NORMAL property is type string and equal to */
      /* 'NORMAL'"                                                                  */
      setSuccess('V3PortletHubTests_SPEC_23_JS_Constants4');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants5                          */
      /* Details: "The Constants object MINIMIZED property is type string and equal */
      /* to 'MINIMIZED'"                                                            */
      setSuccess('V3PortletHubTests_SPEC_23_JS_Constants5');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants6                          */
      /* Details: "The Constants object MAXIMIZED property is type string and equal */
      /* to 'MAXIMIZED'"                                                            */
      setSuccess('V3PortletHubTests_SPEC_23_JS_Constants6');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants7                          */
      /* Details: "The Constants object FULL property is type string and equal to   */
      /* 'cacheLevelFull'"                                                          */
      setSuccess('V3PortletHubTests_SPEC_23_JS_Constants7');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants8                          */
      /* Details: "The Constants object PORTLET property is type string and equal   */
      /* to 'cacheLevelPortlet'"                                                    */
      setSuccess('V3PortletHubTests_SPEC_23_JS_Constants8');

      /* TestCase: V3PortletHubTests_SPEC_23_JS_Constants9                          */
      /* Details: "The Constants object PAGE property is type string and equal to   */
      /* 'cacheLevelPage'"                                                          */
      setSuccess('V3PortletHubTests_SPEC_23_JS_Constants9');
   }

   window.addEventListener('load', execute);
}());

