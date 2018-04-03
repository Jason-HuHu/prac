package com.huxl.designpattern.builder;

/**
 * 实现Packing接口的实体类
 * @author huxl
 * @since 2018/3/22 11:27
 */
public class Wrapper implements Packing{
    @Override
    public String pack() {
        return "Wrapper";
    }
}
