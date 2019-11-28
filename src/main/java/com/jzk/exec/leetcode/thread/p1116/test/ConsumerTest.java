package com.jzk.exec.leetcode.thread.p1116.test;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
//        testConsumer();
        testAndThen();
    }
    /**
     * 一个简单的平方计算
     */
    public static void testConsumer(){
        Consumer<Integer> square = x -> System.out.println("print square : " + x * x);
        Consumer<Integer> square3 = (x) -> System.out.println("print square : " + x + x);
        square.accept(2);
        square3.accept(3);
        square.andThen(null).accept(1);
    }
    /**
     * 定义3个Consumer并按顺序进行调用andThen方法，其中consumer2抛出NullPointerException。
     */
    public static void testAndThen(){
        Consumer<Integer> consumer1 = x -> System.out.println("first x : " + x);
        Consumer<Integer> consumer2 = x -> {
            System.out.println("second x : " + x);
//            throw new NullPointerException("throw exception test");
        };
        Consumer<Integer> consumer3 = x -> System.out.println("third x : " + x);

        consumer1.andThen(consumer2).andThen(consumer3).accept(1);
    }
}
