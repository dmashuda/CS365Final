package com.mashuda.parallel.filter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dan on 4/20/15.
 */
public class ResultSubset<T> {
    private Integer start;
    private Integer end;
    private List<T> results;

    public ResultSubset() {
        start = 0;
        end = 0;
        results = new LinkedList<>();
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
