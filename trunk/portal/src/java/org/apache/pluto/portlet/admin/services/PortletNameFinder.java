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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.pluto.portlet.admin.PlutoAdminConstants;
import org.apache.pluto.portlet.admin.PlutoAdminException;
import org.apache.pluto.portlet.admin.PlutoAdminLogger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * Gets the portlet names from portlet.xml using SAX
 *
 * @author Ken Atherton
 *
 */
public class PortletNameFinder {

 	public static final String CLASS_NAME = "PortletNameFinder";

    PortletNameFinder() {
    }


    public static ArrayList  getPortletNames(InputStream ios) throws Exception {
    	  final String METHOD_NAME = "getPortletNames(InputStream)";
        ArrayList nameList = new ArrayList();
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
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
        	PlutoAdminLogger.logError(CLASS_NAME, METHOD_NAME, e);
        	throw new PlutoAdminException(e);
        }

        OutputStreamWriter errorWriter =
                new OutputStreamWriter(System.err, PlutoAdminConstants.ENCODING);
        db.setErrorHandler(
                new MyErrorHandler(new PrintWriter(errorWriter, true)));

        Document doc = null;
        try {
            doc = db.parse(ios);
        } catch (SAXException e) {
        	PlutoAdminLogger.logError(CLASS_NAME, METHOD_NAME, e);
        	throw new PlutoAdminException(e);
        } catch (IOException e) {
        	PlutoAdminLogger.logError(CLASS_NAME, METHOD_NAME, e);
        	throw new PlutoAdminException(e);
        }

        NodeList portletNames = doc.getElementsByTagName("portlet-name");
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



}
