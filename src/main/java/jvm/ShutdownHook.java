package jvm;

/**
 * @author liuxe 10/25/2015.
 */
public class ShutdownHook {

    private static volatile boolean keepRunning = true;

    public static void main(String[] args) throws InterruptedException {

        final Thread mainThread = Thread.currentThread();

        // 然而这个ShutdownHook只能抗住正常结束的程序，对于kill掉的毫无办法
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Before Shutdown");
                keepRunning = false;
                try {
                    mainThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Running");
        Thread.sleep(3000);

    }
}
