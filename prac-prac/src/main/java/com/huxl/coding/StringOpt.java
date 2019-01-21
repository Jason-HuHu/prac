package com.huxl.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入一个字符串，要求在所有字母子串前后加上 “*”后输出
 * 例子
 * 输入：123asdsa3444dsfdsfsd33
 * 输出：123*asdsa*3444*dsfdsfsd*33
 */
public class StringOpt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Character star = '*';
        char[] chars = str.toCharArray();
        List<Character> resultList = new ArrayList<>();
        boolean beforeChar = false;
        if (checkLetter(chars[0])) {
            resultList.add(star);
            resultList.add(chars[0]);
            beforeChar = true;
        } else {
            resultList.add(chars[0]);
        }
        for (int i =1 ; i < chars.length ; i++) {
            char a = chars[(i)];
            if (beforeChar){
                if (checkLetter(a)) {
                    resultList.add(a);
                    beforeChar = true;
                } else {
                    resultList.add(star);
                    resultList.add(a);
                    beforeChar = false;
                }

            } else {
                if (!checkLetter(a)) {
                    resultList.add(a);
                    beforeChar = false;
                }
                if (checkLetter(a)){
                    resultList.add(star);
                    resultList.add(a);
                    beforeChar = true;
                }
            }


        }
        if (beforeChar) {
            resultList.add(star);
        }
        for (Character c : resultList) {
            System.out.print(c);
        }
    }

    /**
     * 根据ASCII码值判断是否是字母
     * @param c 字符 A-Z 61-90 a-z 97-122
     * @return
     */
    private static boolean checkLetter(char c){
        int i = (int)c;
        if ( (i >=97 && i <= 122) || (i >=61 &&  i <= 90)) {
            return true;
        }
        return false;
    }
}
