package com.isaac;

public class QuickSorting implements SortingMachcing {
    @Override
    public void sort(int[] array) {
        process(array, 0, array.length - 1);
    }

    private void process(int[] nums, int lp, int rp) {
        if (lp >= rp || nums.length == 0) return;
        int num = nums[lp + (int) (Math.random() * (rp - lp + 1))];
        int[] midZone = leftRight(nums, lp, rp, num);
        process(nums, lp, midZone[0] - 1);
        process(nums, midZone[1] + 1, rp);
    }

    private int[] leftRight(int[] nums, int lp, int rp, int num) {
        int sZone = lp - 1;
        int bZone = rp + 1;
        while (lp < bZone) {
            if (nums[lp] < num) {
                swap(nums, lp++, ++sZone);
            } else if (nums[lp] == num) {
                lp++;
            } else {
                swap(nums, lp, --bZone);
            }
        }
        return new int[]{sZone + 1, bZone - 1};
    }

    private static void swap(int[] array, int a, int b) {
        if (a == b) return;
        array[a] ^= array[b];
        array[b] ^= array[a];
        array[a] ^= array[b];
    }
}
