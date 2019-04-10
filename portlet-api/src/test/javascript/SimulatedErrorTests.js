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


describe('If the PortletHub mock implementation is present, simulated error condition specs are executed.',function(){
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


   // Tests in this module need following portlets. register them.
   // These variables provide linkage between the "describe" sections
   hubA,
   hubErr;
       
   // This spec can only be executed against a mock implementation that simulates
   // the condition!!
   if ((portletIds.indexOf('SimulateCommError') >= 0)) {

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

         it('initializes a portlet hub instance for Error simulating portlet',function(){
            var testFunc = function () {
               return portlet.register('SimulateCommError');
            }
            var ph = new portlet.jasmine.PromiseHandler(testFunc);
            runs(ph.getRun());
            waitsFor(ph.getIsComplete(), "The PortletInit object should be returned", 1000);
            runs(ph.getChecker()); 
            runs(function() {
               expect(ph.result).toBeDefined();
            }); 
            runs(function() {
               hubErr = ph.result;
            }); 
         });

      });

      
      describe('The portlet hub reports error if promise is rejected: ',function(){

         // The tests in this section use just a single portlet - portletA
         var cbA = new portlet.jasmine.JasminePortletUtils('SimulateCommError', pageState);

         // add an osc handler for the test
         beforeEach(function () {
            cbA.complete = false;
            runs(function() {
               cbA.oscHandle = hubErr.addEventListener("portlet.onStateChange", cbA.getListener());
            }); 
            waitsFor(cbA.getIsComplete(), "The onStateChange callback should be called", 100);
            runs(function() {
               cbA.complete = false;    // in prep for the actual test
            }); 
         });

         // remove the osc handler added during the test
         afterEach(function () {
            if (cbA.oscHandle !== null) {
               hubErr.removeEventListener(cbA.oscHandle);
               cbA.oscHandle = null;
            }
         });


         it('register method supports an asynchronous response from the impl',function(){
            var testFunc = function () {
               return portlet.register('SimulateLongWait');
            }
            var ph = new portlet.jasmine.PromiseHandler(testFunc);
            runs(ph.getRun());
            waitsFor(ph.getIsComplete(), "The PortletInit object should be returned", 1000);
            runs(ph.getChecker()); 
         });

         it('register method rejects the promise if an error occurs',function(){
            var testFunc = function () {
               return portlet.register('SimulateError');
            }
            var ph = new portlet.jasmine.PromiseHandler(testFunc);
            runs(ph.getRun());
            waitsFor(ph.getIsComplete(), "The PortletInit object should be returned", 1000);
            runs(function() {
               expect(ph.errMsg).not.toEqual("");
               expect(ph.complete).not.toBeTruthy();
               expect(ph.error).toBeTruthy();
            }); 
         });

         it('createResourceUrl does not cause the failure method to be called when no error occurs',function(){
            var parms  = {rp1 : ["resVal"], rp2 : ["resVal2"]}, 
            cache="cacheLevelPage", url = null, errmsg = null;
            runs(function() {
               hubErr.createResourceUrl(parms, cache).then(function (u) {
                  url = u;
               }, function (err) {
                  errmsg = err;
               });
            }); 
            waitsFor(function () {return ((url !== null) || (errmsg !== null));}, "The promise to settle", 100)
            runs(function() {
               expect(errmsg).toEqual(null);
               expect(portlet.test.resource.isResourceUrl(url)).toBeTruthy();
            }); 
         });

         it('createResourceUrl rejects the promise when an error occurs',function(){
            var parms  = {SimulateError : ["reject"], rp2 : ["resVal2"]}, 
            cache="cacheLevelPage", url = null, errmsg = null;
            runs(function() {
               hubErr.createResourceUrl(parms, cache).then(function (u) {
                  url = u;
               }, function (err) {
                  errmsg = err;
               });
            }); 
            waitsFor(function () {return ((url !== null) || (errmsg !== null));}, "The promise to settle", 100)
            runs(function() {
               expect(url).toEqual(null);
               expect(errmsg).not.toEqual(null);
            }); 
         });

         it('startPartialAction does not cause the failure method to be called when no error occurs',function(){
            var parms  = {}, pai = null, errmsg = null;
            var ustr = portlet.test.data.updateStrings[portletA]; // doesn't matter what update data to use
            runs(function() {
               hubErr.startPartialAction(parms).then(function (p) {
                  pai = p;
               }, function (err) {
                  errmsg = err;
               });
            }); 
            waitsFor(function () {return ((pai !== null) || (errmsg !== null));}, "The promise to settle", 100)
            if (pai !== null){
               runs(function() {
                  pai.setPageState(ustr);
               }); 
            }
            runs(function() {
               expect(pai).not.toEqual(null);
               expect(errmsg).toEqual(null);
            }); 
         });

         it('startPartialAction rejects the promise when an error occurs',function(){
            var parms  = {SimulateError : ["reject"]}, pai = null, errmsg = null;
            var ustr = portlet.test.data.updateStrings[portletA]; // doesn't matter what update data to use
            runs(function() {
               hubErr.startPartialAction(parms).then(function (p) {
                  pai = p;
               }, function (err) {
                  errmsg = err;
               });
            }); 
            waitsFor(function () {return ((pai !== null) || (errmsg !== null));}, "The promise to settle", 100)
            if (pai !== null){
               runs(function() {
                  pai.setPageState(ustr);
               }); 
            }
            runs(function() {
               expect(pai).toEqual(null);
               expect(errmsg).not.toEqual(null);
            }); 
         });

      });


      describe('The portlet hub fires onError event if async error occurs during an action or while setting state: ',function(){

         // The tests in this section use just a single portlet - portletA
         var cbErr = new portlet.jasmine.JasminePortletUtils('SimulateCommError', pageState);

         // add an osc handler for the test
         beforeEach(function () {
            cbErr.complete = false;
            runs(function() {
               cbErr.oscHandle = hubErr.addEventListener("portlet.onStateChange", cbErr.getListener());
               cbErr.oeHandle = hubErr.addEventListener("portlet.onError", cbErr.getListener("error"));
            }); 
            waitsFor(cbErr.getIsComplete(), "The onStateChange callback should be called", 100);
            runs(function() {
               cbErr.complete = false;    // in prep for the actual test
               cbErr.retType = null;
               cbErr.retErrorData = null;
            }); 
         });

         // remove the osc handler added during the test
         afterEach(function () {
            if (cbErr.oscHandle !== null) {
               hubErr.removeEventListener(cbErr.oscHandle);
               cbErr.oscHandle = null;
            }
            if (cbErr.oeHandle !== null) {
               hubErr.removeEventListener(cbErr.oeHandle);
               cbErr.oeHandle = null;
            }
         });

         it('The onError function is not called if no error occurs setting state',function(){
            var state = cbErr.getState();
            state.parameters["NewParm"] = ["NewVal"];
            runs(function() {
               hubErr.setRenderState(state);
            }); 
            waitsFor(cbErr.getIsComplete(), "The onStateChange callback should be called", 100);
            runs(function() {
               expect(cbErr.retType).not.toEqual('portlet.onError');
               expect(cbErr.retRenderState).not.toEqual(null);
               expect(cbErr.retErrorData).toEqual(null);
               expect(cbErr.retRenderState.parameters["NewParm"]).toEqual(["NewVal"]);
            }); 
         });

         it('The onError function is called if an asynch error occurs setting state',function(){
            var state = cbErr.getState();
            state.parameters["SimulateError"] = ["reject"];
            runs(function() {
               hubErr.setRenderState(state);
            }); 
            waitsFor(cbErr.getIsComplete(), "The onStateChange callback should be called", 100);
            runs(function() {
               expect(cbErr.retType).toEqual('portlet.onError');
               expect(cbErr.retErrorData).not.toEqual(null);
            }); 
         });

         it('The onError function is not called if no error occurs performing action',function(){
            var parms  = {};
            runs(function() {
               hubErr.action(parms);
            }); 
            waitsFor(cbErr.getIsComplete(), "The onStateChange callback should be called", 100);
            runs(function() {
               expect(cbErr.retType).not.toEqual('portlet.onError');
               expect(cbErr.retRenderState).not.toEqual(null);
               expect(cbErr.retErrorData).toEqual(null);
            }); 
         });

         it('The onError function is called if an asynch error occurs performing action',function(){
            var parms  = {SimulateError : ["reject"]};
            runs(function() {
               hubErr.action(parms);
            }); 
            waitsFor(cbErr.getIsComplete(), "The onStateChange callback should be called", 100);
            runs(function() {
               expect(cbErr.retType).toEqual('portlet.onError');
               expect(cbErr.retErrorData).not.toEqual(null);
            }); 
         });

      });

   }
});
