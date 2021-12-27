package n1exercici3;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class main {

    public static void main(String[] args) {
        Path startingDir = Paths.get(args[0]);

        try {
            System.setOut(new PrintStream(new File("result.txt")));
            Files.walkFileTree(startingDir, new PrintFiles());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
