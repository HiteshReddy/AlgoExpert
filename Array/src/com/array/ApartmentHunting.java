package com.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentHunting {

//    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
//        final int[] distance = new int[blocks.size()];
//        for(int i = 0; i < blocks.size(); i++) {
//            Map<String, Boolean> block = blocks.get(i);
//            int dist = 0;
//            for(String req: reqs){
//                if(block.get(req) != true)
//                    dist = Math.max(dist, nearest(blocks, req, i));
//            }
//            distance[i] = dist;
//        };
//        int blockWithNearest = Integer.MAX_VALUE;
//        int currMin = Integer.MAX_VALUE;
//        for(int i = 0; i < distance.length; i++) {
//            if (distance[i] < currMin) {
//                currMin = distance[i];
//                blockWithNearest = i;
//            }
//        }
//        return blockWithNearest;
//    }
//
//    private static int nearest(List<Map<String, Boolean>> blocks, String requirement, int index) {
//        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
//        for(int i = index+1; i < blocks.size(); i++) {
//            Map<String, Boolean> block = blocks.get(i);
//            if(block.get(requirement) == true) {
//                right = i - index;
//                break;
//            }
//        }
//        for(int i = index; i >=0; i--) {
//            Map<String, Boolean> block = blocks.get(i);
//            if(block.get(requirement) == true) {
//                left = index - i;
//                break;
//            }
//        }
//        return Math.min(left, right);
//    }

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int[][] distances = new int[reqs.length][blocks.size()];
        for(int i = 0; i < reqs.length; i++) {
            String req = reqs[i];
            int[] currReqDist = distances[i];
            int lastAvailReq = Integer.MAX_VALUE;
            for(int j = 0; j < blocks.size(); j++) {
                Map<String, Boolean> block = blocks.get(j);
                if(block.get(req) == true) {
                    lastAvailReq = j;
                    currReqDist[j] = 0;
                } else if(lastAvailReq == Integer.MAX_VALUE){
                    currReqDist[j] = lastAvailReq;
                } else {
                    currReqDist[j] = j-lastAvailReq;
                }
            }
            lastAvailReq = Integer.MAX_VALUE;
            for(int j = blocks.size()-1; j >= 0; j--) {
                Map<String, Boolean> block = blocks.get(j);
                if(block.get(req) == true) {
                    lastAvailReq = j;
                    currReqDist[j] = 0;
                } else if(lastAvailReq != Integer.MAX_VALUE){
                    currReqDist[j] = Math.min(currReqDist[j], lastAvailReq-j);
                }
            }
        }
        int optimumBlock = Integer.MAX_VALUE;
        int minimalDistance = Integer.MAX_VALUE;
        for(int i = 0; i < blocks.size(); i++) {
            int dist = Integer.MIN_VALUE;
            for(int j = 0; j < distances.length; j++) {
                dist = Math.max(dist, distances[j][i]);
            }
            if(dist < minimalDistance) {
                minimalDistance = dist;
                optimumBlock = i;
            }
        }
        return optimumBlock;
    }

    public static void main(String[] args) {
        Map<String, Boolean> m1  = new HashMap<String, Boolean>() {{
            put("gym", true);
            put("office", false);
            put("pool", false);
            put("school", true);
            put("store", false);
        }};
        Map<String, Boolean> m2  = new HashMap<String, Boolean>() {{
            put("gym", false);
            put("office", false);
            put("pool", false);
            put("school", false);
            put("store", false);
        }};
        Map<String, Boolean> m3  = new HashMap<String, Boolean>() {{
            put("gym", false);
            put("office", true);
            put("pool", false);
            put("school", true);
            put("store", false);
        }};
        Map<String, Boolean> m4  = new HashMap<String, Boolean>() {{
            put("gym", false);
            put("office", true);
            put("pool", false);
            put("school", false);
            put("store", false);
        }};
        Map<String, Boolean> m5  = new HashMap<String, Boolean>() {{
            put("gym", false);
            put("office", false);
            put("pool", false);
            put("school", false);
            put("store", true);
        }};
        Map<String, Boolean> m6  = new HashMap<String, Boolean>() {{
            put("gym", true);
            put("office", true);
            put("pool", false);
            put("school", false);
            put("store", false);
        }};
        Map<String, Boolean> m7  = new HashMap<String, Boolean>() {{
            put("gym", false);
            put("office", false);
            put("pool", true);
            put("school", false);
            put("store", false);
        }};
        Map<String, Boolean> m8  = new HashMap<String, Boolean>() {{
            put("gym", false);
            put("office", false);
            put("pool", false);
            put("school", false);
            put("store", false);
        }};
        Map<String, Boolean> m9  = new HashMap<String, Boolean>() {{
            put("gym", false);
            put("office", false);
            put("pool", false);
            put("school", false);
            put("store", false);
        }};
        Map<String, Boolean> m10  = new HashMap<String, Boolean>() {{
            put("gym", false);
            put("office", false);
            put("pool", false);
            put("school", true);
            put("store", false);
        }};
        Map<String, Boolean> m11  = new HashMap<String, Boolean>() {{
            put("gym", false);
            put("office", false);
            put("pool", true);
            put("school", false);
            put("store", false);
        }};

        List<Map<String, Boolean>> blocks = Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11);
        int result = ApartmentHunting.apartmentHunting(blocks, new String[]{"gym", "office", "pool", "school", "store"});
        System.out.println(result);
    }

}
