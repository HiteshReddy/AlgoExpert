package com.graphs;

import java.util.*;

public class BreadthFirstSearch {

    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Deque<Node> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                array.add(node.name);
                queue.addAll(node.children);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch.Node n1 = new BreadthFirstSearch.Node("A");
        n1.addChild("B").addChild("C");
        n1.children.get(0).addChild("D").addChild("E");
        n1.children.get(1).addChild("F").addChild("G");
        List<String> result = n1.breadthFirstSearch(new ArrayList<>());

        Optional.ofNullable(result).ifPresent((l) -> l.forEach(s -> System.out.println(s)));
    }

}
