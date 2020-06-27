package com.stack;

import java.util.Stack;

public class BalancedBrackets {

    public static boolean balancedBrackets(String str) {
        char[] ch = str.toCharArray();
        Stack<String> stack = new Stack<>();
        for(String s: str.split("")) {
            if(s.equals("(") || s.equals("{") || s.equals("[")) {
                stack.push(s);
            } else {
                if(!stack.isEmpty()) {
                    return false;
                }
                String last = stack.pop();
                if(s.equals(")") && !last.equals("(")) {
                    return false;
                } else if(s.equals("}") && !last.equals("{")) {
                    return false;
                } else if(s.equals("]") && !last.equals("[")) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
