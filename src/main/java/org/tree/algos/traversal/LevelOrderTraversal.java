package org.tree.algos.traversal;

import org.tree.algos.BuildTreePreOrder;
import org.tree.algos.util.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            if (node == null) {
                System.out.println();
                if (queue.isEmpty()) break;
                queue.add(null);
                continue;
            }
            System.out.print(node.data + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Node root = BuildTreePreOrder.buildTree(nodes);

        levelOrder(root);
    }

}
