package com.huxl.interview.offer;

/**
 * 剑指Offer：替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author huxl
 */
public class ReplaceSpaces {
    public static void main(String[] args) {

        System.out.println(new ReplaceSpaces().replaceSpace(new StringBuffer("hello world")));
        System.out.println("hello world\"".charAt(2) == ' ');
    }

    public String replaceSpace(StringBuffer str) {
        //注意非空判断
        if (str == null) {
            return null;
        }

        //1.直接使用API
        //return str.toString().replaceAll(" ","%20");

        //2.遍历每个字符
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= str.length()-1; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append('%').append('2').append('0');
            }else {
                sb.append(c);
            }
        }
        return sb.toString();

        //3.移动元素,从后向前

    }


}
