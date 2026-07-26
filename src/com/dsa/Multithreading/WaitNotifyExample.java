package com.dsa.Multithreading;

public class WaitNotifyExample {
    public static void main(String[] args) {

        SharedResources resources = new SharedResources();

        Thread t1 = new Thread(() -> resources.waitExample(), "Thread-1");
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                resources.nofifyExample();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }, "Thread-2");

        t1.start();
        t2.start();

    }

}

class SharedResources {

    public synchronized void waitExample() {

        System.out.println(Thread.currentThread().getName() + " is waiting ");
        try {
            wait();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is Resumed After Notify ");

    }

    public synchronized void nofifyExample() {
        System.out.println(" Notify the Waiting Thread");
        notify();

    }
}
