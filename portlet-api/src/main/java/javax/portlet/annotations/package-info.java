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
 * <span class="changed_added_3_0">
 * The javax.portlet.annotations package provides the annotations used 
 * for portlet configuration and portlet-specific dependency injection.
 * </span>
 * <h4>Overview</h4>
 * <p>
 * The annotation-oriented API provides new capabilities in several areas.
 * </p>
 * <ul class='nospace'>
 * <li>
 * It allows portlet configuration declarations to be performed through use of
 * annotations.
 * The goal is to reduce or remove the need to write a portlet deployment descriptor 
 * in most instances.
 * <p>
 * The developer can choose between providing configuration data through annotations or 
 * through the portlet deployment descriptor.
 * If the same type of information is provided through both annotations and the deployment
 * descriptor, the information from the deployment descriptor has precedence. 
 * </li>
 * <li>
 * It allows portlet lifecycle methods to be identified through use of annotations.
 * <p>
 * The possible portlet method annotations are:
 * {@link javax.portlet.annotations.InitMethod}, 
 * {@link javax.portlet.annotations.DestroyMethod}, 
 * {@link javax.portlet.annotations.ActionMethod}, 
 * {@link javax.portlet.annotations.EventMethod}, 
 * {@link javax.portlet.annotations.HeaderMethod}, 
 * {@link javax.portlet.annotations.RenderMethod}, or
 * {@link javax.portlet.annotations.ServeResourceMethod}. 
 * <p>
 * Annotated portlet lifecycle methods can be contained in any valid CDI bean class. 
 * The class needs not implement any portlet-specific interface or extend a portlet class. 
 * However, each bean portlet method has method signature requirements that 
 * must be fulfilled.
 * Please see the annotation descriptions.
 * </li>
 * <li>
 * It provides new custom scopes for portlet artifacts.
 * <ul class='nospace'>
 * <li>
 * Using the scope annotation
 * {@link javax.portlet.annotations.PortletSessionScoped} 
 * associates the bean lifecycle with the portlet session.
 * </li>
 * <li>
 * Using the scope annotation
 * {@link javax.portlet.annotations.PortletRequestScoped} 
 * associates the bean lifecycle with the portlet request.
 * </li>
 * <li>
 * Using the scope annotation
 * {@link javax.portlet.annotations.RenderStateScoped} 
 * associates the bean lifecycle with the render state, which conceptually is stored 
 * on the URL.
 * If you use RenderStateScoped beans, your bean state will be automatically stored as
 * render parameters for the portlet setting the state.      
 * </li>
 * </ul>
 * </li>
 * <li>
 * It allows portlet artifacts such as portlet request filters, URL generation listeners,
 * and preference validators to be identified through annotations.
 * <p>
 * Please see the following annotation descriptions:
 * {@link javax.portlet.annotations.PortletLifecycleFilter},
 * {@link javax.portlet.annotations.PortletListener}, and
 * {@link javax.portlet.annotations.PortletPreferencesValidator}.
 * </ul>
 * <h4>Injectable Portlet Artifacts</h4>
 * <p>
 * <span style="font-weight:bold; text-decoration:underline;">Note:</span> 
 * Most of these beans are dependent on the portlet request being executed, but 
 * some of them could not themselves 
 * be declared as {@literal @}PortletRequestScoped due to technical limitations. 
 * These beans should be used within enclosing beans that are either
 * {@literal @}RenderStateScoped or {@literal @}PortletRequestScoped to allow 
 * the portlet container to properly manage the lifecycle of the injected object.
 * The required enclosing bean scope is noted in the table.
 * <table class='ovtable' width='100%'>
 * <thead>
 * <tr>
 * <th width="15%">name</th>
 * <th width="40%">Description</th>
 * <th width="15%">Enclosing Bean Scope</th>
 * <th width="30%">Annotation Example</th>
 * </tr>
 * </thead>
 * <tbody>
 * <!-- ************* -->
 * <tr>
 * <td>portletConfig</td>
 * <td>
 * The PortletConfig object.
 * </td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private PortletConfig portletConfig;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>portletRequest</td>
 * <td>The PortletRequest object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private PortletRequest request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>portletResponse</td>
 * <td>The PortletResponse object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private PortletResponse request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>actionRequest</td>
 * <td>The ActionRequest object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private ActionRequest request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>actionResponse</td>
 * <td>The ActionResponse object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private ActionResponse request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>headerRequest</td>
 * <td>The HeaderRequest object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private HeaderRequest request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>headerResponse</td>
 * <td>The HeaderResponse object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private HeaderResponse request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>renderRequest</td>
 * <td>The RenderRequest object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private RenderRequest request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>renderResponse</td>
 * <td>The RenderResponse object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private RenderResponse request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>eventRequest</td>
 * <td>The EventRequest object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private EventRequest request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>eventResponse</td>
 * <td>The EventResponse object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private EventResponse request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>resourceRequest</td>
 * <td>The ResourceRequest object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private ResourceRequest request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>resourceResponse</td>
 * <td>The ResourceResponse object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private ResourceResponse request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>clientDataRequest</td>
 * <td>The ClientDataRequest object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private ClientDataRequest request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>mimeResponse</td>
 * <td>The MimeResponse object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private MimeResponse request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>stateAwareResponse</td>
 * <td>The StateAwareResponse object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private StateAwareResponse request;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>renderParams</td>
 * <td>The RenderParameters object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private RenderParameters renderParams;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>mutableRenderParams</td>
 * <td>The MutableRenderParameters object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private MutableRenderParameters mutableRenderParams;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>actionParams</td>
 * <td>The ActionParameters object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private ActionParameters actionParams;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>resourceParams</td>
 * <td>The ResourceParameters object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private ResourceParameters resourceParams;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>portletContext</td>
 * <td>The PortletContext object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private PortletContext portletContext;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>portletPreferences</td>
 * <td>The PortletPreferences object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private PortletPreferences preferences;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>portletSession</td>
 * <td>The PortletSession object.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private PortletSession session;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>portletMode</td>
 * <td>The PortletMode object.
 * </td>
 * <td>
 * Any
 * </td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private PortletMode mode;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>windowState</td>
 * <td>The WindowState object.
 * </td>
 * <td>
 * Any
 * </td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private WindowState windowState;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>cookies</td>
 * <td>An list of Cookie objects set for the portlet.
 * See {@link javax.portlet.PortletRequest#getCookies() getCookies}.
 * </td>
 * <td>
 * Any
 * </td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private List{@literal <}Cookie> cookies;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>locales</td>
 * <td>An list of supported Locales for the portlet.
 * See {@link javax.portlet.PortletRequest#getLocales() getLocales}.
 * </td>
 * <td>
 * Any
 * </td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private List{@literal <}Locale> locales;
 * </div>
 * </td>
 * </tr>
 * <!-- ********************** -->
 * <!-- ** Dependent scoped ** -->
 * <!-- ********************** -->
 * <tr>
 * <td>namespace</td>
 * <td>A <code>String</code> representing the unique name space for the
 * portlet window.
 * See {@link javax.portlet.PortletResponse#getNamespace() getNamespace}.
 * </td>
 * <td>
 * {@literal @}PortletRequestScoped
 * or
 * {@literal @}RenderStateScoped
 * </td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private String namespace;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>contextPath</td>
 * <td>A <code>String</code> representing the context path for the 
 * portlet application.
 * See {@link javax.portlet.PortletRequest#getContextPath() getContextPath}.
 * </td>
 * <td>
 * {@literal @}PortletRequestScoped
 * or
 * {@literal @}RenderStateScoped
 * </td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private String contextPath;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>windowId</td>
 * <td>A <code>String</code> representing the unique window ID for the
 * portlet window.
 * See {@link javax.portlet.PortletRequest#getWindowID() getWindowID}.
 * </td>
 * <td>
 * {@literal @}PortletRequestScoped
 * or
 * {@literal @}RenderStateScoped
 * </td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private String windowId;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>portletName</td>
 * <td>A <code>String</code> representing the portlet name.
 * See {@link javax.portlet.PortletConfig#getPortletName() getportletName}.
 * </td>
 * <td>
 * {@literal @}PortletRequestScoped
 * or
 * {@literal @}RenderStateScoped
 * </td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private String portletName;
 * </div>
 * </td>
 * </tr>
 * </tbody>
 * </table>
 * <h4>Using the {@literal @}RenderStateScoped Annotation</h4>
 * <p>
 * The {@literal @}RenderStateScoped Annotation allows portlet render parameters
 * to be treated as beans.
 * The bean state is stored as a portlet render parameter.
 * The annotation documentation for 
 * {@link  javax.portlet.annotations.RenderStateScoped RenderStateScoped}
 * describes the necessary prerequisites.
 * </p>
 * <p>
 * The <code>paramName</code> element in the annotation can be used to provide a 
 * parameter name for storing the bean.
 * This element can also be left empty, in which case the portlet container will 
 * generate a parameter name.
 * </p>
 * <p>
 * When resource URLs are generated, {@literal @}RenderStateScoped beans valid for the
 * current request are automatically stored on the URL as render parameters.
 * When creating render or action URLs, {@literal @}RenderStateScoped beans can be
 * automatically stored on the URL with the state valid for the current request by
 * using the appropriate option with the <code>MimeResponse</code>
 * {@link  javax.portlet.MimeResponse#createActionURL createActionURL} and
 * {@link  javax.portlet.MimeResponse#createRenderURL createRenderURL}
 * methods.
 * </p>
 * <p>
 * However, you might want to set a modified {@literal @}RenderStateScoped bean value
 * on your URL.
 * You can do this using the <code>PortletURL</code> interface
 * {@link  javax.portlet.PortletURL#setBeanParameter setBeanParameter}
 * method.
 * You can create a new bean, set the fields as desired, and use the 
 * {@link  javax.portlet.PortletURL#setBeanParameter setBeanParameter}
 * method to set the new bean on the URL.
 * </p>
 * <p>
 * <span style="font-weight:bold; text-decoration:underline;">Tip:</span> 
 * It might be useful to provide your {@literal @}RenderStateScoped
 * bean with a copy constructor <b>in addition to</b> the required default constructor.
 * You could then create a new {@literal @}RenderStateScoped bean based on the 
 * current state of the injected bean and then update the fields on the new bean as required.
 * </p>
 * 
 * @since 3.0
 */
package javax.portlet.annotations;