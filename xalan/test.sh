#!/bin/sh

# to get the classpath do  $ lein classpath > cp.log and copy from there

java -cp /Users/gar/clj/xslj/xalan/test:/Users/gar/clj/xslj/xalan/src:/Users/gar/clj/xslj/xalan/dev-resources:/Users/gar/clj/xslj/xalan/resources:/Users/gar/clj/xslj/xalan/target/classes:/Users/gar/.m2/repository/xml-apis/xml-apis/1.3.04/xml-apis-1.3.04.jar:/Users/gar/.m2/repository/xalan/serializer/2.7.1/serializer-2.7.1.jar:/Users/gar/.m2/repository/xalan/xalan/2.7.1/xalan-2.7.1.jar:/Users/gar/.m2/repository/org/clojure/tools.logging/0.2.6/tools.logging-0.2.6.jar:/Users/gar/.m2/repository/org/clojure/clojure/1.5.1/clojure-1.5.1.jar org.apache.xalan.xslt.Process -IN ../test.xml -XSL test.xsl
