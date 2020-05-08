package com.huxl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 */
public class PalindromeLinkedListDemo {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        boolean r = new PalindromeLinkedListDemo().isPalindrome(head);
        System.out.println(r);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val);
        for (int i = 0; i < list.size()/2; i++) {
            if (!list.get(i).equals(list.get(list.size() -i -1))) {
                return false;
            }
        }
        return true;

    }
}

