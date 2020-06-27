package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KnapsnackProblem {

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[][] cap = new int[items.length+1][capacity+1];
        Arrays.fill(cap[0], 0);


        for(int i = 1; i <= items.length; i++) {
            for(int j = 0; j <= capacity; j++) {
                if(j >= items[i-1][1])
                    cap[i][j] = Math.max(cap[i-1][j], (items[i-1][0] + cap[i-1][j-items[i-1][1]]));
                else
                    cap[i][j] = cap[i-1][j];
            }
        }

        List<List<Integer>> combinations = new ArrayList<>();
        int i = items.length, j = capacity;
        combinations.add(Arrays.asList(cap[i][j]));
        List<Integer> indexes = new ArrayList<>();
        while(j > 0 && i > 0) {
            if(cap[i][j] > cap[i-1][j]) {
                indexes.add(i-1);
                i = i - 1;
                j = j - items[i][1];
            } else {
                i = i - 1;
            }
        }
        Collections.sort(indexes);
        combinations.add(indexes);

        return combinations;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = KnapsnackProblem.knapsackProblem(new int[][] {{1, 2}, {4, 3}, {5, 6}, {6, 7}}, 10);
        result.forEach(l -> System.out.println(l));
    }

}
