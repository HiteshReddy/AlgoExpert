package com.bst;
class Entry<K, V> {
    K key;
    V value;
    // In case of collision, we store the entry using linked list
    Entry<K, V> next;

    public Entry(){}

    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

}

/**
 * 1. hashCode and equals has to be implemented by the given key
 * 2. Assuming the initial capacity is 8 and if the size exceeds the capacity, the Map is re-sized with double the capapcity
 *
 * Time Complexity: Constant time O(1) for both put and get
 *   But:
 *      1. In case of collision, we are interating through the list of values and comparing, so the time complexity in worst case becomes "O(n)"
 *      2. If the initialy capacity is exceeded, then the map has be re-sized and re calculated with again makes the worst case time complexity "o(n)"
 *
 * Space Complexity: linear time O(n) for storing the entries
 *
 */

public class SimpleMap<K, V> {
    Entry<K, V>[] entries;
    int capacity = 8; // choosing the initial capacity as 8, but many implementations has resizing based on load factor
    int size = 0;

    public SimpleMap() {
        entries = new Entry[capacity];
    }

    public SimpleMap(int capacity) {
        entries = new Entry[capacity];
    }

    /**
     * put the given key, value in the map
     */
    public void put(K key, V value) {

        // calculate the hashValue of the key and find the index based on the formula "(hashCode) % capacity"(basically we call this as bucketing)
        // In case of collision, add the entry to the list of values for the given index

        int idx = key.hashCode() % capacity;

        Entry<K, V> entry = new Entry(key, value, null);
        Entry<K, V> current = entries[idx];
        if(current == null) {
            entries[idx] = entry;
            size++;
        } else {
            // In case there is an entry for the given key(collision), add the new entry to the list of values
            while(current != null) {
                // In case of duplicate keys, don't make an entry, instead update it's value
                if(current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                // If the entry is the last element of the list, then add the new entry in the list
                if(current.next == null) {
                    current.next = entry;
                    size++;
                }
                // traverse to the last element of the list
                current = current.next;
            }
        }
        if(size == capacity) {
            // resize the map and re-calculate the index of each key
            reSizeAndReCalculate();
        }
    }

    /**
     * re-size the array with double the capcity and re-arrange the indexes based on the new capacity
     */
    private void reSizeAndReCalculate() {
        Entry<K, V>[] oldEntries = entries;
        capacity = capacity * 2;
        entries = new Entry[capacity];
        for(Entry<K, V> entry : oldEntries) {
            this.put(entry.key, entry.value);
        }
    }

    /**
     * retrieves the value for the given key
     */
    public V get(K key) {
        int idx = key.hashCode() % capacity;
        Entry<K, V> entry = entries[idx];
        while(entry != null) {
            if(entry.key.equals(key))
            {
                return entry.value;
            }
            entry = entry.next;
        }
        // In case there are entries for the given key
        return null;
    }

    /**
     * returns the size of the map
     */
    public int size() {
        return this.size;
    }

    public static void main(String args[]) {
        SimpleMap mapImpl = new SimpleMap();
        mapImpl.put("A", "1");
        mapImpl.put("A", "2");
        mapImpl.put("C", "3");
        mapImpl.put("D", "4");
        mapImpl.put("E", "5");

        assert mapImpl.get("A").equals("2") : "wrong value returned for A";
        assert mapImpl.size() == 4 : "wrong size returned";
    }
}