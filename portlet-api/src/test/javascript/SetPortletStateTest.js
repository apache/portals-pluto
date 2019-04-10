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


describe('The portlet hub allows the portlet client to set its state.',function(){
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
       
   describe('The portlet hub setRenderState function: ',function(){

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
         expect(typeof hubA.setRenderState).toEqual('function');
      });

      it('throws a TypeError if no argument is provided',function(){
         var testFunc = function () {
            hubA.setRenderState();
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if too many (>1) arguments are provided',function(){
         var testFunc = function () {
            hubA.setRenderState("parm1", "parm2");
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the argument is not an object',function(){
         var testFunc = function () {
            hubA.setRenderState(89);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the argument is null',function(){
         var testFunc = function () {
            hubA.setRenderState(null);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the argument does not have a "parameters" property',function(){
         var state = {
               portletMode : "view",
               windowState : "normal",
         };
         var testFunc = function () {
            hubA.setRenderState(state);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the argument does not have a "windowState" property',function(){
         var state = {
               parameters  : {},
               portletMode : "view",
         };
         var testFunc = function () {
            hubA.setRenderState(state);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the argument does not have a "portletMode" property',function(){
         var state = {
               parameters  : {},
               windowState : "normal",
         };
         var testFunc = function () {
            hubA.setRenderState(state);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws an AccessDeniedException if setRenderState is called twice',function(){
         var state = cbA.getState();
         var testFunc = function () {
            hubA.setRenderState(state);
            hubA.setRenderState(state);
         }
         expect(testFunc).toThrowCustomException("AccessDeniedException");
      });

      it('throws an NotInitializedException if no onStateChange listener is registered',function(){
         var state = cbA.getState();
         var testFunc = function () {
            hubB.setRenderState(state);
         }
         expect(testFunc).toThrowCustomException("NotInitializedException");
      });

      it('throws a TypeError if "windowState" has an invalid value',function(){
         var state = cbA.getState();
         state.windowState = "ABNORMAL";
         var testFunc = function () {
            hubA.setRenderState(state);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if "portletMode" has an invalid value',function(){
         var state = cbA.getState();
         state.portletMode = "ABNORMAL";
         var testFunc = function () {
            hubA.setRenderState(state);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws an NotInitializedException if the portlet client has no registered onStateChange listener',function(){
         var state = cbA.getState();
         var testFunc = function () {
            hubA.removeEventListener(cbA.oscHandle);
            cbA.oscHandle = null;
            hubA.setRenderState(state);
         }
         expect(testFunc).toThrowCustomException("NotInitializedException");
      });

      it('does not throw an Exception if the argument is correct',function(){
        var state = pageState[portletA].state;
         runs(function() {
            var testFunc = function () {
               hubA.setRenderState(state);
            }
            expect(testFunc).not.toThrow();
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
      });

      it('causes the onStateChange listener to be called',function(){
         var state = pageState[portletA].state;
         runs(function() {
            hubA.setRenderState(state);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
      });

      it('allows the portlet mode to be set to "edit"',function(){
         var state = cbA.getState();
         state.portletMode = "edit";
         runs(function() {
            hubA.setRenderState(state);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbA.retRenderState.portletMode).toEqual("edit");
         }); 
      });

      it('allows the portlet mode to be set to "view"',function(){
         var state = cbA.getState();
         state.portletMode = "view";
         runs(function() {
            hubA.setRenderState(state);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbA.retRenderState.portletMode).toEqual("view");
         }); 
      });

      it('allows the window state to be set to "maximized"',function(){
         var state = cbA.getState();
         state.windowState = "maximized";
         runs(function() {
            hubA.setRenderState(state);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbA.retRenderState.windowState).toEqual("maximized");
         }); 
      });

      it('allows the window state to be set to "normal"',function(){
         var state = cbA.getState();
         state.windowState = "normal";
         runs(function() {
            hubA.setRenderState(state);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbA.retRenderState.windowState).toEqual("normal");
         }); 
      });

      it('allows a new parameter "NewParm" to be set to "NewVal"',function(){
         var state = cbA.getState();
         state.parameters["NewParm"] = ["NewVal"];
         runs(function() {
            hubA.setRenderState(state);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbA.retRenderState.parameters["NewParm"]).toEqual(["NewVal"]);
         }); 
      });

      it('allows parameter "NewParm" to be set to ["NewVal1", "NewVal2"]',function(){
         var state = cbA.getState();
         var val = ["NewVal1", "NewVal2"];
         state.parameters["NewParm"] = val;
         runs(function() {
            hubA.setRenderState(state);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbA.retRenderState.parameters["NewParm"]).toEqual(val);
         }); 
      });

      it('allows a new parameter "NewParm" to be deleted',function(){
         var state = cbA.getState();
         delete state.parameters["NewParm"];
         runs(function() {
            hubA.setRenderState(state);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbA.retRenderState.parameters["NewParm"]).not.toEqual(["NewVal"]);
         }); 
      });

      it('allows all parameters to be deleted',function(){
         var state = cbA.getState();
         state.parameters = {};
         runs(function() {
            hubA.setRenderState(state);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            // count the parameters
            var cnt = 0, parms = cbA.retRenderState.parameters;
            for (var parm in parms) {
               if (parms.hasOwnProperty(parm)) {
                  cnt++;
               }
            }
            expect(cnt).toEqual(0);
         }); 
      });

      it('allows several parameters to be set',function(){
         var state = cbA.getState(),
             newParms = {
                  parm1 : ["Fred"],
                  parm2 : ["Wilma", "Pebbles"],
                  parm3 : ["Barney", "Betty", "Bam Bam"],
               };
         state.parameters = newParms;
         runs(function() {
            hubA.setRenderState(state);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbA.retRenderState.parameters).toEqual(hubA.newParameters(newParms));
         }); 
      });

      it('allows setting the state back to the original test data',function(){
         var state = cbA.getState();
         runs(function() {
            hubA.setRenderState(state);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbA.retRenderState).toEqual(hubA.newState(state));
         }); 
      });

   });

      
       
   describe('The portlet hub setRenderState function handles public render parameters: ',function(){

      // The tests in this section use three portlets that have public render parameters defined
      var cbB = new portlet.jasmine.JasminePortletUtils(portletB, pageState);
      var cbC = new portlet.jasmine.JasminePortletUtils(portletC, pageState);
      var cbD = new portlet.jasmine.JasminePortletUtils(portletD, pageState);
      
      // add an osc handler for the test
      beforeEach(function () {
         cbB.complete = false;
         cbC.complete = false;
         cbD.complete = false;
         runs(function() {
            cbB.oscHandle = hubB.addEventListener("portlet.onStateChange", cbB.getListener());
            cbC.oscHandle = hubC.addEventListener("portlet.onStateChange", cbC.getListener());
            cbD.oscHandle = hubD.addEventListener("portlet.onStateChange", cbD.getListener());
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbD.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            cbB.complete = false;    // in prep for the actual test
            cbC.complete = false;    // in prep for the actual test
            cbD.complete = false;    // in prep for the actual test
         }); 
      });
      
      // remove the osc handler added during the test
      afterEach(function () {
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

      it('throws an AccessDeniedException if called before previous set render state completes',function(){
         var parms  = {rp1 : ["resVal"]};
         var el = document.createElement("form");
         runs(function() {
            var state = cbB.getState();
            state.parameters["pubparm1"] = ["NewVal"];
            var testFunc = function () {
               hubB.setRenderState(state);
            }
            expect(testFunc).not.toThrow();
         }); 
         runs(function() {
            var state = cbC.getState();
            state.parameters["someparm1"] = ["NewVal"];
            var testFunc = function () {
               hubC.setRenderState(state);
            }
            expect(testFunc).toThrowCustomException("AccessDeniedException");
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
      });

      it('informs the initiating portlet (B) when public render parameter is set',function(){
         var state = cbB.getState();
         state.parameters["pubparm1"] = ["NewVal"];
         runs(function() {
            hubB.setRenderState(state);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbB.retRenderState.parameters["pubparm1"]).toEqual(["NewVal"]);
         }); 
      });

      it('informs the other affected portlet (C) when public render parameter is set',function(){
         var state = cbB.getState();
         state.parameters["pubparm1"] = ["NewVal2"];
         runs(function() {
            hubB.setRenderState(state);
         }); 
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbC.retRenderState.parameters["pubparm1"]).toEqual(["NewVal2"]);
         }); 
      });

      it('does not inform unaffected portlet (D) when public render parameter is set',function(){
         var state = cbB.getState();
         state.parameters["pubparm1"] = ["NewVal"];
         runs(function() {
            hubB.setRenderState(state);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbD.isComplete()).toBeFalsy();
         }); 
      });

      it('does not update private parameter in unaffected portlet (D) with same name as public parameter',function(){
         var state = cbC.getState();
         state.parameters["pubparm1"] = ["newVal4"];
         runs(function() {
            hubC.setRenderState(state);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbD.isComplete()).toBeFalsy();
         }); 
      });

      it('does not update PRP when private parameter with same name as PRP is changed in different portlet',function(){
         var state = cbD.getState();
         state.parameters["pubparm1"] = ["NewVal5"];
         runs(function() {
            hubD.setRenderState(state);
         }); 
         waitsFor(cbD.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbB.isComplete()).toBeFalsy();
            expect(cbC.isComplete()).toBeFalsy();
            expect(cbD.retRenderState.parameters["pubparm1"]).toEqual(["NewVal5"]);
         }); 
      });

      it('allows changing multiple PRPs and having affected portlets be notified',function(){
         var state = cbC.getState(), prp1, prp2;
         prp1 = state.parameters.pubparm1 = ["NewVal5", "NewVal6"];
         prp2 = state.parameters.pubparm2 = ["NewVal7", "NewVal8"];
         runs(function() {
            hubC.setRenderState(state);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbD.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbB.retRenderState.parameters["pubparm1"]).toEqual(prp1);
            expect(cbC.retRenderState.parameters["pubparm1"]).toEqual(prp1);
            expect(cbC.retRenderState.parameters["pubparm2"]).toEqual(prp2);
            expect(cbD.retRenderState.parameters["pubparm2"]).toEqual(prp2);
            // pubparm1 is private parm for portletD
            expect(cbD.retRenderState.parameters["pubparm1"]).not.toEqual(prp1);
         }); 
      });

      it('allows a PRP to be deleted, and it is deleted for all affected portlets',function(){
         var state = cbB.getState();
         delete state.parameters["pubparm1"];
         runs(function() {
            hubB.setRenderState(state);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbB.retRenderState.parameters["pubparm1"]).toBeUndefined();
            expect(cbC.retRenderState.parameters["pubparm1"]).toBeUndefined();
         }); 
      });

      it('allows a deleted PRP to be added again',function(){
         var state = cbB.getState();
         state.parameters["pubparm1"] = ["NewVal2", "NewVal3"];
         runs(function() {
            hubB.setRenderState(state);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbB.retRenderState.parameters["pubparm1"]).toEqual(["NewVal2", "NewVal3"]);
            expect(cbC.retRenderState.parameters["pubparm1"]).toEqual(["NewVal2", "NewVal3"]);
            expect(cbD.isComplete()).toBeFalsy();
         }); 
      });

      it('informs only affected portlets when a PRP is deleted',function(){
         var state = cbB.getState();
         delete state.parameters["pubparm1"];
         runs(function() {
            hubB.setRenderState(state);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbD.isComplete()).toBeFalsy();
         }); 
      });

      it('allows a deleted PRP to be added again through a different portlet',function(){
         var state = cbC.getState(),
             prp1 = ["NewVal10", "NewVal11"];
         state.parameters["pubparm1"] = prp1;
         runs(function() {
            hubC.setRenderState(state);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbB.retRenderState.parameters["pubparm1"]).toEqual(prp1);
            expect(cbC.retRenderState.parameters["pubparm1"]).toEqual(prp1);
            // pubparm1 is private parameter for portlet D 
            expect(cbD.isComplete()).toBeFalsy();
            expect(cbD.retRenderState.parameters["pubparm1"]).not.toEqual(prp1);
         }); 
      });

      it('allows deleting all parameters on a portlet with PRPs. All affected portlets are notified',function(){
         var state = cbC.getState();
         state.parameters = {};
         runs(function() {
            hubC.setRenderState(state);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbD.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbB.retRenderState.parameters["pubparm1"]).toBeUndefined();
            expect(cbC.retRenderState.parameters["pubparm1"]).toBeUndefined();
            expect(cbC.retRenderState.parameters["pubparm2"]).toBeUndefined();
            expect(cbD.retRenderState.parameters["pubparm2"]).toBeUndefined();
            expect(cbD.retRenderState.parameters["pubparm1"]).toBeDefined();
         }); 
      });

      it('allows adding back multiple previously deleted PRPs and having affected portlets be notified',function(){
         var state = cbC.cloneState(pageState[portletC].state);
         var prp1 = state.parameters.pubparm1;
         var prp2 = state.parameters.pubparm2;
         runs(function() {
            hubC.setRenderState(state);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbD.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(cbB.retRenderState.parameters["pubparm1"]).toEqual(prp1);
            expect(cbC.retRenderState.parameters["pubparm1"]).toEqual(prp1);
            expect(cbC.retRenderState.parameters["pubparm2"]).toEqual(prp2);
            expect(cbD.retRenderState.parameters["pubparm2"]).toEqual(prp2);
            expect(cbD.retRenderState.parameters["pubparm1"]).not.toEqual(prp1);
         }); 
      });

      it('allows setting the state back to the original test data',function(){
         var stateB = cbB.cloneState(pageState[portletB].state),
             stateC = cbC.cloneState(pageState[portletC].state),
             stateD = cbD.cloneState(pageState[portletD].state),
             prp1 = stateC.parameters.pubparm1,
             prp2 = stateC.parameters.pubparm2;
         
         runs(function() {
            hubB.setRenderState(stateB);
         }); 
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         
         runs(function() {
            hubC.setRenderState(stateC);
         }); 
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         
         runs(function() {
            hubD.setRenderState(stateD);
         }); 
         waitsFor(cbD.getIsComplete(), "The onStateChange callback should be called", 100);
         
         runs(function() {
            expect(cbB.retRenderState.parameters["pubparm1"]).toEqual(prp1);
            expect(cbC.retRenderState.parameters["pubparm1"]).toEqual(prp1);
            expect(cbC.retRenderState.parameters["pubparm2"]).toEqual(prp2);
            expect(cbD.retRenderState.parameters["pubparm2"]).toEqual(prp2);
         }); 
      });
   
   });

});