package org.tree.algos.binarytree.questions;

import org.tree.algos.binarytree.BuildTreePreOrder;
import org.tree.algos.binarytree.util.Node;

public class HeightOfTree {

    public static int heightOfTree(Node root) {
        if (root == null) return 0;

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Node root = BuildTreePreOrder.buildTree(nodes);

        int height = heightOfTree(root);
        System.out.println("Height of Tree = " + height);
    }
}
