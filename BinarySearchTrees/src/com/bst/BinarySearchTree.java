package com.bst;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            int min = Integer.MIN_VALUE;
            BST currentNode = this;
            while(true) {
                if(value < currentNode.value) {
                    if(currentNode.left == null) {
                        currentNode.left = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if(currentNode.right == null) {
                        currentNode.right = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
            return this;
        }

        public boolean contains(int value) {
            BST currentNode = this;
            while(currentNode != null) {
                if(currentNode.value == value) {
                    return true;
                } else if(value < currentNode.value) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }
            return false;
        }

        public BST remove(int value) {
            remove(value, this);
            return this;
        }


        public void remove(int value, BST parentNode) {
            BST currentNode = this;
            while(currentNode != null) {
                if(value < currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else if(value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    if(currentNode.left != null && currentNode.right != null) {
                        currentNode.value = currentNode.right.getMinValue();
                        currentNode.right.remove(currentNode.value, currentNode);
                    }
                    else if(parentNode == null) {
                        if(currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        } else if(currentNode.right != null) {
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        } else {
                            currentNode = null;
                        }
                    } else if(parentNode.left == currentNode) {
                        if(currentNode.left == null) {
                            parentNode.left = currentNode.right;
                        } else {
                            parentNode.left = currentNode.left;
                        }
                    } else if(parentNode.right == currentNode){
                        if(currentNode.right == null) {
                            parentNode.right = currentNode.left;
                        } else {
                            parentNode.right = currentNode.right;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        private int getMinValue() {
            BST currentNode = this;
            while (currentNode.left != null) {
                currentNode = currentNode.left;
            }
            return currentNode.value;
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
                .insert(1).remove(15).remove(22);

        List<Integer> result = BSTTraversal.inOrderTraverse(tree, new ArrayList<>());
        result.forEach(elem -> System.out.println(elem));
    }
}
