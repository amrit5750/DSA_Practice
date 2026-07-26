package com.dsa.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoomLifeCycleDemo {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new MyRun(i));

        }

        executorService.shutdown();

        if (executorService.awaitTermination(10, TimeUnit.MILLISECONDS)) {
            executorService.shutdownNow();
            System.out.println("Forcing Shutdown! 🚧");
        }

        System.out.println("ALL Threads Terminated");

    }

}

class MyRun implements Runnable {

    private final int taskId;

    public MyRun(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " Starting Task " + taskId);
        try {
            Thread.sleep(2000);
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " - waiting for task " + taskId + " COMPLETED");
                this.wait(1000);

            }
            System.out.println(Thread.currentThread().getName() + " - Task " + taskId + " COMPLETED");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
