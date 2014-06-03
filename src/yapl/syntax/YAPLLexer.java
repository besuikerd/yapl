// Generated from /home/langstra/Documents/Technische Informatica/Vertalerbouw/yapl/src/yapl/syntax/YAPL.g4 by ANTLR 4.x
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
		CONST=26, RETURN=27, IDENTIFIER=28, NUMBER=29, COMMENT=30, WS=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'"
	};
	public static final String[] ruleNames = {
		"SEMICOLON", "COLON", "EQ", "LCURLY", "RCURLY", "LPAREN", "RPAREN", "AT", 
		"COMMA", "LOR", "LAND", "LEQ", "LNEQ", "LNOT", "GT", "GTE", "LT", "LTE", 
		"PLUS", "MINUS", "MULT", "DIV", "MOD", "PROGRAM", "VAR", "CONST", "RETURN", 
		"IDENTIFIER", "NUMBER", "COMMENT", "WS", "LOWER", "UPPER", "LETTER", "DIGIT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u00c0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\7\35\u0099\n\35\f\35\16"+
		"\35\u009c\13\35\3\36\6\36\u009f\n\36\r\36\16\36\u00a0\3\37\3\37\3\37\3"+
		"\37\7\37\u00a7\n\37\f\37\16\37\u00aa\13\37\3\37\3\37\3\37\3\37\3 \6 \u00b1"+
		"\n \r \16 \u00b2\3 \3 \3!\3!\3\"\3\"\3#\3#\5#\u00bd\n#\3$\3$\3\u00a8\2"+
		"%\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\2C\2E\2G\2\3\2\3\5\2\13\f\16\17\"\"\u00c0\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\3I\3\2\2\2\5K\3\2\2\2\7M\3\2\2\2\tO\3\2\2\2\13Q\3\2\2\2\rS\3\2"+
		"\2\2\17U\3\2\2\2\21W\3\2\2\2\23Y\3\2\2\2\25[\3\2\2\2\27^\3\2\2\2\31a\3"+
		"\2\2\2\33d\3\2\2\2\35g\3\2\2\2\37i\3\2\2\2!k\3\2\2\2#n\3\2\2\2%p\3\2\2"+
		"\2\'s\3\2\2\2)u\3\2\2\2+w\3\2\2\2-y\3\2\2\2/{\3\2\2\2\61}\3\2\2\2\63\u0085"+
		"\3\2\2\2\65\u0089\3\2\2\2\67\u008f\3\2\2\29\u0096\3\2\2\2;\u009e\3\2\2"+
		"\2=\u00a2\3\2\2\2?\u00b0\3\2\2\2A\u00b6\3\2\2\2C\u00b8\3\2\2\2E\u00bc"+
		"\3\2\2\2G\u00be\3\2\2\2IJ\7=\2\2J\4\3\2\2\2KL\7<\2\2L\6\3\2\2\2MN\7?\2"+
		"\2N\b\3\2\2\2OP\7}\2\2P\n\3\2\2\2QR\7\177\2\2R\f\3\2\2\2ST\7*\2\2T\16"+
		"\3\2\2\2UV\7+\2\2V\20\3\2\2\2WX\7B\2\2X\22\3\2\2\2YZ\7.\2\2Z\24\3\2\2"+
		"\2[\\\7~\2\2\\]\7~\2\2]\26\3\2\2\2^_\7(\2\2_`\7(\2\2`\30\3\2\2\2ab\7?"+
		"\2\2bc\7?\2\2c\32\3\2\2\2de\7#\2\2ef\7?\2\2f\34\3\2\2\2gh\7#\2\2h\36\3"+
		"\2\2\2ij\7@\2\2j \3\2\2\2kl\7@\2\2lm\7?\2\2m\"\3\2\2\2no\7>\2\2o$\3\2"+
		"\2\2pq\7>\2\2qr\7?\2\2r&\3\2\2\2st\7-\2\2t(\3\2\2\2uv\7/\2\2v*\3\2\2\2"+
		"wx\7,\2\2x,\3\2\2\2yz\7\61\2\2z.\3\2\2\2{|\7\'\2\2|\60\3\2\2\2}~\7r\2"+
		"\2~\177\7t\2\2\177\u0080\7q\2\2\u0080\u0081\7i\2\2\u0081\u0082\7t\2\2"+
		"\u0082\u0083\7c\2\2\u0083\u0084\7o\2\2\u0084\62\3\2\2\2\u0085\u0086\7"+
		"x\2\2\u0086\u0087\7c\2\2\u0087\u0088\7t\2\2\u0088\64\3\2\2\2\u0089\u008a"+
		"\7e\2\2\u008a\u008b\7q\2\2\u008b\u008c\7p\2\2\u008c\u008d\7u\2\2\u008d"+
		"\u008e\7v\2\2\u008e\66\3\2\2\2\u008f\u0090\7t\2\2\u0090\u0091\7g\2\2\u0091"+
		"\u0092\7v\2\2\u0092\u0093\7w\2\2\u0093\u0094\7t\2\2\u0094\u0095\7p\2\2"+
		"\u00958\3\2\2\2\u0096\u009a\5E#\2\u0097\u0099\5E#\2\u0098\u0097\3\2\2"+
		"\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b:"+
		"\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\5G$\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1<\3\2\2\2"+
		"\u00a2\u00a3\7\61\2\2\u00a3\u00a4\7\61\2\2\u00a4\u00a8\3\2\2\2\u00a5\u00a7"+
		"\13\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a9\3\2\2\2"+
		"\u00a8\u00a6\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac"+
		"\7\f\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\b\37\2\2\u00ae>\3\2\2\2\u00af"+
		"\u00b1\t\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\b \2\2\u00b5"+
		"@\3\2\2\2\u00b6\u00b7\4c|\2\u00b7B\3\2\2\2\u00b8\u00b9\4C\\\2\u00b9D\3"+
		"\2\2\2\u00ba\u00bd\5A!\2\u00bb\u00bd\5C\"\2\u00bc\u00ba\3\2\2\2\u00bc"+
		"\u00bb\3\2\2\2\u00bdF\3\2\2\2\u00be\u00bf\4\62;\2\u00bfH\3\2\2\2\b\2\u009a"+
		"\u00a0\u00a8\u00b2\u00bc\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}