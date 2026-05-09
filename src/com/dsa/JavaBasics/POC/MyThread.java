package com.dsa.JavaBasics.POC;

public class MyThread {

    public static void main(String[] args) {

        MyRunnable runnable = new MyRunnable();

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();

    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("thread is  :" + Thread.currentThread().getId());
            System.out.println(i);
        }
    }

}
