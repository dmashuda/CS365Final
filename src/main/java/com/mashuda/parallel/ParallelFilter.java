package com.mashuda.parallel;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by dan on 4/19/15.
 */
public class ParallelFilter<T> {
    private Integer numThreads;
    private LinkedBlockingQueue<ResultSubset> complete;
    private LinkedBlockingQueue<WorkRange> workQueue;

    private FilterWorker[] workers;
    private Thread[] threads;

    public ParallelFilter(){
        numThreads = Runtime.getRuntime().availableProcessors();
        complete = new LinkedBlockingQueue<>();
        workQueue = new LinkedBlockingQueue<>();
        workers = new FilterWorker[numThreads];
        threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++){
            workers[i] = new FilterWorker(workQueue, complete);
            threads[i] = new Thread(workers[i]);
            threads[i].start();
        }
    }


    public List<T> filter(List<T> list, BaseFilter<T> filter){
        WorkStep<T> chunk  = new WorkStep<>(list, filter);
        Integer listSize = list.size();
        Integer chunkSize = listSize / numThreads;

        for (FilterWorker f: workers){
            f.setWorkStep(chunk);
        }

        for (int i = 0; i < numThreads; i++){
            int start = i * chunkSize;
            int end = start + chunkSize;
            if (i == numThreads-1){
                end = listSize;
            }
            WorkRange r = new WorkRange(start, end);
            workQueue.add(r);
        }

        List<T> results = new LinkedList<>();
        for (int i = 0; i < numThreads; i++){
            try {
                ResultSubset subset = complete.take();
                results.addAll(subset.getResults());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return results;
    }


    public void close() throws InterruptedException {
        for (int i = 0; i< numThreads; i++) {
            workQueue.add(new WorkRange(-1, -1));
        }

        for (int i = 0; i< numThreads; i++) {
            threads[i].join();
        }

    }
}
