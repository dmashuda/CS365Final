package com.mashuda.parallel.filter;

import java.util.List;

/**
 * Created by dan on 4/20/15.
 */
public class WorkStep<T> {

    private List<T> values;
    private BaseFilter<T> filter;

    public WorkStep(List<T> values, BaseFilter<T> filter) {
        this.values = values;
        this.filter = filter;
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }

    public BaseFilter<T> getFilter() {
        return filter;
    }

    public void setFilter(BaseFilter<T> filter) {
        this.filter = filter;
    }
}
