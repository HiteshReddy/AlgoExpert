package com.array;

import java.util.Arrays;
import java.util.List;

public class MoveElementsToEnd {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int left = 0, right = array.size()-1;
        while(left < right) {
            if(array.get(left) == toMove) {
                if(array.get(right) == toMove) {
                    right--;
                } else {
                    array.set(left, array.get(right));
                    array.set(right, toMove);
                    left++;
                    right--;
                }
            } else {
                left++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> result = MoveElementsToEnd.moveElementToEnd(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2), 2);
        System.out.println(result);
    }

}
