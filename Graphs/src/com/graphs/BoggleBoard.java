package com.graphs;

import java.util.*;

public class BoggleBoard {

    public static List<String> boggleBoard(char[][] board, String[] words) {
        Trie trie = new Trie();
        Arrays.stream(words).forEach(str -> trie.insert(str));
        Set<String> match = new HashSet<>();
        boolean[][] traversed = new boolean[board.length][board[0].length];
        Arrays.stream(traversed).forEach(arr -> Arrays.fill(arr, false));
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                findIfMatching(i, j, board, traversed, match, trie.root);
            }
        }
        return new ArrayList(match);
    }

    private static void findIfMatching(int i, int j, char[][] board, boolean[][] traversed, Set<String> match, TrieNode node) {
        if(traversed[i][j]) return;
        char ch = board[i][j];
        if(!node.children.containsKey(ch)) return;
        traversed[i][j] = true;
        node = node.children.get(ch);
        if(node.children.containsKey('*')) {
            match.add(node.children.get('*').endString);
        }
        List<Integer[]> allNeighbours = getAllNeighbours(i, j, board);
        for(Integer[] neighbour : allNeighbours) {
            findIfMatching(neighbour[0], neighbour[1], board, traversed, match, node);
        }
        traversed[i][j] = false;
    }

    private static List<Integer[]> getAllNeighbours(int i, int j, char[][] board) {
        List<Integer[]> neighbours = new ArrayList<>();
        int iMax = board.length - 1;
        int jMax = board[0].length - 1;
        if(i > 0 && j < jMax) {
            neighbours.add(new Integer[]{i-1, j+1});
        }
        if(j < jMax) {
            neighbours.add(new Integer[]{i, j+1});
        }
        if(i < iMax && j < jMax) {
            neighbours.add(new Integer[]{i+1, j+1});
        }
        if(i < iMax) {
            neighbours.add(new Integer[]{i+1, j});
        }
        if(i < iMax && j > 0) {
            neighbours.add(new Integer[]{i+1, j-1});
        }
        if(j > 0) {
            neighbours.add(new Integer[]{i, j-1});
        }
        if(i > 0 && j > 0) {
            neighbours.add(new Integer[]{i-1, j-1});
        }
        if(i > 0) {
            neighbours.add(new Integer[]{i-1, j});
        }
        return neighbours;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String endString;

        public TrieNode(){}
        public TrieNode(String endString) { this.endString = endString; }
    }

    static class Trie {
        TrieNode root = new TrieNode();
        char endString = '*';

        public void insert(String str) {
            TrieNode currNode = root;
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(!currNode.children.containsKey(ch)) {
                    currNode.children.put(ch, new TrieNode());
                }
                currNode = currNode.children.get(ch);
            }
            currNode.children.put(endString, new TrieNode(str));
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'y', 'g', 'f', 'y', 'e', 'i'},
                {'c', 'o', 'r', 'p', 'o', 'u'},
                {'j', 'u', 'z', 's', 'e', 'l'},
                {'s', 'y', 'u', 'r', 'h', 'p'},
                {'e', 'a', 'e', 'g', 'n', 'd'},
                {'h', 'e', 'l', 's', 'a', 't'},
        };
        String[] words = {
                "san",
                "sana",
                "at",
                "vomit",
                "yours",
                "help",
                "end",
                "been",
                "bed",
                "danger",
                "calm",
                "ok",
                "chaos",
                "complete",
                "rear",
                "going",
                "storm",
                "face",
                "epual",
                "dangerous"
        };
        List<String> result = boggleBoard(board, words);
        System.out.println(result);
    }
}
