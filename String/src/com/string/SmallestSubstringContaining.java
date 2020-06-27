package com.string;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringContaining {

    public static String smallestSubstringContaining(String bigString, String smallString) {
        Map<Character, Integer> smallMap = new HashMap<>();
        Map<Character, Integer> bigMap = new HashMap<>();
        for(char aChar : smallString.toCharArray())
            smallMap.merge(aChar, 1, Integer::sum);

        int lIdx = 0, rIdx = 0, smallest = Integer.MAX_VALUE;
        int leftIdx = 0,
                rightIdx = 0,
                length = bigString.length(),
                uniqueChars = smallMap.size(),
                currentUniqueChars = 0;
        while(leftIdx < length && rightIdx < length) {
            char ch = bigString.charAt(rightIdx);
            bigMap.computeIfPresent(ch, (k, v) -> v+1);
            bigMap.computeIfAbsent(ch, (k) -> 1);

            if(bigMap.get(ch).equals(smallMap.get(ch))) {
                currentUniqueChars++;
            }

            while(currentUniqueChars == uniqueChars ) {
                if((rightIdx - leftIdx) < smallest) {
                    lIdx = leftIdx;
                    rIdx = rightIdx;
                    smallest = (rIdx-lIdx);
                }
                char currCh = bigString.charAt(leftIdx);
                bigMap.computeIfPresent(currCh, (k, v) -> v-1);
                if(smallMap.containsKey(currCh) && bigMap.get(currCh) < smallMap.get(currCh)) {
                    currentUniqueChars--;
                }
                leftIdx++;
            }
            rightIdx++;

        }

        return (smallest == Integer.MAX_VALUE) ? new String() : bigString.substring(lIdx, rIdx+1);
    }

    public static void main(String[] args) {
        String result = SmallestSubstringContaining.smallestSubstringContaining("abcd$ef$axb$c$", "f$axb$");
        System.out.println(result);
    }

}
