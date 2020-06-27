package com.binarytree;

import java.util.function.Function;

public class IterativeInOrderTraversal {

    public static void iterativeInOrderTraversal(
            BinaryTree tree, Function<BinaryTree, Void> callback) {
        BinaryTree currentNode = tree;
        BinaryTree previousNode = null;
        BinaryTree nextNode = null;
        while(currentNode != null) {
            if(previousNode == null || previousNode == currentNode.parent) {
                if(currentNode.left != null) {
                    nextNode = currentNode.left;
                } else {
                    callback.apply(currentNode);
                    nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
                }
            } else if(currentNode.left == previousNode) {
                callback.apply(currentNode);
                nextNode = (currentNode.right != null) ? currentNode.right : currentNode.parent;
            } else {
                nextNode = currentNode.parent;
            }
            previousNode = currentNode;
            currentNode = nextNode;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }

}
