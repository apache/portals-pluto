@echo off

rem
rem  Copyright 2004 The Apache Software Foundation.
rem  
rem  Licensed under the Apache License, Version 2.0 (the "License");
rem  you may not use this file except in compliance with the License.
rem  You may obtain a copy of the License at
rem  
rem       http://www.apache.org/licenses/LICENSE-2.0
rem  
rem  Unless required by applicable law or agreed to in writing, software
rem  distributed under the License is distributed on an "AS IS" BASIS,
rem  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
rem  See the License for the specific language governing permissions and
rem  limitations under the License.
rem

set JAVA_CMD=java
set CLASSPATH=../lib/pluto-deploy-1.1.jar;
set CLASSPATH=%CLASSPATH%../lib/pluto-binding-1.1.jar;
set CLASSPATH=%CLASSPATH%../lib/commons-cli-1.0.jar;
set CLASSPATH=%CLASSPATH%../lib/commons-digester-1.6.jar;
set CLASSPATH=%CLASSPATH%../lib/commons-beanutils-1.7.0.jar;
set CLASSPATH=%CLASSPATH%../lib/commons-logging-1.0.4.jar;

java -classpath %CLASSPATH%  org.apache.pluto.deploy.cli.AssemblerCLI %1
