package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagTraverse {

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        int row = 0, col = 0;
        int rMax = array.size()-1, cMax = array.get(0).size()-1;
        boolean down = true;
        List<Integer> zigzag = new ArrayList<>();
        while(row >= 0 && row <= rMax && col >= 0 && col <= cMax) {
            zigzag.add(array.get(row).get(col));
            if(down) {
                if(col == 0 || row == rMax) {
                    down = false;
                    if(row == rMax) col++;
                    else row++;
                } else {
                    row++;
                    col--;
                }
            } else {
                if(row == 0 || col == cMax) {
                    down = true;
                    if(col == cMax) row++;
                    else col++;
                } else {
                    row--;
                    col++;
                }
            }
        }
        return zigzag;
    }

    public static void main(String[] args) {
        List<Integer> row1 = Arrays.asList(1, 3, 4, 10);
        List<Integer> row2 = Arrays.asList(2, 5, 9, 11);
        List<Integer> row3 = Arrays.asList(6, 8, 12 ,15);
        List<Integer> row4 = Arrays.asList(7, 13, 14, 16);

        List<List<Integer>> data = Arrays.asList(row1);
        System.out.println(zigzagTraverse(data));
    }

}
