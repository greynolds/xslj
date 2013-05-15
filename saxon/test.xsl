<?xml version='1.0' encoding='UTF-8'?>
<xsl:stylesheet version='2.0'
		xmlns:xj='java:saxon.ext'
		xmlns:fib='xalan://fib.FibonacciNumber'
		xmlns:xsl='http://www.w3.org/1999/XSL/Transform'
		exclude-result-prefixes='xj fib'>
  <xsl:output method='xml' indent='no'/>
  <xsl:template match='/'>
    <reRoot><reNode>
      <xsl:value-of select='/root/node/@val' /> world
      <fib>
        <xsl:value-of select='fib:calculate(7)'/>
      </fib>
      <foo>
        <xsl:value-of select='xj:saxfoo(7)'/>
      </foo>
      <bar>
        <xsl:value-of select='xj:saxbar()'/>
      </bar>
    </reNode></reRoot>
  </xsl:template>
</xsl:stylesheet>
