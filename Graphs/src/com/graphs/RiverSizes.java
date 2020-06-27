package com.graphs;

import java.util.*;

public class RiverSizes {

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        boolean[][] aux = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(aux[i][j]) continue;
                traverse(i, j, matrix, aux, sizes);
            }
        }
        Collections.sort(sizes);
        return sizes;
    }

    private static void traverse(int i, int j, int[][] matrix, boolean[][] aux, List<Integer> sizes) {
        List<Integer[]> nodes = new ArrayList<>();
        nodes.add(new Integer[]{i, j});
        int riverSize = 0;
        while(!nodes.isEmpty()) {
            Integer[] curr = nodes.get(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);
            i = curr[0];
            j = curr[1];
            if(aux[i][j]){ continue; }
            aux[i][j] = true;
            if(matrix[i][j] == 0){ continue; }
            riverSize++;
            List<Integer[]> allPossibleNodes = getAllPossibleNodes(i, j, matrix, aux);
            nodes.addAll(allPossibleNodes);
        }
        if(riverSize > 0) sizes.add(riverSize);
    }

    private static List<Integer[]> getAllPossibleNodes(int i, int j, int[][] matrix, boolean[][] aux) {
        List<Integer[]> possibleNodes = new ArrayList<>();
        if(i > 0 && !aux[i-1][j]) {
            possibleNodes.add(new Integer[]{i-1, j});
        }
        if(i < matrix.length-1 && !aux[i+1][j]) {
            possibleNodes.add(new Integer[]{i+1, j});
        }
        if(j > 0 && !aux[i][j-1]) {
            possibleNodes.add(new Integer[]{i, j-1});
        }
        if(j < matrix[0].length-1 && !aux[i][j+1]) {
            possibleNodes.add(new Integer[]{i, j+1});
        }
        return possibleNodes;
    }

    public static void main(String[] args) {
        int[] i1 = new int[]{1, 0, 0, 1, 0};
        int[] i2 = new int[]{1, 0, 1, 0, 0};
        int[] i3 = new int[]{0, 0, 1, 0, 1};
        int[] i4 = new int[]{1, 0, 1, 0, 1};
        int[] i5 = new int[]{1, 0, 1, 1, 0};

        // int[][] data = new int[][]{i1, i2, i3, i4, i5};
        int[][] data = {
                {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1},
        };
        List<Integer> result = riverSizes(data);
        result.stream().forEach(i -> System.out.println(i));
    }

}
