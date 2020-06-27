package com.sorting;

import java.util.Arrays;

public class HeapSort {

    public static int[] heapSort(int[] array) {
        createMaxHeap(array);
        int rightIdx = array.length - 1;
        while(rightIdx >= 0) {
            shiftDown(array, 0, rightIdx);
            if(array[0] >= array[rightIdx]) swap(array, 0, rightIdx);
            rightIdx--;
        }
        return array;
    }

    private static void createMaxHeap(int[] array) {
        int parentIdx = (array.length-2)/2;
        for(int i = parentIdx; i >=0; i--) {
            shiftDown(array, i, array.length - 1);
        }
    }

    private static void shiftDown(int[] array, int parentIdx, int endIdx) {
        int childOneIdx = 2*parentIdx + 1;
        while(childOneIdx < endIdx) {
            int childTwoIdx = 2*parentIdx + 2;
            int toSwapIdx = -1;
            if(childTwoIdx < endIdx && array[childTwoIdx] > array[childOneIdx]) {
                toSwapIdx = childTwoIdx;
            } else {
                toSwapIdx = childOneIdx;
            }
            if(array[toSwapIdx] > array[parentIdx]) {
                swap(array, parentIdx, toSwapIdx);
                parentIdx = toSwapIdx;
                childOneIdx = 2*parentIdx + 1;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] array, int parentIdx, int toSwapIdx) {
        int temp = array[parentIdx];
        array[parentIdx] = array[toSwapIdx];
        array[toSwapIdx] = temp;
    }

    public static void main(String[] args) {
        int[] result = heapSort(new int[]{8, 5, 2, 9, 5, 6, 3});
        Arrays.stream(result).forEach(i -> System.out.println(i));
    }

}
