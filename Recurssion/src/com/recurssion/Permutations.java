package com.recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

//    public static List<List<Integer>> getPermutations(List<Integer> array) {
//        List<List<Integer>> permutations = new ArrayList<>();
//        getPermutations(array, new ArrayList<>(), permutations);
//        return permutations;
//    }
//
//    private static void getPermutations(List<Integer> array, List<Integer> currentPerm, List<List<Integer>> allPermutations) {
//        if(array.isEmpty()) {
//            allPermutations.add(currentPerm);
//        } else {
//            for(int i = 0; i < array.size(); i++) {
//                List<Integer> sliced = new ArrayList<>(array);
//                sliced.remove(i);
//                List<Integer> newPermutation = new ArrayList<>(currentPerm);
//                newPermutation.add(array.get(i));
//                getPermutations(sliced, newPermutation, allPermutations);
//            }
//        }
//    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutations(0, array, permutations);
        return permutations;
    }

    private static void getPermutations(int index, List<Integer> array, List<List<Integer>> allPermutations) {
        if(index == array.size()-1) {
            allPermutations.add(new ArrayList<Integer>(array));
        } else {
            for(int j = index; j < array.size(); j++) {
                swap(array, index, j);
                getPermutations(index+1, array, allPermutations);
                swap(array, index, j);
            }
        }
    }

    private static void swap(List<Integer> array, int i,int j) {
        Integer t = array.get(i);
        array.set(i, array.get(j));
        array.set(j, t);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.getPermutations(Arrays.asList(1, 2, 3));
        result.forEach(l -> System.out.println(l));
    }

}
