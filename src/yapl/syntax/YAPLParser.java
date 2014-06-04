// Generated from YAPL.g4 by ANTLR 4.2.2
package yapl.syntax;
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
		LTE=18, PLUS=19, MINUS=20, MULT=21, DIV=22, MOD=23, PROGRAM=24, VAR=25, 
		CONST=26, RETURN=27, IF=28, THEN=29, ELSE=30, WHILE=31, DO=32, END=33, 
		IDENTIFIER=34, NUMBER=35, COMMENT=36, WS=37;
	public static final String[] tokenNames = {
		"<INVALID>", "';'", "':'", "'='", "'{'", "'}'", "'('", "')'", "'@'", "','", 
		"'||'", "'&&'", "'=='", "'!='", "'!'", "'>'", "'>='", "'<'", "'<='", "'+'", 
		"'-'", "'*'", "'/'", "'%'", "'program'", "'var'", "'const'", "'return'", 
		"'if'", "'then'", "'else'", "'while'", "'do'", "'end'", "IDENTIFIER", 
		"NUMBER", "COMMENT", "WS"
	};
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_declaration = 2, RULE_expression = 3, 
		RULE_exprconstruct = 4, RULE_ret = 5, RULE_operand = 6, RULE_primaryExpr = 7, 
		RULE_multDivModExpr = 8, RULE_plusMinusExpr = 9, RULE_compareExpr = 10, 
		RULE_andExpr = 11, RULE_orExpr = 12, RULE_id = 13, RULE_number = 14, RULE_typeDenoter = 15;
	public static final String[] ruleNames = {
		"program", "statement", "declaration", "expression", "exprconstruct", 
		"ret", "operand", "primaryExpr", "multDivModExpr", "plusMinusExpr", "compareExpr", 
		"andExpr", "orExpr", "id", "number", "typeDenoter"
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
	public static class ProgramContext extends ParserRuleContext {
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << VAR) | (1L << CONST) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(32); statement();
				}
				}
				setState(37);
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
		public TerminalNode SEMICOLON() { return getToken(YAPLParser.SEMICOLON, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			switch (_input.LA(1)) {
			case VAR:
			case CONST:
				{
				setState(38); declaration();
				}
				break;
			case LCURLY:
			case LPAREN:
			case LNOT:
			case PLUS:
			case MINUS:
			case IDENTIFIER:
			case NUMBER:
				{
				setState(39); expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(42); match(SEMICOLON);
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
		public TypeDenoterContext typeDenoter() {
			return getRuleContext(TypeDenoterContext.class,0);
		}
		public TerminalNode CONST() { return getToken(YAPLParser.CONST, 0); }
		public TerminalNode VAR() { return getToken(YAPLParser.VAR, 0); }
		public TerminalNode COLON() { return getToken(YAPLParser.COLON, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode EQ() { return getToken(YAPLParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			setState(54);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(44); match(VAR);
				setState(45); id();
				setState(46); match(COLON);
				setState(47); typeDenoter();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(49); match(CONST);
				setState(50); id();
				setState(51); match(EQ);
				setState(52); expression();
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
		public TerminalNode EQ() { return getToken(YAPLParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprconstructContext exprconstruct() {
			return getRuleContext(ExprconstructContext.class,0);
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
			setState(56); exprconstruct();
			setState(59);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(57); match(EQ);
				setState(58); expression();
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

	public static class ExprconstructContext extends ParserRuleContext {
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(YAPLParser.RCURLY, 0); }
		public TerminalNode LCURLY() { return getToken(YAPLParser.LCURLY, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public ExprconstructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprconstruct; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitExprconstruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprconstructContext exprconstruct() throws RecognitionException {
		ExprconstructContext _localctx = new ExprconstructContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_exprconstruct);
		int _la;
		try {
			setState(72);
			switch (_input.LA(1)) {
			case LCURLY:
				enterOuterAlt(_localctx, 1);
				{
				setState(61); match(LCURLY);
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << LPAREN) | (1L << LNOT) | (1L << PLUS) | (1L << MINUS) | (1L << VAR) | (1L << CONST) | (1L << IDENTIFIER) | (1L << NUMBER))) != 0)) {
					{
					{
					setState(62); statement();
					}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(68); ret();
				setState(69); match(RCURLY);
				}
				break;
			case LPAREN:
			case LNOT:
			case PLUS:
			case MINUS:
			case IDENTIFIER:
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(71); orExpr();
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

	public static class RetContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(YAPLParser.SEMICOLON, 0); }
		public TerminalNode RETURN() { return getToken(YAPLParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ret);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); match(RETURN);
			setState(75); expression();
			setState(76); match(SEMICOLON);
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
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
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
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_operand);
		int _la;
		try {
			setState(97);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(78); id();
				setState(90);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(79); match(LPAREN);
					setState(80); expression();
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(81); match(COMMA);
						setState(82); expression();
						}
						}
						setState(87);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(88); match(RPAREN);
					}
				}

				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(92); number();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(93); match(LPAREN);
				setState(94); expression();
				setState(95); match(RPAREN);
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
		enterRule(_localctx, 14, RULE_primaryExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LNOT) | (1L << PLUS) | (1L << MINUS))) != 0)) {
				{
				setState(99);
				((PrimaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LNOT) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
					((PrimaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(102); operand();
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
		enterRule(_localctx, 16, RULE_multDivModExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); primaryExpr();
			setState(107);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) {
				{
				setState(105);
				((MultDivModExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
					((MultDivModExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(106); multDivModExpr();
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
		enterRule(_localctx, 18, RULE_plusMinusExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109); multDivModExpr();
			setState(112);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(110);
				((PlusMinusExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((PlusMinusExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(111); plusMinusExpr();
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
		enterRule(_localctx, 20, RULE_compareExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114); plusMinusExpr();
			setState(117);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEQ) | (1L << LNEQ) | (1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE))) != 0)) {
				{
				setState(115);
				((CompareExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEQ) | (1L << LNEQ) | (1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE))) != 0)) ) {
					((CompareExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(116); compareExpr();
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
		enterRule(_localctx, 22, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); compareExpr();
			setState(122);
			_la = _input.LA(1);
			if (_la==LAND) {
				{
				setState(120); match(LAND);
				setState(121); andExpr();
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
		public TerminalNode LOR() { return getToken(YAPLParser.LOR, 0); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
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
		enterRule(_localctx, 24, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124); andExpr();
			setState(127);
			_la = _input.LA(1);
			if (_la==LOR) {
				{
				setState(125); match(LOR);
				setState(126); orExpr();
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
		enterRule(_localctx, 26, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(IDENTIFIER);
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
		public int value = 0;;
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
		enterRule(_localctx, 28, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); match(NUMBER);
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
		enterRule(_localctx, 30, RULE_typeDenoter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); match(IDENTIFIER);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u008a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\3\3\3\5\3+\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\49\n\4\3\5\3\5\3\5\5\5>\n\5\3\6\3\6\7\6B\n\6\f\6\16\6"+
		"E\13\6\3\6\3\6\3\6\3\6\5\6K\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7"+
		"\bV\n\b\f\b\16\bY\13\b\3\b\3\b\5\b]\n\b\3\b\3\b\3\b\3\b\3\b\5\bd\n\b\3"+
		"\t\5\tg\n\t\3\t\3\t\3\n\3\n\3\n\5\nn\n\n\3\13\3\13\3\13\5\13s\n\13\3\f"+
		"\3\f\3\f\5\fx\n\f\3\r\3\r\3\r\5\r}\n\r\3\16\3\16\3\16\5\16\u0082\n\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \2\6\4\2\20\20\25\26\3\2\27\31\3\2\25\26\4\2\16\17\21\24"+
		"\u0089\2%\3\2\2\2\4*\3\2\2\2\68\3\2\2\2\b:\3\2\2\2\nJ\3\2\2\2\fL\3\2\2"+
		"\2\16c\3\2\2\2\20f\3\2\2\2\22j\3\2\2\2\24o\3\2\2\2\26t\3\2\2\2\30y\3\2"+
		"\2\2\32~\3\2\2\2\34\u0083\3\2\2\2\36\u0085\3\2\2\2 \u0087\3\2\2\2\"$\5"+
		"\4\3\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\3\3\2\2\2\'%\3\2\2\2"+
		"(+\5\6\4\2)+\5\b\5\2*(\3\2\2\2*)\3\2\2\2+,\3\2\2\2,-\7\3\2\2-\5\3\2\2"+
		"\2./\7\33\2\2/\60\5\34\17\2\60\61\7\4\2\2\61\62\5 \21\2\629\3\2\2\2\63"+
		"\64\7\34\2\2\64\65\5\34\17\2\65\66\7\5\2\2\66\67\5\b\5\2\679\3\2\2\28"+
		".\3\2\2\28\63\3\2\2\29\7\3\2\2\2:=\5\n\6\2;<\7\5\2\2<>\5\b\5\2=;\3\2\2"+
		"\2=>\3\2\2\2>\t\3\2\2\2?C\7\6\2\2@B\5\4\3\2A@\3\2\2\2BE\3\2\2\2CA\3\2"+
		"\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FG\5\f\7\2GH\7\7\2\2HK\3\2\2\2IK\5\32"+
		"\16\2J?\3\2\2\2JI\3\2\2\2K\13\3\2\2\2LM\7\35\2\2MN\5\b\5\2NO\7\3\2\2O"+
		"\r\3\2\2\2P\\\5\34\17\2QR\7\b\2\2RW\5\b\5\2ST\7\13\2\2TV\5\b\5\2US\3\2"+
		"\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z[\7\t\2\2[]\3\2"+
		"\2\2\\Q\3\2\2\2\\]\3\2\2\2]d\3\2\2\2^d\5\36\20\2_`\7\b\2\2`a\5\b\5\2a"+
		"b\7\t\2\2bd\3\2\2\2cP\3\2\2\2c^\3\2\2\2c_\3\2\2\2d\17\3\2\2\2eg\t\2\2"+
		"\2fe\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\5\16\b\2i\21\3\2\2\2jm\5\20\t\2kl\t"+
		"\3\2\2ln\5\22\n\2mk\3\2\2\2mn\3\2\2\2n\23\3\2\2\2or\5\22\n\2pq\t\4\2\2"+
		"qs\5\24\13\2rp\3\2\2\2rs\3\2\2\2s\25\3\2\2\2tw\5\24\13\2uv\t\5\2\2vx\5"+
		"\26\f\2wu\3\2\2\2wx\3\2\2\2x\27\3\2\2\2y|\5\26\f\2z{\7\r\2\2{}\5\30\r"+
		"\2|z\3\2\2\2|}\3\2\2\2}\31\3\2\2\2~\u0081\5\30\r\2\177\u0080\7\f\2\2\u0080"+
		"\u0082\5\32\16\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\33\3\2\2"+
		"\2\u0083\u0084\7$\2\2\u0084\35\3\2\2\2\u0085\u0086\7%\2\2\u0086\37\3\2"+
		"\2\2\u0087\u0088\7$\2\2\u0088!\3\2\2\2\21%*8=CJW\\cfmrw|\u0081";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}