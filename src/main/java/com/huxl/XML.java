package com.huxl;

import com.huxl.seralization.Person;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author huxl
 * @createDate 2017/10/30 16:36
 */
public class XML {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("name1");
        person.setAge(23);

        XStream xStream = new XStream(new DomDriver());
        //设置person类的别名
        xStream.alias("person1",Person.class);
        String personXML = xStream.toXML(person);
        System.out.println(personXML);
    }
}
