<!--
    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.	   
-->

<!--
   This stylesheet creates a list of test cases from the portlet.xml file.
   
   A naming convention is used in order to be able to automatically create a
   properties file containing test case names mapping to the page to be accessed
   to execute the test. The test case name is used as the portlet name and as 
   the page name for the test.
   
   Note that the test case name must be unique within the TCK.
   
   In addition, an additional file containing test case name - page name mappings
   can be provided. This allows a page and portlet to contain multiple test cases
   that the test driver will execute sequentially. The parameter "additionalTCs"
   must be set in the project pom with an absolute URI to the file. If the 
   parameter is not set, no additional test cases will be added.
-->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:pa="http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd">
  <xsl:output method="xml" indent="yes" doctype-system="http://java.sun.com/dtd/properties.dtd"/> 
  <xsl:strip-space elements="pa:portlet-app"/>
  <xsl:param name="additionalTCs"/>
  <xsl:param name="copyOnly"/>
  <xsl:template match="/">
    <xsl:element name="properties">
      <xsl:if test="$copyOnly!='true'">
         <xsl:apply-templates/>
      </xsl:if>
      <xsl:if test="$additionalTCs!='false'">
         <xsl:variable name="addi" select="document($additionalTCs)"/>
         <xsl:for-each select="$addi//entry">
            <xsl:element name="entry">
               <xsl:attribute name="key"><xsl:value-of select="@key"/></xsl:attribute>
               <xsl:value-of select="."/>
            </xsl:element>
         </xsl:for-each>
      </xsl:if>
    </xsl:element>
  </xsl:template>
 
  <!-- Create entry element for every portlet. For each entry: 
       key attribute    = test case name                                
       value            = page to be addressed to execute the TC
       
       The test driver will use the name / value pairs along with the context
       base to construct URLs of the following form for test case execution:
       
       http://<test.server.host>:<test.server.port>/<test.context.base><value>
  -->
  <xsl:template match="pa:portlet-app/pa:portlet">
    <xsl:element name="entry">
      <xsl:attribute name="key"><xsl:value-of select="pa:portlet-name"/></xsl:attribute>
      <xsl:value-of select="pa:portlet-name"/>
    </xsl:element>
  </xsl:template>
  
  <!-- ignore all other children of pa:portlet-app -->
  <xsl:template match="pa:portlet-app/*[not(pa:portlet-name)]"/>

</xsl:stylesheet>
