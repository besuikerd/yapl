grammar YAPL;

options {
  language = Java;
}

@header{
	import yapl.typing.Type;
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
  (declaration | expression) SEMICOLON
;

declaration locals[Type type]
: 
    VAR id COLON typeDenoter									#declVar
 |  CONST id EQ expression										#declConst
;

expression:
	orExpr (EQ expression)?
;

operand
:
  id (LPAREN (expression (COMMA expression)*)? RPAREN)? 		#opIdOrFunc
  | number														#opNumber
  | LPAREN expression RPAREN 									#opParenExpr
  | TRUE														#opTrue
  | FALSE														#opFalse
  | IF expression THEN expression (ELSE expression)?	 		#opIfThenElse
  | LCURLY statement* RETURN expression SEMICOLON RCURLY		#opExprBlock
  | WHILE expression DO (expression SEMICOLON)* END				#opWhile
;

primaryExpr
:
  op=(PLUS | MINUS | LNOT)? operand
;

multDivModExpr
:
  primaryExpr (op=(MULT | DIV | MOD) multDivModExpr)?
;

plusMinusExpr
:
  multDivModExpr (op=(PLUS | MINUS) plusMinusExpr)?
;

compareExpr
:
  plusMinusExpr (op=(GT | GTE | LT | LTE | LEQ | LNEQ) compareExpr)?
;

andExpr
:
  compareExpr (op=LAND andExpr)?
;

orExpr
:
  andExpr (op=LOR orExpr)?
;

id locals[DeclarationContext ctx]
:
  IDENTIFIER
;


number locals[int value = 0]
:
  NUMBER
;

typeDenoter: 
  IDENTIFIER
;

IDENTIFIER: 
  LETTER LETTER*
;

NUMBER:
  DIGIT+
;

COMMENT : ('//').*? '\n' -> skip;

WS : (' ' | '\t' | '\f' | '\r' | '\n')+ -> skip;

fragment LOWER  :   ('a'..'z') ;
fragment UPPER  :   ('A'..'Z') ;
fragment LETTER :   LOWER | UPPER ;
fragment DIGIT  :   ('0'..'9') ;