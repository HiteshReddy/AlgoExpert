package com.bst;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SameBSTs {

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if(arrayOne.isEmpty() && arrayTwo.isEmpty()) {
            return true;
        }
        if(arrayOne.size() != arrayTwo.size() || (!arrayOne.get(0).equals(arrayTwo.get(0)))) {
            return false;
        }

        int arrayOneFirstValue = arrayOne.get(0);
        List<Integer> arrayOneSmaller = arrayOne
                .subList(1, arrayOne.size())
                .stream()
                .filter(i -> i < arrayOneFirstValue)
                .collect(Collectors.toList());

        int arrayTwoFirstValue = arrayTwo.get(0);
        List<Integer> arrayTwoSmaller = arrayTwo
                .subList(1, arrayOne.size())
                .stream()
                .filter(i -> i < arrayOneFirstValue)
                .collect(Collectors.toList());

        if(!sameBsts(arrayOneSmaller, arrayTwoSmaller)) {
            return false;
        }

        List<Integer> arrayOneLarger = arrayOne
                .subList(1, arrayOne.size())
                .stream()
                .filter(i -> i >= arrayOneFirstValue)
                .collect(Collectors.toList());

        List<Integer> arrayTwoLarger = arrayTwo
                .subList(1, arrayOne.size())
                .stream()
                .filter(i -> i >= arrayOneFirstValue)
                .collect(Collectors.toList());

        if(!sameBsts(arrayOneLarger, arrayTwoLarger)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        boolean result = SameBSTs.sameBsts(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11), Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
        System.out.println(result);
    }

}
