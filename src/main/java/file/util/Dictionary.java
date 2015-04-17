package file.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by dan on 4/16/15.
 */
public class Dictionary {
    public static List<String> loadFile(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        return lines;
    }
}
