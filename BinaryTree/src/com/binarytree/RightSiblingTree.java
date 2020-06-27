package com.binarytree;

public class RightSiblingTree {

    public static BinaryTree rightSiblingTree(BinaryTree root) {
        createSiblingTree(root, null, false);
        return root;
    }

    private static void createSiblingTree(BinaryTree node, BinaryTree parent, boolean isLeftNode) {
        if(node == null) return;
        BinaryTree left = node.left;
        BinaryTree right = node.right;
        createSiblingTree(left, node, true);
        if(parent == null) {
            node.right = null;
        }
        else if(isLeftNode) {
            node.right = parent.right;
        }
        else {
            if(parent.right == null) {
                right.right = null;
            } else {
                right.right = parent.right.left;
            }
        }
        createSiblingTree(right, node, false);
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
