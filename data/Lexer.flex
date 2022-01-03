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
 /* identifiers */
{space} {/*Ignore*/}
"//".* {/*Ignore*/}
"INTEGER" {lexeme=yytext(); return Tokens.KEYWORD;}
"class" {lexeme=yytext(); return Tokens.KEYWORD;}
{Identifier} {lexeme=yytext(); return Tokens.IDENTIFIER;}
"=" {lexeme=yytext(); return Tokens.EQUAL;}
"+" {lexeme=yytext(); return Tokens.ADD;}
"-" {lexeme=yytext(); return Tokens.MINUS;}
"*" {lexeme=yytext(); return Tokens.PRODUCT;}
"++" {lexeme=yytext(); return Tokens.INCREMENT;}
{D}+ {lexeme=yytext(); return Tokens.NUMBER;}
 . {lexeme=yytext(); return Tokens.ERROR;}
