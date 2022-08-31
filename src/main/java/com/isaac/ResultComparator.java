package com.isaac;

public class ResultComparator {
    public static void main(String[] args) {
        long count = 1000000000;
        while (count > 0) {
            long i = (long) (Math.random() * 1000000000);
            if (divide(i) != and(i)) {
                System.out.println("wrong: " + i);
                break;
            }
            count--;
        }
        System.out.println("right");
    }

    static int divide(long num) {
        return (int)(num % 2);
    }

    static int and(long num) {
        return (int)(num & 1);
    }
}
