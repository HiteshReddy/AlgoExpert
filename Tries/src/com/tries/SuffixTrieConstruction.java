package com.tries;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieConstruction {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for(int i = 0; i < str.length(); i++) {
                constructTrieFromIdx(i, str);
            }
        }

        private void constructTrieFromIdx(int i, String str) {
            TrieNode currNode = root;
            for(int j = i; j < str.length(); j++) {
                char currChar = str.charAt(j);
                Map<Character, TrieNode> children = currNode.children;
                if(!children.containsKey(currChar)) {
                    children.put(currChar, new TrieNode());
                }
                currNode = children.get(currChar);
            }
            currNode.children.put(endSymbol, null);
        }

        public boolean contains(String str) {
            TrieNode currNode = root;
            for(int i = 0; i < str.length(); i++) {
                char currChar = str.charAt(i);
                if(!currNode.children.containsKey(currChar)) {
                    return false;
                }
                currNode = currNode.children.get(currChar);
            }
            return currNode.children.containsKey(endSymbol);
        }
    }

    public static void main(String[] args) {
        SuffixTrieConstruction.SuffixTrie node = new SuffixTrieConstruction.SuffixTrie("this is a big string");
        boolean result = node.contains("this");
        System.out.println(result);
    }

}