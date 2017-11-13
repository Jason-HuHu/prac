package com.huxl.value;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setId(i);
            personList.add(person);
        }


        Main m = new Main();
        m.testCollectionsSort(personList);
    }
//    public static void main(String[] args) {
//        Person person = new Person();
//        Main m = new Main();
//        Person person1 = m.ChangePerson(person,1);
//        System.out.println(person.getId());
//    }
    private Person ChangePerson(Person person, int id) {
        person.setId(id);
        person.setBirthday(new Date());
        return person;
    }


    private void testCollectionsSort(List<Person> personList) {

        for (Person person: personList) {
            System.out.println(person.getId());
        }

        Collections.sort(personList);

        for (Person person: personList) {
            System.out.println(person.getId());
        }
    }
}
