package com.isaac;

import java.util.Arrays;

public class MergeSorting {
    public static void main(String[] args) {
        int count = 1000000000;
        while (count > 0) {
            int length = (int) (Math.random() * 1000 + 1);
            int[] ints = new int[length];
            for (int i = 0; i < length; i++) {
                ints[i] = (int) (Math.random() * 1000);
            }
            int[] sortedInts = getAnswer(ints.clone());
            process(ints, 0, ints.length - 1);
            if (!compare(ints, sortedInts)) {
                break;
            }
            count--;
        }
        System.out.println(count > 0 ? "Wrong" : "Right");

    }

    static void merge(int[] ints, int lp, int mid, int rp) {
        if (lp == rp) {
            return;
        }
        int[] tempArray = new int[rp - lp + 1];
        int mp = mid + 1;
        int i = 0;
        int head = lp;
        while (lp <= mid && mp <= rp) {
            tempArray[i++] = ints[lp] <= ints[mp] ? ints[lp++] : ints[mp++];
        }
        while (lp <= mid) {
            tempArray[i++] = ints[lp++];
        }
        while (mp <= rp) {
            tempArray[i++] = ints[mp++];
        }
        for (int j = 0; j < tempArray.length; j++) {
            ints[head+j] = tempArray[j];
        }
    }

    static void process(int[] ints, int lp, int rp) {
        if (lp == rp) {
            return;
        }
        int mp = (lp + rp) >> 1;
        try {
            process(ints, lp, mp);
            process(ints, mp + 1, rp);
            merge(ints, lp, mp, rp);
        } catch (StackOverflowError error) {
            System.out.println(error.getMessage());
            throw new RuntimeException(error.getMessage());
        }
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
