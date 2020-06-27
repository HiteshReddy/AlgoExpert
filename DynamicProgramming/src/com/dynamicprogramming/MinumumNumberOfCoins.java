package com.dynamicprogramming;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinumumNumberOfCoins {

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        Arrays.sort(denoms);
        int totalMinWays = Integer.MAX_VALUE;
        for(int i = denoms.length-1; i >= 0; i--) {
            int s = n;
            int cursor = i;
            int minNumber = 0;
            while(s > 0 && cursor >= 0) {
                if(denoms[cursor] <= s) {
                    s -= denoms[cursor];
                    minNumber++;
                } else {
                    cursor--;
                }
            }
            if(s == 0 && minNumber < totalMinWays)
                totalMinWays = minNumber;
        }
        return (totalMinWays == Integer.MAX_VALUE) ? -1 : totalMinWays;
    }

    public static void main(String[] args) {
        int result = MinumumNumberOfCoins.minNumberOfCoinsForChange(135, new int[]{39, 45, 130, 40, 4, 1, 60, 75});
        System.out.println(result);
    }

}
