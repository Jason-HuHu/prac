# Object 类主要方法分析
```java
public class Object{
    /**
    *使当前线程等待直到其他线程调用当前对象的{@link java.lang.Object#notify()} 或者 {@link java.lang.Object#notifyAll()}
    *或者指定的时间（timeout）已经过去
    *<p>
    *     当前线程必须获得这个对象的监视器（monitor）
    *</p>  
    * 这个方法使得当前线程(把它叫做<var>T</var>)把它自己放进一个等待集合（wait set）并且放弃对当前线程的所有权。线程<var>T</var>
    * 对线程调度失效(即CPU不再使当前线程获得执行的能力)并且休眠等待一下四件事情发生：
    * <ul>
    *     <li>
    *         一些其他线程调用了当前对象的{@code notify}方法，当前线程<var>T</var>恰好被任意选择为被唤醒的线程
    *     </li>
    *     <li>
    *         一些其他线程调用该对象的{@code notifyAll}方法
    *     </li>
    *     <li>
    *         一些其他线程{@linkplain Thread#interrupt()} 中断线程<var>T</var>
    *     </li>
    *     <li>
    *         指定的超时时间已经或多或少的过去了，如果超时时间{@code timeout}是0，则不考虑实时性，线程只需等待通知
    *     </li>
    * </ul>
    * 线程<var>T</var>然后会被移出该对象的等待集合（wait set）重新可以被cpu调度。通过正常的竞争方式与其他线程竞争当前对象的
    * 同步权限;一旦它获得了对象的控制器，它对该对象的所有同步声明都将恢复到原来的状态，也就是恢复到调用该方法时的状态
    * <p>
    * 一个线程也可以醒来，在没有被唤醒、中断或者超时的情况下，一种所谓的<i>(虚假唤醒)spurious wakeup</i>,当虚假唤醒在实际中
    * 出现的时候，应用必须通过测试可能导致该线程被唤醒的条件来阻止它出现，如果条件不满足，则继续等待。换句话说，等待应该总是以
    * 循环的形式出现，就像这样：
    * <pre>
    *     synchronized(obj) {
    *         while(;condition does not hold;)
    *         obj.wait(timeout);
    *         ...//执行符合条件的操作
    *     }
    * </pre>
    * 
    * @param timeout 等待的最大时间
    * @throws IllegalArgumentException 超时时间的值为负数
    * @throws IllegalMonitorStateException 如果当前线程不是该对象的监视者的所有者
    * @throws InterruptedException 如果任何其他线程在当前线程等待被唤醒之前或者正在被唤醒的时候中断当前线程。当该异常抛出是，当前线程
    * 的<i>interrupted state </i> 会被清除
    */
    public final native void wait(long timeout) throws InterruptedException;
    
    /**
    * 唤醒一个等待在该对象中的线程，如果有线程正在等待此对象，他们中的一个会被选中唤醒。
    * 选择是任意的，由实现着自行决定。一个线程等待该对象，通过调用对象的{@code wait}方法实现
    * 
    * 
    */
    public final native void notify();

}
```