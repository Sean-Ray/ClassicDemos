package com.isaac;

// array[i] >= 0
public class BucketSorting implements SortingMachcing {
    @Override
    public void sort(int[] array) {
        if (array.length < 2) return;
        int digitLength = getMaxDigitLength(array);
        int[] arrayClone = array.clone();
        for (int i = 1; i <= digitLength; i++) {
            int[] help = new int[arrayClone.length];
            int[] digitArray = getDigitArray(arrayClone, i);
            int[] beginIndex = getBeginIndex(digitArray);
            for (int j = 0; j < arrayClone.length; j++) {
                help[beginIndex[digitArray[j]]++] = arrayClone[j];
            }
            arrayClone = help;
        }
        for (int j = 0; j < arrayClone.length; j++) {
            array[j] = arrayClone[j];
        }
    }

    private int getMaxDigitLength(int[] array) {
        int maxDigitLength = 0;
        for (int num : array) {
            maxDigitLength = String.valueOf(num).length() > maxDigitLength ? String.valueOf(num).length() : maxDigitLength;
        }
        return maxDigitLength;
    }

    private int[] getDigitArray(int[] array, int n) {
        int[] help = array.clone();
        while (--n > 0) {
            for (int i = 0; i < help.length; i++) {
                help[i] /= 10;
            }
        }
        for (int i = 0; i < help.length; i++) {
            help[i] %= 10;
        }
        return help;
    }

    private int[] getBeginIndex(int[] digitArray) {
        int[] count = new int[10];
        for (int i = 0; i < digitArray.length; i++) {
            count[digitArray[i]]++;
        }
        for (int i = count.length - 1; i >= 0; i--) {
            count[i] = 0;
            for (int j = 0; j < i; j++) {
                count[i] += count[j];
            }
        }
        return count;
    }
}
