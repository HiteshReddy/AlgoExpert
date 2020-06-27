package com.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UnderscorifySubstring {

    public static String underscorifySubstring(String str, String substring) {
        List<List<Integer>> occurrences = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            if(substring.charAt(0) == str.charAt(i)) {
                findAndAddMatchingOccurence(str, substring, i, occurrences);
            }
        }

        for(int i = 0;  i < occurrences.size()-1; ) {
            List<Integer> l1 = occurrences.get(i);
            List<Integer> l2 = occurrences.get(i+1);
            if(l1.get(1) >= l2.get(0)) {
                occurrences.set(i, Arrays.asList(l1.get(0), l2.get(1)));
                occurrences.remove(i+1);
            } else {
                i++;
            }
        }

        List<Integer> mergedOccurrences = occurrences.stream().flatMap(List::stream).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); ) {
            if(!mergedOccurrences.isEmpty() &&  i == mergedOccurrences.get(0)){
                sb.append("_");
                mergedOccurrences.remove(0);
            } else {
                sb.append(str.charAt(i));
                i++;
            }
        }
        if(!mergedOccurrences.isEmpty()) {
            sb.append("_");
        }

        return sb.toString();
    }

    private static void findAndAddMatchingOccurence(String str, String substring, int index, List<List<Integer>> occurrences) {
        for(int i = 0; i < substring.length(); i++) {
            if(index + i >= str.length() || str.charAt(index + i) != substring.charAt(i)) {
                return;
            }
        }
        occurrences.add(Arrays.asList(index, index + substring.length()));
    }

    public static void main(String[] args) {
        String result = UnderscorifySubstring.underscorifySubstring("testthis is a testtest to see if testestest it works", "test");
        System.out.println(result);
    }

}
