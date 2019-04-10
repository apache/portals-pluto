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


describe('The portlet hub provides the ability to add and remove event listeners.',function(){
   'use strict'
   
   // get the portlet IDs provided by the system under test. The function must
   // return a string array of portlet IDs that are known to the portlet hub being 
   // tested. There must be at least 3 IDs available. The first portlet (portletA) 
   // has some parameters set and no render data. The 2nd portlet (portletC) 
   // has no parameters set, and no render data. The final test portlet
   // (portletB) has both parameters and render data.
   var portletIds = portlet.test.getIds(),
       pageState = portlet.test.getInitData(),
       portletA = portletIds[0],
       portletB = portletIds[3],
       portletC = portletIds[1];


   // All tests need a registered portlet client. For the mockup, assume portlet ID portletA
   // is present. Get the hub functions for the portlet.
   // These variables provide linkage between the "describe" sections
   var hubA,
       hubB,
       userEventName = "someEvent",
       userEventHandle,
       oscHandle,             // handle for onStateChangeListener
       oeHandle,              // handle for onError
       
       complete = false,
       retType,
       retErrorData,
       retRenderState,
       retRenderData,
       
       // handler for portlet client event
       pcListener = function (type) {
          complete = true;
          return;
       },
       
       // onError handler
       onError = function (type, errorData) {
          complete = true;
          return;
       },
       
       // onStateChange handler
       onStateChange = function (type, RenderState, renderData) {
          retType = type;
          retRenderState = RenderState;
          retRenderData = renderData;
          complete = true;
          return;
       },
       
       // latch function to wait for callback completion
       // (Jasmine test function called at 10ms intervals until timeout)
       isComplete = function () {
          return complete;
       };
   
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

   
   describe('The portlet hub addEventListener function: ',function(){

      it('is present in the register return object and is a function',function(){
         expect(typeof hubA.addEventListener).toEqual('function');
      });

      it('throws a TypeError if no argument is provided',function(){
         var testFunc = function () {
            hubA.addEventListener();
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if 1 argument is provided',function(){
         var testFunc = function () {
            hubA.addEventListener(userEventName);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if too many (>2) arguments are provided',function(){
         var testFunc = function () {
            hubA.addEventListener("parm1", "parm2", "parm3");
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the type argument is not a string',function(){
         var testFunc = function () {
            hubA.addEventListener(89, onStateChange);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the function argument is not a function',function(){
         var testFunc = function () {
            hubA.addEventListener(userEventName, 89);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the type is null',function(){
         var testFunc = function () {
            hubA.addEventListener(null, onStateChange);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the function is null',function(){
         var testFunc = function () {
            hubA.addEventListener(userEventName, null);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the type begins with "portlet." but is neither "portlet.onStateChange" or "portlet.onError"',function(){
         var testFunc = function () {
            hubA.addEventListener("portlet.invalidType", onStateChange);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('does not throw an exception if both parameters are valid',function(){
         var testFunc = function () {
            userEventHandle = hubA.addEventListener(userEventName, pcListener);
         }
         expect(testFunc).not.toThrow();
      });

      it('returns a handle to the event handler (an object) when the parameters are valid',function(){
         expect(typeof userEventHandle).not.toEqual('undefined');
      });

      it('allows a listener for event type "portlet.onStateChange" to be added.',function(){
         var testFunc = function () {
            oscHandle = hubA.addEventListener("portlet.onStateChange", onStateChange);
         }
         expect(testFunc).not.toThrow();
         expect(typeof oscHandle).not.toEqual('undefined');
      });

      it('allows a listener for event type "portlet.onError" to be added.',function(){
         var testFunc = function () {
            oeHandle = hubA.addEventListener("portlet.onError", onError);
         }
         expect(testFunc).not.toThrow();
         expect(typeof oeHandle).not.toEqual('undefined');
      });

   });
   
   
   describe('The portlet hub removeEventListener function: ',function(){

      it('is present in the register return object and is a function',function(){
         expect(typeof hubA.removeEventListener).toEqual('function');
      });

      it('throws a TypeError if no argument is provided',function(){
         var testFunc = function () {
            hubA.removeEventListener();
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if too many (>1) arguments are provided',function(){
         var testFunc = function () {
            hubA.removeEventListener("parm1", "parm2", "parm3");
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the handle is null',function(){
         var testFunc = function () {
            hubA.removeEventListener(null);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the handle is undefined',function(){
         var testFunc = function () {
            hubA.removeEventListener(undefined);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the handle has an invalid value',function(){
         var testFunc = function () {
            hubA.removeEventListener("This is an invalid handle.");
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('allows a previously added user event listener to be removed',function(){
         var testFunc = function () {
            hubA.removeEventListener(userEventHandle);
         }
         expect(testFunc).not.toThrow();
      });

      it('allows a previously added portlet.onStateChange event listener to be removed',function(){
         var testFunc = function () {
            hubA.removeEventListener(oscHandle);
         }
         expect(testFunc).not.toThrow();
      });

      it('allows a previously added portlet.onError event listener to be removed',function(){
         var testFunc = function () {
            hubA.removeEventListener(oeHandle);
         }
         expect(testFunc).not.toThrow();
      });

      it('throws a TypeError if the user event handler is removed twice',function(){
         var testFunc = function () {
            hubA.removeEventListener(userEventHandle);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the onStateChange event handler is removed twice',function(){
         var testFunc = function () {
            hubA.removeEventListener(oscHandle);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });

      it('throws a TypeError if the onError event handler is removed twice',function(){
         var testFunc = function () {
            hubA.removeEventListener(oeHandle);
         }
         expect(testFunc).toThrowCustomException("TypeError");
      });
      
   });
   
   
   describe('Without render data, the portlet client onStateChange function: ',function(){
      
      userEventHandle = oscHandle = oeHandle = null;
      
      beforeEach(function () {
         complete = false;
      });
      
      // remove the osc handler added during the test
      afterEach(function () {
         if (oscHandle !== null) {
            hubA.removeEventListener(oscHandle);
            oscHandle = null;
         }
      });
         
      it('does not call the portlet.onStateChange listener during the addEventListener call',function(){
         oscHandle = hubA.addEventListener("portlet.onStateChange", onStateChange);
         expect(complete).toBeFalsy();
      });

      it('is called asynchronously after an onStateChange handler is registered',function(){
         runs(function() {
            oscHandle = hubA.addEventListener("portlet.onStateChange", onStateChange);
          }); 

          waitsFor(isComplete, "The onStateChange callback should be called", 5000);
       });

      it('is passed a type parameter with value "portlet.onStateChange"',function(){
         expect(retType).toEqual("portlet.onStateChange");
      });

      it('is passed a RenderState parameter that is an object',function(){
         expect(typeof retRenderState).toEqual('object');
      });

      // portlet A is set up not to have render data
      it('is not passed a RenderData object',function(){
         expect(typeof retRenderData).toEqual('undefined');
      });

      it('is passed a RenderState parameter that has 3 properties',function(){
         var cnt = 0, prop;
         for (prop in retRenderState) {
            if (retRenderState.hasOwnProperty(prop)) {
               cnt = cnt + 1;
            }
         }
         expect(cnt).toEqual(3);
      });

      it('is passed a RenderState object with a "parameters" property',function(){
         expect(typeof retRenderState.parameters).not.toEqual('undefined');
      });

      it('is passed a RenderState object with a "portletMode" property',function(){
         expect(typeof retRenderState.portletMode).not.toEqual('undefined');
      });

      it('is passed a RenderState object with a "windowState" property',function(){
         expect(typeof retRenderState.windowState).not.toEqual('undefined');
      });

      it('its RenderState "parameters" property is an object',function(){
         expect(typeof retRenderState.parameters).toEqual('object');
      });
      
      var parmCnt = 0, parms = pageState[portletA].state.parameters;
      for (var prop in parms) {
         if (parms.hasOwnProperty(prop)) {
            parmCnt = parmCnt + 1;
         }
      }

      it('its RenderState has ' + parmCnt + " parameters",function(){
         var retParmCnt = 0, parms = retRenderState.parameters;
         for (var prop in parms) {
            if (parms.hasOwnProperty(prop)) {
               retParmCnt = retParmCnt + 1;
            }
         }
         expect(retParmCnt).toEqual(parmCnt);
      });

      it('its RenderState "windowState" property is a string',function(){
         expect(typeof retRenderState.windowState).toEqual('string');
      });

      it('its RenderState "portletMode" property is a string',function(){
         expect(typeof retRenderState.portletMode).toEqual('string');
      });

      it('its RenderState has windowState=' + 
            pageState[portletA].state.windowState,function(){
         expect(retRenderState.windowState)
            .toEqual(pageState[portletA].state.windowState);
      });

      it('its RenderState has portletMode=' + 
            pageState[portletA].state.portletMode,function(){
         expect(retRenderState.portletMode)
            .toEqual(pageState[portletA].state.portletMode);
      });

      it('its RenderState parameter is not identical to the test state object"',function(){
         expect(retRenderState).not.toBe(pageState[portletA].state);
      });

      it('its RenderState parameter equals the test state object"',function(){
         var ts = hubA.newState(pageState[portletA].state);
         expect(retRenderState).toEqual(ts);
      });
   
   });
   
   
   describe('With render data, the portlet client onStateChange function: ',function(){
      
      userEventHandle = oscHandle = oeHandle = null;
      
      beforeEach(function () {
         complete = false;
      });
      
      // remove the osc handler added during the test
      afterEach(function () {
         if (oscHandle !== null) {
            hubB.removeEventListener(oscHandle);
            oscHandle = null;
         }
      });
         
      it('does not call the portlet.onStateChange listener during the addEventListener call',function(){
         oscHandle = hubB.addEventListener("portlet.onStateChange", onStateChange);
         expect(complete).toBeFalsy();
      });

      it('is called asynchronously after an onStateChange handler is registered',function(){
         runs(function() {
            oscHandle = hubB.addEventListener("portlet.onStateChange", onStateChange);
          }); 

          waitsFor(isComplete, "The onStateChange callback should be called", 5000);
       });

      it('is passed a type parameter with value "portlet.onStateChange"',function(){
         expect(retType).toEqual("portlet.onStateChange");
      });

      it('is passed a RenderState parameter that is an object',function(){
         expect(typeof retRenderState).toEqual('object');
      });

      it('is passed a RenderState parameter that has 3 properties',function(){
         var cnt = 0;
         for (var prop in retRenderState) {
            if (retRenderState.hasOwnProperty(prop)) {
               cnt = cnt + 1;
            }
         }
         expect(cnt).toEqual(3);
      });

      it('is passed a RenderState object with a "parameters" property',function(){
         expect(typeof retRenderState.parameters).not.toEqual('undefined');
      });

      it('is passed a RenderState object with a "portletMode" property',function(){
         expect(typeof retRenderState.portletMode).not.toEqual('undefined');
      });

      it('is passed a RenderState object with a "windowState" property',function(){
         expect(typeof retRenderState.windowState).not.toEqual('undefined');
      });

      it('its RenderState parameter is not identical to the test state object"',function(){
         expect(retRenderState).not.toBe(pageState[portletB].state);
      });

      it('its RenderState parameter equals the test state object"',function(){
         var ts = hubA.newState(pageState[portletB].state);
         expect(retRenderState).toEqual(ts);
      });

      // portlet B is set up to have render data
      it('is passed a RenderData object',function(){
         expect(typeof retRenderData).toEqual('object');
      });

      it('is passed a RenderData parameter that has 2 properties',function(){
         var cnt = 0;
         for (var prop in retRenderData) {
            if (retRenderData.hasOwnProperty(prop)) {
               cnt = cnt + 1;
            }
         }
         expect(cnt).toEqual(2);
      });

      it('is passed a RenderData object with a "content" property',function(){
         expect(typeof retRenderData.content).not.toEqual('undefined');
      });

      it('is passed a RenderData object with a "mimeType" property',function(){
         expect(typeof retRenderData.mimeType).not.toEqual('undefined');
      });

      it('is passed a RenderData object with a "content" property of type string',function(){
         expect(typeof retRenderData.content).toEqual('string');
      });

      it('is passed a RenderData object with a "mimeType" property of type string',function(){
         expect(typeof retRenderData.mimeType).toEqual('string');
      });

      it('its RenderData parameter equals the test render data object"',function(){
         expect(retRenderData).toEqual(pageState[portletB].renderData);
      });
   
   });

});