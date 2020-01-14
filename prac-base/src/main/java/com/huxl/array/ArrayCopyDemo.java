package com.huxl.array;

import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;

/**
 * 研究java.lang.System#arraycopy(java.lang.Object, int, java.lang.Object, int, int)
 * @author huxl
 * @since 2019/12/18-9:40
 */
public class ArrayCopyDemo {
    public static void main(String[] args) {

/*        Object[] a = new Object[10];
        Object b = new Object();

        System.out.println(a.getClass());
        System.out.println(b.getClass());*/
        int[] a = new int[]{1,2,3,4};
        int[] b = new int[10];
        System.arraycopy(a,0,b,0,3);
        System.out.println(b);
        //
        System.out.println(TemporalAdjusters.lastDayOfMonth());
    }
}

class A<T> {
    public A(){
        System.out.println(this.getClass());
    }
}
