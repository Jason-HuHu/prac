package com.huxl.value;

import java.util.Comparator;
import java.util.Date;

public class Person implements Comparable<Person>{
    private int id;
    private Date birthday;

    public Person(){}
    public Person(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Person person) {
        return -person.id;
    }

//    @Override
    public int compare(Person person1, Person person2) {

        return (person1.id-person2.id);
    }
}
