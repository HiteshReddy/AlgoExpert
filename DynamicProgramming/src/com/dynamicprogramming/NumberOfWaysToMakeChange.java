package com.dynamicprogramming;

import java.util.stream.IntStream;

public class NumberOfWaysToMakeChange {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
       int[] ways = findWays(n, denoms);
       return ways[n];
    }

    public static int[] findWays(int n, int[] denoms) {
        int[] ways = IntStream.generate(() -> 0).limit(n+1).toArray();
        ways[0] = 1;
        for(int i = 0; i < denoms.length; i++) {
            for(int j = 1; j < ways.length; j++) {
                if(denoms[i] <= n && denoms[i] <= j) {
                    ways[j] += ways[j - denoms[i]];
                }
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        int result = NumberOfWaysToMakeChange.numberOfWaysToMakeChange(15, new int[]{1, 5, 10, 25});
        System.out.println(result);
    }

}
