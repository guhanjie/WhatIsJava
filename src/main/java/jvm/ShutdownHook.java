package jvm;

/**
 * @author liuxe 10/25/2015.
 */
public class ShutdownHook {

    private static volatile boolean keepRunning = true;

    public static void main(String[] args) throws InterruptedException {

        final Thread mainThread = Thread.currentThread();

        // Ȼ�����ShutdownHookֻ�ܿ�ס���������ĳ��򣬶���kill���ĺ��ް취
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
