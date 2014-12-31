package concurrency.atomic;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger用来在多线程环境下操作boolean值，他比自己使用synchronized来实现效率提升很多，使用的是CAS (compare and swap) + volatile和native方法
 *
 * 这个样例中使用AtomicInteger执行时间大概为30ms，而使用synchronized的方法实现则需要70ms
 *
 * Created by ShaoJin on 2014/12/31 0031.
 */
public class AtomicIntegerExample {

    private static volatile int i = 0;

    private synchronized static void add() {
        i++;
    }

    private static AtomicInteger ai = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        long st = System.currentTimeMillis();

        Thread t1 = new Thread(new IncreamentWork());
        Thread t2 = new Thread(new IncreamentWork());


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);
        System.out.println(ai.intValue());

        long en = System.currentTimeMillis();
        System.out.println((en - st) + "ms");
    }

    public static class IncreamentWork implements Runnable {

        @Override
        public void run() {
            for (int j = 0; j < 1000000; j++) {
                ai.incrementAndGet();
//                add();
            }
        }
    }
}
