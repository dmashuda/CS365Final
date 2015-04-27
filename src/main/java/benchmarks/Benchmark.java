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
        int num_average = 10;

        long total = 0;

        for (int i = 0; i<num_average;i++){
            total += testWork(list, val)/num_average;
        }

        return total;

    }

    private long testWork(List<T> list, V val){
        setUp();
        System.gc();
        long before = System.currentTimeMillis();
        doWork(list, val);
        long after = System.currentTimeMillis();
        tearDown();
        return  after - before;
    }


}
