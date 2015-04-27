package benchmarks.contains;

import benchmarks.Benchmark;
import com.mashuda.parallel.filter.ParallelFilter;

import java.util.List;

/**
 * Created by dan on 4/18/15.
 */
public class ParallelFilterContainsNoOverhead extends Benchmark<String, String> {

    ParallelFilter<String> filter;

    @Override
    protected void doWork(List<String> list, String val) {
        List<String> results = filter.filter(list, currentVal -> currentVal.contains(val));
    }

    @Override
    protected void setUp() {
        filter = new ParallelFilter<>();
    }

    @Override
    protected void tearDown() {
        try {
            filter.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
