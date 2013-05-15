(ns xalan.ext
  ;; http://en.wikipedia.org/wiki/Java_API_for_XML_Processing#XSLT_interface
  ;; /* file src/examples/xslt/XsltDemo.java */
  ;; package examples.xslt;
  (:import [java.io StringReader StringWriter]
           [javax.xml.transform Transformer TransformerException
            TransformerFactory
            TransformerFactoryConfigurationError]
           [javax.xml.transform.stream StreamSource StreamResult])
;           [org.apache.xalan.extensions ExpressionContext])
  (:use [clojure.string :only [join split]]
        [clojure.java.io :as io]
        [clojure.tools.logging :as log :only (info error)]))

(gen-class
 :name xalan.ext
 :main false
 :prefix xal
 :impl-ns xalan.ext
 :methods [[^{:static true}
            foo
            ;; [Object, org.apache.xalan.extensions.ExpressionContext, Integer]
            [int]
            ;; [Object, Integer]
            void]
           [^{:static true}
            bar
            []
            ;; [Object, Integer]
            void]])

;;(prn (System/getProperty "javax.xml.transform.TransformerFactory"))

(defn xalfoo [n] (log/info "foo" n)) ;; (do (prn("foobar")) "x"))
(defn xalbar [] (do (log/info "bar") "foobar"))
