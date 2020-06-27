package com.array;

public class LongestPeak {

    public static int longestPeak(int[] array) {
        int maxPeak = 0;
        for(int i = 1; i < array.length - 1;) {
            if(array[i] > array[i-1] && array[i] > array[i+1]) {
                int currMaxPeak = 3;
                int j = i - 1;
                int k = i - 2;
                while(i >= 0 && k >= 0&& array[j] > array[k]) {
                    currMaxPeak++;
                    j--;
                    k--;
                }
                j = i + 1;
                k = i + 2;
                while(j < array.length && k < array.length && array[j] > array[k]) {
                    currMaxPeak++;
                    j++;
                    k++;
                }
                maxPeak = Math.max(currMaxPeak, maxPeak);
                i = j;
            } else {
                i++;
            }
        }
        return maxPeak;
    }

    public static void main(String[] args) {
        int result = longestPeak(new int[]{1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1, -1});
        System.out.println(result);
    }

}
