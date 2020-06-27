package com.dynamicprogramming;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestCommonSubsequence {

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        return (str1.length() >= str2.length()) ? sequence(str1, str2) : sequence(str2, str1);
    }

    public static List<Character> sequence(String str1, String str2) {
        String[][] lcs = new String[str1.length()+1][str2.length()+1];
        for(int i = 0; i <= str1.length(); i++) {
            lcs[i] = Stream.generate(() -> "").limit(str2.length()+1).toArray(String[]::new);
        }
        for(int i = 1; i <= str1.length(); i++) {
            for(int j = 1; j <= str2.length(); j++) {
                String s1 = "" + str1.charAt(i-1);
                String s2 = "" + str2.charAt(j-1);
                if(s1.equals(s2)) {
                    lcs[i][j] = lcs[i-1][j-1] + s1;
                } else {
                    if(lcs[i][j-1].length() > lcs[i-1][j].length()) {
                        lcs[i][j] = lcs[i][j-1];
                    } else {
                        lcs[i][j] = lcs[i-1][j];
                    }
                    // lcs[i][j] = lcs[i][j-1].compareTo(lcs[i-1][j]) > 0 ? lcs[i][j-1] : lcs[i-1][j];
                }
            }
        }
        String sequence = lcs[str1.length()][str2.length()];
        return sequence.chars().mapToObj(elem -> (char)elem).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Character> result = LongestCommonSubsequence.longestCommonSubsequence("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "CCCDDEGDHAGKGLWAJWKJAWGKGWJAKLGGWAFWLFFWAGJWKAG");
        System.out.println(result);
    }

}
