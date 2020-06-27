package com.dynamicprogramming;

import java.util.*;
import java.util.stream.Collectors;

public class DiskStacking {

    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        // sort the data based on height
        Collections.sort(disks, Comparator.comparing(l -> l[2]));

        Integer[] heights = disks.stream().map(l -> l[2]).collect(Collectors.toList()).toArray(new Integer[disks.size()]);
        int[] sequence = new int[disks.size()];
        Arrays.fill(sequence, -1);
        int maxHeightIdx = 0;

        // for 0 <= i < disks.size()
        // for 0 <= j < i, compare the disks width, depth and height
        // If the disk is smaller, then add the new height in heights array and update the sequence
        for(int i = 1; i < disks.size(); i++) {
            Integer[] curr = disks.get(i);
            for(int j = 0; j <  i; j++) {
                Integer[] prev = disks.get(j);
                if(curr[0] > prev[0] && curr[1] > prev[1] && curr[2] > prev[2]) {
                    if(curr[2] + heights[j] > heights[i]) {
                        heights[i] =  curr[2] + heights[j];
                        sequence[i] = j;
                    }
                }
            }
            if(heights[i] > heights[maxHeightIdx])
                maxHeightIdx = i;
        }

        List<Integer[]> result = new ArrayList<>();
        while(maxHeightIdx != -1) {
            result.add(disks.get(maxHeightIdx));
            maxHeightIdx = sequence[maxHeightIdx];
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
//        List<Integer[]> data = Arrays.asList(new Integer[]{2, 1, 2}, new Integer[]{3, 2, 3}, new Integer[]{2, 2, 8}, new Integer[]{2, 3, 4}, new Integer[]{1, 3, 1}, new Integer[]{4, 4, 5});
        List<Integer[]> data = Arrays.asList(new Integer[]{2, 1, 2}, new Integer[]{3, 2, 3}, new Integer[]{2, 2, 8});
        List<Integer[]> result = DiskStacking.diskStacking(data);
        for(Integer[] i : result)
            Arrays.stream(i).forEach(j -> System.out.print(j + " "));
    }

}
