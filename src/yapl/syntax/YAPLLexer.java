// Generated from YAPL.g4 by ANTLR 4.2.2
package yapl.syntax;
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
		LTE=18, PLUS=19, MINUS=20, MULT=21, DIV=22, MOD=23, PROGRAM=24, VAR=25, 
		CONST=26, RETURN=27, IF=28, THEN=29, ELSE=30, WHILE=31, DO=32, END=33, 
		IDENTIFIER=34, NUMBER=35, COMMENT=36, WS=37;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"';'", "':'", "'='", "'{'", "'}'", "'('", "')'", "'@'", "','", "'||'", 
		"'&&'", "'=='", "'!='", "'!'", "'>'", "'>='", "'<'", "'<='", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'program'", "'var'", "'const'", "'return'", "'if'", 
		"'then'", "'else'", "'while'", "'do'", "'end'", "IDENTIFIER", "NUMBER", 
		"COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"SEMICOLON", "COLON", "EQ", "LCURLY", "RCURLY", "LPAREN", "RPAREN", "AT", 
		"COMMA", "LOR", "LAND", "LEQ", "LNEQ", "LNOT", "GT", "GTE", "LT", "LTE", 
		"PLUS", "MINUS", "MULT", "DIV", "MOD", "PROGRAM", "VAR", "CONST", "RETURN", 
		"IF", "THEN", "ELSE", "WHILE", "DO", "END", "IDENTIFIER", "NUMBER", "COMMENT", 
		"WS", "LOWER", "UPPER", "LETTER", "DIGIT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\'\u00e6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3 \3 \3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\7#\u00bf\n#\f#\16#\u00c2"+
		"\13#\3$\6$\u00c5\n$\r$\16$\u00c6\3%\3%\3%\3%\7%\u00cd\n%\f%\16%\u00d0"+
		"\13%\3%\3%\3%\3%\3&\6&\u00d7\n&\r&\16&\u00d8\3&\3&\3\'\3\'\3(\3(\3)\3"+
		")\5)\u00e3\n)\3*\3*\3\u00ce\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M\2O\2Q\2S\2\3\2\3\5\2"+
		"\13\f\16\17\"\"\u00e6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3U\3\2\2\2\5W\3\2\2\2\7"+
		"Y\3\2\2\2\t[\3\2\2\2\13]\3\2\2\2\r_\3\2\2\2\17a\3\2\2\2\21c\3\2\2\2\23"+
		"e\3\2\2\2\25g\3\2\2\2\27j\3\2\2\2\31m\3\2\2\2\33p\3\2\2\2\35s\3\2\2\2"+
		"\37u\3\2\2\2!w\3\2\2\2#z\3\2\2\2%|\3\2\2\2\'\177\3\2\2\2)\u0081\3\2\2"+
		"\2+\u0083\3\2\2\2-\u0085\3\2\2\2/\u0087\3\2\2\2\61\u0089\3\2\2\2\63\u0091"+
		"\3\2\2\2\65\u0095\3\2\2\2\67\u009b\3\2\2\29\u00a2\3\2\2\2;\u00a5\3\2\2"+
		"\2=\u00aa\3\2\2\2?\u00af\3\2\2\2A\u00b5\3\2\2\2C\u00b8\3\2\2\2E\u00bc"+
		"\3\2\2\2G\u00c4\3\2\2\2I\u00c8\3\2\2\2K\u00d6\3\2\2\2M\u00dc\3\2\2\2O"+
		"\u00de\3\2\2\2Q\u00e2\3\2\2\2S\u00e4\3\2\2\2UV\7=\2\2V\4\3\2\2\2WX\7<"+
		"\2\2X\6\3\2\2\2YZ\7?\2\2Z\b\3\2\2\2[\\\7}\2\2\\\n\3\2\2\2]^\7\177\2\2"+
		"^\f\3\2\2\2_`\7*\2\2`\16\3\2\2\2ab\7+\2\2b\20\3\2\2\2cd\7B\2\2d\22\3\2"+
		"\2\2ef\7.\2\2f\24\3\2\2\2gh\7~\2\2hi\7~\2\2i\26\3\2\2\2jk\7(\2\2kl\7("+
		"\2\2l\30\3\2\2\2mn\7?\2\2no\7?\2\2o\32\3\2\2\2pq\7#\2\2qr\7?\2\2r\34\3"+
		"\2\2\2st\7#\2\2t\36\3\2\2\2uv\7@\2\2v \3\2\2\2wx\7@\2\2xy\7?\2\2y\"\3"+
		"\2\2\2z{\7>\2\2{$\3\2\2\2|}\7>\2\2}~\7?\2\2~&\3\2\2\2\177\u0080\7-\2\2"+
		"\u0080(\3\2\2\2\u0081\u0082\7/\2\2\u0082*\3\2\2\2\u0083\u0084\7,\2\2\u0084"+
		",\3\2\2\2\u0085\u0086\7\61\2\2\u0086.\3\2\2\2\u0087\u0088\7\'\2\2\u0088"+
		"\60\3\2\2\2\u0089\u008a\7r\2\2\u008a\u008b\7t\2\2\u008b\u008c\7q\2\2\u008c"+
		"\u008d\7i\2\2\u008d\u008e\7t\2\2\u008e\u008f\7c\2\2\u008f\u0090\7o\2\2"+
		"\u0090\62\3\2\2\2\u0091\u0092\7x\2\2\u0092\u0093\7c\2\2\u0093\u0094\7"+
		"t\2\2\u0094\64\3\2\2\2\u0095\u0096\7e\2\2\u0096\u0097\7q\2\2\u0097\u0098"+
		"\7p\2\2\u0098\u0099\7u\2\2\u0099\u009a\7v\2\2\u009a\66\3\2\2\2\u009b\u009c"+
		"\7t\2\2\u009c\u009d\7g\2\2\u009d\u009e\7v\2\2\u009e\u009f\7w\2\2\u009f"+
		"\u00a0\7t\2\2\u00a0\u00a1\7p\2\2\u00a18\3\2\2\2\u00a2\u00a3\7k\2\2\u00a3"+
		"\u00a4\7h\2\2\u00a4:\3\2\2\2\u00a5\u00a6\7v\2\2\u00a6\u00a7\7j\2\2\u00a7"+
		"\u00a8\7g\2\2\u00a8\u00a9\7p\2\2\u00a9<\3\2\2\2\u00aa\u00ab\7g\2\2\u00ab"+
		"\u00ac\7n\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae\7g\2\2\u00ae>\3\2\2\2\u00af"+
		"\u00b0\7y\2\2\u00b0\u00b1\7j\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\7n\2\2"+
		"\u00b3\u00b4\7g\2\2\u00b4@\3\2\2\2\u00b5\u00b6\7f\2\2\u00b6\u00b7\7q\2"+
		"\2\u00b7B\3\2\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7"+
		"f\2\2\u00bbD\3\2\2\2\u00bc\u00c0\5Q)\2\u00bd\u00bf\5Q)\2\u00be\u00bd\3"+
		"\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"F\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c5\5S*\2\u00c4\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7H\3\2\2\2"+
		"\u00c8\u00c9\7\61\2\2\u00c9\u00ca\7\61\2\2\u00ca\u00ce\3\2\2\2\u00cb\u00cd"+
		"\13\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cf\3\2\2\2"+
		"\u00ce\u00cc\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2"+
		"\7\f\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\b%\2\2\u00d4J\3\2\2\2\u00d5\u00d7"+
		"\t\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\b&\2\2\u00dbL\3\2\2\2\u00dc"+
		"\u00dd\4c|\2\u00ddN\3\2\2\2\u00de\u00df\4C\\\2\u00dfP\3\2\2\2\u00e0\u00e3"+
		"\5M\'\2\u00e1\u00e3\5O(\2\u00e2\u00e0\3\2\2\2\u00e2\u00e1\3\2\2\2\u00e3"+
		"R\3\2\2\2\u00e4\u00e5\4\62;\2\u00e5T\3\2\2\2\b\2\u00c0\u00c6\u00ce\u00d8"+
		"\u00e2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}