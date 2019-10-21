package com.huxl.coding;

public class MeaningOfThis {
    public final int value = 4;
    public void doIt(){
        int value = 6;
        Runnable r = new Runnable() {
            private final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
                System.out.println(value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt();
        System.out.println(m.value);
    }
}
