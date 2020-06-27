package com.bst;

import static com.bst.BinarySearchTree.BST;

public class FindClosestValueInBST {

    public static int findClosestValueInBst(BST tree, int target) {
        int closestValue = -1;
        int minDiff = Integer.MAX_VALUE;
        while(tree != null) {
            int currDiff = Math.abs(tree.value-target);
            if(currDiff < minDiff) {
                closestValue = tree.value;
                minDiff = currDiff;
            }
            if(target < tree.value) {
                tree = tree.left;
            } else if(target > tree.value) {
                tree = tree.right;
            } else {
                return tree.value;
            }
        }
        return closestValue;
    }

}
