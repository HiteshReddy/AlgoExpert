package com.array;

import java.util.*;

public class FourNumberSum {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> quadlet = new ArrayList<>();
        Map<Integer, List<List<Integer>>> pairs = new HashMap<>();
        for(int i = 0; i < array.length; i++) {

            // traversing to the front
            for(int j = i+1; j < array.length; j++) {
                int diff = targetSum - (array[i] + array[j]);
                if(pairs.containsKey(diff)) {
                    List<List<Integer>> matchingPairs = pairs.get(diff);
                    for(List<Integer> p : matchingPairs) {
                        quadlet.add(new Integer[]{p.get(1), p.get(0), array[i], array[j]});
                    }
                }
            }

            //traversing to the back
            for(int k = 0; k < i; k++) {
                int currSum = array[i] + array[k];
                if(pairs.containsKey(currSum)) {
                    pairs.get(currSum).add(Arrays.asList(array[i], array[k]));
                } else {
                    List<List<Integer>> p = new ArrayList<>();
                    p.add(Arrays.asList(array[i], array[k]));
                    pairs.put(currSum, p);
                }
            }
        }
        return quadlet;
    }

    public static void main(String[] args) {
        List<Integer[]> result = FourNumberSum.fourNumberSum(new int[]{7, 6, 4, -1, 1, 2}, 16);
        result.stream().forEach(r -> {
            System.out.println(r[0] + ", " + r[1] + ", " + r[2] + ", " + r[3]);
        });
    }

}
