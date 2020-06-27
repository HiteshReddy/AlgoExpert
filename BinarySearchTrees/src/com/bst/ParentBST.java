package com.bst;

import java.util.Objects;

import static com.bst.BinarySearchTree.BST;

public class ParentBST {

    public static BST findParentBST(BST tree, int value) {
        return findParentBST(tree, value, null);
    }

    public static BST findParentBST(BST tree, int value, BST parent) {
        if(tree == null) {
            return null;
        }
        if(tree.value == value) {
            return parent;
        } else if(value < tree.value){
            return findParentBST(tree.left, value, tree);
        } else {
            return findParentBST(tree.right, value, tree);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST(10);
        tree.insert(5)
                .insert(15)
                .insert(22)
                .insert(17)
                .insert(34)
                .insert(7)
                .insert(2)
                .insert(5)
                .insert(1);
        BST result = ParentBST.findParentBST(tree, 8);
        System.out.println(Objects.isNull(result) ? null : result.value);
    }

}
