package com.recurssion;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacci {

    public static int getNthFib(int n) {
        int[] fib = new int[]{0, 1};
        if(n == 1)
            return fib[0];
        for(int i = 3; i <= n; i++) {
            int next = fib[0] + fib[1];
            fib[0] = fib[1];
            fib[1] = next;
        }
        return fib[1];
    }

    public static void main(String[] args) {
        int result = NthFibonacci.getNthFib(2);
        System.out.println(result);
    }

}
