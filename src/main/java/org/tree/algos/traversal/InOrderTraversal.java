package org.tree.algos.traversal;

import org.tree.algos.BuildTreePreOrder;
import org.tree.algos.util.Node;

public class InOrderTraversal {

    public static void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
     }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Node root = BuildTreePreOrder.buildTree(nodes);

        inOrder(root);
    }

}
