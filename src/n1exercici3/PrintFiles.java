package n1exercici3;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class PrintFiles
        extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attr) throws IOException {
        printElement(file);
        return CONTINUE;
    }

    private static void printElement(Path path) throws IOException {
        if (Files.isDirectory(path) || Files.isRegularFile(path)) {
            if (Files.isDirectory(path))
                System.out.print("(D)" + "\t");
            else
                System.out.print("(F)" + "\t");
            System.out.print(path.getFileName() + "\t");
            System.out.println(Files.getLastModifiedTime(path));
        }
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        printElement(dir);
        return super.preVisitDirectory(dir, attrs);
    }


    @Override
    public FileVisitResult visitFileFailed(Path file,
                                           IOException exc) {
        System.err.println(exc);
        return CONTINUE;
    }
}
