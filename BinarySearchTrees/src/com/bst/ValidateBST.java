package com.bst;

import static com.bst.BinarySearchTree.BST;

public class ValidateBST {
    public static boolean validateBst(BST tree) {
        return isValid(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValid(BST tree, Integer minValue, Integer maxValue) {
        if (tree == null) {
            return true;
        }
        if (tree.value >= minValue && tree.value < maxValue
                && isValid(tree.left, minValue, tree.value)
                && isValid(tree.right, tree.value, maxValue)) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree.BST tree = new BinarySearchTree.BST(10);
        tree.insert(5).insert(15).insert(5).insert(2).insert(1).insert(22).insert(13).insert(14);
        boolean result = ValidateBST.validateBst(tree);
        System.out.println(result);
    }
}
