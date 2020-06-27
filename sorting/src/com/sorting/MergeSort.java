package com.sorting;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        if(array.length == 1) return array;
        int midIdx = (0 + array.length)/2;
        int[] firstHalf = Arrays.copyOfRange(array, 0, midIdx);
        int[] secondHalf = Arrays.copyOfRange(array, midIdx, array.length);
        return mergeSortHelper(mergeSort(firstHalf), mergeSort(secondHalf));
    }

    private static int[] mergeSortHelper(int[] firstHalf, int[] secondHalf) {
        int[] mergedArray = new int[firstHalf.length + secondHalf.length];
        int idx1 = 0, idx2 = 0;
        int idx3 = 0;
        while(idx1 < firstHalf.length && idx2 < secondHalf.length) {
            if(firstHalf[idx1] < secondHalf[idx2]) {
                mergedArray[idx3++] = firstHalf[idx1++];
            } else {
                mergedArray[idx3++] = secondHalf[idx2++];
            }
        }
        while(idx1 < firstHalf.length) {
            mergedArray[idx3++] = firstHalf[idx1++];
        }
        while(idx2 < secondHalf.length) {
            mergedArray[idx3++] = secondHalf[idx2++];
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        int[] result = mergeSort(new int[]{1, 3, 2});
        Arrays.stream(result).forEach(i -> System.out.println(i));
    }
}
