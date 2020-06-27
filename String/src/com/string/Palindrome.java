package com.string;

public class Palindrome {

    public static boolean isPalindrome(String str) {
        int start = 0, end = str.length()-1;
        while(start <= end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = Palindrome.isPalindrome("abcdcbaa");
        System.out.println(result);
    }

}
