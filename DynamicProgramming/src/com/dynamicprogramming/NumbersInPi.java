package com.dynamicprogramming;

import java.util.*;
import java.util.stream.Collectors;

public class NumbersInPi {

    public static int numbersInPi(String pi, String[] numbers) {
        Set<String>  numSet = Arrays.stream(numbers).collect(Collectors.toSet());
        Map<Integer, Integer> cache = new HashMap<>();
        int minSpaces = findSpaces(pi, numSet, cache, 0);
        return minSpaces != Integer.MAX_VALUE ? minSpaces : -1;
    }

    private static int findSpaces(String pi, Set<String>  numSet, Map<Integer, Integer> cache, int idx) {
        if(idx == pi.length()) return -1;
        if(cache.containsKey(idx)) return cache.get(idx);
        int spaces = Integer.MAX_VALUE;
        for(int i = idx; i < pi.length(); i++) {
            String s = pi.substring(idx, i + 1);
            if(numSet.contains(s)) {
                int currSpace = findSpaces(pi, numSet, cache, i + 1);
                spaces = Math.min(spaces, (currSpace == Integer.MAX_VALUE) ? Integer.MAX_VALUE : currSpace + 1);
            }
        }
        cache.put(idx, spaces);
        return spaces;
    }

    public static void main(String[] args) {
        int result = numbersInPi("3141592653589793238462643383279", new String[]{"314159265358979323846", "26433", "8", "3279", "314159265", "35897932384626433832", "79"});
        System.out.println(result);
    }
}
