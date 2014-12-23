package memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 常量池内存溢出
 * VM args -XX:PermSize=10m -XX:MaxPermSize=10m -XX:MaxMetaspaceSize=10m
 * jdk8中取消了PermSize，使用Metaspace代替，貌似不能正确的还原PermSize OOM错误了。。。
 *
 * Created by ShaoJin on 2014/12/23 0023.
 */
public class OutOfMemoryErrorExample3 {

    public static void main(String[] args) {
        long i = 0;
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
