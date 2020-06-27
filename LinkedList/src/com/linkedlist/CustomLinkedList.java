package com.linkedlist;

public class CustomLinkedList {

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if(head == null){
                head = node;
                tail = node;
            } else {
                insertBefore(head, node);
            }
        }

        public void setTail(Node node) {
            if(tail == null) {
                setHead(node);
            } else {
                insertAfter(tail, node);
            }
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            if (head == nodeToInsert && tail == nodeToInsert) {
                return;
            }
            remove(nodeToInsert);
            Node p = node.prev;
            nodeToInsert.prev = p;
            nodeToInsert.next = node;
            if (p != null) {
                p.next = nodeToInsert;
            } else {
                head = nodeToInsert;
            }
            node.prev = nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if(head == nodeToInsert && tail == nodeToInsert) {
                return;
            }
            remove(nodeToInsert);
            Node n = node.next;
            nodeToInsert.next = n;
            nodeToInsert.prev = node;
            if(n != null) {
                n.prev = nodeToInsert;
            } else {
                tail = nodeToInsert;
            }
            node.next = nodeToInsert;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            if(position == 1) {
                setHead(nodeToInsert);
                return;
            }
            int cursor = 1;
            Node t = head;
            while(t != null && cursor != position) {
                t = t.next;
                cursor++;
            }
            if(t == null) {
                setTail(nodeToInsert);
            } else {
                insertBefore(t, nodeToInsert);
            }
        }

        public void removeNodesWithValue(int value) {
            Node node = head;
            while(node != null) {
                Node nodeToVerify = node;
                node = node.next;
                if(nodeToVerify.value == value) {
                    remove(nodeToVerify);
                }
            }
        }

        public void remove(Node node) {
            if(head == node) {
                head = node.next;
            }
            if(tail == node) {
                tail = tail.prev;;
            }
            removeBindings(node);
        }

        private void removeBindings(Node node) {
            if(node.prev != null) node.prev.next = node.next;
            if(node.next != null) node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }

        public boolean containsNodeWithValue(int value) {
            Node p = head;
            while(p != null && p.value != value) {
                p = p.next;
            }
            return p != null;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
