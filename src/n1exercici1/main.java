package n1exercici1;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        Path dir = Paths.get(args[0]);

        List<Path> files = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file: stream) {
                files.add(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException x) {
            System.err.println(x);
        }
        files.listIterator().forEachRemaining(System.out::println);
    }
}
