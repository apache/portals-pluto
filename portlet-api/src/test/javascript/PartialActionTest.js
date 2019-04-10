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


describe('The portlet hub allows the portlet client to initiate a partial action',function(){
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


   describe('The portlet hub startPartialAction function: ',function(){

      // The tests in this section use just a single portlet - portletA
      var cbA = new portlet.jasmine.JasminePortletUtils(portletA, pageState);

      // partial action init structure
      var pai = null;

      // add an osc handler for the test
      beforeEach(function () {
         cbA.complete = false;
         runs(function() {
            cbA.oscHandle = hubA.addEventListener("portlet.onStateChange", cbA.getListener());
            cbA.oeHandle = hubA.addEventListener("portlet.onError", cbA.getListener("error"));
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            cbA.complete = false;    // in prep for the actual test
            cbA.retType = null;
            cbA.retErrorData = null;
         }); 
      });

      // remove the osc handler added during the test
      afterEach(function () {
         if (cbA.oscHandle !== null) {
            hubA.removeEventListener(cbA.oscHandle);
            cbA.oscHandle = null;
            hubA.removeEventListener(cbA.oeHandle);
            cbA.oeHandle = null;
         }
      });

      it('is present in the register return object and is a function',function(){
         expect(typeof hubA.startPartialAction).toEqual('function');
      });

      it('throws a TypeError if too many (>1) arguments are provided',function(){
         var parms  = {ap1 : ["actionVal"]};
         var testFunc = function () {
            pai = hubA.startPartialAction(parms, "parm3");
         };
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the argument is null',function(){
         var testFunc = function () {
            pai = hubA.startPartialAction(null);
         };
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if action parameters is invalid',function(){
         var parms  = {ap1 : "actionVal"};
         var testFunc = function () {
            pai = hubA.startPartialAction(parms);
         };
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws an NotInitializedException if no onStateChange listener is registered.',function(){
         var parms  = {ap1 : ["actionVal"]};
         runs(function() {
            var testFunc = function () {
               pai = hubB.startPartialAction(parms);
            }
            expect(testFunc).toThrowCustomException("NotInitializedException");
         }); 
         waits(10);  // give it a chance to call its onStateChange
      });

      it('does not throw if the argument is valid',function(){
         var parms  = {ap1 : ["actionVal"]};
         runs(function() {
            var testFunc = function () {
               pai = hubA.startPartialAction(parms);
            };
            expect(testFunc).not.toThrow();
         }); 
         waits(10);  // give it a chance to call its onStateChange
      });

      it('returns an object',function(){
         var parms  = {ap1 : ["actionVal"]};
         var testFunc = function () {
            return hubA.startPartialAction(parms);
         }
         var ph = new portlet.jasmine.PromiseHandler(testFunc, false);
         runs(ph.getRun());
         waitsFor(ph.getIsComplete(), "The promise from startPartialAction is settled.", 1000);
         runs(ph.getChecker()); 
         runs(function() {
            pai = ph.result;
            expect(typeof pai).toEqual('object');
         }); 
      });

      it('return object contains setPageState function',function(){
         expect(typeof pai.setPageState).toEqual('function');
      });

      it('return object setPageState function throws an exception if called without a parameter',function(){
         var testFunc = function () {
            pai.setPageState();
         };
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('return object setPageState function throws an exception if called with invalid type',function(){
         var testFunc = function () {
            pai.setPageState(89);
         };
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('onError event is fired if the setPageState function is called with invalid update string',function(){
         runs(function() {
            pai.setPageState("Invalid page state.");
         }); 
         waitsFor(cbA.getIsComplete(), "The onError callback should be called", 100);
         runs(function() {
            expect(cbA.retType).toEqual('portlet.onError');
            expect(cbA.retErrorData).not.toEqual(null);
         }); 
      });

      it('return object setPageState function does not throw if parameter is correct',function(){
         var ustr = portlet.test.data.updateStrings[portletA];
         var testFunc = function () {
            pai.setPageState(ustr);
         };
         expect(testFunc).not.toThrow();
         waits(10);     // give it a chance to call its onStateChange
      }); 


      it('return object setPageState function causes the onStateChange listener to be called and state is as expected',function(){
         var ustr = portlet.test.data.updateStrings[portletA];
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            var states = portlet.test.decodeUpdateString(ustr, portletA),
            stateA = hubA.newState(states[portletA]);
            expect(cbA.retRenderState).toEqual(stateA);
         }); 
      });

      it('throws an AccessDeniedException if called twice',function(){
         var parms  = {ap1 : ["actionVal"]}, pai1 = null, pai2 = null;
         var ustr = portlet.test.data.updateStrings[portletA];
         runs(function() {
            var testFunc = function () {
               hubA.startPartialAction(parms).then(function (p) {
                  pai1 = p;
               });
            };
            expect(testFunc).not.toThrow();
         });
         waitsFor(function () {return pai1 !== null;}, "The promise to settle", 100)
         runs(function() {
            var testFunc = function () {
               hubA.startPartialAction(parms).then(function (p) {
                  pai2 = p;
               });
            };
            expect(testFunc).toThrowCustomException("AccessDeniedException");
         }); 
         runs(function() {
            pai1.setPageState(ustr);
         }); 
         waits(10);  // give it a chance to call its onStateChange
      });
   });


   describe('The portlet hub partial action URLs are OK: ',function(){

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


      it('causes the onStateChange listener to be called and state is as expected',function(){
         var parms  = {ap1 : ["actionVal"]}, str, states, stateA;
         var ustr = portlet.test.data.updateStrings[portletA];
         runs(function() {
            pai = null;
            hubA.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            str = portlet.test.data.updateStrings[portletA];
            states = portlet.test.decodeUpdateString(str, portletA);
            stateA = hubA.newState(states[portletA]);
            expect(cbA.retRenderState).toEqual(stateA);
         }); 
      });

      it('return object setPageState URL indicates the initiating portlet A',function(){
         var parms  = {ap1 : ["actionVal"], ap2 : ["actionVal2"]}, id;
         var ustr = portlet.test.data.updateStrings[portletA];
         runs(function() {
            pai = null;
            hubA.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            id = portlet.test.resource.getInitiatingPortletId(pai.url);
            expect(id).toEqual(portletA);
         }); 
      });

      it('return object setPageState URL indicates a different initiating portlet B',function(){
         var parms  = {ap1 : ["actionVal"], ap2 : ["actionVal2"]}, id;
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
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            id = portlet.test.resource.getInitiatingPortletId(pai.url);
            expect(id).toEqual(portletB);
         }); 
      });

      it('returns a partial action URL',function(){
         var parms  = {ap1 : ["actionVal"], ap2 : ["actionVal2"]}, url;
         var ustr = portlet.test.data.updateStrings[portletA];
         runs(function() {
            pai = null;
            hubA.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            expect(portlet.test.action.isPartialActionUrl(pai.url)).toBeTruthy();
         }); 
      });

      it('return object setPageState URL has the action parameters set as expected',function(){
         var parms  = {ap1 : ["actionVal"], ap2 : ["actionVal2"]}, str;
         var ustr = portlet.test.data.updateStrings[portletA];
         runs(function() {
            pai = null;
            hubA.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            str = portlet.test.action.getActionParms(pai.url);
            expect(str).toEqual(parms);
         }); 
      });

      it('return object setPageState URL has multivalued action parameters set as expected',function(){
         var parms  = {ap1 : ["actionVal", "actionVal1"], ap2 : ["actionVal2"]}, str;
         var ustr = portlet.test.data.updateStrings[portletA];
         runs(function() {
            pai = null;
            hubA.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            str = portlet.test.action.getActionParms(pai.url);
            expect(str).toEqual(parms);
         }); 
      });

      it('return object setPageState URL has multivalued action parameters containing null set as expected',function(){
         var parms  = {ap1 : ["actionVal", null, "actionVal1"], ap2 : ["actionVal2"]}, str;
         var ustr = portlet.test.data.updateStrings[portletA];
         runs(function() {
            pai = null;
            hubA.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            str = portlet.test.action.getActionParms(pai.url);
            expect(str).toEqual(parms);
         }); 
      });

      it('return object setPageState URL has null action parameter set as expected',function(){
         var parms  = {ap1 : ["actionVal"], ap2 : [null]}, str;
         var ustr = portlet.test.data.updateStrings[portletA];
         runs(function() {
            pai = null;
            hubA.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            str = portlet.test.action.getActionParms(pai.url);
            expect(str).toEqual(parms);
         }); 
      });

      it('return object setPageState URL has no action parameters when none are added',function(){
         var parms  = {}, str;
         var ustr = portlet.test.data.updateStrings[portletA];
         runs(function() {
            pai = null;
            hubA.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            str = portlet.test.action.getActionParms(pai.url);
            expect(str).toEqual(parms);
         }); 
      });

      it('allows a resource URL to be created containing the render state',function(){
         var parms  = {ap1 : ["actionVal"], ap2 : ["actionVal2"]}, 
             cache="cacheLevelPage", url = null, str;
         runs(function() {
            hubA.createResourceUrl(parms, cache).then(function (u) {
               url = u;
            });
         }); 
         waitsFor(function () {return (url !== null);}, "The promise to settle", 100)
         runs(function() {
            str = portlet.test.resource.getState(url, portletA);
            expect(str).toEqual(cbA.getState());
         }); 
      });

   });


   describe('The portlet hub startPartialAction & setPageState functions: ',function(){

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

      it('allows actions that update the state of 2 portlets. other portlets are not updated',function(){
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
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {
            states = portlet.test.decodeUpdateString(ustr, portletB);
            state = hubA.newState(states[portletB]);
            expect(cbB.retRenderState).toEqual(state);
            state = hubC.newState(states[portletC]);
            expect(cbC.retRenderState).toEqual(state);
            expect(cbA.isComplete()).toBeFalsy();
            expect(cbD.isComplete()).toBeFalsy();
         }); 
      });

      it('allows actions that update the state of several portlets. The state of each is as expected.',function(){
         var parms  = {ap1 : ["actionVal"]}, str, states, state;
         var ustr = portlet.test.data.updateStrings[portletC];
         runs(function() {
            pai = null;
            hubC.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbB.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbC.getIsComplete(), "The onStateChange callback should be called", 100);
         waitsFor(cbD.getIsComplete(), "The onStateChange callback should be called", 100);
         runs(function() {

            states = portlet.test.decodeUpdateString(ustr, portletC);

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

      it('Blocks the startPartialAction method for a different portlet until setPageState is called',function(){
         var parms  = {ap1 : ["actionVal"]};
         var ustr = portlet.test.data.updateStrings[portletA];
         runs(function() {
            pai = null;
            hubA.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            var testFunc = function () {
               hubB.startPartialAction(parms).then(function (p) {
                  pai = p;
               });
            };
            expect(testFunc).toThrowCustomException("AccessDeniedException");
         }); 
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
      });

      it('Blocks the action method for a different portlet until setPageState is called',function(){
         var parms  = {ap1 : ["actionVal"]};
         var ustr = portlet.test.data.updateStrings[portletA];
         var el = document.createElement("form");
         runs(function() {
            pai = null;
            hubA.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            var testFunc = function () {
               hubB.action(parms, el);
            }
            expect(testFunc).toThrowCustomException("AccessDeniedException");
         }); 
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
      });

      it('Blocks the setRenderState method for a different portlet until setPageState is called',function(){
         var parms  = {ap1 : ["actionVal"]};
         var ustr = portlet.test.data.updateStrings[portletA];
         runs(function() {
            pai = null;
            hubA.startPartialAction(parms).then(function (p) {
               pai = p;
            });
         }); 
         waitsFor(function () {return pai !== null;}, "The promise to settle", 100)
         runs(function() {
            var state = cbC.getState();
            state.parameters["someparm1"] = ["NewVal"];
            var testFunc = function () {
               hubC.setRenderState(state);
            }
            expect(testFunc).toThrowCustomException("AccessDeniedException");
         }); 
         runs(function() {
            pai.setPageState(ustr);
         }); 
         waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
      });

   });
   
});
