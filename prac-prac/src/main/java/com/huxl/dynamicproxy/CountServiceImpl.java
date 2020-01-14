package com.huxl.dynamicproxy;

/**
 *
 * @author huxingl
 * @since 2018/8/8 14:25
 */


public class CountServiceImpl implements CountService {
    private int count = 0;
    @Override
    public int count() {
        return count++;
    }
}
