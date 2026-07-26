package com.dsa.Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    public static void main(String[] args) {

        ExecutorService executors = Executors.newFixedThreadPool(2);

        Callable<String> callable1 = new MyCallable("Task 1");
        Callable<String> callable2 = new MyCallable("Task 2");

        try {

            Future<String> future1 = executors.submit(callable1);
            Future<String> future2 = executors.submit(callable2);

            System.out.println("Result from first Task");
            System.out.println(future1.get());

            System.out.println("Result from second Task");
            System.out.println(future2.get());

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Task execution interrupted: " + e.getMessage());
        } finally {
            executors.shutdown();
        }

    }

}

class MyCallable implements Callable<String> {

    private final String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        StringBuilder builder = new StringBuilder();
        try {

            for (int i = 0; i < 5; i++) {
                builder.append("Callable ").append(name).append(" is Running ").append(i).append(" ");
                Thread.sleep(200);

            }

            // TODO Auto-generated method stub

        } catch (Exception e) {
            System.out.println("Exception occured");
            // TODO: handle exception
        }

        return builder.toString();

    }

}
