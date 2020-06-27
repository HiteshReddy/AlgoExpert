package com.string;

public class LongestPalindromeString {

    static class Longest {
        public int startIdx;
        public int endIdx;
        public int longest;

        public Longest(int startIdx, int endIdx, int longest) {
            this.startIdx = startIdx;
            this.endIdx = endIdx;
            this.longest = longest;
        }
    }

    public static String longestPalindromicSubstring(String str) {
        Longest l = new Longest(0, 0, Integer.MIN_VALUE);
        int longest = Integer.MIN_VALUE, left = 0, right = 0;
        for(int i = 0; i < str.length(); i++) {
            int leftIdx = i-1, rightIdx = i+1;
            calculateLongest(str, leftIdx, rightIdx, l);

            leftIdx = i - 1; rightIdx = i;
           calculateLongest(str, leftIdx, rightIdx, l);
        }
        return str.substring(l.startIdx, l.endIdx+1);
    }

    private static void calculateLongest(String str, int leftIdx, int rightIdx, Longest l) {
        while(leftIdx >= 0 && rightIdx < str.length()) {
            if (str.charAt(leftIdx) == str.charAt(rightIdx)) {
                leftIdx--;
                rightIdx++;
            } else {
                break;
            }
        }
        int currSize = (rightIdx - 1) - (leftIdx + 1);
        if (currSize > l.longest) {
            l.startIdx = leftIdx+1;
            l.endIdx = rightIdx-1;
            l.longest = currSize;
        }
    }

    public static void main(String[] args) {
        String result = LongestPalindromeString.longestPalindromicSubstring("a");
        System.out.println(result);
    }

}
