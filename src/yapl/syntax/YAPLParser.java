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
		LTE=18, PLUS=19, MINUS=20, MULT=21, DIV=22, MOD=23, APOSTROFE=24, VAR=25, 
		CONST=26, RETURN=27, IF=28, THEN=29, ELSE=30, WHILE=31, DO=32, END=33, 
		TRUE=34, FALSE=35, IDENTIFIER=36, NUMBER=37, COMMENT=38, WS=39, CHARLITERAL=40;
	public static final String[] tokenNames = {
		"<INVALID>", "';'", "':'", "'='", "'{'", "'}'", "'('", "')'", "'@'", "','", 
		"'||'", "'&&'", "'=='", "'!='", "'!'", "'>'", "'>='", "'<'", "'<='", "'+'", 
		"'-'", "'*'", "'/'", "'%'", "'''", "'var'", "'const'", "'return'", "'if'", 
		"'then'", "'else'", "'while'", "'do'", "'end'", "'true'", "'false'", "IDENTIFIER", 
		"NUMBER", "COMMENT", "WS", "CHARLITERAL"
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << VAR) | (1L << CONST) | (1L << IF) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << CHARLITERAL))) != 0)) {
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
			case CHARLITERAL:
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
		public Type type;
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); orExpr();
			setState(63);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(61); match(EQ);
				setState(62); expression();
				}
				break;
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
	public static class OpCharContext extends OperandContext {
		public TerminalNode CHARLITERAL() { return getToken(YAPLParser.CHARLITERAL, 0); }
		public OpCharContext(OperandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitOpChar(this);
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
		public TerminalNode DO() { return getToken(YAPLParser.DO, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
			setState(115);
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
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << IF) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << CHARLITERAL))) != 0)) {
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
			case CHARLITERAL:
				_localctx = new OpCharContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(81); match(CHARLITERAL);
				}
				break;
			case LPAREN:
				_localctx = new OpParenExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(82); match(LPAREN);
				setState(83); expression();
				setState(84); match(RPAREN);
				}
				break;
			case TRUE:
				_localctx = new OpTrueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(86); match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new OpFalseContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(87); match(FALSE);
				}
				break;
			case IF:
				_localctx = new OpIfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(88); match(IF);
				setState(89); expression();
				setState(90); match(THEN);
				setState(91); expression();
				setState(94);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1+1:
					{
					setState(92); match(ELSE);
					setState(93); expression();
					}
					break;
				}
				}
				break;
			case LCURLY:
				_localctx = new OpExprBlockContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(96); match(LCURLY);
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << VAR) | (1L << CONST) | (1L << IF) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << CHARLITERAL))) != 0)) {
					{
					{
					setState(97); statement();
					}
					}
					setState(102);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(107);
				_la = _input.LA(1);
				if (_la==RETURN) {
					{
					setState(103); match(RETURN);
					setState(104); expression();
					setState(105); match(SEMICOLON);
					}
				}

				setState(109); match(RCURLY);
				}
				break;
			case WHILE:
				_localctx = new OpWhileContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(110); match(WHILE);
				setState(111); expression();
				setState(112); match(DO);
				setState(113); expression();
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
			setState(118);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LNOT) | (1L << PLUS) | (1L << MINUS))) != 0)) {
				{
				setState(117);
				((PrimaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LNOT) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
					((PrimaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(120); operand();
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122); primaryExpr();
			setState(128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(123); opMultDivMod();
					setState(124); primaryExpr();
					}
					} 
				}
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
			setState(131);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(133); multDivModExpr();
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(134); opPlusMinus();
					setState(135); multDivModExpr();
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
			setState(142);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144); plusMinusExpr();
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(145); opCompare();
					setState(146); plusMinusExpr();
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
			setState(153);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(155); compareExpr();
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(156); match(LAND);
					setState(157); compareExpr();
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163); andExpr();
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(164); match(LOR);
					setState(165); andExpr();
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
			setState(171); match(IDENTIFIER);
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
			setState(173); match(NUMBER);
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
			setState(175); match(IDENTIFIER);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u00b4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\61\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4=\n\4\3\5\3\5\3\5\5\5B\n\5\3\6\3"+
		"\6\3\6\3\6\3\6\7\6I\n\6\f\6\16\6L\13\6\5\6N\n\6\3\6\5\6Q\n\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6a\n\6\3\6\3\6\7\6e\n"+
		"\6\f\6\16\6h\13\6\3\6\3\6\3\6\3\6\5\6n\n\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6"+
		"v\n\6\3\7\5\7y\n\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u0081\n\b\f\b\16\b\u0084"+
		"\13\b\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u008c\n\n\f\n\16\n\u008f\13\n\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\7\f\u0097\n\f\f\f\16\f\u009a\13\f\3\r\3\r\3\16\3\16"+
		"\3\16\7\16\u00a1\n\16\f\16\16\16\u00a4\13\16\3\17\3\17\3\17\7\17\u00a9"+
		"\n\17\f\17\16\17\u00ac\13\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3`\2\23"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\6\4\2\20\20\25\26\3\2\27"+
		"\31\3\2\25\26\4\2\16\17\21\24\u00ba\2\'\3\2\2\2\4\60\3\2\2\2\6<\3\2\2"+
		"\2\b>\3\2\2\2\nu\3\2\2\2\fx\3\2\2\2\16|\3\2\2\2\20\u0085\3\2\2\2\22\u0087"+
		"\3\2\2\2\24\u0090\3\2\2\2\26\u0092\3\2\2\2\30\u009b\3\2\2\2\32\u009d\3"+
		"\2\2\2\34\u00a5\3\2\2\2\36\u00ad\3\2\2\2 \u00af\3\2\2\2\"\u00b1\3\2\2"+
		"\2$&\5\4\3\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2\2)\'\3"+
		"\2\2\2*+\5\6\4\2+,\7\3\2\2,\61\3\2\2\2-.\5\b\5\2./\7\3\2\2/\61\3\2\2\2"+
		"\60*\3\2\2\2\60-\3\2\2\2\61\5\3\2\2\2\62\63\7\33\2\2\63\64\5\36\20\2\64"+
		"\65\7\4\2\2\65\66\5\"\22\2\66=\3\2\2\2\678\7\34\2\289\5\36\20\29:\7\5"+
		"\2\2:;\5\b\5\2;=\3\2\2\2<\62\3\2\2\2<\67\3\2\2\2=\7\3\2\2\2>A\5\34\17"+
		"\2?@\7\5\2\2@B\5\b\5\2A?\3\2\2\2AB\3\2\2\2B\t\3\2\2\2CP\5\36\20\2DM\7"+
		"\b\2\2EJ\5\b\5\2FG\7\13\2\2GI\5\b\5\2HF\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK"+
		"\3\2\2\2KN\3\2\2\2LJ\3\2\2\2ME\3\2\2\2MN\3\2\2\2NO\3\2\2\2OQ\7\t\2\2P"+
		"D\3\2\2\2PQ\3\2\2\2Qv\3\2\2\2Rv\5 \21\2Sv\7*\2\2TU\7\b\2\2UV\5\b\5\2V"+
		"W\7\t\2\2Wv\3\2\2\2Xv\7$\2\2Yv\7%\2\2Z[\7\36\2\2[\\\5\b\5\2\\]\7\37\2"+
		"\2]`\5\b\5\2^_\7 \2\2_a\5\b\5\2`a\3\2\2\2`^\3\2\2\2av\3\2\2\2bf\7\6\2"+
		"\2ce\5\4\3\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gm\3\2\2\2hf\3\2\2"+
		"\2ij\7\35\2\2jk\5\b\5\2kl\7\3\2\2ln\3\2\2\2mi\3\2\2\2mn\3\2\2\2no\3\2"+
		"\2\2ov\7\7\2\2pq\7!\2\2qr\5\b\5\2rs\7\"\2\2st\5\b\5\2tv\3\2\2\2uC\3\2"+
		"\2\2uR\3\2\2\2uS\3\2\2\2uT\3\2\2\2uX\3\2\2\2uY\3\2\2\2uZ\3\2\2\2ub\3\2"+
		"\2\2up\3\2\2\2v\13\3\2\2\2wy\t\2\2\2xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\5"+
		"\n\6\2{\r\3\2\2\2|\u0082\5\f\7\2}~\5\20\t\2~\177\5\f\7\2\177\u0081\3\2"+
		"\2\2\u0080}\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\17\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\t\3\2\2\u0086"+
		"\21\3\2\2\2\u0087\u008d\5\16\b\2\u0088\u0089\5\24\13\2\u0089\u008a\5\16"+
		"\b\2\u008a\u008c\3\2\2\2\u008b\u0088\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\23\3\2\2\2\u008f\u008d\3\2\2"+
		"\2\u0090\u0091\t\4\2\2\u0091\25\3\2\2\2\u0092\u0098\5\22\n\2\u0093\u0094"+
		"\5\30\r\2\u0094\u0095\5\22\n\2\u0095\u0097\3\2\2\2\u0096\u0093\3\2\2\2"+
		"\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\27"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\t\5\2\2\u009c\31\3\2\2\2\u009d"+
		"\u00a2\5\26\f\2\u009e\u009f\7\r\2\2\u009f\u00a1\5\26\f\2\u00a0\u009e\3"+
		"\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\33\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00aa\5\32\16\2\u00a6\u00a7\7\f"+
		"\2\2\u00a7\u00a9\5\32\16\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\35\3\2\2\2\u00ac\u00aa\3\2\2"+
		"\2\u00ad\u00ae\7&\2\2\u00ae\37\3\2\2\2\u00af\u00b0\7\'\2\2\u00b0!\3\2"+
		"\2\2\u00b1\u00b2\7&\2\2\u00b2#\3\2\2\2\23\'\60<AJMP`fmux\u0082\u008d\u0098"+
		"\u00a2\u00aa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}