package com.searching;

public class QuickSelect {

    public static int quickselect(int[] array, int k) {
        return quickSelectHelper(array, 0, array.length - 1, k-1);
    }

    private static int quickSelectHelper(int[] array, int startIdx, int endIdx, int targetIdx) {
        if(startIdx > endIdx) return -1;
        if(startIdx == endIdx) return array[startIdx];
        int pivotIdx = startIdx, leftIdx = startIdx + 1, rightIdx = endIdx;
        while(leftIdx <= rightIdx) {
            if(array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                swap(array, leftIdx, rightIdx);
            }
            if(array[leftIdx] < array[pivotIdx]) {
                leftIdx++;
            }
            if(array[rightIdx] > array[pivotIdx]){
                rightIdx--;
            }
        }
        swap(array, pivotIdx, rightIdx);
        if(rightIdx == targetIdx) {
            return array[rightIdx];
        } else if(targetIdx < rightIdx) {
            return quickSelectHelper(array, startIdx, rightIdx - 1, targetIdx);
        } else {
            return quickSelectHelper(array, rightIdx + 1, endIdx, targetIdx);
        }
    }

    private static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void main(String[] args) {
        int result = quickselect(new int[]{5, 6, 2, 4, 9, 8}, 3);
        System.out.println(result);
    }
}
