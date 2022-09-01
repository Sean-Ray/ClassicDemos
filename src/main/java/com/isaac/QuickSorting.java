package com.isaac;

public class QuickSorting {
    public static void main(String[] args) {
        int testTime = 1000;
        while (testTime-- > 0) {
            int[] array = Generator.getRandomArray(10000, 1000);
            if (array.length == 0) continue;
            int num = (int)(Math.random() * 1000);
            leftRight(array, num);
            if (!comparator(array, num)) {
                break;
            }
        }
        System.out.println(testTime < 0 ? "Right" : "Wrong");
    }

    private static void leftRight(int[] nums, int num) {
        int lp = -1;
        int rp = nums.length;
        int i = 0;
        while (i < rp) {
            if (nums[i] < num) {
                int a = nums[i];
                nums[i++] = nums[lp + 1];
                nums[++lp] = a;
            } else if (nums[i] == num) {
                i++;
            } else {
                int a = nums[i];
                nums[i] = nums[rp - 1];
                nums[--rp] = a;
            }
        }
    }

    private static boolean comparator(int[] array, int num) {
        int condition = -1;
        for (int n:array) {
            if (condition > Integer.compare(n, num)) {
                return false;
            }
            condition = Integer.compare(n, num);
        }
        return true;
    }
}
