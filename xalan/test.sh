#!/bin/sh

# to get <CLASSPATH> do  $ lein classpath > cp.log and copy from there

java -cp <CLASSPATH> org.apache.xalan.xslt.Process -IN ../test.xml -XSL test.xsl
