// Generated from E:/Android/Eval/app/src/main\Eval.g4 by ANTLR 4.9.2
package org.eval.grammar.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EvalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EvalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(EvalParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(EvalParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(EvalParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Num}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(EvalParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(EvalParser.IntContext ctx);
}