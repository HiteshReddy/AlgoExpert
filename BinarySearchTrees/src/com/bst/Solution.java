package com.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static ArrayList<Integer> repeatedNumber(final List<Integer> B) {
        List<Integer> A = B.stream().collect(Collectors.toList());
        int missing = 0, duplicate = 0;
        for(int i = 0; i < A.size(); i++) {
            int val = Math.abs(A.get(i));
            if(A.get(val-1) < 0) {
                duplicate = Math.abs(A.get(i));
            } else {
                A.set(val-1, -1*A.get(val-1));
            }
        }
        missing = A.stream().filter(n -> n >= 0).findFirst().get();
        return new ArrayList<>(Arrays.asList(duplicate, missing));
    }

    public static void main(String[] args) {
        List<Integer> result = Solution.repeatedNumber(new ArrayList<>(Arrays.asList(3, 1, 2, 5, 3)));
        System.out.println(result);
    }
}
