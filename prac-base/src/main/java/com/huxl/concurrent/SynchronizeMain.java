package com.huxl.concurrent;

/**
 * javac SynchronizeMain.java
 * javap -c SynchronizeMain
 *
 * @author huxingl
 * @since 2018/11/14 10:55
 */

/*
Compiled from "SynchronizeMain.java"
public class com.huxl.concurrent.SynchronizeMain {
  public com.huxl.concurrent.SynchronizeMain();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: ldc           #2                  // class com/huxl/concurrent/SynchronizeMain
       2: dup
       3: astore_1
       4: monitorenter
       5: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
       8: ldc           #4                  // String synchronize
      10: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      13: aload_1
      14: monitorexit
      15: goto          23
      18: astore_2
      19: aload_1
      20: monitorexit
      21: aload_2
      22: athrow
      23: return
    Exception table:
       from    to  target type
           5    15    18   any
          18    21    18   any
}

 */


public class SynchronizeMain {
    public static void main(String[] args) {
        synchronized (SynchronizeMain.class) {
            System.out.println("synchronize");
        }
    }
}
