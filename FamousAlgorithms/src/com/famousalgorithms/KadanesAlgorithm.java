package com.famousalgorithms;

import java.util.Arrays;

public class KadanesAlgorithm {

    public static int kadanesAlgorithm(int[] array) {
        int idx = 0, max = Integer.MIN_VALUE, currentMax = 0;
        while(idx < array.length) {
            currentMax += array[idx];
            currentMax = Math.max(currentMax, array[idx]);
            max = Math.max(currentMax, max);
            idx++;
        }
        return max;
    }

    public static void main(String[] args) {
        int result = kadanesAlgorithm(new int[]{-1, -2 , -3, -4, -5});
        System.out.println(result);
    }

}
