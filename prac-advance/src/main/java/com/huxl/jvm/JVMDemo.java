package com.huxl.jvm;

/**
 * jvm练习Demo
 *
 * @author xiaoh
 * @since 2019/3/14 14:17
 */
public class JVMDemo {

    private final static int _1MB = 1024*1024;

    public static void main(String[] args) {
        testAllocation();
    }


    /**
     *
     * VM Options:-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRation=8
     *
     * JDK8 默认采用Parallel Scavenge + Parallel Old
     *
     * [GC (Allocation Failure) [PSYoungGen: 7360K->1023K(9216K)] 7360K->5127K(19456K), 0.0046597 secs] [Times: user=0.05 sys=0.00, real=0.00 secs]
     * [GC (Allocation Failure) --[PSYoungGen: 7491K->7491K(9216K)] 11595K->14667K(19456K), 0.0034679 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (Ergonomics) [PSYoungGen: 7491K->3889K(9216K)] [ParOldGen: 7176K->7169K(10240K)] 14667K->11058K(19456K), [Metaspace: 3918K->3918K(1056768K)], 0.0099910 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
     * [Full GC (Ergonomics) [PSYoungGen: 6019K->0K(9216K)] [ParOldGen: 7169K->10034K(10240K)] 13188K->10034K(19456K), [Metaspace: 3918K->3918K(1056768K)], 0.0087627 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
     * [Full GC (Ergonomics) [PSYoungGen: 5120K->5120K(9216K)] [ParOldGen: 10034K->7986K(10240K)] 15154K->13106K(19456K), [Metaspace: 3918K->3918K(1056768K)], 0.0054687 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     *
     * 改为Serial + Serial Old 收集器组合后 -XX:UseSerialGC
     * [GC (Allocation Failure) [DefNew: 6245K->731K(9216K), 0.0053448 secs] 6245K->4827K(19456K), 0.0054023 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [GC (Allocation Failure) [DefNew (promotion failed) : 7033K->6301K(9216K), 0.0438942 secs][Tenured: 7895K->7895K(10240K), 0.0097136 secs] 11129K->10967K(19456K), [Metaspace: 3444K->3444K(1056768K)], 0.0536615 secs] [Times: user=0.00 sys=0.00, real=0.05 secs]
     * [Full GC (Allocation Failure) [Tenured: 7895K->9943K(10240K), 0.0030265 secs] 13179K->9943K(19456K), [Metaspace: 3444K->3444K(1056768K)], 0.0030572 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [GC (Allocation Failure) [DefNew: 5120K->5120K(9216K), 0.0000115 secs][Tenured: 9943K->7895K(10240K), 0.0023122 secs] 15063K->13015K(19456K), [Metaspace: 3444K->3444K(1056768K)], 0.0023664 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (Allocation Failure) [Tenured: 7895K->7876K(10240K), 0.0019512 secs] 13015K->12996K(19456K), [Metaspace: 3444K->3444K(1056768K)], 0.0019778 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     */
    private static void testAllocation(){
        byte[] allocation1,allocation2,allocation3,allocation4;

        allocation1 = getByteArr(2 * _1MB);
//        System.gc();
        allocation2 = getByteArr(2 * _1MB);
        allocation3 = getByteArr(3 * _1MB);
        allocation4 = getByteArr(3 * _1MB);
        allocation4 = getByteArr(2 * _1MB);
        allocation4 = getByteArr(5 * _1MB);
        allocation4 = getByteArr(5 * _1MB);
        allocation4 = getByteArr(5 * _1MB);
        allocation4 = getByteArr(5 * _1MB);

    }

    private static byte[] getByteArr(int size){
        return new byte[size];
    }
}
