package com.graphs;

public class YoungestCommonAncestor {

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int descendantOneDepth = calculateDepth(topAncestor, descendantOne);
        int descendantTwoDepth = calculateDepth(topAncestor, descendantTwo);
        if(descendantOneDepth > descendantTwoDepth) {
            return calculateAncestor(descendantTwo, descendantOne, descendantOneDepth-descendantTwoDepth);
        } else {
            return calculateAncestor(descendantTwo, descendantOne, descendantTwoDepth-descendantOneDepth);
        }
    }

    private static int calculateDepth(AncestralTree topAncestor, AncestralTree descendent) {
        int depth = 0;
        while(descendent.name != topAncestor.name) {
            depth++;
            descendent = descendent.ancestor;
        }
        return depth;
    }

    private static AncestralTree calculateAncestor(AncestralTree descendantOne, AncestralTree descendantTwo, int diff) {
        while(diff > 0) {
            descendantTwo = descendantTwo.ancestor;
            diff--;
        }
        if(descendantOne.name == descendantTwo.name) {
            return descendantOne;
        } else {
            while (descendantOne.name != descendantTwo.name) {
                descendantOne = descendantOne.ancestor;
                descendantTwo = descendantTwo.ancestor;
            }
            return descendantOne;
        }
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

}