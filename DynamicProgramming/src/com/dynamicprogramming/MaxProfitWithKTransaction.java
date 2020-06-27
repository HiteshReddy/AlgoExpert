package com.dynamicprogramming;

import java.util.Arrays;

public class MaxProfitWithKTransaction {

    public static int maxProfitWithKTransactions(int[] prices, int k) {
        if(prices.length == 0)
            return 0;
        int[][] transactions = new int[k+1][prices.length];
        Arrays.fill(transactions[0], 0);

        for(int i = 1; i <= k; i++) {
            int maxPrevTransaction = Integer.MIN_VALUE;
            transactions[i][0] = 0;
            for(int j = 1; j < prices.length; j++) {
                maxPrevTransaction = Math.max(maxPrevTransaction, -prices[j-1] + transactions[i-1][j-1]);
                transactions[i][j] = Math.max((transactions[i][j-1]), prices[j] + maxPrevTransaction);
            }
        }
        return transactions[k][prices.length-1];
    }

    public static void main(String[] args) {
        int maxProfit = MaxProfitWithKTransaction.maxProfitWithKTransactions(new int[]{5, 11, 3, 50, 60, 90}, 2);
        System.out.println(maxProfit);
    }

}
