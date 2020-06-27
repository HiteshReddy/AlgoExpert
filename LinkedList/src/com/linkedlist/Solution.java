package com.linkedlist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int pow(int x, int n, int d) {

        long[] cache = new long[n];
        Arrays.fill(cache, -1);
        long r = pow(x, n, cache);
        int fr = (int)(r%d);
        return fr;
    }

    public static long pow(int x, int n, long[] cache) {
        if(n == 1) {
            return x;
        }
        if(cache[n] != -1) return cache[n];
        long temp = pow(x, n/2, cache);
        if(n % 2 == 0) {
            cache[n] = temp*temp;
            return cache[n];
        } else {
            cache[n] = x*temp*temp;
            return cache[n];
        }
    }

    public static void main(String[] args) {
        long[] cache = new long[9];
        Arrays.fill(cache, -1);
        long result = pow(2, 7, cache);
        System.out.println(result);
    }

}
