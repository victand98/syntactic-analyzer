package syntactic;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
Space=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
/* Spaces */
{Space} {/*ignore*/}

/* Comments */
("//"(.)*) {/*ignore*/}

/* Quotes */
("\"") {return new Symbol(sym.QUOTES, yychar, yyline, yytext());}

/* Data types */
(byte | char | long | float | double) {return new Symbol(sym.DATA_TYPE, yychar, yyline, yytext());}

/* Keywords */
(INTEGER) {return new Symbol(sym.INTEGER, yychar, yyline, yytext());}
(void) {return new Symbol(sym.VOID, yychar, yyline, yytext());}

/* String */
(STRING) {return new Symbol(sym.STRING, yychar, yyline, yytext());}

/* Operators */
("=") {return new Symbol(sym.EQUAL, yychar, yyline, yytext());}
("*") {return new Symbol(sym.PRODUCT, yychar, yyline, yytext());}
("+") {return new Symbol(sym.ADD, yychar, yyline, yytext());}
("-") {return new Symbol(sym.MINUS, yychar, yyline, yytext());}
("/") {return new Symbol(sym.DIVISION, yychar, yyline, yytext());}
("(") {return new Symbol(sym.OPENING_BRACKETS, yychar, yyline, yytext());}
(")") {return new Symbol(sym.CLOSING_BRACKETS, yychar, yyline, yytext());}
("{") {return new Symbol(sym.OPENING_KEYS, yychar, yyline, yytext());}
("}") {return new Symbol(sym.CLOSING_KEYS, yychar, yyline, yytext());}
(";") {return new Symbol(sym.SEMICOLON, yychar, yyline, yytext());}

/* Identifiers */
{L}({L}|{D})* {return new Symbol(sym.IDENTIFIER, yychar, yyline, yytext());}

/* Digits */
("(-"{D}+")")|{D}+ {return new Symbol(sym.NUMBER, yychar, yyline, yytext());}

/* Error */
. {return new Symbol(sym.ERROR, yychar, yyline, yytext());}