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
		LTE=18, PLUS=19, MINUS=20, MULT=21, DIV=22, MOD=23, VAR=24, CONST=25, 
		RETURN=26, IF=27, THEN=28, ELSE=29, WHILE=30, DO=31, END=32, TRUE=33, 
		FALSE=34, IDENTIFIER=35, NUMBER=36, COMMENT=37, WS=38;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"';'", "':'", "'='", "'{'", "'}'", "'('", "')'", "'@'", "','", "'||'", 
		"'&&'", "'=='", "'!='", "'!'", "'>'", "'>='", "'<'", "'<='", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'var'", "'const'", "'return'", "'if'", "'then'", 
		"'else'", "'while'", "'do'", "'end'", "'true'", "'false'", "IDENTIFIER", 
		"NUMBER", "COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"SEMICOLON", "COLON", "EQ", "LCURLY", "RCURLY", "LPAREN", "RPAREN", "AT", 
		"COMMA", "LOR", "LAND", "LEQ", "LNEQ", "LNOT", "GT", "GTE", "LT", "LTE", 
		"PLUS", "MINUS", "MULT", "DIV", "MOD", "VAR", "CONST", "RETURN", "IF", 
		"THEN", "ELSE", "WHILE", "DO", "END", "TRUE", "FALSE", "IDENTIFIER", "NUMBER", 
		"COMMENT", "WS", "LOWER", "UPPER", "LETTER", "DIGIT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2(\u00eb\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\7$\u00c4"+
		"\n$\f$\16$\u00c7\13$\3%\6%\u00ca\n%\r%\16%\u00cb\3&\3&\3&\3&\7&\u00d2"+
		"\n&\f&\16&\u00d5\13&\3&\3&\3&\3&\3\'\6\'\u00dc\n\'\r\'\16\'\u00dd\3\'"+
		"\3\'\3(\3(\3)\3)\3*\3*\5*\u00e8\n*\3+\3+\3\u00d3\2,\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O\2Q\2S\2U\2\3\2\3\5\2\13\f\16\17\"\"\u00eb\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\3W\3\2\2\2\5Y\3\2\2\2\7[\3\2\2\2\t]\3\2\2\2\13_\3\2\2\2\r"+
		"a\3\2\2\2\17c\3\2\2\2\21e\3\2\2\2\23g\3\2\2\2\25i\3\2\2\2\27l\3\2\2\2"+
		"\31o\3\2\2\2\33r\3\2\2\2\35u\3\2\2\2\37w\3\2\2\2!y\3\2\2\2#|\3\2\2\2%"+
		"~\3\2\2\2\'\u0081\3\2\2\2)\u0083\3\2\2\2+\u0085\3\2\2\2-\u0087\3\2\2\2"+
		"/\u0089\3\2\2\2\61\u008b\3\2\2\2\63\u008f\3\2\2\2\65\u0095\3\2\2\2\67"+
		"\u009c\3\2\2\29\u009f\3\2\2\2;\u00a4\3\2\2\2=\u00a9\3\2\2\2?\u00af\3\2"+
		"\2\2A\u00b2\3\2\2\2C\u00b6\3\2\2\2E\u00bb\3\2\2\2G\u00c1\3\2\2\2I\u00c9"+
		"\3\2\2\2K\u00cd\3\2\2\2M\u00db\3\2\2\2O\u00e1\3\2\2\2Q\u00e3\3\2\2\2S"+
		"\u00e7\3\2\2\2U\u00e9\3\2\2\2WX\7=\2\2X\4\3\2\2\2YZ\7<\2\2Z\6\3\2\2\2"+
		"[\\\7?\2\2\\\b\3\2\2\2]^\7}\2\2^\n\3\2\2\2_`\7\177\2\2`\f\3\2\2\2ab\7"+
		"*\2\2b\16\3\2\2\2cd\7+\2\2d\20\3\2\2\2ef\7B\2\2f\22\3\2\2\2gh\7.\2\2h"+
		"\24\3\2\2\2ij\7~\2\2jk\7~\2\2k\26\3\2\2\2lm\7(\2\2mn\7(\2\2n\30\3\2\2"+
		"\2op\7?\2\2pq\7?\2\2q\32\3\2\2\2rs\7#\2\2st\7?\2\2t\34\3\2\2\2uv\7#\2"+
		"\2v\36\3\2\2\2wx\7@\2\2x \3\2\2\2yz\7@\2\2z{\7?\2\2{\"\3\2\2\2|}\7>\2"+
		"\2}$\3\2\2\2~\177\7>\2\2\177\u0080\7?\2\2\u0080&\3\2\2\2\u0081\u0082\7"+
		"-\2\2\u0082(\3\2\2\2\u0083\u0084\7/\2\2\u0084*\3\2\2\2\u0085\u0086\7,"+
		"\2\2\u0086,\3\2\2\2\u0087\u0088\7\61\2\2\u0088.\3\2\2\2\u0089\u008a\7"+
		"\'\2\2\u008a\60\3\2\2\2\u008b\u008c\7x\2\2\u008c\u008d\7c\2\2\u008d\u008e"+
		"\7t\2\2\u008e\62\3\2\2\2\u008f\u0090\7e\2\2\u0090\u0091\7q\2\2\u0091\u0092"+
		"\7p\2\2\u0092\u0093\7u\2\2\u0093\u0094\7v\2\2\u0094\64\3\2\2\2\u0095\u0096"+
		"\7t\2\2\u0096\u0097\7g\2\2\u0097\u0098\7v\2\2\u0098\u0099\7w\2\2\u0099"+
		"\u009a\7t\2\2\u009a\u009b\7p\2\2\u009b\66\3\2\2\2\u009c\u009d\7k\2\2\u009d"+
		"\u009e\7h\2\2\u009e8\3\2\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7j\2\2\u00a1"+
		"\u00a2\7g\2\2\u00a2\u00a3\7p\2\2\u00a3:\3\2\2\2\u00a4\u00a5\7g\2\2\u00a5"+
		"\u00a6\7n\2\2\u00a6\u00a7\7u\2\2\u00a7\u00a8\7g\2\2\u00a8<\3\2\2\2\u00a9"+
		"\u00aa\7y\2\2\u00aa\u00ab\7j\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7n\2\2"+
		"\u00ad\u00ae\7g\2\2\u00ae>\3\2\2\2\u00af\u00b0\7f\2\2\u00b0\u00b1\7q\2"+
		"\2\u00b1@\3\2\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7"+
		"f\2\2\u00b5B\3\2\2\2\u00b6\u00b7\7v\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9"+
		"\7w\2\2\u00b9\u00ba\7g\2\2\u00baD\3\2\2\2\u00bb\u00bc\7h\2\2\u00bc\u00bd"+
		"\7c\2\2\u00bd\u00be\7n\2\2\u00be\u00bf\7u\2\2\u00bf\u00c0\7g\2\2\u00c0"+
		"F\3\2\2\2\u00c1\u00c5\5S*\2\u00c2\u00c4\5S*\2\u00c3\u00c2\3\2\2\2\u00c4"+
		"\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6H\3\2\2\2"+
		"\u00c7\u00c5\3\2\2\2\u00c8\u00ca\5U+\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb"+
		"\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00ccJ\3\2\2\2\u00cd"+
		"\u00ce\7\61\2\2\u00ce\u00cf\7\61\2\2\u00cf\u00d3\3\2\2\2\u00d0\u00d2\13"+
		"\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7\f"+
		"\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\b&\2\2\u00d9L\3\2\2\2\u00da\u00dc"+
		"\t\2\2\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\b\'\2\2\u00e0N\3\2\2\2"+
		"\u00e1\u00e2\4c|\2\u00e2P\3\2\2\2\u00e3\u00e4\4C\\\2\u00e4R\3\2\2\2\u00e5"+
		"\u00e8\5O(\2\u00e6\u00e8\5Q)\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3\2\2\2"+
		"\u00e8T\3\2\2\2\u00e9\u00ea\4\62;\2\u00eaV\3\2\2\2\b\2\u00c5\u00cb\u00d3"+
		"\u00dd\u00e7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}