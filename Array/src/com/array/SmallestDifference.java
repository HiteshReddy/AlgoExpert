package com.array;

import java.util.Arrays;

public class SmallestDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int smallestDiff = Integer.MAX_VALUE;
        int arr1 = 0, arr2 = 0;
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int one = 0, two = 0;
        while(one < arrayOne.length && two < arrayTwo.length) {
            int currDiff = Math.abs(arrayOne[one] - arrayTwo[two]);
            if(currDiff < smallestDiff) {
                smallestDiff = currDiff;
                arr1 = one;
                arr2 = two;
            }
            if(arrayOne[one] < arrayTwo[two]) {
                one++;
            } else {
                two++;
            }
        }
        return new int[]{arrayOne[arr1], arrayTwo[arr2]};
    }

    public static void main(String[] args) {
        int[] result = SmallestDifference.smallestDifference(new int[]{-1, 5, 10, 20 , 28, 3}, new int[]{26, 134, 135, 15, 17});
        System.out.println(result[0] + " " + result[1]);
    }

}
