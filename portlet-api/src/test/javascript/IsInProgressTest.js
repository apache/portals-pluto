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


describe('The portlet hub allows the portlet client test for a blocking operation',function(){
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

   describe('The portlet hub isInProgress function: ',function(){

      // Make sure it works for more than one portlet 

      var cbA = new portlet.jasmine.JasminePortletUtils(portletB, pageState);
      var cbB = new portlet.jasmine.JasminePortletUtils(portletB, pageState);
      var cbC = new portlet.jasmine.JasminePortletUtils(portletC, pageState);
      var cbD = new portlet.jasmine.JasminePortletUtils(portletD, pageState);

      // partial action init structure
      var pai = null;

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

      it('is present in the register return object and is a function',function(){
         expect(typeof hubA.isInProgress).toEqual('function');
      });

      it('returns a boolean value',function(){
         var retval;
         retval = hubA.isInProgress();
         expect(typeof retval).toEqual('boolean');
      });

      it('returns false if a blocking operation is not in progress',function(){
         var retval;
         retval = hubA.isInProgress();
         expect(retval).toBe(false);
      });

      it('returns false through a different hub if a blocking operation is not in progress',function(){
         var retval;
         retval = hubD.isInProgress();
         expect(retval).toBe(false);
      });

      it('returns true when a partial action has been started but setPageState has not been called',function(){
         var parms  = {ap1 : ["actionVal"]}, str, states, state;
         var ustr = portlet.test.data.updateStrings[portletB];
         runs(function() {
            pai = null;
            hubB.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            var retval;
            retval = hubB.isInProgress();
            expect(retval).toBe(true);
         }); 
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
      });

      it('returns true through a different hub when a partial action has been started but setPageState has not been called',function(){
         var parms  = {ap1 : ["actionVal"]}, str, states, state;
         var ustr = portlet.test.data.updateStrings[portletB];
         runs(function() {
            pai = null;
            hubB.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            var retval;
            retval = hubD.isInProgress();
            expect(retval).toBe(true);
         }); 
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
      });

      it('returns true when setPageState has been called but the updates have not been dispatched',function(){
         var parms  = {ap1 : ["actionVal"]}, str, states, state;
         var ustr = portlet.test.data.updateStrings[portletB];
         runs(function() {
            pai = null;
            hubB.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            pai.setPageState(ustr);
         }); 
         runs(function() {
            var retval;
            retval = hubD.isInProgress();
            expect(retval).toBe(true);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
      });

      it('returns false after setPageState updates have been dispatched',function(){
         var parms  = {ap1 : ["actionVal"]}, str, states, state;
         var ustr = portlet.test.data.updateStrings[portletB];
         runs(function() {
            pai = null;
            hubB.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            pai.setPageState(ustr);
         }); 
         runs(function() {
            var retval;
            retval = hubD.isInProgress();
            expect(retval).toBe(true);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            var retval;
            retval = hubD.isInProgress();
            expect(retval).toBe(false);
         }); 
      });

      it('returns false after setPageState updates have been dispatched',function(){
         var parms  = {ap1 : ["actionVal"]}, str, states, state;
         var ustr = portlet.test.data.updateStrings[portletB];
         runs(function() {
            pai = null;
            hubB.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            pai.setPageState(ustr);
         }); 
         runs(function() {
            var retval;
            retval = hubD.isInProgress();
            expect(retval).toBe(true);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            var retval;
            retval = hubD.isInProgress();
            expect(retval).toBe(false);
         }); 
      });

      it('returns false through a different hub after setPageState updates have been dispatched',function(){
         var parms  = {ap1 : ["actionVal"]}, str, states, state;
         var ustr = portlet.test.data.updateStrings[portletB];
         runs(function() {
            pai = null;
            hubB.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            pai.setPageState(ustr);
         }); 
         runs(function() {
            var retval;
            retval = hubD.isInProgress();
            expect(retval).toBe(true);
         }); 
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            var retval;
            retval = hubD.isInProgress();
            expect(retval).toBe(false);
         }); 
      });

      it('returns true when action has been called but the updates have not been dispatched',function(){
         var parms  = {ap1 : ["actionVal"]};
         var el = document.createElement("form");
         runs(function() {
            var testFunc = function () {
               hubB.action(parms, el);
            }
            expect(testFunc).not.toThrow();
         }); 
         runs(function() {
            var retval;
            retval = hubD.isInProgress();
            expect(retval).toBe(true);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
      });

      it('returns true through a different hub when action has been called but the updates have not been dispatched',function(){
         var parms  = {ap1 : ["actionVal"]};
         var el = document.createElement("form");
         runs(function() {
            var testFunc = function () {
               hubB.action(parms, el);
            }
            expect(testFunc).not.toThrow();
         }); 
         runs(function() {
            var retval;
            retval = hubD.isInProgress();
            expect(retval).toBe(true);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
      });

      it('returns false after action updates have been dispatched',function(){
         var parms  = {ap1 : ["actionVal"]};
         var el = document.createElement("form");
         runs(function() {
            var testFunc = function () {
               hubB.action(parms, el);
            }
            expect(testFunc).not.toThrow();
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            var retval;
            retval = hubC.isInProgress();
            expect(retval).toBe(false);
         }); 
      });

      it('returns true when setRenderState has been called but the updates have not been dispatched',function(){
         var parms  = {ap1 : ["actionVal"]};
         runs(function() {
            var state = cbC.getState();
            state.parameters["someparm1"] = ["NewVal"];
            var testFunc = function () {
               hubC.setRenderState(state);
            }
            expect(testFunc).not.toThrow();
         }); 
         runs(function() {
            var retval;
            retval = hubD.isInProgress();
            expect(retval).toBe(true);
         }); 
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
      });

      it('returns true through a different hub when setRenderState has been called but the updates have not been dispatched',function(){
         var parms  = {ap1 : ["actionVal"]};
         runs(function() {
            var state = cbC.getState();
            state.parameters["someparm1"] = ["NewVal"];
            var testFunc = function () {
               hubC.setRenderState(state);
            }
            expect(testFunc).not.toThrow();
         }); 
         runs(function() {
            var retval;
            retval = hubD.isInProgress();
            expect(retval).toBe(true);
         }); 
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
      });

      it('returns false after setRenderState updates have been dispatched',function(){
         var parms  = {ap1 : ["actionVal"]};
         runs(function() {
            var state = cbC.getState();
            state.parameters["someparm1"] = ["NewVal"];
            var testFunc = function () {
               hubC.setRenderState(state);
            }
            expect(testFunc).not.toThrow();
         }); 
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            var retval;
            retval = hubA.isInProgress();
            expect(retval).toBe(false);
         }); 
      });

   });

});
