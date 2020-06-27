package com.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BranchSums {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public void addBranches(BinaryTree left, BinaryTree right) {
            this.left = left;
            this.right = right;
        }
    }


//    private static List<Integer> branchSums(BinaryTree root) {
//        if(root == null)
//            return new ArrayList<>();
//        List<Integer> leftBranch = branchSums(root.left)
//                .stream()
//                .map(i -> i + root.value)
//                .collect(Collectors.toList());
//        List<Integer> rightBranch = branchSums(root.right)
//                .stream()
//                .map(i -> i + root.value)
//                .collect(Collectors.toList());
//        List<Integer> allSums = new ArrayList<>();
//        allSums.addAll(leftBranch);
//        allSums.addAll(rightBranch);
//        if(allSums.isEmpty())
//            allSums.add(root.value);
//        return allSums;
//    }

    private static List<Integer> branchSums(BinaryTree root) {
        List<Integer> allSums = new ArrayList<>();
        addSums(root, 0, allSums);
        return allSums;
    }

    private static void addSums(BinaryTree node, int prevSum, List<Integer> sums) {
        if(node == null)
            return;

        int currentSum = prevSum + node.value;
        if(node.left == null && node.right == null) {
            sums.add(currentSum);
        }

        addSums(node.left, currentSum, sums);
        addSums(node.right, currentSum, sums);
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

        List<Integer> result = BranchSums.branchSums(b1);
        result.forEach(i -> System.out.println(i));

    }

}
