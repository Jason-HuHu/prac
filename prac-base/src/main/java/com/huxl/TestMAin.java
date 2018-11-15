package com.huxl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO..
 *
 * @author huxingl
 * @since 2018/11/15 18:10
 */


public class TestMAin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.next();
        char[] lineArr = line.toCharArray();
        String result = "";
        char str = '*';
        String strlin = "";
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < lineArr.length; i++) {
            char a = lineArr[i];
            if (i == 0) {
                if (checkChar(a)) {
                    list.add(str);
                    list.add(a);
                }else {
                    list.add(a);
                }
                continue;
            }
            char b = lineArr[i-1];
            if (checkChar(b) && checkChar(a)) {
                list.add(a);
            } else {
                list.add(str);
                list.add(a);
            }
        }
        
        for (Character character : list) {
            System.out.print(character);
        }
    }
    
    public static boolean checkChar(char a) {
        int i = (int)a;
        if((i >= 65 && i <= 90) || (i>=97 && i<= 122)) {
            return true;
        }else {
            return false;
        }
    }
}
