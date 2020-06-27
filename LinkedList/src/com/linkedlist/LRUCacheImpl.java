package com.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheImpl {

    static class LRUCache {
        int maxSize;
        Map<String, Node> map = new HashMap<>();
        DoubleLinkedList list = new DoubleLinkedList();
        int currentSize;

        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
        }

        public void insertKeyValuePair(String key, int value) {
            if(map.containsKey(key)) {
                Node node = map.get(key);
                list.remove(node);
                node.value = value;
                list.addHead(node);
                map.put(key, node);
            } else {
                if(currentSize == maxSize) {
                    Node tail = list.tail;
                    list.remove(tail);
                    map.remove(tail.key);
                    currentSize--;
                }
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                list.addHead(newNode);
                currentSize++;
            }
        }

        public LRUResult getValueFromKey(String key) {
            if(map.containsKey(key)) {
                Node node = map.get(key);
                list.remove(node);
                list.addHead(node);
                return new LRUResult(true, node.value);
            }
            return new LRUResult(false, -1);
        }

        public String getMostRecentKey() {
            if(list.head == null)
                return null;
            Node node = list.head;
            return node.key;
        }
    }

    static class DoubleLinkedList {

        Node head;
        Node tail;

        public void addHead(Node node) {
            if(head == null) {
                head = node;
                tail = node;
                return;
            } else if(head == node) {
                return;
            } else if(node == tail) {
                tail = tail.prev;
                remove(tail);
            }
            Node currHead = head;
            node.next = currHead;
            currHead.prev = node;
            head = node;
        }

        public void remove(Node node) {
            if(head == node && tail == node) {
                head = null;
                tail = null;
                return;
            }
            if(node == head) {
                head = head.next;
            }
            if(node == tail) {
                tail = tail.prev;
            }
            if(node.prev != null) node.prev.next = node.next;
            if(node.next != null) node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }
    }

    static class Node {
        String key;
        int value;
        Node next;
        Node prev;

        public Node(String key, int value) { this.key = key; this.value = value; }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCacheImpl.LRUCache lru = new LRUCacheImpl.LRUCache(1);
        Map<String, Integer> letterMaps = new HashMap<String, Integer>();
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        letterMaps.put("a", 0);
        letterMaps.put("b", 1);
        letterMaps.put("c", 2);
        letterMaps.put("d", 3);
        letterMaps.put("e", 4);
        letterMaps.put("f", 5);
        letterMaps.put("g", 6);
        letterMaps.put("h", 7);
        letterMaps.put("i", 8);
        letterMaps.put("j", 9);
        int lruSize = 1;
        assert (lru.getValueFromKey("a").found == false);
        lru.insertKeyValuePair("a", 99);
        assert (lru.getMostRecentKey() == "a");
        assert (lru.getValueFromKey("a").value == 99);
        /* Add existing key when cache isn't full. */
        lru.insertKeyValuePair("a", 0);
        assert (lru.getMostRecentKey() == "a");
        assert (lru.getValueFromKey("a").value == 0);
        /* Add keys now that cache is at maximum capacity. */
        for (int i = lruSize; i < letters.length; i++) {
            String mostRecentLetter = letters[i - 1];
            assert (lru.getMostRecentKey() == mostRecentLetter);
            /* Test key retrieval when cache is full. */
            for (int j = i - lruSize; j < i; j++) {
                String letter = letters[j];
                assert (lru.getValueFromKey(letter).value == letterMaps.get(letter));
                assert (lru.getMostRecentKey() == letter);
            }
            String leastRecentLetter = letters[i - lruSize];
            String currentLetter = letters[i];
            assert (lru.getValueFromKey(currentLetter).found == false);
            lru.insertKeyValuePair(currentLetter, letterMaps.get(currentLetter));
            assert (lru.getMostRecentKey() == currentLetter);
            assert (lru.getValueFromKey(currentLetter).value == letterMaps.get(currentLetter));
            assert (lru.getValueFromKey(leastRecentLetter).found == false);
        }
    }

}
