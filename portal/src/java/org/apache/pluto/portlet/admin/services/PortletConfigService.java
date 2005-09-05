/*
 * Copyright 2003,2004,2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.portlet.admin.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.portlet.admin.PlutoAdminConstants;
import org.apache.pluto.portlet.admin.PlutoAdminException;
import org.apache.pluto.portlet.admin.PlutoAdminLogger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * Parses out info from portlet.xml, putting them in a list
 * of PortletDD objects to be used to update web.xml during deployment.
 *
 * @author Craig Doremus
 *
 */
public class PortletConfigService {
	  private Document _doc = null;
	  private List portletDDList = null;
	  
	  public static final String CLASS_NAME = "PortletConfigService";

	 private PortletConfigService() {
	 }
	
	 public PortletConfigService(InputStream ios) {
	     _doc = getDocument(ios);
	     createPortletDDList();
	 }
	
	 	
	 private static Document getDocument(InputStream ios) {
   	     final String METHOD_NAME = "getDocument(InputStream)";
	     boolean validation = false;
	
	     boolean ignoreWhitespace = false;
	     boolean ignoreComments = false;
	     boolean putCDATAIntoText = false;
	     boolean createEntityRefs = false;
	
	     DocumentBuilderFactory dbf =
	             DocumentBuilderFactory.newInstance();
	
	     dbf.setValidating(validation);
	     dbf.setIgnoringComments(ignoreComments);
	     dbf.setIgnoringElementContentWhitespace(ignoreWhitespace);
	     dbf.setCoalescing(putCDATAIntoText);
	     dbf.setExpandEntityReferences(!createEntityRefs);
	
	     DocumentBuilder db = null;
	     Document doc = null;
	     try {
	         db = dbf.newDocumentBuilder();
	
	         OutputStreamWriter errorWriter =
	             new OutputStreamWriter(System.err, PlutoAdminConstants.ENCODING);
	         db.setErrorHandler(
	             new MyErrorHandler(new PrintWriter(errorWriter, true)));
	
	         doc = db.parse(ios);
	     } catch (ParserConfigurationException e) {
     		 PlutoAdminLogger.logError(CLASS_NAME, METHOD_NAME, e);
     		 throw new PlutoAdminException(e);
	     } catch (SAXException e) {
	     		 PlutoAdminLogger.logError(CLASS_NAME, METHOD_NAME, e);
	     		 throw new PlutoAdminException(e);
	     } catch (IOException e) {
	     		 PlutoAdminLogger.logError(CLASS_NAME, METHOD_NAME, e);
	     		 throw new PlutoAdminException(e);
	     }
	     return doc;
	 }
	
	
	 /**
	  * 
	  * @return
	  * @throws Exception
	  */
	 private void createPortletDDList()  {
		final String METHOD_NAME = "createPortletDDList";
		portletDDList = new ArrayList();
	    NodeList portlets = _doc.getElementsByTagName("portlet");
	    Element portlet = null;
	    PortletDD portletDD = null;
	    NodeList roleRefs = null;
	    ArrayList refList = null;
	    String name = null;
	    String className = null;
	    Element ref = null;
	    String refName = null;
	    String refLink = null;
		if (portlets != null) {
			for (int i = 0; i < portlets.getLength(); i++) {
				portletDD = new PortletDD();
				portlet = (Element)portlets.item(i);
				//portlet-name is required
				name = portlet.getElementsByTagName("portlet-name").item(0).getChildNodes().item(0).getNodeValue();
				if (name == null) {
					IllegalStateException e =  
						new IllegalStateException("The portlet-name element is required in portlet.xml");
		     		 PlutoAdminLogger.logError(CLASS_NAME, METHOD_NAME, e);
		     		 throw e;
				}
				portletDD.setPortletName(name);
				//portlet-class is required
				className = portlet.getElementsByTagName("portlet-class").item(0).getChildNodes().item(0).getNodeValue();
				if (className == null) {
					IllegalStateException e =  
						new IllegalStateException("The portlet-class element is required in portlet.xml");
		     		 PlutoAdminLogger.logError(CLASS_NAME, METHOD_NAME, e);
		     		 throw e;
				}
				portletDD.setPortletClass(className);
				roleRefs = portlet.getElementsByTagName("security-role-ref");
				refList = new ArrayList();
				if (roleRefs != null && roleRefs.getLength() != 0) {
					for (int j = 0; j < roleRefs.getLength(); j++) {
						ref = (Element)roleRefs.item(j);
						refName = ref.getElementsByTagName("role-name").item(0).getChildNodes().item(0).getNodeValue();
						//role-link is optional
						if (ref.getElementsByTagName("role-link").item(0) != null) {
							refLink = ref.getElementsByTagName("role-link").item(0).getChildNodes().item(0).getNodeValue();
						}
						refList.add(new RoleRef(refName, refLink));	
					}
				}

				portletDD.setSecurityRoleRefs(refList);
				portletDDList.add(portletDD);	
				
			}
		} else {
			IllegalStateException e =  
				new IllegalStateException("The portlet.xml file does not contain portlet elements.");
     		 PlutoAdminLogger.logError(CLASS_NAME, METHOD_NAME, e);
     		 throw e;
		}
	     
	 }
	 
	 /**
	  * Small Value Object holding a security-role-ref name and link
	  * values in the portletDDList List.
	  * 
	  * @author cdoremus
	  *
	  */
	 public class RoleRef {
		 public String roleName = null;
		 public String roleLink = null;
		 private RoleRef(){}
		 public RoleRef(String p_roleName, String p_roleLink) {
			 roleName = p_roleName;
			 roleLink = p_roleLink;
		 }
	 }
	 
    /**
     *
     * Inner class that handles errors
     *
     * @author Ken Atherton
     *
     */
    private static class MyErrorHandler implements ErrorHandler {
        private static final String INNER_CLASS_NAME = "MyErrorHandler";
        PrintWriter out = null;
        MyErrorHandler(PrintWriter p_out) {
        	out = p_out;
        }


       private String getParseExceptionInfo(SAXParseException e) {
            String systemId = e.getSystemId();
            if (systemId == null) {
                systemId = "null";
            }
            String info = "URI=" + systemId +
                " Line=" + e.getLineNumber() +
                ": " + e.getMessage();
            return info;
        }


        public void warning(SAXParseException e) throws SAXException {
        		String METHOD_NAME = "warning(e)";
            String msg = "Warning: " + getParseExceptionInfo(e);
          	PlutoAdminLogger.logWarn(INNER_CLASS_NAME, METHOD_NAME, msg);
        }

        public void error(SAXParseException e) throws SAXException {
      		String METHOD_NAME = "error(e)";
            String message = "Error: " + getParseExceptionInfo(e);
          	PlutoAdminLogger.logError(INNER_CLASS_NAME, METHOD_NAME, message, e);
            throw new SAXException(message);
        }

        public void fatalError(SAXParseException e) throws SAXException {
      		String METHOD_NAME = "fatalError(e)";
            String message = "Fatal Error: " + getParseExceptionInfo(e);
          	PlutoAdminLogger.logError(INNER_CLASS_NAME, METHOD_NAME, message, e);
            throw new SAXException(message);
        }
    }

	public List getPortletDDList() {
		return portletDDList;
	}


/*	
	 public ArrayList getPortletNames() throws Exception {
		 final String METHOD_NAME = "getPortletNames()";
	     ArrayList nameList = new ArrayList();
	     NodeList portletNames = _doc.getElementsByTagName("portlet-name");
	     if (null !=  portletNames)
	     {
	         for (int i = 0; i < portletNames.getLength(); i++) {
	             if (null != portletNames.item(i).getChildNodes().item(0))
	             {
	                 String portletName  =  portletNames.item(i).getChildNodes().item(0).getNodeValue();
	                 nameList.add(portletName);
	             }
	         }
	     }
	     return nameList;
	 }
*/
}
