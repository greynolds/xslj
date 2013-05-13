(ns xalan.ext-test
  (:require [clojure.test :refer :all]
;            [xslj.core :refer :all]
            [xalan.ext :refer :all])
  ;; http://en.wikipedia.org/wiki/Java_API_for_XML_Processing#XSLT_interface
  ;; /* file src/examples/xslt/XsltDemo.java */
  ;; package examples.xslt;
  (:import [java.io StringReader StringWriter]
           [javax.xml.transform Transformer TransformerException
            TransformerFactory
            TransformerFactoryConfigurationError]
           [javax.xml.transform.stream StreamSource StreamResult]
           [org.apache.xalan.extensions ExpressionContext])
  (:use clojure.test
        [clojure.tools.logging :as log :only (info error)]
        [clojure.string :only [join split]]
        ;; [clojure.java.io :as io]
        ))

(defn- fixture
  [test-fn]
  (test-fn))

(use-fixtures :once fixture)

;;        "xmlns:java='http://xml.apache.org/xalan/java'"
(def xsltResource
  (join "\n"
        ["<?xml version='1.0' encoding='UTF-8'?>"
        "<xsl:stylesheet version='2.0'"
        "xmlns:xj='xalan://xalan.ext'"
        "xmlns:fib='xalan://fib.FibonacciNumber'"
        "xmlns:xsl='http://www.w3.org/1999/XSL/Transform'"
        "exclude-result-prefixes='xj'>"
        "   <xsl:output method='xml' indent='no'/>"
        "   <xsl:template match='/'>"
        "      <reRoot><reNode>"
        "<xsl:value-of select='/root/node/@val' /> world"
        "<xsl:value-of select='fib:calculate(7)'/>"
        "<xsl:value-of select='xj:xalbar(3)'/>"
        "</reNode></reRoot>"
        "   </xsl:template>"
        "</xsl:stylesheet>"]))

(def xmlSourceResource (join "\n"
                             ["<?xml version='1.0' encoding='UTF-8'?>"
                             "<root><node val='hello'/></root>"]))

(deftest ^:init init
  (testing "xalan init"
    (xalfoo 3)
    (xalbar)
    (def xmlResultResource (StringWriter.))
    (def xmlTransformerFactory (TransformerFactory/newInstance))
    (prn (str "Transformer factory: "
              (.getName (.getClass xmlTransformerFactory))))
    ;; (prn (str "Transformer: "
    ;;           (System/getProperty "javax.xml.transform.TransformerFactory")))
    (def xmlTransformer (.newTransformer xmlTransformerFactory
                                         (StreamSource.
                                          (StringReader.
                                           xsltResource))))
    (.transform xmlTransformer
                (StreamSource. (StringReader. xmlSourceResource))
                (StreamResult. xmlResultResource))
    (prn (str xmlResultResource))))
