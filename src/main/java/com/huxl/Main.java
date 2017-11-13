package com.huxl;

import com.huxl.value.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huxl
 * @createDate 2017/11/3 16:06
 */
public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        List<Person> list1 = new ArrayList<>();
        list1.add(new Person(1));
        list1.add(new Person(2));
        list1.add(new Person(3));
        list1.add(new Person(4));
        List<Person> list2 = new ArrayList<>();
        list2.add(new Person(5));
        list2.add(new Person(6));
        list2.add(new Person(7));
        list2.add(null);
        list2.add(new Person(8));

        list2.add(null);
        list2.add(null);

        personList.addAll(list1);
        personList.addAll(list2);
//        System.out.println(personList.size() + personList.toArray().toString());
        Bean bean = new Bean();
//        bean.getBeanId();
        System.out.println(bean.getBeanId());
        long id = bean.getId();
        System.out.println(id);
    }
}
