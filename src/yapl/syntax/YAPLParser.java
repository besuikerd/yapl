// Generated from YAPL.g4 by ANTLR 4.2.2
package yapl.syntax;

	import yapl.typing.Type;
	import yapl.context.IdEntry;
	import java.util.List;

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
		RULE_operand = 4, RULE_exprBlock = 5, RULE_primaryExpr = 6, RULE_multDivModExpr = 7, 
		RULE_opMultDivMod = 8, RULE_plusMinusExpr = 9, RULE_opPlusMinus = 10, 
		RULE_compareExpr = 11, RULE_opCompare = 12, RULE_andExpr = 13, RULE_orExpr = 14, 
		RULE_id = 15, RULE_number = 16, RULE_typeDenoter = 17;
	public static final String[] ruleNames = {
		"yapl", "statement", "declaration", "expression", "operand", "exprBlock", 
		"primaryExpr", "multDivModExpr", "opMultDivMod", "plusMinusExpr", "opPlusMinus", 
		"compareExpr", "opCompare", "andExpr", "orExpr", "id", "number", "typeDenoter"
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
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << VAR) | (1L << CONST) | (1L << IF) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << CHARLITERAL))) != 0)) {
				{
				{
				setState(36); statement();
				}
				}
				setState(41);
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
			setState(48);
			switch (_input.LA(1)) {
			case VAR:
			case CONST:
				_localctx = new StatementDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42); declaration();
				setState(43); match(SEMICOLON);
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
				setState(45); expression();
				setState(46); match(SEMICOLON);
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
		public List<IdEntry> entries;
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
			this.entries = ctx.entries;
		}
	}
	public static class DeclVarContext extends DeclarationContext {
		public TypeDenoterContext typeDenoter() {
			return getRuleContext(TypeDenoterContext.class,0);
		}
		public TerminalNode VAR() { return getToken(YAPLParser.VAR, 0); }
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(YAPLParser.COMMA); }
		public TerminalNode COLON() { return getToken(YAPLParser.COLON, 0); }
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(YAPLParser.COMMA, i);
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
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(YAPLParser.COMMA); }
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public TerminalNode EQ() { return getToken(YAPLParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA(int i) {
			return getToken(YAPLParser.COMMA, i);
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
		int _la;
		try {
			setState(74);
			switch (_input.LA(1)) {
			case VAR:
				_localctx = new DeclVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(50); match(VAR);
				setState(51); id();
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(52); match(COMMA);
					setState(53); id();
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(59); match(COLON);
				setState(60); typeDenoter();
				}
				break;
			case CONST:
				_localctx = new DeclConstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(62); match(CONST);
				setState(63); id();
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(64); match(COMMA);
					setState(65); id();
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(71); match(EQ);
				setState(72); expression();
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); orExpr();
			setState(79);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(77); match(EQ);
				setState(78); expression();
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
		public ExprBlockContext exprBlock() {
			return getRuleContext(ExprBlockContext.class,0);
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
		public ExprBlockContext exprBlock() {
			return getRuleContext(ExprBlockContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(YAPLParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
			setState(119);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new OpIdOrFuncContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81); id();
				setState(94);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(82); match(LPAREN);
					setState(91);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << IF) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << CHARLITERAL))) != 0)) {
						{
						setState(83); expression();
						setState(88);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(84); match(COMMA);
							setState(85); expression();
							}
							}
							setState(90);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(93); match(RPAREN);
					}
				}

				}
				break;
			case NUMBER:
				_localctx = new OpNumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(96); number();
				}
				break;
			case CHARLITERAL:
				_localctx = new OpCharContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(97); match(CHARLITERAL);
				}
				break;
			case LPAREN:
				_localctx = new OpParenExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(98); match(LPAREN);
				setState(99); expression();
				setState(100); match(RPAREN);
				}
				break;
			case TRUE:
				_localctx = new OpTrueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(102); match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new OpFalseContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(103); match(FALSE);
				}
				break;
			case IF:
				_localctx = new OpIfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(104); match(IF);
				setState(105); expression();
				setState(106); match(THEN);
				setState(107); expression();
				setState(110);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(108); match(ELSE);
					setState(109); expression();
					}
				}

				setState(112); match(END);
				}
				break;
			case LCURLY:
				_localctx = new OpExprBlockContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(114); exprBlock();
				}
				break;
			case WHILE:
				_localctx = new OpWhileContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(115); match(WHILE);
				setState(116); expression();
				setState(117); exprBlock();
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

	public static class ExprBlockContext extends ParserRuleContext {
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
		public ExprBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitExprBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprBlockContext exprBlock() throws RecognitionException {
		ExprBlockContext _localctx = new ExprBlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_exprBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); match(LCURLY);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << VAR) | (1L << CONST) | (1L << IF) | (1L << WHILE) | (1L << TRUE) | (1L << FALSE) | (1L << IDENTIFIER) | (1L << NUMBER) | (1L << CHARLITERAL))) != 0)) {
				{
				{
				setState(122); statement();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(128); match(RETURN);
				setState(129); expression();
				setState(130); match(SEMICOLON);
				}
			}

			setState(134); match(RCURLY);
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
		enterRule(_localctx, 12, RULE_primaryExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LNOT) | (1L << PLUS) | (1L << MINUS))) != 0)) {
				{
				setState(136);
				((PrimaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LNOT) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
					((PrimaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(139); operand();
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
		enterRule(_localctx, 14, RULE_multDivModExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); primaryExpr();
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) {
				{
				{
				setState(142); opMultDivMod();
				setState(143); primaryExpr();
				}
				}
				setState(149);
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
		enterRule(_localctx, 16, RULE_opMultDivMod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
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
		enterRule(_localctx, 18, RULE_plusMinusExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152); multDivModExpr();
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(153); opPlusMinus();
				setState(154); multDivModExpr();
				}
				}
				setState(160);
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
		enterRule(_localctx, 20, RULE_opPlusMinus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
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
		enterRule(_localctx, 22, RULE_compareExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); plusMinusExpr();
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEQ) | (1L << LNEQ) | (1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE))) != 0)) {
				{
				{
				setState(164); opCompare();
				setState(165); plusMinusExpr();
				}
				}
				setState(171);
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
		enterRule(_localctx, 24, RULE_opCompare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
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
		enterRule(_localctx, 26, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); compareExpr();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LAND) {
				{
				{
				setState(175); match(LAND);
				setState(176); compareExpr();
				}
				}
				setState(181);
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
		enterRule(_localctx, 28, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182); andExpr();
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOR) {
				{
				{
				setState(183); match(LOR);
				setState(184); andExpr();
				}
				}
				setState(189);
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
		enterRule(_localctx, 30, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); match(IDENTIFIER);
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
		enterRule(_localctx, 32, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192); match(NUMBER);
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
		enterRule(_localctx, 34, RULE_typeDenoter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(IDENTIFIER);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u00c7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\7\2(\n\2\f\2\16\2+\13\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\63"+
		"\n\3\3\4\3\4\3\4\3\4\7\49\n\4\f\4\16\4<\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\7\4E\n\4\f\4\16\4H\13\4\3\4\3\4\3\4\5\4M\n\4\3\5\3\5\3\5\5\5R\n\5\3"+
		"\6\3\6\3\6\3\6\3\6\7\6Y\n\6\f\6\16\6\\\13\6\5\6^\n\6\3\6\5\6a\n\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6q\n\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6z\n\6\3\7\3\7\7\7~\n\7\f\7\16\7\u0081\13\7\3\7"+
		"\3\7\3\7\3\7\5\7\u0087\n\7\3\7\3\7\3\b\5\b\u008c\n\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\7\t\u0094\n\t\f\t\16\t\u0097\13\t\3\n\3\n\3\13\3\13\3\13\3\13\7"+
		"\13\u009f\n\13\f\13\16\13\u00a2\13\13\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00aa"+
		"\n\r\f\r\16\r\u00ad\13\r\3\16\3\16\3\17\3\17\3\17\7\17\u00b4\n\17\f\17"+
		"\16\17\u00b7\13\17\3\20\3\20\3\20\7\20\u00bc\n\20\f\20\16\20\u00bf\13"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$\2\6\4\2\20\20\25\26\3\2\27\31\3\2\25\26\4\2\16\17"+
		"\21\24\u00ce\2)\3\2\2\2\4\62\3\2\2\2\6L\3\2\2\2\bN\3\2\2\2\ny\3\2\2\2"+
		"\f{\3\2\2\2\16\u008b\3\2\2\2\20\u008f\3\2\2\2\22\u0098\3\2\2\2\24\u009a"+
		"\3\2\2\2\26\u00a3\3\2\2\2\30\u00a5\3\2\2\2\32\u00ae\3\2\2\2\34\u00b0\3"+
		"\2\2\2\36\u00b8\3\2\2\2 \u00c0\3\2\2\2\"\u00c2\3\2\2\2$\u00c4\3\2\2\2"+
		"&(\5\4\3\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\3\3\2\2\2+)\3\2"+
		"\2\2,-\5\6\4\2-.\7\3\2\2.\63\3\2\2\2/\60\5\b\5\2\60\61\7\3\2\2\61\63\3"+
		"\2\2\2\62,\3\2\2\2\62/\3\2\2\2\63\5\3\2\2\2\64\65\7\33\2\2\65:\5 \21\2"+
		"\66\67\7\13\2\2\679\5 \21\28\66\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2"+
		";=\3\2\2\2<:\3\2\2\2=>\7\4\2\2>?\5$\23\2?M\3\2\2\2@A\7\34\2\2AF\5 \21"+
		"\2BC\7\13\2\2CE\5 \21\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2"+
		"\2\2HF\3\2\2\2IJ\7\5\2\2JK\5\b\5\2KM\3\2\2\2L\64\3\2\2\2L@\3\2\2\2M\7"+
		"\3\2\2\2NQ\5\36\20\2OP\7\5\2\2PR\5\b\5\2QO\3\2\2\2QR\3\2\2\2R\t\3\2\2"+
		"\2S`\5 \21\2T]\7\b\2\2UZ\5\b\5\2VW\7\13\2\2WY\5\b\5\2XV\3\2\2\2Y\\\3\2"+
		"\2\2ZX\3\2\2\2Z[\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2]U\3\2\2\2]^\3\2\2\2^_\3"+
		"\2\2\2_a\7\t\2\2`T\3\2\2\2`a\3\2\2\2az\3\2\2\2bz\5\"\22\2cz\7*\2\2de\7"+
		"\b\2\2ef\5\b\5\2fg\7\t\2\2gz\3\2\2\2hz\7$\2\2iz\7%\2\2jk\7\36\2\2kl\5"+
		"\b\5\2lm\7\37\2\2mp\5\b\5\2no\7 \2\2oq\5\b\5\2pn\3\2\2\2pq\3\2\2\2qr\3"+
		"\2\2\2rs\7#\2\2sz\3\2\2\2tz\5\f\7\2uv\7!\2\2vw\5\b\5\2wx\5\f\7\2xz\3\2"+
		"\2\2yS\3\2\2\2yb\3\2\2\2yc\3\2\2\2yd\3\2\2\2yh\3\2\2\2yi\3\2\2\2yj\3\2"+
		"\2\2yt\3\2\2\2yu\3\2\2\2z\13\3\2\2\2{\177\7\6\2\2|~\5\4\3\2}|\3\2\2\2"+
		"~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0086\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0082\u0083\7\35\2\2\u0083\u0084\5\b\5\2\u0084\u0085\7\3"+
		"\2\2\u0085\u0087\3\2\2\2\u0086\u0082\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0089\7\7\2\2\u0089\r\3\2\2\2\u008a\u008c\t\2\2\2"+
		"\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e"+
		"\5\n\6\2\u008e\17\3\2\2\2\u008f\u0095\5\16\b\2\u0090\u0091\5\22\n\2\u0091"+
		"\u0092\5\16\b\2\u0092\u0094\3\2\2\2\u0093\u0090\3\2\2\2\u0094\u0097\3"+
		"\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\21\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098\u0099\t\3\2\2\u0099\23\3\2\2\2\u009a\u00a0\5\20\t"+
		"\2\u009b\u009c\5\26\f\2\u009c\u009d\5\20\t\2\u009d\u009f\3\2\2\2\u009e"+
		"\u009b\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\25\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\t\4\2\2\u00a4\27"+
		"\3\2\2\2\u00a5\u00ab\5\24\13\2\u00a6\u00a7\5\32\16\2\u00a7\u00a8\5\24"+
		"\13\2\u00a8\u00aa\3\2\2\2\u00a9\u00a6\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\31\3\2\2\2\u00ad\u00ab\3\2\2"+
		"\2\u00ae\u00af\t\5\2\2\u00af\33\3\2\2\2\u00b0\u00b5\5\30\r\2\u00b1\u00b2"+
		"\7\r\2\2\u00b2\u00b4\5\30\r\2\u00b3\u00b1\3\2\2\2\u00b4\u00b7\3\2\2\2"+
		"\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\35\3\2\2\2\u00b7\u00b5"+
		"\3\2\2\2\u00b8\u00bd\5\34\17\2\u00b9\u00ba\7\f\2\2\u00ba\u00bc\5\34\17"+
		"\2\u00bb\u00b9\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\37\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1\7&\2\2\u00c1"+
		"!\3\2\2\2\u00c2\u00c3\7\'\2\2\u00c3#\3\2\2\2\u00c4\u00c5\7&\2\2\u00c5"+
		"%\3\2\2\2\25)\62:FLQZ]`py\177\u0086\u008b\u0095\u00a0\u00ab\u00b5\u00bd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}