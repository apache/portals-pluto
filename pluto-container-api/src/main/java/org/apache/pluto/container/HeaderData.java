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

package org.apache.pluto.container;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * This class is a holder for the HTTP header data, cookies, and header section markup provided by the portlet during
 * header phase execution. Handles
 * 
 * @author Scott Nicklous
 * 
 */
public class HeaderData {

   /** Logger. */
   private static final Logger       LOG                = LoggerFactory.getLogger(HeaderData.class);
   private static final boolean      isDebug            = LOG.isDebugEnabled();
   private static final boolean      isTrace            = LOG.isTraceEnabled();

   // for document processing
   private DocumentBuilder           docBuilder         = null;
   private Document                  doc                = null;
   private Element                   root               = null;
   private static final String       ROOT_ELEMENT       = "rootElement";
   private static final String       ROOT_ELEMENT_START = "<rootElement>";
   private static final String       ROOT_ELEMENT_END   = "</rootElement>";
   private static final String       ROOT_ELEMENT_REGEX = "(?:\\s*)</{0,1}" + ROOT_ELEMENT + ">(?:\\s*)";

   private static final Set<String>  allowedTags        = new HashSet<String>(Arrays.asList(new String[] { 
         "META", "LINK", "STYLE", "SCRIPT", "NOSCRIPT"         }));

   private List<Cookie>              cookies            = new ArrayList<Cookie>();
   private Map<String, List<String>> httpHeaders        = new HashMap<String, List<String>>();
   private int                       bufferSize         = 128;
   private ByteArrayOutputStream     baoStream          = null;
   private StringWriter              sWriter            = null;
   private PrintWriter               pWriter            = null;
   
   private Map<PageResourceId, String> resources = new LinkedHashMap<PageResourceId, String>();
   
   /**
    * default constructor
    */
   public HeaderData() {
   }
   
   /**
    * Lazy setup of document and buffers
    * @throws ParserConfigurationException
    */
   private void setupDoc() throws ParserConfigurationException {
      DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
      dbfac.setExpandEntityReferences(true);
      docBuilder = dbfac.newDocumentBuilder();
      
      // the following avoids cluttering the console log with unwanted messages
      docBuilder.setErrorHandler(new ErrorHandler() {
         @Override
         public void warning(SAXParseException arg0) throws SAXException {
         }
         
         @Override
         public void fatalError(SAXParseException arg0) throws SAXException {
         }
         
         @Override
         public void error(SAXParseException arg0) throws SAXException {
         }
      });
      
      doc = docBuilder.newDocument();
      root = doc.createElement(ROOT_ELEMENT);
      doc.appendChild(root);
   }

   /**
    * returns a string containing any tags that should go into the document head section.
    * 
    * @return String containing the tags, or the empty string if no tags are available.
    */
   private String getTags(Document doc) {
      String tags = "";
      if (doc != null) {
         DOMSource src = new DOMSource(doc);
         StringWriter sw = new StringWriter();
         StreamResult res = new StreamResult(sw);
         try {

            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.METHOD, "html");

            trans.transform(src, res);

            tags = sw.toString().replaceAll(ROOT_ELEMENT_REGEX, "");

         } catch (Exception e) {
            StringBuilder txt = new StringBuilder();
            txt.append("Error converting tags to string. Exception: ");
            txt.append(e.toString());
            LOG.warn(txt.toString());
         }
      }

      if (isTrace) {
         StringBuilder sb = new StringBuilder();
         sb.append("returning tags: ");
         sb.append((tags.length() > 0) ? "\n" + tags : "");
         LOG.trace(sb.toString());
      }

      return tags;
   }
   
   /**
    * Parses input text to extract tags that are valid for the document head section.
    * 
    * @param src     the text to parse
    * @param chkArgs if true, illegal argument exception is thrown when source 
    *                contains invalid tags. Otherwise, invalid tags are silently deleted.
    * @return        the extracted tags in string form
    */
   private String getTagsFromText(String src, boolean chkArgs) {
      StringBuilder txt = new StringBuilder(128);
      
      if (src != null) {
         StringBuffer sb = new StringBuffer(128);
         sb.append(ROOT_ELEMENT_START);
         
         // need to do some preprocessing on the input text to avoid placing a burden on the 
         // portlet developer. Goals:
         //    * allow meta and link tags with or without a closing slash
         //    * allow use of unescaped angle brackets within script tag

         // make the parser eat link & meta tags with or without closing slash.
         src = src.replaceAll("(<(?:meta|link).*?[^/])>", "$1/>");

         // disappear any link or meta closing tags, since we're generating html
         src = src.replaceAll("</(?:meta|link)>", "");
         
         // convert < brackets within script tags to corresponding entities
         
         Pattern pat = Pattern.compile(
               "(?s)" +                     // multiline mode 
               "(?<=<(script|style))" +     // 0-width lookbehind; start tag
               "(.*?)" +                    // non-greedy content of tag
               "(?=</(script|style))");     // 0-width lookahead; end tag
         Matcher mat = pat.matcher(src);
         while (mat.find()) {

            String group = mat.group();
            int indexOfBeginCDATA = group.indexOf("<![CDATA[");
            String replacedGroup = "";

            if (indexOfBeginCDATA < 0) {
                replacedGroup = group.replaceAll("&", "&amp;").replaceAll("<", "&lt;");
            }

            // don't convert < brackets within CDATA
            while (indexOfBeginCDATA > -1) {

                String beforeCDATA = group.substring(0, indexOfBeginCDATA);
                replacedGroup += beforeCDATA.replaceAll("&", "&amp;").replaceAll("<", "&lt;");
                int indexOfEndCDATA = group.indexOf("]]>") +  "]]>".length();
                replacedGroup += group.substring(indexOfBeginCDATA, indexOfEndCDATA);
                String afterCDATA = group.substring(indexOfEndCDATA);
                indexOfBeginCDATA = afterCDATA.indexOf("<![CDATA[");

                if (indexOfBeginCDATA > 0) {
                    indexOfBeginCDATA += indexOfEndCDATA;
                }
                else {
                    replacedGroup += afterCDATA.replaceAll("&", "&amp;").replaceAll("<", "&lt;");
                }
            }

            mat.appendReplacement(sb, Matcher.quoteReplacement(replacedGroup));
         }
         mat.appendTail(sb);

         sb.append(ROOT_ELEMENT_END);

         StringReader sr = new StringReader(sb.toString());
         InputSource is = new InputSource(sr);
         Document adoc;

         try {
            if (docBuilder == null) {
               setupDoc();
            }
            adoc = docBuilder.parse(is);

            // verify that all tags are allowed
            Element aroot = adoc.getDocumentElement();
            NodeList nodes = aroot.getChildNodes();
            for (int ii = 0; ii < nodes.getLength(); ii++) {
               Node node = nodes.item(ii);

               // check for valid node type
               int type = node.getNodeType();
               if (type != Node.COMMENT_NODE && type != Node.TEXT_NODE && type != Node.ELEMENT_NODE) {

                  StringBuilder err = new StringBuilder(128);
                  err.append("Invalid node type: ");
                  err.append(type);
                  err.append(", node name: ").append(node.getNodeName());
                  LOG.warn(err.toString());
                  
                  if (chkArgs) {
                     throw new IllegalArgumentException(err.toString());
                  }
                  
                  aroot.removeChild(node);
                  continue;
               }

               // a text node may only contain white space
               if (type == Node.TEXT_NODE) {
                  String text = ((Text) node).getWholeText();

                  if (!text.matches("^\\s*$")) {
                     StringBuilder err = new StringBuilder(128);
                     err.append("Invalid text node: ");
                     err.append(node.getNodeValue());
                     err.append(", node name: ").append(node.getNodeName());
                     txt.append(", allowed tags: ").append(allowedTags.toString());
                     LOG.warn(err.toString());
                     
                     if (chkArgs) {
                        throw new IllegalArgumentException(err.toString());
                     }
                     
                     aroot.removeChild(node);
                     continue;
                  }

               }

               // an element node must be one of the allowed tags
               if (type == Node.ELEMENT_NODE) {
                  String name = ((Element) node).getTagName();

                  if (!allowedTags.contains(name.toUpperCase())) {
                     StringBuilder err = new StringBuilder(128);
                     err.append("Invalid tag: ");
                     err.append(name);
                     err.append(", node name: ").append(node.getNodeName());
                     LOG.warn(err.toString());
                     
                     if (chkArgs) {
                        throw new IllegalArgumentException(err.toString());
                     }
                     
                     aroot.removeChild(node);
                     continue;
                  }

               }
            }

            txt.append(getTags(adoc));
         } catch (IllegalArgumentException e) {
            throw e;
         } catch (SAXParseException e) {
            StringBuilder err = new StringBuilder();
            err.append("Problem parsing tag data: ").append(src.replaceAll("&", "&amp;").replaceAll("<", "&lt;"));
            throw new IllegalArgumentException(err.toString(), e);
         } catch (Exception e) {
            
            // likely resource or config issue, not recoverable and not application's fault
            
            StringBuilder err = new StringBuilder();
            err.append("Problem parsing tag data: ");
            err.append("\n   Original data: ").append(src);
            err.append("\n   Modified buffer: ").append(sb.toString());
            err.append("\nStack trace:\n");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            err.append(sw.toString());
            LOG.warn(err.toString());
         }

      }
      
      return txt.toString();
   }

   /**
    * resets output stream and writer
    */
   public void resetBuffer() {
      if (isDebug) {
         LOG.debug("Resetting buffer.");
      }
      if (baoStream != null) {
         baoStream.reset();
      }
      if (pWriter != null) {
         sWriter = new StringWriter(bufferSize);
         pWriter = new PrintWriter(sWriter);
      }
   }

   /**
    * resets all header data
    */
   public void reset() {
      resetBuffer();
      httpHeaders.clear();
      cookies.clear();
   }

   public PrintWriter getWriter() {
      if (baoStream != null) {
         throw new IllegalStateException("getWriter may not be called after getPortletOutputStream.");
      }
      if (pWriter == null) {
         sWriter = new StringWriter(bufferSize);
         pWriter = new PrintWriter(sWriter);
      }
      if (isDebug) {
         LOG.debug("returning writer.");
      }
      return pWriter;
   }

   public ByteArrayOutputStream getBaoStream() {
      if (sWriter != null) {
         throw new IllegalStateException("getPortletOutputStream may not be called after getWriter.");
      }
      if (baoStream == null) {
         baoStream = new ByteArrayOutputStream(bufferSize);
      }
      if (isDebug) {
         LOG.debug("returning output stream.");
      }
      return baoStream;
   }

   public int getBufferSize() {
      return bufferSize;
   }

   public void setBufferSize(int bufferSize) {
      this.bufferSize = bufferSize;
   }

   public String getHeadSectionMarkup() {

      // First add the markup that was generated by adding elements, then add markup written to the
      // output stream.

      StringBuilder txt = new StringBuilder(128);
      txt.append(getTags(doc));

      String src = null;
      if (sWriter != null) {
         src = sWriter.toString();
      } else if (baoStream != null) {
         src = baoStream.toString();
      }
      
      txt.append("\n<!-- markup from portlet output stream -->");
      txt.append(getTagsFromText(src, false));

      return txt.toString();
   }

   public List<Cookie> getCookies() {
      return cookies;
   }

   public void addCookie(Cookie cookie) {
      cookies.add(cookie);
   }

   public Map<String, List<String>> getHttpHeaders() {
      return httpHeaders;
   }

   public void addHttpHeader(String name, String value) {
      if (!httpHeaders.containsKey(name)) {
         ArrayList<String> vals = new ArrayList<String>(2);
         httpHeaders.put(name, vals);
      }
      httpHeaders.get(name).add(value);
   }

   public void setHttpHeader(String name, String value) {
      ArrayList<String> vals = new ArrayList<String>(Arrays.asList(new String[] { value }));
      httpHeaders.put(name, vals);
   }

   public void addHeaderTag(Element e) {
      String tag = e.getTagName().toUpperCase();
      if (allowedTags.contains(tag)) {
         // If element was created with createElement, root will be initialized
         if (root != null) {
            root.appendChild(e);
         }
      } else {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Ignoring element with disallowed tag name: ").append(tag);
         txt.append(", allowed tags: ").append(allowedTags.toString());
         LOG.warn(txt.toString());
      }
   }

   public Element createElement(String tagName) {
      try {
         if (doc == null) {
            setupDoc();
         }
         return doc.createElement(tagName);
      } catch (ParserConfigurationException e) {
         throw new DOMException((short) 0, "Initialization failure");
      }
   }

   public void addDependency(String name, String scope, String version) {
      
      if (name == null || name.length() == 0) {
         throw new IllegalArgumentException("Dependency name field may not be null or empty.");
      }
      
      PageResourceId pres = new PageResourceId(name, scope, version);
      resources.put(pres, null);
      
   }

   public void addDependency(String name, String scope, String version, String markup) {
      
      if (name == null || name.length() == 0) {
         throw new IllegalArgumentException("Dependency name field may not be null or empty.");
      }
      
      if (markup == null || markup.length() == 0) {
         throw new IllegalArgumentException("Markup may not be null or empty when adding dependency.");
      }
      
      PageResourceId pres = new PageResourceId(name, scope, version);
      String resource = getTagsFromText(markup, true);
      resources.put(pres, resource);

   }
   
   /**
    * gets the dependencies that were dynamically added during render headers processing.
    * 
    * @return  A map of resource IDs to resources. If no resource was provided, 
    *          the value will be <code>null</code>.
    */
   public Map<PageResourceId, String> getDynamicResources() {
      return resources;
   }

}
