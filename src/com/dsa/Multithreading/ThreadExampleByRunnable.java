package com.dsa.Multithreading;

public class ThreadExampleByRunnable {

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
            try {
                System.out.println("Thread is " + Thread.currentThread().getName() + " is Running");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                System.out.println("Thread interrupted");
            }

        }
    }

}
