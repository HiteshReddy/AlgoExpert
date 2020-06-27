package com.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(List<String> words) {
        final Map<String, List<String>> groups = new TreeMap<>();
        words.forEach(word -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars).trim();
            groups.computeIfPresent(sorted, (key, value) -> {
                value.add(word);
                return value;
            });
            groups.computeIfAbsent(sorted, (key) -> {
                List<String> l = new ArrayList<>();
                l.add(word);
                return l;
            });
        });
        List<List<String>> result = new ArrayList<>();
        groups.values().forEach(group -> result.add(group));
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> result = GroupAnagrams.groupAnagrams(Arrays.asList("abc", "dabd", "bca", "cab", "ddba"));
        result.stream().flatMap(List::stream).forEach(word -> System.out.println(word));
    }

}
