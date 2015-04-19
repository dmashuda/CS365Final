package benchmarks;

import java.util.List;

/**
 * Created by dan on 4/18/15.
 */
public abstract class Benchmark<T> {

    protected abstract void doWork(List<T> list, T val);

    protected abstract void setUp();

    public long runBenchMark(List<T> list, T val){
        setUp();
        System.gc();
        long before = System.currentTimeMillis();
        doWork(list, val);
        long after = System.currentTimeMillis();

        return  after - before;
    }
}
