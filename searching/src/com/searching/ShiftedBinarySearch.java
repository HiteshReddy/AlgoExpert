package com.searching;

public class ShiftedBinarySearch {

    public static int shiftedBinarySearch(int[] array, int target) {
        int startIdx = 0, endIdx = array.length-1;
        while(startIdx <= endIdx) {
            int midIdx = (endIdx+startIdx)/2;
            if(array[midIdx] == target) {
                return midIdx;
            } else if(array[startIdx] <= array[midIdx]) {
                if(target >= array[startIdx] && target < array[midIdx]) {
                    endIdx = midIdx - 1;
                } else {
                    startIdx = midIdx + 1;
                }
            } else {
                if(target > array[midIdx] && target <= array[endIdx]) {
                    startIdx = midIdx + 1;
                } else {
                    endIdx = midIdx - 1;
                }
            }
        }
        return -1;
    }

}
