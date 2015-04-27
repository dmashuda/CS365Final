package com.mashuda.parallel.filter;

import com.mashuda.parallel.WorkRange;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by dan on 4/19/15.
 */
public class FilterWorker<T> implements Runnable {

    private LinkedBlockingQueue<WorkRange> workIn;
    private LinkedBlockingQueue<ResultSubset> complete;
    private List<T> results;
    private WorkStep<T> workStep;


    public FilterWorker(LinkedBlockingQueue workIn, LinkedBlockingQueue complete){
        this.workIn = workIn;
        this.complete = complete;
    }

    @Override
    public void run() {

        while (true){
            WorkRange currentRange = null;
            try {
                currentRange = workIn.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (currentRange.getEnd() == currentRange.getStart()){
                return;
            }


            if (workStep == null){
                throw new IllegalStateException("Must specify a work step before inputting range");
            }

            results = new LinkedList<>();

            ListIterator<T> listIterator = workStep.getValues().listIterator(currentRange.getStart());
            BaseFilter<T> filter = workStep.getFilter();

            while (listIterator.hasNext() && listIterator.nextIndex() < currentRange.getEnd()){
                T val = listIterator.next();
                if (filter.applyFilter(val)){
                    results.add(val);
                }
            }

            ResultSubset subset = new ResultSubset();

            subset.setStart(currentRange.getStart());
            subset.setEnd(currentRange.getEnd());
            subset.setResults(results);

            try {
                complete.put(subset);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }

    public void setWorkStep(WorkStep<T> workStep) {
        if (!workIn.isEmpty()){
            throw new IllegalStateException("Don't set the work step until processing is complete for last job");
        }
        this.workStep = workStep;
    }

}
