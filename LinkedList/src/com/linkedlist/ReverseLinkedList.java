package com.linkedlist;

public class ReverseLinkedList {

    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList prev = null;
        while(head != null) {
            LinkedList curr = head;
            head = head.next;
            curr.next = prev;
            prev = curr;
        }
        return prev;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
