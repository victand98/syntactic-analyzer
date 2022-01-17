package src;
import src.model.Tokens;

%%
%class Lexer
%type Tokens
D=[0-9]
space=[ ,\t,\r,\n]+
Identifier = [:jletter:] [:jletterdigit:]*

%{
    public String lexeme;
%}
%%
{space} {/*Ignore*/}
"//".* {/*Ignore*/}
/* Keywords */
"ENTERO" {lexeme=yytext(); return Tokens.KEYWORD;}
 /* Identifiers */
{Identifier} {lexeme=yytext(); return Tokens.IDENTIFIER;}
 /* Arithmetic operators */
"+" {lexeme=yytext(); return Tokens.ADD;}
"-" {lexeme=yytext(); return Tokens.MINUS;}
"*" {lexeme=yytext(); return Tokens.PRODUCT;}
"++" {lexeme=yytext(); return Tokens.INCREMENT;}
 /* Symbols */
"=" {lexeme=yytext(); return Tokens.EQUAL;}
";" {lexeme=yytext(); return Tokens.SEMICOLON;}
 /* Numbers */
{D}+ {lexeme=yytext(); return Tokens.NUMBER;}
 /* Default Error */
 . {lexeme=yytext(); return Tokens.ERROR;}
