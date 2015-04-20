package benchmarks.lengthCheck;

import benchmarks.Benchmark;
import com.mashuda.parallel.ParallelFilter;

import java.util.List;

/**
 * Created by dan on 4/18/15.
 */
public class ParallelFilterLen extends Benchmark<String, Integer> {


    @Override
    protected void doWork(List<String> list, Integer val) {
        ParallelFilter<String> filter = new ParallelFilter<>();
        List<String> results = filter.filter(list, currentVal -> currentVal.length() > val);
        try {
            filter.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void setUp() {

    }

    @Override
    protected void tearDown() {

    }
}
