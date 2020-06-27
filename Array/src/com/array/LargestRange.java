package com.array;

import java.util.HashMap;
import java.util.Map;

public class LargestRange {

    public static int[] largestRange(int[] array) {
        int[] largestRange = new int[2];
        int longestLength = 0;
        Map<Integer, Boolean> finder = new HashMap<>();
        for(int i : array) {
            finder.put(i, false);
        }
        for(int i : array) {
            if(finder.get(i) == true)
                continue;
            finder.put(i, true);
            int left = i-1, right = i+1, currentLength = 1;
            while(finder.containsKey(left)) {
                finder.put(left, true);
                currentLength++;
                left -= 1;
            }
            while(finder.containsKey(right)) {
                finder.put(right, true);
                currentLength++;
                right += 1;
            }
            if(currentLength > longestLength) {
                longestLength = currentLength;
                largestRange[0] = left + 1;
                largestRange[1] = right - 1;
            }
        }
        return largestRange;
    }

    public static void main(String[] args) {
        int[] largestRange = LargestRange.largestRange(new int[]{1, 11, 5, 2, 3, 6});
        System.out.println(largestRange[0]);
        System.out.println(largestRange[1]);
    }

}
