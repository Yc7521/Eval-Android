package org.eval.grammar

import org.eval.grammar.gen.EvalBaseVisitor
import org.eval.grammar.gen.EvalParser.*
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

class EvalVisitor : EvalBaseVisitor<BigDecimal>() {
    private val mathContext = MathContext(30, RoundingMode.HALF_EVEN)

    override fun visitNum(ctx: NumContext): BigDecimal =
        ctx.text.toBigDecimal(mathContext)

    override fun visitInt(ctx: IntContext): BigDecimal =
        ctx.text.toBigDecimal(mathContext)

    override fun visitMulDiv(ctx: MulDivContext): BigDecimal {
        val param1 = ctx.expr(0).accept(this)!!
        val param2 = ctx.expr(1).accept(this)!!
        return with(
            if (ctx.op.type == MUL) param1 * param2 else param1.divide(
                param2,
                mathContext.precision,
                mathContext.roundingMode
            )
        ) {
            // remove trailing zeros
            if (remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
                toBigInteger().toBigDecimal()
            } else {
                this
            }
        }
    }

    override fun visitAddSub(ctx: AddSubContext): BigDecimal {
        val param1 = ctx.expr(0).accept(this)!!
        val param2 = ctx.expr(1).accept(this)!!
        return if (ctx.op.type == ADD) param1 + param2 else param1 - param2
    }

    override fun visitParens(ctx: ParensContext): BigDecimal {
        return ctx.expr().accept(this)!!
    }
}