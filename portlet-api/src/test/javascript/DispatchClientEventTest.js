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


describe('The portlet hub allows the portlet client to dispatch events',function(){
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


   describe('The portlet hub dispatchClientEvent function: ',function(){

      // Make sure it works for more than one portlet 

      var cbA = new portlet.jasmine.JasminePortletUtils(portletA, pageState);
      var cbB = new portlet.jasmine.JasminePortletUtils(portletB, pageState);
      var cbC = new portlet.jasmine.JasminePortletUtils(portletC, pageState);
      var cbD = new portlet.jasmine.JasminePortletUtils(portletD, pageState);

      // sets up for test. the test will register appropriate listeners.
      beforeEach(function () {
         cbA.complete = false;
         cbB.complete = false;
         cbC.complete = false;
         cbD.complete = false;
         cbA.ceHandle = null;
         cbB.ceHandle = null;
         cbC.ceHandle = null;
         cbD.ceHandle = null;
      });

      // remove  handler added during the test
      afterEach(function () {
         if (cbA.ceHandle !== null) {
            hubA.removeEventListener(cbA.ceHandle);
            cbA.ceHandle = null;
         }
         if (cbB.ceHandle !== null) {
            hubB.removeEventListener(cbB.ceHandle);
            cbB.ceHandle = null;
         }
         if (cbC.ceHandle !== null) {
            hubC.removeEventListener(cbC.ceHandle);
            cbC.ceHandle = null;
         }
         if (cbD.ceHandle !== null) {
            hubD.removeEventListener(cbD.ceHandle);
            cbD.ceHandle = null;
         }
      });

      it('is present in the register return object and is a function',function(){
         expect(typeof hubA.dispatchClientEvent).toEqual('function');
      });

      it('throws a TypeError if no argument is provided',function(){
         var testFunc = function () {
            hubA.dispatchClientEvent();
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if 1 argument is provided',function(){
         var testFunc = function () {
            hubA.dispatchClientEvent("myType");
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if too many (>2) arguments are provided',function(){
         var testFunc = function () {
            hubA.dispatchClientEvent("parm1", "parm2", "parm3");
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the type argument is not a string',function(){
         var testFunc = function () {
            hubA.dispatchClientEvent(89, "aPayload");
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the type is null',function(){
         var testFunc = function () {
            hubA.dispatchClientEvent(null, "aPayload");
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('does not throw an Exception if the payload is null',function(){
         var testFunc = function () {
            hubA.dispatchClientEvent("anEvent", null);
         }
         expect(testFunc).not.toThrow();
      });

      it('throws a TypeError if the type begins with "portlet."',function(){
         var testFunc = function () {
            hubA.dispatchClientEvent("portlet.invalidType", "aPayload");
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the type matches a system event type',function(){
         var testFunc = function () {
            hubA.dispatchClientEvent("portlet.onStateChange", "aPayload");
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('does not throw an exception if both parameters are valid',function(){
         var cnt;
         var testFunc = function () {
            cnt = hubA.dispatchClientEvent("anEvent", "aPayload");
         }
         expect(testFunc).not.toThrow();
      });

      it('returns count of 0 when no listener for event is registered',function(){
         var cnt;
         cnt = hubA.dispatchClientEvent("anEvent", "aPayload");
         expect(cnt).toEqual(0);
      });

      it('listener is called & count=1 when 1 listener for event is registered',function(){
         var cnt, type="anEvent", payload="aPayload";
         runs(function() {
            cbA.ceHandle = hubA.addEventListener(type, cbA.getListener("client"));
         }); 
         runs(function() {
            cnt = hubA.dispatchClientEvent(type, payload);
         });
         runs(function() {
            expect(cnt).toEqual(1);
         });
         waitsFor(cbA.getIsComplete(), "The listener should be called", 100);
      });

      it('causes listener to be called with expected type & string payload when event is dispatched',function(){
         var cnt, type="anEvent", payload="aPayload";
         runs(function() {
            cbA.ceHandle = hubA.addEventListener(type, cbA.getListener("client"));
         }); 
         runs(function() {
            cnt = hubA.dispatchClientEvent(type, payload);
         });
         waitsFor(cbA.getIsComplete(), "The listener should be called", 100);
         runs(function() {
            expect(cbA.retType).toEqual(type);
            expect(cbA.retPayload).toEqual(payload);
         });
      });

      it('when type does not match, no event is fired',function(){
         var cnt, type="anEvent", payload="aPayload";
         runs(function() {
            cbB.ceHandle = hubB.addEventListener("differentEvent", cbB.getListener("client"));
         }); 
         runs(function() {
            cnt = hubA.dispatchClientEvent(type, payload);
         });
         waits(20);        // allow listener to run
         runs(function() {
            expect(cnt).toEqual(0);
            expect(cbB.isComplete()).toBeFalsy();
         });
      });

      it('payload=null is transported correctly',function(){
         var cnt, type="anEvent", payload=null;
         runs(function() {
            cbA.ceHandle = hubA.addEventListener(type, cbA.getListener("client"));
         }); 
         runs(function() {
            cnt = hubA.dispatchClientEvent(type, payload);
         });
         waitsFor(cbA.getIsComplete(), "The listener should be called", 100);
         runs(function() {
            expect(cbA.retType).toEqual(type);
            expect(cbA.retPayload).toEqual(payload);
         });
      });

      it('payload of type object is transported correctly',function(){
         var cnt, type="anEvent", payload={name:"Scott",addr:"Stgt"};
         runs(function() {
            cbA.ceHandle = hubA.addEventListener(type, cbA.getListener("client"));
         }); 
         runs(function() {
            cnt = hubA.dispatchClientEvent(type, payload);
         });
         waitsFor(cbA.getIsComplete(), "The listener should be called", 100);
         runs(function() {
            expect(cbA.retType).toEqual(type);
            expect(cbA.retPayload).toEqual(payload);
         });
      });

      it('listener of different portlet is correctly called when event is dispatched',function(){
         var cnt, type="anEvent", payload="aPayload";
         runs(function() {
            cbB.ceHandle = hubB.addEventListener(type, cbB.getListener("client"));
         }); 
         runs(function() {
            cnt = hubA.dispatchClientEvent(type, payload);
         });
         waitsFor(cbB.getIsComplete(), "The listener should be called", 100);
         runs(function() {
            expect(cbB.retType).toEqual(type);
            expect(cbB.retPayload).toEqual(payload);
         });
      });

      it('matches event types by regex',function(){
         var cnt, type="ibm.anEvent", payload="aPayload";
         runs(function() {
            cbB.ceHandle = hubB.addEventListener("ibm\..*", cbB.getListener("client"));
         }); 
         runs(function() {
            cnt = hubA.dispatchClientEvent(type, payload);
         });
         waitsFor(cbB.getIsComplete(), "The listener should be called", 100);
         runs(function() {
            expect(cnt).toEqual(1);
            expect(cbB.retType).toEqual(type);
            expect(cbB.retPayload).toEqual(payload);
         });
      });

      it('when regex does not match, no event is fired',function(){
         var cnt, type="anEvent", payload="aPayload";
         runs(function() {
            cbB.ceHandle = hubB.addEventListener("ibm\..*", cbB.getListener("client"));
         }); 
         runs(function() {
            cnt = hubA.dispatchClientEvent(type, payload);
         });
         waits(20);        // allow listener to run
         runs(function() {
            expect(cnt).toEqual(0);
            expect(cbB.isComplete()).toBeFalsy();
         });
      });

      it('2 listeners of different portlet are correctly called when event is dispatched',function(){
         var cnt, type="anEvent", payload="aPayload";
         runs(function() {
            cbB.ceHandle = hubB.addEventListener(type, cbB.getListener("client"));
            cbD.ceHandle = hubD.addEventListener(type, cbD.getListener("client"));
         }); 
         runs(function() {
            cnt = hubA.dispatchClientEvent(type, payload);
         });
         waitsFor(cbB.getIsComplete(), "The listener should be called", 100);
         waitsFor(cbD.getIsComplete(), "The listener should be called", 100);
         runs(function() {
            expect(cnt).toEqual(2);
            expect(cbB.retType).toEqual(type);
            expect(cbB.retPayload).toEqual(payload);
            expect(cbD.retType).toEqual(type);
            expect(cbD.retPayload).toEqual(payload);
         });
      });

   });

});
