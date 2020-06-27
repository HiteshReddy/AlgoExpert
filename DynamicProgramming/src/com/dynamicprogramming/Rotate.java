package com.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class Rotate<T> {

    private static <T> void rotate1(List<T> list, int distance) {
        int size = list.size();
        if(size == 0)
            return;
        distance = distance%size;
        if(distance == 0)
            return;
        if(distance < 0)
            distance = size - distance;

        for(int i = 0, tMoved = 0; tMoved != size; i++) {
            T currVal = list.get(i);
            int currIdx = i;
            do {
                currIdx = currIdx + distance;
                if(currIdx >= size)
                    currIdx = currIdx - size;
                currVal = list.set(currIdx, currVal);
                tMoved++;
            } while(currIdx != i);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Rotate.rotate1(list, 1);
        System.out.println(list);
    }

}
