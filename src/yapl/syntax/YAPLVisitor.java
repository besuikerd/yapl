// Generated from YAPL.g4 by ANTLR 4.2.2
package yapl.syntax;
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
	 * Visit a parse tree produced by {@link YAPLParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(@NotNull YAPLParser.RetContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull YAPLParser.ExpressionContext ctx);

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
	 * Visit a parse tree produced by {@link YAPLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull YAPLParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull YAPLParser.DeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull YAPLParser.NumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link YAPLParser#exprconstruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprconstruct(@NotNull YAPLParser.ExprconstructContext ctx);

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
	 * Visit a parse tree produced by {@link YAPLParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(@NotNull YAPLParser.OperandContext ctx);

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