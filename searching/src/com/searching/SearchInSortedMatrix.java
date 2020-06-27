package com.searching;

public class SearchInSortedMatrix {

//    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
//        int topIdx = 0, rightIdx = matrix[0].length - 1;
//        while(rightIdx >= 0 && topIdx <= matrix.length - 1) {
//            int val = matrix[topIdx][rightIdx];
//            if(target == val) {
//                return new int[]{topIdx, rightIdx};
//            } else if(val > target) {
//                rightIdx--;
//            } else {
//                topIdx++;
//            }
//        }
//        return new int[]{-1, -1};
//    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int row = 0, column = matrix[0].length - 1;
        while(row <= matrix.length-1 && column >= 0) {
            int val = matrix[row][column];
            if(target == val) {
                return new int[]{row, column};
            } else if(val > target) {
                column--;
            } else {
                row++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 4, 7, 12, 15, 1000}, {2, 5, 19, 31, 32, 1001}, {3, 8, 24, 33, 35, 1002}, {40, 41, 42, 44, 45, 1003}, {99, 100, 103, 106, 128, 1004}};
        int[] result = searchInSortedMatrix(array, 44);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

}
