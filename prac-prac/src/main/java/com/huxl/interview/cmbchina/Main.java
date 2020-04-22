package com.huxl.interview.cmbchina;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 1-23个数，求有多少个集合满足和为24
 输入
 5
 1 1 2 22 23

 输出
 3
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> line = new ArrayList<>(n);
        for (int i = 0; i <= n;i++ ) {
            line.add(in.nextInt());
        }
        int result = 0;
        int sum = 24;
        line.sort(Integer::compareTo);

        System.out.println(result);

    }
}

