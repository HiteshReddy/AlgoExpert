package com.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplicate {

    public static String longestSubstringWithoutDuplication(String str) {
        Map<Character, Integer> occurrences = new HashMap<>();
        char[] chars = str.toCharArray();
        int longest = Integer.MIN_VALUE;
        int start = 0, end = 0;
        for(int leftIdx = 0, rightIdx = 0; rightIdx < chars.length; rightIdx++) {
            if(occurrences.containsKey(chars[rightIdx])) {
                int val = occurrences.get(chars[rightIdx]);
                for(int j = leftIdx; j <= val; j++) {
                    occurrences.remove(chars[j]);
                }
                leftIdx = val+1;
            }
            occurrences.put(chars[rightIdx], rightIdx);
            if(rightIdx - leftIdx > longest) {
                start = leftIdx;
                end = rightIdx;
                longest = rightIdx - leftIdx;
            }
        }
        return str.substring(start, end+1);
    }

    public static void main(String[] args) {
        String result = LongestSubstringWithoutDuplicate.longestSubstringWithoutDuplication("abcdeabcdefc");
        System.out.println(result);
    }

}
