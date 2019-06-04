package com.huxl.interview.offer;

import java.util.Stack;

/**
 * 利用两个栈实现队列
 *
 * @author huxl
 * @since 2019/5/14 11:34
 */
public class TwoStackToQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
