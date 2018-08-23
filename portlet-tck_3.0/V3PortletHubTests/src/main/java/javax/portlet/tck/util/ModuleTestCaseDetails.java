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

package javax.portlet.tck.util;

import java.util.HashMap;
import java.util.Map;
import javax.portlet.tck.beans.TestCaseDetails;

/**
 * Defines constants for the test case names and test case details 
 * for the JSR 362 TCK.
 * 
 * Note that the backing map is static and not threadsafe. Operations
 * that change the map such as put, remove, etc., should not be used
 * in portlets.
 * 
 * @author nick
 */
public class ModuleTestCaseDetails extends TestCaseDetails {

   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER1 = "V3PortletHubTests_SPEC_23_JS_register1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER2 = "V3PortletHubTests_SPEC_23_JS_register2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER3 = "V3PortletHubTests_SPEC_23_JS_register3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER4 = "V3PortletHubTests_SPEC_23_JS_register4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER5 = "V3PortletHubTests_SPEC_23_JS_register5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER6 = "V3PortletHubTests_SPEC_23_JS_register6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER7 = "V3PortletHubTests_SPEC_23_JS_register7";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER8 = "V3PortletHubTests_SPEC_23_JS_register8";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER9 = "V3PortletHubTests_SPEC_23_JS_register9";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT1 = "V3PortletHubTests_SPEC_23_JS_PortletInit1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT2 = "V3PortletHubTests_SPEC_23_JS_PortletInit2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT3 = "V3PortletHubTests_SPEC_23_JS_PortletInit3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT4 = "V3PortletHubTests_SPEC_23_JS_PortletInit4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT5 = "V3PortletHubTests_SPEC_23_JS_PortletInit5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT6 = "V3PortletHubTests_SPEC_23_JS_PortletInit6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT7 = "V3PortletHubTests_SPEC_23_JS_PortletInit7";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT8 = "V3PortletHubTests_SPEC_23_JS_PortletInit8";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT9 = "V3PortletHubTests_SPEC_23_JS_PortletInit9";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITA = "V3PortletHubTests_SPEC_23_JS_PortletInitA";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITB = "V3PortletHubTests_SPEC_23_JS_PortletInitB";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITC = "V3PortletHubTests_SPEC_23_JS_PortletInitC";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITD = "V3PortletHubTests_SPEC_23_JS_PortletInitD";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS1 = "V3PortletHubTests_SPEC_23_JS_Constants1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS2 = "V3PortletHubTests_SPEC_23_JS_Constants2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS3 = "V3PortletHubTests_SPEC_23_JS_Constants3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS4 = "V3PortletHubTests_SPEC_23_JS_Constants4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS5 = "V3PortletHubTests_SPEC_23_JS_Constants5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS6 = "V3PortletHubTests_SPEC_23_JS_Constants6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS7 = "V3PortletHubTests_SPEC_23_JS_Constants7";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS8 = "V3PortletHubTests_SPEC_23_JS_Constants8";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS9 = "V3PortletHubTests_SPEC_23_JS_Constants9";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS1 = "V3PortletHubTests_SPEC_23_JSState_Parameters1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS2 = "V3PortletHubTests_SPEC_23_JSState_Parameters2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS3 = "V3PortletHubTests_SPEC_23_JSState_Parameters3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_STATE1 = "V3PortletHubTests_SPEC_23_JSState_State1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_STATE2 = "V3PortletHubTests_SPEC_23_JSState_State2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_STATE3 = "V3PortletHubTests_SPEC_23_JSState_State3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE = "V3PortletHubTests_SPEC_23_JSState_clone";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETPORTLETMODE = "V3PortletHubTests_SPEC_23_JSState_setPortletMode";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETPORTLETMODE = "V3PortletHubTests_SPEC_23_JSState_getPortletMode";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETWINDOWSTATE = "V3PortletHubTests_SPEC_23_JSState_setWindowState";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETWINDOWSTATE = "V3PortletHubTests_SPEC_23_JSState_getWindowState";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE = "V3PortletHubTests_SPEC_23_JSState_setValue";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE = "V3PortletHubTests_SPEC_23_JSState_getValue";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES = "V3PortletHubTests_SPEC_23_JSState_getValues";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_REMOVE = "V3PortletHubTests_SPEC_23_JSState_remove";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS = "V3PortletHubTests_SPEC_23_JSState_parameters";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PORTLETMODE = "V3PortletHubTests_SPEC_23_JSState_portletMode";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_WINDOWSTATE = "V3PortletHubTests_SPEC_23_JSState_windowState";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE1 = "V3PortletHubTests_SPEC_23_JSState_clone1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE2 = "V3PortletHubTests_SPEC_23_JSState_clone2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE3 = "V3PortletHubTests_SPEC_23_JSState_clone3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE4 = "V3PortletHubTests_SPEC_23_JSState_clone4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE5 = "V3PortletHubTests_SPEC_23_JSState_clone5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE6 = "V3PortletHubTests_SPEC_23_JSState_clone6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE7 = "V3PortletHubTests_SPEC_23_JSState_clone7";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETPORTLETMODE1 = "V3PortletHubTests_SPEC_23_JSState_setPortletMode1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETPORTLETMODE2 = "V3PortletHubTests_SPEC_23_JSState_setPortletMode2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETPORTLETMODE1 = "V3PortletHubTests_SPEC_23_JSState_getPortletMode1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETWINDOWSTATE1 = "V3PortletHubTests_SPEC_23_JSState_setWindowState1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETWINDOWSTATE2 = "V3PortletHubTests_SPEC_23_JSState_setWindowState2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETWINDOWSTATE1 = "V3PortletHubTests_SPEC_23_JSState_getWindowState1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE1 = "V3PortletHubTests_SPEC_23_JSState_setValue1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE2 = "V3PortletHubTests_SPEC_23_JSState_setValue2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE3 = "V3PortletHubTests_SPEC_23_JSState_setValue3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE4 = "V3PortletHubTests_SPEC_23_JSState_setValue4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE5 = "V3PortletHubTests_SPEC_23_JSState_setValue5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE1 = "V3PortletHubTests_SPEC_23_JSState_getValue1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE2 = "V3PortletHubTests_SPEC_23_JSState_getValue2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE3 = "V3PortletHubTests_SPEC_23_JSState_getValue3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE4 = "V3PortletHubTests_SPEC_23_JSState_getValue4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE5 = "V3PortletHubTests_SPEC_23_JSState_getValue5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE6 = "V3PortletHubTests_SPEC_23_JSState_getValue6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES1 = "V3PortletHubTests_SPEC_23_JSState_getValues1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES2 = "V3PortletHubTests_SPEC_23_JSState_getValues2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES3 = "V3PortletHubTests_SPEC_23_JSState_getValues3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES4 = "V3PortletHubTests_SPEC_23_JSState_getValues4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_REMOVE1 = "V3PortletHubTests_SPEC_23_JSState_remove1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSSTATE_REMOVE2 = "V3PortletHubTests_SPEC_23_JSState_remove2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER1 = "V3PortletHubTests_SPEC_23_JSExc_addEventListener1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER2 = "V3PortletHubTests_SPEC_23_JSExc_addEventListener2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER3 = "V3PortletHubTests_SPEC_23_JSExc_addEventListener3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER4 = "V3PortletHubTests_SPEC_23_JSExc_addEventListener4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER5 = "V3PortletHubTests_SPEC_23_JSExc_addEventListener5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER6 = "V3PortletHubTests_SPEC_23_JSExc_addEventListener6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER7 = "V3PortletHubTests_SPEC_23_JSExc_addEventListener7";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER8 = "V3PortletHubTests_SPEC_23_JSExc_addEventListener8";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER1 = "V3PortletHubTests_SPEC_23_JSExc_removeEventListener1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER2 = "V3PortletHubTests_SPEC_23_JSExc_removeEventListener2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER3 = "V3PortletHubTests_SPEC_23_JSExc_removeEventListener3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER4 = "V3PortletHubTests_SPEC_23_JSExc_removeEventListener4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER5 = "V3PortletHubTests_SPEC_23_JSExc_removeEventListener5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_CREATERESOURCEURL1 = "V3PortletHubTests_SPEC_23_JSExc_createResourceUrl1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_CREATERESOURCEURL2 = "V3PortletHubTests_SPEC_23_JSExc_createResourceUrl2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_CREATERESOURCEURL3 = "V3PortletHubTests_SPEC_23_JSExc_createResourceUrl3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE1 = "V3PortletHubTests_SPEC_23_JSExc_setRenderState1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE2 = "V3PortletHubTests_SPEC_23_JSExc_setRenderState2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE3 = "V3PortletHubTests_SPEC_23_JSExc_setRenderState3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE4 = "V3PortletHubTests_SPEC_23_JSExc_setRenderState4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE5 = "V3PortletHubTests_SPEC_23_JSExc_setRenderState5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE6 = "V3PortletHubTests_SPEC_23_JSExc_setRenderState6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE7 = "V3PortletHubTests_SPEC_23_JSExc_setRenderState7";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE9 = "V3PortletHubTests_SPEC_23_JSExc_setRenderState9";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATEA = "V3PortletHubTests_SPEC_23_JSExc_setRenderStateA";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATEB = "V3PortletHubTests_SPEC_23_JSExc_setRenderStateB";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION1 = "V3PortletHubTests_SPEC_23_JSExc_action1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION2 = "V3PortletHubTests_SPEC_23_JSExc_action2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION3 = "V3PortletHubTests_SPEC_23_JSExc_action3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION4 = "V3PortletHubTests_SPEC_23_JSExc_action4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION5 = "V3PortletHubTests_SPEC_23_JSExc_action5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION6 = "V3PortletHubTests_SPEC_23_JSExc_action6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION7 = "V3PortletHubTests_SPEC_23_JSExc_action7";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION8 = "V3PortletHubTests_SPEC_23_JSExc_action8";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTIONA = "V3PortletHubTests_SPEC_23_JSExc_actionA";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_STARTPARTIALACTION1 = "V3PortletHubTests_SPEC_23_JSExc_startPartialAction1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_STARTPARTIALACTION2 = "V3PortletHubTests_SPEC_23_JSExc_startPartialAction2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_STARTPARTIALACTION3 = "V3PortletHubTests_SPEC_23_JSExc_startPartialAction3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSEXC_STARTPARTIALACTION4 = "V3PortletHubTests_SPEC_23_JSExc_startPartialAction4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE1 = "V3PortletHubTests_SPEC_23_JSListener_onStateChange1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE2 = "V3PortletHubTests_SPEC_23_JSListener_onStateChange2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE3 = "V3PortletHubTests_SPEC_23_JSListener_onStateChange3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE4 = "V3PortletHubTests_SPEC_23_JSListener_onStateChange4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE5 = "V3PortletHubTests_SPEC_23_JSListener_onStateChange5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR1 = "V3PortletHubTests_SPEC_23_JSListener_onError1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR2 = "V3PortletHubTests_SPEC_23_JSListener_onError2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR3 = "V3PortletHubTests_SPEC_23_JSListener_onError3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL1 = "V3PortletHubTests_SPEC_23_JSURL_createResourceUrl1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL2 = "V3PortletHubTests_SPEC_23_JSURL_createResourceUrl2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL3 = "V3PortletHubTests_SPEC_23_JSURL_createResourceUrl3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL4 = "V3PortletHubTests_SPEC_23_JSURL_createResourceUrl4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL5 = "V3PortletHubTests_SPEC_23_JSURL_createResourceUrl5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL6 = "V3PortletHubTests_SPEC_23_JSURL_createResourceUrl6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL7 = "V3PortletHubTests_SPEC_23_JSURL_createResourceUrl7";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL8 = "V3PortletHubTests_SPEC_23_JSURL_createResourceUrl8";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL9 = "V3PortletHubTests_SPEC_23_JSURL_createResourceUrl9";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL0 = "V3PortletHubTests_SPEC_23_JSURL_createResourceUrl0";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLA = "V3PortletHubTests_SPEC_23_JSURL_createResourceUrlA";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLB = "V3PortletHubTests_SPEC_23_JSURL_createResourceUrlB";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLC = "V3PortletHubTests_SPEC_23_JSURL_createResourceUrlC";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLD = "V3PortletHubTests_SPEC_23_JSURL_createResourceUrlD";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE1 = "V3PortletHubTests_SPEC_23_JSRS_setRenderState1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE2 = "V3PortletHubTests_SPEC_23_JSRS_setRenderState2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE3 = "V3PortletHubTests_SPEC_23_JSRS_setRenderState3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE4 = "V3PortletHubTests_SPEC_23_JSRS_setRenderState4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE5 = "V3PortletHubTests_SPEC_23_JSRS_setRenderState5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE6 = "V3PortletHubTests_SPEC_23_JSRS_setRenderState6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE7 = "V3PortletHubTests_SPEC_23_JSRS_setRenderState7";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE8 = "V3PortletHubTests_SPEC_23_JSRS_setRenderState8";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE9 = "V3PortletHubTests_SPEC_23_JSRS_setRenderState9";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE0 = "V3PortletHubTests_SPEC_23_JSRS_setRenderState0";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATEA = "V3PortletHubTests_SPEC_23_JSRS_setRenderStateA";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION1 = "V3PortletHubTests_SPEC_23_JSAction_Action1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION2 = "V3PortletHubTests_SPEC_23_JSAction_Action2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION3 = "V3PortletHubTests_SPEC_23_JSAction_Action3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION4 = "V3PortletHubTests_SPEC_23_JSAction_Action4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION5 = "V3PortletHubTests_SPEC_23_JSAction_Action5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION6 = "V3PortletHubTests_SPEC_23_JSAction_Action6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION7 = "V3PortletHubTests_SPEC_23_JSAction_Action7";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE1 = "V3PortletHubTests_SPEC_23_JSPRP_setRenderState1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE2 = "V3PortletHubTests_SPEC_23_JSPRP_setRenderState2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE3 = "V3PortletHubTests_SPEC_23_JSPRP_setRenderState3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE4 = "V3PortletHubTests_SPEC_23_JSPRP_setRenderState4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSPRP_ACTION1 = "V3PortletHubTests_SPEC_23_JSPRP_Action1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSPRP_ACTION2 = "V3PortletHubTests_SPEC_23_JSPRP_Action2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION1 = "V3PortletHubTests_SPEC_23_JSPA_startPartialAction1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION2 = "V3PortletHubTests_SPEC_23_JSPA_startPartialAction2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION3 = "V3PortletHubTests_SPEC_23_JSPA_startPartialAction3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION4 = "V3PortletHubTests_SPEC_23_JSPA_startPartialAction4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION5 = "V3PortletHubTests_SPEC_23_JSPA_startPartialAction5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION6 = "V3PortletHubTests_SPEC_23_JSPA_startPartialAction6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION7 = "V3PortletHubTests_SPEC_23_JSPA_startPartialAction7";

   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {

      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER1, "The portlet hub provides a global namespace var portlet of type object");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER2, "The global portlet object register property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER3, "The portlet hub register function throws a TypeError if no portlet ID argument is provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER4, "The portlet hub register function throws a TypeError if too many (&gt;1) arguments are provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER5, "The portlet hub register function throws a TypeError if the portlet ID is not a string");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER6, "The portlet hub register function throws a TypeError if the portlet ID is undefined");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER7, "The portlet hub register function throws a TypeError if the portlet ID is null");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER8, "The portlet hub register function The promise fails if the portlet ID is not defined for the portlet hub");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER9, "The portlet hub register function returns a PortletInit object when provided with a valid portlet ID");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT1, "The PortletInit object portletModes property is an array");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT2, "The PortletInit object windowStates property is an array");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT3, "The PortletInit object action property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT4, "The PortletInit object addEventListener property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT5, "The PortletInit object createResourceUrl property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT6, "The PortletInit object dispatchClientEvent property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT7, "The PortletInit object isInProgress property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT8, "The PortletInit object newParameters property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT9, "The PortletInit object newState property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITA, "The PortletInit object removeEventListener property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITB, "The PortletInit object setRenderState property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITC, "The PortletInit object startPartialAction property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITD, "The PortletInit object constants property is type object");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS1, "The Constants object VIEW property is type string and equal to 'view'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS2, "The Constants object EDIT property is type string and equal to 'edit'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS3, "The Constants object HELP property is type string and equal to 'help'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS4, "The Constants object NORMAL property is type string and equal to 'normal'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS5, "The Constants object MINIMIZED property is type string and equal to 'minimized'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS6, "The Constants object MAXIMIZED property is type string and equal to 'maximized'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS7, "The Constants object FULL property is type string and equal to 'cacheLevelFull'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS8, "The Constants object PORTLET property is type string and equal to 'cacheLevelPortlet'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS9, "The Constants object PAGE property is type string and equal to 'cacheLevelPage'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS1, "The PortletInit object newParameters function returns a Parameters object");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS2, "The PortletInit object newParameters function returns a Parameters object containing no parameters");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS3, "The PortletInit object newParameters function returns a Parameters object containing cloned values if passed a parameters object");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_STATE1, "The PortletInit object newState function returns a State object");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_STATE2, "The PortletInit object newState function returns a State object containing no parameters if not passed a State object");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_STATE3, "The PortletInit object newState function returns a State object containing cloned values if passed a State object");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE, "The RenderState object clone property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETPORTLETMODE, "The RenderState object setPortletMode property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETPORTLETMODE, "The RenderState object getPortletMode property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETWINDOWSTATE, "The RenderState object setWindowState property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETWINDOWSTATE, "The RenderState object getWindowState property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE, "The RenderState object setValue property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE, "The RenderState object getValue property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES, "The RenderState object getValues property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_REMOVE, "The RenderState object remove property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PARAMETERS, "The RenderState object parameters property is type object");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_PORTLETMODE, "The RenderState object portletMode property is type string");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_WINDOWSTATE, "The RenderState object windowState property is type string");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE1, "The RenderState object clone function returns a new object instance");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE2, "The RenderState object clone function returns a RenderState object with the required properties");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE3, "The RenderState object clone function returns a RenderState object with the same portlet mode");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE4, "The RenderState object clone function returns a RenderState object with the same window state");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE5, "The RenderState object clone function returns a RenderState object with no parameters if the original had no parameters");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE6, "The RenderState object clone function returns a RenderState object with the same single-value parameters if the original had single-value parameters");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_CLONE7, "The RenderState object clone function returns a RenderState object with the same multi-value parameters if the original had multi-value parameters");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETPORTLETMODE1, "The RenderState object setPortletMode function throws a TypeError if the argument is not a string");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETPORTLETMODE2, "The RenderState object setPortletMode function sets the portlet mode");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETPORTLETMODE1, "The RenderState object getPortletMode function returns the portlet mode");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETWINDOWSTATE1, "The RenderState object setWindowState function throws a TypeError if the argument is not a string");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETWINDOWSTATE2, "The RenderState object setWindowState function sets the window state");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETWINDOWSTATE1, "The RenderState object getWindowState function returns the window state");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE1, "The RenderState object setValue function throws a TypeError if the parameter name is not a string");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE2, "The RenderState object setValue function throws a TypeError if the parameter value is not a string or array");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE3, "The RenderState object setValue function can set a single-valued parameter");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE4, "The RenderState object setValue function can set a multi-valued parameter");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_SETVALUE5, "The RenderState object setValue function can set a parameter to null");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE1, "The RenderState object getValue function throws a TypeError if the parameter name is not a string");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE2, "The RenderState object getValue function returns a single-valued parameter");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE3, "The RenderState object getValue function returns null if the parameter was set to null");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE4, "The RenderState object getValue function returns the first value of a multi-valued parameter");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE5, "The RenderState object getValue function returns undefined if the parameter name does not exist and there is no default");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUE6, "The RenderState object getValue function returns the default if the parameter name does not exist and a default is provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES1, "The RenderState object getValues function throws a TypeError if the parameter name is not a string");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES2, "The RenderState object getValues function returns an array of strings for a multi-valued parameter");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES3, "The RenderState object getValues function returns undefined if the parameter name does not exist and there is no default");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_GETVALUES4, "The RenderState object getValues function returns the default if the parameter name does not exist and a default is provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_REMOVE1, "The RenderState object remove function throws a TypeError if the parameter name is not a string");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSSTATE_REMOVE2, "The RenderState object remove function removes an existing parameter");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER1, "The PortletInit object addEventListener function throws a TypeError if no argument is provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER2, "The PortletInit object addEventListener function throws a TypeError if 1 argument is provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER3, "The PortletInit object addEventListener function throws a TypeError if too many (&gt;2) arguments are provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER4, "The PortletInit object addEventListener function throws a TypeError if the type argument is not a string");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER5, "The PortletInit object addEventListener function throws a TypeError if the function argument is not a function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER6, "The PortletInit object addEventListener function throws a TypeError if the type is null");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER7, "The PortletInit object addEventListener function throws a TypeError if the function is null");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ADDEVENTLISTENER8, "The PortletInit object addEventListener function throws a TypeError if the type begins with \"portlet.\" but is neither \"portlet.onStateChange\" or \"portlet.onError\"");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER1, "The PortletInit object removeEventListener function throws a TypeError if no argument is provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER2, "The PortletInit object removeEventListener function throws a TypeError if too many (&gt;1) arguments are provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER3, "The PortletInit object removeEventListener function throws a TypeError if the handle is null");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER4, "The PortletInit object removeEventListener function throws a TypeError if the handle is undefined");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_REMOVEEVENTLISTENER5, "The PortletInit object removeEventListener function throws a TypeError if the handle has an invalid value");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_CREATERESOURCEURL1, "The PortletInit object createResourceUrl function throws a TypeError if too many (&gt;3) arguments are provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_CREATERESOURCEURL2, "The PortletInit object createResourceUrl function throws a TypeError if resource parameters is invalid");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_CREATERESOURCEURL3, "The PortletInit object createResourceUrl function throws a TypeError if the cacheability argument is invalid");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE1, "The PortletInit object setRenderState function throws a TypeError if no argument is provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE2, "The PortletInit object setRenderState function throws a TypeError if too many (&gt;1) arguments are provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE3, "The PortletInit object setRenderState function throws a TypeError if the argument is not an object");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE4, "The PortletInit object setRenderState function throws a TypeError if the single argument is null");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE5, "The PortletInit object setRenderState function throws a TypeError if the argument does not have a \"parameters\" property");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE6, "The PortletInit object setRenderState function throws a TypeError if the argument does not have a \"windowState\" property");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE7, "The PortletInit object setRenderState function throws a TypeError if the argument does not have a \"portletMode\" property");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATE9, "The PortletInit object setRenderState function throws an NotInitializedException if no onStateChange listener is registered");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATEA, "The PortletInit object setRenderState function throws a TypeError if \"windowState\" has an invalid value");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_SETRENDERSTATEB, "The PortletInit object setRenderState function throws a TypeError if \"portletMode\" has an invalid value");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION1, "The PortletInit object action function throws a TypeError if too many (&gt;2) arguments are provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION2, "The PortletInit object action function throws a TypeError if a single argument is null");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION3, "The PortletInit object action function throws a TypeError if the element argument is null");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION4, "The PortletInit object action function throws a TypeError if action parameters is null");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION5, "The PortletInit object action function throws a TypeError if action parameters is invalid");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION6, "The PortletInit object action function throws a TypeError if the element argument is invalid");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION7, "The PortletInit object action function throws a TypeError if there are 2 element arguments");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTION8, "The PortletInit object action function throws a TypeError if there are 2 action parameters arguments");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_ACTIONA, "The PortletInit object action function throws an NotInitializedException if no onStateChange listener is registered.");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_STARTPARTIALACTION1, "The PortletInit object startPartialAction function throws a TypeError if too many (&gt;1) arguments are provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_STARTPARTIALACTION2, "The PortletInit object startPartialAction function throws a TypeError if the single argument is null");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_STARTPARTIALACTION3, "The PortletInit object startPartialAction function throws a TypeError if action parameters is invalid");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSEXC_STARTPARTIALACTION4, "The PortletInit object startPartialAction function throws an NotInitializedException if no onStateChange listener is registered.");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE1, "After an onStateChange listener is added, the portlet hub calls the onStateChange function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE2, "The onStateChange listener type argument has the value 'portlet.onStateChange'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE3, "The onStateChange listener renderState argument is a valid RenderState object");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE4, "A previously added onStateChangeListener can be removed");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONSTATECHANGE5, "The portlet hub throws a TypeError if a previously added onStateChange listener is removed twice");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR1, "An onError listener can be added");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR2, "A previously added onError listener can be removed");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSLISTENER_ONERROR3, "The portlet hub throws a TypeError if a previously added onError listener is removed twice");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL1, "The portlet hub createResourceUrl function returns a string if called with no arguments");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL2, "The portlet hub createResourceUrl function returns a string if called with a resource parameters argument");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL3, "The portlet hub createResourceUrl function returns a string if called with resource parameters and cacheability arguments");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL4, "The portlet hub createResourceUrl function returns a string if called with resource parameters, cacheability, and resource ID arguments");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL5, "The portlet hub createResourceUrl function returns a string if called with a resource ID argument and with the resource parameters and cacheability arguments null");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL6, "The portlet hub createResourceUrl function returns a URL with cacheability set to \"cacheLevelPage\"");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL7, "The portlet hub createResourceUrl function returns a URL with cacheability set to \"cacheLevelPortlet\"");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL8, "The portlet hub createResourceUrl function returns a URL with cacheability set to \"cacheLevelFull\"");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL9, "The portlet hub createResourceUrl function returns a URL with the resource parameters set as expected");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURL0, "The portlet hub createResourceUrl function returns a URL with multivalued resource parameters set as expected");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLA, "The portlet hub createResourceUrl function returns a URL with multivalued resource parameters containing null set as expected");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLB, "The portlet hub createResourceUrl function returns a URL with the render state set when cacheability = cacheLevelPage");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLC, "The portlet hub createResourceUrl function returns a URL with the render state set when cacheability = cacheLevelPortlet");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSURL_CREATERESOURCEURLD, "The portlet hub createResourceUrl function returns a URL with no render state set when cacheability = cacheLevelFull");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE1, "The portlet hub setRenderState function causes the onStateChange listener to be called");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE2, "The portlet hub setRenderState function allows the portlet mode to be set to \"edit\"");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE3, "The portlet hub setRenderState function allows the portlet mode to be set to \"view\"");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE4, "The portlet hub setRenderState function allows the window state to be set to \"maximized\"");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE5, "The portlet hub setRenderState function allows the window state to be set to \"normal\"");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE6, "The portlet hub setRenderState function allows a new parameter \"NewParm\" to be set to \"NewVal\"");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE7, "The portlet hub setRenderState function allows parameter \"NewParm\" to be set to [\"NewVal1\", \"NewVal2\"]");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE8, "The portlet hub setRenderState function allows a new parameter \"NewParm\" to be deleted");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE9, "The portlet hub setRenderState function allows all parameters to be deleted");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATE0, "The portlet hub setRenderState function allows several parameters to be set");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSRS_SETRENDERSTATEA, "The portlet hub setRenderState function allows setting the state back to the original test data");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION1, "The portlet hub action function can be called with no arguments");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION2, "The portlet hub action function can be called with an action parameters argument");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION3, "The portlet hub action function can be called with a form element argument");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION4, "The portlet hub action function can be called with both action parameters and form element arguments");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION5, "The portlet hub action function can cause a private render parameter to be set for the initiating portlet that is target of an event");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION6, "The portlet hub action function can cause a private render parameter to be set for a portlet that is target of an event");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSACTION_ACTION7, "The portlet hub action function fulfills the promise when the action is complete");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE1, "The portlet hub setRenderState function informs the initiating portlet when a public render parameter is set");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE2, "The portlet hub setRenderState function informs other affected portlets when a public render parameter is set");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE3, "The portlet hub setRenderState function allows a public render parameter to be deleted");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSPRP_SETRENDERSTATE4, "The portlet hub setRenderState function informs other affected portlets when public render parameter is deleted");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSPRP_ACTION1, "The portlet hub action function can cause a public render parameter to be set for the initiating portlet that is target of an event");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSPRP_ACTION2, "The portlet hub action function can cause a public render parameter to be set for an affected portlet through an event");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION1, "The portlet hub startPartialAction function can be called with no arguments");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION2, "The portlet hub startPartialAction function can be called with an action parameters argument");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION3, "The portlet hub startPartialAction function returns a PartialActionInit object");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION4, "The PartialActionInit object has a url property of type string");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION5, "The PartialActionInit object has a setPageState property of type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION6, "The PartialActionInit object url property used in an XHR causes a token to be returned that completes the partial action when passed to the setPageState function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JSPA_STARTPARTIALACTION7, "The onStateChange event resulting from a partial action contains render data produced by the portlet resource method");

   }

   /**
    * Constructor.
    * 
    * Passes the static test case names - details map to the superclass
    * 
    * Note that the backing map is static and not threadsafe. Operations
    * that change the map such as put, remove, etc., should not be used
    * in portlets.
    */
   public ModuleTestCaseDetails() {
     super(tcd); 
   }

}
