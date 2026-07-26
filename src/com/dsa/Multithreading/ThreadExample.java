package com.dsa.Multithreading;

public class ThreadExample {

    public static void main(String[] args) {

        // MyThread t1 = new MyThread();
        // MyThread t2 = new MyThread();
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();

    }

}

class MyThread extends Thread {

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
