package org.apache.pluto.container.om.portlet.impl;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;

import javax.xml.bind.JAXBElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class ConfigurationProcessor {
   
   
   /** Logger. */
   private static final Logger LOG = LoggerFactory
         .getLogger(ConfigurationProcessor.class);
   

   /**
    * Traverses the portlet deployment descriptor tree and returns the data in
    * the form of a portlet application definition.
    * 
    * @param rootElement
    *           Root element of portlet DD tree
    * @return The parsed portlet application definition
    * @throws IllegalArgumentException
    *            If there is a data validation error
    */
   public abstract PortletApplicationDefinition process(
         JAXBElement<?> rootElement) throws IllegalArgumentException;

   /**
    * Handle the locale the old-fashioned way (v1 & v2)
    */
   protected Locale deriveLocale(String lang) {
      Locale locale = Locale.ENGLISH;
      if (lang != null) {
         if (lang.contains("_") == true) {

            // tolerate underscores to support old portlets
            String[] parts = lang.split("_");
            if (parts.length == 2) {
               locale = new Locale(parts[0], parts[1]);
            } else {
               locale = new Locale(parts[0], parts[1], parts[2]);
            }

         } else {
            locale = Locale.forLanguageTag(lang);     //BCP47
         }
      }
      return locale;
   }

   /**
    * Check if input string is valid java identifier
    * 
    * @param id
    * @return
    */
   protected boolean isValidIdentifier(String id) {
      char[] chars = id.toCharArray();
      if (!Character.isJavaIdentifierStart(chars[0])) {
         return false;
      }
      for (char c : Arrays.copyOfRange(chars, 1, chars.length)) {
         if (!Character.isJavaIdentifierPart(c) && (c != '.')) {
            return false;
         }
      }
      return true;
   }

   /**
    * checks if class name is valid by trying to load it. If the optional
    * argument <code>assignable</code> is provided, the method will check if the
    * class can be assigned.
    * 
    * @param clsName
    *           Class name string from configuration
    * @param assignable
    *           Interface to which the class should be assignable
    * @param msg
    *           Error message used when exception is thrown.
    */
   protected void checkValidClass(String clsName, Class<?> assignable, String msg) {
   
      StringBuilder txt = new StringBuilder(128);
      txt.append(msg);
      txt.append(clsName);
      if (!isValidIdentifier(clsName)) {
         txt.append(". Invalid java identifier.");
         LOG.warn(txt.toString());
         throw new IllegalArgumentException(txt.toString());
      }
   
      // Make sure the class can be loaded
      Class<?> valClass = null;
      try {
         ClassLoader cl = this.getClass().getClassLoader();
         valClass = cl.loadClass(clsName);
         if (assignable != null && !assignable.isAssignableFrom(valClass)) {
            txt.append(". Specified class is not a ");
            txt.append(assignable.getCanonicalName());
            throw new Exception();
         }
      } catch (Exception e) {
         LOG.warn(txt.toString());
         throw new IllegalArgumentException(txt.toString(), e);
      }
   }
   
   /**
    * Reads web app deployment descriptor to extract the locale - encoding mappings 
    * 
    * @param in            Input stream for DD
    * @param pad           Portlet application definition to be updated
    * @throws Exception    If there is a parsing problem
    */
   public void processWebDD(InputStream in, PortletApplicationDefinition pad) throws Exception {

      // set up document
      DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
      final DocumentBuilder builder = fact.newDocumentBuilder();
      final Document document = builder.parse(in);
      final Element root = document.getDocumentElement();

      // Generate xpath queries
      final XPathFactory xpathFactory = XPathFactory.newInstance();
      final XPath xpath = xpathFactory.newXPath();
      final XPathExpression GET_LIST = 
            xpath.compile("//locale-encoding-mapping-list/locale-encoding-mapping");
      final XPathExpression GET_LOC = xpath.compile("locale/text()");
      final XPathExpression GET_ENC = xpath.compile("encoding/text()");

      // get list of locale - encoding mappings and process them
      NodeList nodes = (NodeList) GET_LIST.evaluate(root,
            XPathConstants.NODESET);

      for (int jj = 0; jj < nodes.getLength(); jj++) {
         Node node = nodes.item(jj);
         String locstr = (String) GET_LOC.evaluate(node, XPathConstants.STRING);
         String encstr = (String) GET_ENC.evaluate(node, XPathConstants.STRING);
         Locale locale = deriveLocale(locstr);
         pad.addLocaleEncodingMapping(locale, encstr);
      }
   }

}