package com.joyowo.mytest;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * User: chenby
 * Date: 2017-11-09
 */
public class TestThreadPool {

    @Test
    public void testPool() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }

/*    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }*/
    public static void main(String[] args) throws Exception{
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    for (int i = 0; i < 10; i++) {
        int index = i;
        cachedThreadPool.execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000L);
                    System.out.println(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(index);
            }
        });
    }
    }
}
