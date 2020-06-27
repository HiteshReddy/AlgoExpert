package com.bst;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}

public class StackUsingLinkedList {

    Node top = null;

    public void push(int A) {
        Node newNode = new Node(A);
        Node temp = top;
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if(top == null) {
            return -1;
        }
        Node topNode = top;
        top = top.next;
        return topNode.data;
    }

    public int peek() {
        return top != null ? top.data : -1;
    }

    public static void main(String[] args) {
        StackUsingLinkedList sl = new StackUsingLinkedList();

        sl.push(1);
        sl.push(2);
        sl.push(3);

        System.out.println(sl.peek());

        System.out.println(sl.pop());
        System.out.println(sl.pop());
        System.out.println(sl.pop());
    }

}
