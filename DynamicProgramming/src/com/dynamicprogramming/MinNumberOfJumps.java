package com.dynamicprogramming;

import java.util.stream.IntStream;

public class MinNumberOfJumps {

    public static int minNumberOfJumps(int[] array) {
//        int[] jumps = IntStream.generate(() -> Integer.MAX_VALUE).limit(array.length).toArray();
//        jumps[0] = 0;
//        for(int i = 1; i < array.length; i++) {
//            for(int j = 0; j < i; j++) {
//                if(j + array[j] >= i) {
//                    jumps[i] = Math.min(jumps[i], jumps[j]+1);
//                }
//            }
//        }
//        return jumps[array.length-1];

        if(array.length == 0)
            return 0;
        int steps = array[0], jumps = 1, maxReach = array[0];
        for(int i = 1; i < array.length-1; i++) {
            maxReach = Math.max(maxReach, i+array[i]);
            steps--;
            if(steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
        }
        return  jumps;
    }

    public static void main(String[] args) {
        int result = MinNumberOfJumps.minNumberOfJumps(new int[]{2, 1, 1});
        System.out.println(result);
    }

}
