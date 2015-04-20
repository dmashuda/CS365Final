package benchmarks;

import java.util.List;

/**
 * Created by dan on 4/18/15.
 */
public abstract class Benchmark<T, V> {

    protected abstract void doWork(List<T> list, V val);

    protected abstract void setUp();
    protected abstract void tearDown();

    public long runBenchMark(List<T> list, V val){
        setUp();
        System.gc();
        long before = System.currentTimeMillis();
        doWork(list, val);
        long after = System.currentTimeMillis();
        tearDown();
        return  after - before;
    }


}
