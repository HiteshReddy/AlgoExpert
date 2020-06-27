package com.dynamicprogramming;

import java.util.Arrays;

public class WaterArea {

    public static int waterArea(int[] heights) {
        int leftMax = 0, rightMax = 0;
        int[] leftMaxArr = new int[heights.length];
        int[] rightMaxArr = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
            leftMaxArr[i] = leftMax;
            leftMax = heights[i] > leftMax ? heights[i] : leftMax;
        }
        for(int i = heights.length-1; i >= 0; i--) {
            rightMaxArr[i] = rightMax;
            rightMax = heights[i] > rightMax ? heights[i] : rightMax;
        }
        int area = 0;
        for(int i = 0; i < heights.length; i++) {
            area += (heights[i] < Math.min(leftMaxArr[i], rightMaxArr[i])) ? Math.min(leftMaxArr[i], rightMaxArr[i]) - heights[i] : 0;
        }
        return area;
    }

    public static void main(String[] args) {
        // int result = WaterArea.waterArea(new int[]{0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3});
        int result = WaterArea.waterArea(new int[]{1, 5, 4, 3});
        System.out.println(result);
    }

}
