grammar YAPL;

options {
  language = Java;
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

//virtual keywords
PROGRAM   : 'program';

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

program: statement*;

statement: 
  (declaration | expression) SEMICOLON
;

declaration: 
    VAR id COLON typeDenoter
 |  CONST id EQ expression
;

expression:
	exprconstruct (EQ expression)?
;

exprconstruct :
	  LCURLY statement* ret RCURLY
	| orExpr
//  	| WHILE expression DO (expression SEMICOLON)* END
;

ret:
  RETURN expression SEMICOLON
;

operand:
  id (LPAREN expression (COMMA expression)* RPAREN)?
  | number
  | LPAREN expression RPAREN
//  | IF expression THEN expression (ELSE expression)? END
;


primaryExpr:
  (PLUS | MINUS | LNOT)? operand
;

multDivModExpr:
  primaryExpr ((MULT | DIV | MOD) primaryExpr)*
;

plusMinusExpr:
  multDivModExpr ((PLUS | MINUS) multDivModExpr)*
;

compareExpr:
  plusMinusExpr ((GT | GTE | LT | LTE | LEQ | LNEQ) plusMinusExpr)*
;

andExpr:
  compareExpr (LAND compareExpr)*
;

orExpr:
  andExpr (LOR andExpr)*
;

id:
  IDENTIFIER
;

number:
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