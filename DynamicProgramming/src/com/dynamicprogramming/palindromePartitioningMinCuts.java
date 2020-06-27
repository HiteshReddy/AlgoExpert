package com.dynamicprogramming;

import java.util.Arrays;

public class palindromePartitioningMinCuts {

    public static int palindromePartitioningMinCuts(String str) {
        int[][] palindromes = new int[str.length()][str.length()];
        int[] cuts = new int[str.length()];
        Arrays.fill(cuts, Integer.MAX_VALUE);
        for(int i = 0; i < str.length(); i++) {
            palindromes[i][i] = 1;
        }
        for(int i = 2; i <= str.length(); i++) {
            for(int j = 0; j <= str.length() - i; j++) {
                int k = i + j - 1;
                if(i == 2) {
                    palindromes[j][k] = str.charAt(j) == str.charAt(k) ? 1 : 0;
                } else {
                    palindromes[j][k] = (str.charAt(j) == str.charAt(k) && palindromes[j+1][k-1] == 1) ? 1 : 0;
                }
            }
        }

        cuts[0] = 0;
        for(int i = 1; i < str.length(); i++) {
            if(palindromes[0][i] == 1) {
                cuts[i] = 0;
            } else {
                cuts[i] = 1;
                for(int j = 1; j < i; j++) {
                    if(palindromes[j][i] == 0) {
                        cuts[i] = cuts[i] + 1;
                    } else {
                        cuts[i] = cuts[j-1] + 1;
                        break;
                    }
                }
                cuts[i] = Math.min(cuts[i-1] + 1, cuts[i]);
            }
        }

        return cuts[str.length()-1] == Integer.MAX_VALUE ? 0 : cuts[str.length()-1];
    }

    public static void main(String[] args) {
        int result = palindromePartitioningMinCuts("abbad");
        System.out.println(result);
    }

}
