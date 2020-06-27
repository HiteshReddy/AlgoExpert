package com.searching;

import java.util.Arrays;

public class FindThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {
        int[] three = new int[3];
        Arrays.fill(three, Integer.MIN_VALUE);
        for(int i=0; i < array.length; i++) {
            int val = array[i];
           if(val > three[2]) {
               substitute(three, val, 2);
           } else if(val > three[1]) {
               substitute(three, val, 1);
           } else if(val > three[0]) {
               substitute(three, val, 0);
           }
        }
        return three;
    }

    private static void substitute(int[] array, int value, int idx) {
        for(int i = 0; i <= idx; i++) {
            if(i == idx) array[i] = value;
            else array[i] = array[i+1];
        }
    }

    public static void main(String[] args) {
        int[] result = findThreeLargestNumbers(new int[]{ -1, -2, -3, -7, -17, -27, -18, -541, -8, -7, 7 });
        System.out.println(result[2] + " " + result[1] + " " + result[0]);
    }

}
