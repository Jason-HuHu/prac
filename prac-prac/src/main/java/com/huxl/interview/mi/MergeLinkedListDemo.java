package com.huxl.interview.mi;

public class MergeLinkedListDemo {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node h12 = head1.next = new Node(2);
        Node h13 = h12.next = new Node(3);
        h13.next = new Node(6);

        Node head2 = new Node(4);
        Node h22 = head2.next = new Node(5);
        Node h23 = h22.next = new Node(7);
        h23.next = new Node(22);
        Node root = merge(head1,head2);
        while (root != null){
            System.out.print(root.val + " ");
            root = root.next;
        }

    }

    private static Node merge(Node head1,Node head2){
        //迭代
        Node root = new Node(-1);
        Node pre = root;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                pre.next = head1;
                head1 = head1.next;
            }else {
                pre.next = head2;
                head2 = head2.next;
            }
            pre = pre.next;
        }
        if (head1 != null) {
            pre.next = head1;
        }
        if (head2 != null) {
            pre.next = head2;
        }
        return root.next;
    }

    private static Node recursiveMerge(Node head1, Node head2) {
        if (head1 ==null) {
            return head2;
        }else if (head2 == null) {
            return head1;
        }
        Node head;
        if (head1.val < head2.val) {
            head = head1;
            head.next = merge(head1.next,head2);
        }   else {
            head = head2;
            head.next = merge(head1,head2.next);
        }
        return head;
    }
}

class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
}
