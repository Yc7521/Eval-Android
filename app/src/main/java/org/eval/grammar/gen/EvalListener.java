// Generated from E:/Android/Eval/app/src/main\Eval.g4 by ANTLR 4.9.2
package org.eval.grammar.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EvalParser}.
 */
public interface EvalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(EvalParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(EvalParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(EvalParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(EvalParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(EvalParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(EvalParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Num}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNum(EvalParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Num}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNum(EvalParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(EvalParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link EvalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(EvalParser.IntContext ctx);
}