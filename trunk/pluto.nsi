; Pluto script for Nullsoft Installer
; $Id: pluto.nsi,v 1 2005/07/28 14:17:51 ddewolf Exp $

  ;Compression options
  CRCCheck on
  SetCompress force
  SetCompressor lzma
  SetDatablockOptimize on

  Name "Apache Pluto"
  OutFile "portals-pluto.exe"   ; The name of the unistaller file to write

  ;Product information
  VIAddVersionKey ProductName "Apache Pluto"
  VIAddVersionKey CompanyName "Apache Software Foundation"
  VIAddVersionKey LegalCopyright "Copyright (c) 1999-2005 The Apache Software Foundation"
  VIAddVersionKey FileDescription "Apache Pluto Installer"
  VIAddVersionKey FileVersion "2.0"
  VIAddVersionKey ProductVersion "1.1.0"
  VIAddVersionKey Comments "portals.apache.org/pluto"
  VIAddVersionKey InternalName "portals-pluto-1.1.0.exe"
  VIProductVersion 1.1.0.0

!include "MUI.nsh"

;---------------------------------
;Installer Look and Feel Config
;  !define MUI_HEADERIMAGE
;  !define MUI_HEADERIMAGE_RIGHT
;  !define MUI_HEADERIMAGE_BITMAP header.bmp
;  !define MUI_WELCOMEFINISHPAGE_BITMAP side_left.bmp 
;  !define MUI_FINISHPAGE_SHOWREADME "$INSTDIR\README"
;  !define MUI_FINISHPAGE_RUN $INSTDIR\bin\startup.bat
;
;  !define MUI_ABORTWARNING
;
;  ;Install Page order
;  !insertmacro MUI_PAGE_WELCOME
;  !insertmacro MUI_PAGE_LICENSE README
;  !insertmacro MUI_PAGE_COMPONENTS
;  !insertmacro MUI_PAGE_DIRECTORY
;  !insertmacro MUI_PAGE_INSTFILES
;  !insertmacro MUI_PAGE_FINISH
;
;  LicenseData README
 
; Set prompt text for select components window and select directory window
ComponentText "Select Pluto components to install."
DirText       "Select the Tomcat installation directory."
 
; --------- Install the Portlet Container
Section "Pluto Portlet Container (required)"
 
  SetOutPath $INSTDIR\shared\lib ; Tomcat Shared Libaries
  File pluto-descriptor-api\target\pluto-descriptor-api-1.1-SNAPSHOT.jar
  File pluto-descriptor-impl\target\pluto-descriptor-impl-1.1-SNAPSHOT.jar
  File pluto-container\target\pluto-container-1.1-SNAPSHOT.jar
  ;File castor-0.9.6.jar
  ;File portlet-api-1.0.jar

  SetOutPath $INSTDIR\common\endorsed 
  ;File xercesImpl-2.6.2.jar
  ;File xml-apis-1.0.b2.jar
  ;File xmlParserAPIs-2.6.2.jar
 
SectionEnd

; --------- Install the Portal ----------
Section "Pluto Portal Driver"
 
  SetOutPath $INSTDIR\webapps 
  File "pluto-portal\target\pluto-portal.war" 
  ;File "\oname=pluto-portal.war" "pluto-portal\target\pluto-portal.war" 

  SetOutPath $INSTDIR\conf\Catalina\localhost 
  File "pluto-portal\src\main\resources\pluto.xml"
 
SectionEnd

; --------- Install the Deployer ----------
Section "Pluto Portal Driver"
 
    ; Execute the Deployer Installer!
 
SectionEnd

; --------- Install the TestSuite ----------
Section "Pluto TestSuite"
 
  SetOutPath $INSTDIR\webapps 
  File "pluto-testsuite\target\pluto-testsuite.war" 

  SetOutPath $INSTDIR\conf\Catalina\localhost 
  File "pluto-testsuite\src\main\resources\testsuite.xml"

SectionEnd

; ---------- Functions ---------
  Function .onVerifyInstDir
    IfFileExists $INSTDIR\bin\tomcat5.exe PathGood
      Abort ; if $INSTDIR is not a winamp directory, don't let us install there
    PathGood:
  FunctionEnd
 
; eof 
 

