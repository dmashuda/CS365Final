package benchmarks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dan on 4/18/15.
 */
public class ParallelStreamsContains extends Benchmark<String> {

    @Override
    protected void doWork(List<String> list, String val) {
        List results = list.parallelStream().filter(e -> e.contains(val)).collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Size java: " + results.size());

    }

    @Override
    protected void setUp() {

    }

    @Override
    protected void tearDown() {

    }
}
