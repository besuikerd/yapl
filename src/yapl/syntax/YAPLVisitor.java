// Generated from YAPL.g4 by ANTLR 4.2.2
package yapl.syntax;

	import yapl.typing.Type;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link YAPLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface YAPLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link YAPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull YAPLParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#opIdOrFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpIdOrFunc(@NotNull YAPLParser.OpIdOrFuncContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#typeDenoter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDenoter(@NotNull YAPLParser.TypeDenoterContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#plusMinusExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinusExpr(@NotNull YAPLParser.PlusMinusExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull YAPLParser.OrExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#opNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpNumber(@NotNull YAPLParser.OpNumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#opParenExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpParenExpr(@NotNull YAPLParser.OpParenExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#exprOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(@NotNull YAPLParser.ExprOrContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull YAPLParser.NumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#declVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclVar(@NotNull YAPLParser.DeclVarContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#declConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclConst(@NotNull YAPLParser.DeclConstContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(@NotNull YAPLParser.PrimaryExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull YAPLParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#multDivModExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivModExpr(@NotNull YAPLParser.MultDivModExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull YAPLParser.IdContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#yapl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYapl(@NotNull YAPLParser.YaplContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#exprBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBlock(@NotNull YAPLParser.ExprBlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#compareExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(@NotNull YAPLParser.CompareExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull YAPLParser.AndExprContext ctx);
}