package org.tree.algos.binarysearchtree;

import org.tree.algos.binarytree.util.Node;

public class SearchInBST {

    //Average Time Complexity = O(Height) = O(log n)
    //Worst Time Complexity = O(n)
    public static boolean searchNode(Node root, int val) {
        if (root == null) return false;

        if (val == root.data) return true;
        else if (val < root.data) {
            return searchNode(root.left, val);
        } else {
            return searchNode(root.right, val);
        }
    }

    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = BuildBST.buildBST(null, values);

        boolean isPresent = searchNode(root, 3);
        if (isPresent) System.out.println("Node Found!");
        else System.out.println("Node Not Found!");
    }

}
