/*jslint browser: true, devel: true, plusplus: true, unparam: true, white: true, indent: 3 */
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

/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

/**
 * @fileOverview
 * This module provides JavaScript functions for portlets.
 *
 * @author Scott Nicklous
 * @copyright IBM Corp., 2014
 */

/**
 * Represents a portlet parameter.
 * <p>
 * Each object property represents a parameter name.
 * The object may also contain no property names,
 * which represents the case of the portlet having no parameters.
 * <p>
 * If properties are present,
 * each property must refer to a array of string values.
 * The array length must be at least 1, because each parameter must have
 * a value.
 * However, a value of 'null' may appear in any array entry.
 * <p>
 * To represent the parameter having a <code>null</code> value, the
 * property value must equal [null].
 * <p>
 * @typedef    PortletParameters
 * @property   {string[]}  {string}    The parameters object may have
 *                                     multiple properties.
 */

/**
 * Represents the render state.
 * <p>
 * RenderState objects obtained from the Portlet Hub define some helper
 * functions for accessing the parameter values.
 * <p>
 * @typedef    RenderState
 * @property   {PortletParameters}   parameters     The portlet parameters
 * @property   {string}             portletMode    The portlet mode
 * @property   {string}             windowState    The window state
 * @property   {function}   clone()                Returns a new copy of this object
 * @property   {function}   setPortletMode(pm)     Sets the portlet mode to the specified value. 
 *               The strings defined by the {@link PortletConstants} object should be used to specify the portlet mode.
 * @property   {function}   getPortletMode()       Returns the current portlet mode 
 * @property   {function}   setWindowState(ws)     Sets the window state to the specified value
 * @property   {function}   getWindowState()       Returns the current window state
 *               The strings defined by the {@link PortletConstants} object should be used to specify the window state.
 * @property   {function}   setValue(n,v)    Sets a parameter with name n and value v.
 *                                           The value v may be a string or an array.
 * @property   {function}   setValues(n,v)   Sets a parameter with name n and value v.
 *                                           The value v may be a string or an array.
 * @property   {function}   getValue(n,d)    Gets the string parameter value for the name n.
 *                                           If n designates a multi-valued parameter, this function returns the first value in the values array.
 *                                           If parameter n is undefined, the function returns the optional default value d.
 * @property   {function}   getValues(n,d)   Gets the string array parameter value for the name n.
 *                                           If parameter n is undefined, the function returns the optional default value array d.
 * @property   {function}   remove(n)        Removes the parameter with name n.
 */

/**
 * Provides defined values for some commonly-used portlet constants
 * <p>
 * @typedef    PortletConstants
 * @property   {string}       VIEW        Specifies portlet mode 'view'    
 * @property   {string}       EDIT        Specifies portlet mode 'edit'    
 * @property   {string}       HELP        Specifies portlet mode 'help'    
 * @property   {string}       NORMAL      Specifies window state 'normal'
 * @property   {string}       MINIMIZED   Specifies window state 'minimized'
 * @property   {string}       MAXIMIZED   Specifies window state 'maximized'
 * @property   {string}       FULL        Specifies resource URL cacheability "cacheLevelFull"
 * @property   {string}       PORTLET     Specifies resource URL cacheability "cacheLevelPage"
 * @property   {string}       PAGE        Specifies resource URL cacheability "cacheLevelPortlet"
 */

/**
 * Optional render data that may be provided by the portlet hub when
 * a render state change occurs.
 *
 * @typedef    RenderData
 * @property   {string}             renderData     The render data
 * @property   {string}             mimeType       The mime type
 */

/**
 * The onStateChange callback function that each portlet client
 * participating in the portlet hub Ajax support must implement.
 * <p>
 * The portlet client registers an onStateChange callback by adding a
 * listener for the portlet.onStateChange
 * event type through the {@link addEventListener} function.
 * <p>
 * When the portlet hub calls the onStateChange callback, it will pass
 * a copy of the current render state as a parameter.
 * The portlet client can make changes to the RenderState object
 * without affecting the actual render state, which is maintained by the
 * portlet hub.
 * The portlet client uses the {@link setRenderState} method to
 * make changes to the local copy of the RenderState object active.
 * <p>
 * Optionally, the portlet hub will make a RenderData object available
 * to the portlet client.
 * When the RenderData object is available, it contains the same data
 * as would be available through a portlet resource request using the
 * current render state with no additional resource parameters and with
 * the resource URL cacheability option set to "PAGE".
 * <p>
 * The portlet client may not call portlet hub functions that can
 * cause state to be updated ({@link action}, {@link updateRenderState},
 * {@link startPartialAction})
 * during onStateChange execution.
 *
 * @name       onStateChange
 * @callback   onStateChange
 * @param      {string}       type           The event type "portlet.onStateChange".
 * @param      {RenderState} RenderState   The render state
 * @param      {RenderData}   renderData     The render data.
 *                                           Optionally provided by the portlet hub.
 */

/**
 * This data is returned to the portlet client by the {@link startPartialAction}
 * function.
 * <p>
 * The portlet client can use the partial action URL to initiate processing.
 * During processing, the portal will perform action and event processing.
 * It will generate a string representing the new page state and pass it to the
 * portlet's serveResource method.
 * <p>
 * The portlet is responsible for transmitting the page state string to the
 * client and for calling the {@link setPageState} callback function.
 * <p>
 * The portlet hub will be blocked until the portlet calls the setPageState
 * function and the portlet hub has successfully performed the state change.
 *
 * @typedef    PartialActionInit
 * @property   {string}             url               The partial action URL
 * @property   {function}           setPageState      Callback function
 */

/**
 * Provides the name of an error that occurred along with an optional
 * message that provide more detail.
 * @typedef    ErrorData
 * @property   {string}    name     The error name
 * @property   {string}    message  An optional message that provides more detail about the error
 */

/**
 * The onError callback function that a portlet client
 * participating in the portlet hub Ajax support may implement.
 * Typically the callback will be used to provide the portlet client with
 * information about asynchronous errors that occurred during processing.
 * <p>
 * The portlet client registers an onError callback by adding a listener for the portlet.onError
 * event type through the {@link addEventListener} function.
 * @name       onError
 * @callback   onError
 * @param      {string}       type           The event type "portlet.onError".
 * @param      {ErrorData}    errorData      Provides information about the error.
 */


/**
 * The "portlet" namespace is reserved for use by portal JavaScript support
 * implementations.
 * <p>
 * Portlet Specification 2.0 (JSR 286) provided Ajax support for portlets by
 * adding a resource URL, resource request, and serveResource() method to allow
 * portlet JavaScript code to retrieve data directly from the portlet. Portlet
 * Specification 3.0 (JSR 362) expands on that by providing capability allowing
 * a portlet to change its state through JavaScript functions.
 * <p>
 * Portlet Specification 3.0 introduces a JavaScript component called the
 * Portlet Hub that manages the state of all portlets on a portal page.
 * <p>
 * Some terminology:
 * <dl>
 * <dt> Portlet Hub </dt>
 * <dd>JavaScript component that manages the state of all portlets on a portal
 * page. It is considered to be part of the portal implementation. This document
 * describes its JavaScript interfaces and behavior.
 * <p>
 * Portlet JavaScript code can use the Portlet Hub programming interface to
 * modify its state by setting private and public render parameters to submit
 * forms while remaining in the Ajax application paradigm.
 * <p>
 * Many portlets can be present on the page and the portlets are in general
 * independent of one another and they are not aware of the state of other
 * portlets, so they are unable to generate URLs properly representing the
 * complete page state. The Portlet Hub provides methods that allow portlets to
 * obtain URLs representing the current portal page state.
 * <p>
 * The programming interface and behavior of this component is standardized by
 * JSR 362. </dd>
 * <dt> Portlet Client </dt>
 * <dd> JavaScript code written by the portlet developer that uses the portlet
 * hub to manage its state and to obtain URLs for retrieving data. </dd>
 * </dl>
 * <h5> Changing the render state </h5>
 * <p>
 * The portlet client can use portlet hub functions to initiate state changes.
 * <p>
 * The portlet client can set public and private render parameters as well as
 * the portlet mode and window state.
 * <p>
 * In addition, the portlet client can submit a portlet action request that uses
 * HTTP POST semantics. The portal will execute the portlet Action Phase and
 * Event Phase processing on the server and return the updated page state to the
 * portlet hub.
 * <p>
 * After the requested state change has been performed, the portlet hub will
 * usually provide each affected portlet client with its updated state
 * information.
 * <p>
 * However, regardless of whether the state change was initiated by setting
 * parameters or through a portlet action, the portal may respond by completely
 * refreshing the page. The portal may do so in order to support portlets that
 * are affected by the state change but do not participate in the portlet
 * client-side support, or for implementation-specific reasons.
 * <p>
 * If the portal responds to a state change request by refreshing the page, the
 * portlets will not be updated with new page state information before the page
 * refresh is carried out.
 * <h5> Receiving render state Updates </h5>
 * <p>
 * When a state change occurs that affects a portlet, the portlet hub informs
 * the affected portlet client of its new state through use of a callback
 * function. The change causing the update does not necessarily need to be
 * initiated by the portlet client itself.
 * <p>
 * For example, when portlet A changes a public render parameter used by portlet
 * B, the portlet hub will inform both the portlet A and the portlet B clients
 * of that change.
 * <h5> Portlet Client Events </h5>
 * <p>
 * Portlet client events consist of an event type and an event payload. Both are
 * defined by by the portlet clients themselves.
 * <p>
 * Portlet client events have no connection to the server-side portlet event
 * mechanism.
 * <p>
 * The portlet hub provides utility functions that enable the portlet client to
 * dispatch and listen for portlet client events.
 * <h5> Error Handling </h5>
 * <p>
 * When the portlet hub can recognize an error during function execution, the
 * error will be reported to the portlet client through an exception.
 * <p>
 * However, some methods initiate work that is performed asynchronously. Errors
 * that occur during asynchronous processing will be reported to the portelt
 * client through the {@link onError} callback function.
 * <h5> Important Considerations </h5>
 * <p>
 * The portlet hub calls the portlet client callback functions in several
 * situations as described above. When the portlet hub calls the portlet client,
 * the portlet client may navigate to a different page or may initiate another
 * change to the render state that could potentially cause a page refresh.
 * <p>
 * Due to this behavior, the delivery of neither render state updates nor
 * portlet client events can be guaranteed.
 * <p>
 * The portlet hub provides for orderly state transitions by allowing only a
 * single blocking operation ({@link action}, {@link setRenderState},
 * {@link startPartialAction}) to be active at any one time.
 * <p>
 * The state transition is considered to be active from the initial portlet
 * client call to one of the blocking operations until the portlet hub has
 * performed the requested state change and has informed all of the affected
 * portlet clients by firing the corresponding onStateChange events.
 * <p>
 * This has the following implications:
 * <ol>
 * <li> It is not possible to initiate a sequence of blocking operations.
 * <p>
 * For example, once a portlet client calls the {@link setRenderState} method,
 * it cannot call any additional blocking method until after its onStateChange
 * listener function has been called. </li>
 * <li> It is not possible to initiate a blocking operation during execution of
 * the onStateChange listener function, since execution of that function belongs
 * to the preceding state change operation. </li>
 * </ol>
 * <hr>
 * 
 * @namespace
 */
var portlet = portlet || {};

(function() {
   'use strict';

   // If module has already been loaded, don't load again
   if (typeof portlet.register === 'function') {
      return;
   }

   // ~~~~~~~~~~~~~~~~ Helper classes for parameters & state
   // ~~~~~~~~~~~~~~~~~~~
   
   function Parameters(p) {
      var n;
      if (p) {
         for (n in p) {
            if (p.hasOwnProperty(n) && Array.isArray(p[n])) {
               this[n] = p[n].slice(0);
            }
         }
      }
   }

   function State(s) {
      var n;
      this.parameters = {};
      if (s) {
         this.portletMode = s.portletMode;
         this.windowState = s.windowState;
         if (s.parameters) {
            for (n in s.parameters) {
               if (s.parameters.hasOwnProperty(n)
                     && Array.isArray(s.parameters[n])) {
                  this.parameters[n] = s.parameters[n].slice(0);
               }
            }
         }
      } else {
         this.portletMode = 'VIEW';
         this.windowState = 'NORMAL';
      }
   }
   State.prototype.clone = function() {
      return new State(this);
   };
   State.prototype.setPortletMode = function(pm) {
      if (typeof pm !== 'string') {
         throw new TypeError('Portlet mode must be a string');
      }
      this.portletMode = pm;
   };
   State.prototype.getPortletMode = function() {
      return this.portletMode;
   };
   State.prototype.setWindowState = function(ws) {
      if (typeof ws !== 'string') {
         throw new TypeError('Window state must be a string');
      }
      this.windowState = ws;
   };
   State.prototype.getWindowState = function() {
      return this.windowState;
   };
   State.prototype.setValue = function(name, value) {
      if (typeof name !== 'string') {
         throw new TypeError('Parameter name must be a string');
      }
      if (typeof value !== 'string' && value !== null && !Array.isArray(value)) {
         throw new TypeError(
               'Parameter value must be a string, an array, or null');
      }
      var val = value;
      if (!Array.isArray(value)) {
         val = [ value ];
      }
      this.parameters[name] = val;
   };
   State.prototype.setValues = State.prototype.setValue;
   State.prototype.remove = function(name) {
      if (typeof name !== 'string') {
         throw new TypeError('Parameter name must be a string');
      }
      if (this.parameters[name] !== undefined) {
         delete this.parameters[name];
      }
   };
   State.prototype.getValue = function(name, def) {
      if (typeof name !== 'string') {
         throw new TypeError('Parameter name must be a string');
      }
      var res = this.parameters[name];
      if (res) {
         res = res[0];
      }
      if (res === undefined) {
         res = def;
      }
      return res;
   };
   State.prototype.getValues = function(name, def) {
      if (typeof name !== 'string') {
         throw new TypeError('Parameter name must be a string');
      }
      var res = this.parameters[name];
      if (res === undefined) {
         res = def;
      }
      return res;
   };
   
   var portletConstants = {
      
      // Portlet mode
      "VIEW" : "view",
      "EDIT" : "edit",
      "HELP" : "help",
      
      // window state
      "NORMAL"    : "normal",
      "MINIMIZED" : "minimized",
      "MAXIMIZED" : "maximized",
      
      // Resource URL cacheability
      "FULL"      : "cacheLevelFull",
      "PAGE"      : "cacheLevelPage",
      "PORTLET"   : "cacheLevelPortlet"
   },

   // variable declarations
   portletRegex = "^portlet[.].*",

   /**
    * Portlet Hub Mockup internal structure defining the data held for each
    * portlet
    *
    * @typedef    PortletData
    * @property   {RenderState} state       The current RenderState object
    * @property {string[]} pubParms String array declaring the public parameters
    *           for the portlet
    * @property   {RenderData}   renderData  Render data for the portlet
    * @private
    */


   // Helper functions
   wnd = window, delay = function(aCallback, aTimeout) {
      wnd.setTimeout(aCallback, aTimeout);
   },


   // ~~~~~~~~~~~~~~~~~~~~~~ Exceptions ~~~~~~~~~~~~~~~~~~~~~~~~~~

   /**
    * Exception thrown when a portlet client is not allowed to access a data
    * element
    * 
    * @typedef    AccessDeniedException
    * @property {string} name The exception name, equal to
    *           "AccessDeniedException"
    * @property {string} message An optional message that provides more detail
    *           about the exception
    */
   throwAccessDeniedException = function(msg) {
      throw {
         name : "AccessDeniedException",
         message : msg
      };
   },

   /**
    * Thrown when a portlet attempts to use the API without comleting the
    * intialization process. In general, this means that the onStateChange
    * listener has not been added.
    *
    * @typedef    NotInitializedException
    * @property {string} name The exception name, equal to
    *           "NotInitializedException"
    * @property {string} message An optional message that provides more detail
    *           about the exception
    */
   throwNotInitializedException = function(msg) {
      throw {
         name : "NotInitializedException",
         message : msg
      };
   },

   /**
    * Maps from the the ID of the registered portlet to the implementation
    * callback
    */
   _registeredPortlets = {},

   /**
    * Shortcut for Object.keys
    *
    * @const
    * @type {function(Object):Array}
    */
   _getKeys = Object.keys,

   /**
    * Shortcut for the Array.isArray
    *
    * @const
    * @type {function(*):boolean}
    */
   _isArray = Array.isArray,

   /**
    * Checks if the object is an object
    *
    * @param {*}
    *            obj object
    * @return {boolean}
    */
   _isObject = function(obj) {
      return typeof obj === "object";
   },

   /**
    * Constructs a deep copy of the object
    *
    * @param {Object|Array}
    *            data
    * @return {Object|Array}
    */
   _clone = function(data) {
      // some helpers down the road
      var result, i, key, keys;
      // the array case
      if (_isArray(data)) {
         // construct a new array
         result = [];
         // fill the array
         for (i = data.length - 1; i >= 0; --i) {
            result[i] = _clone(data[i]);
         }
      } else if (_isObject(data)) {
         // construct a new object
         result = {};
         keys = _getKeys(data);
         for (i = keys.length - 1; i >= 0; --i) {
            key = keys[i];
            result[key] = _clone(data[key]);
         }
      } else {
         // just use the object as is
         result = data;
      }
      // ok
      return result;
   },

   // ~~~~~~~~~~~~~~~~~~~~~~ Event Handling ~~~~~~~~~~~~~~~~~~~~~~~~~~
   // for event handling
   handleCtr = 0,                         // used to generate handles returned by addEventListener

   /**
    * The internal data structure for managing listeners and the update queue.
    * 
    * @typedef  QueueData
    * @property {String}      handle   The listener handle
    * @property {string}      id       The portlet ID
    * @property {string}      type     The event type
    * @property {function}    callback The callback function for the event
    * @private 
    */

   // System listeners (onStateChange and onError). Associative arrays indexed
   // by portletID
   oscListeners = {}, oeListeners = {}, 

   // Portlet Client Event listeners. Associative array indexed by handle
   pcListeners = {},                      // portlet client event listeners

   // the portlet hub can only execute a single blocking operation
   // at a time. At the beginning of the operation, this flag is set to
   // true to prevent other blocking operations from beginning.
   // It is reset after the last onStateChange event resulting from the
   // state change has been fired.
   // (or also if a communication error occurs.)
   busy = false,

   // queue for the callback functions that need to be called. Each element
   // is a QueueData structure. Associative array indexed by handle.
   updateQueue = [],


   /**
    * Add an event listener of the given type to the specified portlet client
    * listener storage object.
    * <p>
    * The portlet client event listeners are stored in associative arrays
    * (objects) indexed by the event listener handle.
    *
    * @param {object}
    *            list The object where the listener will be stored
    * @param {string}
    *            pid The portletID
    * @param {string}
    *            etype The event type
    * @param {function}
    *            func The the listener function to be called
    * @private
    */
   addPCListener = function(list, pid, etype, func) {
      var hand = "handle-" + (++handleCtr);
      list[hand] = {
                     handle   : hand,
                     id       : pid,
                     type     : etype,
                     callback : func
                   };
      return hand;
   },


   /**
    * Removes an event listener identified by the portletId and handle from the
    * portlet client listener storage object
    * 
    * @param {object}
    *            list The object where the listener will be stored
    * @param {string}
    *            pid The portletID
    * @param {object}
    *            handle The event listener handle
    * @returns    {boolean}            <code>true</code> if the listener was removed
    * @throws     {AccessDeniedException}
    *             Thrown if the event listener associated with this handle was
    *             registered by a different portlet
    * @private
    */
   removePCListener = function(list, pid, handle) {
      if (typeof list[handle] === 'object') {

         // the listener was found, so if the portlet ID matches, remove it.
         if (list[handle].id === pid) {
            delete list[handle];
         } else {
            throwAccessDeniedException("Invalid handle for portlet ID=" + pid);
         }
         return true;
      }
      return false;
   },


   /**
    * Add an event listener of the given type to the specified system event
    * listener storage object.
    * <p>
    * The system event listeners are stored in associative arrays (objects)
    * indexed by portlet ID.
    *
    * @param {object}
    *            list The object where the listener will be stored
    * @param {string}
    *            pid The portletID
    * @param {string}
    *            etype The event type
    * @param {function}
    *            func The the listener function to be called
    * @private
    */
   addSystemListener = function(list, pid, etype, func) {

      // add the listener
      var hand = "handle-" + (++handleCtr);

      console.log("addSystemListener, handle=" + hand + ", pid=" + pid);

      list[hand] = {
                     handle   : hand,
                     id       : pid,
                     type     : etype,
                     callback : func
                   };
      return hand;
   },


   /**
    * Removes an event listener identified by the portletId and handle from the
    * system listener storage object
    * 
    * @param {object}
    *            list The object where the listener will be stored
    * @param {string}
    *            pid The portletID
    * @param {object}
    *            handle The event listener handle
    * @returns    {boolean}            <code>true</code> if the listener was removed
    * @private
    */
   removeSystemListener = function(list, pid, handle) {
      var ii;
      if (typeof list[handle] === 'object') {

         // the listener was found, so if the portlet ID matches, remove it.
         if (list[handle].id === pid) {
            delete list[handle];

            // purge any pending notifications -
            ii = updateQueue.length;
            while (ii-- >= 0) {
               if (updateQueue[ii] === handle) {
                  updateQueue.splice(ii, 1);
               }
            }

            return true;
         }
      }
      return false;
   },


   /**
    * Sends an onError event to all registered error event handlers for a given
    * portlet.
    * 
    * @param {string}
    *            pid The portletID
    * @param {string}
    *            err The error message
    * @private
    */
   reportError = function(pid, err) {
      delay(function() {
         var handle;
         for (handle in oeListeners) {
            if (oeListeners.hasOwnProperty(handle)) {
               if (oeListeners[handle].id === pid) {
                  oeListeners[handle].callback('portlet.onError', err);
               }
            }
         }
      }, 0);
   },
   

   /**
    * Returns true if an onStateChange listener is registered for the portlet
    * 
    * @param {string}
    *            pid The portletID
    * @returns {boolean} <code>true</code> if a listener is registered
    * @private
    */
   hasListener = function(pid) {
      var handle;
      for (handle in oscListeners) {
         if (oscListeners.hasOwnProperty(handle)) {
            if (oscListeners[handle].id === pid) {
               return true;
            }
         }
      }
      return false;
   },

   // ~~~~~~~~~~~~~~~~~~~~~~ State handling ~~~~~~~~~~~~~~~~~~~~~~~~~~
   //

   /**
    * Calls the portlet onStateChange method in an asynchronous manner in order
    * to decouple the public API. This method is intended for use after a
    * portlet client registers an onStateChange listener.
    * <p>
    * In a real implementation, the portlet hub might need to communicate with
    * the portal server to obtain data.
    * 
    * @param {string}
    *            pid The portlet ID
    * @private
    */
   _updateStateForPortlet = function(pid) {
      var handle, qdata, dup, ii;

      console.log("_updateStateForPortlet", pid);

      // enqueue update elements for all listeners registered for pid,
      // adding each listener a single time only.
      for (handle in oscListeners) {
    	 dup = false;
         if (oscListeners.hasOwnProperty(handle)) {
            qdata = oscListeners[handle];
            if (qdata.id === pid) {
               for (ii = 0; ii < updateQueue.length; ii++) {
            	   if (updateQueue[ii].handle == handle) {
            		   dup = true;
            		   break;
            	   }
               }
               if (dup === false) {
            	  updateQueue.push(qdata);
                  console.log("Queued update: handle=" + qdata.handle
                        + ", pid=" + qdata.id + ", Queue length="
                        + updateQueue.length)
               }
            }
         }
      }

      if (updateQueue.length >= 1) {
         delay(function() {
            var qdata, state, data, callback, pi;

            // The busy flag is usually set by the caller.
            // but ... need more thought here. When the onStateChange
            // listener is added, the busy flag isn't set in order to avoid
            // blocking the state changes, since adding a listener doesn't
            // change the state. So it's set here, before onStateChange is
            // called so that the state change functions are blocked.
            busy = true;

            while (updateQueue.length > 0) {

               // get the next queue element and call its
               // onStateChange function
               qdata = updateQueue.shift();

               console.log("Dispatch update: handle=" + qdata.handle + ", pid="
                     + qdata.id + ", Queue length=" + updateQueue.length);

               pi = _registeredPortlets[qdata.id];

               state = new State(pi.getState());
               data = pi.getRenderData();
               callback = qdata.callback;

               if ((data !== undefined) && (data !== null)
                     && (data.content !== undefined)
                     && (data.content !== null)) {
                  callback("portlet.onStateChange", state, data);
               } else {
                  callback("portlet.onStateChange", state);
               }
            }
            busy = false;
         }, 0);
      }
   },

   // queue for client events
   ceQueue = [],

   /**
    * dispatches the client events.
    *
    * @param {string}
    *            type The portlet ID
    * @param {function}
    *            callback Callback function
    * @param {any}
    *            payload Event payload
    * @private
    */
   dispatchCE = function(type, callback, payload) {
      var evt = [];

      evt.push(callback);
      evt.push(type);
      evt.push(payload);

      ceQueue.push(evt);

      if (ceQueue.length === 1) {
         delay(function() {
            var event, aType, aCallback, aPayload;

            while (ceQueue.length > 0) {

               // dispatch next event
               event = ceQueue.shift();

               aCallback = event[0];
               aType = event[1];
               aPayload = event[2];

               aCallback(aType, aPayload);
            }
         }, 0);
      }
   },

   /**
    * Accepts an object containing changed render states. Updates the state for
    * each portlet present.
    *
    * @param {string}
    *            upids array of portlet IDs to be updated
    * @private
    */
   updatePageState = function(upids) {
      var ii;
      
      if (upids.length === 0) {
         busy = false;
      } else {
      for (ii = 0; ii < upids.length; ii++) {
         _updateStateForPortlet(upids[ii]);
      }
      }

   },

   /**
    * Accepts an object containing changed portlet IDs. This function is meant
    * to be used by the Portlet Hub impl in order to initiate an unsolicited
    * state update for the input list of portlet IDs.
    *
    * @returns {Promise} fulfilled with the actual upddate function when the hub
    *          is not busy.
    *
    * @private
    */
   updateWhenIdle = function(upids) {
      return new Promise(function(resolve) {
         function update() {
            if (busy) {
               delay(update, 20);
            } else {
               busy = true;
               resolve(updatePageState);
            }
         }
         update();
      });
   },

   /**
    * Updates the render state, taking the public render parameters into
    * account. The portlet client requesting the change, represented by the
    * supplied portelt ID, is updated, along with each portlet that has a public
    * render parameter update.
    * 
    * @param {string}
    *            pid The portlet ID
    * @param {RenderState}
    *            state The new render state
    * @throws  {AccessDeniedException}
    *             Thrown if a blocking operation is already in progress.
    * @throws  {NotInitializedException}
    *                   Thrown if a portlet ID is provided, but no onStateChange
    *                   listener has been registered.
    * @private
    */
   updateState = function(pid, state) {
      var pi;

      // do necessary checks

      if (busy === true) {
         throwAccessDeniedException("Operation in progress");
      } else if (!hasListener(pid)) {
         throwNotInitializedException("No onStateChange listener registered for portlet: "
               + pid);
      }

      busy = true;
      
      // Set state in the implementation. The setState function returns an
      // array of portlet
      // IDs for portlets that need to be updated. Update the page state using
      // this info.
      // If an error occurred, post the error to the onError handler, if one
      // is present.
      
      pi = _registeredPortlets[pid];
      pi.setState(state).then(function(upids) {
         updatePageState(upids);
      }, function(err) {
         busy = false;
         reportError(pid, err);
      });
       
   },


   // ~~~~~~~~~~~~~~~~~~~~~~ Other functions ~~~~~~~~~~~~~~~~~~~~~~~~~~

   /**
    * Used by the portlet hub methods to check the number and types of the
    * arguments.
    *
    * @private
    * @param {string[]}
    *            parms The argument list to be checked
    * @param {number}
    *            minParms The minimum number of arguments
    * @param {number}
    *            maxParms The maximum number of arguments. If this value is
    *           undefined, the function can take any number of arguments greater
    *           than numArgs
    * @param {string[]}
    *            types An array containing the expected parameter types in the
    *            order of occurrance in the argument array
    * @throws {TypeError}
    *                               Thrown if the parameters are in some manner incorrect
    */
   checkArguments = function(parms, minParms, maxParms, types) {

      // Check for the minimum number of arguments
      if (parms.length < minParms) {
         throw new TypeError(
               "Too few arguments provided. Number of arguments: "
               + parms.length);

         // check for maximum number of arguments
      } else if ((typeof maxParms === 'number') && (parms.length > maxParms)) {
         throw new TypeError("Too many arguments provided: "
               + [].join.call(parms, ', '));

         // check if the argument types are as expected if provided with
         // types
      } else if (types) {

         var ii;
         for (ii = Math.min(parms.length, types.length) - 1; ii >= 0; ii = ii - 1) {
            if (typeof parms[ii] !== types[ii]) {
               throw new TypeError("Parameter " + ii + " is of type "
                     + (typeof parms[ii]) + " rather than the expected type "
                     + types[ii]);
            }

            // If checking for types, also make sure the arguments are
            // neither
            // null nor undefined.
            if ((parms[ii] === null) || (parms[ii] === undefined)) {
               throw new TypeError("Argument is " + (typeof parms[ii]));
            }
         }
      }
   },

   /**
    * Verifies that the input parameters are in valid format.
    * <p>
    * Parameters must be an object containing parameter names. It may also
    * contain no property names which represents the case of having no
    * parameters.
    * <p>
    * If properties are present, each property must refer to a array of string
    * values. The array length must be at least 1, because each parameter must
    * have a value. However, a value of 'null' may appear in any array entry.
    * <p>
    * To represent a <code>null</code> value, the property value must equal
    * [null].
    *
    * @param {PortletParameters}
    *            parms The parameters to check
    * @private
    * @throws {TypeError}
    *             Thrown if the parameters are incorrect
    */
   validateParms = function(parms) {
      var parm;

      // check for null or undefined argument
      if ((parms === null) || (parms === undefined)) {
         throw new TypeError("The parameters object is " + (typeof parms));
      }

      for (parm in parms) {
         if (parms.hasOwnProperty(parm)) {
            if (Object.prototype.toString.call(parms[parm]) !== '[object Array]') {
               throw new TypeError("Invalid parameters. The value of " + parm
                     + " is " + Object.prototype.toString.call(parm)
                     + " rather than '[object Array]'");
            } else if (parms[parm].length === 0) {
               throw new TypeError("Invalid parameters. The value of " + parm
                     + " is " + "an array with length 0.");
            }
         }
      }
   },

   /**
    * Tests whether the given portlet mode is allowed
    */
   _isAllowedPM = function(pid, pm) {
      var pi = _registeredPortlets[pid];
      return (pi.getAllowedPM().indexOf(pm) >= 0);
   },

   /**
    * Tests whether the given window state is allowed
    */
   _isAllowedWS = function(pid, ws) {
      var pi = _registeredPortlets[pid];
      return (pi.getAllowedWS().indexOf(ws) >= 0);
   },

   /**
    * Verifies that the input parameters are in valid format, that the portlet
    * mode and window state values are allowed for the portlet.
    *
    * @param {string}
    *            pid The portlet ID
    * @param {RenderState}
    *            state The render state object to check
    * @private
    * @throws {TypeError}
    *             Thrown if any component of the state is incorrect
    */
   validateState = function(pid, state) {
      var pi = _registeredPortlets[pid];

      validateParms(state.parameters);

      // see if the portlet mode is a string and is a value allowed for the
      // portlet
      if ((state.portletMode === undefined)
            || (typeof state.portletMode !== 'string')) {
         throw new TypeError("Invalid parameters. portletMode is "
               + (typeof state.portletMode));
      } else {
         state.portletMode = state.portletMode.toLowerCase();
         if (!_isAllowedPM(pid, state.portletMode)) {
            throw new TypeError("Invalid portletMode=" + state.portletMode
                  + " is not in " + pi.getAllowedPM());
      }
      }
      
      // see if the windowState is a string and is a value allowed for the
      // portlet
      if ((state.windowState === undefined)
            || (typeof state.windowState !== 'string')) {
         throw new TypeError("Invalid parameters. windowState is "
               + (typeof state.windowState));
      } else {
         state.windowState = state.windowState.toLowerCase();
         if (!_isAllowedWS(pid, state.windowState)) {
            throw new TypeError("Invalid windowState=" + state.windowState
                  + " is not in " + pi.getAllowedWS());
      }
      }

   },


   /**
    * sets up for the action.
    *
    * @param {string}
    *            type The URL type
    * @param {string}
    *            pid The portlet ID
    * @param {PortletParameters}
    *            parms Additional parameters. May be <code>null</code>
    * @param {HTMLFormElement}
    *            Form to be submitted May be <code>null</code>
    * @throws  {AccessDeniedException}
    *             Thrown if a blocking operation is already in progress.
    * @throws  {NotInitializedException}
    *                   Thrown if a portlet ID is provided, but no onStateChange
    *                   listener has been registered.
    * @private
    */
   setupAction = function(pid, parms, element) {
      var pi;
      
      // do necessary checks

      if (busy === true) {
         throwAccessDeniedException("Operation in progress");
      } else if (!hasListener(pid)) {
         throwNotInitializedException("No onStateChange listener registered for portlet: "
               + pid);
      }

      busy = true;

      // execute the action. The promise is fulfilled with an array of IDs of
      // portlets to be updated.
      // If an error occurred, post the error to the onError handler, if one
      // is present.

      pi = _registeredPortlets[pid];
      return pi.executeAction(parms, element).then(function(upids) {
         return updatePageState(upids);
      }, function(err) {
         busy = false;
         reportError(pid, err);
      });

   },

   /**
    * Callback function that must be called after a partial action has been
    * started.
    * <p>
    * The page state is generated by the portal and transmitted to the client by
    * the portlet. The portlet client that initiated the partial action must
    * pass the page state string to this function.
    * <p>
    * The callback should only be called once to conclude a partial action
    * sequence.
    * 
    * @param {string}
    *            pid The portlet ID for operation
    * @param {string}
    *            ustr The new page state in string form
    * @throws {TypeError}
    *                      Thrown if the parameter is not a string
    * @name       setPageState
    * @callback   setPageState
    */
   setPageState = function(pid, ustr) {
      var pi;

      // Perform some checks on the update string. allow null string.
      if ((ustr === undefined)
            || ((ustr !== null) && (typeof ustr !== 'string'))) {
         throw new TypeError("Invalid update string: " + ustr);
      }

      // convert page state into an object.
      // update each affected portlet client. Makes use of a 
      // mockup-specific function for decoding. 

      pi = _registeredPortlets[pid];
      pi.decodeUpdateString(ustr).then(function(upids) {
      updatePageState(upids);
      }, function(err) {
         busy = false;
         reportError(pid, err);
      });

   };

   // ~~~~~~~~~~~~~~~~ Register function ~~~~~~~~~~~~~~~~~~~

   /**
    * Registers a portlet client with the portlet hub.
    * <p>
    * The portlet client calling this method must provide a valid portlet ID.
    * The portlet ID is identical to the unique namespace provided by the portal
    * server for the portlet.
    *
    * @param {string}
    *            portletId The unique portlet identifier
    * @returns {Promise} A Promise object. Returns an {@link PortletInit} object
    *          containing functions for use by the portlet client on successful
    *          resolution. Returns an Error object containing a descriptive
    *          message on failure.
    */
   portlet.register = function(portletId) {

      console.log("register", portletId);

      // check for exactly 1 argument of type 'string'
      checkArguments(arguments, 1, 1, [ 'string' ]);

      /**
       * Dispatched to the implementation. The promise will be fulfilled as soon
       * as the implementation has assembled the required information. From that
       * point on it is valid to call into other functions on the
       * implementation. These other functions as passed in as an argument
       */
      return portlet.impl
            .register(portletId, updateWhenIdle)
            .then(
                  function(portletImpl) {

                     console.log("register implementation is ready ...",
                           portletImpl);

                     /**
                      * Keep track of the callback functions for our portlets
                      */
                     _registeredPortlets[portletId] = portletImpl;

                     /**
                      * Returned by the {@link portlet.register} method to
                      * provide functions for use by the portlet client.
                      * 
                      * @namespace PortletInit
                      */
                     return {
         
            /**
                         * A string array containing the portlet modes that are
                         * defined for the portlet.
             * <p>
                         * Note that even if a portlet mode is defined, it may
                         * not be allowed, depending on access rights or other
                         * conditions.
             *
                         * @property {string[]} portletModes The defined portlet
                         *           mode values
             * @memberOf         PortletInit
             */
            portletModes : portletImpl.getAllowedPM(),
         
            /**
                         * A string array containing the window states that are
                         * defined for the portlet.
             * <p>
                         * Note that even if a window state is defined, it may
                         * not be allowed, depending on access rights or other
                         * conditions.
             *
                         * @property {string[]} windowStates The defined window
                         *           state values
             * @memberOf         PortletInit
             */
            windowStates : portletImpl.getAllowedWS(),
         
            /**
                         * Adds a listener function for specified event type.
             * <p>
                         * The portlet hub defines two classes of events -
                         * System Events and Portlet Client events:
             * <dl>
             * <dt>System Events</dt>
                         * <dd> Events that are generated by the portlet hub.
                         * They are used to pass portlet-specific information to
                         * the registered portlet client. The parameters passed
                         * to the system event callback functions are defined by
                         * the portlet hub.
                         * <p>
                         * Event types prefixed with "portlet." are reserved for
                         * system events. System event types may not be
                         * specified with a regular expression or wildcard.
                         * However, the same event listener may be added for
                         * both types of system events.
             * <p>
                         * Only one listener for each type of system event may
                         * be added.
             * <p>
             * The following system event types are defined:
             * <dl>
             * <dt>portlet.onStateChange</dt>
                         * <dd> Fired when the render state changes. In order to
                         * participate in the portlet Ajax support, a portlet
                         * client must register an {@link onStateChange} event
                         * listener for this event type.
                         * <p>
                         * After the portlet client adds an event listener for
                         * the onStateChange event, the portlet hub will call
                         * the onStateChange callback function to provide the
                         * portlet client with its initial state information.
                         * However, this will not occur before the call to
                         * addEventListener returns. </dd>
             * <dt>portlet.onError</dt>
                         * <dd> Fired when an error occurs that cannot be
                         * communicated through an exception. In general, this
                         * will be some type of asynchronous communication
                         * error. In order to receive notification about errors,
                         * a portlet must register an {@link onError} event
                         * listener for this event type. </dd>
             * </dl>
             * </dd>
             * <dt>Portlet Client Events</dt>
                         * <dd> Events initiated by the portlet client through
                         * the dispatch method.
             * <p>
                         * When adding a listener for a portlet client event,
                         * the event type may be specified by a regular
                         * expression string. The listener will be called for
                         * every event type that the regular expression string
                         * matches.
                         * <p>
                         * Example: <br>
                         * myHub.addEventListener("^myCompany\..*", myListener); //
                         * registers myListener for all event types beginning
                         * with "myCompany." </dd>
             * </dl>
             * <p>
                         * An event listener can be added for multiple event
                         * types. This function returns a handle to identify the
                         * unique listener for the event type and for the
                         * portlet client associated with the function.
                         * 
                         * @param {string}
                         *            type The type of listener
                         * @param {function}
                         *           func Function called when event occurs
             *
                         * @returns {object} A handle that can be used to remove
                         *          the event listener
             *
                         * @throws {TypeError}
                         *            Thrown if the input parameters are invalid
             *
             * @memberOf            PortletInit
             */
                        addEventListener : function(type, func) {
         
                           // check for exactly 2 arguments of type
                           // 'string' and 'function'
                           checkArguments(arguments, 2, 2, [ 'string',
                                 'function' ]);
         
               var handle, listeners;
         
               if (type.match(portletRegex)) {
         
                  // Handle adding system event listener.
                              // if it is neither a
                              // portlet.onStateChange nor a
                              // portlet.onError event, throw
                              if ((type !== "portlet.onStateChange")
                                    && (type !== "portlet.onError")) {
                                 throw new TypeError(
                                       "The system event type is invalid: "
                                       + type);
                  }
         
                  if (type === "portlet.onStateChange") {
                                 listeners = oscListeners; // add
                                                      // the
                                                      // onStateChange
                                                      // listener
                  } else {
                                 listeners = oeListeners; // add
                                                      // the
                                                      // onError
                                                      // listener
                  }
         
                              // will throw an exception if the
                              // listener has already been added
                              handle = addSystemListener(listeners, portletId,
                                    type, func);
         
                              // If just added an onStateChange
                              // listener, update the state
                  if (type === "portlet.onStateChange") {
                     _updateStateForPortlet(portletId);
                  }
         
               } else {
         
                  // Portlet client event listener
                              handle = addPCListener(pcListeners, portletId,
                                    type, func);
               }
         
               return handle;
            },
         
            /**
                         * Removes a previously added listener function
                         * designated by the handle. The handle must be the same
                         * object previously returned by the addEventListener
                         * function.
                         * 
                         * @param {object}
                         *           handle The handle of the listener to be
                         *           removed
             *
                         * @throws {TypeError}
                         *            Thrown if the input parameters are invalid
             * @throws  {AccessDeniedException}
                         *            Thrown if the event listener associated
                         *            with this handle was registered by a
                         *            different portlet
             *
             * @memberOf            PortletInit
             */
                        removeEventListener : function(handle) {
         
                           // check for exactly 1 argument. Don't check
                           // the argument type.
               checkArguments(arguments, 1, 1, []);
         
               // check for null or undefined argument
                           if ((handle === null) || (handle === undefined)) {
                              throw new TypeError("The argument provided is "
                                    + (typeof handle));
                           }

                           // Try to remove the listener from each of
                           // the listener arrays
                           // one after the other. If not successful,
                           // the handle was invalid
                           // (or an exception will be thrown by
                           // removePCListener), so throw.

                           if ((removePCListener(pcListeners, portletId, handle) === false)
                                 && (removeSystemListener(oscListeners,
                                 portletId, handle) === false)
                                 && (removeSystemListener(oeListeners,
                                       portletId, handle) === false)) {
         
                              throw new TypeError(
                                    "The event listener handle doesn't match any listeners.");
               }
            },
         
            /**
                         * Sets the render state, which consists of the public
                         * and private render parameters, the portlet mode, and
                         * the window state.
                         * <p>
                         * When the render state has been successfully set, a
                         * copy of the render state will be provided to the
                         * portlet client through the {@link onStateChange}
                         * listener function. A portlet client can modify this
                         * state object and pass it to the setRenderState
                         * function to update the render state.
                         * <p>
                         * However, it is also possible for the portal to
                         * completely refresh the page as a response to setting
                         * the render state. This may occur in order to support
                         * portlets on the page that do not participate in the
                         * Portlet 3.0 Ajax support or due to configuration
                         * settings, for example.
                         * <p>
                         * If the page is completely refreshed, it will be
                         * rendered according to render parameters set on the
                         * server.
                         * <p>
                         * Setting the render state is a blocking operation. To
                         * allow for orderly state transitions, the portlet hub
                         * does not allow this function to be used while a
                         * blocking operation is in progress. A blocking
                         * operation is considered to be in progress from the
                         * initial call until the final onStateChange event for
                         * that operation has been fired. See {@link portlet}
                         * for further information.
             *
                         * @param {RenderState}
                         *            state The new state to be set
             *
                         * @throws {TypeError}
                         *            Thrown if the input parameters are invalid
             * @throws  {AccessDeniedException}
                         *            Thrown if a blocking operation is already
                         *            in progress.
             * @throws  {NotInitializedException}
                         *            Thrown if a portlet ID is provided, but no
                         *            onStateChange listener has been
                         *            registered.
             *
             * @memberOf   PortletInit
             */
                        setRenderState : function(state) {

               console.log("setRenderState", state);

                           // check for exactly 1 argument of type
                           // 'object'
                           // make sure an onStateChange listener is
                           // registered by providing portlet ID
                           checkArguments(arguments, 1, 1, [ 'object' ]);
         
                           // validate render state & throw exception
                           // if incorrect
               validateState(portletId, state);
         
                           // Ok so far, so do the update. Throws if
                           // busy or no callback registered
               updateState(portletId, state);
         
            },


            /**
                         * Returns a promise for a resource URL with parameters
                         * set appropriately for the page state according to the
                         * resource parameters, cacheability option, and
                         * resource ID provided.
                         * <p>
                         * The portlet client may use the resource URL with any
                         * appropriate javascript framework to retrieve content
                         * from the portlet through the server-side
                         * serveResource method.
                         * <p>
                         * Resource parameters are optional parameters attached
                         * to a resource URL in addition to any render state
                         * values that may be present. Resource parameters do
                         * not influence the render state.
                         * <p>
                         * The resource parameters must be an object containing
                         * properties representing parameter names whose values
                         * must be an array of string values, as described under
                         * {@link PortletParameters}. All of the resource
                         * parameters will be attached to the URL. Use of
                         * resource parameters is optional.
                         * <p>
                         * The cacheability option designates the degree to
                         * which the content to be served can be cached and
                         * influences the type of content that can be served.
                         * There are three possible values:
             * <dl>
                         * <dd>"full"</dd>
                         * <dt> Most cacheable, because the URL contains no
                         * portlet-specific or page-specific information. </dt>
                         * <dd>"portlet"</dd>
                         * <dt> More cacheable, because the URL contains only
                         * portlet-specific but no page-specific information.
                         * </dt>
                         * <dd>"page"</dd>
                         * <dt> Least cacheable because the URL contains
                         * portlet-specific and page-specific information.
                         * <p>
                         * However, cacheability must be set to "page" if the
                         * content to be served contains portal URLs. </dt>
             * </dl>
             * <p>
                         * Specification of cacheability is optional. If the
                         * cacheability is not specified, cacheability for the
                         * URL will be set to "PAGE".
                         * <p>
                         * The resource ID is an additional identifying string
                         * that the resource serving method on the server can
                         * use to determine the information to be provided. The
                         * resource ID argument is optional.
                         * <p>
                         * The parameters must be provided in the defined order.
                         * However, if a preceding argument is not needed, it
                         * may be specified as <code>null</code>. Examples of
                         * valid calls: <code>
             * <br>createResourceUrl();
             * <br>createResourceUrl(resParams, cache);
                         * <br>createResourceUrl(resParams, cache, resid);
             * <br>createResourceUrl(resParams);
                         * <br>createResourceUrl(<code>null</code>, cache);
                         * <br>createResourceUrl(<code>null</code>, <code>null</code>, resid);
             * </code>
             *
                         * @param {PortletParameters}
                         *           resParams Resource parameters to be added
                         *           to the URL
                         * @param {string}
                         *           cache Cacheability option. The strings
                         *           defined under {@link PortletConstants}
                         *           should be used to specifiy cacheability.
                         * @param {string}
                         *            resid Resource ID.
                         * 
                         * @returns {Promise} A Promise object. Returns a string
                         *          representing the resource URL on successful
                         *          resolution. Returns an Error object
                         *          containing a descriptive message on failure.
             *
                         * @throws {TypeError}
                         *            Thrown if the input parameters are invalid
             *
             * @memberOf   PortletInit
             */
                        createResourceUrl : function(resParams, cache, resid) {
                           var ii, arg, cacheability = null, pi, rid = null;

                           // check arguments. make sure there is a
                           // maximum of two
                           // args and determine the types. Check
                           // values as possible.
                           if (arguments.length > 3) {
                              throw new TypeError(
                                    "Too many arguments. 3 arguments are allowed.");
                           }

                           if (resParams) {
                              if (typeof resParams === 'object') {
                                 validateParms(resParams); // throws
                                                      // if
                                                      // parms
                                                      // are
                                                      // invalid
                              } else {
                                 throw new TypeError(
                                       "Invalid argument type. Resource parameters must be a parameters object.");
                              }
               }
         
                           if (cache) {
                              if (typeof cache === 'string') {
                                 switch (cache) {
                     case "cacheLevelPage":
                     case "cacheLevelPortlet":
                     case "cacheLevelFull":
                                    cacheability = cache;
                        break;
                     default:
                                    throw new TypeError(
                                          "Invalid cacheability argument: "
                                          + cache);
                     }
                   } else {
                                 throw new TypeError(
                                       "Invalid argument type. Cacheability argument must be a string.");
                  }
               }
               
               // fallback to page level cacheability
               if (!cacheability) {
                  cacheability = "cacheLevelPage";
               }
         
                           if (resid) {
                              if (typeof resid === 'string') {
                                 rid = resid;
                              } else {
                                 throw new TypeError(
                                       "Invalid argument type. Resource ID argument must be a string.");
                              }
                           }

               // everything ok, so get URL from the impl
               pi = _registeredPortlets[portletId];
                           return pi.getUrl("RESOURCE", resParams,
                                 cacheability, rid);
            },
         
            /**
                         * Initiates a portlet action using the specified action
                         * parameters and element arguments.
             * <p>
                         * When the action has successfully completed, a copy of
                         * the render state will be provided to the portlet
                         * client through the {@link onStateChange} listener
                         * function. A portlet client can modify this state
                         * object and pass it to the setRenderState function to
                         * update the render state.
                         * <p>
                         * However, it is also possible for the portal to
                         * completely refresh the page as a response to the
                         * action. This may occur in order to support portlets
                         * on the page that do not participate in the Portlet
                         * 3.0 Ajax support or due to configuration settings,
                         * for example.
                         * <p>
                         * If the page is completely refreshed, it will be
                         * rendered according to render parameters set on the
                         * server.
                         * <p>
                         * Action parameters are optional parameters attached to
                         * a action URL in addition to any render state values
                         * that may be present. Action parameters do not
                         * influence the render state.
                         * <p>
                         * The action parameters must be an object containing
                         * properties representing parameter names whose values
                         * must be an array of string values, as described under
                         * {@link PortletParameters}. All of the action
                         * parameters will be attached to the URL. Use of action
                         * parameters is optional.
                         * <p>
                         * If the <code>element</code> argument is present, it
                         * must refer to an HTML form to be submitted. The
                         * portlet hub will use this form to execute the action.
                         * <p>
                         * If the form element is specified, the encoding type
                         * must be 'application/x-www-form-urlencoded' or
                         * 'multipart/form-data'. The encoding type 'text/plain'
                         * is not supported.
                         * <p>
                         * If the encoding type is 'multipart/form-data', the
                         * submission method must be 'POST'. Form 'INPUT'
                         * elements of type 'FILE' are supported.
                         * <p>
                         * If the encoding type is
                         * 'application/x-www-form-urlencoded', the submission
                         * method can be either 'GET' or 'POST'. However, form
                         * 'INPUT' elements of type 'FILE' are not supported.
                         * <p>
                         * Specification of <code>element</code> is optional.
                         * If the <code>element</code> is not specified, the
                         * portlet hub will submit the action to the server by
                         * executing a 'POST' with an action URL containing any
                         * action parameters provided.
                         * <p>
                         * The parameters may be specified in either order,
                         * individually, or not at all. Examples of valid calls:
                         * <code>
             * <br>action();
             * <br>action(actParams, element);
             * <br>action(actParams);
             * <br>action(element);
             * </code>
             * <p>
                         * A portlet action is a blocking operation. To allow
                         * for orderly state transitions, the portlet hub does
                         * not allow this function to be used while a blocking
                         * operation is in progress. A blocking operation is
                         * considered to be in progress from the initial call
                         * until the final onStateChange event for that
                         * operation has been fired. See {@link portlet} for
                         * further information.
             * <p>
             * 
             *
                         * @param {PortletParameters}
                         *           actParams Action parameters to be added to
                         *           the URL (optional)
                         * @param {HTMLFormElement}
                         *           element DOM element of form to be submitted
                         *           (optional)
                         * 
                         * @returns {Promise} A Promise object that is resolved
                         *          with no argument when the action request has
                         *          completed.
             *
                         * @throws {TypeError}
                         *            Thrown if the input parameters are invalid
             * @throws  {AccessDeniedException}
                         *            Thrown if a blocking operation is already
                         *            in progress.
             * @throws  {NotInitializedException}
                         *            Thrown if a portlet ID is provided, but no
                         *            onStateChange listener has been
                         *            registered.
             *
             * @memberOf   PortletInit
             */
                        action : function(actParams, element) {
               var ii, arg, type, parms = null, el = null, meth;
         
                           console.log("Executing action for portlet: "
                                       + portletId);
                           // check arguments. make sure there is a
                           // maximum of two
                           // args and determine the types. Check
                           // values as possible.
               if (arguments.length > 2) {
                              throw new TypeError(
                                    "Too many arguments. 2 arguments are allowed.");
               }
         
               ii = arguments.length;
                           while (--ii >= 0) {
                  arg = arguments[ii];
                              type = Object.prototype.toString.call(arg);
                  if (type === '[object HTMLFormElement]') {
                     if (el === null) {
                        el = arg;
                     } else {
                                    throw new TypeError(
                                          "too many [object HTMLFormElement] arguments: "
                               + arg + ", " + el);
                     }
                  } else if (type === '[object Object]') {
                                 validateParms(arg); // throws if
                                                // parms are
                                                // invalid
                     if (parms !== null) {
                                    throw new TypeError(
                                          "too many parameters arguments.");
                     }
                     parms = arg;
                              } else if (arg !== undefined) {
                                 throw new TypeError(
                                       "Invalid argument type. Argument "
                                             + (ii + 1) + " is of type " + type);
                  }
               }
               
                           // if we're dealing with a form, verify
                           // method and enctype
               console.log("form element", el);
               
               if (el) {
                              meth = el.method ? el.method.toUpperCase()
                                    : undefined;
            	   
                              if (meth && (meth !== 'POST') && (meth !== 'GET')) {
                                 throw new TypeError("Invalid form method "
                                       + el.method
                                       + ". Allowed methods are GET & POST ");
                              }

                              // allow the default, which is
                              // 'application/x-www-form-urlencoded'
                              // encoded, and also multipart/form-data
                              if (el.enctype
                                    && el.enctype !== 'application\/x-www-form-urlencoded'
                                    && el.enctype !== 'multipart\/form-data') {
                                 throw new TypeError(
                                       "Invalid form enctype "
                                       + el.enctype
                                       + ". Allowed: 'application\/x-www-form-urlencoded' & 'multipart\/form-data'  ");
                              }

                              if (el.enctype
                                    && (el.enctype === 'multipart\/form-data')
                                    && (meth !== 'POST')) {
                                 throw new TypeError(
                                       "Invalid method with multipart/form-data. Must be POST.");
                  }
                  
                              // if the data is supposed to be
                              // urlencoded, we don't suport FILE
                              // element
                              if (!el.enctype
                                    || (el.enctype === 'application\/x-www-form-urlencoded')) {
                     for (ii = 0; ii < el.elements.length; ii++) {
                                    if (el.elements[ii].nodeName.toUpperCase() === 'INPUT'
                                          && el.elements[ii].type.toUpperCase() === 'FILE') {
                                       throw new TypeError(
                                             "Must use enctype = 'multipart/form-data' with input type FILE.");
                        }
                     }
                  }
              }
         
               // everything ok, so do the action
         
               return setupAction(portletId, parms, el);
            },
         
            /**
             * Starts partial action processing and returns a
             * {@link PartialActionInit} object to the caller. The
                         * <code>PartialActionInit</code> object contains a
                         * partial action URL and a {@setPageState} callback
                         * function. The partial action URL can be used to
                         * initiate an action request. The {@setPageState}
                         * callback function allows the portlet client to
                         * complete the partial action operation by updating the
                         * state of all portlet clients on the page that are
                         * affected by action and event processing on the server
                         * resulting from the partial action.
                         * <p>
                         * After the <code>setPageState</code> function has
                         * been called, a copy of the render state will be
                         * provided to each affected portlet client through the
                         * {@link onStateChange} listener function.
                         * <p>
                         * In addition, the {@link onStateChange} listener
                         * function for the initiating portlet will be provided
                         * with a {@link RenderData} object, which contains the
                         * same data as would be available through a portlet
                         * resource request using the current render state with
                         * no additional resource parameters and with the
                         * resource URL cacheability option set to "PAGE".
                         * <p>
                         * Note that HTTP header information for the partial
                         * action response is set by the action processing
                         * method on the server. Any header information set by
                         * the resource method called to obtain the
                         * {@link RenderData} will be lost. If the portlet
                         * client needs access to the header data set by the
                         * resource method, it should create a resource URL and
                         * fetch the resource data on its own when the
                         * {@link onStateChange} listener function is called
                         * after the partial action has been performed.
                         * <p>
                         * However, it is also possible for the portal to
                         * completely refresh the page as a response to the
                         * action. This may occur in order to support portlets
                         * on the page that do not participate in the Portlet
                         * 3.0 Ajax support or due to configuration settings,
                         * for example.
                         * <p>
                         * If the page is completely refreshed, it will be
                         * rendered according to render parameters set on the
                         * server.
                         * <p>
                         * Action parameters are optional parameters attached to
                         * a action URL in addition to any render state values
                         * that may be present. Action parameters do not
                         * influence the render state.
                         * <p>
                         * The action parameters must be an object containing
                         * properties representing parameter names whose values
                         * must be an array of string values, as described under
                         * {@link PortletParameters}. All of the action
                         * parameters will be attached to the URL. Use of action
                         * parameters is optional.
             * <p>
                         * A partial action is a blocking operation. To allow
                         * for orderly state transitions, the portlet hub does
                         * not allow this function to be used while a blocking
                         * operation is in progress. A blocking operation is
                         * considered to be in progress from the initial call
                         * until the final onStateChange event for that
                         * operation has been fired. See {@link portlet} for
                         * further information.
             * 
             * @param {PortletParameters}
                         *           actParams Action parameters to be added to
                         *           the URL (optional)
             * 
             * @returns {Promise} A Promise object. Returns a
                         *          {PortletActionInit} object containing a
                         *          partial action URL and the setPageState
                         *          callback function on successful resolution.
                         *          Returns an Error object containing a
             *          descriptive message on failure.
             * 
             * @throws {TypeError}
             *            Thrown if the input parameters are invalid
             * @throws {AccessDeniedException}
                         *            Thrown if a blocking operation is already
                         *            in progress.
             * @throws {NotInitializedException}
             *            Thrown if a portlet ID is provided, but no
                         *            onStateChange listener has been
                         *            registered.
             * 
             * @memberOf PortletInit
             */
                        startPartialAction : function(actParams) {
               var  parms = null, paObj = {}, pi;
         
                           // check arguments. make sure there is a
                           // maximum of two
                           // args and determine the types. Check
                           // values as possible.
               if (arguments.length > 1) {
                              throw new TypeError(
                                    "Too many arguments. 1 arguments are allowed.");
               } else if (actParams !== undefined) {
                  if (typeof actParams === 'object') {
                                 validateParms(actParams); // throws
                                                      // if
                                                      // parms
                                                      // are
                                                      // invalid
                     parms = actParams;
                  } else {
                                 throw new TypeError(
                                       "Invalid argument type. Argument is of type "
                           + (typeof actParams));
                  }
               }
         
               // make sure operation is allowed
               if (busy === true) {
                  throwAccessDeniedException("Operation in progress");
                           } else if (!hasListener(portletId)) {
                  throwNotInitializedException("No onStateChange listener registered for portlet: "
                        + portletId);
               }
         
               busy = true;
         
                           // Create the PartialActionInit object
                           // fulfill promise by passing it.
               // let errors propagate to caller.
               
               pi = _registeredPortlets[portletId];
                           return pi.getUrl("PARTIAL_ACTION", parms).then(
                                       function(url) {
                  paObj.url = url;
                                    paObj.setPageState = function(ustr) {
                                       setPageState(portletId, ustr);
                                          };
                  return paObj;
               });
         
            },
         
            /**
                         * Tests whether a blocking operation is in progress.
             * <p>
                         * The portlet client can use this function to test
                         * whether a state change is in progress before
                         * initiating a blocking operation.
                         * <p>
                         * Note that if the portlet client uses this function to
                         * implement a waiting function, the render state may be
                         * changed during the time that the portlet client
                         * waits. Also note that the portal may choose to
                         * refresh the page as a response to a blocking
                         * operation, in which case the waiting function would
                         * not complete.
                         * <p>
                         * The portlet hub provides for orderly state
                         * transitions by allowing only a single blocking
                         * operation ({@link action}, {@link setRenderState},
                         * {@link startPartialAction}) to be active at any one
                         * time.
                         * <p>
                         * The state transition is considered to be active from
                         * the initial portlet client call to one of the
                         * blocking operations until the portlet hub has
                         * performed the requested state change and has informed
                         * all of the affected portlet clients by firing the
                         * corresponding onStateChange events.
             * <p>
             * See {@link portlet} for further information.
             *
                         * @returns {boolean} <code>true</code> if a blocking
                         *          operation is in progress
             *
             * @memberOf   PortletInit
             */
                        isInProgress : function() {
               return busy;
            },
         
            /**
             * Dispatches a client event.
             * <p>
                         * Client events of the specified type are queued for
                         * delivery to registered event listeners of that type.
                         * <p>
                         * The event type is matched against the type strings
                         * associated with registered event listeners. An event
                         * will be dispatched for each matching listener. The
                         * number of matching listeners will be returned.
                         * <p>
                         * The event payload is defined by the dispatcher of the
                         * event. It must be present, but may be of any type or
                         * value.
                         * <p>
                         * The portlet Client may not dispatch event types
                         * beginning with the reserved string "portlet.".
                         * <p>
                         * The client is responsible for preventing race
                         * conditions. For example, a race condition can occur
                         * if portlet A dispatches an event to portlet B,
                         * causing an event to portlet A, which dispatches again
                         * to portlet B, etc.
                         * <p>
                         * Event delivery cannot be guaranteed, and may vary
                         * according to the situation.
                         * <p>
                         * Take for example a scenario where a portlet issues an
                         * event to several other portlets, perhaps including
                         * itself. Due to the event, each portlet updates
                         * parameters through use of the {@link setRenderState}
                         * function.
                         * <p>
                         * The <code>setRenderState</code> function can cause
                         * a page refresh depending on the situation. If all
                         * portlets on the page participate in the JSR 362 Ajax
                         * support, the portlet hub might not cause a page
                         * refresh. However, if there are legacy portlets to be
                         * supported, the portal or portlet hub might choose to
                         * refresh the page.
                         * <p>
                         * In the latter case, this means that the first portlet
                         * receiving the event will be able to successfully
                         * update its parameters, but the remaining portlets
                         * will not. This can have unintentional consequences.
                         * 
                         * @param {string}
                         *            type The type of listener
                         * @param {any}
                         *           payload The payload to be delivered
             *
                         * @returns {number} The number of events queued for
                         *          delivery
             *
             * @memberOf   PortletInit
             */
                        dispatchClientEvent : function(type, payload) {
               var cnt = 0, li;
         
                           // check for 2 arguments, the first of which
                           // must be a string
                           checkArguments(arguments, 2, 2, [ 'string' ]);
         
                           // disallow use of reserved name for system
                           // event types
               if (type.match(portletRegex)) {
                              throw new TypeError("The event type is invalid: "
                                    + type);
               }
         
               for (li in pcListeners) {
                  if (pcListeners.hasOwnProperty(li)) {
         
                                 if (type.match(pcListeners[li].type) !== null) {
                                    dispatchCE(type, pcListeners[li].callback,
                                          payload);
                        cnt++;
                     }
                  }
               }
         
               return cnt;
            },
            
            /**
                         * Creates and returns a new PortletParameters object.
             * <p>
                         * If no argument is provided, an empty
                         * PortletParameters object will be returned. If an
                         * existing PortletParameters object is provided as
                         * argument, a clone of the input object will be
                         * returned.
                         * 
                         * @param {PortletParameters}
                         *           p An optional PortletParameters object to
                         *           be copied
             *
                         * @returns {PortletParameters} The new parameters
                         *          object
             *
             * @memberOf   PortletInit
             */
                        newParameters : function(p) {
                           var n, newparams = {};
                           if (p) {
                              for (n in p) {
                                 if (p.hasOwnProperty(n) && Array.isArray(p[n])) {
                                    newparams[n] = p[n].slice(0);
                                 }
                              }
                           }
                           return newparams;
            },
            
            /**
             * Creates and returns a new RenderState object.
             * <p>
                         * If no argument is provided, an empty RenderState
                         * object will be returned. If an existing RenderState
                         * object is provided as argument, a clone of the input
                         * object will be returned.
                         * 
                         * @param {RenderState}
                         *           s An optional RenderState object to be
                         *           copied
             *
                         * @returns {RenderState} The new RenderState object
             *
             * @memberOf   PortletInit
             */
                        newState : function(s) {
               return new State(s);
            },
            
            /**
                         * The {@link PortletConstants} object that provides
                         * useful field definitions for portlet mode, window
                         * state, and resource URL cacheability settings.
             *
             * @memberOf   PortletInit
             */
            constants : portletConstants
         
         };
      });
   };

}());
