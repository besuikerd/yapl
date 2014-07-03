// Generated from YAPL.g4 by ANTLR 4.2.2
package yapl.syntax;

	import yapl.typing.Type;
	import yapl.context.IdEntry;

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
	 * Visit a parse tree produced by {@link YAPLParser#opPlusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpPlusMinus(@NotNull YAPLParser.OpPlusMinusContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#plusMinusExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinusExpr(@NotNull YAPLParser.PlusMinusExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#opIfThenElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpIfThenElse(@NotNull YAPLParser.OpIfThenElseContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#opCompare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpCompare(@NotNull YAPLParser.OpCompareContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#opMultDivMod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpMultDivMod(@NotNull YAPLParser.OpMultDivModContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#opNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpNumber(@NotNull YAPLParser.OpNumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull YAPLParser.NumberContext ctx);

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
	 * Visit a parse tree produced by {@link YAPLParser#opExprBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExprBlock(@NotNull YAPLParser.OpExprBlockContext ctx);

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
	 * Visit a parse tree produced by {@link YAPLParser#compareExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(@NotNull YAPLParser.CompareExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull YAPLParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#statementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementDeclaration(@NotNull YAPLParser.StatementDeclarationContext ctx);

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
	 * Visit a parse tree produced by {@link YAPLParser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(@NotNull YAPLParser.StatementExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull YAPLParser.OrExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#opParenExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpParenExpr(@NotNull YAPLParser.OpParenExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#declVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclVar(@NotNull YAPLParser.DeclVarContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#opTrue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpTrue(@NotNull YAPLParser.OpTrueContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#opFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpFalse(@NotNull YAPLParser.OpFalseContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#yapl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYapl(@NotNull YAPLParser.YaplContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#opWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpWhile(@NotNull YAPLParser.OpWhileContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull YAPLParser.AndExprContext ctx);
}