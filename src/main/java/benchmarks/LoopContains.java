package benchmarks;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dan on 4/18/15.
 */
public class LoopContains extends Benchmark<String> {

    @Override
    public void doWork(List<String> list, String val) {
        List<String> newList = new LinkedList<>();
        for (String s: list){
            if (s.contains(val)){
                newList.add(s);
            }
        }

    }
}
