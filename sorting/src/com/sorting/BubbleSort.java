package com.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        boolean hasSwap = true;
        int counter = 0;
        while(hasSwap) {
            hasSwap = false;
            for(int i = 0; i < array.length - 1 - counter; i++) {
                if(array[i] > array[i+1]) {
                    swap(array, i, i+1);
                    hasSwap = true;
                }
            }
            counter++;
        }
        return array;
    }

    private static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void main(String[] args) {
//        int[] result = bubbleSort(new int[]{8, 5, 2, 11, 3});
//        Arrays.stream(result).forEach(i -> System.out.println(i));
        System.out.println(1 + 2 + 5 * 4 / 5 + 2);
    }

}
