package benchmarks.contains;

import benchmarks.Benchmark;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dan on 4/18/15.
 */
public class LoopContains extends Benchmark<String, String> {

    @Override
    protected void doWork(List<String> list, String val) {
        List<String> newList = new LinkedList<>();
        for (String s: list){
            if (s.contains(val)){
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
