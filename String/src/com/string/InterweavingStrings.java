package com.string;

import java.util.ArrayList;
import java.util.List;

public class InterweavingStrings {

    static class Cache {
        boolean value;
        private Cache(boolean value) {
            this.value = value;
        }
    }

    public static boolean interweavingStrings(String one, String two, String three) {
        if(one.length() + two.length() != three.length()) return false;
        List<List<Cache>> cache = new ArrayList<>();
        for(int i = 0; i <= one.length(); i++) {
            cache.add(new ArrayList<Cache>());
            for(int j = 0; j <= two.length(); j++) {
                cache.get(i).add(null);
            }
        }
        return interweavingStrings(one, two, three, 0, 0, cache);
    }

    private static boolean interweavingStrings(String one, String two, String three, int i, int j, List<List<Cache>> cache) {
        if(cache.get(i) != null && cache.get(i).get(j) != null)
            return cache.get(i).get(j).value;
        int k = i + j;
        if(k == three.length()) return true;
        if(i < one.length() && one.charAt(i) == three.charAt(k)) {
            boolean val = interweavingStrings(one, two, three, i+1, j, cache);
            cache.get(i).set(j, new Cache(val));
            if(val) return val;
        }
        if(j < two.length() && two.charAt(j) == three.charAt(k)) {
            boolean val = interweavingStrings(one, two, three, i, j+1, cache);
            cache.get(i).set(j, new Cache(val));
            return val;
        }
        cache.get(i).set(j, new Cache(false));
        return false;
    }

    public static void main(String[] args) {
        boolean result = interweavingStrings("aa", "aab", "aabaa");
        System.out.println(result);
    }

}
