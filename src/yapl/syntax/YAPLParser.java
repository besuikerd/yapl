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
		RULE_operand = 4, RULE_primaryExpr = 5, RULE_multDivModExpr = 6, RULE_plusMinusExpr = 7, 
		RULE_compareExpr = 8, RULE_andExpr = 9, RULE_orExpr = 10, RULE_id = 11, 
		RULE_number = 12, RULE_typeDenoter = 13;
	public static final String[] ruleNames = {
		"yapl", "statement", "declaration", "expression", "operand", "primaryExpr", 
		"multDivModExpr", "plusMinusExpr", "compareExpr", "andExpr", "orExpr", 
		"id", "number", "typeDenoter"
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
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << VAR) | (1L << CONST) | (1L << IF) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(28); statement();
				}
				}
				setState(33);
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
			setState(40);
			switch (_input.LA(1)) {
			case VAR:
			case CONST:
				_localctx = new StatementDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(34); declaration();
				setState(35); match(SEMICOLON);
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
				setState(37); expression();
				setState(38); match(SEMICOLON);
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
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
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
			setState(52);
			switch (_input.LA(1)) {
			case VAR:
				_localctx = new DeclVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42); match(VAR);
				setState(43); id();
				setState(44); match(COLON);
				setState(45); typeDenoter();
				}
				break;
			case CONST:
				_localctx = new DeclConstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47); match(CONST);
				setState(48); id();
				setState(49); match(EQ);
				setState(50); expression();
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
			setState(54); orExpr();
			setState(57);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(55); match(EQ);
				setState(56); expression();
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
			setState(114);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new OpIdOrFuncContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59); id();
				setState(72);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(60); match(LPAREN);
					setState(69);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << IF) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
						{
						setState(61); expression();
						setState(66);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(62); match(COMMA);
							setState(63); expression();
							}
							}
							setState(68);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(71); match(RPAREN);
					}
				}

				}
				break;
			case NUMBER:
				_localctx = new OpNumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(74); number();
				}
				break;
			case LPAREN:
				_localctx = new OpParenExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(75); match(LPAREN);
				setState(76); expression();
				setState(77); match(RPAREN);
				}
				break;
			case TRUE:
				_localctx = new OpTrueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(79); match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new OpFalseContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(80); match(FALSE);
				}
				break;
			case IF:
				_localctx = new OpIfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(81); match(IF);
				setState(82); expression();
				setState(83); match(THEN);
				setState(84); expression();
				setState(85); match(ELSE);
				setState(86); expression();
				setState(87); match(END);
				}
				break;
			case LCURLY:
				_localctx = new OpExprBlockContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(89); match(LCURLY);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << VAR) | (1L << CONST) | (1L << IF) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
					{
					{
					setState(90); statement();
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96); match(RETURN);
				setState(97); expression();
				setState(98); match(SEMICOLON);
				setState(99); match(RCURLY);
				}
				break;
			case WHILE:
				_localctx = new OpWhileContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(101); match(WHILE);
				setState(102); expression();
				setState(103); match(DO);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << IF) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
					{
					{
					setState(104); expression();
					setState(105); match(SEMICOLON);
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112); match(END);
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
			setState(117);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LNOT) | (1L << PLUS) | (1L << MINUS))) != 0)) {
				{
				setState(116);
				((PrimaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LNOT) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
					((PrimaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(119); operand();
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
		public Token op;
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public TerminalNode MULT() { return getToken(YAPLParser.MULT, 0); }
		public TerminalNode MOD() { return getToken(YAPLParser.MOD, 0); }
		public MultDivModExprContext multDivModExpr() {
			return getRuleContext(MultDivModExprContext.class,0);
		}
		public TerminalNode DIV() { return getToken(YAPLParser.DIV, 0); }
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
			setState(121); primaryExpr();
			setState(124);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) {
				{
				setState(122);
				((MultDivModExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
					((MultDivModExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(123); multDivModExpr();
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

	public static class PlusMinusExprContext extends ParserRuleContext {
		public Token op;
		public PlusMinusExprContext plusMinusExpr() {
			return getRuleContext(PlusMinusExprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(YAPLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(YAPLParser.MINUS, 0); }
		public MultDivModExprContext multDivModExpr() {
			return getRuleContext(MultDivModExprContext.class,0);
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
		enterRule(_localctx, 14, RULE_plusMinusExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); multDivModExpr();
			setState(129);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(127);
				((PlusMinusExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((PlusMinusExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(128); plusMinusExpr();
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

	public static class CompareExprContext extends ParserRuleContext {
		public Token op;
		public TerminalNode LNEQ() { return getToken(YAPLParser.LNEQ, 0); }
		public PlusMinusExprContext plusMinusExpr() {
			return getRuleContext(PlusMinusExprContext.class,0);
		}
		public TerminalNode LEQ() { return getToken(YAPLParser.LEQ, 0); }
		public TerminalNode GTE() { return getToken(YAPLParser.GTE, 0); }
		public TerminalNode LT() { return getToken(YAPLParser.LT, 0); }
		public TerminalNode GT() { return getToken(YAPLParser.GT, 0); }
		public CompareExprContext compareExpr() {
			return getRuleContext(CompareExprContext.class,0);
		}
		public TerminalNode LTE() { return getToken(YAPLParser.LTE, 0); }
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
		enterRule(_localctx, 16, RULE_compareExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); plusMinusExpr();
			setState(134);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEQ) | (1L << LNEQ) | (1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE))) != 0)) {
				{
				setState(132);
				((CompareExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEQ) | (1L << LNEQ) | (1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE))) != 0)) ) {
					((CompareExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(133); compareExpr();
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

	public static class AndExprContext extends ParserRuleContext {
		public Token op;
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public CompareExprContext compareExpr() {
			return getRuleContext(CompareExprContext.class,0);
		}
		public TerminalNode LAND() { return getToken(YAPLParser.LAND, 0); }
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
		enterRule(_localctx, 18, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); compareExpr();
			setState(139);
			_la = _input.LA(1);
			if (_la==LAND) {
				{
				setState(137); ((AndExprContext)_localctx).op = match(LAND);
				setState(138); andExpr();
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

	public static class OrExprContext extends ParserRuleContext {
		public Token op;
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode LOR() { return getToken(YAPLParser.LOR, 0); }
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
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
		enterRule(_localctx, 20, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); andExpr();
			setState(144);
			_la = _input.LA(1);
			if (_la==LOR) {
				{
				setState(142); ((OrExprContext)_localctx).op = match(LOR);
				setState(143); orExpr();
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
		enterRule(_localctx, 22, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); match(IDENTIFIER);
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
		enterRule(_localctx, 24, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); match(NUMBER);
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
		enterRule(_localctx, 26, RULE_typeDenoter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); match(IDENTIFIER);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3(\u009b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\7\2 \n\2\f\2\16\2#\13\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3+\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4\67\n\4\3\5\3\5\3\5\5\5<\n\5\3\6\3\6\3\6\3\6\3\6\7\6C\n\6\f\6\16"+
		"\6F\13\6\5\6H\n\6\3\6\5\6K\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6^\n\6\f\6\16\6a\13\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6n\n\6\f\6\16\6q\13\6\3\6\3\6\5\6u\n\6\3"+
		"\7\5\7x\n\7\3\7\3\7\3\b\3\b\3\b\5\b\177\n\b\3\t\3\t\3\t\5\t\u0084\n\t"+
		"\3\n\3\n\3\n\5\n\u0089\n\n\3\13\3\13\3\13\5\13\u008e\n\13\3\f\3\f\3\f"+
		"\5\f\u0093\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\2\2\20\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\2\6\4\2\20\20\25\26\3\2\27\31\3\2\25\26\4\2\16\17"+
		"\21\24\u00a2\2!\3\2\2\2\4*\3\2\2\2\6\66\3\2\2\2\b8\3\2\2\2\nt\3\2\2\2"+
		"\fw\3\2\2\2\16{\3\2\2\2\20\u0080\3\2\2\2\22\u0085\3\2\2\2\24\u008a\3\2"+
		"\2\2\26\u008f\3\2\2\2\30\u0094\3\2\2\2\32\u0096\3\2\2\2\34\u0098\3\2\2"+
		"\2\36 \5\4\3\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\3\3\2"+
		"\2\2#!\3\2\2\2$%\5\6\4\2%&\7\3\2\2&+\3\2\2\2\'(\5\b\5\2()\7\3\2\2)+\3"+
		"\2\2\2*$\3\2\2\2*\'\3\2\2\2+\5\3\2\2\2,-\7\32\2\2-.\5\30\r\2./\7\4\2\2"+
		"/\60\5\34\17\2\60\67\3\2\2\2\61\62\7\33\2\2\62\63\5\30\r\2\63\64\7\5\2"+
		"\2\64\65\5\b\5\2\65\67\3\2\2\2\66,\3\2\2\2\66\61\3\2\2\2\67\7\3\2\2\2"+
		"8;\5\26\f\29:\7\5\2\2:<\5\b\5\2;9\3\2\2\2;<\3\2\2\2<\t\3\2\2\2=J\5\30"+
		"\r\2>G\7\b\2\2?D\5\b\5\2@A\7\13\2\2AC\5\b\5\2B@\3\2\2\2CF\3\2\2\2DB\3"+
		"\2\2\2DE\3\2\2\2EH\3\2\2\2FD\3\2\2\2G?\3\2\2\2GH\3\2\2\2HI\3\2\2\2IK\7"+
		"\t\2\2J>\3\2\2\2JK\3\2\2\2Ku\3\2\2\2Lu\5\32\16\2MN\7\b\2\2NO\5\b\5\2O"+
		"P\7\t\2\2Pu\3\2\2\2Qu\7#\2\2Ru\7$\2\2ST\7\35\2\2TU\5\b\5\2UV\7\36\2\2"+
		"VW\5\b\5\2WX\7\37\2\2XY\5\b\5\2YZ\7\"\2\2Zu\3\2\2\2[_\7\6\2\2\\^\5\4\3"+
		"\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2bc\7\34"+
		"\2\2cd\5\b\5\2de\7\3\2\2ef\7\7\2\2fu\3\2\2\2gh\7 \2\2hi\5\b\5\2io\7!\2"+
		"\2jk\5\b\5\2kl\7\3\2\2ln\3\2\2\2mj\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2"+
		"\2pr\3\2\2\2qo\3\2\2\2rs\7\"\2\2su\3\2\2\2t=\3\2\2\2tL\3\2\2\2tM\3\2\2"+
		"\2tQ\3\2\2\2tR\3\2\2\2tS\3\2\2\2t[\3\2\2\2tg\3\2\2\2u\13\3\2\2\2vx\t\2"+
		"\2\2wv\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\5\n\6\2z\r\3\2\2\2{~\5\f\7\2|}\t"+
		"\3\2\2}\177\5\16\b\2~|\3\2\2\2~\177\3\2\2\2\177\17\3\2\2\2\u0080\u0083"+
		"\5\16\b\2\u0081\u0082\t\4\2\2\u0082\u0084\5\20\t\2\u0083\u0081\3\2\2\2"+
		"\u0083\u0084\3\2\2\2\u0084\21\3\2\2\2\u0085\u0088\5\20\t\2\u0086\u0087"+
		"\t\5\2\2\u0087\u0089\5\22\n\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2"+
		"\u0089\23\3\2\2\2\u008a\u008d\5\22\n\2\u008b\u008c\7\r\2\2\u008c\u008e"+
		"\5\24\13\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\25\3\2\2\2\u008f"+
		"\u0092\5\24\13\2\u0090\u0091\7\f\2\2\u0091\u0093\5\26\f\2\u0092\u0090"+
		"\3\2\2\2\u0092\u0093\3\2\2\2\u0093\27\3\2\2\2\u0094\u0095\7%\2\2\u0095"+
		"\31\3\2\2\2\u0096\u0097\7&\2\2\u0097\33\3\2\2\2\u0098\u0099\7%\2\2\u0099"+
		"\35\3\2\2\2\22!*\66;DGJ_otw~\u0083\u0088\u008d\u0092";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}