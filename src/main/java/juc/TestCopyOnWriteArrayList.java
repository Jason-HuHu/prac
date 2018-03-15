package juc;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author huxl
 * @createDate 2018/2/7 11:32
 */
public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        HellloThread hellloThread = new HellloThread();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(hellloThread).start();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");

    }
}

class HellloThread implements Runnable {
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
//    private static List<String> list = new ArrayList<>();
    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }
    @Override
    public void run() {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
//            System.out.println(Thread.currentThread().getName() + " ----" + System.currentTimeMillis());
            list.add("GG" + Thread.currentThread().getName());
        }

    }
}
