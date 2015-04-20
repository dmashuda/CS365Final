package benchmarks.lengthCheck;

import benchmarks.Benchmark;
import com.mashuda.parallel.ParallelFilter;

import java.util.List;

/**
 * Created by dan on 4/18/15.
 */
public class ParallelFilterLenNoOverhead extends Benchmark<String, Integer> {

    ParallelFilter<String> filter;

    @Override
    protected void doWork(List<String> list, Integer val) {
        List<String> results = filter.filter(list, currentVal -> currentVal.length() > val);
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
