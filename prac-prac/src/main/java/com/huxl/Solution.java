package com.huxl;




import java.util.ArrayList;
import java.util.List;

/**
 * TODO..
 *
 * @author huxingl
 * @since 2018/8/30 15:35
 */


public class Solution {
    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer(" we are jhhh");
//        System.out.println(new Solution().replaceSpace(sb));
        
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        
        new Solution().printListFromTailToHead(node);
    }
    
    public String replaceSpace(StringBuffer str) {
        System.out.println(str.reverse());
        return str.toString().replaceAll(" ","%20");
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(listNode.val);
        while (listNode.next != null) {
            tmp.add(listNode.next.val);
            listNode = listNode.next;
        }
        //从头到尾返回
        Object[] temRes = tmp.toArray();
        int i = temRes.length -1;
        while (i >=0) {
            result.add((Integer) temRes[i]);
        }
        return result;
        
    }
    
    
    private static class ListNode{
        int val;
        ListNode next = null;
        
        ListNode(int val){
            this.val = val;
        }
    }
}
