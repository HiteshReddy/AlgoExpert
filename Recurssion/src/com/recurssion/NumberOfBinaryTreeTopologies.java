package com.recurssion;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBinaryTreeTopologies {

    public static int numberOfBinaryTreeTopologies(int n) {
        int result = numberOfBinaryTreeTopologies(n, new HashMap<Integer, Integer>());
        return result;
    }

    public static int numberOfBinaryTreeTopologies(int n, Map<Integer, Integer> cache) {
        if(n == 0)
            return 1;
        if(cache.containsKey(n))
            return cache.get(n);
        int total = 0;
        for(int L = 0; L < n; L++) {
            int left = numberOfBinaryTreeTopologies(L, cache);
            int right = numberOfBinaryTreeTopologies(n-1-L, cache);
            total += left * right;
        }
        cache.put(n, total);
        return total;
    }

    public static void main(String[] args) {
        int result = NumberOfBinaryTreeTopologies.numberOfBinaryTreeTopologies(5);
        System.out.println(result);
    }
}
