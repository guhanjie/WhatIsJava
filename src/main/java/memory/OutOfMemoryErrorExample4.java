package memory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本机直接内存区溢出
 * VM args -Xmx20m -XX:MaxDirectMemorySize=10m
 *
 * 主要是通过Unsafe的allocateMemory方法来申请直接内存，但是他只能通过rt.jar中的类来访问，所以我们使用反射来使他可以被生成实例
 *
 * Created by ShaoJin on 2014/12/23 0023.
 */
public class OutOfMemoryErrorExample4 {

    public static final int _1MB = 1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);

        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
