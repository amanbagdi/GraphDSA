package org.tree.algos.binarytree.questions;

import org.tree.algos.binarytree.BuildTreePreOrder;
import org.tree.algos.binarytree.util.Node;

public class CountOfNodes {

    public static int countNodes(Node root) {
        if (root == null) return 0;

        int countLeftNodes = countNodes(root.left);
        int countRightNodes = countNodes(root.right);

        return countLeftNodes + countRightNodes + 1;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Node root = BuildTreePreOrder.buildTree(nodes);

        int count = countNodes(root);
        System.out.println("Total Nodes = " + count);
    }

}
