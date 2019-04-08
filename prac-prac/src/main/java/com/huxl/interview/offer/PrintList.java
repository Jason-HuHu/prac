package com.huxl.interview.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 剑指Offer：从尾到头打印链表
 *
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * @author huxl
 */
public class PrintList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);

        ArrayList<Integer> list = new PrintList().printListFromTailToHead(root);
        System.out.println(list);
    }

//    ArrayList<Integer> list = new ArrayList<>();
//
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//
//        //1.递归版本
//        if (listNode != null) {
//            list.add(listNode.val);
//            this.printListFromTailToHead(listNode.next);
//        }
//
//
//        return list;
//    }
    //2.利用API
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        int size = stack.size();
        for (int i = 0; i < size; i ++) {
            list.add(stack.pop());
        }

        return list;
    }


}

class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
