package org.eval.grammar

import org.eval.grammar.gen.EvalBaseVisitor
import org.eval.grammar.gen.EvalParser.*

class EvalVisitor : EvalBaseVisitor<Double>() {
    override fun visitNum(ctx: NumContext): Double = ctx.text.toDouble()

    override fun visitInt(ctx: IntContext): Double = ctx.text.toDouble()

    override fun visitMulDiv(ctx: MulDivContext): Double {
        val param1 = ctx.expr(0).accept(this)!!
        val param2 = ctx.expr(1).accept(this)!!
        return if (ctx.op.type == MUL) param1 * param2 else param1 / param2
    }

    override fun visitAddSub(ctx: AddSubContext): Double {
        val param1 = ctx.expr(0).accept(this)!!
        val param2 = ctx.expr(1).accept(this)!!
        return if (ctx.op.type == ADD) param1 + param2 else param1 - param2
    }

    override fun visitParens(ctx: ParensContext): Double {
        return ctx.expr().accept(this)!!
    }
}