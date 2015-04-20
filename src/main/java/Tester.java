import benchmarks.contains.*;
import file.util.Dictionary;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dan on 4/16/15.
 */
public class Tester {
    public static void main (String args[]) throws IOException {

        String filePath = ClassLoader.getSystemResource("Dictionary.txt").getPath();
        List<String> dictionary = Dictionary.loadFile(filePath);

        List<String> benchList = new LinkedList<>();

        StreamsContains streamBench = new StreamsContains();
        ParallelFilterContains parallelFilterBench = new ParallelFilterContains();
        ParallelFilterContainsNoOverhead parallelFilterContainsNoOverhead = new ParallelFilterContainsNoOverhead();
        ParallelStreamsContains parStreamBench = new ParallelStreamsContains();
        LoopContains loopBench = new LoopContains();


        for (int testSize = 1; testSize < 10000; testSize *= 10) {
            benchList.clear();
            for (int i = 0; i < testSize; i++) {
                benchList.addAll(dictionary);
            }
            System.out.println("Size: " +benchList.size());
           // System.out.println("Stream: "+ streamBench.runBenchMark(benchList, "special")+"ms");
            System.out.println("Parallel: "+ parallelFilterBench.runBenchMark(benchList, "special")+"ms");
            System.out.println("Parallel No Overhead: "+ parallelFilterContainsNoOverhead.runBenchMark(benchList, "special")+"ms");
            System.out.println("ParStream: "+ parStreamBench.runBenchMark(benchList, "special")+"ms");
            //System.out.println("For Loop: " + loopBench.runBenchMark(benchList, "special")+"ms");
            System.out.println();
        }

    }
}
