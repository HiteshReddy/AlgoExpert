package com.dynamicprogramming;

public class MaximumSubsetSum {

    public static int maxSubsetSumNoAdjacent(int[] array) {
        if(array.length == 0)
            return 0;
        else if (array.length == 1)
            return array[0];
        int first = array[0], second = Math.max(array[0], array[1]);
        for(int i = 2; i < array.length; i++) {
            int current = Math.max(second, first + array[i]);
            first = second;
            second = current;
        }
        return second;
    }

    public static void main(String[] args) {
        int result = MaximumSubsetSum.maxSubsetSumNoAdjacent(new int[]{75, 105, 120, 75, 90, 135});
        System.out.println(result);
    }

}
