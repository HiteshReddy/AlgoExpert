package com.recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Powerset {

//    public static List<List<Integer>> powerset(List<Integer> array) {
//        List<List<Integer>> subSets = new ArrayList<>();
//        subSets.add(new ArrayList<>());
//        for(int e : array) {
//            int length = subSets.size();
//            for(int i = 0; i < length; i++) {
//                List<Integer> currentSubSet = new ArrayList<>(subSets.get(i));
//                currentSubSet.add(e);
//                subSets.add(currentSubSet);
//            }
//        }
//        return subSets;
//    }

    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> powerset = new ArrayList<>();
        powerset(powerset, array, array.size()-1);
        return powerset;
    }

    public static void powerset(List<List<Integer>> powerset, List<Integer> array, int index) {
        if (index < 0) {
            powerset.add(new ArrayList<>());
            return;
        }
        int ele = array.get(index);
        powerset(powerset, array, index-1);
        int length = powerset.size();
        for(int i = 0; i < length; i++) {
            List<Integer> currentPowerSet = new ArrayList<>(powerset.get(i));
            currentPowerSet.add(ele);
            powerset.add(currentPowerSet);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Powerset.powerset(Arrays.asList(1, 2, 3));
        System.out.println(result);
    }

}
