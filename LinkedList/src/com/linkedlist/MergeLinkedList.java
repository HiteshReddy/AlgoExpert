package com.linkedlist;

import java.util.Arrays;
import java.util.List;

public class MergeLinkedList {

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList temp = new LinkedList(-1);
        LinkedList merged = temp;
        while(headOne != null && headTwo != null) {
            if(headOne.value < headTwo.value) {
                temp.next = headOne;
                headOne = headOne.next;
            } else {
                temp.next = headTwo;
                headTwo = headTwo.next;
            }
            temp = temp.next;
        }
        if(headOne != null) {
            temp.next = headOne;
        }
        if(headTwo != null) {
            temp.next = headTwo;
        }
        return merged.next;
    }

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void addMany(LinkedList parent, List<Integer> values) {
        for (int value : values) {
            parent.next = new LinkedList(value);
            parent = (LinkedList) parent.next;
        }
    }

    public static void main(String[] args) {
        LinkedList l2 = new LinkedList(1);
        addMany(l2, Arrays.asList(2, 3, 4));

        LinkedList l1 = new LinkedList(6);
        addMany(l1, Arrays.asList(7, 8));

        LinkedList result = mergeLinkedLists(l1, l2);
        while(result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }
}
