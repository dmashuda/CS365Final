package benchmarks.lengthCheck;

import benchmarks.Benchmark;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dan on 4/18/15.
 */
public class ParallelStreamsLen extends Benchmark<String, Integer> {

    @Override
    protected void doWork(List<String> list, Integer val) {
        List results = list.parallelStream().filter(e -> e.length() > val).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    protected void setUp() {

    }

    @Override
    protected void tearDown() {

    }
}
