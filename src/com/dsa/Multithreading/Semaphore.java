package com.dsa.Multithreading;

public class Semaphore {
    private static final java.util.concurrent.Semaphore mutex = new java.util.concurrent.Semaphore(1);

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> AccessCriticalSection("Thread-1"));
        Thread t2 = new Thread(() -> AccessCriticalSection("Thread-2"));
        t1.start();
        t2.start();

    }

    public static void AccessCriticalSection(String threadName) {
        try {
            System.out.println(threadName + " is attempting to acquire the lock.");
            mutex.acquire(); // Acquire the semaphore
            System.out.println(threadName + " acquired the lock.");
            Thread.sleep(1000); // Simulate work in the critical section

        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            mutex.release(); // Release the semaphore
            System.out.println(threadName + " released the lock.");
        }
    }

}
