package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class MaximumSubIncreasingSubsequence {

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[] sums = new int[array.length];
        int[] indexes = IntStream.generate(() -> -1).limit(array.length).toArray();
        int max = -1, maxIdx = -1;

        for(int i = 0; i < array.length; i++) {
            sums[i] = array[i];
            for(int j = 0; j < i; j++) {
                if(array[j] < array[i]) {
                    if(array[i] + sums[j] > sums[i]) {
                        sums[i] = array[i] + sums[j];
                        indexes[i] = j;
                    }
                }
            }
            if(sums[i] > max) {
                max = sums[i];
                maxIdx = i;
            }
        }
        List<Integer> sequence = new ArrayList<>();
        while(maxIdx >= 0) {
            sequence.add(array[maxIdx]);
            maxIdx = indexes[maxIdx];
        }
        Collections.sort(sequence);
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(max));
        result.add(sequence);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = MaximumSubIncreasingSubsequence.maxSumIncreasingSubsequence(new int[]{-1 ,1});
        result.forEach(l -> System.out.println(l));
    }

}
