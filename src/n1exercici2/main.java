package n1exercici2;

import java.io.IOException;
import java.nio.file.*;

public class main {

    public static void main(String[] args) {
        Path startingDir = Paths.get(args[0]);

        try {
            Files.walkFileTree(startingDir, new PrintFiles());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
