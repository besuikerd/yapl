// Generated from YAPL.g4 by ANTLR 4.2.2
package yapl.syntax;

	import yapl.typing.Type;
	import yapl.context.IdEntry;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class YAPLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMICOLON=1, COLON=2, EQ=3, LCURLY=4, RCURLY=5, LPAREN=6, RPAREN=7, AT=8, 
		COMMA=9, LOR=10, LAND=11, LEQ=12, LNEQ=13, LNOT=14, GT=15, GTE=16, LT=17, 
		LTE=18, PLUS=19, MINUS=20, MULT=21, DIV=22, MOD=23, VAR=24, CONST=25, 
		RETURN=26, IF=27, THEN=28, ELSE=29, WHILE=30, DO=31, END=32, TRUE=33, 
		FALSE=34, IDENTIFIER=35, NUMBER=36, COMMENT=37, WS=38;
	public static final String[] tokenNames = {
		"<INVALID>", "';'", "':'", "'='", "'{'", "'}'", "'('", "')'", "'@'", "','", 
		"'||'", "'&&'", "'=='", "'!='", "'!'", "'>'", "'>='", "'<'", "'<='", "'+'", 
		"'-'", "'*'", "'/'", "'%'", "'var'", "'const'", "'return'", "'if'", "'then'", 
		"'else'", "'while'", "'do'", "'end'", "'true'", "'false'", "IDENTIFIER", 
		"NUMBER", "COMMENT", "WS"
	};
	public static final int
		RULE_yapl = 0, RULE_statement = 1, RULE_declaration = 2, RULE_expression = 3, 
		RULE_operand = 4, RULE_primaryExpr = 5, RULE_multDivModExpr = 6, RULE_opMultDivMod = 7, 
		RULE_plusMinusExpr = 8, RULE_opPlusMinus = 9, RULE_compareExpr = 10, RULE_opCompare = 11, 
		RULE_andExpr = 12, RULE_orExpr = 13, RULE_id = 14, RULE_number = 15, RULE_typeDenoter = 16;
	public static final String[] ruleNames = {
		"yapl", "statement", "declaration", "expression", "operand", "primaryExpr", 
		"multDivModExpr", "opMultDivMod", "plusMinusExpr", "opPlusMinus", "compareExpr", 
		"opCompare", "andExpr", "orExpr", "id", "number", "typeDenoter"
	};

	@Override
	public String getGrammarFileName() { return "YAPL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public YAPLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class YaplContext extends ParserRuleContext {
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public YaplContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yapl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitYapl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YaplContext yapl() throws RecognitionException {
		YaplContext _localctx = new YaplContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_yapl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << VAR) | (1L << CONST) | (1L << IF) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(34); statement();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatementDeclarationContext extends StatementContext {
		public TerminalNode SEMICOLON() { return getToken(YAPLParser.SEMICOLON, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StatementDeclarationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitStatementDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementExpressionContext extends StatementContext {
		public TerminalNode SEMICOLON() { return getToken(YAPLParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementExpressionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitStatementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(46);
			switch (_input.LA(1)) {
			case VAR:
			case CONST:
				_localctx = new StatementDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(40); declaration();
				setState(41); match(SEMICOLON);
				}
				break;
			case LCURLY:
			case LPAREN:
			case LNOT:
			case PLUS:
			case MINUS:
			case IF:
			case WHILE:
			case TRUE:
			case FALSE:
			case IDENTIFIER:
			case NUMBER:
				_localctx = new StatementExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(43); expression();
				setState(44); match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public IdEntry entry;
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
			this.entry = ctx.entry;
		}
	}
	public static class DeclVarContext extends DeclarationContext {
		public TypeDenoterContext typeDenoter() {
			return getRuleContext(TypeDenoterContext.class,0);
		}
		public TerminalNode VAR() { return getToken(YAPLParser.VAR, 0); }
		public TerminalNode COLON() { return getToken(YAPLParser.COLON, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public DeclVarContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitDeclVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclConstContext extends DeclarationContext {
		public TerminalNode CONST() { return getToken(YAPLParser.CONST, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode EQ() { return getToken(YAPLParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclConstContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitDeclConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			setState(58);
			switch (_input.LA(1)) {
			case VAR:
				_localctx = new DeclVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(48); match(VAR);
				setState(49); id();
				setState(50); match(COLON);
				setState(51); typeDenoter();
				}
				break;
			case CONST:
				_localctx = new DeclConstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(53); match(CONST);
				setState(54); id();
				setState(55); match(EQ);
				setState(56); expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode EQ() { return getToken(YAPLParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); orExpr();
			setState(63);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(61); match(EQ);
				setState(62); expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperandContext extends ParserRuleContext {
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
	 
		public OperandContext() { }
		public void copyFrom(OperandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OpNumberContext extends OperandContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public OpNumberContext(OperandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitOpNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpParenExprContext extends OperandContext {
		public TerminalNode LPAREN() { return getToken(YAPLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(YAPLParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OpParenExprContext(OperandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitOpParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpTrueContext extends OperandContext {
		public TerminalNode TRUE() { return getToken(YAPLParser.TRUE, 0); }
		public OpTrueContext(OperandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitOpTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpExprBlockContext extends OperandContext {
		public TerminalNode SEMICOLON() { return getToken(YAPLParser.SEMICOLON, 0); }
		public TerminalNode RETURN() { return getToken(YAPLParser.RETURN, 0); }
		public TerminalNode RCURLY() { return getToken(YAPLParser.RCURLY, 0); }
		public TerminalNode LCURLY() { return getToken(YAPLParser.LCURLY, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OpExprBlockContext(OperandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitOpExprBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpIdOrFuncContext extends OperandContext {
		public TerminalNode LPAREN() { return getToken(YAPLParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(YAPLParser.COMMA); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(YAPLParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(YAPLParser.COMMA, i);
		}
		public OpIdOrFuncContext(OperandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitOpIdOrFunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpFalseContext extends OperandContext {
		public TerminalNode FALSE() { return getToken(YAPLParser.FALSE, 0); }
		public OpFalseContext(OperandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitOpFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpIfThenElseContext extends OperandContext {
		public TerminalNode ELSE() { return getToken(YAPLParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(YAPLParser.IF, 0); }
		public TerminalNode THEN() { return getToken(YAPLParser.THEN, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode END() { return getToken(YAPLParser.END, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public OpIfThenElseContext(OperandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitOpIfThenElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpWhileContext extends OperandContext {
		public List<TerminalNode> SEMICOLON() { return getTokens(YAPLParser.SEMICOLON); }
		public TerminalNode DO() { return getToken(YAPLParser.DO, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode END() { return getToken(YAPLParser.END, 0); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(YAPLParser.SEMICOLON, i);
		}
		public TerminalNode WHILE() { return getToken(YAPLParser.WHILE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public OpWhileContext(OperandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitOpWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_operand);
		int _la;
		try {
			setState(120);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new OpIdOrFuncContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(65); id();
				setState(78);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(66); match(LPAREN);
					setState(75);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << IF) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
						{
						setState(67); expression();
						setState(72);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(68); match(COMMA);
							setState(69); expression();
							}
							}
							setState(74);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(77); match(RPAREN);
					}
				}

				}
				break;
			case NUMBER:
				_localctx = new OpNumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(80); number();
				}
				break;
			case LPAREN:
				_localctx = new OpParenExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(81); match(LPAREN);
				setState(82); expression();
				setState(83); match(RPAREN);
				}
				break;
			case TRUE:
				_localctx = new OpTrueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(85); match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new OpFalseContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(86); match(FALSE);
				}
				break;
			case IF:
				_localctx = new OpIfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(87); match(IF);
				setState(88); expression();
				setState(89); match(THEN);
				setState(90); expression();
				setState(91); match(ELSE);
				setState(92); expression();
				setState(93); match(END);
				}
				break;
			case LCURLY:
				_localctx = new OpExprBlockContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(95); match(LCURLY);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << VAR) | (1L << CONST) | (1L << IF) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
					{
					{
					setState(96); statement();
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(102); match(RETURN);
				setState(103); expression();
				setState(104); match(SEMICOLON);
				setState(105); match(RCURLY);
				}
				break;
			case WHILE:
				_localctx = new OpWhileContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(107); match(WHILE);
				setState(108); expression();
				setState(109); match(DO);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << IF) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
					{
					{
					setState(110); expression();
					setState(111); match(SEMICOLON);
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(118); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExprContext extends ParserRuleContext {
		public Token op;
		public TerminalNode LNOT() { return getToken(YAPLParser.LNOT, 0); }
		public TerminalNode PLUS() { return getToken(YAPLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(YAPLParser.MINUS, 0); }
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitPrimaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_primaryExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LNOT) | (1L << PLUS) | (1L << MINUS))) != 0)) {
				{
				setState(122);
				((PrimaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LNOT) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
					((PrimaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(125); operand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultDivModExprContext extends ParserRuleContext {
		public List<PrimaryExprContext> primaryExpr() {
			return getRuleContexts(PrimaryExprContext.class);
		}
		public PrimaryExprContext primaryExpr(int i) {
			return getRuleContext(PrimaryExprContext.class,i);
		}
		public OpMultDivModContext opMultDivMod(int i) {
			return getRuleContext(OpMultDivModContext.class,i);
		}
		public List<OpMultDivModContext> opMultDivMod() {
			return getRuleContexts(OpMultDivModContext.class);
		}
		public MultDivModExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multDivModExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitMultDivModExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultDivModExprContext multDivModExpr() throws RecognitionException {
		MultDivModExprContext _localctx = new MultDivModExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_multDivModExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); primaryExpr();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) {
				{
				{
				setState(128); opMultDivMod();
				setState(129); primaryExpr();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpMultDivModContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(YAPLParser.MULT, 0); }
		public TerminalNode MOD() { return getToken(YAPLParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(YAPLParser.DIV, 0); }
		public OpMultDivModContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opMultDivMod; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitOpMultDivMod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpMultDivModContext opMultDivMod() throws RecognitionException {
		OpMultDivModContext _localctx = new OpMultDivModContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_opMultDivMod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlusMinusExprContext extends ParserRuleContext {
		public OpPlusMinusContext opPlusMinus(int i) {
			return getRuleContext(OpPlusMinusContext.class,i);
		}
		public List<MultDivModExprContext> multDivModExpr() {
			return getRuleContexts(MultDivModExprContext.class);
		}
		public MultDivModExprContext multDivModExpr(int i) {
			return getRuleContext(MultDivModExprContext.class,i);
		}
		public List<OpPlusMinusContext> opPlusMinus() {
			return getRuleContexts(OpPlusMinusContext.class);
		}
		public PlusMinusExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusMinusExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitPlusMinusExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusMinusExprContext plusMinusExpr() throws RecognitionException {
		PlusMinusExprContext _localctx = new PlusMinusExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_plusMinusExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); multDivModExpr();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(139); opPlusMinus();
				setState(140); multDivModExpr();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpPlusMinusContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(YAPLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(YAPLParser.MINUS, 0); }
		public OpPlusMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opPlusMinus; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitOpPlusMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpPlusMinusContext opPlusMinus() throws RecognitionException {
		OpPlusMinusContext _localctx = new OpPlusMinusContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_opPlusMinus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompareExprContext extends ParserRuleContext {
		public List<OpCompareContext> opCompare() {
			return getRuleContexts(OpCompareContext.class);
		}
		public PlusMinusExprContext plusMinusExpr(int i) {
			return getRuleContext(PlusMinusExprContext.class,i);
		}
		public List<PlusMinusExprContext> plusMinusExpr() {
			return getRuleContexts(PlusMinusExprContext.class);
		}
		public OpCompareContext opCompare(int i) {
			return getRuleContext(OpCompareContext.class,i);
		}
		public CompareExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitCompareExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareExprContext compareExpr() throws RecognitionException {
		CompareExprContext _localctx = new CompareExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_compareExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149); plusMinusExpr();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEQ) | (1L << LNEQ) | (1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE))) != 0)) {
				{
				{
				setState(150); opCompare();
				setState(151); plusMinusExpr();
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpCompareContext extends ParserRuleContext {
		public TerminalNode LNEQ() { return getToken(YAPLParser.LNEQ, 0); }
		public TerminalNode LEQ() { return getToken(YAPLParser.LEQ, 0); }
		public TerminalNode GTE() { return getToken(YAPLParser.GTE, 0); }
		public TerminalNode LT() { return getToken(YAPLParser.LT, 0); }
		public TerminalNode GT() { return getToken(YAPLParser.GT, 0); }
		public TerminalNode LTE() { return getToken(YAPLParser.LTE, 0); }
		public OpCompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opCompare; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitOpCompare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpCompareContext opCompare() throws RecognitionException {
		OpCompareContext _localctx = new OpCompareContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_opCompare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEQ) | (1L << LNEQ) | (1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExprContext extends ParserRuleContext {
		public TerminalNode LAND(int i) {
			return getToken(YAPLParser.LAND, i);
		}
		public List<CompareExprContext> compareExpr() {
			return getRuleContexts(CompareExprContext.class);
		}
		public List<TerminalNode> LAND() { return getTokens(YAPLParser.LAND); }
		public CompareExprContext compareExpr(int i) {
			return getRuleContext(CompareExprContext.class,i);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); compareExpr();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LAND) {
				{
				{
				setState(161); match(LAND);
				setState(162); compareExpr();
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrExprContext extends ParserRuleContext {
		public List<TerminalNode> LOR() { return getTokens(YAPLParser.LOR); }
		public List<AndExprContext> andExpr() {
			return getRuleContexts(AndExprContext.class);
		}
		public AndExprContext andExpr(int i) {
			return getRuleContext(AndExprContext.class,i);
		}
		public TerminalNode LOR(int i) {
			return getToken(YAPLParser.LOR, i);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); andExpr();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOR) {
				{
				{
				setState(169); match(LOR);
				setState(170); andExpr();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public IdEntry entry;
		public TerminalNode IDENTIFIER() { return getToken(YAPLParser.IDENTIFIER, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public int value = 0;
		public TerminalNode NUMBER() { return getToken(YAPLParser.NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178); match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDenoterContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(YAPLParser.IDENTIFIER, 0); }
		public TypeDenoterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDenoter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitTypeDenoter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDenoterContext typeDenoter() throws RecognitionException {
		TypeDenoterContext _localctx = new TypeDenoterContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeDenoter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180); match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3(\u00b9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\61\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4=\n\4\3\5\3\5\3\5\5\5B\n\5\3\6\3"+
		"\6\3\6\3\6\3\6\7\6I\n\6\f\6\16\6L\13\6\5\6N\n\6\3\6\5\6Q\n\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6d\n\6\f"+
		"\6\16\6g\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6t\n\6\f\6"+
		"\16\6w\13\6\3\6\3\6\5\6{\n\6\3\7\5\7~\n\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b"+
		"\u0086\n\b\f\b\16\b\u0089\13\b\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u0091\n\n\f"+
		"\n\16\n\u0094\13\n\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u009c\n\f\f\f\16\f\u009f"+
		"\13\f\3\r\3\r\3\16\3\16\3\16\7\16\u00a6\n\16\f\16\16\16\u00a9\13\16\3"+
		"\17\3\17\3\17\7\17\u00ae\n\17\f\17\16\17\u00b1\13\17\3\20\3\20\3\21\3"+
		"\21\3\22\3\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2"+
		"\6\4\2\20\20\25\26\3\2\27\31\3\2\25\26\4\2\16\17\21\24\u00bd\2\'\3\2\2"+
		"\2\4\60\3\2\2\2\6<\3\2\2\2\b>\3\2\2\2\nz\3\2\2\2\f}\3\2\2\2\16\u0081\3"+
		"\2\2\2\20\u008a\3\2\2\2\22\u008c\3\2\2\2\24\u0095\3\2\2\2\26\u0097\3\2"+
		"\2\2\30\u00a0\3\2\2\2\32\u00a2\3\2\2\2\34\u00aa\3\2\2\2\36\u00b2\3\2\2"+
		"\2 \u00b4\3\2\2\2\"\u00b6\3\2\2\2$&\5\4\3\2%$\3\2\2\2&)\3\2\2\2\'%\3\2"+
		"\2\2\'(\3\2\2\2(\3\3\2\2\2)\'\3\2\2\2*+\5\6\4\2+,\7\3\2\2,\61\3\2\2\2"+
		"-.\5\b\5\2./\7\3\2\2/\61\3\2\2\2\60*\3\2\2\2\60-\3\2\2\2\61\5\3\2\2\2"+
		"\62\63\7\32\2\2\63\64\5\36\20\2\64\65\7\4\2\2\65\66\5\"\22\2\66=\3\2\2"+
		"\2\678\7\33\2\289\5\36\20\29:\7\5\2\2:;\5\b\5\2;=\3\2\2\2<\62\3\2\2\2"+
		"<\67\3\2\2\2=\7\3\2\2\2>A\5\34\17\2?@\7\5\2\2@B\5\b\5\2A?\3\2\2\2AB\3"+
		"\2\2\2B\t\3\2\2\2CP\5\36\20\2DM\7\b\2\2EJ\5\b\5\2FG\7\13\2\2GI\5\b\5\2"+
		"HF\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KN\3\2\2\2LJ\3\2\2\2ME\3\2\2\2"+
		"MN\3\2\2\2NO\3\2\2\2OQ\7\t\2\2PD\3\2\2\2PQ\3\2\2\2Q{\3\2\2\2R{\5 \21\2"+
		"ST\7\b\2\2TU\5\b\5\2UV\7\t\2\2V{\3\2\2\2W{\7#\2\2X{\7$\2\2YZ\7\35\2\2"+
		"Z[\5\b\5\2[\\\7\36\2\2\\]\5\b\5\2]^\7\37\2\2^_\5\b\5\2_`\7\"\2\2`{\3\2"+
		"\2\2ae\7\6\2\2bd\5\4\3\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2"+
		"\2\2ge\3\2\2\2hi\7\34\2\2ij\5\b\5\2jk\7\3\2\2kl\7\7\2\2l{\3\2\2\2mn\7"+
		" \2\2no\5\b\5\2ou\7!\2\2pq\5\b\5\2qr\7\3\2\2rt\3\2\2\2sp\3\2\2\2tw\3\2"+
		"\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2xy\7\"\2\2y{\3\2\2\2zC\3\2"+
		"\2\2zR\3\2\2\2zS\3\2\2\2zW\3\2\2\2zX\3\2\2\2zY\3\2\2\2za\3\2\2\2zm\3\2"+
		"\2\2{\13\3\2\2\2|~\t\2\2\2}|\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080"+
		"\5\n\6\2\u0080\r\3\2\2\2\u0081\u0087\5\f\7\2\u0082\u0083\5\20\t\2\u0083"+
		"\u0084\5\f\7\2\u0084\u0086\3\2\2\2\u0085\u0082\3\2\2\2\u0086\u0089\3\2"+
		"\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\17\3\2\2\2\u0089\u0087"+
		"\3\2\2\2\u008a\u008b\t\3\2\2\u008b\21\3\2\2\2\u008c\u0092\5\16\b\2\u008d"+
		"\u008e\5\24\13\2\u008e\u008f\5\16\b\2\u008f\u0091\3\2\2\2\u0090\u008d"+
		"\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\23\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\t\4\2\2\u0096\25\3\2\2\2\u0097"+
		"\u009d\5\22\n\2\u0098\u0099\5\30\r\2\u0099\u009a\5\22\n\2\u009a\u009c"+
		"\3\2\2\2\u009b\u0098\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\27\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\t\5\2"+
		"\2\u00a1\31\3\2\2\2\u00a2\u00a7\5\26\f\2\u00a3\u00a4\7\r\2\2\u00a4\u00a6"+
		"\5\26\f\2\u00a5\u00a3\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2"+
		"\u00a7\u00a8\3\2\2\2\u00a8\33\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00af"+
		"\5\32\16\2\u00ab\u00ac\7\f\2\2\u00ac\u00ae\5\32\16\2\u00ad\u00ab\3\2\2"+
		"\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\35"+
		"\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\7%\2\2\u00b3\37\3\2\2\2\u00b4"+
		"\u00b5\7&\2\2\u00b5!\3\2\2\2\u00b6\u00b7\7%\2\2\u00b7#\3\2\2\2\22\'\60"+
		"<AJMPeuz}\u0087\u0092\u009d\u00a7\u00af";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}