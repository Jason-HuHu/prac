package com.huxl.designpattern.strategy;

import com.huxl.designpattern.strategy.operation.OperationAdd;
import com.huxl.designpattern.strategy.operation.OperationMultiply;

/**
 * 策略模式 ： 一个类的行为或算法可以在运行时更改
 *  在策略模式中，我们创建表示各种策略的对象和一个行为随着策略对象改变而改变的context对象，策略对象改变
 *  contex对象的执行算法
 *
 *  主要解决问题 ： 在有多种算法相似的情况下，使用if..else分支过多会太复杂并且难以维护
 * @author huxl
 * @since 2018/3/23 10:15
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        //使用context 来观察不同策略时的执行结果
        Context context = new Context(new OperationAdd());
        System.out.println("5＋10 =" + context.executeStratge(5,20));
        context = new Context(new OperationMultiply());
        System.out.println("5 * 10 = " + context.executeStratge(5,10));
    }
}
