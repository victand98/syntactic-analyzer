package src.syntactic;

import java.io.File;

public class CreateFile {
    public static void main(String[] args) {
        String path = "src" + File.separatorChar + "syntactic" + File.separatorChar + "data" + File.separatorChar;

        String[] paths = { path + "Lexer.flex" };
        try {
            jflex.Main.generate(paths);
        } catch (Exception e) {
            System.out.println("An error occurred while generating the file\n" + e.toString());
        }

    }
}
