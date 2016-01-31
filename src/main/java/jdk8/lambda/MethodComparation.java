package jdk8.lambda;

import java.util.function.Consumer;

/**
 * Created by liuxe on 2016/1/31.
 */
public class MethodComparation {

    static class Wo {
        public void m1(Integer i) {
        }
    }

    public static void main(String[] args) {

        Wo wo = new Wo();
        Consumer<Integer> c1 = wo::m1;
        Consumer<Integer> c2 = wo::m1;

        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2));

        // 这里想比较两个lambda是否源自同一个method，看来并没有什么好的方法。。。

    }
}
