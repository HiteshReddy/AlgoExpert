package com.graphs;

import java.util.ArrayList;
import java.util.List;

public class SalesPath {

    static class Node {
        int cost;
        List<Node> children = new ArrayList<Node>();
        Node parent;

        Node(int cost) {
            this.cost = cost;
            parent = null;
        }

        public Node addChild(int cost) {
            Node child = new Node(cost);
            children.add(child);
            return this;
        }
    }

    static int getCheapestCost(Node rootNode) {
        int currentCost = rootNode.cost;
        List<Node> myChild = rootNode.children;
        if(myChild.size() == 0)
            return currentCost;
        int currentMin = Integer.MAX_VALUE;
        for(Node node : myChild) {
            currentMin = Math.min(currentMin, getCheapestCost(node));
        }
        return currentCost + currentMin;
    }

    public static void main(String[] args) {
        SalesPath.Node n1 = new SalesPath.Node(0);
        n1.addChild(5).addChild(3).addChild(6);
        n1.children.get(0).addChild(4);
        n1.children.get(1).addChild(2).addChild(0);
        n1.children.get(1).children.get(0).addChild(1);
        n1.children.get(1).children.get(0).children.get(0).addChild(1);
        n1.children.get(1).children.get(1).addChild(10);
        n1.children.get(2).addChild(1).addChild(5);
        int minCost = SalesPath.getCheapestCost(n1);
        System.out.println(minCost);
    }

}
