package com.huxl.seralization;

import java.io.Serializable;

/**
 * @author huxl
 * @createDate 2017/10/30 9:34
 */
public class Person implements Serializable{
    private String name;
    private Integer age;
    public Person() {}
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}