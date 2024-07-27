package org.tree.algos.binarysearchtree.questions;

import org.tree.algos.binarysearchtree.BuildBST;
import org.tree.algos.binarytree.util.Node;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {

    public static void printRootToLeafPaths(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(list);
        }
        printRootToLeafPaths(root.left, list);
        printRootToLeafPaths(root.right, list);
        list.remove(list.size() - 1);
    }

    public static void printPath(List<Integer> list) {
        for (Integer i: list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = BuildBST.buildBST(null, values);

        printRootToLeafPaths(root, new ArrayList<>());
    }

}
