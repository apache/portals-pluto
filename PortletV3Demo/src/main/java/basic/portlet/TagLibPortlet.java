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

package basic.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;

import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.PortletRequest.LIFECYCLE_PHASE;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.EventDefinition;
import javax.portlet.annotations.EventMethod;
import javax.portlet.annotations.HeaderMethod;
import javax.portlet.annotations.Namespace;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletQName;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.portlet.filter.HeaderResponseWrapper;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.xml.namespace.QName;

/**
 * This portlet exercises the dynamic dependency provisioning and declaration functions.
 * 
 * @author Scott Nicklous
 * 
 */
@PortletApplication(events= {@EventDefinition(
      qname=@PortletQName(namespaceURI="http://www.apache.org/portals/pluto", localPart="TagLibPortlet"),
      payloadType=String.class)})
@ApplicationScoped
public class TagLibPortlet {


   private static final String PROXY = "/ActEvtProxy";

   private static final Logger LOGGER     = Logger.getLogger(TagLibPortlet.class.getName());

   public static final String  PHASE      = "phase";
   public static final String  PHASE_HDR  = "header";
   public static final String  PHASE_REN  = "render";
   public static final String  PHASE_RES  = "resource";
   public static final String  PHASE_ACT  = "action";
   public static final String  PHASE_EVT  = "event";
   
   public static final String  TEST       = "test";
   public static final String  TEST_OBJ   = "obj";
   public static final String  TEST_BEAN  = "bean";

   public static final String  ATTRIB_TXT          = "text";
   public static final String  ATTRIB_PHASE_TITLE  = "phaseTitle";

   private static final String JSPDLG     = "/WEB-INF/jsp/tagLibDialog.jsp";
   private static final String JSPOBJ     = "/WEB-INF/jsp/tagLibObjects.jsp";
   private static final String JSPBEANS   = "/WEB-INF/jsp/tagLibBeans.jsp";
   
   // for event processing
   private static final String URI     = "http://www.apache.org/portals/pluto";
   private static final String LPART   = "TagLibPortlet";

   @Inject
   private PortletConfig       pcfg;
   @Inject
   @Namespace
   private String              pid;
   
   /**
    * for selecting the JSP based on parameter value
    */
   private static String getJsp(String ttype) {
      String jsp = JSPOBJ;
      if (ttype != null && ttype.equals(TEST_BEAN)) {
         jsp = JSPBEANS;
      }
      return jsp;
   }

   /**
    * Adds required dynamic dependencies
    */
   @HeaderMethod(portletNames = "TagLibPortlet")
   public void header(HeaderRequest req, HeaderResponse resp) throws IOException {

      // Add link tag to head section to include the style sheet

      String contextRoot = req.getContextPath();
      StringBuilder txt = new StringBuilder(128);
      txt.append("<link href='").append(contextRoot);
      txt.append("/resources/css/infobox.css' rel='stylesheet' type='text/css'>");
      resp.addDependency("infobox", "org.apache.pluto", "0.4.0", txt.toString());

   }

   /**
    * Renders the dialog through a JSP
    * 
    * @throws IOException
    * @throws PortletException
    */
   @RenderMethod(portletNames = "TagLibPortlet", ordinal = 100)
   public void render(RenderRequest req, RenderResponse resp) throws PortletException, IOException {
      String phase = req.getRenderParameters().getValue(PHASE);
      if (phase == null) {
         phase = PHASE_REN;
      }
      req.setAttribute(PHASE, phase);

      String ttype = req.getRenderParameters().getValue(TEST);
      if (ttype == null) {
         ttype = TEST_OBJ;
      }
      req.setAttribute(TEST, ttype);

      PortletRequestDispatcher prd = req.getPortletContext().getRequestDispatcher(JSPDLG);
      prd.include(req, resp);

      StringBuilder txt = new StringBuilder(128);
      txt.append("Portlet name: ").append(pcfg.getPortletName());
      txt.append(", phase: ").append(phase);
      txt.append(", test type: ").append(ttype);
      LOGGER.fine(txt.toString());

      if (phase.equals(PHASE_REN)) {
         req.setAttribute(ATTRIB_PHASE_TITLE, req.getAttribute(LIFECYCLE_PHASE));
         prd = req.getPortletContext().getRequestDispatcher(getJsp(ttype));
         prd.include(req, resp);
      } else if (phase.equals(PHASE_RES)) {
         ResourceURL resurl = resp.createResourceURL();

         txt.setLength(0);
         txt.append("<div id='").append(pid).append("-putResourceHere'></div>\n");
         txt.append("<script>\n");
         txt.append("(function () {\n");
         txt.append("   var xhr = new XMLHttpRequest();\n");
         txt.append("   xhr.onreadystatechange=function() {\n");
         txt.append("      if (xhr.readyState==4 && xhr.status==200) {\n");
         txt.append("         document.getElementById('").append(pid)
               .append("-putResourceHere').innerHTML=xhr.responseText;\n");
         txt.append("      }\n");
         txt.append("   };\n");
         txt.append("   xhr.open(\"GET\",\"").append(resurl.toString()).append("\",true);\n");
         txt.append("   xhr.send();\n");
         txt.append("})();\n");
         txt.append("</script>\n");

         resp.getWriter().write(txt.toString());

      } else {
         String output = (String) req.getPortletSession().getAttribute(ATTRIB_TXT);
         if (output != null) {
            resp.getWriter().write(output);
            req.getPortletSession().removeAttribute(ATTRIB_TXT);
         } else {
            output = (String) req.getPortletSession().getAttribute(ATTRIB_TXT, APPLICATION_SCOPE);
            if (output != null) {
               resp.getWriter().write(output);
               req.getPortletSession().removeAttribute(ATTRIB_TXT, APPLICATION_SCOPE);
            } else {
               txt.setLength(0);
               txt.append("<div class='redbox'>");
               txt.append("<p>No data found.</p>");
               txt.append("</div>");
               resp.getWriter().write(txt.toString());
            }
         }
      }

   }

   @ServeResourceMethod(portletNames = "TagLibPortlet")
   public void getTable(ResourceRequest req, ResourceResponse resp) throws PortletException, IOException {
      req.setAttribute(ATTRIB_PHASE_TITLE, req.getAttribute(LIFECYCLE_PHASE));
      String ttype = req.getRenderParameters().getValue(TEST);
      PortletRequestDispatcher prd = req.getPortletContext().getRequestDispatcher(getJsp(ttype));
      prd.include(req, resp);
   }

   @HeaderMethod(portletNames = "TagLibPortlet")
   public void collectHdrData(HeaderRequest req, HeaderResponse resp) throws PortletException, IOException {
      String phase = req.getRenderParameters().getValue(PHASE);
      String ttype = req.getRenderParameters().getValue(TEST);
      if (phase != null && phase.equals(PHASE_HDR)) {
         req.setAttribute(ATTRIB_PHASE_TITLE, req.getAttribute(LIFECYCLE_PHASE));
         HdrRespWrapper wrapped = new HdrRespWrapper(resp);
         PortletRequestDispatcher prd = req.getPortletContext().getRequestDispatcher(getJsp(ttype));
         prd.include(req, wrapped);
         req.getPortletSession().setAttribute(ATTRIB_TXT, wrapped.getOutput());
      }
   }

   @ActionMethod(portletName = "TagLibPortlet", 
         publishingEvents= {@PortletQName(namespaceURI=URI, localPart=LPART)})
   public void handleDialog(ActionRequest req, ActionResponse resp) throws PortletException, IOException {
      
      String ttype = req.getActionParameters().getValue(TEST);
      if (ttype == null) {
         ttype  = TEST_OBJ;
      }
      resp.getRenderParameters().setValue(TEST, ttype);
      
      String phase = req.getActionParameters().getValue(PHASE);
      if (phase != null) {
         resp.getRenderParameters().setValue(PHASE, phase);
         if (phase.equals(PHASE_ACT)) {
            req.setAttribute(ATTRIB_PHASE_TITLE, req.getAttribute(LIFECYCLE_PHASE));
            PortletRequestDispatcher prd = req.getPortletContext().getRequestDispatcher(PROXY);
            prd.include(req, resp);
         } else if (phase.equals(PHASE_EVT)) {
            QName qn = new QName(URI, LPART);
            resp.setEvent(qn, pid);
         }
      } 

      StringBuilder txt = new StringBuilder(128);
      txt.append("Parameter: ").append(PHASE);
      txt.append(", value: ").append(phase);
      LOGGER.fine(txt.toString());

   }
   
   
   @EventMethod(portletName = "TagLibPortlet",
         processingEvents= {@PortletQName(namespaceURI=URI, localPart=LPART)})
   public void doEvent(EventRequest req, EventResponse resp) throws PortletException, IOException {
      String payload = (String) req.getEvent().getValue();
      
      // make sure event came from this instance
      
      if (payload != null && payload.equals(pid)) {
         req.setAttribute(ATTRIB_PHASE_TITLE, req.getAttribute(LIFECYCLE_PHASE));
         PortletRequestDispatcher prd = req.getPortletContext().getRequestDispatcher(PROXY);
         prd.include(req, resp);
      }
      
   }

   // =========== inner classes =============
   private static class HdrRespWrapper extends HeaderResponseWrapper {

      StringWriter sw = new StringWriter();
      PrintWriter  pw = new PrintWriter(sw);

      public HdrRespWrapper(HeaderResponse response) {
         super(response);
      }

      public String getOutput() {
         pw.flush();
         return sw.toString();
      }

      @Override
      public PrintWriter getWriter() throws IOException {
         return pw;
      }
   }

   private static class ProxyRespWrapper extends HttpServletResponseWrapper {

      StringWriter sw = new StringWriter();
      PrintWriter  pw = new PrintWriter(sw);

      public ProxyRespWrapper(HttpServletResponse response) {
         super(response);
      }

      public String getOutput() {
         pw.flush();
         return sw.toString();
      }

      @Override
      public PrintWriter getWriter() throws IOException {
         return pw;
      }

   }

   @WebServlet(urlPatterns = PROXY)
   public static class ActEvtProxyServlet extends HttpServlet {
      private static final long serialVersionUID = -1798128019502989930L;
      private static final Logger LOGGER = Logger.getLogger(TagLibPortlet.ActEvtProxyServlet.class.getName());

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         ProxyRespWrapper wrapped = new ProxyRespWrapper(resp);
         String ttype = req.getParameter(TEST);
         RequestDispatcher rd = req.getRequestDispatcher(getJsp(ttype));
         rd.include(req, wrapped);
         String output = wrapped.getOutput();
         req.getSession().setAttribute(ATTRIB_TXT, output);
         LOGGER.fine("Proxy executed. Output length: " + ((output == null) ? "null" : output.length()));
      }
      
      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         doGet(req, resp);
      }
   }
}
