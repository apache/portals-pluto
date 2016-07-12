
This project contains the JSR 362 Portlet Specification 3.0 TCK.

This is currently a work in progress. Some (many) test cases remain to be 
developed. 

Overview:
=========

The TCK contains portlets and a test driver that are used to perform the
compatibility test. The portlets contain the code that actually exercises the
portlet API. The driver uses Selenium 2 driven by Junit to access the system
under test through a browser.

Each portlet test module defines its own test case list and page file containing
the page definitions expected by the tests contained in the module.  

Depending on how the module is configured, the test case list and page file can be
automatically generated from the portlet.xml file with additional tests defined 
in a separate file (TestModule1), can have the test case list generated manually
while automatically generating the page file (TestModule2), or can have both the
test list and the page file generated manually (TestModule3).

A test portlet may define multiple test cases. The test case names must be 
unique in the system, and must be of a form that can be used as portlet names 
and as Java Properties file keys.

The build process generates a consolidated test case list and consolidated page 
file containing all test cases and page definitions for all test modules. 

The test driver works by reading the consolidated test case list. For each test
case, the driver accesses the specified page. It logs in if necessary, clicks
any available test case link, and collects the test case results from the
browser window.

The test driver checks whether a login is necessary by checking for the
existence of an entry field that has the HTML element ID for the user naem
field. If the user name field is available, the driver enters the user name and
password into the corresponding entry fields and submits the form. The username
HTML element ID, password element ID, username and password ar configurable
through the parent POM file.

The driver checks for links to be clicked and results by checking for specific
HTML element IDs on the page. The clickable link ID has the form
"<testcasename>-clickme", the result field ID has the form "<testcasename>-results"
and the details message has the form "<testcasename>-details".

If the driver finds a link associated with the test case is found on the page, 
it clicks the link, waits for the new page to load, and then checks for the
result elements.

The driver reads the contents of the HTML elements that have the results &
details element IDs and analyzes the results string to determine test case
success or failure.

Note that the tests contained in the current test modules are not "real" TCK
tests. They are merely some tests that allow test framework functionality to be
demonstrated.

Project Structure:
==================

The project consists of the following modules:

common      - Common code used by the test portlets and the test driver. This
              module also contains the XSL stylesheets used during the test
              portlet module build to generate the test case list and page
              configuration for the module.   
deploy      - The directory deploy/target/deploy-files contains the portlet war
              files and the page file to be deployed on the system under test.
driver      - The maven-based test driver. When this module is built, it
              generates a conslidated test case list and page file for the test
              cases and pages defined by all test case portlet modules.
TestModule1 - Defines several portlets, each of which is placed on its own page.
TestModule2 - Defines several portlets, all of which are placed on the same
              portal page. Some tests produce links that are clicked by the test
              driver when the test is run. Some tests set public render
              parameters that are used by another test portlet.
TestModule3 - Defines two portlets in separate portlet aplpications for public 
              render parameter testing. Both portlets are placed on the same
              page. When the test driver clicks a test link in one portlet, the
              test results are displayed in the second portlet.
V2XxxTests  - Modules with this naming scheme contain test cases to demostrate 
              backward compatibilty with the Portlet Specification version 2.0.
              Portlets whose class names contain the string "_SIG_" contain 
              generated code for verifying the method signatures. These portlets
              should not be changed by hand. The remaining portlets contain
              additional V2 verification code.


Building the TCK:
=================

Building the TCK produces the test portlets, a list of test cases in XML format,
an XML-based page file containing the page configuration expected by the test
cases, and the test driver itself. Perform the build from the project base
directory.

To build portlet war files that do not contain any special configuration, use
the command:

mvn clean install

To build portlet war files that are configured for deployment on Pluto, use the 
command:

mvn clean install -Ppluto

Deploying TCK artifacts:
========================

Deploy the portlet war files contained in the deploy/target/deploy-files
directory on your system under test. Use the page file which has the default
name of deploy/target/deploy-files/pluto-portal-driver-config.xml to create
pages for your system. If you are testing with Apache Pluto, you can simply copy
this file into the Pluto webapps/pluto/WEB-INF directory in order to set up the
pages. The WAR files contain the test portlet code. Deploy these files on your 
system. To deploy them on Pluto, copy them into the Pluto webapps directory.

Running the TCK:
================

Configure the parent POM file to address your system under test. See properties
section. You can set the host name and port for the system under test, and can
also select the browser to be used by the Selenium WebDriver code. Note,
however, that if you use a browser other than "firefox" or "HTMLUnit" you will
have to download and install additional WebDriver software manually, and you may
need to add additional configuration properties (See the test.browser.webDriver
property in the parent POM).

Run the TCK by switching to the driver subdirectory and execute the command:

mvn test -Prun-tck

If you want to run a subset of the tests, use the "-Dtest.module=" option. The
driver will then only execute those tests whose test case name contains the 
specified string. For example, if you want to run the signature verification
tests, use the command:

mvn test -Prun-tck -Dtest.module=SIG

Creating Test Reports:
======================

tbd
