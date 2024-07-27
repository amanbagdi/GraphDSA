package org.tree.algos.binarysearchtree;

import org.tree.algos.binarytree.util.Node;

public class BuildBST {

    public static Node buildBST(Node root, int[] values) {
        for (int val: values) {
            root = insertNode(root, val);
        }
        return root;
    }

    public static Node insertNode(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.data) {
            root.left = insertNode(root.left, val);
        } else {
            root.right = insertNode(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = buildBST(null, values);
        inOrder(root);
    }

}
