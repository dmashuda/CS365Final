package com.mashuda.parallel;

/**
 * Created by dan on 4/19/15.
 */
public class WorkRange {
    private Integer start;
    private Integer end;

    public WorkRange(Integer end, Integer start) {
        this.end = end;
        this.start = start;
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
}
