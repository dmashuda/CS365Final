package benchmarks.lengthCheck;

import benchmarks.Benchmark;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dan on 4/18/15.
 */
public class LoopLen extends Benchmark<String, Integer> {

    @Override
    protected void doWork(List<String> list, Integer val) {
        List<String> newList = new LinkedList<>();
        for (String s: list){
            if (s.length() > val){
                newList.add(s);
            }
        }

    }

    @Override
    protected void setUp() {

    }

    @Override
    protected void tearDown() {

    }
}
