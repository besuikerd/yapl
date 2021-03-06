grammar YAPL;

options {
  language = Java;
}

@header{
	import yapl.typing.Type;
	import yapl.context.IdEntry;
	import java.util.List;
}

SEMICOLON : ';';
COLON     : ':';
EQ        : '=';
LCURLY    : '{';
RCURLY    : '}';
LPAREN    : '(';
RPAREN    : ')';
AT        : '@';
COMMA     : ',';
LOR       : '||';
LAND      : '&&';
LEQ       : '==';
LNEQ      : '!=';
LNOT      : '!';
GT        : '>';
GTE       : '>=';
LT        : '<';
LTE       : '<=';
PLUS      : '+';
MINUS     : '-';
MULT      : '*';
DIV       : '/';
MOD       : '%';
APOSTROFE : '\'';

//keywords
VAR       : 'var';
CONST     : 'const';
RETURN    : 'return';
IF        : 'if';
THEN      : 'then';
ELSE      : 'else';
WHILE     : 'while';
DO        : 'do';
END       : 'end';
TRUE	  : 'true';
FALSE     : 'false';



yapl
: 
	statement*
;

statement
: 
    declaration SEMICOLON 		#statementDeclaration 
  | expression SEMICOLON 		#statementExpression
;

declaration locals[List<IdEntry> entries]
: 
    VAR id (COMMA id)* COLON typeDenoter	#declVar
 |  CONST id (COMMA id)* EQ expression		#declConst
;

expression locals[Type type]
:
	orExpr (EQ expression)?
;

operand
:
  id (LPAREN (expression (COMMA expression)*)? RPAREN)?	 		
							#opIdOrFunc
  | number						#opNumber
  | CHARLITERAL						#opChar
  | LPAREN expression RPAREN 				#opParenExpr
  | TRUE						#opTrue
  | FALSE						#opFalse
  | IF expression THEN expression (ELSE expression)? END
							#opIfThenElse
  | exprBlock						#opExprBlock
  | WHILE expression exprBlock				#opWhile
;

exprBlock:
	LCURLY statement* (RETURN expression SEMICOLON)? RCURLY
;

primaryExpr
:
  op=(PLUS | MINUS | LNOT)? operand
;

multDivModExpr
:
  primaryExpr (opMultDivMod primaryExpr)*
;

opMultDivMod: MULT | DIV | MOD;

plusMinusExpr
:
  multDivModExpr (opPlusMinus multDivModExpr)*
;

opPlusMinus: PLUS | MINUS;

compareExpr
:
  plusMinusExpr (opCompare plusMinusExpr)*
;

opCompare: GT | GTE | LT | LTE | LEQ | LNEQ;

andExpr
:
  compareExpr (LAND compareExpr)*
;

orExpr
:
  andExpr (LOR andExpr)*
;


id locals[IdEntry entry]
:
  IDENTIFIER
;


number
:
  NUMBER
;

typeDenoter: 
  IDENTIFIER
;

IDENTIFIER: 
  LETTER (LETTER|NUMBER)*
;

NUMBER:
  DIGIT+
;


COMMENT : ('//').*? '\n' -> skip;

WS : (' ' | '\t' | '\f' | '\r' | '\n')+ -> skip;

CHARLITERAL: '\'' SINGLECHAR '\'';

fragment SINGLECHAR :   ~['\\];

fragment LOWER  :   ('a'..'z') ;
fragment UPPER  :   ('A'..'Z') ;
fragment LETTER :   LOWER | UPPER;
fragment DIGIT  :   ('0'..'9') ;