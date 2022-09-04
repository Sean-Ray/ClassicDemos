package com.isaac;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        beginTesting(1000, 1000000000, 200000, new QuickSorting());
//        beginTesting(10000, 1000, 10000, new QuickSorting());
    }

    static <T extends SortingMachcing> void beginTesting(int testTimes, int maximum, int maxArrayLength, T SortingClass) {
        while (testTimes-- > 0) {
            int length = (int) (Math.random() * maxArrayLength);
            int[] ints = Generator.getRandomArray(length, maximum);
            int[] sortedInts = getAnswer(ints.clone());
            // Sorting Class
            SortingMachcing sortingMachcing = SortingClass;
            sortingMachcing.sort(ints);
            if (!compare(ints, sortedInts)) {
                break;
            }
        }
        System.out.println(testTimes >= 0 ? "Wrong" : "Right");
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
