/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package javax.portlet.tck.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.TestButton;
import javax.xml.namespace.QName;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES6;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETNAMES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETNAMES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETMAP1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETMAP2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_RESET1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_RESET2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_RESET3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE6;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * EnvironmentTests_PortletPreferences_ApiEvent_event
 *
 * @author ahmed
 */
public class EnvironmentTests_PortletPreferences_ApiEvent implements Portlet {
  
  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    QName eventQName = new QName(TCKNAMESPACE, "EnvironmentTests_PortletPreferences_ApiEvent");
    portletResp.setEvent(eventQName, "Hi!");
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_isReadOnly1 */
    /* Details: "Method isReadOnly(String): Returns true if the */
    /* preference specified by the key is defined to be read-only in the */
    /* deployment descriptor" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY1, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_isReadOnly2 */
    /* Details: "Method isReadOnly(String): Returns false if the */
    /* preference specified by the key is not defined to be read-only in */
    /* the deployment descriptor" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_isReadOnly3 */
    /* Details: "Method isReadOnly(String): Returns false if the */
    /* preference specified by the key is undefined" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY3, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_isReadOnly4 */
    /* Details: "Method isReadOnly(String): Throws */
    /* IllegalArgumentException if the key is null" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_ISREADONLY4, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_getValue1 */
    /* Details: "Method getValue(String, String): Returns the first */
    /* String value for the specified key" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE1, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_getValue2 */
    /* Details: "Method getValue(String, String): Returns the specified */
    /* default value if there is no value for the specified key " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_getValue3 */
    /* Details: "Method getValue(String, String): Returns the specified */
    /* default value if the existing value for the specified key is null */
    /* " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE3, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_getValue4 */
    /* Details: "Method getValue(String, String): Throws */
    /* IllegalArgumentException if the key is null" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUE4, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_getValues1 */
    /* Details: "Method getValues(String, String[]): Returns the values */
    /* String[] for the specified key" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES1, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_getValues2 */
    /* Details: "Method getValues(String, String[]): Returns the */
    /* specified default String[] if there is no Values for the specified */
    /* key " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_getValues3 */
    /* Details: "Method getValues(String, String[]): Returns the */
    /* specified default String[] if the existing String[] for the */
    /* specified key is null " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES3, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_getValues4 */
    /* Details: "Method getValues(String, String[]): Throws */
    /* IllegalArgumentException if the key is null" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETVALUES4, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_setValue1 */
    /* Details: "Method setValue(String, String): Sets the specified */
    /* value for the specified key" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE1, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_setValue2 */
    /* Details: "Method setValue(String, String): Any existing String or */
    /* String[] value for the specified key is replaced" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_setValue3 */
    /* Details: "Method setValue(String, String): The value may be set to */
    /* null" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE3, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_setValue4 */
    /* Details: "Method setValue(String, String): Throws */
    /* ReadOnlyException if the preference cannot be modified for this */
    /* request" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE4, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_setValue5 */
    /* Details: "Method setValue(String, String): Throws */
    /* IllegalArgumentException if the key is null" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUE5, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_setValues1 */
    /* Details: "Method setValues(String, String[]): Sets the specified */
    /* value array for the specified key" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES1, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_setValues2 */
    /* Details: "Method setValues(String, String[]): Any existing String */
    /* or String[] Values for the specified key is replaced" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_setValues3 */
    /* Details: "Method setValues(String, String[]): The value array may */
    /* be set to null" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES3, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_setValues4 */
    /* Details: "Method setValues(String, String[]): The value array may */
    /* contain null members" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES4, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_setValues5 */
    /* Details: "Method setValues(String, String[]): Throws */
    /* ReadOnlyException if the preference cannot be modified for this */
    /* request" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES5, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_setValues6 */
    /* Details: "Method setValues(String, String[]): Throws */
    /* IllegalArgumentException if the key is null" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_SETVALUES6, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_getNames1 */
    /* Details: "Method getNames(): Returns an */
    /* java.util.Enumeration&lt;java.lang.String&gt; containing the */
    /* available preference keys" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETNAMES1, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_getNames2 */
    /* Details: "Method getNames(): Returns an empty Enumeration if no */
    /* preference keys are available" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETNAMES2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_getMap1 */
    /* Details: "Method getMap(): Returns an */
    /* java.util.Map&lt;java.lang.String&gt; containing the available */
    /* preferences" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETMAP1, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_getMap2 */
    /* Details: "Method getMap(): Returns an empty Map if no preferences */
    /* are available" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_GETMAP2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_reset1 */
    /* Details: "Method reset(String): Removes the value associated with */
    /* the specified key" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_RESET1, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_reset2 */
    /* Details: "Method reset(String): Throws ReadOnlyException if the */
    /* preference cannot be modified for this request" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_RESET2, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_reset3 */
    /* Details: "Method reset(String): Throws IllegalArgumentException if */
    /* the key is null" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_RESET3, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_store3 */
    /* Details: "Method store(): If a validator is defined, it is called */
    /* before the actual store is performed" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE3, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_store4 */
    /* Details: "Method store(): If validation fails, the store is not */
    /* performed" */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE4, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2EnvironmentTests_PortletPreferences_ApiEvent_store6 */
    /* Details: "Method store(): Throws ValidatorException if the */
    /* validation performed by the associated validator fails " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIEVENT_STORE6, aurl);
      tb.writeTo(writer);
    }

  }

}
