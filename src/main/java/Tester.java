import file.util.Dictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dan on 4/16/15.
 */
public class Tester {
    public static void main (String args[]) throws IOException {

        String filePath = ClassLoader.getSystemResource("Dictionary.txt").getPath();
        List<String> words = Dictionary.loadFile(filePath);


        long beforepar = System.currentTimeMillis();

        List<String> parstream = words.stream().filter(e -> e.contains("special")).collect(Collectors.toCollection(ArrayList::new));
        long afterpar = System.currentTimeMillis();

        List<String> streamsResults = words.stream().parallel().filter(e -> e.contains("special")).collect(Collectors.toCollection(ArrayList::new));
        long afterseq = System.currentTimeMillis();

        long par = afterpar - beforepar;
        long seq = afterseq - beforepar;

        System.out.println("Par: "+ par);
        System.out.println("Seq: "+ seq);

    }
}
