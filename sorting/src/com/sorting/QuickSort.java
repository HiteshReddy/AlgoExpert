package com.sorting;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSort(int[] array) {
        if(array.length <= 1)
            return array;
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }

    private static void quickSortHelper(int[] array, int startIdx, int endIdx) {
        if(startIdx >= endIdx) {
            return;
        }
        int pivotIdx = startIdx, leftIdx = startIdx + 1, rightIdx = endIdx;
        while(leftIdx <= rightIdx) {
            if(array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                swap(array, leftIdx, rightIdx);
            } else if(array[leftIdx] <= array[pivotIdx]) {
                leftIdx++;
            } else if(array[rightIdx] >= array[pivotIdx]) {
                rightIdx--;
            }
        }
        swap(array, pivotIdx, rightIdx);
        quickSortHelper(array, startIdx, rightIdx - 1);
        quickSortHelper(array, rightIdx + 1, endIdx);
    }

    private static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] result = quickSort(new int[]{5, 6, 2, 4, 9, 8});
        Arrays.stream(result).forEach(i -> System.out.println(i));
    }
}
