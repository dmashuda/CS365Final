package com.mashuda.parallel;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dan on 4/19/15.
 */
public class FilterWorker<T> implements Runnable {

    LinkedBlockingQueue<WorkRange> workIn;
    AtomicInteger numComplete;
    List<T> results;
    WorkStep<T> workStep;


    public FilterWorker(LinkedBlockingQueue workIn, AtomicInteger numComplete){
        this.workIn = workIn;
        this.numComplete = numComplete;
    }

    @Override
    public void run() {

        while (true){
            WorkRange currentRange = workIn.poll();
            if (currentRange.getEnd() == currentRange.getStart()){
                return;
            }

            if (workStep == null){
                throw new IllegalStateException("Must specify a work step before inputting range");
            }

            results = new LinkedList<>();

            ListIterator<T> listIterator = workStep.getValues().listIterator(currentRange.getStart());

            while (listIterator.hasNext() && listIterator.nextIndex() <= currentRange.getEnd()){
                T val = listIterator.next();
                if (workStep.getFilter().applyFilter(val)){
                    results.add(val);
                }
            }

            numComplete.incrementAndGet();

        }

    }

    public void setWorkStep(WorkStep<T> workStep) {
        if (!workIn.isEmpty()){
            throw new IllegalStateException("Don't set the work step until processing is complete for last job");
        }
        this.workStep = workStep;
    }

    public List<T> getResults() {
        if (!workIn.isEmpty()){
            throw new IllegalStateException("Don't get results until the processing is finished");
        }
        numComplete.set(0);
        return results;
    }
}
