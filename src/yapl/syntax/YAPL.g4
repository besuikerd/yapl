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

program: statement*;

statement:
  (declaration | assignment) SEMICOLON
;

declaration: 
    VAR id COLON typeDenoter
 |  CONST id EQ expression
;

assignment:
  id EQ expression
;

expression:
    LCURLY statement* ret RCURLY
  | orExpr
;


ret:
  RETURN expression SEMICOLON
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

operand:
    id (LPAREN expression (COMMA expression)* RPAREN)?
  | number
  | LPAREN expression RPAREN
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