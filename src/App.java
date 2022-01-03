package src;

import java.io.File;
import java.io.FileReader;

import jflex.Main;
import src.model.Tokens;

public class App {
    public static String path = "data" + File.separatorChar;

    public static void main(String[] args) throws Exception {
        // move the result to src path
        // only execute this once
        // generateFile();

        try {
            Lexer lexer = new Lexer(new FileReader(path + "code.jcr"));
            String result = "";

            while (true) {
                Tokens token = lexer.yylex();
                if (token == null) {
                    result += "END";
                    break;
                }

                switch (token) {
                    case ERROR:
                        result += lexer.lexeme + " NO RECOGNIZED SYMBOL";
                        break;
                    case ADD:
                        result += lexer.lexeme + " ADD";
                        break;
                    case MINUS:
                        result += lexer.lexeme + " MINUS";
                        break;
                    case INCREMENT:
                        result += lexer.lexeme + " INCREMENT";
                        break;
                    case PRODUCT:
                        result += lexer.lexeme + " PRODUCT";
                        break;
                    case NUMBER:
                        result += lexer.lexeme + " NUMBER";
                        break;
                    case IDENTIFIER:
                        result += lexer.lexeme + " IDENTIFIER";
                        break;
                    case EQUAL:
                        result += lexer.lexeme + " EQUAL";
                        break;
                    case KEYWORD:
                        result += lexer.lexeme + " KEYWORD";
                        break;

                    default:
                        break;
                }

                System.out.println(result);
                result = "";
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR " + e.toString());
        }
    }

    public static void generateFile() {
        try {
            String[] files = { (path + "Lexer.flex") };

            Main.generate(files);
        } catch (Exception e) {
            System.out.println("Error en generar archivo.");
        }
    }
}
