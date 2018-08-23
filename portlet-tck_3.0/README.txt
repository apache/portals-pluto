
This project contains the JSR 362 Portlet Specification 3.0 TCK.

Overview:
=========

The TCK contains portlets and a test driver that are used to perform the
compatibility test. The portlets contain the code that actually exercises the
portlet API. The driver uses Selenium 2 driven by Junit to access the system
under test through a selenium webdriver browser.

You can click through the tests on the portal pages displayed by the system under
test, or you can use the test driver to automatically click through the tests
and collect the results. Since there are many test cases (>6000), you will 
generally use the test driver.

A test portlet may define multiple test cases. The test case names must be 
unique in the system, and must be of a form that can be used as portlet names 
and as Java Properties file keys.

Each portlet test module defines its own test case list and page file containing
the page definitions expected by the tests contained in the module.  

The build process generates a consolidated test case list and consolidated page 
file containing all test cases and page definitions for all test modules. The 
consolidated test case list maps the test case to the name of the page on which 
the test case is located.

The test driver works by reading the consolidated test case list. For each test
case, the driver accesses the specified page. It logs in if necessary, clicks
any available test case link, and collects the test case results from the
browser window.

The test driver accesses a TCK page by looking for and clicking a link whose
link text is equal to the page name. If the test driver cannot find the link on 
current page, it will access the test server login URL configured in the
portlet-tck_3.0/POM.xml file.

The test driver checks whether a login is necessary by checking for the
existence of an entry field that has the HTML element ID for the user name
field. If the user name field is available, the driver enters the user name and
password into the corresponding entry fields and submits the form. The username
HTML element ID, password element ID, username and password are configurable
in the portlet-tck_3.0/POM.xml file.

The driver checks for links to be clicked and results to be collected by
checking for specific HTML element IDs on the page. The HTML element IDs are
based on the test case name. From the point of view of the test driver there can
be several relevant element IDs on the page for each test case:

"<testcasename>-setup"        - Test setup link      
"<testcasename>-clickme"      - Test execution link
"<testcasename>-results"      - Test results field; "Succeeded" or "Failed"
"<testcasename>-details"      - Test details field; provides failure reason

After accessing the page on which the test case is to be found, the test driver
first looks for a setup link. If found, it clicks the link and waits for the
page to load.

The driver then looks for a test execution link. If found, 
it clicks the link, waits for the new page to load, and then checks for the
result elements.

The driver reads the contents of the HTML elements that have the results &
details element IDs and analyzes the results string to determine test case
success or failure.

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
TestModule3 - Defines two portlets in separate portlet applications for public 
              render parameter testing. Both portlets are placed on the same
              page. When the test driver clicks a test link in one portlet, the
              test results are displayed in the second portlet.
V2*Tests    - Modules with this naming scheme contain test cases to demostrate 
              backward compatibilty with the Portlet Specification version 2.0.
              Portlets whose class names contain the string "_SIG_" contain 
              generated code for verifying the method signatures. These portlets
              should not be changed by hand. The remaining portlets contain
              additional V2 verification code.
V3*Tests    - Modules with this naming scheme test v3.0 specific funtionality.

The Page File:
==============

The page file defines the page names for the TCK and the portlets expected to
be on each page. This is an XML file in the form of a Pluto driver configuration
file. The schema for this file is located in the Pluto project at the following
location:

./pluto-portal-driver/src/main/resources/pluto-portal-driver-config.xsd

After the TCK has been built, complete page file for the TCK pages is contained
in the following file:

./pluto/portlet-tck_3.0/deploy/target/deploy-files/pluto-portal-driver-config.xml

It is expected that vendors will extract the portlet to page mapping information
from the page file in order to create the necessary configuration files for
the portal under test.

When creating pages for your system, note that the test driver expects links to
all test case pages to be available. The test driver searches for the page links
by link text, so it is important that the links have the names defined in the
page file.

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

These commands can be executed either from the Pluto project base directory or
from the ./portlet-tck_3.0 directory.

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

At the time of this writing, the HTMLUnit driver does not support JavaScript 
adequately for JSR 362 TCK purposes. You may need to try different drivers to
find the appropriate WebDriver driver for your environment.

All TCK tests were successfully executed through the test driver against Pluto
using the ChromeDriver web driver. See the portlet-tck_3.0/POM.xml file for
a configuration example.

Run the TCK by switching to the driver subdirectory and execute the command:

mvn test -Prun-tck

If you want to run a subset of the tests, use the "-Dtest.module=" option. The
driver will then only execute those tests whose test case name contains the 
specified string. For example, if you want to run the signature verification
tests, use the command:

mvn test -Prun-tck -Dtest.module=SIG

You can also exclude specific tests by placing an exclamation point before the
text to be matched. For example, if you want to exclude the signature verification
tests, use the command:

mvn test -Prun-tck -Dtest.module=!SIG

The 'test.dryrun' flag will cause the test cases to be listed without executing them.
For example, the following command will list all of the test cases whose test
case name contains 'ResourceResponse', but will not execute them:

mvn test -Prun-tck -Dtest.module=ResourceResponse -Dtest.dryrun=true

The test driver will wait for a response for a default time of 3 seconds. If this
value proves to be too short, you can change it in the portlet-tck_3.0/POM.xml
file, or you can specify a timeout value using the 'test-timeout' command line
option. The timeout value is specified in seconds, as follows:

mvn test -Prun-tck -Dtest.module=ResourceResponse -Dtest.timeout=5

The test driver has an ignore list containing test case names that are not
required to pass in order for a portal product to be JSR 362 compliant. The 
ignore list is an XML file in properties file format located at:

portlet-tck_3.0/driver/src/main/resources/xml-resources/ignoredTestCases.xml

By default, the test driver will ignore and will not execute all test cases 
in the ignore list. If you wish to execute all test cases including those in
the ignore list, set the command line flag 'test.ignore' to false:

mvn test -Prun-tck -Dtest.ignore=false

Under certain circumstances such as a very fast CPU or a large display size,
Selenium throws a WebDriverException claiming that a button or link  is not
clickable. If this happens, the window scrolling workarond can be enabled:

mvn test -Prun-tck -Dtest.scroll=true

Passing the TCK:
================

TCK execution is self-policing. If you are a portal vendor and wish to claim
JSR 362 compatibility for your product, you should be able to demonstrate that 
this TCK can be executed against your product with no errors.

Contesting a Test Case:
=======================

When defining and implementing the TCK test cases, care was taken to assure 
proper implementation and to test only required functionality.

However, mistakes may have occurred. If you feel that a test case is incorrectly
implemented or is invalid as defined, please proceed as follows.

In either case, please open an issue at the Pluto Jira:

https://issues.apache.org/jira/browse/PLUTO/

Prefix the summary with 'TCK:' in order to allow TCK issues to be readily
identified. Please be sure to specify the exact name(s) of the test case(s) in
question.

If you feel that the test case was implemented incorrectly, you may correct the
implementation and issue a pull request through github here:

https://github.com/apache/portals-pluto/pulls

If you feel that the test case is invalid as defined, you may update the ignore
list and issue a pull request.

If we agree that the test case is invalid or incorrectly implemented, we will 
fix it or integrate your fix into the Pluto master and version 3.0 branches.

