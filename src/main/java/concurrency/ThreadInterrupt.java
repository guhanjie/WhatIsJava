package concurrency;

/**
 * 线程中止测试
 *
 * Created by ShaoJin on 2014/12/22 0022.
 */
public class ThreadInterrupt {

    static class MyWork implements Runnable {

        void slp() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("inter sleep interrupt");
            }
        }

        @Override
        public void run() {
            int count = 0;
            while (!Thread.currentThread().isInterrupted()) { // 高风险，内部代码如包含sleep等并且捕获异常，则这种方法无效
                try {
                    Thread.sleep(700);
                    System.out.println(count++);

                    slp();

                } catch (Exception e) {
                    System.out.println("outer finish");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new MyWork());
        t.start();

        Thread.sleep(1000);
        t.interrupt();
    }
}
