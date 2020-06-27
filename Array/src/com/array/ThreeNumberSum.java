package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> matches = new ArrayList<>();
        if(array.length < 3)
            return matches;
        for(int i = 0; i < array.length-2; i++) {
            int currVal = array[i];
            int left = i + 1;
            int right = array.length - 1;
            while(left < right) {
                int currSum = array[left] + array[right];
                if(currVal + currSum == targetSum) {
                    matches.add(new Integer[]{currVal, array[left], array[right]});
                    left++;
                    right--;
                } else if(currVal + currSum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        List<Integer[]> result = ThreeNumberSum.threeNumberSum(new int[]{12, 3, 1}, 16);
        result.stream().forEach(arr -> {
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        });
    }

}
