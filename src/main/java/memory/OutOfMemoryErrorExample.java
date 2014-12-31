package memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 最简单的堆内存溢出
 * VM args -Xmx10m
 *
 * Created by ShaoJin on 2014/12/23 0023.
 */
public class OutOfMemoryErrorExample {

    public static void main(String[] args) {
        example1();
    }

    public static void example1() {
        List<Object> list = new ArrayList<>();

        while (true) {
            // 死循环创建对象并保持引用导 致内存溢出，配置-Xmx来设置堆最大值
            list.add(new Object());

        }
    }

}
