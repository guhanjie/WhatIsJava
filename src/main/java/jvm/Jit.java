package jvm;

/**
 * 测试Java HotSpot虚拟机的JIT特性，启动时增加：-XX:+PrintCompilation 参数
 *
 * @author shaojin 2015/12/28
 * @modify
 */
public class Jit {
    public static void main(String[] args) throws InterruptedException {
        long i = 0;
        while(true){

            run(i);
            i++;
        }

    }

    public static void run(long i) throws InterruptedException {
        if (i%5000 == 0) {
            System.out.println("I=" + i);
        }
        Thread.sleep(1);
    }
}
