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
 * This module contains common utilities used for testing.
 * <p>
 * It does not contain specs, and should be loaded with the source under test.
 */

var portlet = portlet || {};

(function () {
   portlet.jasmine = {
       
      JasminePortletUtils : function (pid, pageState) {
         this.portletId         = pid;
         this.pageState         = pageState;        // test data for all portlet IDs on page
         this.oscHandle         = null;             // handle for onStateChangeListener
         this.oeHandle          = null;             // handle for onError
         this.ceHandle          = null;             // handle for client Event

         this.complete          = false;

         this.retType           = null;
         this.retErrorData      = null;
         this.retRenderState   = null;
         this.retRenderData     = null;
         this.retPayload        = null;
      },
   };
   
   portlet.jasmine.JasminePortletUtils.prototype = {

      // utility function to avoid wrecking the common init data
      cloneState : function(aState) {
      
         var newParams = {},
         newState = {
               portletMode : aState.portletMode,
               windowState : aState.windowState,
               parameters : newParams
         }, key, oldParams = aState.parameters;
      
         for (key in oldParams) {
            if (oldParams.hasOwnProperty(key)) {
               newParams[key] = oldParams[key].slice(0);
            }
         }
      
         return newState;
      },
      
      // clones the returned state and gives it back.
      // Meant to be called after the listener has been added 
      // & the callback has added the state
      getState        : function () {
         if (this.retRenderState !== null) {
            return this.cloneState(this.retRenderState);
         } else {
            return this.cloneState(this.pageState[this.portletId]);
         }
      },

      // handler for portlet client event
      onClientEvent      : function (type, payload) {
         this.complete = true;
         this.retType = type;
         this.retPayload = payload;
         return;
      },
      
      // onError handler
      onError      : function (type, errorData) {
         this.complete = true;
         this.retType = type;
         this.retErrorData = errorData;
         return;
      },
      
      // onStateChange handler
      onStateChange      : function (type, RenderState, renderData) {
         this.complete = true;
         this.retType = type;
         this.retRenderState = RenderState;
         this.retRenderData = renderData;
         return;
      },
      
      getListener      : function (type) {
         var  that = this;
         if (type !== undefined) {
            if (type === "client") {
               return function(type, payload) {
                  that.onClientEvent(type, payload);
               };
            } else if (type === "error") {
               return function(type, errorData) {
                  that.onError(type, errorData);
               };
            }
         }
         return function(type, RenderState, renderData) {
            that.onStateChange(type, RenderState, renderData);
         };
      },
      
      // latch function to wait for callback completion
      // (Jasmine test function called at 10ms intervals until timeout)
      isComplete      : function () {
         return this.complete;
      },
      
      getIsComplete      : function () {
         var  that = this;
         return function() {
            return that.isComplete();
         };
      },
   };

   portlet.jasmine.PromiseHandler = function (f, checkResType) {
      this.func = f
      this.result = null;
      this.errMsg = "";
      this.error = false;
      this.complete = false;
      this.checkResType = (checkResType === false) ? false : true;
   } 
   
   portlet.jasmine.PromiseHandler.prototype = {
   
      // For handling promise completion
      run     : function () {
         var that = this;
         var testFunc = function() {
            that.prom = (that.func)();
            that.prom.then( 
               function (res) {
                  that.result = res; 
                  that.complete = true;
               }, 
               function (err) {
                  that.errMsg = err;
                  that.error = true;
               } 
            );
         }
         expect(testFunc).not.toThrow();
      },
      
      // For making a closure around the run function
      getRun      : function () {
         var  that = this;
         return function() {
            return that.run();
         };
      },
   
      // latch function to wait for callback completion
      // (Jasmine test function called at 10ms intervals until timeout)
      isComplete      : function () {
         return (this.complete || this.error);
      },
      
      // For making a closure around the isComplete function
      getIsComplete      : function () {
         var  that = this;
         return function() {
            return that.isComplete();
         };
      },
   
      // Check for good completion
      checker      : function () {
         expect(this.errMsg).toEqual("");
         expect(this.complete).toBeTruthy();
         expect(this.error).not.toBeTruthy();
         if (this.checkResType) {
            expect(typeof this.result).toEqual('object');
         }
      },
      
      // For making a closure around the checker function
      getChecker      : function () {
         var  that = this;
         return function() {
            return that.checker();
         };
      }
   };

})();
