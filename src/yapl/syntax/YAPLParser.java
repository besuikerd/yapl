// Generated from /home/langstra/Documents/Technische Informatica/Vertalerbouw/yapl/src/yapl/syntax/YAPL.g4 by ANTLR 4.x
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
		CONST=26, RETURN=27, IDENTIFIER=28, NUMBER=29, COMMENT=30, WS=31;
	public static final String[] tokenNames = {
		"<INVALID>", "';'", "':'", "'='", "'{'", "'}'", "'('", "')'", "'@'", "','", 
		"'||'", "'&&'", "'=='", "'!='", "'!'", "'>'", "'>='", "'<'", "'<='", "'+'", 
		"'-'", "'*'", "'/'", "'%'", "'program'", "'var'", "'const'", "'return'", 
		"IDENTIFIER", "NUMBER", "COMMENT", "WS"
	};
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_declaration = 2, RULE_assignment = 3, 
		RULE_expression = 4, RULE_ret = 5, RULE_primaryExpr = 6, RULE_multDivModExpr = 7, 
		RULE_plusMinusExpr = 8, RULE_compareExpr = 9, RULE_andExpr = 10, RULE_orExpr = 11, 
		RULE_operand = 12, RULE_id = 13, RULE_number = 14, RULE_typeDenoter = 15;
	public static final String[] ruleNames = {
		"program", "statement", "declaration", "assignment", "expression", "ret", 
		"primaryExpr", "multDivModExpr", "plusMinusExpr", "compareExpr", "andExpr", 
		"orExpr", "operand", "id", "number", "typeDenoter"
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << CONST) | (1L << IDENTIFIER))) != 0)) {
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
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
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
			case IDENTIFIER:
				{
				setState(39); assignment();
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
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TypeDenoterContext typeDenoter() {
			return getRuleContext(TypeDenoterContext.class,0);
		}
		public TerminalNode VAR() { return getToken(YAPLParser.VAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CONST() { return getToken(YAPLParser.CONST, 0); }
		public TerminalNode COLON() { return getToken(YAPLParser.COLON, 0); }
		public TerminalNode EQ() { return getToken(YAPLParser.EQ, 0); }
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

	public static class AssignmentContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EQ() { return getToken(YAPLParser.EQ, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YAPLVisitor ) return ((YAPLVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); id();
			setState(57); match(EQ);
			setState(58); expression();
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode LCURLY() { return getToken(YAPLParser.LCURLY, 0); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(YAPLParser.RCURLY, 0); }
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
		enterRule(_localctx, 8, RULE_expression);
		int _la;
		try {
			setState(71);
			switch (_input.LA(1)) {
			case LCURLY:
				enterOuterAlt(_localctx, 1);
				{
				setState(60); match(LCURLY);
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << CONST) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(61); statement();
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(67); ret();
				setState(68); match(RCURLY);
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
				setState(70); orExpr();
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
			setState(73); match(RETURN);
			setState(74); expression();
			setState(75); match(SEMICOLON);
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
		public TerminalNode LNOT() { return getToken(YAPLParser.LNOT, 0); }
		public TerminalNode MINUS() { return getToken(YAPLParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(YAPLParser.PLUS, 0); }
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
			setState(78);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LNOT) | (1L << PLUS) | (1L << MINUS))) != 0)) {
				{
				setState(77);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LNOT) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(80); operand();
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
		public PrimaryExprContext primaryExpr(int i) {
			return getRuleContext(PrimaryExprContext.class,i);
		}
		public List<TerminalNode> DIV() { return getTokens(YAPLParser.DIV); }
		public List<PrimaryExprContext> primaryExpr() {
			return getRuleContexts(PrimaryExprContext.class);
		}
		public List<TerminalNode> MULT() { return getTokens(YAPLParser.MULT); }
		public TerminalNode DIV(int i) {
			return getToken(YAPLParser.DIV, i);
		}
		public TerminalNode MOD(int i) {
			return getToken(YAPLParser.MOD, i);
		}
		public TerminalNode MULT(int i) {
			return getToken(YAPLParser.MULT, i);
		}
		public List<TerminalNode> MOD() { return getTokens(YAPLParser.MOD); }
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
			setState(82); primaryExpr();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) {
				{
				{
				setState(83);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(84); primaryExpr();
				}
				}
				setState(89);
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

	public static class PlusMinusExprContext extends ParserRuleContext {
		public List<MultDivModExprContext> multDivModExpr() {
			return getRuleContexts(MultDivModExprContext.class);
		}
		public TerminalNode MINUS(int i) {
			return getToken(YAPLParser.MINUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(YAPLParser.MINUS); }
		public MultDivModExprContext multDivModExpr(int i) {
			return getRuleContext(MultDivModExprContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(YAPLParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(YAPLParser.PLUS, i);
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
			setState(90); multDivModExpr();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(91);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(92); multDivModExpr();
				}
				}
				setState(97);
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

	public static class CompareExprContext extends ParserRuleContext {
		public TerminalNode LTE(int i) {
			return getToken(YAPLParser.LTE, i);
		}
		public List<TerminalNode> GTE() { return getTokens(YAPLParser.GTE); }
		public List<TerminalNode> LTE() { return getTokens(YAPLParser.LTE); }
		public TerminalNode LNEQ(int i) {
			return getToken(YAPLParser.LNEQ, i);
		}
		public TerminalNode GT(int i) {
			return getToken(YAPLParser.GT, i);
		}
		public TerminalNode GTE(int i) {
			return getToken(YAPLParser.GTE, i);
		}
		public TerminalNode LT(int i) {
			return getToken(YAPLParser.LT, i);
		}
		public List<TerminalNode> LT() { return getTokens(YAPLParser.LT); }
		public PlusMinusExprContext plusMinusExpr(int i) {
			return getRuleContext(PlusMinusExprContext.class,i);
		}
		public List<TerminalNode> LEQ() { return getTokens(YAPLParser.LEQ); }
		public List<TerminalNode> LNEQ() { return getTokens(YAPLParser.LNEQ); }
		public List<TerminalNode> GT() { return getTokens(YAPLParser.GT); }
		public List<PlusMinusExprContext> plusMinusExpr() {
			return getRuleContexts(PlusMinusExprContext.class);
		}
		public TerminalNode LEQ(int i) {
			return getToken(YAPLParser.LEQ, i);
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
		enterRule(_localctx, 18, RULE_compareExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); plusMinusExpr();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEQ) | (1L << LNEQ) | (1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE))) != 0)) {
				{
				{
				setState(99);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEQ) | (1L << LNEQ) | (1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(100); plusMinusExpr();
				}
				}
				setState(105);
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

	public static class AndExprContext extends ParserRuleContext {
		public TerminalNode LAND(int i) {
			return getToken(YAPLParser.LAND, i);
		}
		public CompareExprContext compareExpr(int i) {
			return getRuleContext(CompareExprContext.class,i);
		}
		public List<TerminalNode> LAND() { return getTokens(YAPLParser.LAND); }
		public List<CompareExprContext> compareExpr() {
			return getRuleContexts(CompareExprContext.class);
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
		enterRule(_localctx, 20, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); compareExpr();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LAND) {
				{
				{
				setState(107); match(LAND);
				setState(108); compareExpr();
				}
				}
				setState(113);
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
		public AndExprContext andExpr(int i) {
			return getRuleContext(AndExprContext.class,i);
		}
		public TerminalNode LOR(int i) {
			return getToken(YAPLParser.LOR, i);
		}
		public List<AndExprContext> andExpr() {
			return getRuleContexts(AndExprContext.class);
		}
		public List<TerminalNode> LOR() { return getTokens(YAPLParser.LOR); }
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
		enterRule(_localctx, 22, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114); andExpr();
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOR) {
				{
				{
				setState(115); match(LOR);
				setState(116); andExpr();
				}
				}
				setState(121);
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

	public static class OperandContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(YAPLParser.COMMA); }
		public TerminalNode RPAREN() { return getToken(YAPLParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode LPAREN() { return getToken(YAPLParser.LPAREN, 0); }
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
		enterRule(_localctx, 24, RULE_operand);
		int _la;
		try {
			setState(141);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(122); id();
				setState(134);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(123); match(LPAREN);
					setState(124); expression();
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(125); match(COMMA);
						setState(126); expression();
						}
						}
						setState(131);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(132); match(RPAREN);
					}
				}

				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(136); number();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(137); match(LPAREN);
				setState(138); expression();
				setState(139); match(RPAREN);
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
			setState(143); match(IDENTIFIER);
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
		enterRule(_localctx, 28, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); match(NUMBER);
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
			setState(147); match(IDENTIFIER);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u0098\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\3\3\3\5\3+\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\49\n\4\3\5\3\5\3\5\3\5\3\6\3\6\7\6A\n\6\f\6\16\6D\13"+
		"\6\3\6\3\6\3\6\3\6\5\6J\n\6\3\7\3\7\3\7\3\7\3\b\5\bQ\n\b\3\b\3\b\3\t\3"+
		"\t\3\t\7\tX\n\t\f\t\16\t[\13\t\3\n\3\n\3\n\7\n`\n\n\f\n\16\nc\13\n\3\13"+
		"\3\13\3\13\7\13h\n\13\f\13\16\13k\13\13\3\f\3\f\3\f\7\fp\n\f\f\f\16\f"+
		"s\13\f\3\r\3\r\3\r\7\rx\n\r\f\r\16\r{\13\r\3\16\3\16\3\16\3\16\3\16\7"+
		"\16\u0082\n\16\f\16\16\16\u0085\13\16\3\16\3\16\5\16\u0089\n\16\3\16\3"+
		"\16\3\16\3\16\3\16\5\16\u0090\n\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\6\4\2\20\20\25\26\3"+
		"\2\27\31\3\2\25\26\4\2\16\17\21\24\u0096\2%\3\2\2\2\4*\3\2\2\2\68\3\2"+
		"\2\2\b:\3\2\2\2\nI\3\2\2\2\fK\3\2\2\2\16P\3\2\2\2\20T\3\2\2\2\22\\\3\2"+
		"\2\2\24d\3\2\2\2\26l\3\2\2\2\30t\3\2\2\2\32\u008f\3\2\2\2\34\u0091\3\2"+
		"\2\2\36\u0093\3\2\2\2 \u0095\3\2\2\2\"$\5\4\3\2#\"\3\2\2\2$\'\3\2\2\2"+
		"%#\3\2\2\2%&\3\2\2\2&\3\3\2\2\2\'%\3\2\2\2(+\5\6\4\2)+\5\b\5\2*(\3\2\2"+
		"\2*)\3\2\2\2+,\3\2\2\2,-\7\3\2\2-\5\3\2\2\2./\7\33\2\2/\60\5\34\17\2\60"+
		"\61\7\4\2\2\61\62\5 \21\2\629\3\2\2\2\63\64\7\34\2\2\64\65\5\34\17\2\65"+
		"\66\7\5\2\2\66\67\5\n\6\2\679\3\2\2\28.\3\2\2\28\63\3\2\2\29\7\3\2\2\2"+
		":;\5\34\17\2;<\7\5\2\2<=\5\n\6\2=\t\3\2\2\2>B\7\6\2\2?A\5\4\3\2@?\3\2"+
		"\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\5\f\7\2FG\7\7"+
		"\2\2GJ\3\2\2\2HJ\5\30\r\2I>\3\2\2\2IH\3\2\2\2J\13\3\2\2\2KL\7\35\2\2L"+
		"M\5\n\6\2MN\7\3\2\2N\r\3\2\2\2OQ\t\2\2\2PO\3\2\2\2PQ\3\2\2\2QR\3\2\2\2"+
		"RS\5\32\16\2S\17\3\2\2\2TY\5\16\b\2UV\t\3\2\2VX\5\16\b\2WU\3\2\2\2X[\3"+
		"\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\21\3\2\2\2[Y\3\2\2\2\\a\5\20\t\2]^\t\4\2\2"+
		"^`\5\20\t\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\23\3\2\2\2ca\3\2"+
		"\2\2di\5\22\n\2ef\t\5\2\2fh\5\22\n\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3"+
		"\2\2\2j\25\3\2\2\2ki\3\2\2\2lq\5\24\13\2mn\7\r\2\2np\5\24\13\2om\3\2\2"+
		"\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\27\3\2\2\2sq\3\2\2\2ty\5\26\f\2uv\7"+
		"\f\2\2vx\5\26\f\2wu\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\31\3\2\2\2"+
		"{y\3\2\2\2|\u0088\5\34\17\2}~\7\b\2\2~\u0083\5\n\6\2\177\u0080\7\13\2"+
		"\2\u0080\u0082\5\n\6\2\u0081\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0087\7\t\2\2\u0087\u0089\3\2\2\2\u0088}\3\2\2\2\u0088\u0089\3\2\2\2"+
		"\u0089\u0090\3\2\2\2\u008a\u0090\5\36\20\2\u008b\u008c\7\b\2\2\u008c\u008d"+
		"\5\n\6\2\u008d\u008e\7\t\2\2\u008e\u0090\3\2\2\2\u008f|\3\2\2\2\u008f"+
		"\u008a\3\2\2\2\u008f\u008b\3\2\2\2\u0090\33\3\2\2\2\u0091\u0092\7\36\2"+
		"\2\u0092\35\3\2\2\2\u0093\u0094\7\37\2\2\u0094\37\3\2\2\2\u0095\u0096"+
		"\7\36\2\2\u0096!\3\2\2\2\20%*8BIPYaiqy\u0083\u0088\u008f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}