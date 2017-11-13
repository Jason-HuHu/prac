package com.huxl.prac;

public enum AccountType {
    SAVING,FIXED,CURRENT;
    private AccountType() {
        System.out.println("It is an account type");
    }
}
