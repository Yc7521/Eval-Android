package org.eval.util

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.eval.grammar.EvalVisitor
import org.eval.grammar.gen.EvalLexer
import org.eval.grammar.gen.EvalParser

object Util {
    fun eval(expr: String): Double {
        // 对每一个输入的字符串，构造一个 CodePointCharStream
        val cs = CharStreams.fromString(expr)
        // 用 cs 构造词法分析器 lexer，词法分析的作用是产生记号
        val lexer = EvalLexer(cs)
        // 用词法分析器 lexer 构造一个记号流 tokens
        val tokens = CommonTokenStream(lexer)
        // 再使用 tokens 构造语法分析器 parser,至此已经完成词法分析和语法分析的准备工作
        val parser = EvalParser(tokens)
        // 最终调用语法分析器的规则 expr，完成对表达式的验证
        val context = parser.expr()
        // 通过访问者模式，执行我们的程序
        return EvalVisitor().visit(context)!!
    }
}