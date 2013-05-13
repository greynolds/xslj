(ns saxon.ext-test
  (:require [clojure.test :refer :all]
;            [xslj.core :refer :all]
            [saxon.ext :refer :all])
  ;; http://en.wikipedia.org/wiki/Java_API_for_XML_Processing#XSLT_interface
  ;; /* file src/examples/xslt/XsltDemo.java */
  ;; package examples.xslt;
  (:import [java.io StringReader StringWriter]
           [javax.xml.transform Transformer TransformerException
            TransformerFactory
            TransformerFactoryConfigurationError]
           [javax.xml.transform.stream StreamSource StreamResult]
           [net.sf.saxon FeatureKeys])
  ;;          [org.apache.xalan.extensions ExpressionContext])
  (:use clojure.test
        [clojure.tools.logging :as log :only (info error)]
        [clojure.string :only [join split]]
        ;; [clojure.java.io :as io]
        ))

(defn- fixture
  [test-fn]
  (test-fn))

(use-fixtures :once fixture)

(def xsltResource
  (join "\n"
        ["<?xml version='1.0' encoding='UTF-8'?>"
        "<xsl:stylesheet version='2.0'"
        "xmlns:xj='saxon.ext'"
        "xmlns:xsl='http://www.w3.org/1999/XSL/Transform'"
        "exclude-result-prefixes='xj'>"
        "   <xsl:output method='xml' indent='no'/>"
        "   <xsl:template match='/'>"
        "      <reRoot><reNode>"
        "<xsl:value-of select='/root/node/@val' /> world"
        "<xsl:value-of select='xj:saxfoo(7)' />"
        "</reNode></reRoot>"
        "   </xsl:template>"
        "</xsl:stylesheet>"]))
;; String xmlSourceResource =
(def xmlSourceResource (join "\n"
                             ["<?xml version='1.0' encoding='UTF-8'?>"
                             "<root><node val='hello'/></root>"]))

(deftest ^:init init
  (testing "saxon init"
    (saxfoo 3)
    (saxbar)
    (def xmlResultResource (StringWriter.))
    (def xmlTransformerFactory (net.sf.saxon.TransformerFactoryImpl.))
    (prn (str "Transformer factory: "
              (.getName (.getClass xmlTransformerFactory))))
;; from https://bugs.launchpad.net/ubuntu/+source/saxonb/+bug/412517:
;; "If you are using SaxonB from its Java API you should set the Attribute
;; 'FeatureKeys.ALLOW_EXTERNAL_FUNCTIONS' to 'true'. See the API
;; reference in the libsaxonb-java-doc package for more information."

;; See http://www.saxonica.com/documentation9.0/javadoc/net/sf/saxon/FeatureKeys.html
    ;; (.setAttribute xmlTransformerFactory
    ;;                FeatureKeys/ALLOW_EXTERNAL_FUNCTIONS
    ;;                true)
    (prn (str "Allow external functions? "
              (.getAttribute xmlTransformerFactory
                             FeatureKeys/ALLOW_EXTERNAL_FUNCTIONS)))
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
