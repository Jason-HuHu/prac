package com.huxl.leetcode;

/**
 * 反转链表
 */
public class ReverseLinkedListDemo {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
//        ListNode prev = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode nexTemp = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = nexTemp;
//        }
//        return prev;
        ListNode cur = reverseList(head.next);
        cur.next.next = head;
        cur.next = null;
        return cur;

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
