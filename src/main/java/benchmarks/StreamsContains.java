package benchmarks;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dan on 4/18/15.
 */
public class StreamsContains extends Benchmark<String> {

    @Override
    protected void doWork(List<String> list, String val) {
        list.stream().filter(e -> e.contains(val)).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    protected void setUp() {

    }

    @Override
    protected void tearDown() {

    }
}
