package com.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {

    public static boolean isAnagram(String first, String second) {
        if(first.length() != second.length()) {
            return false;
        }
        Map<String, Integer> firstOccurrences = new HashMap<>();
        for(String s: first.split("")) {
            firstOccurrences.computeIfPresent(s, (k, v) -> v+1);
            firstOccurrences.computeIfAbsent(s, (k) -> 1);
        }
        for(String s : second.split("")) {
            if(firstOccurrences.containsKey(s)) {
                firstOccurrences.put(s, firstOccurrences.get(s)-1);
            } else {
                return false;
            }
        }

        return !firstOccurrences.values().stream().filter(v -> v != 0).findAny().isPresent();
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "c");
        Employee e2 = new Employee(2, "b");
        Employee e3 = new Employee(1, "a");
        List<Employee> list = Arrays.asList(e1, e2, e3);
        Set<Employee> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        System.out.println(set.size());
    }

}

class Employee implements Comparable<Employee>{
    int id;
    String name;
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public int hashCode() {
        return this.id;
    }
    public boolean equals(Object o) {
        if(o instanceof Employee) {
            Employee e = (Employee)o;
            return Objects.equals(e.id, this.id);
        }
        return false;
    }
    public int compareTo(Employee e) {
        return Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getId)
                .compare(this, e);
    }
    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name;
    }
}

