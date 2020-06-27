package com.linkedlist;

public class FindLoop {

    public static LinkedList findLoop(LinkedList head) {
        LinkedList first = head;
        LinkedList second = head;
        while(first != null && second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if(first == second)
                break;
        }
        if(first != second) {
            return null;
        }
        first = head;
        while(first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
