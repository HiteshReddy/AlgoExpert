package com.array;

public class SubarraySort {

    public static int[] subarraySort(int[] array) {
        int minOfUnsorted = Integer.MAX_VALUE, maxOfUnsorted = Integer.MIN_VALUE,
                left = -1, right = -1;
        for(int i = 0; i < array.length-1; ) {
            if(array[i] > array[i+1]) {
                minOfUnsorted = Math.min(minOfUnsorted, array[i+1]);
                maxOfUnsorted = Math.max(maxOfUnsorted, array[i]);
                i += 2;
            } else {
                i++;
            }
        }
        for(int i = 0; i < array.length; i++) {
            if(array[i] > minOfUnsorted) {
                left = i;
                break;
            }
        }
        for(int i = array.length-1; i >= 0; i--) {
            if(array[i] < maxOfUnsorted) {
                right = i;
                break;
            }
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        int[] result = SubarraySort.subarraySort(new int[]{10, 20, 11, 4, 11, 11, 20, 10, 11, 11, 20, 14, 11, 20, 20});
        System.out.println(result[0] + " " + result[1]);
    }
}
