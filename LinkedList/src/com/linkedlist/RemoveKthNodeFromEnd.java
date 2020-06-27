package com.linkedlist;

public class RemoveKthNodeFromEnd {

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
//        int size = 0;
//        LinkedList temp = head;
//        while(temp != null) {
//            temp = temp.next;
//            size++;
//        }
//        if(k == size) {
//            head.value = head.next.value;
//            head.next = head.next.next;
//        }
//        temp = head;
//        LinkedList prev = null;
//        int cursor = 1;
//        while(cursor != (size - k + 1) || temp == null) {
//            prev = temp;
//            temp = temp.next;
//            cursor++;
//        }
//
//        if(temp != null) {
//            prev.next = temp.next;
//        }

        int cursor = 1;
        LinkedList first = head;
        LinkedList second = head;
        while(cursor <= k) {
            second = second.next;
            cursor++;
        }
        if(second == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        while(second.next != null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
     LinkedList l1 = new LinkedList(1);
     LinkedList l2 = new LinkedList(2);
     LinkedList l3 = new LinkedList(3);
     LinkedList l4 = new LinkedList(4);
     LinkedList l5 = new LinkedList(5);
     l1.next = l2;
     l2.next = l3;
     l3.next = l4;
     l4.next = l5;
     removeKthNodeFromEnd(l1, 5);
     while(l1 != null) {
         System.out.println(l1.value);
         l1 = l1.next;
     }
    }

}
