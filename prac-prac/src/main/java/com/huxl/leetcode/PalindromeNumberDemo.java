package com.huxl.leetcode;

/**
 * 回文数
 */
public class PalindromeNumberDemo {
    public static void main(String[] args) {
        boolean r = new PalindromeNumberDemo().isPalindrome(121);
        System.out.println(r);
    }

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        if (arr[arr.length-1] == '0') {
            return false;
        }
        for(int i=arr.length -1 ; i >= 0;i--) {
            sb.append(arr[i]);
        }
        if (str.equals(sb.toString())) {
            return true;
        }
        return false;
    }
}
