#!/bin/bash
ANT_HOME=`pwd`/ant
$ANT_HOME/bin/ant -Dbuild.compiler.emacs=true -emacs $@
