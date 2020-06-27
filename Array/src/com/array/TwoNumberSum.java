package com.array;

import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> values = new HashSet<>();
        for(int i : array) {
            if(values.contains(targetSum - i)) {
                return new int[] {i, targetSum - i};
            }
            values.add(i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result = TwoNumberSum.twoNumberSum(new int[]{ 3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

}
