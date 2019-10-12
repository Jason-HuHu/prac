package com.huxl.interview;

public class StringCompare {

    private String value;

    public StringCompare(String value) {
        this.value= value;
    }

    public void compareStr(String str){
        if(this.value == str) {
            System.out.println("the same");
        }else {
            System.out.println("the different");
        }
    }

    public static void main(String[] args) {
        String strA = "abc";
        String strB = "abc";

        StringCompare a = new StringCompare(strA);
        StringCompare b = new StringCompare(strB);

        a.compareStr("abc");
        b.compareStr(new String("abc"));

    }
}
