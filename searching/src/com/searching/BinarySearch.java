package com.searching;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int start = 0, end = array.length-1;
        while(start <= end) {
            int mid = (end + start)/2;
            if(array[mid] == target)
                return mid;
            else if(target < array[mid])
                end = mid - 1;
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int result = BinarySearch.binarySearch(new int[]{ 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 }, 34);
        System.out.println(result);
    }

}
