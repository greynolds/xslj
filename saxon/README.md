# saxon

A simple example of using clojure to implement xslt extension
functions, using saxon.

src/main/java contains an extension function implemented in java.
This is just to establish that the extension functionality is working.

src/saxon contains extension functions implemented in clojure.

test/saxon/ext_test.clj contains code to test the extension functions
using JAXP to process a simple xml file and xslt stylesheet.

## Usage

  $ lein compile
  $ lein test

## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
