package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by Liuxey on 2015/11/6.
 */
public class TestHashMap {

    private volatile static Map<String, String> map = new HashMap();

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
            IntStream.range(0, 1000).forEach((x) -> {
                map.put(x + "", x + "x");
            });
        });
        t1.start();

        Thread.sleep(1);

        Thread t2 = new Thread(() -> {
           IntStream.range(0, 1000).forEach((x) -> {
               System.out.println(x + ":" + map.get(x + ""));
           });
        });
        t2.start();

        t1.join();
        t2.join();
    }
}
