package org.tree.algos.binarysearchtree.questions;

import org.tree.algos.binarysearchtree.BuildBST;
import org.tree.algos.binarytree.util.Node;

public class PrintInRange {

    public static void printInRange(Node root, int x, int y) {
        if (root == null) return;

        if (y < root.data) {
            printInRange(root.left, x, y);
        } else if (x > root.data) {
            printInRange(root.right, x, y);
        } else if (root.data >= x && root.data <= y) {
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        }

    }

    public static void main(String[] args) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = BuildBST.buildBST(null, values);

        printInRange(root, 6, 10);
    }
}
