package com.joyowo.mytest.util;

import java.util.Optional;

/**
 * Author: chenby
 * Date: 2017-12-14
 */
@FunctionalInterface
public interface MyFunction<T, R> {
    void consumer(T t);

    default void test(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
      /*  MyFunction fc = (Object l) -> System.out.println(l.equals("1"));
        fc.consumer("1");*/
      MyFunction<String,String> mf = Integer::parseInt;
      mf.consumer("1");
      mf = String::isEmpty;
      mf.consumer("");
        FunctionInstance fi = new FunctionInstance();
        mf = fi::getLength;
        mf.consumer(null);

    }
class FunctionInstance {
    public Integer getLength(String str) {
        return Optional.ofNullable(str).orElse("").length();  // Optional也是Java8引入的
    }
}
}
