package com.string;

import java.util.HashMap;
import java.util.Map;

public class PatternMatcher {

    public static String[] patternMatcher(String pattern, String str) {
        // get the count of x and y matchers

        // start from 1 as the x matcher length and calculate the y length
        // create the string with the assumed lengths and match with the original one
        // if match return the string else follow step-2 again

        char[] matchers = pattern.toCharArray();
        boolean hasMatchersChanged = false;
        if(matchers[0] == 'y') {
            hasMatchersChanged = true;
            for(int i = 0; i < matchers.length; i++) {
                if(matchers[i] == 'x')
                    matchers[i] = 'y';
                else {
                    matchers[i] = 'x';
                }
            }
        }
        int yStartIdx = 0;
        for(char aChar : matchers) {
            if(aChar == 'y')
                break;
            yStartIdx++;
        }
        // get the count matching x and y
        Map<Character, Integer> matcherCount = getCountOfMatchers(matchers);
        if(matcherCount.get('y') == null) {
            int yCount = matcherCount.get('x');
            String s = str.substring(0, str.length()/yCount);
            return (hasMatchersChanged) ? new String[]{"", s} : new String[]{s, ""};
        }

        for(int i = 1; i <  str.length(); i++) {
            String xStr = str.substring(0, i);
            int yLength = (str.length() - matcherCount.get('x')*i) / matcherCount.get('y');
            if(yLength < 0 || yLength % 1 != 0)
                continue;
            String yStr = str.substring(i*yStartIdx, (i*yStartIdx)+yLength);
            StringBuilder sb = new StringBuilder();
            for(char aChar : matchers) {
                if(aChar == 'x')
                    sb.append(xStr);
                else
                    sb.append(yStr);
            }
            String strBasedOnI = sb.toString();
            if(str.equals(strBasedOnI))
                return (hasMatchersChanged) ? new String[]{yStr, xStr} : new String[]{xStr, yStr};
        }
        return new String[]{};
    }

    private static Map<Character, Integer> getCountOfMatchers(char[] chars) {
        Map<Character, Integer> matchers = new HashMap<>();
        for (char aChar : chars) {
            matchers.merge(aChar, 1, Integer::sum);
        }
        return matchers;
    }

    public static void main(String[] args) {
        String[] result = PatternMatcher.patternMatcher("yyyy", "testtesttesttest");
        for (String s : result) {
            System.out.println(s);
        }
    }

}
