package com.dsa.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new MyRunnableClass(i));

        }
        executorService.shutdown();

    }

}

class MyRunnableClass implements Runnable {

    private final int taskId;

    public MyRunnableClass(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is processing task: " + taskId);
        try {
            Thread.sleep(2000); // Simulate task execution time
        } catch (InterruptedException e) {
            System.out.println("Task interrupted: " + e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " finished task: " + taskId);

    }

}
