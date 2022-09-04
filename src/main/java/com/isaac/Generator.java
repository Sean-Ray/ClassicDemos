package com.isaac;

public class Generator {
    public static int[] getRandomArray(int maxLength, int maxNum) {
        int[] array = new int[(int)(Math.random() * maxLength)];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * (maxNum + 1));
        }
        return array;
    }
}
