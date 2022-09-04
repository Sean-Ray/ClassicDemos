package com.isaac;

public class QuickSorting implements SortingMachcing {
    @Override
    public void sort(int[] array) {
        int num = (int) (Math.random() * (array.length));
    }

    private void leftRight(int[] nums, int lp, int rp, int num) {
        int i = 0;
        while (i < rp) {
            if (nums[i] < num) {
                swap(nums, i++, ++lp);
            } else if (nums[i] == num) {
                i++;
            } else {
                swap(nums, i, --rp);
            }
        }
    }

    private static void swap(int[] array, int a, int b) {
        array[a] ^= array[b];
        array[b] ^= array[a];
        array[a] ^= array[b];
    }
}
