package com.huxl.java8.chaptrer9;

/**
 * 相同方法签名 优先级
 * 父类优先 -> 本类 ->更具体的接口
 *
 * @author huxl
 * @since 2019/12/5-18:38
 */
public class DefaultMethodDemo {

    public static void main(String[] args) {
        //D 有实现则先D 未实现则 C
        new D().hello();
        new C().hello();
    }
}
