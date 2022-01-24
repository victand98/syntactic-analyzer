package syntactic;

import java.io.StringReader;

import java_cup.runtime.Symbol;

public class Syntactic {

    public static void main(String[] args) {
        String code = "INTEGER imprimir(){\n STRING a; INTEGER a = 9;}";
        Syntax syntax = new Syntax(new LexerCup(new StringReader(code)));
        Symbol aux = null;
        try {
            aux = syntax.parse();
            System.out.println("The code has been successfully executed");
        } catch (Exception e) {
            System.out.println("ERROR:\n" + e.toString());
            Symbol sym = syntax.getS();
            System.out.println("Syntax error in the line " + (sym.right + 1) + " column " + (sym.left + 1)
                    + "; Wrong syntax: " + sym.value);

        }
    }
}
