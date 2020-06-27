package com.graphs;

public class SingleCycleCheck {

    public static boolean hasSingleCycle(int[] array) {
        int idx = 0;
        int size = array.length;
        int currElem = array[idx];
        int count = 1;
        while(count <= size) {
            int toMoveIdx = idx + currElem;
            if(toMoveIdx < 0) {
                toMoveIdx = size + toMoveIdx;
            } else if(toMoveIdx > size - 1) {
                toMoveIdx = toMoveIdx % size;
            }
            int temp = array[toMoveIdx];
            array[toMoveIdx] = array[idx];
            currElem = temp;
            idx = toMoveIdx;
            count++;
        }
        return idx == 0;
    }

    public static void main(String[] args) {
        boolean result = hasSingleCycle(new int[]{0, 1, 1, 1, 1});
        System.out.println(result);
    }

}
