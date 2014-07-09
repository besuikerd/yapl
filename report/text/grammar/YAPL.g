grammar YAPL;

options {
  language = Java;
  output=AST;
  k=1;
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
    declaration SEMICOLON 										 
  | expression SEMICOLON 										
;

declaration 
: 
    VAR id (COMMA id)* COLON typeDenoter						
 |  CONST id (COMMA id)* EQ expression							
;

expression 
:
	orExpr (EQ expression)?
;

operand
:
  id (LPAREN (expression (COMMA expression)*)? RPAREN)?	 		
  | number					 									
  | CHARLITERAL													
  | LPAREN expression RPAREN 									
  | TRUE														
  | FALSE														
  | IF expression THEN expression (ELSE expression)? END 		
  | exprBlock													
  | WHILE expression exprBlock									
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


id 
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


COMMENT
    :   '//' .* '\n' 
            { $channel=HIDDEN; }
    ;

WS
    :   (' ' | '\t' | '\f' | '\r' | '\n')+
            { $channel=HIDDEN; }
    ;
	
CHARLITERAL: '\'' SINGLECHAR '\'';

fragment SINGLECHAR :   LETTER | DIGIT;

fragment LOWER  :   ('a'..'z') ;
fragment UPPER  :   ('A'..'Z') ;
fragment LETTER :   LOWER | UPPER;
fragment DIGIT  :   ('0'..'9') ;