package com.dsa;

import java.util.HashMap;
import java.util.Map;

public class MultiThreading implements Runnable {

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    @Override
    public void run() {
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    public static void main(String[] args) {

        Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        // t.start();
        // t.run();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1 acquired lock1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                synchronized (lock2) {
                    System.out.println("Thread 1 acquired lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2 acquired lock2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                synchronized (lock1) {
                    System.out.println("Thread 2 acquired lock1");
                }
            }
        });

        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 1);
        map.put(1, 1);
        map.put(3, 1);

        for (java.util.Map.Entry<Integer, Integer> nEntry : map.entrySet()) {
            map.remove(1);

        }

        // t1.start();
        // t2.start();

    }

}
