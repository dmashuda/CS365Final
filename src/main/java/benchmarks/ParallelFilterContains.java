package benchmarks;

import com.mashuda.parallel.ParallelFilter;

import java.util.List;

/**
 * Created by dan on 4/18/15.
 */
public class ParallelFilterContains extends Benchmark<String> {

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
