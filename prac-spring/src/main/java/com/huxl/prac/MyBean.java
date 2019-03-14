package com.huxl.prac;

/**
 * 自定义bean
 *
 * @author xiaoh
 * @since 2019/3/12 9:43
 */
public class MyBean {
    private String name;

    public MyBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
