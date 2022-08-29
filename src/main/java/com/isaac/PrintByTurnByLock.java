package com.isaac;

public class PrintByTurnByLock {
    public static void main(String[] args) {
        Object o = new Object();

        Thread t0 = new Thread(() -> {
            String a = "ABCDEFG";
            try {
                synchronized (o) {
                    o.wait();
                    for (char c : a.toCharArray()) {
                        System.out.print(c);
                        o.notify();
                        o.wait();
                    }
                    o.notify();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t1 = new Thread(() -> {
            String b = "1234567";
            try {
                synchronized (o) {
                    o.notify();
                    o.wait();
                    for (char c : b.toCharArray()) {
                        System.out.print(c);
                        o.notify();
                        o.wait();
                    }
                    o.notify();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t0.start();
        t1.start();
    }
}
