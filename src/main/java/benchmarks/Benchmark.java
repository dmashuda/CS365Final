package benchmarks;

import java.util.List;

/**
 * Created by dan on 4/18/15.
 */
public abstract class Benchmark<T> {

    public abstract void doWork(List<T> list, T val);

    public long runBenchMark(List<T> list, T val){
        System.gc();
        long before = System.currentTimeMillis();
        doWork(list, val);
        long after = System.currentTimeMillis();

        return  after - before;
    }
}
