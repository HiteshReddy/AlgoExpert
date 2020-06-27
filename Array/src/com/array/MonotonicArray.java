package com.array;

public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {
        boolean decreasing = array[0] > array[array.length - 1];
        for(int i = 0; i < array.length - 1; i++) {
            if(decreasing && (array[i] < array[i + 1])) return false;
            else if(!decreasing && (array[i] > array[i + 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = isMonotonic(new int[]{-1, -5});
        System.out.println(result);
    }

}
