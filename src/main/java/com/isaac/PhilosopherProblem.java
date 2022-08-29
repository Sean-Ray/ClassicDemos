package com.isaac;

public class PhilosopherProblem {
    public static void main(String[] args) {
        Chopstick chop0 = new Chopstick(0);
        Chopstick chop1 = new Chopstick(1);
        Chopstick chop2 = new Chopstick(2);
        Chopstick chop3 = new Chopstick(3);
        Chopstick chop4 = new Chopstick(4);

        Philosopher philosopher0 = new Philosopher(0, chop0, chop1);
        Philosopher philosopher1 = new Philosopher(1, chop1, chop2);
        Philosopher philosopher2 = new Philosopher(2, chop2, chop3);
        Philosopher philosopher3 = new Philosopher(3, chop3, chop4);
        Philosopher philosopher4 = new Philosopher(4, chop4, chop0);

        philosopher0.start();
        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
    }
}

class Chopstick {
    private int index;

    public Chopstick(int index) {
        this.index = index;
    }
}

class Philosopher extends Thread {
    private int index;

    private Chopstick leftChop;

    private Chopstick rightChop;

    public Philosopher(int index, Chopstick l, Chopstick r) {
        this.index = index;
        this.leftChop = l;
        this.rightChop = r;
    }

    @Override
    public void run() {
        try {
            if (this.index % 2 == 0) {
                synchronized (rightChop) {
                    Thread.sleep(10);
                    synchronized (leftChop) {
                        System.out.println(this.index + " 号吃完了！");
                    }
                }
            } else {
                synchronized (leftChop) {
                    Thread.sleep(10);
                    synchronized (rightChop) {
                        System.out.println(this.index + " 号吃完了！");
                    }
                }
            }
        } catch (InterruptedException ex) {

        }
    }
}