#!/bin/sh

# http://www.saxonica.com/documentation9.1/using-xsl/commandline.html

# to get the classpath do  $ lein classpath > cp.log and copy from there

java -cp /Users/gar/clj/xslj/saxon/test:/Users/gar/clj/xslj/saxon/src:/Users/gar/clj/xslj/saxon/dev-resources:/Users/gar/clj/xslj/saxon/resources:/Users/gar/clj/xslj/saxon/target/classes:/Users/gar/.m2/repository/net/sourceforge/saxon/saxon/9.1.0.8/saxon-9.1.0.8.jar:/Users/gar/.m2/repository/org/clojure/tools.logging/0.2.6/tools.logging-0.2.6.jar:/Users/gar/.m2/repository/org/clojure/clojure/1.5.1/clojure-1.5.1.jar net.sf.saxon.Transform -s:../test.xml -xsl:test.xsl
