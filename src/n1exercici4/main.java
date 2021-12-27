package n1exercici4;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static n1exercici4.ReadTxt.findExtension;

public class main {

    public static void main(String[] args) {
        Path path = Paths.get(args[0]);

        try {
            if (Files.isDirectory(path)) {
                System.setOut(new PrintStream(new File("result.txt")));
                Files.walkFileTree(path, new PrintFiles());
            } else if (findExtension(path).toString().equals("txt")) {
                readFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

}

