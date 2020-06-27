package com.recurssion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static int productSum(List<Object> array) {
        return productSum(array, 0, 1);
    }

    public static int productSum(List<Object> array, int sum, int deapth) {
        for(int i = 0; i < array.size(); i++) {
            Object obj = array.get(i);
            if(obj instanceof ArrayList) {
                sum += productSum((ArrayList)obj, 0, deapth+1);
            } else {
                sum += (int)obj;
            }
        }
        return (deapth)*sum;
    }

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        List<Object> subList1 = new ArrayList<>();
        subList1.add(7);
        subList1.add(-1);
        list.add(subList1);
        list.add(3);
        List<Object> subList2 = new ArrayList<>();
        subList2.add(6);
        List<Integer> subList3 = new ArrayList<>();
        subList3.add(-13);
        subList3.add(8);
        subList2.add(subList3);
        subList2.add(4);
        list.add(subList2);
        int result = ProductSum.productSum(list);
        System.out.println(result);
    }

}
