package n1exercici4;

import java.nio.file.Path;
import java.util.Optional;

public class ReadTxt {
    public static String findExtension(Path startingDir) {
        String fileName = startingDir.getFileName().toString();
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex == -1) {
            return "";
        }
        return fileName.substring(lastIndex + 1);
    }


}
