package com.mashuda.parallel.filter;

/**
 * Created by dan on 4/20/15.
 */
public interface BaseFilter<T> {
    public Boolean applyFilter(T val);
}
