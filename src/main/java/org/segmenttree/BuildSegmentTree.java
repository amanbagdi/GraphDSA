package org.segmenttree;

public class BuildSegmentTree {

    public static void buildTree(int i, int l, int r, int[] arr, int[] segmentTree) {
        if (l == r) {
            segmentTree[i] = arr[l];
            return;
        }
        int mid = l + (r-l)/2;

        buildTree(2*i+1, l, mid, arr, segmentTree);
        buildTree(2*i+2, mid+1, r, arr, segmentTree);

        segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2];
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8};
        int[] segmentTree = new int[arr.length*4];

        buildTree(0, 0, arr.length-1, arr, segmentTree);
        for (int n: segmentTree) {
            if (n!=0)
                System.out.print(n + " ");
        }
    }

}
