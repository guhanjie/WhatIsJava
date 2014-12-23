package memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 多线程栈内存溢出(实际开发中特别需要注意)
 * VM args -Xmx200m
 * Created by ShaoJin on 2014/12/23 0023.
 */
public class OutOfMemoryErrorExample2 {

    public static void main(String[] args) {
        example2();
    }

    public static void example2() {
        int count = 0 ;
        /*
        在多线程模式下
        设置产生非常多的线程数，执行example2使用了-Xmx200m
        但是启动虚拟机后系统内战基本占满，说明-Xmx设置的是堆的内存最大使用值，无法限制线程栈内存占用
        如果创建过多的线程，还是会造成栈空间过大导致占用过多的系统资源(产生页交换)最终系统宕机
        此时需要通过编程的方式限制线程总数不能过大，比如Tomcat设置的最大并发数等
         */
        while(count <= 10000) {
            new Thread(new Mywork()).start();
        }
    }

    static class Mywork implements Runnable {

        @Override
        public void run() {
            try {
                // 如果在每个线程中再去创建非常多的对象，如果-Xmx不够的话会先出现Heap Size的OOM错误
//                List<Object> list = new ArrayList<>();
//                int c = 0;
//                while(c <= 10000) {
//                    list.add(new Object());
//                }
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
