package com.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeapthFirstSearch {

    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }


        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            for(Node child : this.children) {
                child.depthFirstSearch(array);
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
        Node n1 = new Node("A");
        n1.addChild("B").addChild("C");
        n1.children.get(0).addChild("D").addChild("E");
        n1.children.get(1).addChild("F").addChild("G");
        List<String> result = n1.depthFirstSearch(new ArrayList<>());

        Optional.ofNullable(result).ifPresent((l) -> l.forEach(s -> System.out.println(s)));
    }

}
