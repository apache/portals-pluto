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
 * This describes a proposed extension for the JSR 362 Portlet Specification 3.0
 * public API to exploit CDI capabilities in portlets. 
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
 * It allows portlets to be written as CDI beans.
 * Such portlets can make use of standard CDI features such as interceptors, 
 * decorators, and dependency injection.
 * <p>
 * Bean portlet methods must carry with one of the following annotations:
 * {@link javax.portlet.annotations.ActionMethod}, 
 * {@link javax.portlet.annotations.EventMethod}, 
 * {@link javax.portlet.annotations.HeaderMethod}, 
 * {@link javax.portlet.annotations.RenderMethod}, 
 * {@link javax.portlet.annotations.ServeResourceMethod}, or 
 * {@link javax.portlet.annotations.PortletResources}.
 * <p>
 * Bean portlet methods can be contained in any valid bean class. 
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
 * {@link javax.portlet.annotations.PortletStateScoped} 
 * associates the bean lifecycle with the portlet state, which conceptually is stored 
 * on the URL.
 * If you use PortletStateScoped beans, your bean state will be automatically stored as
 * render parameters for the portlet setting the state.      
 * </li>
 * </ul>
 * </li>
 * <li>
 * It allows portlet artifacts such as portlet request filters, URL generation listeners,
 * and preference validators to be implemented as CDI beans.
 * <p>
 * Please see the following annotation descriptions:
 * {@link javax.portlet.annotations.PortletRequestFilter},
 * {@link javax.portlet.annotations.PortletListener}, and
 * {@link javax.portlet.annotations.PreferencesValidator}.
 * </ul>
 * <h4>Injectable Portlet Artifacts</h4>
 * <p>
 * In addition to the annotations, this package provides producer methods that allow
 * many portlet artifacts to be injected into your code as beans.
 * The following table describes the beans that are available for injection.
 * </p>
 * <p>
 * <span style="font-weight:bold; text-decoration:underline;">Note:</span> 
 * Most of these beans are dependent on the portlet request being executed, but could not themselves 
 * be declared as {@literal @}RequestScoped due to technical limitations. 
 * These beans should be used within enclosing beans that are either
 * {@literal @}PortletStateScoped or {@literal @}RequestScoped to allow the portlet container to properly manage 
 * the lifecycle of the injected object.
 * The required enclosing bean scope is noted in the table.
 * <table class='ovtable' width='100%'>
 * <thead>
 * <tr>
 * <th width="15%">Object</th>
 * <th width="40%">Description</th>
 * <th width="15%">Enclosing Bean Scope</th>
 * <th width="30%">Annotation Example</th>
 * </tr>
 * </thead>
 * <tbody>
 * <!-- ************* -->
 * <tr>
 * <td>PortletConfig</td>
 * <td>The PortletConfig object. Use qualifier {@literal @}BeanPortlet for disambiguation.</td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject {@literal @}BeanPortlet<br/>
 * private PortletConfig portletConfig;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>PortletRequest</td>
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
 * <td>PortletResponse</td>
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
 * <td>PortletPreferences</td>
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
 * <td>PortletSession</td>
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
 * <td>URLFactory</td>
 * <td>Provides methods for creating URLs.
 * See {@link javax.portlet.annotations.URLFactory URLFactory}.
 * </td>
 * <td>Any</td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private URLFactory urlFactory;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>PortletMode</td>
 * <td>The PortletMode object.
 * </td>
 * <td>
 * {@literal @}RequestScoped
 * or
 * {@literal @}PortletStateScoped
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
 * <td>WindowState</td>
 * <td>The WindowState object.
 * </td>
 * <td>
 * {@literal @}RequestScoped
 * or
 * {@literal @}PortletStateScoped
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
 * <td>Cookies[]</td>
 * <td>An array of Cookies set for the portlet.
 * See {@link javax.portlet.PortletRequest#getCookies() getCookies}.
 * </td>
 * <td>
 * {@literal @}RequestScoped
 * or
 * {@literal @}PortletStateScoped
 * </td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private Cookies[] cookies;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>Locale</td>
 * <td>The Locale object.
 * See {@link javax.portlet.PortletRequest#getLocale() getLocale}.
 * </td>
 * <td>
 * {@literal @}RequestScoped
 * or
 * {@literal @}PortletStateScoped
 * </td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private Locale locale;
 * </div>
 * </td>
 * </tr>
 * <!-- ************* -->
 * <tr>
 * <td>Locales[]</td>
 * <td>An array of supported Locales for the portlet.
 * See {@link javax.portlet.PortletRequest#getLocales() getLocales}.
 * </td>
 * <td>
 * {@literal @}RequestScoped
 * or
 * {@literal @}PortletStateScoped
 * </td>
 * <td>
 * <div class='codebox'>
 * {@literal @}Inject<br/>
 * private Locales[] locales;
 * </div>
 * </td>
 * </tr>
 * </tbody>
 * </table>
 * <h4>Using the {@literal @}PortletStateScoped Annotation</h4>
 * <p>
 * The {@literal @}PortletStateScoped Annotation allows portlet render parameters
 * to be treated as beans.
 * The bean state is stored as a portlet render parameter.
 * The annotation documentation for 
 * {@link  javax.portlet.annotations.PortletStateScoped PortletStateScoped}
 * describes the necessary prerequisites.
 * </p>
 * <p>
 * The <code>paramName</code> element in the annotation can be used to provide a 
 * parameter name for storing the bean.
 * This element can also be left empty, in which case the portlet container will 
 * generate a parameter name.
 * </p>
 * <p>
 * When resource URLs are generated, {@literal @}PortletStateScoped beans valid for the
 * current request are automatically stored on the URL as render parameters.
 * When creating render or action URLs, {@literal @}PortletStateScoped beans can be
 * automatically stored on the URL with the state valid for the current request by
 * using the appropriate option with the <code>URLFactory</code>
 * {@link  javax.portlet.annotations.URLFactory#createActionURL createActionURL} and
 * {@link  javax.portlet.annotations.URLFactory#createRenderURL createRenderURL}
 * methods.
 * </p>
 * <p>
 * However, you might want to set a modified {@literal @}PortletStateScoped bean value
 * on your URL.
 * You can do this using the <code>PortletURL</code> interface
 * {@link  javax.portlet.PortletURL#setBeanParameter setBeanParameter}
 * method.
 * You can create a new bean, set the fields as desired, and use the 
 * <code>setBeanParameter</code> method to set the new bean on the URL.
 * </p>
 * <p>
 * <span style="font-weight:bold; text-decoration:underline;">Tip:</span> 
 * It might be useful to provide your {@literal @}PortletStateScoped
 * bean with a copy constructor <b>in addition to</b> the required default constructor.
 * You could then create a new {@literal @}PortletStateScoped bean based on the 
 * current state of the injected bean and then update the fields on the new bean as required.
 * </p>
 */
package javax.portlet.annotations;