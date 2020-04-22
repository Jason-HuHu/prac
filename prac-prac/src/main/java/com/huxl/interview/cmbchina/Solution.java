package com.huxl.interview.cmbchina;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        if (str == null) {
            return;
        }
        char[] arr = str.toCharArray();
        List<Character> starList = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        for (char e : arr) {
            if (e == '*') {
                starList.add(e);
            }else {
                list.add(e);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character star : starList) {
            sb.append(star);
        }
        for (Character e : list) {
            sb.append(e);
        }
        System.out.println(sb.toString());
    }
}
