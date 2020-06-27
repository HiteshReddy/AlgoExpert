package com.dynamicprogramming;

public class LevenshteinDistance {

    public static int levenshteinDistance(String str1, String str2) {
        int[][] edits = new int[str1.length() + 1][str2.length() + 1];
        for(int i = 0; i < edits[0].length; i++) {
            edits[0][i] = i;
        }
        for(int i = 1; i < edits.length; i++) {
            edits[i][0] = edits[i - 1][0] + 1;
        }
        for(int i = 1; i <= str1.length(); i++) {
            for(int j = 1; j <= str2.length(); j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    edits[i][j] = Math.min(edits[i - 1][j - 1], Math.min(edits[i][j - 1], edits[i - 1][j])) + 1;
                }
            }
        }
        return edits[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        int result = levenshteinDistance("abc", "yabd");
        System.out.println(result);
    }

}
