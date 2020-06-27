package com.array;

import java.util.Arrays;

public class MinRewards {

//    public static int minRewards(int[] scores) {
//        int[] rewards = new int[scores.length];
//        Arrays.fill(rewards, 1);
//        for(int i = 1; i < scores.length; i++) {
//            if(scores[i] < scores[i-1]) {
//                for(int j = i-1; j >=0; j--) {
//                    if(scores[j] > scores[j + 1]) {
//                        rewards[j] = Math.max(rewards[j], rewards[j+1] + 1);
//                    }
//                }
//            } else {
//                rewards[i] = rewards[i-1] + 1;
//            }
//        }
//        return Arrays.stream(rewards).sum();
//    }

    public static int minRewards(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);
        for(int i = 1; i < scores.length; i++) {
            if(scores[i] > scores[i-1]) {
                rewards[i] = rewards[i-1] + 1;
            }
        }
        for(int i = scores.length-1; i > 0; i--) {
            if(scores[i] < scores[i-1]) {
                rewards[i-1] = Math.max(rewards[i-1], rewards[i] + 1);
            }
        }
        return Arrays.stream(rewards).sum();
    }

    public static void main(String[] args) {
        int result = MinRewards.minRewards(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5});
        System.out.println(result);
    }

}
