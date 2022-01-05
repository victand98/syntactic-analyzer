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
                        result += lexer.lexeme + "\t NO RECOGNIZED SYMBOL";
                        break;
                    case ADD:
                        result += lexer.lexeme + "\t ADD";
                        break;
                    case MINUS:
                        result += lexer.lexeme + "\t MINUS";
                        break;
                    case INCREMENT:
                        result += lexer.lexeme + "\t INCREMENT";
                        break;
                    case PRODUCT:
                        result += lexer.lexeme + "\t PRODUCT";
                        break;
                    case NUMBER:
                        result += lexer.lexeme + "\t NUMBER";
                        break;
                    case IDENTIFIER:
                        result += lexer.lexeme + "\t IDENTIFIER";
                        break;
                    case EQUAL:
                        result += lexer.lexeme + "\t EQUAL";
                        break;
                    case KEYWORD:
                        result += lexer.lexeme + "\t KEYWORD";
                        break;
                    case SEMICOLON:
                        result += lexer.lexeme + "\t SEMICOLON";
                        break;

                    default:
                        break;
                }

                System.out.println(result);
                result = "";
            }

        } catch (Exception e) {
            System.out.println("ERROR\n" + e.toString());
        }
    }

    public static void generateFile() {
        try {
            String[] files = { (path + "Lexer.flex") };
            Main.generate(files);
        } catch (Exception e) {
            System.out.println("Error generating file.");
        }
    }
}
