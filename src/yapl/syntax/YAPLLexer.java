// Generated from YAPL.g4 by ANTLR 4.2.2
package yapl.syntax;

	import yapl.typing.Type;
	import yapl.context.IdEntry;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class YAPLLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMICOLON=1, COLON=2, EQ=3, LCURLY=4, RCURLY=5, LPAREN=6, RPAREN=7, AT=8, 
		COMMA=9, LOR=10, LAND=11, LEQ=12, LNEQ=13, LNOT=14, GT=15, GTE=16, LT=17, 
		LTE=18, PLUS=19, MINUS=20, MULT=21, DIV=22, MOD=23, APOSTROFE=24, VAR=25, 
		CONST=26, RETURN=27, IF=28, THEN=29, ELSE=30, WHILE=31, DO=32, END=33, 
		TRUE=34, FALSE=35, IDENTIFIER=36, NUMBER=37, COMMENT=38, WS=39, CHARLITERAL=40;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"';'", "':'", "'='", "'{'", "'}'", "'('", "')'", "'@'", "','", "'||'", 
		"'&&'", "'=='", "'!='", "'!'", "'>'", "'>='", "'<'", "'<='", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'''", "'var'", "'const'", "'return'", "'if'", "'then'", 
		"'else'", "'while'", "'do'", "'end'", "'true'", "'false'", "IDENTIFIER", 
		"NUMBER", "COMMENT", "WS", "CHARLITERAL"
	};
	public static final String[] ruleNames = {
		"SEMICOLON", "COLON", "EQ", "LCURLY", "RCURLY", "LPAREN", "RPAREN", "AT", 
		"COMMA", "LOR", "LAND", "LEQ", "LNEQ", "LNOT", "GT", "GTE", "LT", "LTE", 
		"PLUS", "MINUS", "MULT", "DIV", "MOD", "APOSTROFE", "VAR", "CONST", "RETURN", 
		"IF", "THEN", "ELSE", "WHILE", "DO", "END", "TRUE", "FALSE", "IDENTIFIER", 
		"NUMBER", "COMMENT", "WS", "CHARLITERAL", "SINGLECHAR", "LOWER", "UPPER", 
		"LETTER", "DIGIT"
	};


	public YAPLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "YAPL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2*\u00f9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 "+
		"\3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3"+
		"$\3%\3%\7%\u00cc\n%\f%\16%\u00cf\13%\3&\6&\u00d2\n&\r&\16&\u00d3\3\'\3"+
		"\'\3\'\3\'\7\'\u00da\n\'\f\'\16\'\u00dd\13\'\3\'\3\'\3\'\3\'\3(\6(\u00e4"+
		"\n(\r(\16(\u00e5\3(\3(\3)\3)\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\5-\u00f6\n"+
		"-\3.\3.\3\u00db\2/\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S\2U\2W\2Y\2[\2\3\2\4\5\2"+
		"\13\f\16\17\"\"\4\2))^^\u00f8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\3]\3\2\2\2\5_\3\2\2\2\7a\3\2\2\2\tc\3\2\2\2\13e\3\2"+
		"\2\2\rg\3\2\2\2\17i\3\2\2\2\21k\3\2\2\2\23m\3\2\2\2\25o\3\2\2\2\27r\3"+
		"\2\2\2\31u\3\2\2\2\33x\3\2\2\2\35{\3\2\2\2\37}\3\2\2\2!\177\3\2\2\2#\u0082"+
		"\3\2\2\2%\u0084\3\2\2\2\'\u0087\3\2\2\2)\u0089\3\2\2\2+\u008b\3\2\2\2"+
		"-\u008d\3\2\2\2/\u008f\3\2\2\2\61\u0091\3\2\2\2\63\u0093\3\2\2\2\65\u0097"+
		"\3\2\2\2\67\u009d\3\2\2\29\u00a4\3\2\2\2;\u00a7\3\2\2\2=\u00ac\3\2\2\2"+
		"?\u00b1\3\2\2\2A\u00b7\3\2\2\2C\u00ba\3\2\2\2E\u00be\3\2\2\2G\u00c3\3"+
		"\2\2\2I\u00c9\3\2\2\2K\u00d1\3\2\2\2M\u00d5\3\2\2\2O\u00e3\3\2\2\2Q\u00e9"+
		"\3\2\2\2S\u00ed\3\2\2\2U\u00ef\3\2\2\2W\u00f1\3\2\2\2Y\u00f5\3\2\2\2["+
		"\u00f7\3\2\2\2]^\7=\2\2^\4\3\2\2\2_`\7<\2\2`\6\3\2\2\2ab\7?\2\2b\b\3\2"+
		"\2\2cd\7}\2\2d\n\3\2\2\2ef\7\177\2\2f\f\3\2\2\2gh\7*\2\2h\16\3\2\2\2i"+
		"j\7+\2\2j\20\3\2\2\2kl\7B\2\2l\22\3\2\2\2mn\7.\2\2n\24\3\2\2\2op\7~\2"+
		"\2pq\7~\2\2q\26\3\2\2\2rs\7(\2\2st\7(\2\2t\30\3\2\2\2uv\7?\2\2vw\7?\2"+
		"\2w\32\3\2\2\2xy\7#\2\2yz\7?\2\2z\34\3\2\2\2{|\7#\2\2|\36\3\2\2\2}~\7"+
		"@\2\2~ \3\2\2\2\177\u0080\7@\2\2\u0080\u0081\7?\2\2\u0081\"\3\2\2\2\u0082"+
		"\u0083\7>\2\2\u0083$\3\2\2\2\u0084\u0085\7>\2\2\u0085\u0086\7?\2\2\u0086"+
		"&\3\2\2\2\u0087\u0088\7-\2\2\u0088(\3\2\2\2\u0089\u008a\7/\2\2\u008a*"+
		"\3\2\2\2\u008b\u008c\7,\2\2\u008c,\3\2\2\2\u008d\u008e\7\61\2\2\u008e"+
		".\3\2\2\2\u008f\u0090\7\'\2\2\u0090\60\3\2\2\2\u0091\u0092\7)\2\2\u0092"+
		"\62\3\2\2\2\u0093\u0094\7x\2\2\u0094\u0095\7c\2\2\u0095\u0096\7t\2\2\u0096"+
		"\64\3\2\2\2\u0097\u0098\7e\2\2\u0098\u0099\7q\2\2\u0099\u009a\7p\2\2\u009a"+
		"\u009b\7u\2\2\u009b\u009c\7v\2\2\u009c\66\3\2\2\2\u009d\u009e\7t\2\2\u009e"+
		"\u009f\7g\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7w\2\2\u00a1\u00a2\7t\2\2"+
		"\u00a2\u00a3\7p\2\2\u00a38\3\2\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7h\2"+
		"\2\u00a6:\3\2\2\2\u00a7\u00a8\7v\2\2\u00a8\u00a9\7j\2\2\u00a9\u00aa\7"+
		"g\2\2\u00aa\u00ab\7p\2\2\u00ab<\3\2\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae"+
		"\7n\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7g\2\2\u00b0>\3\2\2\2\u00b1\u00b2"+
		"\7y\2\2\u00b2\u00b3\7j\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7n\2\2\u00b5"+
		"\u00b6\7g\2\2\u00b6@\3\2\2\2\u00b7\u00b8\7f\2\2\u00b8\u00b9\7q\2\2\u00b9"+
		"B\3\2\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7f\2\2\u00bd"+
		"D\3\2\2\2\u00be\u00bf\7v\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7w\2\2\u00c1"+
		"\u00c2\7g\2\2\u00c2F\3\2\2\2\u00c3\u00c4\7h\2\2\u00c4\u00c5\7c\2\2\u00c5"+
		"\u00c6\7n\2\2\u00c6\u00c7\7u\2\2\u00c7\u00c8\7g\2\2\u00c8H\3\2\2\2\u00c9"+
		"\u00cd\5Y-\2\u00ca\u00cc\5Y-\2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2"+
		"\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ceJ\3\2\2\2\u00cf\u00cd\3"+
		"\2\2\2\u00d0\u00d2\5[.\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4L\3\2\2\2\u00d5\u00d6\7\61\2\2"+
		"\u00d6\u00d7\7\61\2\2\u00d7\u00db\3\2\2\2\u00d8\u00da\13\2\2\2\u00d9\u00d8"+
		"\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc"+
		"\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\7\f\2\2\u00df\u00e0\3\2"+
		"\2\2\u00e0\u00e1\b\'\2\2\u00e1N\3\2\2\2\u00e2\u00e4\t\2\2\2\u00e3\u00e2"+
		"\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00e8\b(\2\2\u00e8P\3\2\2\2\u00e9\u00ea\7)\2\2\u00ea"+
		"\u00eb\5S*\2\u00eb\u00ec\7)\2\2\u00ecR\3\2\2\2\u00ed\u00ee\n\3\2\2\u00ee"+
		"T\3\2\2\2\u00ef\u00f0\4c|\2\u00f0V\3\2\2\2\u00f1\u00f2\4C\\\2\u00f2X\3"+
		"\2\2\2\u00f3\u00f6\5U+\2\u00f4\u00f6\5W,\2\u00f5\u00f3\3\2\2\2\u00f5\u00f4"+
		"\3\2\2\2\u00f6Z\3\2\2\2\u00f7\u00f8\4\62;\2\u00f8\\\3\2\2\2\b\2\u00cd"+
		"\u00d3\u00db\u00e5\u00f5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}