<%--
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed  under the  License is distributed on an "AS IS" BASIS,
WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
implied.

See the License for the specific language governing permissions and
limitations under the License.
--%>
<%@ page session="false" %>
<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class='orangebox'>


<h3>Demo Outline:</h3>
<ol>
<li> Begin with empty class; add hello world render method
 <ul>
   <li>Simple portlet configuration</li>
   <li>Using the @RenderMethod annotation implicitly defines a portlet</li>
   <li>The portletNames attribute defines the portlet name, but can also define a list of names</li>
   <li>The portlet shown does not implement any portlet API specific interface</li>
   <li>Shows use of simplified method signature - returns a string</li>
 </ul>
<li>Add the NameBean.java class</li>
 <ul>
   <li>An @RenderStateScoped bean</li>
   <li>When the bean is passivated, the bean state is stored as a portlet render parameter</li>
   <li>The parameter name can optionally be specified as annotation attribute</li>
   <li>The bean must implement the @PortletSerializable interface</li>
   <ul>
      <li>To store the bean state as render parameter values String array</li>
      <li>Allows the bean state to be a public render parameter when param name specified</li>
      <li>Allows the bean state to be accessed on client when param name specified</li>
   </ul>
   <li>Shows injection of portlet String namespace. Same value returned by PortletResponse#getNamespace()</li>
   <ul>
      <li>Uses @Namespace qualifier annotation</li>
   </ul>
   <li>Shows injection of portlet MimeResponse object</li>
   <li>Adds a second @RenderMethod with ordinal number = 200</li>
   <ul>
      <li>When a portlet has multiple render methods for a given portlet mode, they are rendered in ascending order</li>
      <li>Supports a portlet component model</li>
      <li>Shows that portlet lifecycle methods do not need to be located in the same class</li>
      <li>Shows use of V3 ActionURL interface</li>
      <li>ActionURL is created using the injected MimeResponse object</li>
      <li>Use of Copy.ALL to caop all current render parameters to new URL</li>
   </ul>
   <li>Injects a portlet ActionParameters object</li>
   <ul>
      <li>Can only be accessed from within an action method</li>
   </ul>
   <li>The @ActionMethod defines an action method with actionName attribute 'setName'</li>
   <ul>
      <li>Method name can be freely selected</li>
      <li>Relaxed method signature requirements - don't need to declare throws clause if not needed</li>
      <li>Action method is executed when a form targeting the portlet is submitted</li>
    </ul>
 </ul>
<li>Add the HelloWorldImage.java class</li>
 <ul>
   <li>Uses injection to access a number of portlet artifacts</li>
   <li>Defines an @HeaderMethod with portletNames="*"</li>
   <ul>
      <li>Applies this header method to all portlets in the portlet application</li>
      <li>Defines a page resource dependency for the portlet hub</li>
      <ul>
         <li>Using the HeaderResponse#addDependency() method</li>
      </ul>
      <li>The portlet container will place the portlet hub JavaScript API on the page</li>
      <li>Dependency specification is a page resource ID</li>
      <ul>
         <li>consisting of resouce name, resource scope, and version</li>
      </ul>
   </ul>
   <li>Defines an @RenderMethod using the incude attribute</li>
   <ul>
      <li>Ordinal 100, so rendered after the name but before the entry field</li>
      <li>Causes the specified JSP to be included</li>
      <li>The JSP contains JavaScript code that is used to load the image</li>
   </ul>
   <li>Defines a @ServeResourceMethod with resourceId attribute set to "getImage"</li>
   <ul>
      <li>The JavaScript portlet client addresses this resource method with an Ajax call </li>
   </ul>
 </ul>
<li>Look at the helloWorldImage.jsp</li>
 <ul>
   <li>Defines a div element to contain the image</li>
   <ul>
      <li>The id attribute is based on the portlet namespace to make it unique on the page</li>
   </ul>
   <li>Defines JavaScript code known as the portlet client</li>
   <li>Defines update function as handler for the onStateChange event</li>
   <ul>
      <li>Called with 2 arguments: event type and new portlet state</li>
      <li>Portlet state consists of render parameters, portlet mode, and window state</li>
   </ul>
   <li>If the name parameter has changed, the update function uses createResourceUrl method</li>
   <ul>
      <li>Takes 3 arguments: resource parameters, cacheability option, and resource ID</li>
      <li>Here, resource ID is set to 'getImage'; matches resource ID on serve resource method</li>
      <li>Returns Promise object, which the portlet hub fulfils with the URL</li>
      <li>The URL can be used like any other URL, for example, in an Ajax request</li>
   </ul>
   <li>The portlet client registers with the portlet hub using the portlet.register() method</li>
   <ul>
      <li>Takes the portlet namespace as argument, uniquely identifying the portlet</li>
      <li>Returns a Promise object, which the portlet hub fulfills when it is ready</li>
      <li>When it fulfills the promise, the portlet hub passes a PortletInit object</li>
      <ul>
         <li>Contains functions and constants for portlet use</li>
         <li>PortletInit object is specific to portlet at hand</li>
      </ul>
   </ul>
   <li>The portlet hub registers an onStateChange listener with the portlet hub</li>
   <ul>
      <li>Using the portlet hub addEventListener function</li>
      <li>Takes 2 arguments: The event type, and the callback function, in this case, 'update'</li>
   </ul>
 </ul>
<li>Add CSSIncludingHeaderMethod.java </li>
 <ul>
   <li>Defines a single header method; applies to all portlets in the portlet application</li>
   <li>Uses HeaderResponse#addDependency method to add a dependency</li>
   <ul>
      <li>But this time, also provides source markup for that dependency</li>
   </ul>
   <li>The portlet container will assure that the resource is only placed on the page once</li>
   <li>The portlet container will select version if two resources differ only by version</li>
 </ul>
<li>Look at ChatHistory.java</li>
 <ul>
   <li>@ApplicationScoped bean</li>
   <li>Simply a container for message strings</li>
   <li>Can add a message, clear messages, get markup for messages, get number of messages</li>
   <ul>
      <li>Latter function is used to poll for new messages</li>
   </ul>
   <li>Injects the NameBean to access the current name</li>
 </ul>
 <li>Look at ChatRoomListener.java</li>
 <ul>
   <li>Implements an injectable PortletAsyncListener to check for timeout</li>
   <li>If timeout occurs, a flag is set and the request is completed</li>
 </ul>
<li>Look at ChatRoomRunner.java</li>
 <ul>
   <li>An @PortletRequestScoped bean containing the 'run' method for async thread</li>
   <li>Injects the ChatHistory object</li>
   <li>Injects the async listener object</li>
   <li>Thread is initialized and started during resource request processing</li>
   <li>Initialized with the PortletAsyncContext object - needed for async processing</li>
   <li>Initialized with 'refresh' flag - just an application-specific flag</li>
   <li>The run() method polls the chat history until a change in # messages occurs</li>
   <ul>
      <li>When change occurs, returns the markup through the ResourceRequest object</li>
      <li>If the async listener shows that a timeout occurred, the run() method exits </li>
      <li>Completes asynchronous processing using the PortletAsyncContext#complete() method</li>
    </ul>
 </ul>
</ul>
<li>Look at ChatRoom.java</li>
<ul>
   <li>Class that contains portlet lifecycle methods for the chat room</li>
   <li>Defines @RenderMethod to render the chatroom</li>
   <ul>
      <li>Serves a JSP containing the portetl client for Ajax updates</li>
   </ul>
   <li>Defines @ServeResourceMethod that starts asynchronous processing to serve updates</li>
   <ul>
      <li>Activates asynchronous processing using the annotation asyncSupported attribute</li>
      <li>Shows how to obtain a resource parameter in the V3 manner</li>
      <li>Starts async processing by calling the ResourceResponse#startPortletAsync() method</li>
      <li>startPortletAsync returns a portletAsyncContext object</li>
      <li>Sets the request timeout through the PortletAsyncContext#setTimeout() method</li>
      <li>Adds an async listener to check for a timeout</li>
      <li>Initializes the injected ChatRoomRunner object with the PortletAsyncContext object</li>
      <li>Starts the async thread through the PortletAsyncContext#start() method</li>
   </ul>
   <li>Defines 2 action methods to handle user input</li>
   <ul>
      <li>actionName="addMessage" - used when message entered</li>
      <li>actionName="clearHistory" - used when 'clear' button clicked</li>
   </ul>
</ul>
<li>Look at chatroom.jsp</li>
<ul>
   <li>Renders box containing the chat history</li>
   <li>Renders form for user input</li>
   <li>Provides portlet client JavaScript code</li>
   <ul>
      <li>Defines getChat function, which constantly loops to get new chat history</li>
      <ul>
         <li>The resource URL is created with resource ID 'getChatHistory' to address appropriate resource method</li>
         <li>The resource URL is created with resource parameters; set for 1st execution, thereafter null</li>
      </ul>
      <li>Defines update function called when state changes</li>
      <li>Attaches onsubmit handler to form </li>
      <ul>
         <li>The form is submitted through the portlet hub action method</li>
      </ul>
      <li>Attaches onclick handler to the clear button</li>
      <ul>
         <li>Instead of submitting the form, specific action parameters are submitted</li>
         <li>The action parameter 'javax.portlet.action' specifies the action name</li>
         <li>In this case, the action name 'clearHistory' causes the server-side clearHistory action method to be called</li>
      </ul>
   </ul>
</ul>
<li>Look at Help.java</li>
<ul>
   <li>Includes a @PortletConfiguration annotation that defines support for the 'help' portlet mode</li>
   <li>Includes a render method that includes the help JSP</li>
   <li>The portletMode="help" attribute specifies that this method is to be executed to display help</li>
</ul>
</li>
</ol>
</div>


