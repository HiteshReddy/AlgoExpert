package com.tries;

import java.util.*;
import java.util.stream.Collectors;

public class MultiStringSearch {

//    static class TrieNode {
//        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
//    }
//
//    static class SuffixTrie {
//        TrieNode root = new TrieNode();
//        char endSymbol = '*';
//
//        public SuffixTrie(String str) {
//            populateSuffixTrieFrom(str);
//        }
//
//        public void populateSuffixTrieFrom(String str) {
//            for(int i = 0; i < str.length(); i++) {
//                constructTrieFromIdx(i, str);
//            }
//        }
//
//        private void constructTrieFromIdx(int i, String str) {
//            TrieNode currNode = root;
//            for(int j = i; j < str.length(); j++) {
//                char currChar = str.charAt(j);
//                Map<Character, TrieNode> children = currNode.children;
//                if(!children.containsKey(currChar)) {
//                    children.put(currChar, new TrieNode());
//                }
//                currNode = children.get(currChar);
//            }
//            currNode.children.put(endSymbol, null);
//        }
//
//        public boolean contains(String str) {
//            TrieNode currNode = root;
//            for(int i = 0; i < str.length(); i++) {
//                char currChar = str.charAt(i);
//                if(!currNode.children.containsKey(currChar)) {
//                    return false;
//                }
//                currNode = currNode.children.get(currChar);
//            }
//            return true;
//        }
//    }

    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        Trie trie = new Trie();
        Arrays.stream(smallStrings).forEach(str -> trie.insert(str));
        Map<String, Boolean> match = new HashMap<>();
        for(int i = 0; i < bigString.length(); i++) {
            searchStringAtIdx(i, bigString, trie, match);
        }
        return Arrays.stream(smallStrings).map(str -> match.containsKey(str)).collect(Collectors.toList());
    }

    private static void searchStringAtIdx(int idx, String bigString, Trie trie, Map<String, Boolean> match) {
        TrieNode node = trie.root;
        for(int i = idx; i < bigString.length(); i++) {
            char ch = bigString.charAt(i);
            if(!node.children.containsKey(ch)) {
                break;
            }
            node = node.children.get(ch);
            if(node.children.containsKey(trie.end)) {
                match.put(node.children.get(trie.end).endWord, true);
            }
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        String endWord;
        public TrieNode(String endWord) {
            this.endWord = endWord;
        }
    }

    static class Trie {
        TrieNode root = new TrieNode(null);
        Character end = '*';

        public void insert(String str) {
            TrieNode currNode = root;
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(!currNode.children.containsKey(ch)) {
                    currNode.children.put(ch, new TrieNode(null));
                }
                currNode = currNode.children.get(ch);
            }
            currNode.children.put(end, new TrieNode(str));
        }

    }

    public static void main(String[] args) {
        List<Boolean> result = multiStringSearch("3141592653589793238462643383279", new String[]{"3", "314", "49", "9001", "15926535897", "14", "9323", "8462643383279", "4", "793"});
        System.out.println(result);
    }

}
