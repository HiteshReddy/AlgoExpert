package com.searching;

public class SearchForRange {

    public static int[] searchForRange(int[] array, int target) {
        int[] range = new int[]{-1, -1};
        searchLeft(array, range, target);
        searchRight(array, range, target);
        return range;
    }

    private static void searchLeft(int[] array, int[] range, int target) {
        int startIdx = 0, endIdx = array.length - 1;
        while(startIdx <= endIdx) {
            int midIdx = (startIdx + endIdx)/2;
            if(array[midIdx] == target) {
                if(midIdx == 0 || array[midIdx] != array[midIdx - 1]) {
                    range[0] = midIdx;
                    return;
                } else if(array[midIdx] == array[midIdx-1]) {
                    endIdx = midIdx - 1;
                }
            } else if(target < array[midIdx]) {
                endIdx = midIdx - 1;
            } else {
                startIdx = midIdx + 1;
            }
        }
    }

    private static void searchRight(int[] array, int[] range, int target) {
        int startIdx = 0, endIdx = array.length - 1;
        while(startIdx <= endIdx) {
            int midIdx = (startIdx + endIdx)/2;
            if(array[midIdx] == target) {
                if(midIdx == array.length - 1 || array[midIdx] != array[midIdx + 1]) {
                    range[1] = midIdx;
                    return;
                } else if(array[midIdx] == array[midIdx+1]) {
                    startIdx = midIdx + 1;
                }
            } else if(target < array[midIdx]) {
                endIdx = midIdx - 1;
            } else {
                startIdx = midIdx + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] result = searchForRange(new int[]{ 5, 7, 7, 8, 8, 10 }, 5);
        System.out.println(result[0] + " " + result[1]);
    }

}
