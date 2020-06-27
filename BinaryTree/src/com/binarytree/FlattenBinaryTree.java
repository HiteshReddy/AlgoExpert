package com.binarytree;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree {

    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        BinaryTree[] nodes = flatten(root);
        return nodes[0];
    }


    private static BinaryTree[] flatten(BinaryTree node) {
        BinaryTree left = null;
        BinaryTree right = null;

        if(node.left == null) {
            left = node;
        } else {
            BinaryTree[] leftAndRight = flatten(node.left);
            leftAndRight[1].right = node;
            node.left = leftAndRight[1];
            left = leftAndRight[0];
        }

        if(node.right == null) {
            right = node;
        } else {
            BinaryTree[] leftAndRight = flatten(node.right);
            leftAndRight[0].left = node;
            node.right = leftAndRight[0];
            right = leftAndRight[1];
        }
        return new BinaryTree[]{left, right};
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

    public static void main(String[] args) {
        BinaryTree b7 = new BinaryTree(7);
        BinaryTree b8 = new BinaryTree(8);
        BinaryTree b5 = new BinaryTree(5);
        b5.left = b7;
        b5.right = b8;

        BinaryTree b4 = new BinaryTree(4);
        BinaryTree b2 = new BinaryTree(2);
        b2.left = b4;
        b2.right = b5;

        BinaryTree b3 = new BinaryTree(3);
        BinaryTree b6 = new BinaryTree(6);
        b3.left = b6;

        BinaryTree b1 = new BinaryTree(1);
        b1.left = b2;
        b1.right = b3;

        BinaryTree result = flattenBinaryTree(b1);
        while(result != null) {
            System.out.println(result.left != null ? result.left.value : -1);
            System.out.println("current:" + result.value);
            System.out.println(result.right != null ? result.right.value : -1);
            result = result.right;
            System.out.println("=================");
        }
    }

}
