package com.isaac;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
//        beginTesting();
        System.out.println((int)9.9);
    }

    static void beginTesting() {
        int count = 10000;
        while (count > 0) {
            int length = (int) (Math.random() * 10000);
            int[] ints = Generator.getRandomArray(length, 1000000000);
            int[] sortedInts = getAnswer(ints.clone());
            // Sorting Class
            SortingMachcing sortingMachcing = new HeapSorting();
            sortingMachcing.sort(ints);
            if (!compare(ints, sortedInts)) {
                break;
            }
            count--;
        }
        System.out.println(count > 0 ? "Wrong" : "Right");
    }

    static int[] getAnswer(int[] ints) {
        Arrays.sort(ints);
        return ints;
    }

    static boolean compare(int[] a, int[] b) {
        if (a.length != b.length || a == b) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
