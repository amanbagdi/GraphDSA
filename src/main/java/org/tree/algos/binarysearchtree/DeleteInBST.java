package org.tree.algos.binarysearchtree;

import org.tree.algos.binarytree.util.Node;

public class DeleteInBST {

    public static Node deleteNode(Node root, int value) {
        if (root == null) return null;

        if (value < root.data) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.data) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            } else {
                Node node = inOrderSuccessor(root.right);
                node.left = root.left;
                return node;
            }
        }
        return root;
    }

    public static Node inOrderSuccessor(Node root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        return inOrderSuccessor(root.left);
    }

    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = BuildBST.buildBST(null, values);

        System.out.println("Nodes before deletion");
        BuildBST.inOrder(root);

        root = deleteNode(root, 5);

        System.out.println();
        System.out.println("Nodes after deletion");
        BuildBST.inOrder(root);

    }

}
