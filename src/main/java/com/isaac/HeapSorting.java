package com.isaac;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapSorting<T> implements SortingMachcing {
    @Override
    public void sort(int[] array) {
        Heap heap = new Heap(array.length);
        for (int num:array) {
            heap.push(num);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = heap.pop();
        }

    }
}

class Heap {
    private int[] heap;

    private int heapSize = 0;

    public Heap(int volumn) {
        heap = new int[volumn];
    }

    public void push(int num) {
        if (heapSize == heap.length) {
            throw new RuntimeException("超出heapSize");
        }
        heapInsert(num);
    }

    public int pop() {
        if (heapSize == 0) {
            throw new RuntimeException("空了");
        }
        int res = heap[0];
        swap(0, --heapSize);
        heapify(0);
        return res;
    }

    private void heapify(int index) {
        while ((index << 1 | 1) < heapSize) {
            int leftChildIndex = index << 1 | 1;
            if (leftChildIndex + 1 < heapSize) {
                int minIndex = heap[leftChildIndex] < heap[leftChildIndex + 1] ? leftChildIndex : leftChildIndex + 1;
                if (heap[index] > heap[minIndex]) {
                    swap(index, minIndex);
                    index = minIndex;
                } else {
                    break;
                }
            } else {
                if (heap[index] > heap[leftChildIndex]) {
                    swap(index, leftChildIndex);
                    index = leftChildIndex;
                } else {
                    break;
                }
            }
        }
    }

    private void heapInsert(int num) {
        heap[heapSize] = num;
        int index = heapSize++;
        while (heap[index] < heap[(index - 1) / 2]) {
            swap(index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
    }

    private void swap(int a, int b) {
        heap[a] ^= heap[b];
        heap[b] ^= heap[a];
        heap[a] ^= heap[b];
    }
}
