(ns saxon.ext
  ;; http://en.wikipedia.org/wiki/Java_API_for_XML_Processing#XSLT_interface
  ;; /* file src/examples/xslt/XsltDemo.java */
  ;; package examples.xslt;
  (:import [java.io StringReader StringWriter]
           [javax.xml.transform Transformer TransformerException
            TransformerFactory
            TransformerFactoryConfigurationError]
           [javax.xml.transform.stream StreamSource StreamResult])
  (:use [clojure.string :only [join split]]
        [clojure.java.io :as io]
        [clojure.tools.logging :as log :only (info error)]))

(gen-class
; :name Foo
 :main false
 :prefix sax
;; :impl-ns Foo
 :methods [[^{:static true}
            foo
            [int]
            void]
           [^{:static true}
            bar
            []
            void]])

(defn saxfoo [n] (log/info "foo" n)) ;; (do (prn("foobar")) "x"))
(defn saxbar [] (do (log/info "bar") "foobar"))
