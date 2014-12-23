package memory;

/**
 * 栈爆StackOverflowError
 *
 * Created by ShaoJin on 2014/12/19 0019.
 */
public class StackOverflowErrorExample {

    static int length = 0;

    public static void main(String[] args) {
        nest();
    }


    public static void nest() {
        length++;
        try {
            // 无限循环调用导致调用栈溢出抛出StackOverflowError :] 可以通过设置-Xss的值来增加线程调用栈的大小，默认1m
            nest();

        } catch (Throwable e) {
            System.out.println("StackLength:" + length);
            e.printStackTrace();
        }
    }
}
