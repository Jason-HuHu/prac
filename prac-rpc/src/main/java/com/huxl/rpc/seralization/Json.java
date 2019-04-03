package com.huxl.rpc.seralization;

import com.alibaba.fastjson.JSON;

/**
 * @author huxl
 * @createDate 2017/10/30 16:18
 */
public class Json {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("name1");
        person.setAge(23);

        //JSON对象序列化
        String personJson =null;
        personJson = JSON.toJSONString(person);
        System.out.println(personJson);

        //反序列化
        Person obj = JSON.parseObject(personJson,Person.class);
        System.out.println(obj.getName());
    }
}
