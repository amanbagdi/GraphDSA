package org.tree.algos.questions;

import org.tree.algos.BuildTreePreOrder;
import org.tree.algos.util.Node;

public class DiameterOfTree {

    //Time Complexity = O(N^2)
    public static int diameterOfTree(Node root) {
        if (root == null) return 0;

        int diamLeft = diameterOfTree(root.left);
        int diamRight = diameterOfTree(root.right);
        int diamThroughRoot = HeightOfTree.heightOfTree(root.left) + HeightOfTree.heightOfTree(root.right) + 1;

        int maxDiameter = Math.max(diamThroughRoot, Math.max(diamLeft, diamRight));
        return maxDiameter;
    }

    //Time Complexity = O(N)
    public static TreeInfo diameterOfTreeOptimized(Node root) {
        if (root == null) return new TreeInfo(0, 0);

        TreeInfo left = diameterOfTreeOptimized(root.left);
        TreeInfo right = diameterOfTreeOptimized(root.right);
        int myHeight = Math.max(left.ht, right.ht) + 1;

        int myDiameter = Math.max(left.ht + right.ht + 1, Math.max(left.diam, right.diam));

        TreeInfo treeInfo = new TreeInfo(myHeight, myDiameter);
        return treeInfo;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Node root = BuildTreePreOrder.buildTree(nodes);

        int diameter = diameterOfTree(root);
        System.out.println("Diameter of Tree = " + diameter);

        TreeInfo diameterOptimized = diameterOfTreeOptimized(root);
        System.out.println("Diameter of Tree = " + diameterOptimized.diam);
    }

    public static class TreeInfo {
        int ht;
        int diam;

        public TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }
}
