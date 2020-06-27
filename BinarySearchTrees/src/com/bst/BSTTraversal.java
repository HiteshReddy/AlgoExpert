package com.bst;

import java.util.ArrayList;
import java.util.List;
import static com.bst.BinarySearchTree.BST;

public class BSTTraversal {

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if(tree == null)
            return null;
        inOrderTraverse(tree.left, array);
        array.add(tree.value);
        inOrderTraverse(tree.right, array);
        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if(tree == null)
            return null;
        array.add(tree.value);
        preOrderTraverse(tree.left, array);
        preOrderTraverse(tree.right, array);
        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if(tree == null)
            return null;
        postOrderTraverse(tree.left, array);
        postOrderTraverse(tree.right, array);
        array.add(tree.value);
        return array;
    }

    public static void main(String[] args) {
        BinarySearchTree.BST tree = new BinarySearchTree.BST(10);
        tree.insert(5).insert(15).insert(5).insert(2).insert(1).insert(22);
        List<Integer> result = BSTTraversal.preOrderTraverse(tree, new ArrayList<>());
        result.stream().forEach(elem -> System.out.println(elem));
    }

}
