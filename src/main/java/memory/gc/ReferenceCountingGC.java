package memory.gc;

/**
 * 检测JVM的根搜索算法，不会产生循环引用导致无法GC的问题
 *
 * VM args -XX:+PrintGC
 * Created by ShaoJin on 2014/12/23 0023.
 */
public class ReferenceCountingGC {

    private Object instance = null;

    public static final int _1MB = 1024 * 1024;

    private byte[] bytes = new byte[2 * _1MB];

    public static void main(String[] args) throws InterruptedException {
        ReferenceCountingGC o1 = new ReferenceCountingGC();
        ReferenceCountingGC o2 = new ReferenceCountingGC();

        o1.instance = o2;
        o2.instance = o1;

        o1 = null;
        o2 = null;

        // 即使设置了循环引用JVM的GC仍然能回收两个对象，说明JVM不是使用的引用计数算法
        System.gc();

        // 确保看到调用finalize方法
        Thread.sleep(200);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("结束了" + this);

        // 对象可以在finalize方法中把自己（this）引用给其他对象，防止自己死亡，但是一旦第二次被进入回收队列，则会直接死亡，无法自救
    }
}