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

/**
 * This is Jasmine test code for the Portlet Hub.
 * <p>
 * Since the portlet hub does not get reinitialized, its state is
 * maintained throughout the testing. The tests are constructed so that
 * by the end of module execution, any listeners that are added in the 
 * earlier portions of the test are removed.
 */


describe('The portlet hub allows the portlet client to execute a portlet action',function(){
   'use strict'
   
   // get the portlet IDs provided by the system under test. The function must
   // return a string array of portlet IDs that are known to the portlet hub being 
   // tested. Portlets:
   //                private parms        public parms             Render data
   //                =============        ============             ===========
   //    portletA      parm1, parm2             -                     -   
   //    portletB      parm1, parm2       pubparm1                    -   
   //    portletC      parm1, parm2       pubparm1, pubparm2          -
   //    portletD      parm2, pubparm1    pubparm2                    -
   //    portletE      parm1, parm2       pubparm1, pubparm2          -
   //    portletF           -                   -                     -   
   var portletIds = portlet.test.getIds(),                      
       portletA = portletIds[0],                                
       portletB = portletIds[1],                                 
       portletC = portletIds[2],                                 
       portletD = portletIds[3],                                 

       // Test data provided by the portlet hub
       pageState = portlet.test.getInitData(),                  


       // Tests in thismodule need following portlets. register them.
       // These variables provide linkage between the "describe" sections
       hubA,
       hubB,
       hubC,
       hubD;
   
       
   describe('The portlet hub is initialized for the tests: ',function(){
   
       it('initializes a portlet hub instance for portlet A',function(){
          var testFunc = function () {
             return portlet.register(portletA);
          }
          var ph = new portlet.jasmine.PromiseHandler(testFunc);
          runs(ph.getRun());
          waitsFor(ph.getIsComplete(), "The PortletInit object should be returned", 1000);
          runs(ph.getChecker()); 
          runs(function() {
             expect(ph.result).toBeDefined();
          }); 
          runs(function() {
             hubA = ph.result;
          }); 
       });
       
       it('initializes a portlet hub instance for portlet B',function(){
          var testFunc = function () {
             return portlet.register(portletB);
          }
          var ph = new portlet.jasmine.PromiseHandler(testFunc);
          runs(ph.getRun());
          waitsFor(ph.getIsComplete(), "The PortletInit object should be returned", 1000);
          runs(ph.getChecker()); 
          runs(function() {
             expect(ph.result).toBeDefined();
          }); 
          runs(function() {
             hubB = ph.result;
          }); 
       });
   
       it('initializes a portlet hub instance for portlet C',function(){
          var testFunc = function () {
             return portlet.register(portletC);
          }
          var ph = new portlet.jasmine.PromiseHandler(testFunc);
          runs(ph.getRun());
          waitsFor(ph.getIsComplete(), "The PortletInit object should be returned", 1000);
          runs(ph.getChecker()); 
          runs(function() {
             expect(ph.result).toBeDefined();
          }); 
          runs(function() {
             hubC = ph.result;
          }); 
       });
       
       it('initializes a portlet hub instance for portlet D',function(){
          var testFunc = function () {
             return portlet.register(portletD);
          }
          var ph = new portlet.jasmine.PromiseHandler(testFunc);
          runs(ph.getRun());
          waitsFor(ph.getIsComplete(), "The PortletInit object should be returned", 1000);
          runs(ph.getChecker()); 
          runs(function() {
             expect(ph.result).toBeDefined();
          }); 
          runs(function() {
             hubD = ph.result;
          }); 
       });
     
   });
       
   describe('The portlet hub action function: ',function(){

      // The tests in this section use just a single portlet - portletA
      var cbA = new portlet.jasmine.JasminePortletUtils(portletA, pageState);
      
      // add an osc handler for the test
      beforeEach(function () {
         cbA.complete = false;
         runs(function() {
            cbA.oscHandle = hubA.addEventListener("portlet.onStateChange", cbA.getListener());
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            cbA.complete = false;    // in prep for the actual test
         }); 
      });
      
      // remove the osc handler added during the test
      afterEach(function () {
         if (cbA.oscHandle !== null) {
            hubA.removeEventListener(cbA.oscHandle);
            cbA.oscHandle = null;
         }
      });

      it('is present in the register return object and is a function',function(){
         expect(typeof hubA.action).toEqual('function');
      });

      it('throws a TypeError if too many (>2) arguments are provided',function(){
         var parms  = {rp1 : ["resVal"]},
             el = document.createElement("form");
         var testFunc = function () {
            hubA.action(parms, el, "parm3");
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if a single argument is null',function(){
         var testFunc = function () {
            hubA.action(null);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the element argument is null',function(){
         var parms  = {rp1 : ["resVal"]};
         var testFunc = function () {
            hubA.action(parms, null);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if action parameters  is null',function(){
         var el = document.createElement("form");
         var testFunc = function () {
            hubA.action(null, el);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

//       it('throws a TypeError if action parameters is undefined',function(){
//          var el = document.createElement("form");
//          var testFunc = function () {
//             hubA.action(undefined, el);
//          }
//          expect(testFunc).toThrowCustomException("TypeError");
//       });

      it('throws a TypeError if action parameters is invalid',function(){
         var parms  = {rp1 : "resVal"};
         var el = document.createElement("form");
         var testFunc = function () {
            hubA.action(parms, el);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the element argument is invalid',function(){
         var parms  = {rp1 : ["resVal"]};
         var el = document.createElement("form");
         var testFunc = function () {
            hubA.action(parms, "Invalid");
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if there are 2 element arguments',function(){
         var parms  = {rp1 : ["resVal"]};
         var el = document.createElement("form");
         var testFunc = function () {
            hubA.action(el, el);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if there are 2 action parameters arguments',function(){
         var parms  = {rp1 : ["resVal"]};
         var testFunc = function () {
            hubA.action(parms, parms);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('does not throw if both arguments are valid',function(){
         var parms  = {rp1 : ["resVal"]};
         var el = document.createElement("form");
         runs(function() {
            var testFunc = function () {
               hubA.action(parms, el);
            }
            expect(testFunc).not.toThrow();
         }); 
         waits(10);  // give it a chance to call its onStateChange
      });

      it('throws an AccessDeniedException if action is called twice',function(){
         var parms  = {rp1 : ["resVal"]};
         var el = document.createElement("form");
         runs(function() {
            var testFunc = function () {
               hubA.action(parms, el);
               hubA.action(parms, el);
            }
            expect(testFunc).toThrowCustomException("AccessDeniedException");
         }); 
         waits(10);  // give it a chance to call its onStateChange
      });

      it('throws an NotInitializedException if no onStateChange listener is registered.',function(){
         var parms  = {rp1 : ["resVal"]};
         var el = document.createElement("form");
         runs(function() {
            var testFunc = function () {
               hubB.action(parms, el);
            }
            expect(testFunc).toThrowCustomException("NotInitializedException");
         }); 
         waits(10);  // give it a chance to call its onStateChange
      });

      it('causes the onStateChange listener to be called and state is as expected',function(){
         var parms  = {rp1 : ["resVal"]}, str, states, stateA;
         var el = document.createElement("form");
         runs(function() {
            hubA.action(el, parms);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            str = portlet.test.data.updateStrings[portletA];
            states = portlet.test.decodeUpdateString(str, portletA);
            stateA = hubA.newState(states[portletA]);
            expect(cbA.retRenderState).toEqual(stateA);
         }); 
      });
      
      it('allows a resource URL to be created containing the render state',function(){
         var parms  = {rp1 : ["resVal"], rp2 : ["resVal2"]}, cache="cacheLevelPage", url, str;
         var testFunc = function () {
            return hubA.createResourceUrl(parms, cache);
         }
         var ph = new portlet.jasmine.PromiseHandler(testFunc, false);
         runs(ph.getRun());
         waitsFor(ph.getIsComplete(), "The promise from createResourceUrl is settled.", 1000);
         runs(ph.getChecker()); 
         runs(function() {
            url = ph.result;
            str = portlet.test.resource.getState(url, portletA);
            expect(str).toEqual(cbA.getState());
         }); 
      });
          
   });
   
   
   describe('The portlet hub actions affect multiple portlets: ',function(){

      // Make sure it works for more than one portlet 
      
      var cbA = new portlet.jasmine.JasminePortletUtils(portletB, pageState);
      var cbB = new portlet.jasmine.JasminePortletUtils(portletB, pageState);
      var cbC = new portlet.jasmine.JasminePortletUtils(portletC, pageState);
      var cbD = new portlet.jasmine.JasminePortletUtils(portletD, pageState);
      
      // add an osc handler for the test
      beforeEach(function () {
         cbA.complete = false;
         cbB.complete = false;
         cbC.complete = false;
         cbD.complete = false;
         runs(function() {
            cbA.oscHandle = hubA.addEventListener("portlet.onStateChange", cbA.getListener());
            cbB.oscHandle = hubB.addEventListener("portlet.onStateChange", cbB.getListener());
            cbC.oscHandle = hubC.addEventListener("portlet.onStateChange", cbC.getListener());
            cbD.oscHandle = hubD.addEventListener("portlet.onStateChange", cbD.getListener());
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbD.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            cbA.complete = false;    // in prep for the actual test
            cbB.complete = false;    // in prep for the actual test
            cbC.complete = false;    // in prep for the actual test
            cbD.complete = false;    // in prep for the actual test
         }); 
      });
      
      // remove the osc handler added during the test
      afterEach(function () {
         if (cbA.oscHandle !== null) {
            hubA.removeEventListener(cbA.oscHandle);
            cbA.oscHandle = null;
         }
         if (cbB.oscHandle !== null) {
            hubB.removeEventListener(cbB.oscHandle);
            cbB.oscHandle = null;
         }
         if (cbC.oscHandle !== null) {
            hubC.removeEventListener(cbC.oscHandle);
            cbC.oscHandle = null;
         }
         if (cbD.oscHandle !== null) {
            hubD.removeEventListener(cbD.oscHandle);
            cbD.oscHandle = null;
         }
      });

      it('throws an AccessDeniedException if called before previous action completes',function(){
         var parms  = {rp1 : ["resVal"]};
         var el = document.createElement("form");
         runs(function() {
            var testFunc = function () {
               hubA.action(parms, el);
            }
            expect(testFunc).not.toThrow();
         }); 
         runs(function() {
            var testFunc = function () {
               hubB.action(parms, el);
            }
            expect(testFunc).toThrowCustomException("AccessDeniedException");
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
      });
      
      it('allows actions that update the state of 2 portlets. other portlets are not updated',function(){
         var parms  = {rp1 : ["resVal"]}, str, states, state;
         var el = document.createElement("form");
         runs(function() {
            hubB.action(el, parms);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            str = portlet.test.data.updateStrings[portletB];
            states = portlet.test.decodeUpdateString(str, portletB);
            state = hubB.newState(states[portletB]);
            expect(cbB.retRenderState).toEqual(state);
            state = hubC.newState(states[portletC]);
            expect(cbC.retRenderState).toEqual(state);
            expect(cbA.isComplete()).toBeFalsy();
            expect(cbD.isComplete()).toBeFalsy();
         }); 
      });
      
      it('allows actions that update the state of several portlets. The state of each is as expected.',function(){
         var parms  = {rp1 : ["resVal"]}, str, states, state;
         var el = document.createElement("form");
         runs(function() {
            hubC.action(el, parms);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbD.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            
            str = portlet.test.data.updateStrings[portletC];
            states = portlet.test.decodeUpdateString(str, portletC);
            
            state = hubA.newState(states[portletA]);
            expect(cbA.retRenderState).toEqual(state);
            
            state = hubB.newState(states[portletB]);
            expect(cbB.retRenderState).toEqual(state);
            
            state = hubC.newState(states[portletC]);
            expect(cbC.retRenderState).toEqual(state);
            
            state = hubD.newState(states[portletD]);
            expect(cbD.retRenderState).toEqual(state);
         
         }); 
      });
      
   });

});