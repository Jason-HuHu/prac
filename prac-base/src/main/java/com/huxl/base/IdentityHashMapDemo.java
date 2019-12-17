package com.huxl.base;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Identity
 * n.	身份; 本身; 本体; 特征; 特有的感觉(或信仰); 同一性; 相同; 一致;
 * 键 可以重复
 *
 * @author huxl
 * @since 2019/12/13-15:52
 */
public class IdentityHashMapDemo {

    public static void main(String[] args) {

        Map<Object,String> objHashMap = new HashMap<>();

        objHashMap.put(new Object(),"1");
        objHashMap.put(new Object(),"1");
        objHashMap.put(new Object(),"1");
        objHashMap.put(new Object(),"1");

        System.out.println("objHashMap:" + objHashMap.size());

        Map<Object,String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(new Object(),"1");
        identityHashMap.put(new Object(),"1");
        identityHashMap.put(new Object(),"1");
        identityHashMap.put(new Object(),"1");


        System.out.println("identityHashMap:" +identityHashMap.size());

    }


}
