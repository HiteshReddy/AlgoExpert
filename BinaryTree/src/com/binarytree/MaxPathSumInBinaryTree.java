package com.binarytree;

public class MaxPathSumInBinaryTree {

    public static int maxPathSum(BinaryTree tree) {
        return maxSum(tree).v2;
    }

    private static Tuple maxSum(BinaryTree tree) {
        if(tree == null) {
            return new Tuple(0, 0);
        }
        Tuple leftBranchMaxSum = maxSum(tree.left);
        Tuple rightBranchMaxSum = maxSum(tree.right);
        int maxSumBranch = Math.max(leftBranchMaxSum.v1, rightBranchMaxSum.v1);
        int maxSumBranchWithRoot = Math.max(maxSumBranch + tree.value, tree.value);

        int sumBranchWithRoot = Math.max(maxSumBranchWithRoot, leftBranchMaxSum.v1 + tree.value + rightBranchMaxSum.v1);
        int maxSum = Math.max(Math.max(leftBranchMaxSum.v2, rightBranchMaxSum.v2), sumBranchWithRoot);
        return new Tuple(maxSumBranchWithRoot, maxSum);
    }

    static class Tuple {
        int v1;
        int v2;

        public Tuple(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
