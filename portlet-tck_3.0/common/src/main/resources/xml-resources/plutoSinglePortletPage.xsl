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
   This stylesheet generates a valid page configuration file for pluto by
   transforming the portlet.xml file. The servlet context is provided through
   a parameter. The page name is set to the portlet name, which is also a
   test case name.
   
   It places each portlet from the portlet application on a separate page.
-->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:pa="http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd">
  <xsl:strip-space elements="pa:portlet-app"/>
  <xsl:output method="xml" indent="yes"/>
  <xsl:param name="portlet-app-context"/>
  <xsl:template match="/">
  <pluto-portal-driver
    xmlns="http://portals.apache.org/pluto/xsd/pluto-portal-driver-config.xsd"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://portals.apache.org/pluto/xsd/pluto-portal-driver-config.xsd
                        http://portals.apache.org/pluto/pluto-portal/1.1/pluto-portal-driver-config.xsd"
    version="1.1">


    <portal-name>pluto-portal-driver</portal-name>
    <portal-version>3.0-SNAPSHOT</portal-version>
    <container-name>Pluto Portal Driver</container-name>

    <supports>
      <portlet-mode>view</portlet-mode>
      <portlet-mode>edit</portlet-mode>
      <portlet-mode>help</portlet-mode>
      <portlet-mode>config</portlet-mode>

      <window-state>normal</window-state>
      <window-state>maximized</window-state>
      <window-state>minimized</window-state>
    </supports>
    <xsl:element name="render-config">
      <xsl:attribute name="default">About Apache Pluto</xsl:attribute>
    <page name="About Apache Pluto" uri="/WEB-INF/themes/pluto-default-theme.jsp">
      <portlet context="/pluto" name="AboutPortlet"/>
    </page>
      <xsl:apply-templates/>
    </xsl:element>
    </pluto-portal-driver>
  </xsl:template>

  <xsl:template match="pa:portlet-app/pa:portlet">
      <xsl:element name="page">
        <xsl:attribute name="name"><xsl:value-of select="pa:portlet-name"/></xsl:attribute>
        <xsl:attribute name="uri">/WEB-INF/themes/pluto-default-theme.jsp</xsl:attribute>
          <xsl:element name="portlet">
            <xsl:attribute name="context">/<xsl:value-of select='$portlet-app-context'/></xsl:attribute>
            <xsl:attribute name="name"><xsl:value-of select="pa:portlet-name"/></xsl:attribute>
          </xsl:element>
      </xsl:element>    
  </xsl:template>
  
  <!-- ignore all other children of pa:portlet-app -->
  <xsl:template match="pa:portlet-app/*[not(pa:portlet-name)]"/>

</xsl:stylesheet>
