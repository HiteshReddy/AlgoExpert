package com.binarytree;

import com.binarytree.BranchSums.BinaryTree;

import java.util.List;

public class InvertedTree {

    public static void invertBinaryTree(BinaryTree tree) {
        if(tree == null)
            return;

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
        BinaryTree left = tree.left;
        tree.left = tree.right;
        tree.right = left;
    }

    public static void main(String[] args) {
        BinaryTree b1 = new BinaryTree(1);
        BinaryTree b2 = new BinaryTree(2);
        BinaryTree b3 = new BinaryTree(3);
        BinaryTree b4 = new BinaryTree(4);
        BinaryTree b5 = new BinaryTree(5);
        BinaryTree b6 = new BinaryTree(6);
        BinaryTree b7 = new BinaryTree(7);
        BinaryTree b8 = new BinaryTree(8);
        BinaryTree b9 = new BinaryTree(9);
        BinaryTree b10 = new BinaryTree(10);

        b1.addBranches(b2, b3);
        b2.addBranches(b4, b5);
        b4.addBranches(b8, b9);
        b5.addBranches(b10, null);
        b3.addBranches(b6, b7);

        InvertedTree.invertBinaryTree(b1);
    }

}
