package com.huxl.interview.cmbchina;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        String str = "google";
        int a = new Solution2().FirstNotRepeatingChar2(str);
        System.out.println(a);
    }

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        if (str.length() == 1) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            char c = str.charAt(i);
            for (int j = 0; j < str.length(); j++) {
                if (c == str.charAt(j))
                count ++;
            }
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingChar2(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        if (str.length() == 1) {
            return 0;
        }
        //用来保存已经出现过重复的字母
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            char c = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (c == str.charAt(j)) {
                    count++;
                    set.add(c);
                }

            }
            if (count == 0  && !set.contains(c)) {
                return i;
            }
        }
        return -1;
    }

}
