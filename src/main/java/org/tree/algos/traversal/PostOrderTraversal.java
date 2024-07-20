package org.tree.algos.traversal;

import org.tree.algos.BuildTreePreOrder;
import org.tree.algos.util.Node;

public class PostOrderTraversal {

    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Node root = BuildTreePreOrder.buildTree(nodes);

        postOrder(root);
    }

}
