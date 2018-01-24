package com.huxl.spring_base.aop;

import org.aspectj.lang.JoinPoint;

/**
 * @author huxl
 * @createDate 2018/1/17 10:45
 */
public class ServicePointCut {


    public void doBefore(JoinPoint point) {
        System.out.println("猴子开始偷桃子了。。。");
    }
    public void doAfter(JoinPoint point) {
        System.out.println(point.getArgs());
        System.out.println("猴子偷完桃子了。。。");
    }
}
